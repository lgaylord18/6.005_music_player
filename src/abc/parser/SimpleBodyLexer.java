// Generated from SimpleBody.g4 by ANTLR 4.5.1

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
public class SimpleBodyLexer extends Lexer {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
    T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, OTHER_LETTERS=15, NOTE_LETTERS=16, 
    OCTAVE=17, TIME=18, TUPLET_NUMBER=19, NUMBER=20, WHITESPACE=21, END_BAR=22, 
    NEWLINE=23, SPACES=24;
  public static String[] modeNames = {
    "DEFAULT_MODE"
  };

  public static final String[] ruleNames = {
    "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
    "T__9", "T__10", "T__11", "T__12", "T__13", "OTHER_LETTERS", "NOTE_LETTERS", 
    "OCTAVE", "TIME", "TUPLET_NUMBER", "NUMBER", "WHITESPACE", "END_BAR", 
    "NEWLINE", "SPACES"
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


  public SimpleBodyLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }

  @Override
  public String getGrammarFileName() { return "SimpleBody.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public String[] getModeNames() { return modeNames; }

  @Override
  public ATN getATN() { return _ATN; }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u0086\b\1\4"+
      "\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
      "\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21"+
      "\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
      "\4\30\t\30\4\31\t\31\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
      "\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r"+
      "\3\16\3\16\3\16\3\17\3\17\3\17\3\20\6\20V\n\20\r\20\16\20W\3\21\3"+
      "\21\3\22\6\22]\n\22\r\22\16\22^\3\23\5\23b\n\23\3\23\3\23\5\23f\n"+
      "\23\3\24\3\24\3\25\6\25k\n\25\r\25\16\25l\3\26\3\26\3\27\3\27\3\27"+
      "\3\27\3\27\3\27\5\27w\n\27\3\30\3\30\3\30\5\30|\n\30\5\30~\n\30\3"+
      "\31\6\31\u0081\n\31\r\31\16\31\u0082\3\31\3\31\2\2\32\3\3\5\4\7\5"+
      "\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
      "#\23%\24\'\25)\26+\27-\30/\31\61\32\3\2\b\4\2J\\j|\4\2CIci\4\2))."+
      ".\3\2\62;\4\2\13\13\"\"\3\2\"\"\u008f\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
      "\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
      "\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
      "\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
      "\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
      "\2\2\3\63\3\2\2\2\5\65\3\2\2\2\7\67\3\2\2\2\t9\3\2\2\2\13;\3\2\2\2"+
      "\r=\3\2\2\2\17?\3\2\2\2\21A\3\2\2\2\23C\3\2\2\2\25E\3\2\2\2\27H\3"+
      "\2\2\2\31K\3\2\2\2\33N\3\2\2\2\35Q\3\2\2\2\37U\3\2\2\2!Y\3\2\2\2#"+
      "\\\3\2\2\2%a\3\2\2\2\'g\3\2\2\2)j\3\2\2\2+n\3\2\2\2-v\3\2\2\2/}\3"+
      "\2\2\2\61\u0080\3\2\2\2\63\64\7\'\2\2\64\4\3\2\2\2\65\66\7\60\2\2"+
      "\66\6\3\2\2\2\678\7.\2\28\b\3\2\2\29:\7)\2\2:\n\3\2\2\2;<\7|\2\2<"+
      "\f\3\2\2\2=>\7]\2\2>\16\3\2\2\2?@\7_\2\2@\20\3\2\2\2AB\7*\2\2B\22"+
      "\3\2\2\2CD\7~\2\2D\24\3\2\2\2EF\7~\2\2FG\7~\2\2G\26\3\2\2\2HI\7]\2"+
      "\2IJ\7~\2\2J\30\3\2\2\2KL\7~\2\2LM\7_\2\2M\32\3\2\2\2NO\7<\2\2OP\7"+
      "~\2\2P\34\3\2\2\2QR\7~\2\2RS\7<\2\2S\36\3\2\2\2TV\t\2\2\2UT\3\2\2"+
      "\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2X \3\2\2\2YZ\t\3\2\2Z\"\3\2\2\2[]"+
      "\t\4\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_$\3\2\2\2`b\5)"+
      "\25\2a`\3\2\2\2ab\3\2\2\2bc\3\2\2\2ce\7\61\2\2df\5)\25\2ed\3\2\2\2"+
      "ef\3\2\2\2f&\3\2\2\2gh\4\64\66\2h(\3\2\2\2ik\t\5\2\2ji\3\2\2\2kl\3"+
      "\2\2\2lj\3\2\2\2lm\3\2\2\2m*\3\2\2\2no\t\6\2\2o,\3\2\2\2pq\7]\2\2"+
      "qw\7~\2\2rs\7~\2\2sw\7~\2\2tu\7~\2\2uw\7_\2\2vp\3\2\2\2vr\3\2\2\2"+
      "vt\3\2\2\2w.\3\2\2\2x~\7\f\2\2y{\7\17\2\2z|\7\f\2\2{z\3\2\2\2{|\3"+
      "\2\2\2|~\3\2\2\2}x\3\2\2\2}y\3\2\2\2~\60\3\2\2\2\177\u0081\t\7\2\2"+
      "\u0080\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
      "\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\b\31\2\2\u0085\62\3\2\2\2"+
      "\f\2W^aelv{}\u0082\3\b\2\2";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}