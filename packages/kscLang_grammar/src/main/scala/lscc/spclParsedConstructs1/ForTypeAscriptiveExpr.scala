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

  // def (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl { val basePxery : ctx.type } )

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
    import ctx.givenFispoSupp.InputState as PAny

    ({
      ;


      ({
        ;

        ({
          ;

          /**
           * won't work if these `import`s were placed outside this method.
           */
          import fwscImplicits.prsWhitespaceableHeadTailConcatOp
          import lscalg.digestivity.subjectConcatOps1.prsHeadTailConcatOp.{+%: as +:}

          val headRule
          =
            ForUnparenthesedSimpleHeadBindingExpr()
            .withLogging1(mainMsg = "ForBindingFirstTermOrTypeAscribedExprP.HeadBinding")

          val tailRule
          =
            ForTermOrTypeAscriptiveInfixAndRhs()
            .withLogging1(mainMsg = "ForBindingFirstTermOrTypeAscribedExprP.TailAscription")

          (
            headRule

            +%:

            tailRule

            +:

            lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
          )
          .withLogging1(mainMsg = s"ForBindingFirstTermOrTypeAscribedExprP.L135")
          .map(e => {
            e
          } )
          .map({ case (bindingExpr, s) => {
            TermOrTypeAscribedExprImplAst(bindingSideExpr = bindingExpr, ascriptiveSideExpr = s )
          } } )
          .withLogging1(mainMsg = s"ForBindingFirstTermOrTypeAscribedExprP.L142")
          .nn
        })
      })
    })
    .withFinalPtrPosVl()
    .withLogging1(mainMsg = "ForBindingFirstTermOrTypeAscribedExprP")
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

  import lscalg.bnfParsing.IRegExp

  import lscalg.parsing.ParseFunction.returnedMainValueMapOpImplicits.given
  import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

  import lscalg.parsing.subjectConcatOps1.given

  /** to impose `prsWhitespaceableHeadTailConcatOp` */
  import fwscImplicits.prsWhitespaceableHeadTailConcatOp

  import IRegExp.tagImplicits.r

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
    import ctx.givenFispoSupp.InputState as PAny
    import ctx.givenFispoSupp

    /**
     * won't work if these `import`s were placed outside this method.
     */
    import fwscImplicits.prsWhitespaceableHeadTailConcatOp
    import lscalg.digestivity.subjectConcatOps1.prsHeadTailConcatOp.{+%: as +:}

    ({
      ;

      (
        //

        (
          ForOccurringGeneralisedKeyword.forPattern("""\@|is|was""".r )
          .map({ case  kwd => {
            Keyword (kwd )
          } } )
          .withFinalPtrPosVl()
          .withLogging1(mainMsg = s"ForTermOrTypeAscriptiveInfixAndRhs.ToTermEquiv.LeadKeyWord(${kwIngCtx })")

          +%:

          ForTermQueryExpr()
          .withLogging1(mainMsg = s"ForTermOrTypeAscriptiveInfixAndRhs.ToTermEquiv.Main(${kwIngCtx })")

          +:

          lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
        )
        .map({ case (iTypeKw, vl) => {
          // (iTypeKw, vl )
          ToTermPatternScrutiveAscription(vl )
        } })
        .withLogging1(mainMsg = s"ForTermOrTypeAscriptiveInfixAndRhs.ToTermEquiv(${kwIngCtx })")

        orElse

        (
          ForOccurringGeneralisedKeyword.forPattern("""\:|implements|satisfies""".r )
          .map({ case  kwd => {
            Keyword (kwd )
          } } )
          .withFinalPtrPosVl()

          +%:

          ForTypeQueryExpr()

          +:

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
        .withLogging1(mainMsg = s"ForTermOrTypeAscriptiveInfixAndRhs.ToType(${kwIngCtx })")
      )
      .withFinalPtrPosVl()
      .withLogging1(mainMsg = s"ForTermOrTypeAscriptiveInfixAndRhs(${kwIngCtx })")
    })
  }.nn

  ;
}

// TODO
export lscc.spclGrammar.forTermOrTypeLevelExprs.{AscriptiveExpr,AscriptiveExprPr }
export lscc.spclGrammar.forTermOrTypeLevelExprs.{ ToTermPatternScrutiveAscription, ToTypeScrutiveAscription, SatisfiaScrutiveAscription}



export lscc.spclGrammar.forTermOrTypeLevelExprs.{PrefixScrutLhsExpr }









