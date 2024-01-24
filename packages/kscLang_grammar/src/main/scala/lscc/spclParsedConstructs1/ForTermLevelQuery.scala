package lscc.spclParsedConstructs1

















object ForQueryExpr
{
  ;

  ;

  import lscalg.parsing.ParseFunction.returnedMainValueMapOpImplicits.given
  import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

  import lscalg.parsing.subjectConcatOps1.given

  /** to impose `prsWhitespaceableHeadTailConcatOp` */
  import fwscImplicits.prsWhitespaceableHeadTailConcatOp

  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    //
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[Any ]
  = {
    // TODO

    (
      ForPrefixedExpr()
      .match { case r => r : ctx.SpclSdfYielding[Any] }
    )
    // .withFinalPtrPosVl()
  }.nn

  ;
}






object ForPrefixedExpr {
  ;

  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[AstTermOrTypeAscribedExprImpl._Any ]
  = {
    (
      ForTermOrTypeAscribedExprP()
    )
  }

  ;
}









