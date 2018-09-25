package abc.sound;
import static org.junit.Assert.*;
import org.junit.Test;

public class MusicTest {
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    //Testing strategy
    //Note
    //  - pitch
    //  - duration
    //  - transpose
    //      - up a semitone
    //      - down a semitone
    //  - equals
    //      - same note
    //      - different note
    //      - same note, different transpose
    //  - hashCode
    //      - same note
    //      - same note different transpose
    //  - toString
    //Concat
    //  - first
    //      - returns the first argument passed to Concat
    //  - second
    //      - returns the second argument passed to Concat
    //  - duration
    //      - two musics that are the same length
    //      - two musics are different lengths
    //  - transpose
    //      - up a semitone
    //      - down a semitone
    //  - toString
    //  - equals
    //      - same note
    //      - different note
    //      - same note, different transpose
    //      - (m1 + m2) + (m3 + m4) == ((m1 + m2) + m3) + m4
    //  - hashCode
    //      - same note
    //      - same note different transpose
    //      - different
    //Rest
    //  - duration
    //  - transpose
    //      does nothing
    //  - toString
    //  - equals
    //      two rests same duration
    //      two rests different durations
    //  - hashCode
    //      same value for equals rests
    //      different values for unequal rests
    //Together
    //  - duration
    //      two notes of the same duration
    //      two notes of different durations
    //  - transpose
    //      affects both notes in the together
    //  - toString
    //      two notes
    //      a note and a rest
    //  - equals
    //      true for two togethers that are the same
    //      true for two togethers that have the same notes but in opposite order
    //      false for different togethers
    //  - hashCode
    //      same value for equals togethers
    //      same value for true for two togethers that have the same notes but in opposite order
    //      different values for unequal togethers
    
    //Note
    //  - pitch
    //  - duration
    //  - transpose
    //      - up a semitone
    //      - down a semitone
    //  - equals
    //      - same note
    //      - different note
    //      - same note, different transpose
    //  - hashCode
    //      - same note
    //  - toString
    @Test
    // that the pitch method for a note returns the correct pitch
    public void testNotePitch() {
        Pitch pitch1 = new Pitch('C');
        Note note = new Note(0.25, pitch1);
        Pitch pitch2 = note.pitch();
        assertEquals(pitch1, pitch2);
    }
    
    @Test
    // that the duration method for a note returns the correct duration
    public void testNoteDuration() {
        double duration = 0.25;
        Pitch pitch1 = new Pitch('C');
        Note note = new Note(0.25, pitch1);
        assertTrue(duration == note.duration());
    }
    
    @Test
    // note.transpose(1) produces the correct pitch
    public void testNoteTransposeUpASemitone()
    {
        Note note = new Note(0.5, new Pitch('A'));
        note = (Note)note.transpose(1);
        assertTrue(note.pitch().toMidiNote() == 70);
    }
    
    @Test
    // note.transpose(-11) produces the correct pitch
    public void testNoteTransposeDownASemitone()
    {
        Note note = new Note(0.5, new Pitch('A'));
        note = (Note)note.transpose(-1);
        assertTrue(note.pitch().toMidiNote() == 68);
    }
    
    @Test
    // equals is true for the same note
    public void testNoteEqualsSame() {
        Pitch pitch1 = new Pitch('C');
        Note note1 = new Note(0.25, pitch1);
        Pitch pitch2 = new Pitch('C');
        Note note2 = new Note(0.25, pitch2);
        assertTrue(note1.equals(note2));
    }
    
    @Test
    // equals is false for different notes
    public void testNoteEqualsDifferent() {
        Pitch pitch1 = new Pitch('C');
        Note note1 = new Note(0.25, pitch1);
        Pitch pitch2 = new Pitch('D');
        Note note2 = new Note(0.25, pitch2);
        assertFalse(note1.equals(note2));
    }
    
