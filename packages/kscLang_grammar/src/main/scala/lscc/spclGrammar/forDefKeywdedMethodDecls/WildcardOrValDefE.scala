package lscc.spclGrammar.forDefKeywdedMethodDecls

















// TODO
object UnderscoreWildcardDefOnly1
{
  ;

  import lscc.spclParsedConstructs1.SpclGrammaticalPxery

  import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
  import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

  /**
   * `__`
   * 
   */
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclGrammar.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[UnderscoreWildcardPatternImpl._Any ]
  = ({
    ;

    import ctx.given

    lscc.spclGrammar.forDefKeywdedMethodDecls.UnderscoreWildcardPatternPrf.apply()
    .match { case f => f : ctx.SpclSdfYieldingUnwrapped[String ] }
    .mapMainValue(UnderscoreWildcardPatternImpl.forExactSrcLevelToken(_) )
    .withFinalPtrPosVl()

    .withLogging1(mainMsg = s"ForUnderscoreWildcardDefOnly(${kwIngCtx })")
  }).nn

  ;
}

object UnderscoreWildcardPatternImpl {
  ;
  type _Any
  = UnderscoreWildcardPatternImpl[?]
  def forExactSrcLevelToken(value: String)
  : _Any
  = new UnderscoreWildcardPatternImpl()
}
case class UnderscoreWildcardPatternImpl[T] private [UnderscoreWildcardPatternImpl] ()




import lscc.spclGrammar.forTermOrTypeLevelExprs.ValDefOnlyAst

/**
 * 
 * exclusively a sequence a Taglining Keyword `val` and then a BindingNameIsh,
 * without anything else
 * 
 * `val example1`, `val exampleSome`
 * 
 */
object ForValDefOnly
{
  ;

  import lscc.spclParsedConstructs1.SpclGrammaticalPxery

  import glscc.spclTerminalGrammars.{Keyword, FixedIdentifier}
  import glscc.spclTerminalGrammars.{ FixedIdentifier as Identifier}

  import lscc.spclGrammar.forTermOrTypeLevelExprs.ValDefOnlyAst

  import lscc.spclParsedConstructs1.ForOccurringKeywordOrRefP

  transparent inline // delegating methods shall always be `tr inline`
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclGrammar.IReservedWords.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[ValDefOnlyAst._Any ]
  = apply(mainBindingIdentKwdIngMode = kwIngCtx ).nn

  /**
   * `val example1`, `val exampleSome`
   * 
   */
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclGrammar.IReservedWords.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    (mainBindingIdentKwdIngMode: lscc.spclGrammar.IReservedWords.WithGivenFispoSupp[ctx.givenFispoSupp.type ]  )
  : ctx.SpclSdfYielding[ValDefOnlyAst._Any ]
  = {
    ;

    import ctx.given
    import ctx.{givenFispoSupp, grmMetadataWrapMode, expcRx}

    import givenFispoSupp.InputState as PAny

    ({
      ;

      /** 
       * impose
       * altered definition of the WithFilter ops, which is better for this usage.
       * 
       */
      import lscalg.parsing.ParseFunction.returnedMainValueMapOpImplicits.given
      import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

      ({
        ;

        ({
          ;

          val tagliningKwPrf
          = (
            //

            ForOccurringKeywordOrRefP()
            .collect({ case (Keyword(iTypeKwd @ ("val" | "const" | "let" ) )) => Keyword(iTypeKwd) } )
            .withFinalPtrPosVl()
            .withLogging1(mainMsg = s"ForValDefOnly.Tag(${kwIngCtx })")
          )

          val bindingNameTokenPrf
          = (
            //

            lscc.spclGrammar.IReservedWords.withSp(mainBindingIdentKwdIngMode )({
              ForOccurringKeywordOrRefP()
            })
            .collect({ case s @ (Identifier(ident)) => (ident ) } )
            .withFinalPtrPosVl()
            .withLogging1(mainMsg = s"ForValDefOnly.MainBindingToken(${kwIngCtx })")
          )

          (
            tagliningKwPrf

            +++%:

            bindingNameTokenPrf

            ++%:

            lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
          )
          .map({ case (iType, ident) => ValDefOnlyAst(ident = ident, iTypeKw = iType ) } )
        })
        .withFinalPtrPosVl()
        .withLogging1(mainMsg = s"ForValDefOnly(${kwIngCtx })")
      })
    })
    .nn
  }

  ;
}








