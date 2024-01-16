package lscalg.bnfParsing
package spclCptdFispoSuppExtras1






import lscalg.cli.repl.{*}















;

@deprecated("switch to the new spelling.")
type GivenFispoSupp
= GivenFiSpoSupp

@deprecated("switch to the new spelling.")
transparent inline
def GivenFispoSupp
: GivenFiSpoSupp.type
= GivenFiSpoSupp

// TODO
trait GivenFiSpoSupp
{
  type T

  val SpclAfterDigestTupleOption
  : BnfCompatibleFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[T]

  type SpclMatchContent
  >: SpclAfterDigestTupleOption._Impl1.Some
  <: SpclAfterDigestTupleOption._Impl1.Some
}
object GivenFiSpoSupp
extends
AnyRef
with GivenFiSpoSuppImplicits
{
  ;

  type _Any
  = GivenFiSpoSupp

  transparent inline
  def apply[T](using impl : ForTExactly[T] )
  = impl

  transparent inline
  def inGiven(using impl : _Any )
  = impl

  @deprecated("this is a misnomer.")
  type ForTExtending[-CT]
  = GivenFiSpoSupp { type T >: CT }

  type ForTExactly[CT]
  = ForTInRange[CT, CT]

  type ForTAssignableFrom[-CT]
  = ForTInRange[CT, Any ]

  type ForTInRange[-CTL <: CTU, +CTU]
  = GivenFiSpoSupp { type T >: CTL <: CTU }

  ;

  ;

  given ftoOp
  : AnyRef with {
    ;

    extension [A, ActualR] (r: lscalg.digestivity.Sdf.zippedWithReceiverInstances.ForReceiverAndRValue[A, ActualR] ) (using ec : ForTAssignableFrom[A] )
      //

      /** 
       * convenience which return exclusively `SpclAfterDigestTupleOption._Any`.
       * 
       */
      def applyOET
        //
        (receiver: A )
        (using eAcRTEquiv : (ActualR <:< ec.SpclMatchContent) )
      = {
        r.applyO(receiver)
        .map({ case (m, newPos) => (eAcRTEquiv(m) ) })
        .getOrElse[ec.SpclAfterDigestTupleOption._Any ] (ec.SpclAfterDigestTupleOption.negativeInstance )
      }
  }

  implicit
  object ptrParseFromSpOps
  {
    ;

    extension [T] (r: T ) (using ec : GivenFiSpoSupp.ForTAssignableFrom[T] )
      //
      def immediateSubjectInstance
        [R] (s: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[T, R] )
        (using R <:< ec.SpclMatchContent )
      = s.applyOET(r)

  }


}

protected
trait GivenFiSpoSuppImplicits
extends
AnyRef
with GivenFiSpoSuppLowPriorityImplicits
{ this : GivenFiSpoSupp.type =>
  ;

  ;

  import lscalg.bnfParsing.spclBnfParseOptionCtorAndPtrTypeDefinerExtras.BnfParseOptionCtorAndPtrTypeDefiner

  /** 
   * by given `BnfParseOptionCtorAndPtrTypeDefiner`. TBD
   * 
   */
  given from_BnfParseOptionCtorAndPtrTypeDefiner
    //
    (using c : BnfParseOptionCtorAndPtrTypeDefiner._Any )
  : (_Any & c.ccImpl.type )
  = c.ccImpl

  ;

  ;
}

protected
trait GivenFiSpoSuppLowPriorityImplicits
{ this : GivenFiSpoSupp.type =>
  ;

  @deprecated
  @annotation.experimental
  inline
  given failIfFound
  : GivenFiSpoSupp
  = compiletime.error(s"unexpected selection.")

  given for_BC
  : GivenFiSpoSupp with {
    //
    import BnfCompatibleFileReadPtr1 as BC

    @deprecated
    type T
    >: BC._Any
    <: BC._Any

    val SpclAfterDigestTupleOption
    : BC.SpclAfterDigestTupleOption.type
    = valueOf

    // type SpclMatchContent
    // >: BC.SpclAfterDigestTupleOption._Impl1.Some
    // <: BC.SpclAfterDigestTupleOption._Impl1.Some
  }

  ;
}









