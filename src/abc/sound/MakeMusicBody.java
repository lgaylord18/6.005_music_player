package abc.sound;
import java.util.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import abc.parser.BodyListener;
import abc.parser.BodyParser.BarlineContext;
import abc.parser.BodyParser.BodyContext;
import abc.parser.BodyParser.Body_lineContext;
import abc.parser.BodyParser.ChordContext;
import abc.parser.BodyParser.CommentContext;
import abc.parser.BodyParser.ElementContext;
import abc.parser.BodyParser.NoteContext;
import abc.parser.BodyParser.Note_elementContext;
import abc.parser.BodyParser.RepeatContext;
import abc.parser.BodyParser.RestContext;
import abc.parser.BodyParser.StringContext;
import abc.parser.BodyParser.TimeContext;
import abc.parser.BodyParser.TupletContext;
import abc.parser.BodyParser.VoiceContext;

/** Make a Music from a parse tree. */
public class MakeMusicBody implements BodyListener {
    
    private double length;
    private String key;
    private Set<String> voices = new HashSet<String>();
    private Map<String, Music> voicesWithMusic = new HashMap<String, Music>();
    private Map<String, Music> voicesRepeatSection = new HashMap<String, Music>();
    private Map<String, Boolean> voicesRepeat = new HashMap<String, Boolean>();
    private Map<String, Boolean> voicesFirstEnding = new HashMap<String, Boolean>();
    private Map<String, Boolean> voicesSecondEnding = new HashMap<String, Boolean>();
    private String currentVoice;
    private boolean inVoice = false;
    private Music music;
    private ArrayList<ArrayList<String>> accidental = new ArrayList<ArrayList<String>>();
    private boolean firstEnding = false;
    private boolean secondEnding = false;
    private Music repeatSection;
    private int largestMultiple3 = 1;
    private int largestMultiple2 = 1;
    private int meterDenominator;
    private double wholeNote;
    private double coefficient;
    
    public MakeMusicBody(Header header) {
      this.length = header.length();
      this.voices = header.voices();
      this.key = header.key();
      String meter = header.meter();
      this.meterDenominator = Integer.valueOf(meter.substring(meter.indexOf("/") + 1, meter.length()));
      this.wholeNote = this.length * this.meterDenominator;
      this.coefficient = (1/(double)meterDenominator)/length;
    }
    
    /**
     * This method returns the Body that the was created by the listener object.
     * Only executes if the entire listener was walked over a parse
     * true using the ParseTreeWalker
     * @return Body for the parse tree that was just walked through
     */
    public Body getBody() {
        int ticksPerBeat = (this.largestMultiple2 * this.largestMultiple3)*(int)coefficient;
        return new Body(music, ticksPerBeat); 
    }

    @Override public void enterBody(BodyContext context) { }
    @Override public void exitBody(BodyContext context) {
        if (!this.voicesWithMusic.isEmpty()){ // if there was stored music from voices
            Music voiceMusic = new Rest(1);
            for (String voice: this.voices) {
                // combine all of the voices so that they play together
                voiceMusic = new Together(voiceMusic, this.voicesWithMusic.get(voice));
            }
            if ((this.music != null) && (voiceMusic != null)) {
                this.music = new Concat(this.music, voiceMusic);
            } else if (voiceMusic != null) {
                this.music = voiceMusic;
            }
        }
    }

