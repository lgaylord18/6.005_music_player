package abc.player;
import java.io.FileNotFoundException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import org.junit.Test;

/**
 * Tests to make sure warm up exercise pieces play correctly.
 * 
 *  @category no_didit 
 */
public class MainTest {
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    // 
    
    @Test
    //valid file
    public void testMainValidFileABC() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/abc_song.abc";
        Main.main(args);
    }
    
    @Test
    //valid file
    public void testMainValidFileFurElise() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/fur_elise.abc";
        Main.main(args);
    }
    
    @Test
    //valid file
    public void testMainValidFileInvention() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/invention.abc";
        Main.main(args);
    }
    
    @Test
    //valid file
    public void testMainValidFileLittleNightMusic() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/little_night_music.abc";
        Main.main(args);
    }
    
    @Test
    //valid file
    public void testMainValidFilePaddy() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/paddy.abc";
        Main.main(args);
    }
    
    @Test
    //valid file
    public void testMainValidFilePiece1() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/piece1.abc";
        Main.main(args);
    }
    
    @Test
    //valid file
    public void testMainValidFilePiece2() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/piece2.abc";
        Main.main(args);
    }
    
    @Test
    //valid file
    public void testMainValidFilePrelude() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/prelude.abc";
        Main.main(args);
    }
    
    @Test
    //valid file
    public void testMainValidFileSample1() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/sample1.abc";
        Main.main(args);
    }
    
    @Test
    //valid file
    public void testMainValidFileSample2() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/piece2.abc";
        Main.main(args);
    }
    
    @Test
    //valid file
    public void testMainValidFileSample3() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/sample3.abc";
        Main.main(args);
    }
    
    @Test
    //valid file
    public void testMainValidFileScale() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/scale.abc";
        Main.main(args);
    }
    
    @Test
    //valid file
    public void testMainValidFileStayinAlive() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/stayin_alive.abc";
        Main.main(args);
    }
    
    @Test
    //valid file
    public void testMainValidFileTestCase() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/test_case.abc";
        Main.main(args);
    }
    
    @Test
    //valid file
    public void testMainValidFileWaxiesDargle() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/waxies_dargle.abc";
        Main.main(args);
    }
    
    @Test
    //invalid file
    public void testMainInvalidFile() throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException
    {
        String[] args = new String[1];
        args[0] = "./sample_abc/superman.abc";
        Main.main(args);
    }

}
