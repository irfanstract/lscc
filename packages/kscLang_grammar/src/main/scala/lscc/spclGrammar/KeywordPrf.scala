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
    (subject: IRegExp.ForRegexp[String] )
  : ctx.SpclSdfYieldingUnwrapped[ctx.givenFispoSupp.SpclMatchContent ]
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
    (subject: IRegExp.ForRegexp[String] )
  : ctx.SpclSdfYieldingUnwrapped[ctx.givenFispoSupp.SpclMatchContent ]
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
    (subject: IRegExp.ForRegexp[String] )
  : IRegExp.ForRegexp[String]
  = {
    ;
    import IRegExp.tagImplicits.r

    subject
    .regex
    .match { case s => s"""\b(?:$s)\b""" }
    .r
  }

}