    @Override public void enterBody_line(Body_lineContext context) { }
    @Override public void exitBody_line(Body_lineContext context) {
        if (context.voice() != null) { // if it is a voice line
            // set up the fields for the current voice
            String voice = context.voice().string().getText();
            this.inVoice = true;
            this.currentVoice = voice;
            this.voices.add(voice);
            this.voicesFirstEnding.put(currentVoice, false);
            this.voicesSecondEnding.put(currentVoice, false);
        } else if (context.element() != null & !context.isEmpty()) { // if it is an element line
            if (!context.element().isEmpty()) { // if there is an element
                List<ElementContext> elementContexts = context.element();
                Music music = createMusic(elementContexts.get(0), null);
                // make music out of the list of elements on this line
                for (int i = 1; i < elementContexts.size(); i++) {
                    music = createMusic(elementContexts.get(i), music);
                }
                if (this.inVoice) { // if there is currently a voice for the element line
                    if (!this.voicesWithMusic.isEmpty()) { // if voices already has some music
                        if (this.voicesWithMusic.containsKey(this.currentVoice)) {
                            // if this specific voice already has some music
                            Music currentMusic = this.voicesWithMusic.get(this.currentVoice);
                            this.voicesWithMusic.replace(this.currentVoice, new Concat(currentMusic, music));
                        } else { // this specific voice does not already have some music
                            this.voicesWithMusic.put(currentVoice, music);
                        }
                    } else { // the voice does not already have some music
                        this.voicesWithMusic.put(currentVoice, music);
                    }
                    this.inVoice = false;
                } else { // there is not currently a voice for the element line
                    if (this.music != null) { // there is already some music
                        this.music = new Concat(this.music, music);
                    } else { // there is not already some music
                        this.music = music;
                    }
                }
            }
        }
    }

    @Override public void enterComment(CommentContext context) { }
    @Override public void exitComment(CommentContext context) { }

    @Override public void enterVoice(VoiceContext context) { }
    @Override public void exitVoice(VoiceContext context) { }

    @Override public void enterElement(ElementContext context) { }
    @Override public void exitElement(ElementContext context) { }
    
    /**
     * updateRepeats takes in an element, and adds it to the section of music to be repeated, 
     * depending on whether or not there currently is a voice.
     * @param element a musical element to be added to sections of music to be repeated
     */
    public void updateRepeats(Music element) {
        if (inVoice) { // there is a voice for this element
            if (!this.voicesFirstEnding.get(currentVoice) && !this.voicesSecondEnding.get(currentVoice)) {
                // if it is not in a first or second ending section
                if (this.voicesRepeatSection.containsKey(currentVoice)) {
                    // if there already is a section of music to be repeated for this voice
                    Music section = this.voicesRepeatSection.get(currentVoice);
                    Music concat = new Concat(section, element);
                    this.voicesRepeatSection.replace(currentVoice, concat);
                } else { // there is not a section of music to be repeated for this voice
                    this.voicesRepeatSection.put(currentVoice, element);
                    this.voicesRepeat.put(currentVoice, false);
                }
            }
        } else if (!this.firstEnding && !this.secondEnding){
            // there is not a voice for this element
            // it is not currently in a first or second ending
            if (this.repeatSection == null) {
                // if there is not already a section of music to be repeated
                this.repeatSection = element;
            } else {
                // there is already a section of music to be repeated
                this.repeatSection = new Concat(this.repeatSection, element);
            }
        }
    }
    
