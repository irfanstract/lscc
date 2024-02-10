package lscc.spclParsedConstructs1




















object ForPrefixedExpr
{
  ;

  // TODO

  transparent inline /* a must-have modifier for forwarders */
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    //
    (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
    ( )
    //
    // (using wrMode : SpclWrapMode.ForPxery[ctx1.type ] )
  : ctx.SpclSdfYielding[Any ]
  = {
    import ctx.given

    import ctx.spclSdpExtraOpsImplicits.given

    (
      ForUnparenedBindingFirstTermOrTypeAscribedExprP.apply()
    )
    .match { case p => p : ctx.SpclSdfYielding[Any ] }
    .nn
  }.nn

  transparent inline /* a must-have modifier for forwarders */
  def withMode
    //
    (using ctx: SpclGrammaticalPxery )
    //
    (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
    //
    // (using wrMode : SpclWrapMode.ForPxery[ctx1.type ] )
  : ctx.SpclSdfYielding[Any ]
  = {
    given m.type
    = m

    apply()
  }.nn

  ;
}








object ForPossiblyParenthesisedExpr
{
  ;

  ;

  /* RELEVANT UTILITY IMPORTS */

  ;

  /* RELEVANT ON-TOPIC IMPORTS */

  ;

  /* IMPLEMENTATIVE -- SYNTACTIC IMPORTS */

  // TODO

  // transparent inline /* a must-have modifier for forwarders */
  def apply
    //
    [MainValue ]
    (using ctx1: SpclGrammaticalPxery )
    //
    // (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx1.type ] )
    (mainRule: ctx1.SpclSdfYielding[( MainValue  ) ] )
    (using wrMode : SpclWrapMode.ForPxery[ctx1.type ] )
  // : ctx1.SpclSdfYielding[( ctx1.grmMetadataWrapMode.AppliedTo[MainValue] , Unit ) ]
  : ctx1.SpclSdfYielding[(wrMode.AppliedToWrapped[MainValue] )]
  = {
    ;

    import ctx1.spclSdpExtraOpsImplicits.given

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

  // final lazy val
  final lazy val SpclWrapMode
  : ForParenthesisedExpr.SpclWrapMode.type
  = ForParenthesisedExpr.SpclWrapMode

}

object ForParenthesisedExpr
{
  ;

  ;

  /* RELEVANT UTILITY IMPORTS */

  /* RELEVANT ON-TOPIC NAME-IMPORTS */

  /* IMPLEMENTATIVE -- SYNTACTIC IMPORTS */

  import lscalg.bnfParsing.IRegExp

  import IRegExp.tagImplicits.r

  ;

  // transparent inline /* a must-have modifier for forwarders */
  def apply
    //
    [MainValue ]
    (using ctx: SpclGrammaticalPxery )
    //
    // (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
    (mainRule: ctx.SpclSdfYielding[( MainValue  ) ] )
    (using wrMode : SpclWrapMode.ForPxery[ctx.type ] )
  // : ctx.SpclSdfYielding[( ctx.grmMetadataWrapMode.AppliedTo[MainValue] , Unit ) ]
  : ctx.SpclSdfYielding[(wrMode.AppliedToWrapped[MainValue] )]
  = {
    ;

    import ctx.given
    import ctx.givenFispoSupp
    import ctx.givenFispoSupp.InputState as PAny

    import ctx.spclSdpExtraOpsImplicits.given

    ({
      ;


      ({
        ;

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

            +++%:

            mainRule

            +++%:

            closingBracketPrf

            ++%:

            ctx.prsfNil
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
    (using enclosingPxery: SpclGrammaticalPxery )
    (using wrMode : SpclWrapMode.ForPxery[enclosingPxery.type ] )
    (mainValue : enclosingPxery.grmMetadataWrapMode.AppliedTo[A] )
  : wrMode.AppliedToWrapped[A]
  = wrMode.applyToWrappedValue(mainValue )

  trait SpclWrapMode
  {
    ;

    val enclosingPxery
    : SpclGrammaticalPxery

    type AppliedToUnwrapped[+R]

    type AppliedToWrapped[+A]
    = AppliedToUnwrapped[enclosingPxery.grmMetadataWrapMode.AppliedTo[A] ]

    def applyToWrappedValue
      [A]
      (mainValue : enclosingPxery.grmMetadataWrapMode.AppliedTo[A] )
    : AppliedToUnwrapped[mainValue.type ]

    extension (receiver: Unit)
      @deprecated
      def test(): Unit = {}

  }
  object SpclWrapMode
  {
    ;

    type ForPxery[+C <: SpclGrammaticalPxery ]
    = SpclWrapMode {
      //
      val enclosingPxery
      : C
    }

    ;

    // @deprecated
    implicit
    transparent inline
    def given_fromImpliedSpclGrammaticalPxery
      //
      [C <: SpclGrammaticalPxery ]
      (using ctxImpl : C )
    : ((
      //
      SpclWrapMode.ForPxery[ctxImpl.type ]

      /* 
       * strange, adding refinements would prevent this from getting found
       */
      // { ... ... }
    ) )
    = fromImpliedSpclGrammaticalPxery[ctxImpl.type ]

    def fromImpliedSpclGrammaticalPxery
      //
      [C <: SpclGrammaticalPxery ]
      (using ctxImpl : C )
    : ((
      //
      SpclWrapMode.ForPxery[ctxImpl.type ]
    ) {
      ;

      type AppliedToUnwrapped[+A]
      >: (A, Unit ) @annotation.unchecked.uncheckedVariance
      <: (A, Unit )

      /* disabed ; it led to StackOverflowError(s) */
      // // TODO remove this LOC
      // def applyToWrappedValue
      //   [A]
      //   (value : enclosingPxery.grmMetadataWrapMode.AppliedTo[A] )
      // : (value.type, Unit )

    } )
    = new SpclWrapMode {
      ;

      val enclosingPxery
      : ctxImpl.type
      = ctxImpl

      type AppliedToUnwrapped[+A]
      >: (A, Unit ) @annotation.unchecked.uncheckedVariance
      <: (A, Unit )

      def applyToWrappedValue
        [A]
        (value : enclosingPxery.grmMetadataWrapMode.AppliedTo[A] )
      = (value, () ) : (value.type, Unit )

    }
  }

  ;
}











