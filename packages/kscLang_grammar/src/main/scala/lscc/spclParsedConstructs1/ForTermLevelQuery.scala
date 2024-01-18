package lscc.spclParsedConstructs1

















object ForQueryExpr
{
  ;

  ;

  def apply
    //
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using apMode : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ] )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , apMode.AfterSi[Any ] ]
  = {
    // TODO

    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

    (
      ForPrefixedExpr()
    )
    .mapWithFinalPtrPosVl((v, srcPosInfo) => {
      v.withSrcInfo(srcPosInfo = srcPosInfo )
    } )
  }

  ;
}






object ForPrefixedExpr {
  ;

  def apply
    //
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using apMode : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ] )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  = {
    (
      ForPrefixedScrutTermLvlExpr()
    )
  }

  ;
}









