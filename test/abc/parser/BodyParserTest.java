package abc.parser;

import static org.junit.Assert.*;
import java.util.*;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import org.junit.Test;
import abc.sound.Concat;
import abc.sound.Header;
import abc.sound.Music;
import abc.sound.Note;
import abc.sound.Pitch;
import abc.sound.Together;

/** Tests to make sure MakeMusicBody works correctly. */
public class BodyParserTest {
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    
    // Partitions & Testing Strategy
    //Note
    //  accidental
    //      double sharp
    //      sharp
    //      natural
    //      flat
    //      double flat
    //      overwrite other accidentals
    //  octave
    //      multiple octaves
    //  length (slash or no slash)
    //      just a slash - needs default values
    //      slash with numerator
    //      slash with denominator
    //      whole number
    //Rest
    //  length (slash or no slash)
    //      just a slash - needs default values
    //      slash with numerator
    //      slash with denominator
    //      whole number
    //  multiple rests in a row
    //Chord
    //  note with accidental
    //  note with octave
    //  note with multiplicative factor/different durations
    //Tuplet
    //  duplet
    //  triplet
    //  quadruplets
    //  chords inside
    //  notes + chords of different lengths
    //Repeat
    //  simple |: notes :|
    //  multiple bars
    //  omitted beginning
    //  different endings
    //      on same line
    //      on different lines
    //      omitted beginning
    //Voices
    //  one voice
    //  multiple voices
    //  with repeats
    //      different endings
    //      different endings on different lines
    //      omitted beginning
    
    //Note
    //  accidental
    //      double sharp
    //      sharp
    //      natural
    //      flat
    //      double flat
    //  octave
    //      multiple octaves
    //  length (slash or no slash)
    //      just a slash - needs default values
    //      slash with numerator
    //      slash with denominator
    //      whole number
    @Test
    //simple note
    public void testBodyParserNote() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music music = Music.parseBody("C", header).music();
        
        Pitch pitch = new Pitch('C');
        Note note = new Note(1, pitch);