    /**
     * Creates a music from an element and a piece of music. Concats the element to the end
     * of the piece of music provided.
     * @param context and ElementContext that provides all of the information for the element
     * @param previousMusic a piece of music that the context will be added to the end of
     * @return a Music from the provided information
     */
    public Music createMusic(ElementContext context, Music previousMusic) {
        if (context.note_element() != null) { // if context is a note_element
            Note_elementContext noteElements = context.note_element();
            Music element;
            if (noteElements.note() != null) { // if context is a note
                NoteContext note = noteElements.note();
                element = createNote(note, Optional.empty());
            } else { // context is a chord
                ChordContext chord = noteElements.chord();
                element = createChord(chord, Optional.empty());
            }
            if (previousMusic == null) { // if there is no previousMusic provided
                previousMusic = element;
            } else { // there is previousMusic provided
                previousMusic = new Concat(previousMusic, element);
            }
            updateRepeats(element);
        } else if (context.rest() != null) {// if context is a rest
            RestContext rest = context.rest();
            Music element = createRest(rest);
            if (previousMusic == null) { // if there is no previousMusic provided
                previousMusic = element;
            } else { // there is previousMusic provided
                previousMusic = new Concat(previousMusic, element);
            }
            updateRepeats(element);
        } else if (context.tuplet() != null) {// if context is a tuplet
            TupletContext tuplet = context.tuplet();
            Music element = createTuplet(tuplet);
            if (previousMusic == null) { // if there is no previousMusic provided
                previousMusic = element;
            } else { // there is previousMusic provided
                previousMusic = new Concat(previousMusic, element);
            }
            updateRepeats(element);
        } else if (context.barline() != null) {// if context is a barline
            if (inVoice) { // there is a voice for this element
                if (this.voicesSecondEnding.get(currentVoice)) {
                    this.voicesSecondEnding.replace(currentVoice, false);
                    this.voicesRepeatSection.remove(currentVoice);
                }
            } else {// there is not a voice for this element
                this.secondEnding = false;
            }
            this.accidental = new ArrayList<ArrayList<String>>();
            String barline = context.barline().getText();
            if (barline.equals("|:")) { // if barline is the beginning of a repeat
                if (this.inVoice) {//there is a voice for this element
                    this.voicesRepeat.put(currentVoice, true);
                }
            } else if (barline.equals(":|")) {// barline is the end of a repeat
                if (this.inVoice) {// there is a voice for this element
                    this.voicesRepeat.put(currentVoice, false);
                    if (this.voicesWithMusic.containsKey(currentVoice)) {
                        // there is a repeat section for the current voice
                        Music concat = new Concat(this.voicesWithMusic.get(currentVoice), this.voicesRepeatSection.get(currentVoice));
                        this.voicesWithMusic.replace(currentVoice, concat);
                        this.voicesRepeatSection.remove(currentVoice);
                    }
                } else {// there is not a voice for this element
                    previousMusic = new Concat(previousMusic, this.repeatSection);
                }
            }
        } else if (context.repeat() != null) {// if context is a first or second ending
            String repeat = context.repeat().getText();
            if (repeat.equals("[1")) {// if repeat is a first ending
                if (this.inVoice) {// there is a voice for this element
                    this.voicesRepeat.put(currentVoice, false);
                }
                this.voicesFirstEnding.replace(currentVoice, true);
                this.firstEnding = true;
            } else {// repeat is a second ending
                this.voicesSecondEnding.replace(currentVoice, true);
                this.secondEnding = true;
            }
        }
        return previousMusic;
    }
    
    @Override public void enterNote_element(Note_elementContext context) { }
    @Override public void exitNote_element(Note_elementContext context) { }

    @Override public void enterNote(NoteContext context) { }
    @Override public void exitNote(NoteContext context) { }
    
