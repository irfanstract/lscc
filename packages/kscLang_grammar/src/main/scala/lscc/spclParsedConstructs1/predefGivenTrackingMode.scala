package lscc.spclParsedConstructs1


















object SpclApm {
  ;

  type _Any
  = SpclApm

  type withPtrTRange
    [-TL <: TU, +TU ]
  = _Any { val ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp.ForTInRange[TL, TU] }

  type withPtrTImplementing
    [+TU ]
  = withPtrTRange[Nothing, TU ]

  type withAfterSiType
    [+C[+Value] ]
  = _Any { type AfterSi <: [value] =>> C[value] }

  ;

  // def
  def identityInstance
    //
    (using ecImpl : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
  = {
    new AnyRef with SpclApm
    {
      //

      type AfterSi
        [+Value]
      >: Value @annotation.unchecked.uncheckedVariance
      <: Value @annotation.unchecked.uncheckedVariance

      val ec
      : ecImpl.type
      = ecImpl

      extension [Value] (value: Value) {
        def withSrcInfo
          //
          (srcPosInfo: SrcPtrInfo )
        : AfterSi[value.type]
        = { value }
      }
    }
  }

  ;
}

trait SpclApm
{
  ;

  // type
  type AfterSi
    [+Value]

  extension [Value] (value: Value) {
    def withSrcInfo
      //
      (srcPosInfo: SrcPtrInfo )
    : AfterSi[value.type]
  }

  type SrcPtrInfo
  >: ec.T
  <: ec.T

  val ec
  : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any

  ;
}










