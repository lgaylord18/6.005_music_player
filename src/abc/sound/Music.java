package abc.sound;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import abc.parser.BodyLexer;
import abc.parser.BodyParser;
import abc.parser.HeaderLexer;
import abc.parser.HeaderParser;

/**
 * Music represents an immutable piece of music.
 */
public interface Music {
    
    // Datatype definition:
    //  Music = Rest(duration: double) + Note(duration: double, pitch: Pitch) + 
    //              Concat(m1: Music, m2: Music) + Together(m1: Music, m2: Music)
    
    /**
     * Parse the header of an abc file.
     * @param input header to parse, as defined in the ABC Player project handout.
     * @return a Header object
     * @throws IllegalArgumentException if the header is invalid
     */
    public static Header parseHeader(String input) throws IllegalArgumentException{
        try { 
            // Create a stream of characters from the string
            CharStream stream = new ANTLRInputStream(input);
    
            // Create an instance of the lexer class that our grammar file 
            // generated, and pass it the character stream
            HeaderLexer lexer = new HeaderLexer(stream);
            lexer.removeErrorListeners();  
            lexer.reportErrorsAsExceptions(); // Check for errors
            TokenStream tokens = new CommonTokenStream(lexer);
            
            // Feed terminals to parser
            HeaderParser parser = new HeaderParser(tokens);
            parser.removeErrorListeners(); 
            parser.reportErrorsAsExceptions(); // Check for errors
            
            // Generate the parse tree using the starter rule.
            ParseTree tree = parser.header();
            
            MakeMusicHeader headerMaker = new MakeMusicHeader();
            new ParseTreeWalker().walk(headerMaker, tree);
            return headerMaker.getHeader();
        } catch(ParseCancellationException e) {
            throw new IllegalArgumentException(e);
        }
    }
    
    /**
     * Parse the body of an abc file.
     * @param input body to parse, as defined in the ABC Player project handout.
     * @return a Body object
     * @throws IllegalArgumentException if the expression is invalid
     */
    public static Body parseBody(String input, Header header) throws IllegalArgumentException{
        try { 
            // Create a stream of characters from the string
            CharStream stream = new ANTLRInputStream(input);
    
            // Create an instance of the lexer class that our grammar file 
            // generated, and pass it the character stream
            BodyLexer lexer = new BodyLexer(stream);
            lexer.removeErrorListeners();  
            lexer.reportErrorsAsExceptions(); // Check for errors
            TokenStream tokens = new CommonTokenStream(lexer);
            
            // Feed terminals to parser
            BodyParser parser = new BodyParser(tokens);
            parser.removeErrorListeners(); 
            parser.reportErrorsAsExceptions(); // Check for errors
            
            // Generate the parse tree using the starter rule.
            ParseTree tree = parser.body();
            
            MakeMusicBody bodyMaker = new MakeMusicBody(header);
            new ParseTreeWalker().walk(bodyMaker, tree);
            return bodyMaker.getBody();
        } catch(ParseCancellationException e) {
            throw new IllegalArgumentException(e);
        }
    }
    
    /**
     * @return total duration of this piece in beats
     */
    double duration();
    
    /**
     * Transpose all notes upward or downward in pitch.
     * @param semitonesUp semitones by which to transpose
     * @return for Music m, return m' such that for all notes n in m, the
     *         corresponding note n' in m' has
     *         n'.pitch() == n.pitch().transpose(semitonesUp), and m' is
     *         otherwise identical to m
     */
    Music transpose(int semitonesUp);
    
    /**
     * Play this piece.
     * @param player player to play on
     * @param atBeat when to play
     * @param ticksPerBeat the number of ticks per beat in this piece
     * @param tempo the tempo of this piece
     */
    void play(SequencePlayer player, int atBeat, int ticksPerBeat);
    
}
