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

  import lscc.spclGrammar.{KeywordingCtx, IReservedWords}

  import lscc.spclParsedConstructs1.SpclGrammaticalPxery

  transparent inline
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    //
    (using kwIngCtx : IReservedWords.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[Any ]
  = {
    // TODO
    import ctx.given

    ForQueryExpr1.withMode
      (lscc.spclGrammar.forTermOrTypeLevelExprs.forTermLevelC() )
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

  import lscc.spclGrammar.{KeywordingCtx, IReservedWords}

  import lscc.spclParsedConstructs1.SpclGrammaticalPxery

  transparent inline
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    //
    (using kwIngCtx : IReservedWords.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[Any ]
  = {
    // TODO
    import ctx.given

    ForQueryExpr1.withMode
      (lscc.spclGrammar.forTermOrTypeLevelExprs.forTypeLevelC() )
  }.nn

  ;
}






/**
 * 
 * *either-level references*
 * 
 */
// TODO
final
lazy val ForQueryExpr1
= {
  ;

  import lscc.spclParsedConstructs1.SpclGrammaticalPxery

  type CR

  SpclGrammaticalPrfConstructor.forExprsAtImpliedLvl(
    ctx => (m => {
      ;

      /* IMPLIED GIVENS */
      import m.spclUnprefixedKeywdingMode

      /* IMPLIED SYNTAX CONVENTIONS */
      import ctx.spclSdpExtraOpsImplicits.given

      ;

      ({
        ;

        // TODO
        ({
          ;

          // (
          //   ForPrefixedExpr()
          //   orElse
          //   ForSingleTokenLiteralExpr()
          // )

          ???
          .match { case r => r : ctx.SpclSdfYielding[CR ] }
        } )
        .nn
      })
    }) )
  .nn
}






