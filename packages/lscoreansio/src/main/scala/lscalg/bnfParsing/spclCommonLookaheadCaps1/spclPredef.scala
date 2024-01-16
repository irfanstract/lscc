package lscalg.bnfParsing

package  spclCommonLookaheadCaps1





import lscalg.cli.repl.{*}















// // TODO
// trait GivenFispoSupp
// {
//   type T

//   val SpclAfterDigestTupleOption
//   : BnfCompatibleFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[T]

//   type SpclMatchContent
//   >: SpclAfterDigestTupleOption._Impl1.Some
//   <: SpclAfterDigestTupleOption._Impl1.Some
// }
// object GivenFispoSupp {
//   ;

//   type _Any
//   = GivenFispoSupp

//   transparent inline
//   def apply[T](using impl : ForTExactly[T] )
//   = impl

//   transparent inline
//   def inGiven(using impl : _Any )
//   = impl

//   @deprecated("this is a misnomer.")
//   type ForTExtending[-CT]
//   = GivenFispoSupp { type T >: CT }

//   type ForTExactly[CT]
//   = ForTInRange[CT, CT]

//   type ForTAssignableFrom[-CT]
//   = ForTInRange[CT, Any ]

//   type ForTInRange[-CTL <: CTU, +CTU]
//   = GivenFispoSupp { type T >: CTL <: CTU }

//   ;

//   @deprecated
//   @annotation.experimental
//   inline
//   given failIfFound
//   : GivenFispoSupp
//   = compiletime.error(s"unexpected selection.")

//   given for_BC
//   : GivenFispoSupp with {
//     //
//     import BnfCompatibleFileReadPtr1 as BC

//     @deprecated
//     type T
//     >: BC._Any
//     <: BC._Any

//     val SpclAfterDigestTupleOption
//     : BC.SpclAfterDigestTupleOption.type
//     = valueOf

//     // type SpclMatchContent
//     // >: BC.SpclAfterDigestTupleOption._Impl1.Some
//     // <: BC.SpclAfterDigestTupleOption._Impl1.Some
//   }

//   given ftoOp
//   : AnyRef with {
//     ;

//     extension [A, ActualR] (r: lscalg.digestivity.Sdf.zippedWithReceiverInstances.ForReceiverAndRValue[A, ActualR] ) (using ec : ForTAssignableFrom[A] )
//       //

//       /** 
//        * convenience which return exclusively `SpclAfterDigestTupleOption._Any`.
//        * 
//        */
//       def applyOET
//         //
//         (receiver: A )
//         (using eAcRTEquiv : (ActualR <:< ec.SpclMatchContent) )
//       = {
//         r.applyO(receiver)
//         .map({ case (m, newPos) => (eAcRTEquiv(m) ) })
//         .getOrElse[ec.SpclAfterDigestTupleOption._Any ] (ec.SpclAfterDigestTupleOption.negativeInstance )
//       }
//   }

//   implicit
//   object ptrParseFromSpOps
//   {
//     ;

//     extension [T] (r: T ) (using ec : GivenFispoSupp.ForTAssignableFrom[T] )
//       //
//       def immediateSubjectInstance
//         [R] (s: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[T, R] )
//         (using R <:< ec.SpclMatchContent )
//       = s.applyOET(r)

//   }


// }

@deprecated("switch to the new spelling.")
type GivenFispoSupp
= GivenFiSpoSupp

@deprecated("switch to the new spelling.")
transparent inline
def GivenFispoSupp
: GivenFiSpoSupp.type
= GivenFiSpoSupp


// @deprecated
type GivenFiSpoSupp
= lscalg.bnfParsing.spclCptdFispoSuppExtras1.GivenFiSpoSupp

// @deprecated
transparent inline
def GivenFiSpoSupp
: lscalg.bnfParsing.spclCptdFispoSuppExtras1.GivenFiSpoSupp.type
= lscalg.bnfParsing.spclCptdFispoSuppExtras1.GivenFiSpoSupp










