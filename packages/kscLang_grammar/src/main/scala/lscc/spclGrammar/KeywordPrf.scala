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
    (using ec : GivenFiSpoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    (subject: IRegExp.ForRegexp[String] )
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ec.T, ec.SpclMatchContent ]
  = ({
    import IRegExp.tagImplicits.r

    /** 
     * compensate for very speculable absence of the meta-char `\b`
     * 
     */
    glscc.spclTerminalGrammars.ForImmediateSingleLineRawOcc({
      subject
      .regex
      .match { case s => s"""\b(?:$s)\b""" }
      .r
    })
  })

}







