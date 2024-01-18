package lscc.spclParsedConstructs1

















;

protected // TODO
object ForChainedInfixOpFullExpr {
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
  // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , apMode.AfterSi[UnderscoreWildcardPatternImpl._Any ] ]
  = ???

  ;
}




def ForChainedInfixOpItemExpr
  //
  (using g : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
  (using a : SpclApm.withPtrTRange[g.T, g.T ] )
= {
  new AnyRef with ForChainedInfixOpItemExprImpl {
    //

    implicit val givenFispoSupp
    : g.type
    = g

    implicit val apMode
    : a.type
    = a

  }
}

type ParsedChainedInfixOpItemExpr
= ForChainedInfixOpItemExprImpl#ParsedChainedInfixOpItemExpr

// protected // can't be 'protected' since there's no other way to reference the inner path-dependable stuffs
// trait
trait ForChainedInfixOpItemExprImpl
{ ForChainedInfixOpItemExpr =>
  ;

  implicit val givenFispoSupp
  : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any

  implicit val apMode
  : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ]

  ;

  def apply
    //
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T, apMode.AfterSi[PrefixScrutLhsExpr ] ]
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T, apMode.AfterSi[ParsedChainedInfixOpItemExpr ] ]
  = {
    ;

    import givenFispoSupp.T as PAny

    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

    ;

    (
      ForSingleTokenLiteralExpr()
      .map(e => (
        e.map(e => (
          ParsedChainedInfixOpItemExpr.ForSingleTokenLiteralExpr(e )
        ))
      ) )

      orElse

      ForInfixOpEdCompoundSelectExpr()
      .map(e => {
        e.map(e => (
          ParsedChainedInfixOpItemExpr.ForCompoundSelectExpr(e)
        ) )
      } )
    )
    .nn
  }

  ;

  // TODO
  enum ParsedChainedInfixOpItemExpr
  {
    case ForCompoundSelectExpr(e: IInfixOpEdCompoundSelectExpr )
    case ForSingleTokenLiteralExpr(value: ISingleTokenLiteralExpr )
  }

  ;
}

def ForInfixOpEdCompoundSelectExpr
  //
  (using g : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
  (using a : SpclApm.withPtrTRange[g.T, g.T ] )
= {
  new AnyRef with ForInfixOpEdCompoundSelectExprImpl {
    //

    implicit val givenFispoSupp
    : g.type
    = g

    implicit val apMode
    : a.type
    = a

  }
}

// TODO
type IInfixOpEdCompoundSelectExpr
= ForInfixOpEdCompoundSelectExprImpl#IInfixOpEdCompoundSelectExpr

// protected // can't be 'protected' since there's no other way to reference the inner path-dependable stuffs
// trait
trait ForInfixOpEdCompoundSelectExprImpl
{ ForInfixOpEdCompoundSelectExpr =>
  ;

  implicit val givenFispoSupp
  : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any

  implicit val apMode
  : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ]

  import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
  import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

  /**
   * expr like `bar1.bar2.bar3` being an item of a chain of infix op
   * 
   */
  def apply
    //
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , apMode.AfterSi[UnderscoreWildcardPatternImpl._Any ] ]
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , apMode.AfterSi[IInfixOpEdCompoundSelectExpr ] ]
  = {
    // TODO

    import givenFispoSupp.T as PAny

    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

    import fwscImplicits.prsWhitespaceableHeadTailConcatOp

    (
      ForSingleTokenLiteralExpr()
      .map(_.value)
      .map(e => (
        IInfixOpEdCompoundSelectExpr.TermI(e)
      ) )

      orElse

      (
        ForInfixOpEdCompoundSelectExpr()

        +%:

        lscc.spclParsedConstructs1.KeywordingCtx.withSp({
          // TODO
          kwIngCtx
        })({
          ForOccurringKeywordOrRefP()
        })

        +%:

        lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
      )
      // TODO
      .collect({ case (receiverWr *: Identifier(tail) *: _ ) => ({
        val receiver = receiverWr.value
        // TODO
        IInfixOpEdCompoundSelectExpr.SuccI(receiver, tail )
      }) })
    )
    .mapWithFinalPtrPosVl((e, pos) => (
      e
      .withSrcInfo(srcPosInfo = pos )
    ) )
    .nn
  }

  ;

  enum IInfixOpEdCompoundSelectExpr {
    case TermI(l: ISingleTokenLiteralExpr )
    case SuccI(l: IInfixOpEdCompoundSelectExpr, r: String )
  }

  ;
}





// TODO
object ForSingleTokenLiteralExpr
{
  ;

  ;

  def apply
    //
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using apMode : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ] )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , apMode.AfterSi[IInfixOpEdCompoundSelectExpr ] ]
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , apMode.AfterSi[ISingleTokenLiteralExpr ] ]
  = {
    ;

    import givenFispoSupp.T as PAny
    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

    (
      ForNumericLiteral1()
      .map(_ => (
        ISingleTokenLiteralExpr.ForNumeric()
      ) )

      // orElse

      // ForOccurringKeywordOrRefP()
      // .map(Some(_) )
    )
    // .map(_.value)
    .mapWithFinalPtrPosVl((e, pos) => (
      e
      .withSrcInfo(srcPosInfo = pos )
    ) )
    .nn
  }
  ;
}

enum ISingleTokenLiteralExpr {
  case ForNumeric()
}







