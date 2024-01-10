package lscc.spclParsedConstructs1


















;

object ForOccurringKeyword
{
  ;

  /**
   * the items the `KeywordingCtx` `kwIngCtx` would consider "reserved".
   * 
   * implemented as `kwIngCtx.asParseSubject`.
   * 
   */
  def apply
    //
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    ()
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T, givenFispoSupp.SpclMatchContent ]
  = {
    ;

    import givenFispoSupp.T as PAny

    kwIngCtx.asParseSubject
  }

  ;
}

object ForOccurringKeywordOrRef
{
  ;

  /**
   * `ForOccurringKeywordOrRef` specific to `kwIngCtx`.
   * first, `ForOccurringKeyword`, and then, as fallback, `ForImmediateUnescapedWord`.
   * 
   */
  def apply
    //
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T, Keyword[String] | Identifier[String] ]
  = {
    ;

    import givenFispoSupp.T as PAny

    (
      ForOccurringKeyword()
      .mapMainValue(v => Keyword(v.matchedStr) )

      orElse

      (ForImmediateUnescapedWord() orElse ForImmediateEscapedIdent() )
      .mapMainValue(v => Identifier(v.matchedStr) )

    )
  }

  ;
}




object ForValDefOnly
{
  ;

  /**
   * `val example1`, `val exampleSome`
   * 
   */
  def apply
    //
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    // (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  = {
    ;

    import givenFispoSupp.T as PAny

    ({
      ;

      /** 
       * impose
       * altered definition of the WithFilter ops, which is better for this usage.
       * 
       */
      import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1

      ({
        ;

        val cPr = ForTermLevelUnprefixedKeyword()

        ({
          ;
          given cPr.type = cPr

          import lscalg.parsing.subjectConcatOps1.given

          ({
            import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
          })

          (
            ForOccurringKeywordOrRef()
            .collect({ case iTypeKw @ (Keyword(iType @ ("val" | "const" | "let" ) )) => iTypeKw } )

            +%:

            ForOccurringKeywordOrRef()
            .collect({ case (Identifier(ident)) => (ident ) } )

            +%:

            lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
          )
          .map({ case (iType, ident) => (ident, iType ) } )
        })
        .map({ case s @ (ident *: iType *: _ ) => s } )
      })
    })
  }

  ;
}










