package lscc.spclGrammar.forTermAscriptiveScrut














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
object UnparenedBindingFirstTermOrTypeAscribedExprPrf
{
  ;

  /* RELEVANT UTILITY IMPORTS */

  ;

  /* RELEVANT ON-TOPIC IMPORTS */

  ;

  /* IMPLEMENTATIVE -- SYNTACTIC IMPORTS */

  ;

  transparent inline /* a must-have modifier for forwarders */
  def apply
    //
    (using ctx: lscc.spclParsedConstructs1.SpclGrammaticalPxery )
    (using reprCtx: (
      // TODO
      lscc.spclGrammar.forTermAscriptiveScrut.IAscriptiveExprGrammmaticalReprSupport.OfSpecificMetaDataWrapMode[ctx.grmMetadataWrapMode.type ]
    ) )
    //
    (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
    ( )
  : ctx.SpclSdfYielding[reprCtx.TermOrTypeAscribedExprImplAst ]
  = {
    import m.given

    given m.spclUnprefixedKeywdingMode.type
    = m.spclUnprefixedKeywdingMode

    applyImpl()
  }.nn

  protected
  def applyImpl
    //
    (using ctx: lscc.spclParsedConstructs1.SpclGrammaticalPxery )
    (using reprCtx: (
      // TODO
      lscc.spclGrammar.forTermAscriptiveScrut.IAscriptiveExprGrammmaticalReprSupport.OfSpecificMetaDataWrapMode[ctx.grmMetadataWrapMode.type ]
    ) )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[reprCtx.TermOrTypeAscribedExprImplAst ]
  = {
    ;

    import ctx.given
    import ctx.givenFispoSupp
    import ctx.givenFispoSupp.InputState as PAny

    import reprCtx.{TermOrTypeAscribedExprImplAst, PrefixScrutLhsExpr}

    import ctx.spclSdpExtraOpsImplicits.given

    ({
      ;

      import lscc.spclParsedConstructs1.{ForPossiblyParenthesisedExpr }

      ({
        ;

        ({
          ;

          val headRule
          = {
            ;
            import lscc.spclParsedConstructs1.ForUnparenthesedSimpleHeadBindingExpr

            ({
              ;
              ForPossiblyParenthesisedExpr({
                ForUnparenthesedSimpleHeadBindingExpr()
              })
              .mapMainValue(e => {
                for {
                  (v0, _) <- e
                  v = v0.value
                }
                yield v
              })
            })
            .withLogging1(mainMsg = "UnparenedBindingFirstTermOrTypeAscribedExprP.HeadBinding")
          }

          val tailRule
          = {
            ;
            import lscc.spclGrammar.forTermAscriptiveScrut.UnparenedFbfSpecificToTermOrTypeAscriptiveInfixAndRhsPrf as ForTermOrTypeAscriptiveInfixAndRhs

            ForTermOrTypeAscriptiveInfixAndRhs()
            .withLogging1(mainMsg = "UnparenedBindingFirstTermOrTypeAscribedExprP.TailAscription")
          }

          (
            headRule

            +++%:

            tailRule

            ++%:

            ctx.prsfNil
          )
          .withLogging1(mainMsg = s"UnparenedBindingFirstTermOrTypeAscribedExprP.L135")
          .map(e => {
            e
          } )
          .map({ case e @ (bindingExpr, s) => {
            TermOrTypeAscribedExprImplAst(
              bindingSideExpr = bindingExpr
              ,
              ascriptiveSideExpr = (for (sv <- s) yield sv.ascriptiveSideExpr ).value
              ,
            )
          } } )
          .withLogging1(mainMsg = s"UnparenedBindingFirstTermOrTypeAscribedExprP.L142")
          .nn
        })
      }) 
    })
    .withFinalPtrPosVl()
    .withLogging1(mainMsg = "UnparenedBindingFirstTermOrTypeAscribedExprP")
  }.nn

  ;
}



/**
 * 
 * type-ascriptive suffix operator --
 * one of these forms
 * 
 * ```
 * // 'SATISFIES'
 * 
 * satisfies T
 * 
 * // 'IMPLEMENTS'
 * 
 * implements T
 * 
 * : T
 * 
 * // 'IS'
 * 
 * @ &lt;query&gt;
 * 
 * is &lt;query&gt;
 * ```
 * 
 */
object UnparenedFbfSpecificToTermOrTypeAscriptiveInfixAndRhsPrf
{ 
  ;

