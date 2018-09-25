package abc.sound;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import org.junit.Test;

/**
 * Tests to make sure warm up exercise pieces play correctly.
 * 
 *  @category no_didit 
 */
public class SequencePlayerTest {
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    //test piece1
    @Test public void testPieceOne() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
        SequencePlayer player = new SequencePlayer(140, 12);
        //first bar
        player.addNote(new Pitch('C').toMidiNote(), 0, 12);
        player.addNote(new Pitch('C').toMidiNote(), 12, 12);
        player.addNote(new Pitch('C').toMidiNote(), 24, 9);
        player.addNote(new Pitch('D').toMidiNote(), 33, 3);
        player.addNote(new Pitch('E').toMidiNote(), 36, 12);
        
        //second bar
        player.addNote(new Pitch('E').toMidiNote(), 48, 9);
        player.addNote(new Pitch('D').toMidiNote(), 57, 3);
        player.addNote(new Pitch('E').toMidiNote(), 60, 9);
        player.addNote(new Pitch('F').toMidiNote(), 69, 3);
        player.addNote(new Pitch('G').toMidiNote(), 72, 24);
        
        //third bar
        player.addNote(new Pitch('C').transpose(12).toMidiNote(), 96, 4);
        player.addNote(new Pitch('C').transpose(12).toMidiNote(), 100, 4);
        player.addNote(new Pitch('C').transpose(12).toMidiNote(), 104, 4);
        player.addNote(new Pitch('G').toMidiNote(), 108, 4);
        player.addNote(new Pitch('G').toMidiNote(), 112, 4);
        player.addNote(new Pitch('G').toMidiNote(), 116, 4);
        player.addNote(new Pitch('E').toMidiNote(), 120, 4);
        player.addNote(new Pitch('E').toMidiNote(), 124, 4);
        player.addNote(new Pitch('E').toMidiNote(), 128, 4);
        player.addNote(new Pitch('C').toMidiNote(), 132, 4);
        player.addNote(new Pitch('C').toMidiNote(), 136, 4);
        player.addNote(new Pitch('C').toMidiNote(), 140, 4);
        
        //fourth bar
        player.addNote(new Pitch('G').toMidiNote(), 144, 9);
        player.addNote(new Pitch('F').toMidiNote(), 153, 3);
        player.addNote(new Pitch('E').toMidiNote(), 156, 9);
        player.addNote(new Pitch('D').toMidiNote(), 165, 3);
        player.addNote(new Pitch('C').toMidiNote(), 168, 24);

        player.play();
        Thread.sleep(10000);
    }
    
    //test piece2
    @Test public void testPieceTwo() throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
        SequencePlayer player = new SequencePlayer(200, 12);
        //first bar
        player.addNote(new Pitch('F').transpose(1).toMidiNote(), 0, 6);
        player.addNote(new Pitch('E').transpose(12).toMidiNote(), 0, 6);
        player.addNote(new Pitch('F').toMidiNote(), 6, 6);
        player.addNote(new Pitch('E').transpose(12).toMidiNote(), 6, 6);
        player.addNote(new Pitch('F').toMidiNote(), 18, 6);
        player.addNote(new Pitch('E').transpose(12).toMidiNote(), 18, 6);
        player.addNote(new Pitch('F').toMidiNote(), 30, 6);
        player.addNote(new Pitch('C').transpose(12).toMidiNote(), 30, 6);
        player.addNote(new Pitch('F').toMidiNote(), 36, 12);
        player.addNote(new Pitch('E').transpose(12).toMidiNote(), 36, 12);
        
        //second bar
        player.addNote(new Pitch('G').toMidiNote(), 48, 12);
        player.addNote(new Pitch('B').toMidiNote(), 48, 12);
        player.addNote(new Pitch('G').transpose(12).toMidiNote(), 48, 12);
        player.addNote(new Pitch('G').toMidiNote(), 72, 12);
        
        //third bar
        player.addNote(new Pitch('C').transpose(12).toMidiNote(), 96, 18);
        player.addNote(new Pitch('G').transpose(12).toMidiNote(), 114, 6);
        player.addNote(new Pitch('E').toMidiNote(), 132, 12);
        
        //fourth bar
        player.addNote(new Pitch('E').toMidiNote(), 144, 6);
        player.addNote(new Pitch('A').toMidiNote(), 150, 12);
        player.addNote(new Pitch('B').toMidiNote(), 162, 12);
        player.addNote(new Pitch('B').transpose(-1).toMidiNote(), 174, 6);
        player.addNote(new Pitch('A').toMidiNote(), 180, 12);
        
        //fifth bar
        player.addNote(new Pitch('G').toMidiNote(), 192, 8);
        player.addNote(new Pitch('E').transpose(12).toMidiNote(), 200, 8);
        player.addNote(new Pitch('G').transpose(12).toMidiNote(), 208, 8);
        player.addNote(new Pitch('A').transpose(12).toMidiNote(), 216, 12);
        player.addNote(new Pitch('F').transpose(12).toMidiNote(), 228, 6);
        player.addNote(new Pitch('G').transpose(12).toMidiNote(), 234, 6);
        
        //sixth bar
        player.addNote(new Pitch('E').transpose(12).toMidiNote(), 246, 12);
        player.addNote(new Pitch('C').transpose(12).toMidiNote(), 258, 6);
        player.addNote(new Pitch('D').transpose(12).toMidiNote(), 264, 6);
        player.addNote(new Pitch('B').toMidiNote(), 270, 9);
        
        player.play();
        Thread.sleep(10000);
    }
    
    
}
