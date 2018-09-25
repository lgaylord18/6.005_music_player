// Generated from Body.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BodyParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
    T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ACCIDENTAL=15, NOTE_LETTERS=16, 
    OCTAVE=17, TUPLET_START=18, OTHER_LETTERS=19, REST_LETTERS=20, NUMBER=21, 
    WHITESPACE=22, END_BAR=23, NEWLINE=24, SPACES=25;
  public static final int
    RULE_body = 0, RULE_body_line = 1, RULE_comment = 2, RULE_voice = 3, 
    RULE_element = 4, RULE_note_element = 5, RULE_note = 6, RULE_rest = 7, 
    RULE_chord = 8, RULE_tuplet = 9, RULE_barline = 10, RULE_repeat = 11, 
    RULE_string = 12, RULE_time = 13;
  public static final String[] ruleNames = {
    "body", "body_line", "comment", "voice", "element", "note_element", 
    "note", "rest", "chord", "tuplet", "barline", "repeat", "string", "time"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'%'", "'V:'", "'['", "']'", "'|'", "'||'", "'[|'", "'|]'", "':|'", 
    "'|:'", "'[1'", "'[2'", "'.'", "'/'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, null, null, null, null, null, null, null, 
    null, null, null, "ACCIDENTAL", "NOTE_LETTERS", "OCTAVE", "TUPLET_START", 
    "OTHER_LETTERS", "REST_LETTERS", "NUMBER", "WHITESPACE", "END_BAR", 
    "NEWLINE", "SPACES"
  };
  public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

  /**
   * @deprecated Use {@link #VOCABULARY} instead.
   */
  @Deprecated
  public static final String[] tokenNames;
  static {
    tokenNames = new String[_SYMBOLIC_NAMES.length];
    for (int i = 0; i < tokenNames.length; i++) {
      tokenNames[i] = VOCABULARY.getLiteralName(i);
      if (tokenNames[i] == null) {
        tokenNames[i] = VOCABULARY.getSymbolicName(i);
      }

      if (tokenNames[i] == null) {
        tokenNames[i] = "<INVALID>";
      }
    }
  }

  @Override
  @Deprecated
  public String[] getTokenNames() {
    return tokenNames;
  }

  @Override

  public Vocabulary getVocabulary() {
    return VOCABULARY;
  }

  @Override
  public String getGrammarFileName() { return "Body.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public ATN getATN() { return _ATN; }


      // This method makes the parser stop running if it encounters
      // invalid input and throw a RuntimeException.
      public void reportErrorsAsExceptions() {
          // To prevent any reports to standard error, add this line:
          //removeErrorListeners();
          
          addErrorListener(new BaseErrorListener() {
              public void syntaxError(Recognizer<?, ?> recognizer,
                                      Object offendingSymbol, 
                                      int line, int charPositionInLine,
                                      String msg, RecognitionException e) {
                  throw new ParseCancellationException(msg, e);
              }
          });
      }

  public BodyParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class BodyContext extends ParserRuleContext {
    public TerminalNode EOF() { return getToken(BodyParser.EOF, 0); }
    public List<Body_lineContext> body_line() {
      return getRuleContexts(Body_lineContext.class);
    }
    public Body_lineContext body_line(int i) {
      return getRuleContext(Body_lineContext.class,i);
    }
    public BodyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_body; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).enterBody(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).exitBody(this);
    }
  }

  public final BodyContext body() throws RecognitionException {
    BodyContext _localctx = new BodyContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_body);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(29); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(28);
        body_line();
        }
        }
        setState(31); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << ACCIDENTAL) | (1L << NOTE_LETTERS) | (1L << TUPLET_START) | (1L << REST_LETTERS) | (1L << WHITESPACE) | (1L << NEWLINE))) != 0) );
      setState(33);
      match(EOF);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class Body_lineContext extends ParserRuleContext {
    public VoiceContext voice() {
      return getRuleContext(VoiceContext.class,0);
    }
    public CommentContext comment() {
      return getRuleContext(CommentContext.class,0);
    }
    public List<TerminalNode> NEWLINE() { return getTokens(BodyParser.NEWLINE); }
    public TerminalNode NEWLINE(int i) {
      return getToken(BodyParser.NEWLINE, i);
    }
    public List<ElementContext> element() {
      return getRuleContexts(ElementContext.class);
    }
    public ElementContext element(int i) {
      return getRuleContext(ElementContext.class,i);
    }
    public Body_lineContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_body_line; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).enterBody_line(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).exitBody_line(this);
    }
  }

  public final Body_lineContext body_line() throws RecognitionException {
    Body_lineContext _localctx = new Body_lineContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_body_line);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(43);
      switch (_input.LA(1)) {
      case T__1:
        {
        setState(35);
        voice();
        }
        break;
      case T__2:
      case T__4:
      case T__5:
      case T__6:
      case T__7:
      case T__8:
      case T__9:
      case T__10:
      case T__11:
      case ACCIDENTAL:
      case NOTE_LETTERS:
      case TUPLET_START:
      case REST_LETTERS:
      case WHITESPACE:
        {
        setState(37); 
        _errHandler.sync(this);
        _alt = 1;
        do {
          switch (_alt) {
          case 1:
            {
            {
            setState(36);
            element();
            }
            }
            break;
          default:
            throw new NoViableAltException(this);
          }
          setState(39); 
          _errHandler.sync(this);
          _alt = getInterpreter().adaptivePredict(_input,1,_ctx);
        } while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
        }
        break;
      case T__0:
        {
        setState(41);
        comment();
        }
        break;
      case NEWLINE:
        {
        setState(42);
        match(NEWLINE);
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
      setState(46);
      switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
      case 1:
        {
        setState(45);
        match(NEWLINE);
        }
        break;
      }
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class CommentContext extends ParserRuleContext {
    public StringContext string() {
      return getRuleContext(StringContext.class,0);
    }
    public CommentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_comment; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).enterComment(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).exitComment(this);
    }
  }

  public final CommentContext comment() throws RecognitionException {
    CommentContext _localctx = new CommentContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_comment);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(48);
      match(T__0);
      setState(50);
      switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
      case 1:
        {
        setState(49);
        string();
        }
        break;
      }
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class VoiceContext extends ParserRuleContext {
    public StringContext string() {
      return getRuleContext(StringContext.class,0);
    }
    public VoiceContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_voice; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).enterVoice(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).exitVoice(this);
    }
  }

  public final VoiceContext voice() throws RecognitionException {
    VoiceContext _localctx = new VoiceContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_voice);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(52);
      match(T__1);
      setState(53);
      string();
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class ElementContext extends ParserRuleContext {
    public Note_elementContext note_element() {
      return getRuleContext(Note_elementContext.class,0);
    }
    public RestContext rest() {
      return getRuleContext(RestContext.class,0);
    }
    public TupletContext tuplet() {
      return getRuleContext(TupletContext.class,0);
    }
    public BarlineContext barline() {
      return getRuleContext(BarlineContext.class,0);
    }
    public RepeatContext repeat() {
      return getRuleContext(RepeatContext.class,0);
    }
    public TerminalNode WHITESPACE() { return getToken(BodyParser.WHITESPACE, 0); }
    public ElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_element; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).enterElement(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).exitElement(this);
    }
  }

  public final ElementContext element() throws RecognitionException {
    ElementContext _localctx = new ElementContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_element);
    try {
      setState(61);
      switch (_input.LA(1)) {
      case T__2:
      case ACCIDENTAL:
      case NOTE_LETTERS:
        enterOuterAlt(_localctx, 1);
        {
        setState(55);
        note_element();
        }
        break;
      case REST_LETTERS:
        enterOuterAlt(_localctx, 2);
        {
        setState(56);
        rest();
        }
        break;
      case TUPLET_START:
        enterOuterAlt(_localctx, 3);
        {
        setState(57);
        tuplet();
        }
        break;
      case T__4:
      case T__5:
      case T__6:
      case T__7:
      case T__8:
      case T__9:
        enterOuterAlt(_localctx, 4);
        {
        setState(58);
        barline();
        }
        break;
      case T__10:
      case T__11:
        enterOuterAlt(_localctx, 5);
        {
        setState(59);
        repeat();
        }
        break;
      case WHITESPACE:
        enterOuterAlt(_localctx, 6);
        {
        setState(60);
        match(WHITESPACE);
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class Note_elementContext extends ParserRuleContext {
    public NoteContext note() {
      return getRuleContext(NoteContext.class,0);
    }
    public ChordContext chord() {
      return getRuleContext(ChordContext.class,0);
    }
    public Note_elementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note_element; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).enterNote_element(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).exitNote_element(this);
    }
  }

  public final Note_elementContext note_element() throws RecognitionException {
    Note_elementContext _localctx = new Note_elementContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_note_element);
    try {
      setState(65);
      switch (_input.LA(1)) {
      case ACCIDENTAL:
      case NOTE_LETTERS:
        enterOuterAlt(_localctx, 1);
        {
        setState(63);
        note();
        }
        break;
      case T__2:
        enterOuterAlt(_localctx, 2);
        {
        setState(64);
        chord();
        }
        break;
      default:
        throw new NoViableAltException(this);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class NoteContext extends ParserRuleContext {
    public TerminalNode NOTE_LETTERS() { return getToken(BodyParser.NOTE_LETTERS, 0); }
    public TerminalNode ACCIDENTAL() { return getToken(BodyParser.ACCIDENTAL, 0); }
    public TerminalNode OCTAVE() { return getToken(BodyParser.OCTAVE, 0); }
    public TimeContext time() {
      return getRuleContext(TimeContext.class,0);
    }
    public TerminalNode NUMBER() { return getToken(BodyParser.NUMBER, 0); }
    public NoteContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).enterNote(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).exitNote(this);
    }
  }

  public final NoteContext note() throws RecognitionException {
    NoteContext _localctx = new NoteContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_note);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(68);
      _la = _input.LA(1);
      if (_la==ACCIDENTAL) {
        {
        setState(67);
        match(ACCIDENTAL);
        }
      }

      setState(70);
      match(NOTE_LETTERS);
      setState(72);
      _la = _input.LA(1);
      if (_la==OCTAVE) {
        {
        setState(71);
        match(OCTAVE);
        }
      }

      setState(76);
      switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
      case 1:
        {
        setState(74);
        time();
        }
        break;
      case 2:
        {
        setState(75);
        match(NUMBER);
        }
        break;
      }
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class RestContext extends ParserRuleContext {
    public TerminalNode REST_LETTERS() { return getToken(BodyParser.REST_LETTERS, 0); }
    public TimeContext time() {
      return getRuleContext(TimeContext.class,0);
    }
    public TerminalNode NUMBER() { return getToken(BodyParser.NUMBER, 0); }
    public RestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_rest; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).enterRest(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).exitRest(this);
    }
  }

  public final RestContext rest() throws RecognitionException {
    RestContext _localctx = new RestContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_rest);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(78);
      match(REST_LETTERS);
      setState(81);
      switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
      case 1:
        {
        setState(79);
        time();
        }
        break;
      case 2:
        {
        setState(80);
        match(NUMBER);
        }
        break;
      }
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class ChordContext extends ParserRuleContext {
    public List<NoteContext> note() {
      return getRuleContexts(NoteContext.class);
    }
    public NoteContext note(int i) {
      return getRuleContext(NoteContext.class,i);
    }
    public ChordContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_chord; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).enterChord(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).exitChord(this);
    }
  }

  public final ChordContext chord() throws RecognitionException {
    ChordContext _localctx = new ChordContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_chord);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(83);
      match(T__2);
      setState(85); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(84);
        note();
        }
        }
        setState(87); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( _la==ACCIDENTAL || _la==NOTE_LETTERS );
      setState(89);
      match(T__3);
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class TupletContext extends ParserRuleContext {
    public TerminalNode TUPLET_START() { return getToken(BodyParser.TUPLET_START, 0); }
    public List<Note_elementContext> note_element() {
      return getRuleContexts(Note_elementContext.class);
    }
    public Note_elementContext note_element(int i) {
      return getRuleContext(Note_elementContext.class,i);
    }
    public TupletContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_tuplet; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).enterTuplet(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).exitTuplet(this);
    }
  }

  public final TupletContext tuplet() throws RecognitionException {
    TupletContext _localctx = new TupletContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_tuplet);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(91);
      match(TUPLET_START);
      setState(93); 
      _errHandler.sync(this);
      _alt = 1;
      do {
        switch (_alt) {
        case 1:
          {
          {
          setState(92);
          note_element();
          }
          }
          break;
        default:
          throw new NoViableAltException(this);
        }
        setState(95); 
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,12,_ctx);
      } while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class BarlineContext extends ParserRuleContext {
    public BarlineContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_barline; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).enterBarline(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).exitBarline(this);
    }
  }

  public final BarlineContext barline() throws RecognitionException {
    BarlineContext _localctx = new BarlineContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_barline);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(97);
      _la = _input.LA(1);
      if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) ) {
      _errHandler.recoverInline(this);
      } else {
        consume();
      }
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class RepeatContext extends ParserRuleContext {
    public RepeatContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_repeat; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).enterRepeat(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).exitRepeat(this);
    }
  }

  public final RepeatContext repeat() throws RecognitionException {
    RepeatContext _localctx = new RepeatContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_repeat);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(99);
      _la = _input.LA(1);
      if ( !(_la==T__10 || _la==T__11) ) {
      _errHandler.recoverInline(this);
      } else {
        consume();
      }
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class StringContext extends ParserRuleContext {
    public List<TerminalNode> NOTE_LETTERS() { return getTokens(BodyParser.NOTE_LETTERS); }
    public TerminalNode NOTE_LETTERS(int i) {
      return getToken(BodyParser.NOTE_LETTERS, i);
    }
    public List<TerminalNode> OTHER_LETTERS() { return getTokens(BodyParser.OTHER_LETTERS); }
    public TerminalNode OTHER_LETTERS(int i) {
      return getToken(BodyParser.OTHER_LETTERS, i);
    }
    public List<TerminalNode> REST_LETTERS() { return getTokens(BodyParser.REST_LETTERS); }
    public TerminalNode REST_LETTERS(int i) {
      return getToken(BodyParser.REST_LETTERS, i);
    }
    public List<TerminalNode> NUMBER() { return getTokens(BodyParser.NUMBER); }
    public TerminalNode NUMBER(int i) {
      return getToken(BodyParser.NUMBER, i);
    }
    public List<TerminalNode> WHITESPACE() { return getTokens(BodyParser.WHITESPACE); }
    public TerminalNode WHITESPACE(int i) {
      return getToken(BodyParser.WHITESPACE, i);
    }
    public List<TerminalNode> OCTAVE() { return getTokens(BodyParser.OCTAVE); }
    public TerminalNode OCTAVE(int i) {
      return getToken(BodyParser.OCTAVE, i);
    }
    public StringContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_string; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).enterString(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).exitString(this);
    }
  }

  public final StringContext string() throws RecognitionException {
    StringContext _localctx = new StringContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_string);
    int _la;
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(102); 
      _errHandler.sync(this);
      _alt = 1;
      do {
        switch (_alt) {
        case 1:
          {
          {
          setState(101);
          _la = _input.LA(1);
          if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << NOTE_LETTERS) | (1L << OCTAVE) | (1L << OTHER_LETTERS) | (1L << REST_LETTERS) | (1L << NUMBER) | (1L << WHITESPACE))) != 0)) ) {
          _errHandler.recoverInline(this);
          } else {
            consume();
          }
          }
          }
          break;
        default:
          throw new NoViableAltException(this);
        }
        setState(104); 
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,13,_ctx);
      } while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static class TimeContext extends ParserRuleContext {
    public List<TerminalNode> NUMBER() { return getTokens(BodyParser.NUMBER); }
    public TerminalNode NUMBER(int i) {
      return getToken(BodyParser.NUMBER, i);
    }
    public TimeContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_time; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).enterTime(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof BodyListener ) ((BodyListener)listener).exitTime(this);
    }
  }

  public final TimeContext time() throws RecognitionException {
    TimeContext _localctx = new TimeContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_time);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(107);
      _la = _input.LA(1);
      if (_la==NUMBER) {
        {
        setState(106);
        match(NUMBER);
        }
      }

      setState(109);
      match(T__13);
      setState(111);
      _la = _input.LA(1);
      if (_la==NUMBER) {
        {
        setState(110);
        match(NUMBER);
        }
      }

      }
    }
    catch (RecognitionException re) {
      _localctx.exception = re;
      _errHandler.reportError(this, re);
      _errHandler.recover(this, re);
    }
    finally {
      exitRule();
    }
    return _localctx;
  }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33t\4\2\t\2\4\3"+
      "\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
      "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\6\2 \n\2\r\2\16\2!\3"+
      "\2\3\2\3\3\3\3\6\3(\n\3\r\3\16\3)\3\3\3\3\5\3.\n\3\3\3\5\3\61\n\3"+
      "\3\4\3\4\5\4\65\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6@\n\6\3"+
      "\7\3\7\5\7D\n\7\3\b\5\bG\n\b\3\b\3\b\5\bK\n\b\3\b\3\b\5\bO\n\b\3\t"+
      "\3\t\3\t\5\tT\n\t\3\n\3\n\6\nX\n\n\r\n\16\nY\3\n\3\n\3\13\3\13\6\13"+
      "`\n\13\r\13\16\13a\3\f\3\f\3\r\3\r\3\16\6\16i\n\16\r\16\16\16j\3\17"+
      "\5\17n\n\17\3\17\3\17\5\17r\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22"+
      "\24\26\30\32\34\2\5\3\2\7\f\3\2\r\16\5\2\17\17\22\23\25\30}\2\37\3"+
      "\2\2\2\4-\3\2\2\2\6\62\3\2\2\2\b\66\3\2\2\2\n?\3\2\2\2\fC\3\2\2\2"+
      "\16F\3\2\2\2\20P\3\2\2\2\22U\3\2\2\2\24]\3\2\2\2\26c\3\2\2\2\30e\3"+
      "\2\2\2\32h\3\2\2\2\34m\3\2\2\2\36 \5\4\3\2\37\36\3\2\2\2 !\3\2\2\2"+
      "!\37\3\2\2\2!\"\3\2\2\2\"#\3\2\2\2#$\7\2\2\3$\3\3\2\2\2%.\5\b\5\2"+
      "&(\5\n\6\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*.\3\2\2\2+.\5"+
      "\6\4\2,.\7\32\2\2-%\3\2\2\2-\'\3\2\2\2-+\3\2\2\2-,\3\2\2\2.\60\3\2"+
      "\2\2/\61\7\32\2\2\60/\3\2\2\2\60\61\3\2\2\2\61\5\3\2\2\2\62\64\7\3"+
      "\2\2\63\65\5\32\16\2\64\63\3\2\2\2\64\65\3\2\2\2\65\7\3\2\2\2\66\67"+
      "\7\4\2\2\678\5\32\16\28\t\3\2\2\29@\5\f\7\2:@\5\20\t\2;@\5\24\13\2"+
      "<@\5\26\f\2=@\5\30\r\2>@\7\30\2\2?9\3\2\2\2?:\3\2\2\2?;\3\2\2\2?<"+
      "\3\2\2\2?=\3\2\2\2?>\3\2\2\2@\13\3\2\2\2AD\5\16\b\2BD\5\22\n\2CA\3"+
      "\2\2\2CB\3\2\2\2D\r\3\2\2\2EG\7\21\2\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2"+
      "\2HJ\7\22\2\2IK\7\23\2\2JI\3\2\2\2JK\3\2\2\2KN\3\2\2\2LO\5\34\17\2"+
      "MO\7\27\2\2NL\3\2\2\2NM\3\2\2\2NO\3\2\2\2O\17\3\2\2\2PS\7\26\2\2Q"+
      "T\5\34\17\2RT\7\27\2\2SQ\3\2\2\2SR\3\2\2\2ST\3\2\2\2T\21\3\2\2\2U"+
      "W\7\5\2\2VX\5\16\b\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z[\3\2"+
      "\2\2[\\\7\6\2\2\\\23\3\2\2\2]_\7\24\2\2^`\5\f\7\2_^\3\2\2\2`a\3\2"+
      "\2\2a_\3\2\2\2ab\3\2\2\2b\25\3\2\2\2cd\t\2\2\2d\27\3\2\2\2ef\t\3\2"+
      "\2f\31\3\2\2\2gi\t\4\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2k"+
      "\33\3\2\2\2ln\7\27\2\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2oq\7\20\2\2pr"+
      "\7\27\2\2qp\3\2\2\2qr\3\2\2\2r\35\3\2\2\2\22!)-\60\64?CFJNSYajmq";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}