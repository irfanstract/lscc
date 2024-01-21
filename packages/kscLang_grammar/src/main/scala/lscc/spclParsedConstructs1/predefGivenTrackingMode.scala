package lscc.spclParsedConstructs1


















transparent inline
def SpclApm
: SpclGrammaticalItemMetaDataWrapMode.type
= SpclGrammaticalItemMetaDataWrapMode

type SpclApm[+R]
= SpclGrammaticalItemMetaDataWrapMode





object SpclGrammaticalItemMetaDataWrapMode {
  ;

  type _Any
  = SpclGrammaticalItemMetaDataWrapMode

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
    new AnyRef with SpclGrammaticalItemMetaDataWrapMode
    {
      //

      type AfterSi
        [+Value]
      >: Value @annotation.unchecked.uncheckedVariance
      <: Value @annotation.unchecked.uncheckedVariance

      extension [Value] (cw: AfterSi[Value]) {
        def value
        : cw.type
        = cw
      }

      extension [V0] (cw: AfterSi[V0]) {
        def map
          [V2] (m: V0 => V2 )
        // : V2
        = m(cw)
      }

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

      ;

      extension [V0] (cw: AfterSi[V0]) {
        def zip
          [V2] (m: AfterSi[V2] )
        : (cw.type, m.type )
        // : AfterSi[(V0, V2)]
        = (cw, m)
      }

    }
  }

  ;
}

trait SpclGrammaticalItemMetaDataWrapMode
{
  ;

  // type
  type AfterSi
    [+Value]
  //

  extension [Value] (cw: AfterSi[Value]) {
    def value
    : Value
  }

  extension [V0] (cw: AfterSi[V0]) {
    def map
      [V2] (m: V0 => V2 )
    : AfterSi[V2]
  }

  extension [Value] (cw: AfterSi[Value]) {
    def srcPtrMaybe
    : Option[SrcPtrInfo]
    = None
  }

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

  extension [V0] (cw: AfterSi[V0]) {
    def zip
      [V2] (m: AfterSi[V2] )
    : AfterSi[(V0, V2)]
  }

  ;
}










