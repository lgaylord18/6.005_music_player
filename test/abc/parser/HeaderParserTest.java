package abc.parser;

import org.junit.Test;

import abc.sound.Header;
import abc.sound.Music;

/** Tests to make sure MakeMusicHeader works correctly. */
public class HeaderParserTest {
    
    /*
     * Testing strategy:
     *   Index Number (X) 
     *      not tested because it's not relevant to this project
     *   Title (T)
     *      special cases: apostrophes, numbers, commas, periods in title
     *   Key (K)
     *      m there
     *      m not there
     *      #
     *      _
     *      just a letter
     *   Composer (C)
     *      there
     *      not there (composer is any readable string)
     *   Default Length (L) 
     *      there
     *      not there 
     *          meter >= .75
     *          meter < .75
     *   Meter (M)
     *      there 
     *          C
     *          C|
     *          fraction
     *      not (meter is 4/4)
     *   Tempo (Q)
     *      there
     *      not (tempo is 100)
     */
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testHeaderParserAllFields() {
        Header header = Music.parseHeader("X: 1\nT:Piece No.1\nM:C\nL:1/4\nQ:1/4=140\nC:arezu\nV:hi\nV:do\nK:C");
        assert(header.title().equals("Piece No.1"));
        assert(header.meter().equals("4/4"));
        assert(header.length() == 1.0/4);
        assert(header.tempo() == 140);
        assert(header.composer().equals("arezu"));
        assert(header.voices().size() > 0);
        assert(header.key().equals("C"));
    }
    
    @Test
    public void testHeaderParserNoMeter() {
        Header header = Music.parseHeader("X: 1\nT:Title\nL:1/4\nQ:1/4=140\nC:Arezu\nV:hi\nV:do\nK:A#m");
        assert(header.title().equals("Title"));
        assert(header.meter().equals("4/4"));
        assert(header.length() == 1.0/4);
        assert(header.tempo() == 140);
        assert(header.composer().equals("Arezu"));
        assert(header.voices().size() > 0);
        assert(header.key().equals("A#m"));
    }
    
    @Test
    public void testHeaderParserNoLengthHighMeter() {
        Header header = Music.parseHeader("X: 1\nT:Erin Burr, Sir\nM:C|\nQ:1/4=140\nC:arezu\nV:hi\nV:do\nK:F_");
        assert(header.title().equals("Erin Burr, Sir"));
        assert(header.meter().equals("2/2"));
        assert(header.length() == 1.0/8);
        assert(header.tempo() == 140);
        assert(header.composer().equals("arezu"));
        assert(header.voices().size() > 0);
        assert(header.key().equals("F_"));
    }
    
    @Test
    public void testHeaderParserNoLengthLowMeter() {
        Header header = Music.parseHeader("X: 1\nT:Jesse's Girl\nM:1/4\nQ:1/4=140\nC:arezu\nV:hi\nV:do\nK:C");
        assert(header.title().equals("Jesse's Girl"));
        assert(header.meter().equals("1/4"));
        assert(header.length() == 1.0/16);
        assert(header.tempo() == 140);
        assert(header.composer().equals("arezu"));
        assert(header.voices().size() > 0);
        assert(header.key().equals("C"));
    }
    
    @Test
    public void testHeaderParserNoLengthOrMeter() {
        Header header = Music.parseHeader("X: 1\nT:Piece No.1\nQ:1/4=140\nC:AREZU\nV:hi\nV:do\nK:C");
        assert(header.title().equals("Piece No.1"));
        assert(header.meter().equals("4/4"));
        assert(header.length() == 1.0/8);
        assert(header.tempo() == 140);
        assert(header.composer().equals("AREZU"));
        assert(header.voices().size() > 0);
        assert(header.key().equals("C"));
    }
    
    @Test
    public void testHeaderParserNoComposer() {
        Header header = Music.parseHeader("X: 1\nT:Piece No.1\nM:4/4\nL:1/4\nQ:1/4=140\nV:hi\nV:do\nK:G_m");
        assert(header.title().equals("Piece No.1"));
        assert(header.meter().equals("4/4"));
        assert(header.length() == 1.0/4);
        assert(header.tempo() == 140);
        assert(header.composer() != null); // any readable string is acceptable
        assert(header.voices().size() > 0);
        assert(header.key().equals("G_m"));
    }
    
    @Test
    public void testHeaderParserNoTempo() {
        Header header = Music.parseHeader("X: 1\nT:Piece No.1\nM:4/4\nL:1/4\nC:Liza H.W. Gaylord\nV:hi\nV:do\nK:C");
        assert(header.title().equals("Piece No.1"));
        assert(header.meter().equals("4/4"));
        assert(header.length() == 1.0/4);
        assert(header.tempo() == 100);
        assert(header.composer().equals("Liza H.W. Gaylord"));
        assert(header.voices().size() > 0);
        assert(header.key().equals("C"));
    }
    
    @Test
    public void testHeaderParserNoVoices() {
        Header header = Music.parseHeader("X: 1\nT:Piece No.1\nM:4/4\nL:1/4\nQ:1/4=140\nC:Oppenheimer\nK:C");
        assert(header.title().equals("Piece No.1"));
        assert(header.meter().equals("4/4"));
        assert(header.length() == 1.0/4);
        assert(header.tempo() == 140);
        assert(header.composer().equals("Oppenheimer"));
        assert(header.voices().size() == 0);
        assert(header.key().equals("C"));
    }
    
    @Test
    public void testHeaderParserNoOptionalFields() {
        Header header = Music.parseHeader("X: 1\nT:Piece No.1\nK:C");
        assert(header.title().equals("Piece No.1"));
        assert(header.meter().equals("4/4"));
        assert(header.length() == 1.0/8);
        assert(header.tempo() == 100);
        assert(header.composer() != null); // any readable string is acceptable
        assert(header.voices().size() == 0);
        assert(header.key().equals("C"));
    }
    
    @Test
    public void testHeaderParserMeterCommonTime() {
        Header header = Music.parseHeader("X:1\nT:Piece No.2\nM:C\nK:A#m");
        assert(header.meter().equals("4/4"));
        assert(header.key().equals("A#m"));
    }
}
