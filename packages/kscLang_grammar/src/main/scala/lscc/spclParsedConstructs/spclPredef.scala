package lscc

package spclParsedConstructs


















import lscalg.bnfParsing.BnfCompatibleFileReadPtr1.{GeneralisedSpclAfterDigestTupleOption, GeneralisedSpclAfterDigestTupleOptionLU }





import lscalg.bnfParsing.BnfCompatibleFileReadPtr1 as GrmSpclFileReadPtr1

import lscalg.bnfParsing.spclCommonLookaheadCaps as GrmPtrStrMatchOpTraits1








;

export lscalg.bnfParsing.spclBnfParseOptionCtorAndPtrTypeDefinerExtras.BnfParseOptionCtorAndPtrTypeDefiner






// @deprecated("instead, split the dependency into two: 'BnfParseOptionCtorAndPtrTypeDefiner' and also 'ForImmediatePatterOccurence'.")
trait BnfParseOptionCtorAndPtrTypeDefinerAndIemiOps private[BnfParseOptionCtorAndPtrTypeDefinerAndIemiOps] ()
// extends
// AnyRef with BnfParseOptionCtorAndPtrTypeDefiner
{
  thisBnfParseOptionCtorAndPtrTypeDefiner =>
  ;

  val ieoc
  : BnfParseOptionCtorAndPtrTypeDefiner

  export ieoc.PAny

  export ieoc.SpclAfterDigestTupleOption

  export ieoc.ccImpl

  given iemiOpsR : (
    lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
      [PAny, util.matching.Regex , SpclAfterDigestTupleOption._Any ]
  )

}

// @deprecated("instead, split the dependency into two: 'BnfParseOptionCtorAndPtrTypeDefiner' and also 'ForImmediatePatterOccurence'.")
object BnfParseOptionCtorAndPtrTypeDefinerAndIemiOps
{
  ;

  type _Any
  = BnfParseOptionCtorAndPtrTypeDefinerAndIemiOps

  type ForPtrTypeAndParseOptionConstructor
    //
    [
      PAnyImpl
      ,
      +EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAnyImpl]
      ,
    ]
  = ((
    BnfParseOptionCtorAndPtrTypeDefinerAndIemiOps
    {
      val ieoc
      : BnfParseOptionCtorAndPtrTypeDefiner.ForPtrTypeAndParseOptionConstructor[PAnyImpl, EOptConstructor ]
    }
  ))

  // TODO
  // @deprecated("instead, split the dependency into two: 'BnfParseOptionCtorAndPtrTypeDefiner' and also 'ForImmediatePatterOccurence'.")
  // transparent inline
  given iForPtrTypeAndParseOptionConstructor
    [
      PAny
      ,
      EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
      ,
    ]
    // (using VO_EOptConstructor : ValueOf[EOptConstructor] )
    (using ieocImpl : BnfParseOptionCtorAndPtrTypeDefiner.ForPtrTypeAndParseOptionConstructor[PAny, EOptConstructor] )
    (using rr : (
      GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
        [PAny, util.matching.Regex , ieocImpl.SpclAfterDigestTupleOption._Any ]
    ) )
  : ForPtrTypeAndParseOptionConstructor[PAny, EOptConstructor]
  = {
    ;

    type PAnyT = PAny

    new _Any {
      ;

      // type PAny
      // >: PAnyT
      // <: PAnyT

      // val SpclAfterDigestTupleOption
      // : VO_EOptConstructor.value.type
      // = VO_EOptConstructor.value

      val ieoc
      : ieocImpl.type
      = ieocImpl

      val iemiOpsR : (
        lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
          [PAnyT, util.matching.Regex , SpclAfterDigestTupleOption._Any ]
      )
      = rr
    }
  }

  transparent inline
  given given_underlying_BnfParseOptionCtorAndPtrTypeDefiner
    (using c : _Any)
  : (BnfParseOptionCtorAndPtrTypeDefiner & c.ieoc.type )
  = c.ieoc

  ;
}










