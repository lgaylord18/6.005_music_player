package abc.sound;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

public class HeaderTest {
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    // Partitions & Testing Strategy
    //  - title
    //  - key
    //  - composer
    //  - length
    //  - meter
    //  - tempo
    //  - voices
    //  - toString
    //  - equals
    //      two equal things
    //      two unequal things
    //  - hashCode
    //      two equal things
    //      two unequal things
    
    @Test
    //header.title() returns the right String
    public void testHeaderTitle()
    {
        Set<String> voices = new HashSet<>(Arrays.asList("uppler", "middle", "lower"));
        Header header = new Header("Moonlight Sonata", "Ludwig van Beethoven", "1/4", "3/8", 100, "A#m", voices);
        assertTrue(header.title().equals("Moonlight Sonata"));
    }
    
    @Test
    //header.key() returns the right String
    public void testHeaderKey()
    {
        Set<String> voices = new HashSet<>(Arrays.asList("uppler", "middle", "lower"));
        Header header = new Header("Moonlight Sonata", "Ludwig van Beethoven", "1/4", "3/8", 100, "A#m", voices);
        assertTrue(header.key().equals("A#m"));
    }
    
    @Test
    //header.composer() returns the right String
    public void testHeaderComposer()
    {
        Set<String> voices = new HashSet<>(Arrays.asList("uppler", "middle", "lower"));
        Header header = new Header("Moonlight Sonata", "Ludwig van Beethoven", "1/4", "3/8", 100, "A#m", voices);
        assertTrue(header.composer().equals("Ludwig van Beethoven"));
    }
    
    @Test
    //header.length() returns the right double
    public void testHeaderLength()
    {
        Set<String> voices = new HashSet<>(Arrays.asList("uppler", "middle", "lower"));
        Header header = new Header("Moonlight Sonata", "Ludwig van Beethoven", "1/4", "3/8", 100, "A#m", voices);
        assertTrue(header.length() == 0.25);
    }
    
    @Test
    //header.meter() returns the right String
    public void testHeaderMeter()
    {
        Set<String> voices = new HashSet<>(Arrays.asList("uppler", "middle", "lower"));
        Header header = new Header("Moonlight Sonata", "Ludwig van Beethoven", "1/4", "3/8", 100, "A#m", voices);
        assertTrue(header.meter().equals("3/8"));
    }
    
    @Test
    //header.tempo() returns the right int
    public void testHeaderTempo()
    {
        Set<String> voices = new HashSet<>(Arrays.asList("uppler", "middle", "lower"));
        Header header = new Header("Moonlight Sonata", "Ludwig van Beethoven", "1/4", "3/8", 100, "A#m", voices);
        assertTrue(header.tempo() == 100);
    }
    
    @Test
    //header.voices() returns the right set
    public void testHeaderVoices()
    {
        Set<String> voices = new HashSet<>(Arrays.asList("uppler", "middle", "lower"));
        Header header = new Header("Moonlight Sonata", "Ludwig van Beethoven", "1/4", "3/8", 100, "A#m", voices);
        assertTrue(header.voices().equals(voices));
    }
    
    //  - toString
    //  - equals
    //      two equal things
    //      two unequal things
    //  - hashCode
    //      two equal things
    //      two unequal things
    
    @Test
    //header.toString() returns the right string
    public void testHeaderToString()
    {
        Set<String> voices = new HashSet<>(Arrays.asList("uppler", "middle", "lower"));
        Header header = new Header("Moonlight Sonata", "Ludwig van Beethoven", "1/4", "3/8", 100, "A#m", voices);
        String correct = "Moonlight Sonata by: Ludwig van Beethoven";
        assertTrue(header.toString().equals(correct));
    }
    
    @Test
    //header.equals() returns true for two equal headers
    public void testHeaderEqualsSame()
    {
        Set<String> voices = new HashSet<>(Arrays.asList("uppler", "middle", "lower"));
        Header header1 = new Header("Moonlight Sonata", "Ludwig van Beethoven", "1/4", "3/8", 100, "A#m", voices);
        Header header2 = new Header("Moonlight Sonata", "Ludwig van Beethoven", "1/4", "3/8", 100, "A#m", voices);
        assertTrue(header1.equals(header2));
    }
    
    @Test
    //header.equals() returns false for two different headers
    public void testHeaderEqualsDifferent()
    {
        Set<String> voices = new HashSet<>(Arrays.asList("uppler", "middle", "lower"));
        Header header1 = new Header("Moonlight Sonata", "Ludwig van Beethoven", "1/4", "3/8", 100, "A#m", voices);
        Header header2 = new Header("Fur Elise", "Ludwig van Beethoven", "1/16", "3/8", 140, "Am", voices);
        assertFalse(header1.equals(header2));
    }
    
    @Test
    //header.hashCode() returns the same value for two equal headers
    public void testHeaderHashCodeSame()
    {
        Set<String> voices = new HashSet<>(Arrays.asList("uppler", "middle", "lower"));
        Header header1 = new Header("Moonlight Sonata", "Ludwig van Beethoven", "1/4", "3/8", 100, "A#m", voices);
        Header header2 = new Header("Moonlight Sonata", "Ludwig van Beethoven", "1/4", "3/8", 100, "A#m", voices);
        assertTrue(header1.equals(header2));
        assertTrue(header1.hashCode() == header2.hashCode());
    }
    
    @Test
    //header.hashCode() returns two different values for two different headers
    public void testHeaderHashCodeDifferent()
    {
        Set<String> voices = new HashSet<>(Arrays.asList("uppler", "middle", "lower"));
        Header header1 = new Header("Moonlight Sonata", "Ludwig van Beethoven", "1/4", "3/8", 100, "A#m", voices);
        Header header2 = new Header("Fur Elise", "Ludwig van Beethoven", "1/16", "3/8", 140, "Am", voices);
        assertFalse(header1.equals(header2));
        assertFalse(header1.hashCode() == header2.hashCode());
    }
}