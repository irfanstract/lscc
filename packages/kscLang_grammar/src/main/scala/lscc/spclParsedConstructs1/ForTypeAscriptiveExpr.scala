package lscc.spclParsedConstructs1

















/**
 * 
 * a class of expressions each in any of roughly these forms
 * 
 * ```
 * _ @ &lt;query&gt;
 * 
 * val example1 @ &lt;query&gt;
 * 
 * _ : T
 * 
 * val exampleSome : T
 * ```
 * 
 */
object ForTermOrTypeAscribedExprP
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
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[AstTermOrTypeAscribedExprImpl.ForApmType[ctx.apMode.type ] ]
  = {
    ;

    import ctx.given
    import ctx.givenFispoSupp
    import ctx.givenFispoSupp.T as PAny

    ({
      ;


      ({
        ;

        ({
          ;

          import fwscImplicits.prsWhitespaceableHeadTailConcatOp

          (
            ForPsFirstBindingExpr()

            +%:

            ForTermOrTypeAscriptiveInfixAndRhs()

            +%:

            lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
          )
          .map({ case (bindingExpr, s) => {
            AstTermOrTypeAscribedExprImpl(bindingSideExpr = bindingExpr, ascriptiveSideExpr = s )
          } } )
          .nn
        })
      })
    })
    .withFinalPtrPosVl()
  }.nn

  ;
}

// TODO
object AstTermOrTypeAscribedExprImpl {
  ;

  type _Any
  = AstTermOrTypeAscribedExprImpl[?]

  def apply
    //
    (using apMode : SpclApm._Any )
    (bindingSideExpr: apMode.AfterSi[PrefixScrutLhsExpr], ascriptiveSideExpr: apMode.AfterSi[AscriptiveExpr ] )
  = new AstTermOrTypeAscribedExprImpl((apMode, bindingSideExpr, ascriptiveSideExpr ) : (
    (apMode.type, bindingSideExpr.type, ascriptiveSideExpr.type )
  ) )

  type _DataAny
  = (
    //

    (SpclApm._Any, Any, Any ) {
      ;
      val _2 : _1.AfterSi[PrefixScrutLhsExpr]
      val _3 : _1.AfterSi[AscriptiveExpr]
    }
  )

  type ForApmType
    [+T <: SpclApm._Any ]
  = AstTermOrTypeAscribedExprImpl[(
    _DataAny
    & Tuple3[T, ?, ?]
  )]

  ;
}
case class AstTermOrTypeAscribedExprImpl
  [+T <: AstTermOrTypeAscribedExprImpl._DataAny ] private[AstTermOrTypeAscribedExprImpl] (d: T )





/**
 * 
 * type-ascriptive suffix operator --
 * one of `: T` or `@ &lt;query&gt;`
 * 
 */
object ForTermOrTypeAscriptiveInfixAndRhs
{ 
  ;

  import lscalg.parsing.ParseFunction.returnedMainValueMapOpImplicits.given
  import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

  import lscalg.parsing.subjectConcatOps1.given

  /** to impose `prsWhitespaceableHeadTailConcatOp` */
  import fwscImplicits.prsWhitespaceableHeadTailConcatOp

  def apply
    //
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[AscriptiveExpr ]
  = {
    ;

    import ctx.given
    import ctx.givenFispoSupp.T as PAny
    import ctx.givenFispoSupp

    ({
      ;

      (
        //

        (
          ForOccurringKeywordOrRefP()
          .map({ case (scrutMode @ (Keyword( kwd @ ("@" | "@") ) ) ) => {
            Keyword(kwd )
          } } )
          .withFinalPtrPosVl()

          +%:

          ForQueryExpr()

          +%:

          lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
        )
        .map({ case (iTypeKw, vl) => {
          // (iTypeKw, vl )
          ToTermPatternScrutiveAscription(vl )
        } })

        orElse

        (
          ForOccurringKeywordOrRefP()
          .map({ case (scrutMode @ (Keyword( kwd @ (":" | ":") ) )  ) => {
            Keyword(kwd )
          } } )
          .withFinalPtrPosVl()

          +%:

          KeywordingCtx.withSp(ForTypeLevelUnprefixedKeyword() ) {
            ForQueryExpr()
          }

          +%:

          lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
        )
        .map({ case (iTypeKw, vl) => {
          // (iTypeKw, vl )
          ToTypeScrutiveAscription(vl )
        } })
      )
      .withFinalPtrPosVl()
    })
  }.nn

  ;
}

trait AscriptiveExpr protected () {}

case class ToTermPatternScrutiveAscription(main: Any )
extends AscriptiveExpr

case class ToTypeScrutiveAscription(t: Any )
extends AscriptiveExpr



enum PrefixScrutLhsExpr {
  ;

  case ForIgnorableWildcard()

  case ForValDef(value: FvdParsed._Any )

}

object ForPsFirstBindingExpr {
  ;

  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[PrefixScrutLhsExpr ]
  = {
    ;

    import ctx.given

    import ctx.givenFispoSupp

    import ctx.givenFispoSupp.T as PAny

    import lscalg.parsing.ParseFunction.returnedMainValueMapOpImplicits.given
    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

    ;

    (
      ForValDefOnly()
      .map(e => {
        e
        .map(e => (
          PrefixScrutLhsExpr.ForValDef(e) : PrefixScrutLhsExpr.ForValDef
        ) )
      } )

      orElse

      ForUnderscoreWildcardDefOnly()
      .map(e => {
        e
        .map(_ => (
          PrefixScrutLhsExpr.ForIgnorableWildcard() : PrefixScrutLhsExpr.ForIgnorableWildcard
        ) )
      } )
    )
  }.nn

  ;
}