    @Test
    // equals is false for the same note with different transpose
    public void testNoteEqualsSameDifferentTranspose() {
        Pitch pitch1 = new Pitch('C');
        Note note1 = new Note(0.25, pitch1);
        Pitch pitch2 = new Pitch('C');
        Music note2 = new Note(0.25, pitch2);
        note2 = note2.transpose(1);
        assertFalse(note1.equals(note2));
    }
    
    @Test
    // hashCode returns the same integer for the same note
    public void testNoteHashCodeSame() {
        Pitch pitch1 = new Pitch('C');
        Note note1 = new Note(0.25, pitch1);
        Pitch pitch2 = new Pitch('C');
        Note note2 = new Note(0.25, pitch2);
        assertTrue(note1.hashCode() == note2.hashCode());
    }
    
    @Test
    // hashCode returns the same integer for the same note
    public void testNoteHashCodeSameDifferentTranspose() {
        Pitch pitch1 = new Pitch('C');
        Note note1 = new Note(0.25, pitch1);
        Pitch pitch2 = new Pitch('C');
        Note note2 = new Note(0.25, pitch2);
        note2.transpose(1);
        assertTrue(note1.hashCode() == note2.hashCode());
    }
    
    @Test
    // toString returns the correct string for a given note
    public void testNoteToString() {
        Pitch pitch1 = new Pitch('C');
        Note note1 = new Note(0.25, pitch1);
        String string = "C0.25";
        assertEquals(string, note1.toString());
    }
    
    //Concat
    //  - first
    //      - returns the first argument passed to Concat
    //  - second
    //      - returns the second argument passed to Concat
    //  - duration
    //      - two musics are the same length
    //      - two musics are different lengths
    //  - transpose
    //      - up a semitone
    //      - down a semitone
    //  - toString
    //  - equals
    //      - same Concat
    //      - different Concat
    //          - switch first and second musics
    //          - totally different Concats
    //      - same Concat, different transpose
    //  - hashCode
    //      - same Concat
    //      - same Concat different transpose
    //      - different
    
    @Test
    // returns the first music passed into the Concat
    public void testConcatFirst() {
        Pitch pitch1 = new Pitch('C');
        Pitch pitch2 = new Pitch('D');
        Music note1 = new Note(0.25, pitch1);
        Music note2 = new Note(0.25, pitch2);
        Concat concat = new Concat(note1, note2);
        assertEquals(note1, concat.first());
    }
    
    @Test
    // returns the second music passed into the Concat
    public void testConcatSecond() {
        Pitch pitch1 = new Pitch('C');
        Pitch pitch2 = new Pitch('D');
        Music note1 = new Note(0.25, pitch1);
        Music note2 = new Note(0.25, pitch2);
        Concat concat = new Concat(note1, note2);
        assertEquals(note2, concat.second());
    }
    
    @Test
    // the duration for two musics that are the same length concatenated together
    public void testConcatDurationSame() {
        Pitch pitch1 = new Pitch('C');
        Pitch pitch2 = new Pitch('D');
        Music note1 = new Note(0.25, pitch1);
        Music note2 = new Note(0.25, pitch2);
        Concat concat = new Concat(note1, note2);
        assertTrue(0.5 == concat.duration());
    }
    
    @Test
    // the duration for two musics that are different lengths concatenated together
    public void testConcatDurationDifferent() {
        Pitch pitch1 = new Pitch('C');
        Pitch pitch2 = new Pitch('D');
        Music note1 = new Note(0.5, pitch1);
        Music note2 = new Note(0.25, pitch2);
        Concat concat = new Concat(note1, note2);
        assertTrue(0.75 == concat.duration());
    }

    @Test
    // concat.transpose(1) returns the correct value for each note
    public void testConcatTransposeUpASemitone()
    {
        Music note1 = new Note(0.5, new Pitch('C'));
        Music note2 = new Note(0.5, new Pitch('D'));
        Concat concat = new Concat(note1, note2);
        concat = (Concat)concat.transpose(1);
        
        Music note3 = new Note(0.5, new Pitch('C').transpose(1));
        Music note4 = new Note(0.5, new Pitch('D').transpose(1));
        assertTrue(concat.first().equals(note3));
        assertTrue(concat.second().equals(note4));
    }
    