    /**
     * Takes the information for a note as a NoteContext, parses it, and returns the note
     * with all of the information given.
     * @param context a NoteContext that gives the information for the note to be created
     * @param providedDuration only present if the note to be created is part of a tuplet
     * @return a Music representing the note with the provided information
     */
    public Music createNote(NoteContext context, Optional<Double> providedDuration) {
        int OCTAVE = 12;
        if (context.ACCIDENTAL() != null) {//the note directly has an accidental
            ArrayList<String> accidentalInfo = new ArrayList<String>();
            String note = context.NOTE_LETTERS().getText();
            String acc = context.ACCIDENTAL().getText();
            for (int i = 0; i < this.accidental.size(); i++) { 
                // all right to remove during loop because will only need one of the elements in loop
                ArrayList<String> previousAccidentals = this.accidental.get(i);
                if (previousAccidentals.get(0).equals(note)) {
                    this.accidental.remove(i);
                }
            }
            accidentalInfo.add(note);
            accidentalInfo.add(acc);
            this.accidental.add(accidentalInfo);
        }
        
        char oldNoteLetter = context.NOTE_LETTERS().getText().charAt(0);
        char newNoteLetter;
        if (Character.isLowerCase(oldNoteLetter)) {
            // keep track of higher octave notes
            newNoteLetter = Character.toUpperCase(oldNoteLetter);
        } else {
            newNoteLetter = oldNoteLetter;
        }
        Pitch pitch = new Pitch(newNoteLetter);
        
        if (Character.isLowerCase(oldNoteLetter)) {
            // adjust for higher octave notes
            pitch = pitch.transpose(OCTAVE);
        }
        
        if (context.OCTAVE() != null) {//the note directly has an octave adjustment
            String octave = context.OCTAVE().getText();
            int numSemitones = octave.length();
            if (octave.contains("'")) {
                pitch = pitch.transpose(numSemitones*OCTAVE);
            } else if (octave.contains(",")) {
                pitch = pitch.transpose(numSemitones*(-OCTAVE));
            }
        }
        
        changePitchForKey(newNoteLetter); //adjust the pitch to fit the key
        List<String> accidentalString = new ArrayList<>();
        for (ArrayList<String> accidentalInfo : this.accidental) {
            // check for accidentals on the note
            if (accidentalInfo.get(0).equals(String.valueOf(oldNoteLetter))) {
                accidentalString.add(accidentalInfo.get(1));
            }
        }
        if (!accidentalString.contains("=") && !accidentalString.isEmpty()) {
            //transpose according to the accidental on the note
            for (int i = 0; i < accidentalString.get(0).length(); i++) {
                if (accidentalString.get(0).charAt(i) == '^') { pitch = pitch.transpose(1); }
                else if (accidentalString.get(0).charAt(i) == '_') { pitch = pitch.transpose(-1); }
            }
        }
        
        double duration = this.wholeNote;
        if (providedDuration.isPresent()) {
            //only present if the note is part of a tuplet
            duration = providedDuration.get();
        } 
        if (context.time() != null) { // the note has fractional information about duration
            if (context.time().getText().contains("/")) {
                String stringDuration = context.time().getText();
                String slash = "/";
                if (stringDuration.endsWith(slash)) { stringDuration = stringDuration + "2";}
                if (stringDuration.startsWith(slash)) { stringDuration = "1" + stringDuration; }
                
                double durationTop = Double.valueOf(stringDuration.substring(0, stringDuration.indexOf("/")));
                double durationBottom = Double.valueOf(stringDuration.substring(stringDuration.indexOf("/") + 1, 
                        stringDuration.length()));
                if (durationBottom > this.largestMultiple2) {
                    this.largestMultiple2 = (int) durationBottom;
                }
                duration = (durationTop/durationBottom) * duration;
            }
        } else if (context.NUMBER() != null) { //note has whole number information about duration
            duration = (Double.valueOf(context.NUMBER().getText()))*duration;
        }
        
        Note note = new Note(duration, pitch);
        return note;
    }
    
