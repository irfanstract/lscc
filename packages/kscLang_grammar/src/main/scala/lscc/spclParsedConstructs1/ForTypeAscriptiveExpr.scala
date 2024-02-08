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

//   /** to impose `prsWhitespaceableHeadTailConcatOp` */
//   import fwscImplicits.prsWhitespaceableHeadTailConcatOp

//   // def (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl { val basePxery : ctx.type } )

  // transparent inline /* a must-have modifier for forwarders */
  // def apply
  //   //
  //   (using ctx: SpclGrammaticalPxery )
  //   //
  //   (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
  //   ( )
  // : ctx.SpclSdfYielding[TermOrTypeAscribedExprImplAst.ForApmType[ctx.grmMetadataWrapMode.type ] ]
  // = {
  //   import m.given

  //   given m.spclUnprefixedKeywdingMode.type
  //   = m.spclUnprefixedKeywdingMode

  //   forMode(m )
  // }

//   transparent inline /* a necessary modifier for forwarders */
//   def forMode
//     //
//     (using ctx: SpclGrammaticalPxery )
//     (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
//   : ctx.SpclSdfYielding[TermOrTypeAscribedExprImplAst.ForApmType[ctx.grmMetadataWrapMode.type ] ]
//   = {
//     import m.given
//     given m.spclUnprefixedKeywdingMode.type
//     = m.spclUnprefixedKeywdingMode

//     withImplicitKwdIngCtx( )
//   }

  // protected
  // def withImplicitKwdIngCtx
  //   //
  //   (using ctx: SpclGrammaticalPxery )
  //   (using reprCtx: (
  //     // TODO
  //     lscc.spclGrammar.forTermAscriptiveScrut.IAscriptiveExprGrammmaticalReprSupport {
  //       //
  //     }
  //   ) )
  //   (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
  //   ()
  // : ctx.SpclSdfYielding[TermOrTypeAscribedExprImplAst.ForApmType[ctx.grmMetadataWrapMode.type ] ]
  // = {
  //   ;

  //   import ctx.given
  //   import ctx.givenFispoSupp
  //   import ctx.givenFispoSupp.InputState as PAny

  //   ({
  //     ;


  //     ({
  //       ;

  //       ({
  //         ;

  //         val headRule
  //         =
  //           ForUnparenthesedSimpleHeadBindingExpr()
  //           .withLogging1(mainMsg = "ForBindingFirstTermOrTypeAscribedExprP.HeadBinding")

  //         val tailRule
  //         =
  //           ForTermOrTypeAscriptiveInfixAndRhs()
  //           .withLogging1(mainMsg = "ForBindingFirstTermOrTypeAscribedExprP.TailAscription")

  //         (
  //           headRule

  //           +++%:

  //           tailRule

  //           ++%:

  //           lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
  //         )
  //         .withLogging1(mainMsg = s"ForBindingFirstTermOrTypeAscribedExprP.L135")
  //         .map(e => {
  //           e
  //         } )
  //         .map({ case (bindingExpr, s) => {
  //           TermOrTypeAscribedExprImplAst(bindingSideExpr = bindingExpr, ascriptiveSideExpr = s )
  //         } } )
  //         .withLogging1(mainMsg = s"ForBindingFirstTermOrTypeAscribedExprP.L142")
  //         .nn
  //       })
  //     })
  //   })
  //   .withFinalPtrPosVl()
  //   .withLogging1(mainMsg = "ForBindingFirstTermOrTypeAscribedExprP")
  // }.nn

  ;
}

// export lscc.spclGrammar.forTermOrTypeLevelExprs.{TermOrTypeAscribedExprImplAst }






export ForTermOrTypeAscriptiveInfixAndRhs.apply as forTermOrTypeAscriptiveInfixAndRhs

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

  import IRegExp.tagImplicits.r

  def apply 
    //
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclGrammar.IReservedWords.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    (using reprCtx: (
      // TODO
      lscc.spclGrammar.forTermAscriptiveScrut.IAscriptiveExprGrammmaticalReprSupport {
        //
      }
    ) )
    ()
  : ctx.SpclSdfYielding[reprCtx.TermOrTypeAscribedExprImplAst ]
  = {
    ;

    import ctx.given
    import ctx.givenFispoSupp.InputState as PAny
    import ctx.givenFispoSupp

    import reprCtx.{TermOrTypeAscribedExprImplAst, PrefixScrutLhsExpr}

    ({
      ;

      // TODO
      enum SpclAscriptiveMode1
        (
          val conformedExprLvl : lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type] , val tagPattern : IRegExp._Any )
      // extends java.lang.Enum[SpclAscriptiveMode1]
      {
        ;

        given conformedExprLvl.type = conformedExprLvl

        case ToTerm extends SpclAscriptiveMode1 (
          conformedExprLvl = lscc.spclGrammar.forTermOrTypeLevelExprs.forTermLevelC() ,
          tagPattern = """\@|:={1,2}|={1,2}:|={2,3}|=|is|was""".r )
        //

        case ToType extends SpclAscriptiveMode1 (
          conformedExprLvl = lscc.spclGrammar.forTermOrTypeLevelExprs.forTypeLevelC() ,
          tagPattern = """\:|implements|satisfies""".r )
        //

        def name
        = productPrefix

        def taglinePrf
        = {
          ;

          ForOccurringGeneralisedKeyword.forPattern(tagPattern )
          .map({ case  kwd => {
            Keyword (kwd )
          } } )
          .withFinalPtrPosVl()
          .withLogging1(mainMsg = s"ForTermOrTypeAscriptiveInfixAndRhs.${name}.LeadKeyWord()")
        }

        lazy val latterSideExprPrf
        = {
          ForQueryExpr1.withMode(conformedExprLvl)
          .withLogging1(mainMsg = s"ForTermOrTypeAscriptiveInfixAndRhs.${name}.Main(${kwIngCtx })")
        }

        lazy val fullExprPrf1 = (
          taglinePrf

          +++%:

          latterSideExprPrf

          ++%:
            lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
        )
      }

      (
        //

        SpclAscriptiveMode1.ToTerm.fullExprPrf1
        .map({ case (iTypeKw, vl) => {
          // (iTypeKw, vl )
          ToTermPatternScrutiveAscription(vl )
        } })
        .withLogging1(mainMsg = s"ForTermOrTypeAscriptiveInfixAndRhs.ToTermEquiv(${kwIngCtx })")

        orElse

        SpclAscriptiveMode1.ToType.fullExprPrf1
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
// export lscc.spclGrammar.forTermOrTypeLevelExprs.{AscriptiveExpr,AscriptiveExprPr }
export lscc.spclGrammar.forTermOrTypeLevelExprs.{ ToTermPatternScrutiveAscription, ToTypeScrutiveAscription, SatisfiaScrutiveAscription}



// export lscc.spclGrammar.forTermOrTypeLevelExprs.{PrefixScrutLhsExpr }









