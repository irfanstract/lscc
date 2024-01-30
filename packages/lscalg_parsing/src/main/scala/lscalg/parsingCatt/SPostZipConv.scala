package lscalg.parsingCatt

















trait SPostZipConv protected[SPostZipConv] ()
extends
AnyRef
{
  ;

  type Conv[+Value1, +Value2 <: Value2Base]

  type Value2Base

  def conv
    [V1, V2 <: Value2Base](a1: V1, a2: V2)
  : Conv[a1.type, a2.type ]

  ;
}

object SPostZipConv
extends
AnyRef
with SPostZipConvImplicits
{
  ;

  type _Any
  = SPostZipConv

  type ByCc
    [+ConvImpl[+Value1, +Value2] , -Value2BaseImpl ]
  = _Any {
    ;

    type Conv[+Value1, +Value2 <: Value2Base ]
    >: ConvImpl[Value1, Value2] @annotation.unchecked.uncheckedVariance
    <: ConvImpl[Value1, Value2]

    type Value2Base
    >: Value2BaseImpl @annotation.unchecked.uncheckedVariance
    <: Value2BaseImpl @annotation.unchecked.uncheckedVariance
  }

  ;
}

protected
trait SPostZipConvImplicits
extends
AnyRef
with SPostZipConvLowPrioImplicits
{ this : SPostZipConv.type =>
  ;

  transparent
  inline
  given idmTuple1
    //
    [RhsVal]
    (using ([e] =>> e )[RhsVal <:< Tuple ] )
  // : _Any { type Value2Base >: RhsVal }
  : idmTuple.type
  = idmTuple

  protected
  given idmTuple
  : _Any with {
    ;
    type Conv[+Value1, +Value2 <: Value2Base ]
    >: (Value1 *: Value2 ) @annotation.unchecked.uncheckedVariance
    <: (Value1 *: Value2 )

    type Value2Base
    >: Tuple
    <: Tuple

    override
    def conv
      [V1, V2 <: Value2Base](a1: V1, a2: V2)
    : a1.type *: a2.type
    = a1 *: a2
  }

}

protected
trait SPostZipConvLowPrioImplicits
extends
AnyRef
{ this : SPostZipConv.type =>
  ;

  // transparent
  inline
  given idm1
    //
    [RhsVal]
    (using util.NotGiven[RhsVal <:< Tuple ] )
  // : _Any { type Value2Base >: RhsVal }
  : idm
  = idm

  protected
  given idm(using DummyImplicit)
  : _Any with {
    ;
    type Conv[+Value1, +Value2]
    >: Tuple2[Value1, Value2] @annotation.unchecked.uncheckedVariance
    <: Tuple2[Value1, Value2]

    type Value2Base
    >: Any
    <: Any

    override
    def conv
      [V1, V2 <: Value2Base](a1: V1, a2: V2)
    : (a1.type, a2.type)
    = (a1, a2)
  }

}












