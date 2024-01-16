package lscc.spclParsedConstructs1


















;

object ForPrefixedExpr {
  ;

  def apply
    //
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using apMode : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ] )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  = {
    (
      ForPrefixedScrutTermLvlExpr()
    )
  }

  ;
}




;

object ForPrefixedScrutTermLvlExpr
{
  ;

  // val kwIngCtx
  // = ForTermLevelUnprefixedKeyword()

  ;

  /**
   * `val example1 @ (expr)`, `val exampleSome : T`
   * 
   */
  def apply
    //
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using apMode : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ] )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , FvdParsed._Any ]
  = {
    ;

    import givenFispoSupp.T as PAny
    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

    ({
      ;


      ({
        ;

        ({
          ;

          import fwscImplicits.prsWhitespaceableHeadTailConcatOp

          (
            ForPrefixingScrutTermLvlExpr()

            +%:

            ForScrutSyntactic()

            +%:

            lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
          )
          .map({ case (bindingExpr, s) => bindingExpr } )
        })
      })
    })
  }

  ;
}

object ForPrefixingScrutTermLvlExpr {
  ;

  def apply
    //
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using apMode : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ] )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  = {
    ;

    import givenFispoSupp.T as PAny
    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1
    
    ;

    (
      ForValDefOnly()
      .map(e => {
        e.map(PrefixScrutLhsExpr.ForValDef.apply _ )
      } )

      orElse

      ForUnderscoreWildcardDefOnly()
      .map(e => {
        e.map(_ => PrefixScrutLhsExpr.ForIgnorableWildcard() )
      } )
    )
  }

  ;
}

enum PrefixScrutLhsExpr {
  ;

  case ForIgnorableWildcard()

  case ForValDef(value: FvdParsed._Any )

}





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
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using apMode : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ] )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  = (
    ForUnderscoreWildcardPattern.apply()
    .mapWithFinalPtrPosVl((vl, pos) => {
      vl
      .withSrcInfo(srcPosInfo = pos )
    } )
  )

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
    (using apMode : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ] )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , FvdParsed._Any ]
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
      import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

      ({
        ;

        ({
          ;

          import fwscImplicits.prsWhitespaceableHeadTailConcatOp

          (
            ForOccurringKeywordOrRef()
            .collect({ case (Keyword(iTypeKwd @ ("val" | "const" | "let" ) )) => Keyword(iTypeKwd) } )
            .mapWithFinalPtrPosVl({ case (vl, pos) => vl.withSrcInfo(srcPosInfo = pos) })

            +%:

            ForOccurringKeywordOrRef()
            .collect({ case (Identifier(ident)) => (ident ) } )
            .mapWithFinalPtrPosVl({ case (vl, pos) => vl.withSrcInfo(srcPosInfo = pos) })

            +%:

            // ForScrutSyntactic()

            // +%:
              
            lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
          )
          .map({ case (iType, ident) => FvdParsed(ident = ident, iTypeKw = iType ) } )
        })
        .mapWithFinalPtrPosVl({ case (vl, pos) => vl.withSrcInfo(srcPosInfo = pos) })
      })
    })
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










