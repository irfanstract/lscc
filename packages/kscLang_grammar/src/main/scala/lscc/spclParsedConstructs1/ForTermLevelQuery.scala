package lscc.spclParsedConstructs1

















/** 
 * 
 * *term-level references*
 * 
 */
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

transparent inline
def ForTypeQueryExpr
= ForTypeRef

/** 
 * 
 * *type-level reference to types*
 * 
 */
object ForTypeRef
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






/**
 * 
 * *either-level references*
 * 
 */
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
    (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
  : ctx.SpclSdfYielding[Any ]
  = {
    import m.spclUnprefixedKeywdingMode

    ForPrefixedExpr.withMode(m )
  }

  ;
}






