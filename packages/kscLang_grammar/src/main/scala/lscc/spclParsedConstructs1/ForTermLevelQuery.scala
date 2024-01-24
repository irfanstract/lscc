package lscc.spclParsedConstructs1

















object ForTermQueryExpr
{
  ;

  ;

  import lscc.spclParsedConstructs1.KeywordingCtx

  transparent inline
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    //
    (using kwIngCtx : KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[Any ]
  = {
    // TODO
    import ctx.given

    ForQueryExpr1.withMode
      (lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.forTermLevel() )
  }.nn

  ;
}

object ForTypeQueryExpr
{
  ;

  ;

  import lscc.spclParsedConstructs1.KeywordingCtx

  transparent inline
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    //
    (using kwIngCtx : KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[Any ]
  = {
    // TODO
    import ctx.given

    ForQueryExpr1.withMode
      (lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.forTypeLevel() )
  }.nn

  ;
}






object ForQueryExpr1
{
  ;

  ;

  import lscalg.parsing.ParseFunction.returnedMainValueMapOpImplicits.given
  import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

  import lscalg.parsing.subjectConcatOps1.given

  /** to impose `prsWhitespaceableHeadTailConcatOp` */
  import fwscImplicits.prsWhitespaceableHeadTailConcatOp

  transparent inline
  def withMode
    //
    (using ctx: SpclGrammaticalPxery )
    //
    (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl { val ctx1 : ctx.type } )
  : ctx.SpclSdfYielding[Any ]
  = {
    import m.spclUnprefixedKeywdingMode

    apply()
  }

  @deprecated
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
  : ctx.SpclSdfYielding[TermOrTypeAscribedExprImplAst._Any ]
  = {
    (
      ForBindingFirstTermOrTypeAscribedExprP()
    )
  }

  ;
}









