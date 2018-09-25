// Generated from Header.g4 by ANTLR 4.5.1

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
public class HeaderParser extends Parser {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
    T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, 
    T__16=17, T__17=18, T__18=19, KEY_SIG_LETTER=20, C=21, M=22, OTHER_LETTER=23, 
    NUMBER=24, NEWLINE=25, WHITESPACE=26;
  public static final int
    RULE_header = 0, RULE_index_field = 1, RULE_title_field = 2, RULE_comment = 3, 
    RULE_optional_fields = 4, RULE_composer_field = 5, RULE_length_field = 6, 
    RULE_meter_field = 7, RULE_tempo_field = 8, RULE_voice_field = 9, RULE_key_field = 10, 
    RULE_end_line = 11, RULE_key = 12, RULE_string = 13, RULE_length = 14, 
    RULE_meter = 15, RULE_tempo = 16;
  public static final String[] ruleNames = {
    "header", "index_field", "title_field", "comment", "optional_fields", 
    "composer_field", "length_field", "meter_field", "tempo_field", "voice_field", 
    "key_field", "end_line", "key", "string", "length", "meter", "tempo"
  };

  private static final String[] _LITERAL_NAMES = {
    null, "'X:'", "'T:'", "'%'", "'C:'", "'L:'", "'M:'", "'Q:'", "'V:'", 
    "'K:'", "'#'", "'_'", "'.'", "','", "'''", "'/'", "'-'", "':'", "'|'", 
    "'='", null, "'C'", "'m'"
  };
  private static final String[] _SYMBOLIC_NAMES = {
    null, null, null, null, null, null, null, null, null, null, null, null, 
    null, null, null, null, null, null, null, null, "KEY_SIG_LETTER", "C", 
    "M", "OTHER_LETTER", "NUMBER", "NEWLINE", "WHITESPACE"
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
  public String getGrammarFileName() { return "Header.g4"; }

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

  public HeaderParser(TokenStream input) {
    super(input);
    _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }
  public static class HeaderContext extends ParserRuleContext {
    public Index_fieldContext index_field() {
      return getRuleContext(Index_fieldContext.class,0);
    }
    public Title_fieldContext title_field() {
      return getRuleContext(Title_fieldContext.class,0);
    }
    public Key_fieldContext key_field() {
      return getRuleContext(Key_fieldContext.class,0);
    }
    public List<CommentContext> comment() {
      return getRuleContexts(CommentContext.class);
    }
    public CommentContext comment(int i) {
      return getRuleContext(CommentContext.class,i);
    }
    public List<Optional_fieldsContext> optional_fields() {
      return getRuleContexts(Optional_fieldsContext.class);
    }
    public Optional_fieldsContext optional_fields(int i) {
      return getRuleContext(Optional_fieldsContext.class,i);
    }
    public HeaderContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_header; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterHeader(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitHeader(this);
    }
  }

  public final HeaderContext header() throws RecognitionException {
    HeaderContext _localctx = new HeaderContext(_ctx, getState());
    enterRule(_localctx, 0, RULE_header);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(34);
      index_field();
      setState(38);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==T__2) {
        {
        {
        setState(35);
        comment();
        }
        }
        setState(40);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(41);
      title_field();
      setState(45);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) {
        {
        {
        setState(42);
        optional_fields();
        }
        }
        setState(47);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(48);
      key_field();
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

  public static class Index_fieldContext extends ParserRuleContext {
    public TerminalNode NUMBER() { return getToken(HeaderParser.NUMBER, 0); }
    public End_lineContext end_line() {
      return getRuleContext(End_lineContext.class,0);
    }
    public TerminalNode WHITESPACE() { return getToken(HeaderParser.WHITESPACE, 0); }
    public Index_fieldContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_index_field; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterIndex_field(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitIndex_field(this);
    }
  }

  public final Index_fieldContext index_field() throws RecognitionException {
    Index_fieldContext _localctx = new Index_fieldContext(_ctx, getState());
    enterRule(_localctx, 2, RULE_index_field);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(50);
      match(T__0);
      setState(52);
      _la = _input.LA(1);
      if (_la==WHITESPACE) {
        {
        setState(51);
        match(WHITESPACE);
        }
      }

      setState(54);
      match(NUMBER);
      setState(55);
      end_line();
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

  public static class Title_fieldContext extends ParserRuleContext {
    public StringContext string() {
      return getRuleContext(StringContext.class,0);
    }
    public End_lineContext end_line() {
      return getRuleContext(End_lineContext.class,0);
    }
    public TerminalNode WHITESPACE() { return getToken(HeaderParser.WHITESPACE, 0); }
    public Title_fieldContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_title_field; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterTitle_field(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitTitle_field(this);
    }
  }

  public final Title_fieldContext title_field() throws RecognitionException {
    Title_fieldContext _localctx = new Title_fieldContext(_ctx, getState());
    enterRule(_localctx, 4, RULE_title_field);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(57);
      match(T__1);
      setState(59);
      switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
      case 1:
        {
        setState(58);
        match(WHITESPACE);
        }
        break;
      }
      setState(61);
      string();
      setState(62);
      end_line();
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
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public TerminalNode WHITESPACE() { return getToken(HeaderParser.WHITESPACE, 0); }
    public CommentContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_comment; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterComment(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitComment(this);
    }
  }

  public final CommentContext comment() throws RecognitionException {
    CommentContext _localctx = new CommentContext(_ctx, getState());
    enterRule(_localctx, 6, RULE_comment);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(64);
      match(T__2);
      setState(66);
      switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
      case 1:
        {
        setState(65);
        match(WHITESPACE);
        }
        break;
      }
      setState(68);
      string();
      setState(69);
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

  public static class Optional_fieldsContext extends ParserRuleContext {
    public Composer_fieldContext composer_field() {
      return getRuleContext(Composer_fieldContext.class,0);
    }
    public Length_fieldContext length_field() {
      return getRuleContext(Length_fieldContext.class,0);
    }
    public Meter_fieldContext meter_field() {
      return getRuleContext(Meter_fieldContext.class,0);
    }
    public Tempo_fieldContext tempo_field() {
      return getRuleContext(Tempo_fieldContext.class,0);
    }
    public Voice_fieldContext voice_field() {
      return getRuleContext(Voice_fieldContext.class,0);
    }
    public CommentContext comment() {
      return getRuleContext(CommentContext.class,0);
    }
    public Optional_fieldsContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_optional_fields; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterOptional_fields(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitOptional_fields(this);
    }
  }

  public final Optional_fieldsContext optional_fields() throws RecognitionException {
    Optional_fieldsContext _localctx = new Optional_fieldsContext(_ctx, getState());
    enterRule(_localctx, 8, RULE_optional_fields);
    try {
      setState(77);
      switch (_input.LA(1)) {
      case T__3:
        enterOuterAlt(_localctx, 1);
        {
        setState(71);
        composer_field();
        }
        break;
      case T__4:
        enterOuterAlt(_localctx, 2);
        {
        setState(72);
        length_field();
        }
        break;
      case T__5:
        enterOuterAlt(_localctx, 3);
        {
        setState(73);
        meter_field();
        }
        break;
      case T__6:
        enterOuterAlt(_localctx, 4);
        {
        setState(74);
        tempo_field();
        }
        break;
      case T__7:
        enterOuterAlt(_localctx, 5);
        {
        setState(75);
        voice_field();
        }
        break;
      case T__2:
        enterOuterAlt(_localctx, 6);
        {
        setState(76);
        comment();
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

  public static class Composer_fieldContext extends ParserRuleContext {
    public StringContext string() {
      return getRuleContext(StringContext.class,0);
    }
    public End_lineContext end_line() {
      return getRuleContext(End_lineContext.class,0);
    }
    public TerminalNode WHITESPACE() { return getToken(HeaderParser.WHITESPACE, 0); }
    public Composer_fieldContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_composer_field; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterComposer_field(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitComposer_field(this);
    }
  }

  public final Composer_fieldContext composer_field() throws RecognitionException {
    Composer_fieldContext _localctx = new Composer_fieldContext(_ctx, getState());
    enterRule(_localctx, 10, RULE_composer_field);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(79);
      match(T__3);
      setState(81);
      switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
      case 1:
        {
        setState(80);
        match(WHITESPACE);
        }
        break;
      }
      setState(83);
      string();
      setState(84);
      end_line();
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

  public static class Length_fieldContext extends ParserRuleContext {
    public LengthContext length() {
      return getRuleContext(LengthContext.class,0);
    }
    public End_lineContext end_line() {
      return getRuleContext(End_lineContext.class,0);
    }
    public TerminalNode WHITESPACE() { return getToken(HeaderParser.WHITESPACE, 0); }
    public Length_fieldContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_length_field; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterLength_field(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitLength_field(this);
    }
  }

  public final Length_fieldContext length_field() throws RecognitionException {
    Length_fieldContext _localctx = new Length_fieldContext(_ctx, getState());
    enterRule(_localctx, 12, RULE_length_field);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(86);
      match(T__4);
      setState(88);
      _la = _input.LA(1);
      if (_la==WHITESPACE) {
        {
        setState(87);
        match(WHITESPACE);
        }
      }

      setState(90);
      length();
      setState(91);
      end_line();
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

  public static class Meter_fieldContext extends ParserRuleContext {
    public MeterContext meter() {
      return getRuleContext(MeterContext.class,0);
    }
    public End_lineContext end_line() {
      return getRuleContext(End_lineContext.class,0);
    }
    public TerminalNode WHITESPACE() { return getToken(HeaderParser.WHITESPACE, 0); }
    public Meter_fieldContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_meter_field; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterMeter_field(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitMeter_field(this);
    }
  }

  public final Meter_fieldContext meter_field() throws RecognitionException {
    Meter_fieldContext _localctx = new Meter_fieldContext(_ctx, getState());
    enterRule(_localctx, 14, RULE_meter_field);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(93);
      match(T__5);
      setState(95);
      _la = _input.LA(1);
      if (_la==WHITESPACE) {
        {
        setState(94);
        match(WHITESPACE);
        }
      }

      setState(97);
      meter();
      setState(98);
      end_line();
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

  public static class Tempo_fieldContext extends ParserRuleContext {
    public TempoContext tempo() {
      return getRuleContext(TempoContext.class,0);
    }
    public End_lineContext end_line() {
      return getRuleContext(End_lineContext.class,0);
    }
    public TerminalNode WHITESPACE() { return getToken(HeaderParser.WHITESPACE, 0); }
    public Tempo_fieldContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_tempo_field; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterTempo_field(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitTempo_field(this);
    }
  }

  public final Tempo_fieldContext tempo_field() throws RecognitionException {
    Tempo_fieldContext _localctx = new Tempo_fieldContext(_ctx, getState());
    enterRule(_localctx, 16, RULE_tempo_field);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(100);
      match(T__6);
      setState(102);
      _la = _input.LA(1);
      if (_la==WHITESPACE) {
        {
        setState(101);
        match(WHITESPACE);
        }
      }

      setState(104);
      tempo();
      setState(105);
      end_line();
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

  public static class Voice_fieldContext extends ParserRuleContext {
    public StringContext string() {
      return getRuleContext(StringContext.class,0);
    }
    public End_lineContext end_line() {
      return getRuleContext(End_lineContext.class,0);
    }
    public TerminalNode WHITESPACE() { return getToken(HeaderParser.WHITESPACE, 0); }
    public Voice_fieldContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_voice_field; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterVoice_field(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitVoice_field(this);
    }
  }

  public final Voice_fieldContext voice_field() throws RecognitionException {
    Voice_fieldContext _localctx = new Voice_fieldContext(_ctx, getState());
    enterRule(_localctx, 18, RULE_voice_field);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(107);
      match(T__7);
      setState(109);
      switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
      case 1:
        {
        setState(108);
        match(WHITESPACE);
        }
        break;
      }
      setState(111);
      string();
      setState(112);
      end_line();
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

  public static class Key_fieldContext extends ParserRuleContext {
    public KeyContext key() {
      return getRuleContext(KeyContext.class,0);
    }
    public TerminalNode EOF() { return getToken(HeaderParser.EOF, 0); }
    public TerminalNode WHITESPACE() { return getToken(HeaderParser.WHITESPACE, 0); }
    public Key_fieldContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_key_field; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterKey_field(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitKey_field(this);
    }
  }

  public final Key_fieldContext key_field() throws RecognitionException {
    Key_fieldContext _localctx = new Key_fieldContext(_ctx, getState());
    enterRule(_localctx, 20, RULE_key_field);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(114);
      match(T__8);
      setState(116);
      _la = _input.LA(1);
      if (_la==WHITESPACE) {
        {
        setState(115);
        match(WHITESPACE);
        }
      }

      setState(118);
      key();
      setState(119);
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

  public static class End_lineContext extends ParserRuleContext {
    public TerminalNode NEWLINE() { return getToken(HeaderParser.NEWLINE, 0); }
    public CommentContext comment() {
      return getRuleContext(CommentContext.class,0);
    }
    public End_lineContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_end_line; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterEnd_line(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitEnd_line(this);
    }
  }

  public final End_lineContext end_line() throws RecognitionException {
    End_lineContext _localctx = new End_lineContext(_ctx, getState());
    enterRule(_localctx, 22, RULE_end_line);
    try {
      setState(123);
      switch (_input.LA(1)) {
      case NEWLINE:
        enterOuterAlt(_localctx, 1);
        {
        setState(121);
        match(NEWLINE);
        }
        break;
      case T__2:
        enterOuterAlt(_localctx, 2);
        {
        setState(122);
        comment();
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

  public static class KeyContext extends ParserRuleContext {
    public TerminalNode KEY_SIG_LETTER() { return getToken(HeaderParser.KEY_SIG_LETTER, 0); }
    public TerminalNode C() { return getToken(HeaderParser.C, 0); }
    public TerminalNode M() { return getToken(HeaderParser.M, 0); }
    public KeyContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_key; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterKey(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitKey(this);
    }
  }

  public final KeyContext key() throws RecognitionException {
    KeyContext _localctx = new KeyContext(_ctx, getState());
    enterRule(_localctx, 24, RULE_key);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(125);
      _la = _input.LA(1);
      if ( !(_la==KEY_SIG_LETTER || _la==C) ) {
      _errHandler.recoverInline(this);
      } else {
        consume();
      }
      setState(127);
      _la = _input.LA(1);
      if (_la==T__9 || _la==T__10) {
        {
        setState(126);
        _la = _input.LA(1);
        if ( !(_la==T__9 || _la==T__10) ) {
        _errHandler.recoverInline(this);
        } else {
          consume();
        }
        }
      }

      setState(130);
      _la = _input.LA(1);
      if (_la==M) {
        {
        setState(129);
        match(M);
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

  public static class StringContext extends ParserRuleContext {
    public List<TerminalNode> KEY_SIG_LETTER() { return getTokens(HeaderParser.KEY_SIG_LETTER); }
    public TerminalNode KEY_SIG_LETTER(int i) {
      return getToken(HeaderParser.KEY_SIG_LETTER, i);
    }
    public List<TerminalNode> C() { return getTokens(HeaderParser.C); }
    public TerminalNode C(int i) {
      return getToken(HeaderParser.C, i);
    }
    public List<TerminalNode> NUMBER() { return getTokens(HeaderParser.NUMBER); }
    public TerminalNode NUMBER(int i) {
      return getToken(HeaderParser.NUMBER, i);
    }
    public List<TerminalNode> M() { return getTokens(HeaderParser.M); }
    public TerminalNode M(int i) {
      return getToken(HeaderParser.M, i);
    }
    public List<TerminalNode> OTHER_LETTER() { return getTokens(HeaderParser.OTHER_LETTER); }
    public TerminalNode OTHER_LETTER(int i) {
      return getToken(HeaderParser.OTHER_LETTER, i);
    }
    public List<TerminalNode> WHITESPACE() { return getTokens(HeaderParser.WHITESPACE); }
    public TerminalNode WHITESPACE(int i) {
      return getToken(HeaderParser.WHITESPACE, i);
    }
    public StringContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_string; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterString(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitString(this);
    }
  }

  public final StringContext string() throws RecognitionException {
    StringContext _localctx = new StringContext(_ctx, getState());
    enterRule(_localctx, 26, RULE_string);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(133); 
      _errHandler.sync(this);
      _la = _input.LA(1);
      do {
        {
        {
        setState(132);
        _la = _input.LA(1);
        if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << KEY_SIG_LETTER) | (1L << C) | (1L << M) | (1L << OTHER_LETTER) | (1L << NUMBER) | (1L << WHITESPACE))) != 0)) ) {
        _errHandler.recoverInline(this);
        } else {
          consume();
        }
        }
        }
        setState(135); 
        _errHandler.sync(this);
        _la = _input.LA(1);
      } while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << KEY_SIG_LETTER) | (1L << C) | (1L << M) | (1L << OTHER_LETTER) | (1L << NUMBER) | (1L << WHITESPACE))) != 0) );
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

  public static class LengthContext extends ParserRuleContext {
    public List<TerminalNode> NUMBER() { return getTokens(HeaderParser.NUMBER); }
    public TerminalNode NUMBER(int i) {
      return getToken(HeaderParser.NUMBER, i);
    }
    public LengthContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_length; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterLength(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitLength(this);
    }
  }

  public final LengthContext length() throws RecognitionException {
    LengthContext _localctx = new LengthContext(_ctx, getState());
    enterRule(_localctx, 28, RULE_length);
    int _la;
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(140);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==NUMBER) {
        {
        {
        setState(137);
        match(NUMBER);
        }
        }
        setState(142);
        _errHandler.sync(this);
        _la = _input.LA(1);
      }
      setState(143);
      match(T__14);
      setState(147);
      _errHandler.sync(this);
      _la = _input.LA(1);
      while (_la==NUMBER) {
        {
        {
        setState(144);
        match(NUMBER);
        }
        }
        setState(149);
        _errHandler.sync(this);
        _la = _input.LA(1);
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

  public static class MeterContext extends ParserRuleContext {
    public List<TerminalNode> NUMBER() { return getTokens(HeaderParser.NUMBER); }
    public TerminalNode NUMBER(int i) {
      return getToken(HeaderParser.NUMBER, i);
    }
    public TerminalNode C() { return getToken(HeaderParser.C, 0); }
    public MeterContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_meter; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterMeter(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitMeter(this);
    }
  }

  public final MeterContext meter() throws RecognitionException {
    MeterContext _localctx = new MeterContext(_ctx, getState());
    enterRule(_localctx, 30, RULE_meter);
    try {
      setState(156);
      switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
      case 1:
        enterOuterAlt(_localctx, 1);
        {
        {
        setState(150);
        match(NUMBER);
        setState(151);
        match(T__14);
        setState(152);
        match(NUMBER);
        }
        }
        break;
      case 2:
        enterOuterAlt(_localctx, 2);
        {
        setState(153);
        match(C);
        }
        break;
      case 3:
        enterOuterAlt(_localctx, 3);
        {
        setState(154);
        match(C);
        setState(155);
        match(T__17);
        }
        break;
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

  public static class TempoContext extends ParserRuleContext {
    public TerminalNode NUMBER() { return getToken(HeaderParser.NUMBER, 0); }
    public MeterContext meter() {
      return getRuleContext(MeterContext.class,0);
    }
    public TempoContext(ParserRuleContext parent, int invokingState) {
      super(parent, invokingState);
    }
    @Override public int getRuleIndex() { return RULE_tempo; }
    @Override
    public void enterRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).enterTempo(this);
    }
    @Override
    public void exitRule(ParseTreeListener listener) {
      if ( listener instanceof HeaderListener ) ((HeaderListener)listener).exitTempo(this);
    }
  }

  public final TempoContext tempo() throws RecognitionException {
    TempoContext _localctx = new TempoContext(_ctx, getState());
    enterRule(_localctx, 32, RULE_tempo);
    try {
      enterOuterAlt(_localctx, 1);
      {
      setState(161);
      switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
      case 1:
        {
        setState(158);
        meter();
        setState(159);
        match(T__18);
        }
        break;
      }
      setState(163);
      match(NUMBER);
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
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\34\u00a8\4\2\t"+
      "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
      "\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
      "\4\22\t\22\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\7\2.\n\2\f\2\16"+
      "\2\61\13\2\3\2\3\2\3\3\3\3\5\3\67\n\3\3\3\3\3\3\3\3\4\3\4\5\4>\n\4"+
      "\3\4\3\4\3\4\3\5\3\5\5\5E\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
      "\5\6P\n\6\3\7\3\7\5\7T\n\7\3\7\3\7\3\7\3\b\3\b\5\b[\n\b\3\b\3\b\3"+
      "\b\3\t\3\t\5\tb\n\t\3\t\3\t\3\t\3\n\3\n\5\ni\n\n\3\n\3\n\3\n\3\13"+
      "\3\13\5\13p\n\13\3\13\3\13\3\13\3\f\3\f\5\fw\n\f\3\f\3\f\3\f\3\r\3"+
      "\r\5\r~\n\r\3\16\3\16\5\16\u0082\n\16\3\16\5\16\u0085\n\16\3\17\6"+
      "\17\u0088\n\17\r\17\16\17\u0089\3\20\7\20\u008d\n\20\f\20\16\20\u0090"+
      "\13\20\3\20\3\20\7\20\u0094\n\20\f\20\16\20\u0097\13\20\3\21\3\21"+
      "\3\21\3\21\3\21\3\21\5\21\u009f\n\21\3\22\3\22\3\22\5\22\u00a4\n\22"+
      "\3\22\3\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2"+
      "\5\3\2\26\27\3\2\f\r\5\2\r\23\26\32\34\34\u00af\2$\3\2\2\2\4\64\3"+
      "\2\2\2\6;\3\2\2\2\bB\3\2\2\2\nO\3\2\2\2\fQ\3\2\2\2\16X\3\2\2\2\20"+
      "_\3\2\2\2\22f\3\2\2\2\24m\3\2\2\2\26t\3\2\2\2\30}\3\2\2\2\32\177\3"+
      "\2\2\2\34\u0087\3\2\2\2\36\u008e\3\2\2\2 \u009e\3\2\2\2\"\u00a3\3"+
      "\2\2\2$(\5\4\3\2%\'\5\b\5\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2"+
      "\2)+\3\2\2\2*(\3\2\2\2+/\5\6\4\2,.\5\n\6\2-,\3\2\2\2.\61\3\2\2\2/"+
      "-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\5\26\f\2\63"+
      "\3\3\2\2\2\64\66\7\3\2\2\65\67\7\34\2\2\66\65\3\2\2\2\66\67\3\2\2"+
      "\2\678\3\2\2\289\7\32\2\29:\5\30\r\2:\5\3\2\2\2;=\7\4\2\2<>\7\34\2"+
      "\2=<\3\2\2\2=>\3\2\2\2>?\3\2\2\2?@\5\34\17\2@A\5\30\r\2A\7\3\2\2\2"+
      "BD\7\5\2\2CE\7\34\2\2DC\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\5\34\17\2GH"+
      "\7\33\2\2H\t\3\2\2\2IP\5\f\7\2JP\5\16\b\2KP\5\20\t\2LP\5\22\n\2MP"+
      "\5\24\13\2NP\5\b\5\2OI\3\2\2\2OJ\3\2\2\2OK\3\2\2\2OL\3\2\2\2OM\3\2"+
      "\2\2ON\3\2\2\2P\13\3\2\2\2QS\7\6\2\2RT\7\34\2\2SR\3\2\2\2ST\3\2\2"+
      "\2TU\3\2\2\2UV\5\34\17\2VW\5\30\r\2W\r\3\2\2\2XZ\7\7\2\2Y[\7\34\2"+
      "\2ZY\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\5\36\20\2]^\5\30\r\2^\17\3\2"+
      "\2\2_a\7\b\2\2`b\7\34\2\2a`\3\2\2\2ab\3\2\2\2bc\3\2\2\2cd\5 \21\2"+
      "de\5\30\r\2e\21\3\2\2\2fh\7\t\2\2gi\7\34\2\2hg\3\2\2\2hi\3\2\2\2i"+
      "j\3\2\2\2jk\5\"\22\2kl\5\30\r\2l\23\3\2\2\2mo\7\n\2\2np\7\34\2\2o"+
      "n\3\2\2\2op\3\2\2\2pq\3\2\2\2qr\5\34\17\2rs\5\30\r\2s\25\3\2\2\2t"+
      "v\7\13\2\2uw\7\34\2\2vu\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\5\32\16\2yz"+
      "\7\2\2\3z\27\3\2\2\2{~\7\33\2\2|~\5\b\5\2}{\3\2\2\2}|\3\2\2\2~\31"+
      "\3\2\2\2\177\u0081\t\2\2\2\u0080\u0082\t\3\2\2\u0081\u0080\3\2\2\2"+
      "\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0085\7\30\2\2\u0084"+
      "\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\33\3\2\2\2\u0086\u0088\t"+
      "\4\2\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2\2\2"+
      "\u0089\u008a\3\2\2\2\u008a\35\3\2\2\2\u008b\u008d\7\32\2\2\u008c\u008b"+
      "\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2"+
      "\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0095\7\21\2\2\u0092"+
      "\u0094\7\32\2\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093"+
      "\3\2\2\2\u0095\u0096\3\2\2\2\u0096\37\3\2\2\2\u0097\u0095\3\2\2\2"+
      "\u0098\u0099\7\32\2\2\u0099\u009a\7\21\2\2\u009a\u009f\7\32\2\2\u009b"+
      "\u009f\7\27\2\2\u009c\u009d\7\27\2\2\u009d\u009f\7\24\2\2\u009e\u0098"+
      "\3\2\2\2\u009e\u009b\3\2\2\2\u009e\u009c\3\2\2\2\u009f!\3\2\2\2\u00a0"+
      "\u00a1\5 \21\2\u00a1\u00a2\7\25\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a0"+
      "\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\7\32"+
      "\2\2\u00a6#\3\2\2\2\26(/\66=DOSZahov}\u0081\u0084\u0089\u008e\u0095"+
      "\u009e\u00a3";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}