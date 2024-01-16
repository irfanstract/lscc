package lscc.spclParsedConstructs1

















/** 
 * type-ascriptive suffix operator -- one of `: T` or `@ t`
 * 
 */
object ForScrutSyntactic
{
  ;

  import lscalg.parsing.subjectConcatOps1.given

  def apply
    //
    //
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using apMode : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ] )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , Keyword[String] ]
  = {
    ;

    import givenFispoSupp.T as PAny

    ({
      ;

      /** `WithFilter` */
      import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
      import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

      /** to impose `prsWhitespaceableHeadTailConcatOp` */
      import fwscImplicits.prsWhitespaceableHeadTailConcatOp

      (
        //

        (
          ForOccurringKeywordOrRef()
          .mapWithFinalPtrPosVl({ case (scrutMode @ (Keyword( kwd @ ("@" | "@") ) ) , srcPos ) => {
            Keyword(kwd )
            .withSrcInfo(srcPosInfo = srcPos )
          } } )

          +%:

          ForQueryExpr()

          +%:

          lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
        )
        .map({ case (iTypeKw, vl) => {
          (iTypeKw, vl )
        } })

        orElse

        (
          ForOccurringKeywordOrRef()
          .mapWithFinalPtrPosVl({ case (scrutMode @ (Keyword( kwd @ (":" | ":") ) ) , srcPos ) => {
            Keyword(kwd )
            .withSrcInfo(srcPosInfo = srcPos )
          } } )

          +%:

          KeywordingCtx.withSp(ForTypeLevelUnprefixedKeyword() ) {
            ForQueryExpr()
          }

          +%:

          lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
        )
        .map({ case (iTypeKw, vl) => {
          (iTypeKw, vl )
        } })
      )
    })
  }

  ;
}

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









