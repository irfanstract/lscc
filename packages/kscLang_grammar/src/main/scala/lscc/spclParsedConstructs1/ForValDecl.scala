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
      import lscalg.parsing.ParseFunction.returnedMainValueMapOpImplicits.given
      import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

      ({
        ;

        ({
          ;

          import fwscImplicits.prsWhitespaceableHeadTailConcatOp

          val tagliningKwPrf
          = (
            //

            ForOccurringKeywordOrRefP()
            .collect({ case (Keyword(iTypeKwd @ ("val" | "const" | "let" ) )) => Keyword(iTypeKwd) } )
            .withFinalPtrPosVl()
          )

          val bindingNameTokenPrf
          = (
            //

            lscc.spclParsedConstructs1.KeywordingCtx.withSp(mainBindingIdentKwdIngMode )({
              ForOccurringKeywordOrRefP()
            })
            .collect({ case s @ (Identifier(ident)) => (ident ) } )
            .withFinalPtrPosVl()
          )

          (
            tagliningKwPrf

            +%:

            bindingNameTokenPrf

            +%:

            // ForTermOrTypeAscriptiveInfixAndRhs()

            // +%:
              
            lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
          )
          .map({ case (iType, ident) => FvdParsed(ident = ident, iTypeKw = iType ) } )
        })
        .withFinalPtrPosVl()
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