    /**
     * Takes in a note that is being made by the parser and adds the
     * appropriate accidental to accidentalInfo to adjust for the key of the music
     * @param letter the base letter of the note being made
     */
    public void changePitchForKey(Character letter)
    {
        Character noteLetter = Character.toUpperCase(letter);
        switch(key)
        {
            case "C":
            case "Am":
                break;
                
            case "G" :
            case "Em" :
                if (noteLetter.equals('F'))
                {
                    ArrayList<String> accidentalInfo = new ArrayList<String>();
                    accidentalInfo.add(String.valueOf(letter));
                    accidentalInfo.add("#");
                    accidental.add(accidentalInfo);
                }
                break;
                
            case "D":
            case "Bm":
                if (noteLetter.equals('F') | noteLetter.equals('C'))
                {
                    ArrayList<String> accidentalInfo = new ArrayList<String>();
                    accidentalInfo.add(String.valueOf(letter));
                    accidentalInfo.add("#");
                    accidental.add(accidentalInfo);
                }
                break;
                
            case "A":
            case "F#m":
                if (noteLetter.equals('F') | noteLetter.equals('C') | noteLetter.equals('G'))
                { 
                    ArrayList<String> accidentalInfo = new ArrayList<String>();
                    accidentalInfo.add(String.valueOf(letter));
                    accidentalInfo.add("#");
                    accidental.add(accidentalInfo);
                }
                break;
            
            case "E":
            case "C#m":
                if (noteLetter.equals('F') | noteLetter.equals('C') | noteLetter.equals('G') | noteLetter.equals('D'))
                {
                    ArrayList<String> accidentalInfo = new ArrayList<String>();
                    accidentalInfo.add(String.valueOf(letter));
                    accidentalInfo.add("#");
                    accidental.add(accidentalInfo);
                }
                break;
                
            case "B":
            case "G#m":
            case "C_":
            case "A_m":
                if (noteLetter.equals('F') | noteLetter.equals('C') | noteLetter.equals('G') | noteLetter.equals('D') | noteLetter.equals('A'))
                {
                    ArrayList<String> accidentalInfo = new ArrayList<String>();
                    accidentalInfo.add(String.valueOf(letter));
                    accidentalInfo.add("#");
                    accidental.add(accidentalInfo);
                }
                break;
            
            case "F#":
            case "D#m":
            case "G_":
            case "E_m":
                if (noteLetter.equals('F') | noteLetter.equals('C') | noteLetter.equals('G') | noteLetter.equals('D') | noteLetter.equals('A') | noteLetter.equals('E'))
                {
                    ArrayList<String> accidentalInfo = new ArrayList<String>();
                    accidentalInfo.add(String.valueOf(letter));
                    accidentalInfo.add("#");
                    accidental.add(accidentalInfo);
                }
                break;
                
            case "C#":
            case "A#m":
            case "D_":
            case "B_m":
                if (noteLetter.equals('F') | noteLetter.equals('C') | noteLetter.equals('G') | noteLetter.equals('D') | noteLetter.equals('A') | noteLetter.equals('E') | noteLetter.equals('B'))
                {
                    ArrayList<String> accidentalInfo = new ArrayList<String>();
                    accidentalInfo.add(String.valueOf(letter));
                    accidentalInfo.add("#");
                    accidental.add(accidentalInfo);
                }
                break;
                                
            case "F":
            case "Dm":
                if (noteLetter.equals('B'))
                {
                    ArrayList<String> accidentalInfo = new ArrayList<String>();
                    accidentalInfo.add(String.valueOf(letter));
                    accidentalInfo.add("_");
                    accidental.add(accidentalInfo);
                }
                break;
                
            case "B_":
            case "Gm":
                if (noteLetter.equals('B') | noteLetter.equals('E'))
                {
                    ArrayList<String> accidentalInfo = new ArrayList<String>();
                    accidentalInfo.add(String.valueOf(letter));
                    accidentalInfo.add("_");
                    accidental.add(accidentalInfo);
                }
                break;
                
            case "E_":
            case "Cm":
                if (noteLetter.equals('B') | noteLetter.equals('E') | noteLetter.equals('A'))
                {
                    ArrayList<String> accidentalInfo = new ArrayList<String>();
                    accidentalInfo.add(String.valueOf(letter));
                    accidentalInfo.add("_");
                    accidental.add(accidentalInfo);
                }
                break;
                
             case "A_":
             case "Fm":
                 if (noteLetter.equals('B') | noteLetter.equals('E') | noteLetter.equals('A') | noteLetter.equals('D'))
                 {
                     ArrayList<String> accidentalInfo = new ArrayList<String>();
                     accidentalInfo.add(String.valueOf(letter));
                     accidentalInfo.add("_");
                     accidental.add(accidentalInfo);
                 }
                 break;
        }
    }

    @Override public void enterRest(RestContext context) { }
    @Override public void exitRest(RestContext context) { }
    
    /**
     * Creates a piece of music that is a rest from the information provided.
     * @param context a RestContext that provides the information for the rest to be created
     * @return a Music representing a rest with the provided information
     */
    public Music createRest(RestContext context) {
        double duration = this.wholeNote;
        if (context.time() != null) {// there is fraction information about duration
            String time = context.time().getText();
            String slash = "/";
            if (time.endsWith(slash)) { time = time + "2"; }
            if (time.startsWith(slash)) { time = "1" + time; }
            double durationTop = Double.valueOf(time.substring(0, time.indexOf("/")));
            double durationBottom = Double.valueOf(time.substring(time.indexOf("/") + 1, 
                    time.length()));
            if (durationBottom > this.largestMultiple2) {
                this.largestMultiple2 = (int) durationBottom;
            }
            duration = (durationTop/durationBottom)*duration;
        }
        else if (context.NUMBER() != null) //there is whole number information about duration
        {
            duration = (Double.valueOf(context.NUMBER().getText()))*duration;
        }
        else {
            duration = this.wholeNote;
        }
        
        Music rest = new Rest(duration);
        return rest;
    }

