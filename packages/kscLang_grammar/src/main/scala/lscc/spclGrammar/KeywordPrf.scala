package lscc.spclGrammar















/** 
 * 
 * `ParseFunction` to parse the desired keywds
 * 
 */
object KeywordPrf
{
  // TODO

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp

  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1
  import lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFiSpoSupp

  /**
   * 
   * alias of `forWordlikeContentByPattern`.
   * 
   */
  @deprecated("alias of 'forWordlikeContentByPattern'.")
  transparent inline
  def forContentPattern
    //
    (using ctx : lscc.spclTerminalGrammarsB.SpclPxery )
    (subject: IRegExp._Any )
  : ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1 ]
  = forWordlikeContentByPattern(subject)

  /**
   * 
   * `KeywordPrf`
   * to match UnescapedWord(s) described by the given RegExp (and hence, assumed to be `\w+`s)
   * .
   * will
   * compensate for very speculable absence, at either ends, of the meta-char `\b`,
   * by adding one manually
   * .
   * 
   */
  def forWordlikeContentByPattern
    //
    (using ctx : lscc.spclTerminalGrammarsB.SpclPxery )
    (subject: IRegExp._Any )
  : ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1 ]
  = ({
    import ctx.given

    /** 
     * compensate for very speculable absence of the meta-char `\b`
     * 
     */
    glscc.spclTerminalGrammars.ForImmediateSingleLineRawOcc({
      wordLikeContentPattern(subject)
    })
  }).nn

  ;

  /**
   * 
   * `IRegExp`
   * to match UnescapedWord(s) described by the given RegExp (and hence, assumed to be `\w+`s)
   * .
   * will
   * compensate for very speculable absence, at either ends, of the meta-char `\b`,
   * by adding one manually
   * .
   * 
   */
  // private
  // transparent inline
  def wordLikeContentPattern
    //
    (subject: IRegExp._Any )
  : IRegExp._Any
  = {
    ;
    import language.unsafeNulls

    import IRegExp.tagImplicits.r

    subject
    .regex
    .match { case s => (
      // """\b(?:[MAIN])\b""" /* causes `Stack overflow during pattern compilation`s */
      // """\b[MAIN]\b""" /* WRONG */
      """\b(?:[MAIN])\b"""
      .replace("[MAIN]", s )
    ) }
    .match { case r => {
      assert((r startsWith """\b""") && (r endsWith """\b""") )
      r
    } }
    .r
  }

}







