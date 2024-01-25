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
 * (val example1) @ &lt;query&gt;
 * 
 * _ is &lt;query&gt;
 * 
 *  val example1  is &lt;query&gt;
 * 
 * (val example1) is &lt;query&gt;
 * 
 * _ : T
 * 
 * val exampleSome : T
 * 
 * (val exampleSome) : T
 * ```
 * 
 */
object ForBindingFirstTermOrTypeAscribedExprP
{
  ;

  ;

  import lscalg.parsing.ParseFunction.returnedMainValueMapOpImplicits.given
  import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

  import lscalg.parsing.subjectConcatOps1.given

  /** to impose `prsWhitespaceableHeadTailConcatOp` */
  import fwscImplicits.prsWhitespaceableHeadTailConcatOp

  // def (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl { val ctx1 : ctx.type } )

  transparent inline /* a must-have modifier for forwarders */
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    //
    (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
    ( )
  : ctx.SpclSdfYielding[TermOrTypeAscribedExprImplAst.ForApmType[ctx.grmMetadataWrapMode.type ] ]
  = forMode(m )

  transparent inline /* a necessary modifier for forwarders */
  def forMode
    //
    (using ctx: SpclGrammaticalPxery )
    (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
  : ctx.SpclSdfYielding[TermOrTypeAscribedExprImplAst.ForApmType[ctx.grmMetadataWrapMode.type ] ]
  = {
    import m.given
    given m.spclUnprefixedKeywdingMode.type
    = m.spclUnprefixedKeywdingMode

    withImplicitKwdIngCtx( )
  }

  protected
  def withImplicitKwdIngCtx
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[TermOrTypeAscribedExprImplAst.ForApmType[ctx.grmMetadataWrapMode.type ] ]
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
            ForUnparenthesedSimpleHeadBindingExpr()

            +%:

            ForTermOrTypeAscriptiveInfixAndRhs()

            +%:

            lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
          )
          .map({ case (bindingExpr, s) => {
            TermOrTypeAscribedExprImplAst(bindingSideExpr = bindingExpr, ascriptiveSideExpr = s )
          } } )
          .nn
        })
      })
    })
    .withFinalPtrPosVl()
  }.nn

  ;
}

export lscc.spclGrammar.forTermOrTypeLevelExprs.{TermOrTypeAscribedExprImplAst }






/**
 * 
 * type-ascriptive suffix operator --
 * one of these forms
 * 
 * ```
 * satisfies T
 * 
 * : T
 * 
 * @ &lt;query&gt;
 * 
 * is &lt;query&gt;
 * ```
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
  : ctx.SpclSdfYielding[AscriptiveExprPr[ctx.grmMetadataWrapMode.type ] ]
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
          .map({ case (scrutMode @ (Keyword( kwd @ ("@" | "is") ) ) ) => {
            Keyword (kwd )
          } } )
          .withFinalPtrPosVl()

          +%:

          ForTermQueryExpr()

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
          .map({ case (scrutMode @ (Keyword( kwd @ (":" | "satisfies") ) )  ) => {
            Keyword(kwd )
          } } )
          .withFinalPtrPosVl()

          +%:

          ForTypeQueryExpr()

          +%:

          lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
        )
        .map({
          //
          case (iTypeKw0 , vl) =>
            ;
            (for { iTypeKw <- iTypeKw0 }
            yield ((iTypeKw, vl) match {
              //

              case (iTypeKw @ Keyword("satisfies"), vl) => {
                // (iTypeKw, vl )
                SatisfiaScrutiveAscription(vl )
              }
              case (iTypeKw @ Keyword(":") , vl) => {
                // (iTypeKw, vl )
                ToTypeScrutiveAscription(vl )
              }
            }))
            .value
        })
      )
      .withFinalPtrPosVl()
    })
  }.nn

  ;
}

// TODO
export lscc.spclGrammar.forTermOrTypeLevelExprs.{AscriptiveExpr,AscriptiveExprPr }
export lscc.spclGrammar.forTermOrTypeLevelExprs.{ ToTermPatternScrutiveAscription, ToTypeScrutiveAscription, SatisfiaScrutiveAscription}



export lscc.spclGrammar.forTermOrTypeLevelExprs.{PrefixScrutLhsExpr }









