package abc.sound;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import abc.parser.HeaderListener;
import abc.parser.HeaderParser;
import abc.parser.HeaderParser.CommentContext;
import abc.parser.HeaderParser.Composer_fieldContext;
import abc.parser.HeaderParser.End_lineContext;
import abc.parser.HeaderParser.Index_fieldContext;
import abc.parser.HeaderParser.Key_fieldContext;
import abc.parser.HeaderParser.Length_fieldContext;
import abc.parser.HeaderParser.Meter_fieldContext;
import abc.parser.HeaderParser.Optional_fieldsContext;
import abc.parser.HeaderParser.StringContext;
import abc.parser.HeaderParser.Tempo_fieldContext;
import abc.parser.HeaderParser.Title_fieldContext;
import abc.parser.HeaderParser.Voice_fieldContext;

/** Get header info from a parse tree. */
public class MakeMusicHeader implements HeaderListener{
    
    private String title;
    private String key;
    private String composer = "Unknown";
    private Optional<String> length = Optional.empty();
    private String meter = "4/4";
    private double meterTop = 4;
    private double meterBottom = 4;
    private int tempo = 100;
    private String voice;
    private final Set<String> voices = new HashSet<>();

    /**
     * This method returns the Header that the was created by the listener object.
     * Only executes if the entire listener was walked over a parse
     * true using the ParseTreeWalker
     * @return Header for the parse tree that was just walked through
     */
    public Header getHeader() {
        if (!length.isPresent()) {
            if (meterTop/meterBottom >= 0.75) {
                length = Optional.of("1/8");
            } else {
                length = Optional.of("1/16");
            }
        }
        
        return new Header(title, composer, length.get(), meter, tempo, key, voices);
    }
    
    @Override public void enterHeader(HeaderParser.HeaderContext ctx) { }
    @Override public void exitHeader(HeaderParser.HeaderContext ctx) { }
    @Override public void enterOptional_fields(Optional_fieldsContext ctx) { }
    @Override public void exitOptional_fields(Optional_fieldsContext ctx) { }
    @Override public void enterIndex_field(Index_fieldContext ctx) { }

    @Override public void exitIndex_field(Index_fieldContext ctx) {
        // do nothing, this field does not carry any
        // meaning as we only parse one file at a time
    }

    @Override public void enterTitle_field(Title_fieldContext ctx) { }

    @Override
    public void exitTitle_field(Title_fieldContext ctx) {
        title = ctx.string().getText();
    }
    
    @Override public void enterComment(CommentContext ctx) { }
    @Override public void exitComment(CommentContext ctx) { }
    @Override public void enterKey_field(Key_fieldContext ctx) { }
    @Override public void exitKey_field(Key_fieldContext ctx) { }
    @Override public void enterComposer_field(Composer_fieldContext ctx) { }

    @Override
    public void exitComposer_field(Composer_fieldContext ctx) {
        composer = ctx.string().getText();
    }

    @Override public void enterLength_field(Length_fieldContext ctx) { }
    @Override public void exitLength_field(Length_fieldContext ctx) { }
    @Override public void enterMeter_field(Meter_fieldContext ctx) { }

    @Override
    public void exitMeter_field(Meter_fieldContext ctx) {
        String barDuration = ctx.meter().getText();
        if (barDuration.equals("C|")) {
            meter = "2/2";
            meterTop = 2;
            meterBottom = 2;
        } else if (!barDuration.equals("C") && !barDuration.equals("4/4")) { // ignore these cases because
            meter = barDuration;                                             // meter is by default 4/4
            meterTop = Double.valueOf(barDuration.substring(0, barDuration.indexOf("/")));
            meterBottom = Double.valueOf(barDuration.substring(barDuration.indexOf("/") + 1, 
                    barDuration.length()));
        }
    }

    @Override public void enterTempo_field(Tempo_fieldContext ctx) { }
    @Override public void exitTempo_field(Tempo_fieldContext ctx) { }
    @Override public void enterVoice_field(Voice_fieldContext ctx) { }

    @Override
    public void exitVoice_field(Voice_fieldContext ctx) {
        voice = ctx.string().getText();
        voices.add(voice.trim());
    }
    
    @Override public void enterEnd_line(End_lineContext ctx) { }
    @Override
    public void exitEnd_line(End_lineContext ctx) { }
    @Override
    public void enterKey(HeaderParser.KeyContext ctx) { }
    
    @Override
    public void exitKey(HeaderParser.KeyContext ctx) {
        key = ctx.getText();
    }
    
    @Override public void enterString(StringContext ctx) { }
    @Override public void exitString(StringContext ctx) { }
    @Override public void enterLength(HeaderParser.LengthContext ctx) { }
    
    @Override
    public void exitLength(HeaderParser.LengthContext ctx) {
        length = Optional.of(ctx.getText());
    }
    
    @Override public void enterMeter(HeaderParser.MeterContext ctx) { }
    @Override
    public void exitMeter(HeaderParser.MeterContext ctx) { }
    @Override
    public void enterTempo(HeaderParser.TempoContext ctx) { }
    
    @Override
    public void exitTempo(HeaderParser.TempoContext ctx) {
        tempo = Integer.valueOf(ctx.NUMBER().getText());
    }
    
    @Override
    public void enterEveryRule(ParserRuleContext arg0) {
//        System.err.println("entering " + arg0.getText() + ", map is " + map); 
    }

    @Override
    public void exitEveryRule(ParserRuleContext arg0) {
//        System.err.println("exiting " + arg0.getText() + ", map is " + map);
    }

    @Override public void visitErrorNode(ErrorNode arg0) { }
    @Override public void visitTerminal(TerminalNode arg0) { }
}
