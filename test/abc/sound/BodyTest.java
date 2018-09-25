package abc.sound;
import static org.junit.Assert.*;
import org.junit.Test;

public class BodyTest {
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    // Partitions & Testing Strategy
    //  - music
    //      - Note
    //          - with accidental
    //          - with octave
    //      - Rest
    //      - Together
    //          - same length
    //          - different length
    //      - Concat
    //          - Triplet
    //          - Duplet
    //          - Quadruplet
    //  - ticksPerBeat
    //  - toString
    //  - equals
    //      same music and ticksPerBeat
    //      different music and same ticksPerBeat
    //      same music and different ticksPerBeat
    //  - hashCode
    //      equal for two things that are equal
    //      different for different music and same ticksPerBeat
    //      different for same music and different ticksPerBeat
    
    //  - music
    //      - Note
    //          - with accidental
    //          - with octave
    //      - Rest
    //      - Together
    //          - same length
    //          - different length
    //      - Concat
    //          - Triplet
    //          - Duplet
    //          - Quadruplet
    @Test
    // body.music() with a note
    public void testBodyMusicNote()
    {
        Body body = new Body(new Note(0.25, new Pitch('A')),12);
        Music music = body.music();
        Music comparison = new Note(0.25, new Pitch('A'));
        assertTrue(music.equals(comparison));
    }
    
    @Test
    // body.music() with a note with an accidental
    public void testBodyMusicNoteWithAccidental()
    {
        Body body = new Body(new Note(0.25, new Pitch('A').transpose(1)),12);
        Music music = body.music();
        Music comparison = new Note(0.25, new Pitch('A').transpose(1));
        assertTrue(music.equals(comparison));
    }
    
    @Test
    // body.music() with a note transposed an octave
    public void testBodyMusicNoteWithOctave()
    {
        Body body = new Body(new Note(0.25, new Pitch('A').transpose(-12)),12);
        Music music = body.music();
        Music comparison = new Note(0.25, new Pitch('A').transpose(-12));
        assertTrue(music.equals(comparison));
    }
    
    @Test
    // body.music() with a rest
    public void testBodyMusicRest()
    {
        Body body = new Body(new Rest(0.25),12);
        Music music = body.music();
        Music comparison = new Rest(0.25);
        assertTrue(music.equals(comparison));
    }
    
    @Test
    //body.music() with a together of the same length
    public void testBodyMusicTogetherSameLength()
    {
        Music together = new Together(new Note(0.5, new Pitch('B')), new Note(0.5, new Pitch('C')));
        Body body = new Body(together, 12);
        Music music = body.music();
        assertTrue(music.equals(together));
    }
    
    @Test
    // body.music() with a together of different lengths
    public void testBodyMusicTogetherDifferentLengths()
    {
        Music together = new Together(new Note(0.25, new Pitch('A')), new Rest(0.5));
        Body body = new Body(together,12);
        Music music = body.music();
        assertTrue(music.equals(together));
    }
    
    @Test
    //body.music() with a concat representing a duplet
    public void testBodyMusicConcatDuplet()
    {
        Music duplet = new Concat(new Note(0.25, new Pitch('B')), new Note(0.5, new Pitch('C')));
        Body body = new Body(duplet,12);
        Music music = body.music();
        assertTrue(music.equals(duplet));
    }
    
    @Test
    //body.music() with a concat representing a triplet
    public void testBodyMusicConcatTriplet()
    {
        Music triplet = new Concat(new Concat(new Note(0.5, new Pitch('C')), new Note(0.25, new Pitch('D'))), new Note(0.25, new Pitch('A')));
        Body body = new Body(triplet, 12);
        Music music = body.music();
        assertTrue(music.equals(triplet));
    }
    
    @Test
    //body.music() with a concat representing a quadruplet
    public void testBodyMusicConcatQuadruplet()
    {
        Music quadruplet = new Concat(new Concat(new Note(0.5, new Pitch('C')), new Note(0.25, new Pitch('D'))), new Concat(new Note(0.25, new Pitch('A')), new Note(0.25, new Pitch('B'))));
        Body body = new Body(quadruplet, 12);
        Music music = body.music();
        assertTrue(music.equals(quadruplet));
    }
    