    @Test
    // concat.transpose(-1) returns the correct value for each note
    public void testConcatTransposeDownASemitone()
    {
        Music note1 = new Note(0.5, new Pitch('C'));
        Music note2 = new Note(0.5, new Pitch('D'));
        Concat concat = new Concat(note1, note2);
        concat = (Concat)concat.transpose(-1);
        
        Music note3 = new Note(0.5, new Pitch('C').transpose(-1));
        Music note4 = new Note(0.5, new Pitch('D').transpose(-1));
        assertTrue(concat.first().equals(note3));
        assertTrue(concat.second().equals(note4));
    }
    
    @Test
    // concat.toString() returns the proper string
    public void testConcatToString() {
        Pitch pitch1 = new Pitch('C');
        Pitch pitch2 = new Pitch('D');
        Music note1 = new Note(0.25, pitch1);
        Music note2 = new Note(0.25, pitch2);
        Concat concat = new Concat(note1, note2);
        assertEquals("C0.25 D0.25", concat.toString());
    }
    
    @Test
    // concat.equals() returns true for two of the same concats
    public void testConcatEqualsSame() {
        Pitch pitch1 = new Pitch('C');
        Pitch pitch2 = new Pitch('D');
        Music note1 = new Note(0.25, pitch1);
        Music note2 = new Note(0.25, pitch2);
        Concat concat1 = new Concat(note1, note2);
        Concat concat2 = new Concat(note1, note2);
        assertEquals(concat1, concat2);
    }
    
    @Test
    // concat.equals() returns false for the same concat flipped
    public void testConcatEqualsDifferentOpposite() {
        Pitch pitch1 = new Pitch('C');
        Pitch pitch2 = new Pitch('D');
        Music note1 = new Note(0.25, pitch1);
        Music note2 = new Note(0.25, pitch2);
        Concat concat1 = new Concat(note1, note2);
        Concat concat2 = new Concat(note2, note1);
        assertFalse(concat1.equals(concat2));
    }
    
    @Test
    // concat.equals() returns false for different concats
    public void testConcatEqualsDifferent() {
        Pitch pitch1 = new Pitch('C');
        Pitch pitch2 = new Pitch('D');
        Pitch pitch3 = new Pitch('E');
        Pitch pitch4 = new Pitch('F');
        Music note1 = new Note(0.25, pitch1);
        Music note2 = new Note(0.25, pitch2);
        Music note3 = new Note(0.25, pitch3);
        Music note4 = new Note(0.25, pitch4);
        Concat concat1 = new Concat(note1, note2);
        Concat concat2 = new Concat(note3, note4);
        assertFalse(concat1.equals(concat2));
    }
    
    @Test
    //concat.equals() returns true for the same notes concatted in different ways (but the same order)
    public void testConcatEqualsDifferentWays()
    {
        Music note1 = new Note(0.25, new Pitch('C'));
        Music note2 = new Note(0.25, new Pitch('D'));
        Music note3 = new Note(0.25, new Pitch('E'));
        Music note4 = new Note(0.25, new Pitch('F'));
        
        Concat concat1 = new Concat(new Concat(note1, note2), new Concat(note3, note4));
        Concat concat2 = new Concat(new Concat(new Concat(note1, note2), note3), note4);
        assertTrue(concat1.equals(concat2));
    }
    
    @Test
    // concat.hashCode() returns true for two of the same concats
    public void testConcatHashCodeSame() {
        Music note1 = new Note(0.25, new Pitch('A'));
        Music note2 = new Note(0.25, new Pitch('B'));
        Concat concat1 = new Concat(note1, note2);
        Concat concat2 = new Concat(note1, note2);
        assertTrue(concat1.hashCode() == concat2.hashCode());
    }
    
