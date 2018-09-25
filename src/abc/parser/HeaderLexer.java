// Generated from Header.g4 by ANTLR 4.5.1

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
public class HeaderLexer extends Lexer {
  static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

  protected static final DFA[] _decisionToDFA;
  protected static final PredictionContextCache _sharedContextCache =
    new PredictionContextCache();
  public static final int
    T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
    T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, 
    T__16=17, T__17=18, T__18=19, KEY_SIG_LETTER=20, C=21, M=22, OTHER_LETTER=23, 
    NUMBER=24, NEWLINE=25, WHITESPACE=26;
  public static String[] modeNames = {
    "DEFAULT_MODE"
  };

  public static final String[] ruleNames = {
    "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
    "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
    "T__17", "T__18", "KEY_SIG_LETTER", "C", "M", "OTHER_LETTER", "NUMBER", 
    "NEWLINE", "WHITESPACE"
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


  public HeaderLexer(CharStream input) {
    super(input);
    _interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
  }

  @Override
  public String getGrammarFileName() { return "Header.g4"; }

  @Override
  public String[] getRuleNames() { return ruleNames; }

  @Override
  public String getSerializedATN() { return _serializedATN; }

  @Override
  public String[] getModeNames() { return modeNames; }

  @Override
  public ATN getATN() { return _ATN; }

  public static final String _serializedATN =
    "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\34y\b\1\4\2\t\2"+
      "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
      "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4"+
      "\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t"+
      "\30\4\31\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4"+
      "\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3"+
      "\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
      "\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27"+
      "\3\30\3\30\3\31\6\31o\n\31\r\31\16\31p\3\32\3\32\3\33\6\33v\n\33\r"+
      "\33\16\33w\2\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
      "\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
      "\63\33\65\34\3\2\7\4\2CDFI\5\2J\\cnp|\3\2\62;\5\2\f\f\17\17AA\3\2"+
      "\"\"z\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
      "\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
      "\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
      "!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
      "\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67"+
      "\3\2\2\2\5:\3\2\2\2\7=\3\2\2\2\t?\3\2\2\2\13B\3\2\2\2\rE\3\2\2\2\17"+
      "H\3\2\2\2\21K\3\2\2\2\23N\3\2\2\2\25Q\3\2\2\2\27S\3\2\2\2\31U\3\2"+
      "\2\2\33W\3\2\2\2\35Y\3\2\2\2\37[\3\2\2\2!]\3\2\2\2#_\3\2\2\2%a\3\2"+
      "\2\2\'c\3\2\2\2)e\3\2\2\2+g\3\2\2\2-i\3\2\2\2/k\3\2\2\2\61n\3\2\2"+
      "\2\63r\3\2\2\2\65u\3\2\2\2\678\7Z\2\289\7<\2\29\4\3\2\2\2:;\7V\2\2"+
      ";<\7<\2\2<\6\3\2\2\2=>\7\'\2\2>\b\3\2\2\2?@\7E\2\2@A\7<\2\2A\n\3\2"+
      "\2\2BC\7N\2\2CD\7<\2\2D\f\3\2\2\2EF\7O\2\2FG\7<\2\2G\16\3\2\2\2HI"+
      "\7S\2\2IJ\7<\2\2J\20\3\2\2\2KL\7X\2\2LM\7<\2\2M\22\3\2\2\2NO\7M\2"+
      "\2OP\7<\2\2P\24\3\2\2\2QR\7%\2\2R\26\3\2\2\2ST\7a\2\2T\30\3\2\2\2"+
      "UV\7\60\2\2V\32\3\2\2\2WX\7.\2\2X\34\3\2\2\2YZ\7)\2\2Z\36\3\2\2\2"+
      "[\\\7\61\2\2\\ \3\2\2\2]^\7/\2\2^\"\3\2\2\2_`\7<\2\2`$\3\2\2\2ab\7"+
      "~\2\2b&\3\2\2\2cd\7?\2\2d(\3\2\2\2ef\t\2\2\2f*\3\2\2\2gh\7E\2\2h,"+
      "\3\2\2\2ij\7o\2\2j.\3\2\2\2kl\t\3\2\2l\60\3\2\2\2mo\t\4\2\2nm\3\2"+
      "\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\62\3\2\2\2rs\t\5\2\2s\64\3\2\2"+
      "\2tv\t\6\2\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\66\3\2\2\2\5"+
      "\2pw\2";
  public static final ATN _ATN =
    new ATNDeserializer().deserialize(_serializedATN.toCharArray());
  static {
    _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
    for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
      _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
    }
  }
}