package lscalg.bnfParsing.spclBnfParseOptionCtorAndPtrTypeDefinerExtras




















import lscalg.bnfParsing.BnfCompatibleFileReadPtr1.{GeneralisedSpclAfterDigestTupleOption, GeneralisedSpclAfterDigestTupleOptionLU }





import lscalg.bnfParsing.BnfCompatibleFileReadPtr1 as GrmSpclFileReadPtr1

import lscalg.bnfParsing.spclCommonLookaheadCaps as GrmPtrStrMatchOpTraits1








;

trait BnfParseOptionCtorAndPtrTypeDefiner private[BnfParseOptionCtorAndPtrTypeDefiner] ()
{
  thisBnfParseOptionCtorAndPtrTypeDefiner =>
  ;

  type PAny

  val SpclAfterDigestTupleOption
  : GeneralisedSpclAfterDigestTupleOption[PAny]

  given ccImpl
  : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp with {
    ;

    type InputState
    >: PAny
    <: PAny

    export thisBnfParseOptionCtorAndPtrTypeDefiner.SpclAfterDigestTupleOption as SpclAfterDigestTupleOption
  }

}

object BnfParseOptionCtorAndPtrTypeDefiner
{
  ;

  type _Any
  = BnfParseOptionCtorAndPtrTypeDefiner

  type ForPtrType
    //
    [
      PAny
      ,
    ]
  = ForPtrTypeLU[PAny, PAny]

  type ForPtrTypeLU
    //
    [
      -PAnyImplL <: PAnyImplU, +PAnyImplU,
    ]
  = ( (
    BnfParseOptionCtorAndPtrTypeDefiner
    {
      type PAny >: PAnyImplL <: PAnyImplU
    }
  ))

  type ForPtrTypeAndParseOptionConstructor
    //
    [
      PAny
      ,
      +EOptConstructor
      <: Singleton & GeneralisedSpclAfterDigestTupleOption[PAny]
      ,
    ]
  = ([PAnyImpl] =>> (
    BnfParseOptionCtorAndPtrTypeDefiner.ForPtrType[PAnyImpl]
    {
      // type PAny >: PAnyImpl <: PAnyImpl

      val SpclAfterDigestTupleOption
      : EOptConstructor

    }
  ))[PAny]

  // TODO
  // transparent inline
  given iForPtrTypeAndParseOptionConstructor
    [
      PAny
      ,
      EOptConstructor
      <: Singleton & GeneralisedSpclAfterDigestTupleOption[PAny]
      ,
    ]
    (using VO_EOptConstructor : ValueOf[EOptConstructor] )
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

    }
  }

  ;
}












