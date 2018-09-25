// Generated from Body.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BodyParser}.
 */
public interface BodyListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link BodyParser#body}.
   * @param ctx the parse tree
   */
  void enterBody(BodyParser.BodyContext ctx);
  /**
   * Exit a parse tree produced by {@link BodyParser#body}.
   * @param ctx the parse tree
   */
  void exitBody(BodyParser.BodyContext ctx);
  /**
   * Enter a parse tree produced by {@link BodyParser#body_line}.
   * @param ctx the parse tree
   */
  void enterBody_line(BodyParser.Body_lineContext ctx);
  /**
   * Exit a parse tree produced by {@link BodyParser#body_line}.
   * @param ctx the parse tree
   */
  void exitBody_line(BodyParser.Body_lineContext ctx);
  /**
   * Enter a parse tree produced by {@link BodyParser#comment}.
   * @param ctx the parse tree
   */
  void enterComment(BodyParser.CommentContext ctx);
  /**
   * Exit a parse tree produced by {@link BodyParser#comment}.
   * @param ctx the parse tree
   */
  void exitComment(BodyParser.CommentContext ctx);
  /**
   * Enter a parse tree produced by {@link BodyParser#voice}.
   * @param ctx the parse tree
   */
  void enterVoice(BodyParser.VoiceContext ctx);
  /**
   * Exit a parse tree produced by {@link BodyParser#voice}.
   * @param ctx the parse tree
   */
  void exitVoice(BodyParser.VoiceContext ctx);
  /**
   * Enter a parse tree produced by {@link BodyParser#element}.
   * @param ctx the parse tree
   */
  void enterElement(BodyParser.ElementContext ctx);
  /**
   * Exit a parse tree produced by {@link BodyParser#element}.
   * @param ctx the parse tree
   */
  void exitElement(BodyParser.ElementContext ctx);
  /**
   * Enter a parse tree produced by {@link BodyParser#note_element}.
   * @param ctx the parse tree
   */
  void enterNote_element(BodyParser.Note_elementContext ctx);
  /**
   * Exit a parse tree produced by {@link BodyParser#note_element}.
   * @param ctx the parse tree
   */
  void exitNote_element(BodyParser.Note_elementContext ctx);
  /**
   * Enter a parse tree produced by {@link BodyParser#note}.
   * @param ctx the parse tree
   */
  void enterNote(BodyParser.NoteContext ctx);
  /**
   * Exit a parse tree produced by {@link BodyParser#note}.
   * @param ctx the parse tree
   */
  void exitNote(BodyParser.NoteContext ctx);
  /**
   * Enter a parse tree produced by {@link BodyParser#rest}.
   * @param ctx the parse tree
   */
  void enterRest(BodyParser.RestContext ctx);
  /**
   * Exit a parse tree produced by {@link BodyParser#rest}.
   * @param ctx the parse tree
   */
  void exitRest(BodyParser.RestContext ctx);
  /**
   * Enter a parse tree produced by {@link BodyParser#chord}.
   * @param ctx the parse tree
   */
  void enterChord(BodyParser.ChordContext ctx);
  /**
   * Exit a parse tree produced by {@link BodyParser#chord}.
   * @param ctx the parse tree
   */
  void exitChord(BodyParser.ChordContext ctx);
  /**
   * Enter a parse tree produced by {@link BodyParser#tuplet}.
   * @param ctx the parse tree
   */
  void enterTuplet(BodyParser.TupletContext ctx);
  /**
   * Exit a parse tree produced by {@link BodyParser#tuplet}.
   * @param ctx the parse tree
   */
  void exitTuplet(BodyParser.TupletContext ctx);
  /**
   * Enter a parse tree produced by {@link BodyParser#barline}.
   * @param ctx the parse tree
   */
  void enterBarline(BodyParser.BarlineContext ctx);
  /**
   * Exit a parse tree produced by {@link BodyParser#barline}.
   * @param ctx the parse tree
   */
  void exitBarline(BodyParser.BarlineContext ctx);
  /**
   * Enter a parse tree produced by {@link BodyParser#repeat}.
   * @param ctx the parse tree
   */
  void enterRepeat(BodyParser.RepeatContext ctx);
  /**
   * Exit a parse tree produced by {@link BodyParser#repeat}.
   * @param ctx the parse tree
   */
  void exitRepeat(BodyParser.RepeatContext ctx);
  /**
   * Enter a parse tree produced by {@link BodyParser#string}.
   * @param ctx the parse tree
   */
  void enterString(BodyParser.StringContext ctx);
  /**
   * Exit a parse tree produced by {@link BodyParser#string}.
   * @param ctx the parse tree
   */
  void exitString(BodyParser.StringContext ctx);
  /**
   * Enter a parse tree produced by {@link BodyParser#time}.
   * @param ctx the parse tree
   */
  void enterTime(BodyParser.TimeContext ctx);
  /**
   * Exit a parse tree produced by {@link BodyParser#time}.
   * @param ctx the parse tree
   */
  void exitTime(BodyParser.TimeContext ctx);
}