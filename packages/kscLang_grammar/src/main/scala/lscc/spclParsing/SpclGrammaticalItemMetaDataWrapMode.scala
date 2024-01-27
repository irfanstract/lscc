package lscc.spclParsing


















object SpclGrammaticalItemMetaDataWrapMode
extends
AnyRef
with SpclGrammaticalItemMetaDataWrapModeGivenInstances
{
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
  = _Any { type AppliedTo <: [value] =>> C[value] }

  ;

  ;
}

@deprecatedInheritance
sealed
trait SpclGrammaticalItemMetaDataWrapMode private[lscc] ()
{
  ;

  // type
  type AppliedTo
    [+Value]
  //

  extension [Value] (cw: AppliedTo[Value]) {
    def value
    : Value
  }

  extension [V0] (cw: AppliedTo[V0]) {
    def map
      [V2] (m: V0 => V2 )
    : AppliedTo[V2]
  }

  extension [Value] (cw: AppliedTo[Value]) {
    def srcPtrMaybe
    : Option[SrcPtrInfo]
    = None
  }

  extension [Value] (value: Value) {
    def withSrcInfo
      //
      (srcPosInfo: SrcPtrInfo )
    : AppliedTo[value.type]
  }

  type SrcPtrInfo
  >: ec.T
  <: ec.T

  val ec
  : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any

  extension [V0] (cw: AppliedTo[V0]) {
    def zip
      [V2] (m: AppliedTo[V2] )
    : AppliedTo[(V0, V2)]
  }

  ;
}

trait SpclGrammaticalItemMetaDataWrapModeGivenInstances
{ this : SpclGrammaticalItemMetaDataWrapMode.type =>
  ;

  ;

  protected
  sealed
  trait SpwciIdentityInstanceImpl extends
  _Any
  {
    ;

    override
    type AppliedTo
      [+Value]
    >: Value @annotation.unchecked.uncheckedVariance
    <: Value @annotation.unchecked.uncheckedVariance

    extension [Value] (cw: AppliedTo[Value]) {
      def value
      : cw.type
      = cw
    }

    extension [V0] (cw: AppliedTo[V0]) {
      def map
        [V2] (m: V0 => V2 )
      // : V2
      : AppliedTo[V2]
      = m(cw)
    }

    extension [Value] (value: Value) {
      def withSrcInfo
        //
        (srcPosInfo: SrcPtrInfo )
      : AppliedTo[value.type]
      = { value }
    }

    ;

    extension [V0] (cw: AppliedTo[V0]) {
      def zip
        [V2] (m: AppliedTo[V2] )
      : (cw.type, m.type )
      // : AppliedTo[(V0, V2)]
      = (cw, m)
    }

  }

  // TODO
  def identityInstance
    //
    (using ecImpl : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
  : SpwciIdentityInstanceImpl { val ec: ecImpl.type }
  = {
    new AnyRef with SpwciIdentityInstanceImpl
    {
      //

      val ec
      : ecImpl.type
      = ecImpl

    }
  }

  ;
}









