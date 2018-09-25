// Generated from SimpleBody.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleBodyParser}.
 */
public interface SimpleBodyListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link SimpleBodyParser#body}.
   * @param ctx the parse tree
   */
  void enterBody(SimpleBodyParser.BodyContext ctx);
  /**
   * Exit a parse tree produced by {@link SimpleBodyParser#body}.
   * @param ctx the parse tree
   */
  void exitBody(SimpleBodyParser.BodyContext ctx);
  /**
   * Enter a parse tree produced by {@link SimpleBodyParser#body_line}.
   * @param ctx the parse tree
   */
  void enterBody_line(SimpleBodyParser.Body_lineContext ctx);
  /**
   * Exit a parse tree produced by {@link SimpleBodyParser#body_line}.
   * @param ctx the parse tree
   */
  void exitBody_line(SimpleBodyParser.Body_lineContext ctx);
  /**
   * Enter a parse tree produced by {@link SimpleBodyParser#comment}.
   * @param ctx the parse tree
   */
  void enterComment(SimpleBodyParser.CommentContext ctx);
  /**
   * Exit a parse tree produced by {@link SimpleBodyParser#comment}.
   * @param ctx the parse tree
   */
  void exitComment(SimpleBodyParser.CommentContext ctx);
  /**
   * Enter a parse tree produced by {@link SimpleBodyParser#element}.
   * @param ctx the parse tree
   */
  void enterElement(SimpleBodyParser.ElementContext ctx);
  /**
   * Exit a parse tree produced by {@link SimpleBodyParser#element}.
   * @param ctx the parse tree
   */
  void exitElement(SimpleBodyParser.ElementContext ctx);
  /**
   * Enter a parse tree produced by {@link SimpleBodyParser#string}.
   * @param ctx the parse tree
   */
  void enterString(SimpleBodyParser.StringContext ctx);
  /**
   * Exit a parse tree produced by {@link SimpleBodyParser#string}.
   * @param ctx the parse tree
   */
  void exitString(SimpleBodyParser.StringContext ctx);
  /**
   * Enter a parse tree produced by {@link SimpleBodyParser#note_element}.
   * @param ctx the parse tree
   */
  void enterNote_element(SimpleBodyParser.Note_elementContext ctx);
  /**
   * Exit a parse tree produced by {@link SimpleBodyParser#note_element}.
   * @param ctx the parse tree
   */
  void exitNote_element(SimpleBodyParser.Note_elementContext ctx);
  /**
   * Enter a parse tree produced by {@link SimpleBodyParser#note}.
   * @param ctx the parse tree
   */
  void enterNote(SimpleBodyParser.NoteContext ctx);
  /**
   * Exit a parse tree produced by {@link SimpleBodyParser#note}.
   * @param ctx the parse tree
   */
  void exitNote(SimpleBodyParser.NoteContext ctx);
  /**
   * Enter a parse tree produced by {@link SimpleBodyParser#rest}.
   * @param ctx the parse tree
   */
  void enterRest(SimpleBodyParser.RestContext ctx);
  /**
   * Exit a parse tree produced by {@link SimpleBodyParser#rest}.
   * @param ctx the parse tree
   */
  void exitRest(SimpleBodyParser.RestContext ctx);
  /**
   * Enter a parse tree produced by {@link SimpleBodyParser#chord}.
   * @param ctx the parse tree
   */
  void enterChord(SimpleBodyParser.ChordContext ctx);
  /**
   * Exit a parse tree produced by {@link SimpleBodyParser#chord}.
   * @param ctx the parse tree
   */
  void exitChord(SimpleBodyParser.ChordContext ctx);
  /**
   * Enter a parse tree produced by {@link SimpleBodyParser#tuplet}.
   * @param ctx the parse tree
   */
  void enterTuplet(SimpleBodyParser.TupletContext ctx);
  /**
   * Exit a parse tree produced by {@link SimpleBodyParser#tuplet}.
   * @param ctx the parse tree
   */
  void exitTuplet(SimpleBodyParser.TupletContext ctx);
  /**
   * Enter a parse tree produced by {@link SimpleBodyParser#barline}.
   * @param ctx the parse tree
   */
  void enterBarline(SimpleBodyParser.BarlineContext ctx);
  /**
   * Exit a parse tree produced by {@link SimpleBodyParser#barline}.
   * @param ctx the parse tree
   */
  void exitBarline(SimpleBodyParser.BarlineContext ctx);
}