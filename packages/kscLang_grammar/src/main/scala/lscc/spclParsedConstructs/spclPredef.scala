package lscc

package spclParsedConstructs














import lscalg.bnfParsing.BnfCompatibleFileReadPtr1 as GrmSpclFileReadPtr1

import lscalg.bnfParsing.spclCommonLookaheadCaps as GrmPtrStrMatchOpTraits1























trait BnfParseOptionCtorAndPtrTypeDefiner private[BnfParseOptionCtorAndPtrTypeDefiner] ()
{
  thisBnfParseOptionCtorAndPtrTypeDefiner =>
  ;

  type PAny

  val SpclAfterDigestTupleOption
  : GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]

  given iemiOpsR : (
    lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
      [PAny, util.matching.Regex , SpclAfterDigestTupleOption._Any ]
  )

  given ccImpl
  : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp with {
    ;

    type T
    >: PAny
    <: PAny

    // TODO
    // val SpclAfterDigestTupleOption
    // : BnfCompatibleFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[T]
    export thisBnfParseOptionCtorAndPtrTypeDefiner.SpclAfterDigestTupleOption as SpclAfterDigestTupleOption
  }

}

object BnfParseOptionCtorAndPtrTypeDefiner
{
  ;

  type _Any = BnfParseOptionCtorAndPtrTypeDefiner

  type ForPtrTypeAndParseOptionConstructor
    //
    [
      PAny
      ,
      +EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
      ,
    ]
  = ([PAnyImpl] =>> (
    BnfParseOptionCtorAndPtrTypeDefiner
    {
      type PAny >: PAnyImpl <: PAnyImpl
      val SpclAfterDigestTupleOption : EOptConstructor
    }
  ))[PAny]

  // TODO
  // transparent inline
  given iForPtrTypeAndParseOptionConstructor
    [
      PAny
      ,
      EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
      ,
    ]
    (using VO_EOptConstructor : ValueOf[EOptConstructor] )
    (using rr : (
      GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
        [PAny, util.matching.Regex , VO_EOptConstructor.value._Any ]
    ) )
  : ForPtrTypeAndParseOptionConstructor[PAny, EOptConstructor]
  = {
    ;

    type PAnyT = PAny

    new _Any {
      ;

      type PAny
      >: PAnyT
      <: PAnyT

      val SpclAfterDigestTupleOption
      : VO_EOptConstructor.value.type
      = VO_EOptConstructor.value

      val iemiOpsR : (
        lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
          [PAny, util.matching.Regex , SpclAfterDigestTupleOption._Any ]
      )
      = rr
    }
  }

  ;
}










