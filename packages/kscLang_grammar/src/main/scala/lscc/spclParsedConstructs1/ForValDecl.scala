package lscc.spclParsedConstructs1


















;




;





;

object ForUnderscoreWildcardDefOnly {
  ;

  import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
  import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

  /**
   * `__`
   * 
   */
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[UnderscoreWildcardPatternImpl._Any ]
  = ({
    ;

    import ctx.given

    ForUnderscoreWildcardPattern.apply()
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

  transparent inline // delegating methods shall always be `tr inline`
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
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
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    (mainBindingIdentKwdIngMode: lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ]  )
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

          /**
           * won't work if these `import`s were placed outside this method.
           */
          import fwscImplicits.prsWhitespaceableHeadTailConcatOp
          import lscalg.digestivity.subjectConcatOps1.prsHeadTailConcatOp.{+%: as +:}

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

            lscc.spclParsedConstructs1.KeywordingCtx.withSp(mainBindingIdentKwdIngMode )({
              ForOccurringKeywordOrRefP()
            })
            .collect({ case s @ (Identifier(ident)) => (ident ) } )
            .withFinalPtrPosVl()
            .withLogging1(mainMsg = s"ForValDefOnly.MainBindingNameExpr(${kwIngCtx })")
          )

          (
            tagliningKwPrf

            +%:

            bindingNameTokenPrf

            +:

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

export lscc.spclGrammar.forTermOrTypeLevelExprs.ValDefOnlyAst






object ForUnparenthesedSimpleHeadBindingExpr {
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

    import ctx.givenFispoSupp.InputState as PAny

    import lscalg.parsing.ParseFunction.returnedMainValueMapOpImplicits.given
    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

    ;

    (
      ForValDefOnly().map(_.value )
      .map(e => {
        PrefixScrutLhsExpr.ForValDef(e) : PrefixScrutLhsExpr.ForValDef
      } )

      orElse

      ForUnderscoreWildcardDefOnly().map(_.value )
      .map(e => {
        PrefixScrutLhsExpr.ForIgnorableWildcard() : PrefixScrutLhsExpr.ForIgnorableWildcard
      } )
    )
    .withFinalPtrPosVl()
    .withLogging1(mainMsg = s"ForUnparenthesedSimpleHeadBindingExpr")
  }.nn

  ;
}












