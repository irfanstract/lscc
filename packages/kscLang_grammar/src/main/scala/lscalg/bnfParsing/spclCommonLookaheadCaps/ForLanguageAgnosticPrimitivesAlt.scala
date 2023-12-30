
package lscalg
package bnfParsing
package spclCommonLookaheadCaps



















given forLanguageAgnosticPrimitves1
  [
    _Any
    ,
    EOptConstructor
    <: Singleton & BnfCompatibleFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[_Any]
    ,
  ]
  (using VO_EOptConstructor : ValueOf[EOptConstructor] )
  //
  (using toGetRemngLines : lscalg.cli.repl.DefinesGetRemainingLines[_Any, BnfCompatibleFileReadPtr1.ContentLines ] )
  (using lscalg.bnfParsing.BnrpDoComposeAdvancement[_Any, ([CL] =>> (CL => CL ) )[BnfCompatibleFileReadPtr1.ContentLines ] ] )
  //
  (using forRImpl : (
    spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
      [_Any, util.matching.Regex , VO_EOptConstructor.value._Any ]
  ) )
  (using forLiteralImpl :(
    // TODO
    spclCommonLookaheadCaps.ForImmediateLiteral._AnyForReceiverAndSpecAndReturnBaseType
      [_Any, String , VO_EOptConstructor.value._Any ]
  ) )
  //
: AnyRef with
{
  ;

  transparent inline
  def SpclAfterDigestTupleOption
  = VO_EOptConstructor.value._Impl1 : VO_EOptConstructor.value._Impl1.type

  ;

  val iemiOpsR
  : forRImpl.type
  = valueOf

  // export iemiOpsR.{*}

  val iemiOpsL
  : forLiteralImpl.type
  = valueOf

  // export iemiOpsL.{*}

  ;

  val iemiOpsZeroLengthMatching
  : spclCommonLookaheadCaps.forZeroLengthMatchingImpl[_Any, iemiOpsR.type ]
  = spclCommonLookaheadCaps.forZeroLengthMatching[_Any]

  export iemiOpsZeroLengthMatching.{*}

  val iemiOpsEofs
  // : spclCommonLookaheadCaps.forEofMatchingImpl[_Any, toGetRemngLines.type ]
  = spclCommonLookaheadCaps.forEofMatching[_Any](using {
    ;

    import lscalg.cli.repl.DefinesGetRemainingLinesConv.{*, given}
    drlItemExtractingWrapper[_Any, LazyList ] (using toGetRemngLines)
  })

  export iemiOpsEofs.{*}

  ;

  ;
}













