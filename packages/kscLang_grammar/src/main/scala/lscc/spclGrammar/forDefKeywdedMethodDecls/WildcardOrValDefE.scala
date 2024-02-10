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




import lscc.spclGrammar.forTermOrTypeLevelExprs.ValDefAlikeOnlyAst

/**
 * 
 * exclusively a sequence a Taglining Keyword `val` and then a BindingNameIsh,
 * without anything else
 * 
 * `val example1`, `val exampleSome`
 * 
 */
object UnparenthesedUntypedValDefAlike
{
  ;

  import lscc.spclParsedConstructs1.SpclGrammaticalPxery

  import glscc.spclTerminalGrammars.{Keyword, FixedIdentifier}
  import glscc.spclTerminalGrammars.{ FixedIdentifier as Identifier}

  import lscc.spclGrammar.forTermOrTypeLevelExprs.ValDefAlikeOnlyAst

  import lscc.spclParsedConstructs1.ForOccurringKeywordOrRefP

  transparent inline // delegating methods shall always be `tr inline`
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (using reprCtx : lscc.spclGrammar.forTermAscriptiveScrut.IAscriptiveExprGrammmaticalReprSupport.OfSpecificMetaDataWrapMode[ctx.grmMetadataWrapMode.type ] )
    (using kwIngCtx : lscc.spclGrammar.IReservedWords.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[ValDefAlikeOnlyAst._Any ]
  = apply(mainBindingIdentKwdIngMode = kwIngCtx ).nn

  /**
   * `val example1`, `val exampleSome`
   * 
   */
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (using reprCtx : lscc.spclGrammar.forTermAscriptiveScrut.IAscriptiveExprGrammmaticalReprSupport.OfSpecificMetaDataWrapMode[ctx.grmMetadataWrapMode.type ] )
    (using kwIngCtx : lscc.spclGrammar.IReservedWords.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    (mainBindingIdentKwdIngMode: lscc.spclGrammar.IReservedWords.WithGivenFispoSupp[ctx.givenFispoSupp.type ]  )
  : ctx.SpclSdfYielding[reprCtx.UntypedValDefAlikeAst ]
  = {
    ;

    import ctx.given

    ({
      ;

      import ctx.spclSdpExtraOpsImplicits.given

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
            .withLogging1(mainMsg = s"UnparenthesedUntypedValDefAlike.Tag(${kwIngCtx })")
          )

          val bindingNameTokenPrf
          = (
            //

            lscc.spclGrammar.IReservedWords.withSp(mainBindingIdentKwdIngMode )({
              ForOccurringKeywordOrRefP()
            })
            .collect({ case s @ (Identifier(ident)) => (ident ) } )
            .withFinalPtrPosVl()
            .withLogging1(mainMsg = s"UnparenthesedUntypedValDefAlike.MainBindingToken(${kwIngCtx })")
          )

          (
            tagliningKwPrf

            +++%:

            bindingNameTokenPrf

            ++%:

            ctx.prsfNil
          )
          .map({ case (iType, ident) => {
            ValDefAlikeOnlyAst(ident = ident, iTypeKw = iType )
          } } )
        })
        .withFinalPtrPosVl()
        .withLogging1(mainMsg = s"UnparenthesedUntypedValDefAlike(${kwIngCtx })")
      })
    })
    .match { case e => (
      e
    ) }
  }

  ;
}






object UnparenthesedSimpleHeadBindingExprPrf
{
  ;

  import lscc.spclParsedConstructs1.SpclGrammaticalPxery

  import glscc.spclTerminalGrammars.{Keyword, FixedIdentifier}
  import glscc.spclTerminalGrammars.{ FixedIdentifier as Identifier}

  import lscc.spclGrammar.forTermOrTypeLevelExprs.ValDefAlikeOnlyAst

  import lscc.spclParsedConstructs1.ForOccurringKeywordOrRefP
  def apply
    //
    (using grmCtx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclGrammar.KeywordingCtx.WithGivenFispoSupp[grmCtx.givenFispoSupp.type ] )
    (using reprCtx : lscc.spclGrammar.forTermAscriptiveScrut.IAscriptiveExprGrammmaticalReprSupport.OfSpecificMetaDataWrapMode[grmCtx.grmMetadataWrapMode.type ] )
    ()
  : grmCtx.SpclSdfYielding[reprCtx.PrefixScrutLhsExpr ]
  = {
    ;

    import reprCtx.PrefixScrutLhsExpr

    import grmCtx.given
    import grmCtx.spclSdpExtraOpsImplicits.given

    ;

    (
      UnparenthesedUntypedValDefAlike().map(_.value )
      .map(e => {
        PrefixScrutLhsExpr.ForValDef(e) : PrefixScrutLhsExpr.ForValDef
      } )

      orElse

      UnderscoreWildcardDefOnly1().map(_.value )
      .map(e => {
        PrefixScrutLhsExpr.ForIgnorableWildcard() : PrefixScrutLhsExpr.ForIgnorableWildcard
      } )
    )
    .withFinalPtrPosVl()
    .withLogging1(mainMsg = s"ForUnparenthesedSimpleHeadBindingExpr")
  }.nn

  ;
}








