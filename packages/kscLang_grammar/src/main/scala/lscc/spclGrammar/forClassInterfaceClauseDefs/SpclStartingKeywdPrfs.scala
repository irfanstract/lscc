package lscc.spclGrammar.forClassInterfaceClauseDefs















final
lazy val SpclStartingKeywdPrfs
= DefKeywdedMethodDeclStartingKeywdPrfs

object DefKeywdedMethodDeclStartingKeywdPrfs
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1
  import lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp

  // protected
  def apply
    //
    (using ec : GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    ( )
  = {
    ;
    import IRegExp.tagImplicits.r

    // TODO
    ((
      lscc.spclGrammar.KeywordPrf.forContentPattern("""(?:tr|tra|trait|cl|cl[a]|cla+s+|ob|obj|obje|obje[ck]t*)\b""".r )
    ))
  }

}