        assertTrue(music.equals(note));
        assertTrue(music.duration() == 1.0);
    }
    
    @Test
    //note with a double sharp
    public void testBodyParserNoteDoubleSharp()
    {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Note parsed = (Note)Music.parseBody("^^A", header).music();
        Note equal = new Note(1./4, new Pitch('A').transpose(2));
        assertTrue(parsed.pitch().equals(equal.pitch()));
    }
    
    @Test
    //note with a single sharp
    public void testBodyParserNoteSharp()
    {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Note parsed = (Note)Music.parseBody("^A", header).music();
        Note equal = new Note(1./4, new Pitch('A').transpose(1));
        assertTrue(parsed.pitch().equals(equal.pitch()));
    }
    
    @Test
    //note with a natural
    public void testBodyParserNoteNatural() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:G");
        Note music = (Note) Music.parseBody("=F", header).music();
        Note note = new Note(1./4, new Pitch('F'));
        assertTrue(note.pitch().equals(music.pitch()));
    }
    
    @Test
    //note with a single flat
    public void testBodyParserNoteFlat()
    {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Note parsed = (Note)Music.parseBody("_A", header).music();
        Note equal = new Note(1./4, new Pitch('A').transpose(-1));
        assertTrue(parsed.pitch().equals(equal.pitch()));
    }
    
    @Test
    //note with a double flat
    public void testBodyParserNoteDoubleFlat()
    {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Note parsed = (Note)Music.parseBody("__A", header).music();
        Note equal = new Note(1./4, new Pitch('A').transpose(-2));
        assertTrue(parsed.pitch().equals(equal.pitch()));
    }
    
    @Test
    public void testBodyParserNoteAccidentalsReplaceEachOther()
    {
        Header header = Music.parseHeader("X:1\nT: Accidentals\nM:C\nK:C");
        Music accidentals = Music.parseBody("__A _A =A ^A ^^A|]", header).music();
        Note ASharpSharp = new Note(0.5, new Pitch('A').transpose(-2));
        Note ASharp = new Note(0.5, new Pitch('A').transpose(-1));
        Note A = new Note(0.5, new Pitch('A'));
        Note AFlat = new Note(0.5, new Pitch('A').transpose(1));
        Note AFlatFlat = new Note(0.5, new Pitch('A').transpose(2));
        List<Note> notes = new ArrayList<>(Arrays.asList(ASharpSharp, ASharp, A, AFlat, AFlatFlat));
        Concat equal = new Concat(notes.get(0), notes.get(1));
        for (int i = 2; i < notes.size(); i++)
        {
            equal = new Concat(equal,notes.get(i));
        }
        assertTrue(accidentals.equals(equal));
    }
    
    @Test
    //note with an octave change
    public void testBodyParserNoteOneOctave() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Note music = (Note)Music.parseBody("a", header).music();
        Pitch proper = new Pitch('A').transpose(12);
        assertTrue(music.pitch().equals(proper));
    }
    
    @Test
    //not with a multiple octave change
    public void testBodyParserNoteMultipleOctaves()
    {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Note music = (Note)Music.parseBody("A,,", header).music();
        Pitch proper = new Pitch('A').transpose(-24);
        assertTrue(music.pitch().equals(proper));
    }
    
    @Test
    //notes with all different lengths
    public void testBodyParserDurationsWithMissmatchedMeterAndLength() {
        Header header = Music.parseHeader("X:1\nT: Title\nL:1/4\nM:C|\nK:C");
        Note one = (Note)Music.parseBody("A4", header).music();
        Note two = (Note)Music.parseBody("B2", header).music();
        Note three = (Note)Music.parseBody("C", header).music();
        Note four = (Note)Music.parseBody("D/", header).music();
        Note five = (Note)Music.parseBody("E/4", header).music();
        Note six = (Note)Music.parseBody("F/8", header).music();
        
        
        assertTrue(one.duration() == 2.0);
        assertTrue(two.duration() == 1.0);
        assertTrue(three.duration() == 0.5);
        assertTrue(four.duration() == 0.25);
        assertTrue(five.duration() == 0.125);
        assertTrue(six.duration() == 0.0625);
    }
    
    @Test
    //note with octave change and time with slash (default values required)
    public void testBodyParserOptionalTime() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Note one = (Note)Music.parseBody("d'/", header).music();
        assertTrue(one.duration() == 1.0/2);
    }
    
    @Test
    //series of notes
    public void testBodyParserMyScale() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music scale = Music.parseBody("C D E F | G A B c | c B A G | F E D C |", header).music();
        assertTrue(scale.duration() == 16.0);
    }
    
    //Rest
    //  length (slash or no slash)
    //      just a slash - needs default values
    //      slash with numerator
    //      slash with denominator
    //      whole number
    //  multiple rests in a row
    @Test
    //parse simple rest
    public void testBodyParserRest() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music music = Music.parseBody("z", header).music();
        assertTrue(music.duration() == 1.0);
    }
    
    @Test
    //parse rest followed by slash
    public void testBodyParserRestDurationSlash()
    {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music music = Music.parseBody("z/", header).music();
        assertTrue(music.duration() == 0.5);
    }
    
    @Test
    //parse rest followed by slash
    public void testBodyParserRestDurationSlashNumerator()
    {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music music = Music.parseBody("z2/", header).music();
        assertTrue(music.duration() == 1.0);
    }
    
    @Test
    //parse rest followed by slash
    public void testBodyParserRestDurationSlashDenominator()
    {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music music = Music.parseBody("z/4", header).music();
        assertTrue(music.duration() == 0.25);
    }
    
    @Test
    //parse rest followed by slash
    public void testBodyParserRestDurationWholeNumber()
    {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music music = Music.parseBody("z2", header).music();
        assertTrue(music.duration() == 2.0);
    }
    
    @Test
    //multiple rests in a row
    public void testBodyParserRestMultipleInARow()
    {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music music = Music.parseBody("zz/", header).music();
        assertTrue(music.duration() == 1.5);
    }
    
    //Chord
    //  note with accidental
    //  note with octave
    //  note with multiplicative factor/different durations
    @Test
    public void testBodyParserChord() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music music = Music.parseBody("[CD]", header).music();
        
        Pitch pitch1 = new Pitch('C');
        Pitch pitch2 = new Pitch('D');
        Note noteC = new Note(1, pitch1);
        Note noteD = new Note(1, pitch2);
        Music chord = new Together(noteC, noteD);
        
        assertTrue(music.equals(chord));
        assertTrue(music.duration() == 1.0);
    }
    
    @Test
    //chord with accidentals inside
    public void testBodyParserChordWithAccidentals() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music music = Music.parseBody("[^C_D]", header).music();
        Pitch pitch1 = new Pitch('C').transpose(1);
        Pitch pitch2 = new Pitch('D').transpose(-1);
        Note noteC = new Note(1, pitch1);
        Note noteD = new Note(1, pitch2);
        Music chord = new Together(noteC, noteD);
        assertTrue(music.equals(chord));
    }
    
    @Test
    //chord with multiplicative factors inside/different durations
    public void testBodyParserChordWithDifferentDurations()
    {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music music = Music.parseBody("[C/D/4]", header).music();
        Pitch pitch1 = new Pitch('C');
        Pitch pitch2 = new Pitch('D');
        Note noteC = new Note(0.5, pitch1);
        Note noteD = new Note(0.25, pitch2);
        Music chord = new Together(noteC, noteD);
        assertTrue(music.equals(chord));
    }
    
    //Tuplet
    //  duplet
    //  triplet
    //  quadruplets
    //  chords inside
    //  notes + chords of different lengths
    @Test
    //simple duplet
    public void testBodyParserTupletDuplet() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music music = Music.parseBody("(2GD", header).music();
        
        Double noteLength = (3.0)/2.0;
        Pitch pitch1 = new Pitch('G');
        Pitch pitch2 = new Pitch('D');
        Note noteG = new Note(noteLength, pitch1);
        Note noteD = new Note(noteLength, pitch2);
        Music duplet = new Concat(noteG, noteD);
        
        assertTrue(music.equals(duplet));
        assertTrue(music.duration() == 3.0);
    }
    
    @Test
    //simple triplet
    public void testBodyParserTupletTriplet() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music music = Music.parseBody("(3GAB", header).music();
        
        Double noteLength = (2.0)/3.0;
        Pitch pitch1 = new Pitch('G');
        Pitch pitch2 = new Pitch('A');
        Pitch pitch3 = new Pitch('B');
        Music noteG = new Note(noteLength, pitch1);
        Music noteA = new Note(noteLength, pitch2);
        Music noteB = new Note(noteLength, pitch3);
        Music firstTwo = new Concat(noteG, noteA);
        Music triplet = new Concat(firstTwo, noteB);
        
        assertTrue(music.equals(triplet));
        assertTrue(music.duration() == 2.0);
    }
    
    @Test
    //simple quadruplet
    public void testBodyParserTupletQuadruplet() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music music = Music.parseBody("(4GABD", header).music();
        
        Double noteLength = (3.0)/4.0;
        Pitch pitch1 = new Pitch('G');
        Pitch pitch2 = new Pitch('A');
        Pitch pitch3 = new Pitch('B');
        Pitch pitch4 = new Pitch('D');
        Music noteG = new Note(noteLength, pitch1);
        Music noteA = new Note(noteLength, pitch2);
        Music noteB = new Note(noteLength, pitch3);
        Music noteD = new Note(noteLength, pitch4);
        
        Music firstTwo = new Concat(noteG, noteA);
        Music secondTwo = new Concat(noteB, noteD);
        Music quadruplet = new Concat(firstTwo, secondTwo);
        
        assertTrue(music.equals(quadruplet));
        assertTrue(music.duration() == 3.0);
    }
    
    @Test
    //triplet with chords + notes of different lengths
    public void testBodyParserTupletChords()
    {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music music = Music.parseBody("(4[G'A][BD]C'D/", header).music();
        
        Pitch pitch1 = new Pitch('G').transpose(12);
        Pitch pitch2 = new Pitch('A');
        Pitch pitch3 = new Pitch('B');
        Pitch pitch4 = new Pitch('D');
        Music first = new Together(new Note(0.75, pitch1), new Note(0.75, pitch2));
        Music second = new Together(new Note(0.75, pitch3), new Note(0.75, pitch4));
        Music third = new Note(0.75, new Pitch('C').transpose(12));
        Music fourth = new Note(0.75/2.0, new Pitch('D'));
        
        Music firstTwo = new Concat(first, second);
        Music secondTwo = new Concat(third, fourth);
        Music quadruplet = new Concat(firstTwo, secondTwo);
        assertTrue(quadruplet.equals(music));
    }
    
    @Test
    // triplet with half of default note length
    public void testBodyParseTupletHalf() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Music music = Music.parseBody("(3C/C/C/", header).music();
        Pitch pitch = new Pitch('C');
        Double noteLength = (2.0/3.0)/2.0;
        Music note = new Note(noteLength, pitch);
        Music firstTwo = new Concat(note, note);
        Music triplet = new Concat(firstTwo, note);
        assertTrue(music.equals(triplet));
        assertTrue(music.duration() == 1.0);
    }
    
    //Repeat
    //  simple |: notes :|
    //  multiple bars
    //  omitted beginning
    //  different endings
    //      on same line
    //      on different lines
    //      omitted beginning
    @Test
    //simple case
    public void testBodyParserRepeatSingleBar()
    {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Concat music = (Concat) Music.parseBody("|:CDAB:|", header).music();
        Note C = new Note(1.0, new Pitch('C'));
        Note D = new Note(1.0, new Pitch('D'));
        Note A = new Note(1.0, new Pitch('A'));
        Note B = new Note(1.0, new Pitch('B'));
        
        List<Note> notes = new ArrayList<>(Arrays.asList(C,D,A,B,C,D,A,B));
        Concat equal = new Concat(notes.get(0), notes.get(1));
        for (int i = 2; i < notes.size(); i++)
        {
            equal = new Concat(equal,notes.get(i));
        }
        assertTrue(music.equals(equal));
        
    }
    
    @Test
    //multiple bars
    public void testBodyParserRepeatMultipleBars() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Concat music = (Concat) Music.parseBody("|: C D E F | G A B c :|", header).music();
        
        Note C = new Note(1.0, new Pitch('C'));
        Note D = new Note(1.0, new Pitch('D'));
        Note E = new Note(1.0, new Pitch('E'));
        Note F = new Note(1.0, new Pitch('F'));
        Note G = new Note(1.0, new Pitch('G'));
        Note A = new Note(1.0, new Pitch('A'));
        Note B = new Note(1.0, new Pitch('B'));
        Note c = new Note(1.0, new Pitch('C').transpose(12));
        
        List<Note> notes = new ArrayList<>(Arrays.asList(C,D,E,F,G,A,B,c,C,D,E,F,G,A,B,c));
        Concat equal = new Concat(notes.get(0), notes.get(1));
        for (int i = 2; i < notes.size(); i++)
        {
            equal = new Concat(equal,notes.get(i));
        }
        assertTrue(music.equals(equal));
    }
    
    @Test
    //omitted beginning
    public void testBodyParserRepeatOmittedBeginning()
    {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Concat music = (Concat) Music.parseBody(" C D E F | G A B c :|", header).music();
        Note C = new Note(1.0, new Pitch('C'));
        Note D = new Note(1.0, new Pitch('D'));
        Note E = new Note(1.0, new Pitch('E'));
        Note F = new Note(1.0, new Pitch('F'));
        Note G = new Note(1.0, new Pitch('G'));
        Note A = new Note(1.0, new Pitch('A'));
        Note B = new Note(1.0, new Pitch('B'));
        Note c = new Note(1.0, new Pitch('C').transpose(12));
        
        List<Note> notes = new ArrayList<>(Arrays.asList(C,D,E,F,G,A,B,c,C,D,E,F,G,A,B,c));
        Concat equal = new Concat(notes.get(0), notes.get(1));
        for (int i = 2; i < notes.size(); i++)
        {
            equal = new Concat(equal,notes.get(i));
        }
        assertTrue(music.equals(equal));
    }
    
    @Test
    //different endings on same line
    public void testBodyParserRepeatsDifferentEndings() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Concat music = (Concat) Music.parseBody("|: C D E F |[1 G A B c | G A B B :|[2 F E D C |", header).music();
        
        Note C = new Note(1.0, new Pitch('C'));
        Note D = new Note(1.0, new Pitch('D'));
        Note E = new Note(1.0, new Pitch('E'));
        Note F = new Note(1.0, new Pitch('F'));
        Note G = new Note(1.0, new Pitch('G'));
        Note A = new Note(1.0, new Pitch('A'));
        Note B = new Note(1.0, new Pitch('B'));
        Note c = new Note(1.0, new Pitch('C').transpose(12));
        
        List<Note> notes = new ArrayList<>(Arrays.asList(C,D,E,F,G,A,B,c,G,A,B,B,C,D,E,F,F,E,D,C));
        Concat equal = new Concat(notes.get(0), notes.get(1));
        for (int i = 2; i < notes.size(); i++)
        {
            equal = new Concat(equal,notes.get(i));
        }
        assertTrue(music.equals(equal));
    }
    
    @Test
    //different endings on different lines
    public void testBodyParserRepeatsDifferentEndingsDifferentLines() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Concat music = (Concat) Music.parseBody("|: C D E F |[1 G A B c |\n G A B B :|[2 F E D C |", header).music();
        
        Note C = new Note(1.0, new Pitch('C'));
        Note D = new Note(1.0, new Pitch('D'));
        Note E = new Note(1.0, new Pitch('E'));
        Note F = new Note(1.0, new Pitch('F'));
        Note G = new Note(1.0, new Pitch('G'));
        Note A = new Note(1.0, new Pitch('A'));
        Note B = new Note(1.0, new Pitch('B'));
        Note c = new Note(1.0, new Pitch('C').transpose(12));
        
        List<Note> notes = new ArrayList<>(Arrays.asList(C,D,E,F,G,A,B,c,G,A,B,B,C,D,E,F,F,E,D,C));
        Concat equal = new Concat(notes.get(0), notes.get(1));
        for (int i = 2; i < notes.size(); i++)
        {
            equal = new Concat(equal,notes.get(i));
        }
        assertTrue(music.equals(equal));
    }
    
    @Test
    //different endings on same line, beginning omitted
    public void testBodyParserRepeatsDifferentEndingsWithOmittedBeginning() {
        Header header = Music.parseHeader("X: 1\nT: Title\nL:1/4\nQ:1/4=100\nK:C");
        Concat music = (Concat) Music.parseBody("C D E F |[1 G A B c | G A B B :|[2 F E D C |", header).music();
        
        Note C = new Note(1.0, new Pitch('C'));
        Note D = new Note(1.0, new Pitch('D'));
        Note E = new Note(1.0, new Pitch('E'));
        Note F = new Note(1.0, new Pitch('F'));
        Note G = new Note(1.0, new Pitch('G'));
        Note A = new Note(1.0, new Pitch('A'));
        Note B = new Note(1.0, new Pitch('B'));
        Note c = new Note(1.0, new Pitch('C').transpose(12));
        
        List<Note> notes = new ArrayList<>(Arrays.asList(C,D,E,F,G,A,B,c,G,A,B,B,C,D,E,F,F,E,D,C));
        Concat equal = new Concat(notes.get(0), notes.get(1));
        for (int i = 2; i < notes.size(); i++)
        {
            equal = new Concat(equal,notes.get(i));
        }
        assertTrue(music.equals(equal));
    }
    
    //Voices
    //  one voice
    //  multiple voices
    //  with repeats
    //      different endings
    //      different endings on different lines
    //      omitted beginning
    @Test
    //one voice
    public void testBodyParserVoicesOneVoice()
    {
        Header header = Music.parseHeader("X:1\nT: Title\nV:1\nL:1/16\nM:3/8\nQ:1/8=140\nK:Am");
        Music voices = Music.parseBody("V:1\ne^d|e^deB=dc|A2 z CEA|", header).music();
        assertTrue(voices.duration() == 7.0);
    }
    
    @Test
    //multiple voices
    public void testBodyParserVoicesMultipleVoices() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException
    {
        Header header = Music.parseHeader("X: 1\nT: fur else\nV:1\nV:2\nM:3/8\nL:1/16\nQ:1/8=140\nK:Am");
        Music music = Music.parseBody("V:1\ne^d|e^deB=dc|A2 z CEA|B2 z E^GB|c2 z Ee^d|\nV:2\nz2|z6|A,,E,A, z z2|E,,E,^G, z z2|A,,E,A, z z2|", header).music();
        assertTrue(music.duration() == 13.0);
    }
   
    @Test
    //with repeats - different endings + omitted beginning
    public void testBodyParserVoicesWithRepeatsAndDifferentEndings()
    {
        Header header = Music.parseHeader("X: 1\nT: fur else\nV:1\nV:2\nM:3/8\nL:1/16\nQ:1/8=140\nK:Am");
        Music music = Music.parseBody("V:1\ne^deB=dc|A2 z CEA|B2 z EcB|[1A2 z2:|[2A2z Bcd|\nV:2\nz6|A,,E,A, z z2|E,,E,^G, z z2|[1A,,E,A, z :|[2A,,E,A, z z2|", header).music();
        assertTrue(music.duration() == 14.0);
    }
    
    @Test
    //with repeats - different endings on different lines
    public void testBodyParserVoicesWithRepeatsDifferentEndingsDifferentLines()
    {
        Header header = Music.parseHeader("X: 1\nT: fur else\nV:1\nV:2\nM:3/8\nL:1/16\nQ:1/8=140\nK:Am");
        Music music = Music.parseBody("V:1\ne^deB=dc|A2 z CEA|B2 z EcB|[1A2 z Bcd:|\nV:2\nz6|A,,E,A, z z2|E,,E,^G, z z2|[1A,,E,A, z z2:|\nV:1\n[2A2 z [Ec][Fc][EGc]|c4 fe|e2d2 _ba|agfedc|\nV:2\n[2A,,E,A, [_B,C][A,C][G,B,C]|F,A,CA,CA,|F,_B,DB,DB,|F,E[F,G,_B,]E[F,G,B,]E|", header).music();
        assertTrue(music.duration() == 24.0);
    }
    
}
