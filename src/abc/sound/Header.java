package abc.sound;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Header represents an immutable header of an abc file, as defined in the ABCPlayer Project spec. 
 */
public class Header {
    
    private final String title;
    private final String key;
    private final String composer;
    private final double length;
    private final String meter;
    private final int tempo;
    private final Set<String> voices = new HashSet<>();
    
    // Abstraction Function
    //  Represents the header of an abc file where
    //    title = title of the piece
    //    key = key signature of the piece
    //    composer = composer of the piece
    //    length = default length of a note in this piece
    //    meter = meter of the piece
    //    tempo = number of beats of the given length to play per minute
    //    voices = the list of voices in the piece. voices is empty if there are 
    //             no voices in the piece
    
    // Rep Invariant
    //  0 < length =< 1

    // Rep Exposure
    //  All fields are private and final. Immutable objects or object references 
    //  are only passed into or returned from Header() and voices(), and defensive 
    //  copies are made in both cases.
    
    /**
     * Creates a Header.
     * @param title the title of the piece
     * @param composer the composer of the piece
     * @param length the default note length of the piece
     * @param meter the meter of the piece
     * @param tempo the tempo (in beats/minute) of the piece
     * @param key the key signature of the piece
     * @param voices the voices in the piece
     */
    public Header(String title, String composer, String length, String meter, int tempo, String key, 
            Set<String> voices) {
        this.composer = composer;
        this.title = title;
        this.key = key;
        this.meter = meter;
        this.tempo = tempo;
        
        if (voices.size() > 0) {
            for (String voice: voices) {
                this.voices.add(voice);
            }
        } 
        
        String lengthString = length;
        double lengthTop = Double.valueOf(lengthString.substring(0, lengthString.indexOf("/")));
        double lengthBottom = Double.valueOf(lengthString.substring(lengthString.indexOf("/") + 1, 
                lengthString.length()));
        this.length = lengthTop/lengthBottom;
        checkRep();
    }
    
    /** Checks that the representation invariant is true */
    private void checkRep() {
        assert title != null;
        assert key != null;
        assert composer != null;
        assert meter != null;
        assert voices != null;
        
        assert tempo > 0;
        assert length > 0;
        assert length <= 1;
    }
    
    /**
     * @return title of piece
     */
    public String title() {
        return this.title;
    }
    
    /**
     * @return key of piece
     */
    public String key() {
        return this.key;
    }
    
    /**
     * @return composer of piece
     */
    public String composer() {
        return this.composer;
    }
    
    /**
     * @return default length of a note in this piece
     */
    public double length() {
        return this.length;
    }
    
    /**
     * @return meter of piece
     */
    public String meter() {
        return this.meter;
    }
    
    /** 
     * @return tempo of piece
     */
    public int tempo() {
        return this.tempo;
    }
    
    /**
     * @return a list of the voices in this piece. The list may be empty if no
     *         voices exist in the piece.
     */
    public Set<String> voices() {
        return new HashSet<>(voices);
    }
    
    @Override
    public String toString() {
        return this.title + " by: " + this.composer;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final Header other = (Header) obj;
        return (this.title.equals(other.title)) &&
                (this.key.equals(other.key)) &&
                (this.composer.equals(other.composer)) &&
                (this.length == other.length) &&
                (this.meter.equals(other.meter)) &&
                (this.tempo == other.tempo) &&
                (this.voices.equals(other.voices));
    }
    
    @Override
    public int hashCode() {
        return this.title.hashCode() + this.composer.hashCode();
    }
}