    @Test
    // concat.hashCode() returns false for the same concat flipped
    public void testConcatHashCodeDifferentOpposite()
    {
        Music note1 = new Note(0.25, new Pitch('C'));
        Music note2 = new Note(0.25, new Pitch('A'));
        Concat concat1 = new Concat(note1, note2);
        Concat concat2 = new Concat(note2, note1);
        assertFalse(concat1.hashCode() == concat2.hashCode());
    }
    
    @Test
    // concat.hashCode() returns false for two different concats
    public void testConcatHashCodeDifferent()
    {
        Music note1 = new Note(0.5, new Pitch('B'));
        Music note2 = new Note(0.5, new Pitch('A'));
        Music note3 = new Note(0.5, new Pitch('D'));
        Concat concat1 = new Concat(note1, note2);
        Concat concat2 = new Concat(note2, note3);
        assertFalse(concat1.hashCode() == concat2.hashCode());
    }
    
    //Rest
    //  - duration
    //  - transpose
    //      does nothing
    //  - toString
    //  - equals
    //      two rests same duration
    //      two rests different durations
    //  - hashCode
    //      same value for equals rests
    //      different values for unequal rests
    
    @Test
    //rest.duration() returns the proper duration for a rest
    public void testRestDuration()
    {
        double duration = 0.25;
        Rest rest = new Rest(0.25);
        assertTrue(duration == rest.duration());
    }
    
    @Test
    //rest.equals() returns true for two rests with the same duration
    public void testRestEqualsSameDuration()
    {
        Rest rest1 = new Rest(0.5);
        Rest rest2 = new Rest(0.5);
        assertTrue(rest1.equals(rest2));
    }
    
    @Test
    //rest.equals() returns false for two rests with different durations
    public void testRestEqualsDifferentDurations()
    {
        Rest rest1 = new Rest(0.25);
        Rest rest2 = new Rest(0.5);
        assertFalse(rest1.equals(rest2));
    }
    
    @Test
    //rest.toString() returns the proper string
    public void testRestToString()
    {
        Rest rest = new Rest(0.5);
        String restString = ".0.5";
        assertTrue(rest.toString().equals(restString));
    }
    
    @Test
    //rest.hashCode() returns the same hashCode for two rests with the same duration
    public void testRestHashCodeSameRest()
    {
        Rest rest1 = new Rest(0.5);
        Rest rest2 = new Rest(0.5);
        assertTrue(rest1.hashCode() == rest2.hashCode());
    }
    
    @Test
    //rest.hashCode() returns two different values for two rests with different durations
    public void testRestHashCodeDifferentRests()
    {
        Rest rest1 = new Rest(0.25);
        Rest rest2 = new Rest(0.5);
        assertFalse(rest2.hashCode() == rest1.hashCode());
    }
    
    @Test
    //rest.tranpose() does not effect the rest
    public void testRestTranspose()
    {
        Rest rest1 = new Rest(0.25);
        Rest rest2 = new Rest(0.25);
        assertTrue(rest1.equals(rest2));
        rest2 = (Rest)rest2.transpose(12);
        assertTrue(rest1.equals(rest2));
        
    }
    
    //Together
    //  - duration
    //      two notes of the same duration
    //      two notes of different durations
    //  - transpose
    //      affects both notes in the together
    //  - toString
    //      two notes
    //      a note and a rest
    //  - equals
    //      true for two togethers that are the same
    //      true for two togethers that have the same notes but in opposite order
    //      false for different togethers
    //  - hashCode
    //      same value for equals togethers
    //      same value for true for two togethers that have the same notes but in opposite order
    //      different values for unequal togethers
    
    @Test
    //together.duration() returns the proper value for two notes of the same duration
    public void testTogetherDurationSame()
    {
        Note note1 = new Note(0.25, new Pitch('C'));
        Note note2 = new Note(0.25, new Pitch('D'));
        Together together = new Together(note1, note2);
        assertTrue(together.duration() == 0.25);
    }
    
    @Test
    //together.duration() returns the proper value for two notes of different durations
    public void testTogetherDurationDifferent()
    {
        Note note1 = new Note(0.25, new Pitch('G'));
        Note note2 = new Note(0.5, new Pitch('A'));
        Together together = new Together(note1, note2);
        assertTrue(together.duration() == 0.5);
    }
    
