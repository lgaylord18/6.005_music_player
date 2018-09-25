package abc.sound;

/**
 * Body represents an immutable body of an abc file. 
 */
public class Body {
    
    private final Music music;
    private final int ticksPerBeat;
    
    // Abstraction Function
    //  Represents the body of an abc file where
    //      music = the music in the body of the file
    //      ticksPerBeat = the number of ticks/beat needed to play the music in this body
    
    // Rep Invariant
    //  ticksPerBeat is a positive number

    // Rep Exposure
    //  All fields are private and final. No immutable objects or object references 
    //  are passed into or returned from any methods.
    
    /**
     * Creates a Body.
     * @param music the Music in this body
     * @param ticksPerBeat the number of ticks/beat needed to play the music in this body
     */
    public Body(Music music, int ticksPerBeat) {
        this.music = music;
        this.ticksPerBeat = ticksPerBeat;
        checkRep();
    }
    
    /** Checks that the representation invariant is true */
    private void checkRep() {
        assert music != null;
        assert ticksPerBeat > 0;
    }

    /**
     * @return the music in this body
     */
    public Music music() {
        return music;
    }
    
    /**
     * @return the number of ticks/beat needed to play the music in this body
     */
    public int ticksPerBeat() {
        return ticksPerBeat;
    }
    
    @Override
    public String toString() {
        return this.music.toString() + " " + this.ticksPerBeat;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final Body other = (Body) obj;
        return ticksPerBeat == other.ticksPerBeat && music.equals(other.music);
    }
    
    @Override
    public int hashCode() {
        return this.music.hashCode() + ticksPerBeat;
    }
}
