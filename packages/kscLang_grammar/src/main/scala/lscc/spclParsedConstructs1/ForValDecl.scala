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
    // (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    // (using apMode : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ] )
    // (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    // (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , apMode.AfterSi[UnderscoreWildcardPatternImpl._Any ] ]
  : ctx.SpclSdfYielding[UnderscoreWildcardPatternImpl._Any ]
  = ({
    ;

    import ctx.given

    ForUnderscoreWildcardPattern.apply()
    .mapWithFinalPtrPosVl((vl, pos) => {
      UnderscoreWildcardPatternImpl.forExactSrcLevelToken(vl )
      .withSrcInfo(srcPosInfo = pos )
    } )
    .nn
  })

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




object ForValDefOnly
{
  ;

  /**
   * `val example1`, `val exampleSome`
   * 
   */
  transparent inline // delegating methods shall always be `tr inline`
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[FvdParsed._Any ]
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
  : ctx.SpclSdfYielding[FvdParsed._Any ]
  = {
    ;

    import ctx.given
    import ctx.{givenFispoSupp, apMode, expcRx}

    import givenFispoSupp.T as PAny

    ({
      ;

      /** 
       * impose
       * altered definition of the WithFilter ops, which is better for this usage.
       * 
       */
      import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
      import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

      ({
        ;

        ({
          ;

          import fwscImplicits.prsWhitespaceableHeadTailConcatOp

          (
            ForOccurringKeywordOrRefP()
            .collect({ case (Keyword(iTypeKwd @ ("val" | "const" | "let" ) )) => Keyword(iTypeKwd) } )
            .mapWithFinalPtrPosVl({ case (vl, pos) => vl.withSrcInfo(srcPosInfo = pos) })

            +%:

            lscc.spclParsedConstructs1.KeywordingCtx.withSp(mainBindingIdentKwdIngMode )({
              ForOccurringKeywordOrRefP()
            })
            .collect({ case (Identifier(ident)) => (ident ) } )
            .mapWithFinalPtrPosVl({ case (vl, pos) => vl.withSrcInfo(srcPosInfo = pos) })

            +%:

            // ForScrutOperatorAndRhs()

            // +%:
              
            lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
          )
          .map({ case (iType, ident) => FvdParsed(ident = ident, iTypeKw = iType ) } )
        })
        .mapWithFinalPtrPosVl({ case (vl, pos) => vl.withSrcInfo(srcPosInfo = pos) })
      })
    })
    .nn
  }

  ;
}

object FvdParsed
{
  ;

  type _Any
  = FvdParsed[?, ?]

  ;
}

case class FvdParsed
  [
    +Ident,
    +IType ,
  ] (
    ident : Ident ,
    iTypeKw : IType ,
  )










