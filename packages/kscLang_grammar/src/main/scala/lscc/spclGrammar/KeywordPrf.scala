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
   * `KeywordPrf` to match items which matches the given RegExp (assumed to be `\w+`s)
   * 
   * compensate for very speculable absence of the meta-char `\b`
   * 
   */
  def forContentPattern
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
      wrapRegex(subject)
    })
  }).nn

  ;

  private
  transparent inline
  def wrapRegex
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