    @Override public void enterChord(ChordContext context) { }
    @Override public void exitChord(ChordContext context) { }
    
    /**
     * Creates a chord from the provided information.
     * @param context a NoteContext that gives the information for the chord to be created
     * @param providedDuration only present if the chord to be created is part of a tuplet
     * @return a Music representing a Chord wit the provided information
     */
    public Music createChord(ChordContext context, Optional<Double> providedDuration) {
        List<NoteContext> contextNote = context.note();
        List<Music> notes = new ArrayList<Music>();
        Optional<Double> duration;
        if (providedDuration.isPresent()) { // creating a tuplet
            duration = providedDuration;
        } else { // not creating a tuplet
            duration = Optional.empty();
        }
        for (NoteContext noteContext: contextNote) { 
            // create all of the notes in context
            Music note = createNote(noteContext, duration);
            notes.add(note);
        }
        
        Music previousNotes = notes.get(0);
        for (int i=1; i < notes.size(); i++) {
            // put all of the notes in context together
            previousNotes = new Together(previousNotes, notes.get(i));
        }
        return previousNotes;
    }

    @Override public void enterTuplet(TupletContext context) { }
    @Override public void exitTuplet(TupletContext context) { }
    
    /**
     * Creates either a duplet, triplet, or quadruplet based on the information provided in 
     * context.
     * @param context a NoteContext that gives the information for the tuplet to be created
     * @return a Music representing a tuplet with the provided information
     */
    public Music createTuplet(TupletContext context) {
        Character tupletNumber = context.TUPLET_START().getText().charAt(1);
        
        List<Note_elementContext> contextNote = context.note_element();
        List<Music> notesElements = new ArrayList<Music>();
        Optional<Double> lengthPerNote;
        if (tupletNumber.equals('2')) { // calculate duration for a duplet
            lengthPerNote = Optional.of((3.0/2.0)*this.wholeNote);
            int denominator = 2;
            if (denominator > this.largestMultiple2) {
                this.largestMultiple2 = denominator;
            }
        } else if (tupletNumber.equals('3')) { // calculate duration for a triplet
            lengthPerNote = Optional.of((2.0/3.0)*this.wholeNote);
            int denominator = 3;
            if (denominator > this.largestMultiple3) {
                this.largestMultiple3 = denominator;
            }
        } else { // calculate duration for a quadruplet
            lengthPerNote = Optional.of((3.0/4.0)*this.wholeNote);
            int denominator = 4;
            if (denominator > this.largestMultiple2) {
                this.largestMultiple2 = denominator;
            }
        }
        
        for (Note_elementContext noteElement : contextNote) {
            // create the tupletg
            if (noteElement.note() != null) {
                NoteContext note = noteElement.note();
                Music noteObject = createNote(note, lengthPerNote);
                notesElements.add(noteObject);
            } else if (noteElement.chord() != null) {
                ChordContext chord = noteElement.chord();
                Music chordObject = createChord(chord, lengthPerNote);
                notesElements.add(chordObject);
            }
        }
        
        Music previousNotes = notesElements.get(0);
        for (int i=1; i < notesElements.size(); i++) {
            previousNotes = new Concat(previousNotes, notesElements.get(i));
        }
        return previousNotes;
        
    }

    @Override public void enterBarline(BarlineContext context) { }
    @Override public void exitBarline(BarlineContext context) { }

    @Override public void enterRepeat(RepeatContext context) { }
    @Override public void exitRepeat(RepeatContext context) { }
    
    @Override public void enterString(StringContext ctx) { }
    @Override public void exitString(StringContext ctx) { }
    
    @Override public void enterEveryRule(ParserRuleContext context) { }

    @Override public void exitEveryRule(ParserRuleContext context) { }

    @Override public void visitErrorNode(ErrorNode node) { }

    @Override public void visitTerminal(TerminalNode node) { }

    @Override
    public void enterTime(TimeContext ctx) { }

    @Override
    public void exitTime(TimeContext ctx) { }
}
