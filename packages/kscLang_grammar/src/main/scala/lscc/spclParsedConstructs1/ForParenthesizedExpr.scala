package lscc.spclParsedConstructs1




















object ForPrefixedExpr {
  ;

  transparent inline /* a must-have modifier for forwarders */
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    //
    (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
    ( )
  : ctx.SpclSdfYielding[TermOrTypeAscribedExprImplAst._Any ]
  = withMode(m )

  def withMode
    //
    (using ctx: SpclGrammaticalPxery )
    //
    (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
  : ctx.SpclSdfYielding[TermOrTypeAscribedExprImplAst._Any ]
  = {
    (
      ForBindingFirstTermOrTypeAscribedExprP.forMode(m )
    )
  }.nn

  ;
}








object ForPossiblyParenthesisedExpr
{
  ;

  import lscalg.parsing.ParseFunction.returnedMainValueMapOpImplicits.given
  import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

  import lscalg.parsing.subjectConcatOps1.given

  // TODO

  // transparent inline /* a must-have modifier for forwarders */
  def apply
    //
    [MainValue ]
    (using ctx: SpclGrammaticalPxery )
    //
    // (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
    (mainRule: ctx.SpclSdfYielding[( MainValue  ) ] )
  : ctx.SpclSdfYielding[( ctx.grmMetadataWrapMode.AppliedTo[MainValue] , Unit ) ]
  = {
    ;

    (
      ForParenthesisedExpr(mainRule )

      orElse

      mainRule
      .map(va => {
        ForParenthesisedExpr.spclWrap(va )
      })
      .withFinalPtrPosVl()
    )
  }.nn

}

object ForParenthesisedExpr
{
  ;

  ;

  import lscalg.parsing.ParseFunction.returnedMainValueMapOpImplicits.given
  import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

  import lscalg.parsing.subjectConcatOps1.given

  /** to impose `prsWhitespaceableHeadTailConcatOp` */
  import fwscImplicits.prsWhitespaceableHeadTailConcatOp

  import lscalg.bnfParsing.IRegExp, IRegExp.tagImplicits.r

  // transparent inline /* a must-have modifier for forwarders */
  def apply
    //
    [MainValue ]
    (using ctx: SpclGrammaticalPxery )
    //
    // (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
    (mainRule: ctx.SpclSdfYielding[( MainValue  ) ] )
  : ctx.SpclSdfYielding[( ctx.grmMetadataWrapMode.AppliedTo[MainValue] , Unit ) ]
  = {
    ;

    import ctx.given
    import ctx.givenFispoSupp
    import ctx.givenFispoSupp.T as PAny

    ({
      ;


      ({
        ;

        import fwscImplicits.prsWhitespaceableHeadTailConcatOp

        ({
          ;

          val (openingBracketPrf, closingBracketPrf )
          = (
            ForOccurringGeneralisedKeyword.forPattern("""(""".r )
            ,
            ForOccurringGeneralisedKeyword.forPattern(""")""".r )
          )

          (
            openingBracketPrf

            +%:

            mainRule

            +%:

            closingBracketPrf

            +%:

            lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
          )
          .map({ case (opnp, mainValue, closingP) => {
            // TODO
            spclWrap(mainValue )
          } } )
          .nn
        })
      })
    })
    .withFinalPtrPosVl()
  }.nn

  // TODO
  // private[lscc]
  def spclWrap
    [A]
    (using ctx: SpclGrammaticalPxery )
    (mainValue : ctx.grmMetadataWrapMode.AppliedTo[A] )
  : (ctx.grmMetadataWrapMode.AppliedTo[A], Unit )
  = (mainValue, () )

  ;
}











