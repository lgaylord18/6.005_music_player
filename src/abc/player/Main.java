package abc.player;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import abc.sound.Body;
import abc.sound.Header;
import abc.sound.Music;
import abc.sound.SequencePlayer;

/**
 * Main entry point of your application.
 */
public class Main {

    /**
     * Plays the input file using Java MIDI API and displays
     * header information to the standard output stream.
     * 
     * (Your code should not exit the application abnormally using
     * System.exit().)
     * 
     * @param file the name of input abc file
     * @throws InvalidMidiDataException if inappropriate MIDI data is encountered
     * @throws MidiUnavailableException if the sequencer cannot be opened
     * @throws FileNotFoundException if the file is not found
     */
    public static void play(String file) throws MidiUnavailableException, InvalidMidiDataException, FileNotFoundException {
        File abcFile = new File(file);
        String header = "", body = "";
        Scanner s = new Scanner(abcFile);
        
        String line = s.nextLine();
        while (!(line.charAt(0) == 'K')) {
            header += line + "\n";
            line = s.nextLine();
        }
        header += line;
        
        line = s.nextLine();
        while (s.hasNextLine()) {
            body += line + "\n";
            line = s.nextLine();
        }
        body += line;
        
        s.close();
        
        Header parsedHeader = Music.parseHeader(header);
        Body parsedBody = Music.parseBody(body, parsedHeader);
        Music music = parsedBody.music();
        
        SequencePlayer player = new SequencePlayer(parsedHeader.tempo(), parsedBody.ticksPerBeat());
        music.play(player, 0, parsedBody.ticksPerBeat());
        player.play();
    }
    
    /**
     * Main method of the program. Plays music from a file.
     * 
     * @param args command-line arguments. The first element is the file name.
     * @throws InvalidMidiDataException if inappropriate MIDI data is encountered
     * @throws Mi=diUnavailableException if the sequencer cannot be opened
     * @throws FileNotFoundException if the file is not found
     */
    public static void main(String[] args) throws FileNotFoundException, MidiUnavailableException, InvalidMidiDataException {
        String fileName = "./sample_abc/piece2.abc";
                //args[0];
        try {
            play(fileName);
        } catch (FileNotFoundException | MidiUnavailableException | InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }
}
