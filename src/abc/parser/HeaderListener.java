// Generated from Header.g4 by ANTLR 4.5.1

package abc.parser;
// Do not edit this .java file! Edit the .g4 file and re-run Antlr.

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HeaderParser}.
 */
public interface HeaderListener extends ParseTreeListener {
  /**
   * Enter a parse tree produced by {@link HeaderParser#header}.
   * @param ctx the parse tree
   */
  void enterHeader(HeaderParser.HeaderContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#header}.
   * @param ctx the parse tree
   */
  void exitHeader(HeaderParser.HeaderContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#index_field}.
   * @param ctx the parse tree
   */
  void enterIndex_field(HeaderParser.Index_fieldContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#index_field}.
   * @param ctx the parse tree
   */
  void exitIndex_field(HeaderParser.Index_fieldContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#title_field}.
   * @param ctx the parse tree
   */
  void enterTitle_field(HeaderParser.Title_fieldContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#title_field}.
   * @param ctx the parse tree
   */
  void exitTitle_field(HeaderParser.Title_fieldContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#comment}.
   * @param ctx the parse tree
   */
  void enterComment(HeaderParser.CommentContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#comment}.
   * @param ctx the parse tree
   */
  void exitComment(HeaderParser.CommentContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#optional_fields}.
   * @param ctx the parse tree
   */
  void enterOptional_fields(HeaderParser.Optional_fieldsContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#optional_fields}.
   * @param ctx the parse tree
   */
  void exitOptional_fields(HeaderParser.Optional_fieldsContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#composer_field}.
   * @param ctx the parse tree
   */
  void enterComposer_field(HeaderParser.Composer_fieldContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#composer_field}.
   * @param ctx the parse tree
   */
  void exitComposer_field(HeaderParser.Composer_fieldContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#length_field}.
   * @param ctx the parse tree
   */
  void enterLength_field(HeaderParser.Length_fieldContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#length_field}.
   * @param ctx the parse tree
   */
  void exitLength_field(HeaderParser.Length_fieldContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#meter_field}.
   * @param ctx the parse tree
   */
  void enterMeter_field(HeaderParser.Meter_fieldContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#meter_field}.
   * @param ctx the parse tree
   */
  void exitMeter_field(HeaderParser.Meter_fieldContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#tempo_field}.
   * @param ctx the parse tree
   */
  void enterTempo_field(HeaderParser.Tempo_fieldContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#tempo_field}.
   * @param ctx the parse tree
   */
  void exitTempo_field(HeaderParser.Tempo_fieldContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#voice_field}.
   * @param ctx the parse tree
   */
  void enterVoice_field(HeaderParser.Voice_fieldContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#voice_field}.
   * @param ctx the parse tree
   */
  void exitVoice_field(HeaderParser.Voice_fieldContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#key_field}.
   * @param ctx the parse tree
   */
  void enterKey_field(HeaderParser.Key_fieldContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#key_field}.
   * @param ctx the parse tree
   */
  void exitKey_field(HeaderParser.Key_fieldContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#end_line}.
   * @param ctx the parse tree
   */
  void enterEnd_line(HeaderParser.End_lineContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#end_line}.
   * @param ctx the parse tree
   */
  void exitEnd_line(HeaderParser.End_lineContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#key}.
   * @param ctx the parse tree
   */
  void enterKey(HeaderParser.KeyContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#key}.
   * @param ctx the parse tree
   */
  void exitKey(HeaderParser.KeyContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#string}.
   * @param ctx the parse tree
   */
  void enterString(HeaderParser.StringContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#string}.
   * @param ctx the parse tree
   */
  void exitString(HeaderParser.StringContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#length}.
   * @param ctx the parse tree
   */
  void enterLength(HeaderParser.LengthContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#length}.
   * @param ctx the parse tree
   */
  void exitLength(HeaderParser.LengthContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#meter}.
   * @param ctx the parse tree
   */
  void enterMeter(HeaderParser.MeterContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#meter}.
   * @param ctx the parse tree
   */
  void exitMeter(HeaderParser.MeterContext ctx);
  /**
   * Enter a parse tree produced by {@link HeaderParser#tempo}.
   * @param ctx the parse tree
   */
  void enterTempo(HeaderParser.TempoContext ctx);
  /**
   * Exit a parse tree produced by {@link HeaderParser#tempo}.
   * @param ctx the parse tree
   */
  void exitTempo(HeaderParser.TempoContext ctx);
}