    @Test
    //together.toString() returns the proper string for two notes
    public void testTogetherToStringNotes()
    {
        Note note1 = new Note(0.25, new Pitch('C'));
        Note note2 = new Note(0.25, new Pitch('D'));
        Together together = new Together(note1, note2);
        String togetherString = "together(C0.25 |||| D0.25)";
        assertTrue(together.toString().equals(togetherString));
    }
    
    @Test
    //together.toString() returns the proper string for a note and a rest
    public void testTogetherToStringNoteAndRest()
    {
        Note note = new Note(0.25, new Pitch('C'));
        Rest rest = new Rest(0.5);
        Together together = new Together(note, rest);
        String togetherString = "together(C0.25 |||| .0.5)";
        assertTrue(together.toString().equals(togetherString));
    }
    
    @Test
    //together.equals() returns true for two togethers that are the same
    public void testTogetherEqualsTrueOpposite()
    {
        Together together1 = new Together(new Note(0.25, new Pitch('A')), new Note(0.5, new Pitch('B')));
        Together together2 = new Together(new Note(0.5, new Pitch('B')), new Note(0.25, new Pitch('A')));
        assertTrue(together1.equals(together2));
    }
    
    @Test
    //together.equals() returns true for two togethers that are the same
    public void testTogetherEqualsTrue()
    {
        Together together1 = new Together(new Note(0.25, new Pitch('A')), new Note(0.5, new Pitch('B')));
        Together together2 = new Together(new Note(0.25, new Pitch('A')), new Note(0.5, new Pitch('B')));
        assertTrue(together2.equals(together1));
    }
    
    @Test
    //together.equals() returns false for two togethers that are different
    public void testTogetherEqualsFalse()
    {
        Together together1 = new Together(new Note(0.25, new Pitch('A')), new Note(0.5, new Pitch('B')));
        Together together2 = new Together(new Note(0.25, new Pitch('A')), new Note(0.5, new Pitch('C')));
        assertFalse(together2.equals(together1));
    }
    
    @Test
    //together.hashCode() returns the same value for two togethers that are the same
    public void testTogetherHashCodeSame()
    {
        Together together1 = new Together(new Note(0.25, new Pitch('A')), new Note(0.5, new Pitch('B')));
        Together together2 = new Together(new Note(0.25, new Pitch('A')), new Note(0.5, new Pitch('B')));
        assertTrue(together2.hashCode() == together1.hashCode());
    }
    
    @Test
    //together.hashCode() returns different values for two unequal togethers
    public void testTogetherHashCodeDifferent()
    {
        Together together1 = new Together(new Note(0.25, new Pitch('A')), new Note(0.5, new Pitch('B')));
        Together together2 = new Together(new Note(0.25, new Pitch('A')), new Note(0.5, new Pitch('C')));
        assertFalse(together2.hashCode() == together1.hashCode());
    }
    
    @Test
    //together.hashCode() returns the same value for a together and its flip
    public void testTogetherHashCodeSameFlipped()
    {
        Together together1 = new Together(new Note(0.25, new Pitch('A')), new Note(0.5, new Pitch('B')));
        Together together2 = new Together(new Note(0.5, new Pitch('B')), new Note(0.25, new Pitch('A')));
        assertTrue(together1.hashCode() == together2.hashCode());
    }
    
    @Test
    //together.transpose() affects both musics
    public void testTogetherTranspose()
    {
        Together together = new Together(new Note(0.5, new Pitch('B')), new Note(0.25, new Pitch('C')));
        together = (Together) together.transpose(12);
        Pitch pitch1 = new Pitch('B').transpose(12);
        Pitch pitch2 = new Pitch('C').transpose(12);
        Note start = (Note)together.top();
        Note end = (Note)together.bottom();
        assertTrue(start.pitch().equals(pitch1));
        assertTrue(end.pitch().equals(pitch2));
    }    
}