  /* RELEVANT UTILITY IMPORTS */

  import lscalg.bnfParsing.IRegExp

  ;

  /* RELEVANT ON-TOPIC IMPORTS */

  import lscc.spclParsedConstructs1.SpclGrammaticalPxery

  ;

  /* IMPLEMENTATIVE -- SYNTACTIC IMPORTS */

  import IRegExp.tagImplicits.r

  ;

  def apply 
    //
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclGrammar.IReservedWords.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    (using reprCtx: (
      // TODO
      lscc.spclGrammar.forTermAscriptiveScrut.IAscriptiveExprGrammmaticalReprSupport.OfSpecificMetaDataWrapMode[ctx.grmMetadataWrapMode.type ] {
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

    import ctx.spclSdpExtraOpsImplicits.given

    ({
      ;

      import glscc.spclTerminalGrammars.{Keyword, FixedIdentifier }

      import lscc.spclGrammar.forTermOrTypeLevelExprs.{forTermLevelC , forTypeLevelC }

      // TODO
      enum SpclAscriptiveMode1
        (
          val conformedExprLvl :
            lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type]
          ,
          val tagPattern :
            IRegExp._Any
          ,
      )
      // extends java.lang.Enum[SpclAscriptiveMode1]
      {
        ;

        given conformedExprLvl.type
        = conformedExprLvl

        case ToTerm extends SpclAscriptiveMode1 (
          conformedExprLvl = forTermLevelC() ,
          tagPattern = """\@|:={1,2}|={1,2}:|={2,3}|=|is|was""".r )
        //

        case ToType extends SpclAscriptiveMode1 (
          conformedExprLvl = forTypeLevelC() ,
          tagPattern = """\:|implements|satisfies""".r )
        //

        /** `name` only built-in for `java.lang.Enum`. this is esentially `productPrefix`. */
        def name
        = productPrefix

        import lscc.spclParsedConstructs1.{ForQueryExpr1}

        import lscc.spclParsedConstructs1.{ForOccurringGeneralisedKeyword}

        def taglinePrf
        = {
          ;

          ({
            ;
            ForOccurringGeneralisedKeyword.forPattern(tagPattern )
            .map({ case  kwd => {
              Keyword (kwd )
            } } )
            .withFinalPtrPosVl()
          })
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
            ctx.prsfNil
        )
      }

      import glscc.spclTerminalGrammars.{Keyword, FixedIdentifier }

      import lscc.spclGrammar.forTermOrTypeLevelExprs.{ ToTermPatternScrutiveAscription, ToTypeScrutiveAscription, SatisfiaScrutiveAscription}

      val toTermAscriptivePrf
      = {
        ;

        SpclAscriptiveMode1.ToTerm.fullExprPrf1
        .map({ case (iTypeKw, vl) => {
          // (iTypeKw, vl )
          ToTermPatternScrutiveAscription(vl )
        } })
        .withLogging1(mainMsg = s"ForTermOrTypeAscriptiveInfixAndRhs.ToTermEquiv(${kwIngCtx })")
      }

      val toTypeAscriptivePrf
      = {
        ;

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
              case (iTypeKw , vl) => {
                // (iTypeKw, vl )
                ToTypeScrutiveAscription(vl )
              }
            }))
            .value
        })
        .withLogging1(mainMsg = s"ForTermOrTypeAscriptiveInfixAndRhs.ToType(${kwIngCtx })")
      }

      (
        //

        toTermAscriptivePrf

        orElse

        toTypeAscriptivePrf
      )
      .withFinalPtrPosVl()
      .withLogging1(mainMsg = s"ForTermOrTypeAscriptiveInfixAndRhs(${kwIngCtx })")
    })
  }.nn

  ;
}









