package abc.sound;

/**
 * Note represents an immutable musical note. 
 */
public class Note implements Music {
    
    private final double duration;
    private final Pitch pitch;
    
    // Abstraction Function
    //  Represents a musical note with duration duration and pitch pitch
    
    // Rep Invariant
    //  Duration is a positive number

    // Rep Exposure
    //  All fields are private and final. No immutable objects or object references 
    //  are passed into or returned from any methods.
    
    /**
     * Make a Note played by instrument for duration beats.
     * @param duration duration in beats, must be >= 0
     * @param pitch pitch to play
     */
    public Note(double duration, Pitch pitch) {
        this.duration = duration;
        this.pitch = pitch;
        checkRep();
    }
    
    /** Checks that the representation invariant is true. */
    private void checkRep() {
        assert duration > 0;
        assert pitch != null;
    }
    
    /**
     * @return pitch of this note
     */
    public Pitch pitch() {
        return pitch;
    }
    
    /**
     * @return duration of this note
     */
    public double duration() {
        return duration;
    }
    
    /**
     * Transpose this note.
     * @return a new Note with the pitch transposed
     */
    public Music transpose(int semitonesUp) {
        return new Note(duration, pitch.transpose(semitonesUp));
    }
    
    /**
     * Play this note.
     */
    public void play(SequencePlayer player, int atBeat, int ticksPerBeat) {
        player.addNote(pitch.toMidiNote(), atBeat, (int) Math.ceil(ticksPerBeat*duration));
    }

    @Override
    public int hashCode() {
        long durationBits = Double.doubleToLongBits(duration);
        return (int) (durationBits ^ (durationBits >>> 32))
                + pitch.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final Note other = (Note) obj;
        return duration == other.duration
                && pitch.equals(other.pitch);
    }

    @Override
    public String toString() {
        return pitch.toString() + duration;
    }
}
