// Generated from SimpleBody.g4 by ANTLR 4.5.1

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
public class SimpleBodyParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
    T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, OTHER_LETTERS=15, NOTE_LETTERS=16, 
    OCTAVE=17, TIME=18, TUPLET_NUMBER=19, NUMBER=20, WHITESPACE=21, END_BAR=22, 
    NEWLINE=23, SPACES=24;
  public static final int
    RULE_body = 0, RULE_body_line = 1, RULE_comment = 2, RULE_element = 3, 
    RULE_string = 4, RULE_note_element = 5, RULE_note = 6, RULE_rest = 7, 
    RULE_chord = 8, RULE_tuplet = 9, RULE_barline = 10;
  public static final String[] ruleNames = {
    "body", "body_line", "comment", "element", "string", "note_element", 
    "note", "rest", "chord", "tuplet", "barline"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'%'", "'.'", "','", "'''", "'z'", "'['", "']'", "'('", "'|'", 
    "'||'", "'[|'", "'|]'", "':|'", "'|:'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, null, null, null, null, null, null, null, 
    null, null, null, "OTHER_LETTERS", "NOTE_LETTERS", "OCTAVE", "TIME", 
    "TUPLET_NUMBER", "NUMBER", "WHITESPACE", "END_BAR", "NEWLINE", "SPACES"
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
  public String getGrammarFileName() { return "SimpleBody.g4"; }

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

  public SimpleBodyParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class BodyContext extends ParserRuleContext {
    public TerminalNode EOF() { return getToken(SimpleBodyParser.EOF, 0); }
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
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).enterBody(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).exitBody(this);
    }
  }

  public final BodyContext body() throws RecognitionException {
    BodyContext _localctx = new BodyContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_body);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(23); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(22);
        body_line();
        }
        }
        setState(25); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << NOTE_LETTERS) | (1L << WHITESPACE))) != 0) );
      setState(27);
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
    public List<ElementContext> element() {
      return getRuleContexts(ElementContext.class);
    }
    public ElementContext element(int i) {
      return getRuleContext(ElementContext.class,i);
    }
    public List<CommentContext> comment() {
      return getRuleContexts(CommentContext.class);
    }
    public CommentContext comment(int i) {
      return getRuleContext(CommentContext.class,i);
    }
    public Body_lineContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_body_line; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).enterBody_line(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).exitBody_line(this);
    }
  }

  public final Body_lineContext body_line() throws RecognitionException {
    Body_lineContext _localctx = new Body_lineContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_body_line);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(31); 
      _errHandler.sync(this);
      _alt = 1;
      do {
        switch (_alt) {
        case 1:
          {
          setState(31);
          switch (_input.LA(1)) {
          case T__4:
          case T__5:
          case T__7:
          case T__8:
          case T__9:
          case T__10:
          case T__11:
          case T__12:
          case T__13:
          case NOTE_LETTERS:
          case WHITESPACE:
            {
            setState(29);
            element();
            }
            break;
          case T__0:
            {
            setState(30);
            comment();
            }
            break;
          default:
            throw new NoViableAltException(this);
          }
          }
          break;
        default:
          throw new NoViableAltException(this);
        }
        setState(33); 
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

  public static class CommentContext extends ParserRuleContext {
    public StringContext string() {
      return getRuleContext(StringContext.class,0);
    }
    public TerminalNode NEWLINE() { return getToken(SimpleBodyParser.NEWLINE, 0); }
    public CommentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_comment; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).enterComment(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).exitComment(this);
    }
  }

  public final CommentContext comment() throws RecognitionException {
    CommentContext _localctx = new CommentContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_comment);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(35);
      match(T__0);
      setState(36);
      string();
      setState(37);
      match(NEWLINE);
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
    public TerminalNode WHITESPACE() { return getToken(SimpleBodyParser.WHITESPACE, 0); }
    public ElementContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_element; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).enterElement(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).exitElement(this);
    }
  }

  public final ElementContext element() throws RecognitionException {
    ElementContext _localctx = new ElementContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_element);
    try {
      setState(44);
      switch (_input.LA(1)) {
      case T__5:
      case NOTE_LETTERS:
        enterOuterAlt(_localctx, 1);
        {
        setState(39);
        note_element();
        }
        break;
      case T__4:
        enterOuterAlt(_localctx, 2);
        {
        setState(40);
        rest();
        }
        break;
      case T__7:
        enterOuterAlt(_localctx, 3);
        {
        setState(41);
        tuplet();
        }
        break;
      case T__8:
      case T__9:
      case T__10:
      case T__11:
      case T__12:
      case T__13:
        enterOuterAlt(_localctx, 4);
        {
        setState(42);
        barline();
        }
        break;
      case WHITESPACE:
        enterOuterAlt(_localctx, 5);
        {
        setState(43);
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

  public static class StringContext extends ParserRuleContext {
    public List<TerminalNode> NOTE_LETTERS() { return getTokens(SimpleBodyParser.NOTE_LETTERS); }
    public TerminalNode NOTE_LETTERS(int i) {
      return getToken(SimpleBodyParser.NOTE_LETTERS, i);
    }
    public List<TerminalNode> OTHER_LETTERS() { return getTokens(SimpleBodyParser.OTHER_LETTERS); }
    public TerminalNode OTHER_LETTERS(int i) {
      return getToken(SimpleBodyParser.OTHER_LETTERS, i);
    }
    public List<TerminalNode> WHITESPACE() { return getTokens(SimpleBodyParser.WHITESPACE); }
    public TerminalNode WHITESPACE(int i) {
      return getToken(SimpleBodyParser.WHITESPACE, i);
    }
    public StringContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_string; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).enterString(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).exitString(this);
    }
  }

  public final StringContext string() throws RecognitionException {
    StringContext _localctx = new StringContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_string);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(47); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(46);
        _la = _input.LA(1);
        if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << OTHER_LETTERS) | (1L << NOTE_LETTERS) | (1L << WHITESPACE))) != 0)) ) {
        _errHandler.recoverInline(this);
        } else {
          consume();
        }
        }
        }
        setState(49); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << OTHER_LETTERS) | (1L << NOTE_LETTERS) | (1L << WHITESPACE))) != 0) );
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
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).enterNote_element(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).exitNote_element(this);
    }
  }

  public final Note_elementContext note_element() throws RecognitionException {
    Note_elementContext _localctx = new Note_elementContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_note_element);
    try {
      setState(53);
      switch (_input.LA(1)) {
      case NOTE_LETTERS:
        enterOuterAlt(_localctx, 1);
        {
        setState(51);
        note();
        }
        break;
      case T__5:
        enterOuterAlt(_localctx, 2);
        {
        setState(52);
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
    public TerminalNode NOTE_LETTERS() { return getToken(SimpleBodyParser.NOTE_LETTERS, 0); }
    public TerminalNode OCTAVE() { return getToken(SimpleBodyParser.OCTAVE, 0); }
    public TerminalNode TIME() { return getToken(SimpleBodyParser.TIME, 0); }
    public NoteContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_note; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).enterNote(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).exitNote(this);
    }
  }

  public final NoteContext note() throws RecognitionException {
    NoteContext _localctx = new NoteContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_note);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(55);
      match(NOTE_LETTERS);
      setState(57);
      _la = _input.LA(1);
      if (_la==OCTAVE) {
        {
        setState(56);
        match(OCTAVE);
        }
      }

      setState(60);
      _la = _input.LA(1);
      if (_la==TIME) {
        {
        setState(59);
        match(TIME);
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

  public static class RestContext extends ParserRuleContext {
    public TerminalNode TIME() { return getToken(SimpleBodyParser.TIME, 0); }
    public RestContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_rest; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).enterRest(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).exitRest(this);
    }
  }

  public final RestContext rest() throws RecognitionException {
    RestContext _localctx = new RestContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_rest);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(62);
      match(T__4);
      setState(64);
      _la = _input.LA(1);
      if (_la==TIME) {
        {
        setState(63);
        match(TIME);
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
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).enterChord(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).exitChord(this);
    }
  }

  public final ChordContext chord() throws RecognitionException {
    ChordContext _localctx = new ChordContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_chord);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(66);
      match(T__5);
      setState(68); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(67);
        note();
        }
        }
        setState(70); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( _la==NOTE_LETTERS );
      setState(72);
      match(T__6);
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
    public TerminalNode TUPLET_NUMBER() { return getToken(SimpleBodyParser.TUPLET_NUMBER, 0); }
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
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).enterTuplet(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).exitTuplet(this);
    }
  }

  public final TupletContext tuplet() throws RecognitionException {
    TupletContext _localctx = new TupletContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_tuplet);
    try {
      int _alt;
      enterOuterAlt(_localctx, 1);
      {
      setState(74);
      match(T__7);
      setState(75);
      match(TUPLET_NUMBER);
      setState(77); 
      _errHandler.sync(this);
      _alt = 1;
      do {
        switch (_alt) {
        case 1:
          {
          {
          setState(76);
          note_element();
          }
          }
          break;
        default:
          throw new NoViableAltException(this);
        }
        setState(79); 
        _errHandler.sync(this);
        _alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).enterBarline(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof SimpleBodyListener ) ((SimpleBodyListener)listener).exitBarline(this);
    }
  }

  public final BarlineContext barline() throws RecognitionException {
    BarlineContext _localctx = new BarlineContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_barline);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(81);
      _la = _input.LA(1);
      if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
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

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32V\4\2\t\2\4\3"+
      "\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
      "\t\13\4\f\t\f\3\2\6\2\32\n\2\r\2\16\2\33\3\2\3\2\3\3\3\3\6\3\"\n\3"+
      "\r\3\16\3#\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5/\n\5\3\6\6\6\62"+
      "\n\6\r\6\16\6\63\3\7\3\7\5\78\n\7\3\b\3\b\5\b<\n\b\3\b\5\b?\n\b\3"+
      "\t\3\t\5\tC\n\t\3\n\3\n\6\nG\n\n\r\n\16\nH\3\n\3\n\3\13\3\13\3\13"+
      "\6\13P\n\13\r\13\16\13Q\3\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24"+
      "\26\2\4\5\2\4\6\21\22\27\27\3\2\13\20X\2\31\3\2\2\2\4!\3\2\2\2\6%"+
      "\3\2\2\2\b.\3\2\2\2\n\61\3\2\2\2\f\67\3\2\2\2\169\3\2\2\2\20@\3\2"+
      "\2\2\22D\3\2\2\2\24L\3\2\2\2\26S\3\2\2\2\30\32\5\4\3\2\31\30\3\2\2"+
      "\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36\7"+
      "\2\2\3\36\3\3\2\2\2\37\"\5\b\5\2 \"\5\6\4\2!\37\3\2\2\2! \3\2\2\2"+
      "\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\5\3\2\2\2%&\7\3\2\2&\'\5\n\6\2\'"+
      "(\7\31\2\2(\7\3\2\2\2)/\5\f\7\2*/\5\20\t\2+/\5\24\13\2,/\5\26\f\2"+
      "-/\7\27\2\2.)\3\2\2\2.*\3\2\2\2.+\3\2\2\2.,\3\2\2\2.-\3\2\2\2/\t\3"+
      "\2\2\2\60\62\t\2\2\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63"+
      "\64\3\2\2\2\64\13\3\2\2\2\658\5\16\b\2\668\5\22\n\2\67\65\3\2\2\2"+
      "\67\66\3\2\2\28\r\3\2\2\29;\7\22\2\2:<\7\23\2\2;:\3\2\2\2;<\3\2\2"+
      "\2<>\3\2\2\2=?\7\24\2\2>=\3\2\2\2>?\3\2\2\2?\17\3\2\2\2@B\7\7\2\2"+
      "AC\7\24\2\2BA\3\2\2\2BC\3\2\2\2C\21\3\2\2\2DF\7\b\2\2EG\5\16\b\2F"+
      "E\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\7\t\2\2K\23\3"+
      "\2\2\2LM\7\n\2\2MO\7\25\2\2NP\5\f\7\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2"+
      "\2QR\3\2\2\2R\25\3\2\2\2ST\t\3\2\2T\27\3\2\2\2\r\33!#.\63\67;>BHQ";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}