    //  - ticksPerBeat
    //  - toString
    
    @Test
    //body.ticksPerBeat returns what it's given for ticksPerBeat
    public void testBodyTicksPerBeat()
    {
        Music music = new Together(new Note(0.5, new Pitch('B')), new Note(0.5, new Pitch('C')));
        Body body = new Body(music,12);
        assertTrue(body.ticksPerBeat() == 12);
    }
    
    @Test
    //body.ticksPerBeat returns what it's given for ticksPerBeat
    public void testBodyToString()
    {
        Music music = new Together(new Note(0.5, new Pitch('B')), new Note(0.5, new Pitch('C')));
        Body body = new Body(music,12);
        String correct = music.toString() + " 12";
        assertTrue(body.toString().equals(correct));
    }
    
    //  - equals
    //      same music and ticksPerBeat
    //      different music and same ticksPerBeat
    //      same music and different ticksPerBeat
    
    @Test
    //body.equals() returns true for two equal things
    public void testBodyEqualsSame()
    {
        Music music1 = new Together(new Note(0.5, new Pitch('B')), new Note(0.5, new Pitch('C')));
        Music music2 = new Together(new Note(0.5, new Pitch('C')), new Note(0.5, new Pitch('B')));
        assertTrue(music1.equals(music2));
        Body body1 = new Body(music1, 12);
        Body body2 = new Body(music2, 12);
        assertTrue(body1.equals(body2));
    }
    
    @Test
    //body.equals() returns false for two different musics
    public void testBodyEqualsDifferentMusic()
    {
        Music music1 = new Together(new Note(0.5, new Pitch('B')), new Note(0.5, new Pitch('C')));
        Music music2 = new Note(0.5, new Pitch('B'));
        assertFalse(music1.equals(music2));
        Body body1 = new Body(music1, 12);
        Body body2 = new Body(music2, 12);
        assertFalse(body1.equals(body2));
    }
    
    @Test
    //body.equals() returns false for two different ticksPerBeat
    public void testBodyEqualsDifferentTicksPerBeat()
    {
        Music music = new Note(0.5, new Pitch('B'));
        Body body1 = new Body(music, 12);
        Body body2 = new Body(music, 24);
        assertFalse(body1.equals(body2));
    }
    
    //  - hashCode
    //      equal for two things that are equal
    //      different for different music and same ticksPerBeat
    //      different for same music and different ticksPerBeat
    
    @Test
    //body.hashCode() returns the same value for two equal things
    public void testBodyHashCodeEqualThings()
    {
        Music music1 = new Together(new Note(0.5, new Pitch('B')), new Note(0.5, new Pitch('C')));
        Music music2 = new Together(new Note(0.5, new Pitch('C')), new Note(0.5, new Pitch('B')));
        assertTrue(music1.equals(music2));
        Body body1 = new Body(music1, 12);
        Body body2 = new Body(music2, 12);
        assertTrue(body1.equals(body2));
        assertTrue(body1.hashCode() == body2.hashCode());
    }
    
    @Test
    //body.hashCode() returns different values for two musics that aren't equal
    public void testBodyHashCodeDifferentMusics()
    {
        Music music1 = new Together(new Note(0.5, new Pitch('B')), new Note(0.5, new Pitch('C')));
        Music music2 = new Note(0.25, new Pitch('A'));
        assertFalse(music1.equals(music2));
        Body body1 = new Body(music1, 12);
        Body body2 = new Body(music2, 12);
        assertFalse(body1.equals(body2));
        assertFalse(body1.hashCode() == body2.hashCode());
    }
    
    @Test
    //body.hashCode() returns different values for two ticksperBeat that aren't equal
    public void testBodyHashCodeDifferentTicksPerBeat()
    {
        Music music = new Note(0.75, new Pitch('C'));
        Body body1 = new Body(music, 12);
        Body body2 = new Body(music, 24);
        assertFalse(body1.equals(body2));
        assertFalse(body1.hashCode() == body2.hashCode());
    }
    
}
