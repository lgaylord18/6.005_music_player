package abc.sound;

/**
 * Concat represents two pieces of music played one after the other. 
 * Immutable.
 */
public class Concat implements Music{
    private final Music first;
    private final Music second;
    
    // Abstraction Function
    //  Represents two musics played after one another, first is played first and second 
    //  is played second
    
    // Rep Invariant
    //  True

    // Rep Exposure
    //  All fields are private and final. No immutable objects or object references 
    //  are passed into or returned from any methods.

    
    /**
     * Make a Music sequence that plays first followed by second
     * @param first music to play first
     * @param second music to play second
     */
    public Concat(Music first, Music second) {
        this.first = first;
        this.second = second;
        checkRep();
    }
    
    /** Checks that the representation invariant is true */
    private void checkRep() {
        assert first != null;
        assert second != null;
    }
    
    /**
     * @return first piece in this concatenation
     */
    public Music first() {
        return first;
    }
    
    /**
     * @return second piece in this concatenation
     */
    public Music second() {
        return second;
    }

    @Override
    public double duration() {
        return first.duration() + second.duration();
    }

    @Override
    public Music transpose(int semitonesUp) {
        return new Concat(first.transpose(semitonesUp), second.transpose(semitonesUp));
    }

    @Override
    public void play(SequencePlayer player, int atBeat, int ticksPerBeat) {
        first.play(player, atBeat, ticksPerBeat);
        second.play(player, atBeat + (int) (Math.ceil(first.duration()*ticksPerBeat)), ticksPerBeat);
    }
    
    @Override
    public String toString() {
        return first.toString() + " " + second.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final Concat other = (Concat) obj;
        return this.toString().equals(other.toString());
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        return first.hashCode() + prime*second.hashCode();
    }
    
}
