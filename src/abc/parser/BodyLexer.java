// Generated from Body.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BodyLexer extends Lexer {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
    T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ACCIDENTAL=15, NOTE_LETTERS=16, 
    OCTAVE=17, TUPLET_START=18, OTHER_LETTERS=19, REST_LETTERS=20, NUMBER=21, 
    WHITESPACE=22, END_BAR=23, NEWLINE=24, SPACES=25;
  public static String[] modeNames = {
    "DEFAULT_MODE"
  };

  public static final String[] ruleNames = {
    "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
    "T__9", "T__10", "T__11", "T__12", "T__13", "ACCIDENTAL", "NOTE_LETTERS", 
    "OCTAVE", "TUPLET_START", "OTHER_LETTERS", "REST_LETTERS", "NUMBER", 
    "WHITESPACE", "END_BAR", "NEWLINE", "SPACES"
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


  public BodyLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }

  @Override
  public String getGrammarFileName() { return "Body.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public String[] getModeNames() { return modeNames; }

  @Override
  public ATN getATN() { return _ATN; }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u0093\b\1\4"+
      "\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
      "\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21"+
      "\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
      "\4\30\t\30\4\31\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5"+
      "\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13"+
      "\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3"+
      "\20\3\20\3\20\3\20\5\20a\n\20\3\21\3\21\3\22\6\22f\n\22\r\22\16\22"+
      "g\3\23\3\23\3\23\3\23\3\23\3\23\5\23p\n\23\3\24\6\24s\n\24\r\24\16"+
      "\24t\3\25\3\25\3\26\6\26z\n\26\r\26\16\26{\3\27\6\27\177\n\27\r\27"+
      "\16\27\u0080\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0089\n\30\3\31\3"+
      "\31\3\32\6\32\u008e\n\32\r\32\16\32\u008f\3\32\3\32\2\2\33\3\3\5\4"+
      "\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
      "!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\t\4\2CIci\4\2))"+
      "..\4\2J[j{\4\2\\\\||\3\2\62;\3\2\"\"\5\2\f\f\17\17AA\u009f\2\3\3\2"+
      "\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
      "\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
      "\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2"+
      "#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
      "\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2\5\67\3\2\2\2\7"+
      ":\3\2\2\2\t<\3\2\2\2\13>\3\2\2\2\r@\3\2\2\2\17C\3\2\2\2\21F\3\2\2"+
      "\2\23I\3\2\2\2\25L\3\2\2\2\27O\3\2\2\2\31R\3\2\2\2\33U\3\2\2\2\35"+
      "W\3\2\2\2\37`\3\2\2\2!b\3\2\2\2#e\3\2\2\2%o\3\2\2\2\'r\3\2\2\2)v\3"+
      "\2\2\2+y\3\2\2\2-~\3\2\2\2/\u0088\3\2\2\2\61\u008a\3\2\2\2\63\u008d"+
      "\3\2\2\2\65\66\7\'\2\2\66\4\3\2\2\2\678\7X\2\289\7<\2\29\6\3\2\2\2"+
      ":;\7]\2\2;\b\3\2\2\2<=\7_\2\2=\n\3\2\2\2>?\7~\2\2?\f\3\2\2\2@A\7~"+
      "\2\2AB\7~\2\2B\16\3\2\2\2CD\7]\2\2DE\7~\2\2E\20\3\2\2\2FG\7~\2\2G"+
      "H\7_\2\2H\22\3\2\2\2IJ\7<\2\2JK\7~\2\2K\24\3\2\2\2LM\7~\2\2MN\7<\2"+
      "\2N\26\3\2\2\2OP\7]\2\2PQ\7\63\2\2Q\30\3\2\2\2RS\7]\2\2ST\7\64\2\2"+
      "T\32\3\2\2\2UV\7\60\2\2V\34\3\2\2\2WX\7\61\2\2X\36\3\2\2\2Ya\7a\2"+
      "\2Z[\7a\2\2[a\7a\2\2\\a\7`\2\2]^\7`\2\2^a\7`\2\2_a\7?\2\2`Y\3\2\2"+
      "\2`Z\3\2\2\2`\\\3\2\2\2`]\3\2\2\2`_\3\2\2\2a \3\2\2\2bc\t\2\2\2c\""+
      "\3\2\2\2df\t\3\2\2ed\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2h$\3\2\2"+
      "\2ij\7*\2\2jp\7\64\2\2kl\7*\2\2lp\7\65\2\2mn\7*\2\2np\7\66\2\2oi\3"+
      "\2\2\2ok\3\2\2\2om\3\2\2\2p&\3\2\2\2qs\t\4\2\2rq\3\2\2\2st\3\2\2\2"+
      "tr\3\2\2\2tu\3\2\2\2u(\3\2\2\2vw\t\5\2\2w*\3\2\2\2xz\t\6\2\2yx\3\2"+
      "\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2|,\3\2\2\2}\177\t\7\2\2~}\3\2\2"+
      "\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081.\3\2"+
      "\2\2\u0082\u0083\7]\2\2\u0083\u0089\7~\2\2\u0084\u0085\7~\2\2\u0085"+
      "\u0089\7~\2\2\u0086\u0087\7~\2\2\u0087\u0089\7_\2\2\u0088\u0082\3"+
      "\2\2\2\u0088\u0084\3\2\2\2\u0088\u0086\3\2\2\2\u0089\60\3\2\2\2\u008a"+
      "\u008b\t\b\2\2\u008b\62\3\2\2\2\u008c\u008e\t\7\2\2\u008d\u008c\3"+
      "\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2"+
      "\u0090\u0091\3\2\2\2\u0091\u0092\b\32\2\2\u0092\64\3\2\2\2\13\2`g"+
      "ot{\u0080\u0088\u008f\3\b\2\2";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}