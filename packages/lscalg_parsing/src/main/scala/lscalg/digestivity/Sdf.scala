package lscalg.digestivity

















/**
 * 
 * on an obtained `Subject`, one can do this
 * 
 * ```
 * val dOpt = tryParse(src = existingInpPos, subject = s )
 * ```
 * 
 * a `Subject`
 * can be obtained from one of the factory methods,
 * most which builds on given "partial digest function"
 * 
 * ```
 * Subject.fromLiftedPartialFunction((inpPtr: FileReadPos ) => {
 *   ;
 *   inpPtr.tryNextBigDecimal()
 * } )
 * ```
 * 
 * `lscalg.parsing`
 * 
 */
@deprecated
transparent inline
def Subject
: Sdf.type
= Sdf

/**
 * 
 * on an obtained `Subject`, one can do this
 * 
 * ```
 * val dOpt = tryParse(src = existingInpPos, subject = s )
 * ```
 * 
 * a `Subject`
 * can be obtained from one of the factory methods,
 * most which builds on given "partial digest function"
 * 
 * ```
 * Subject.fromLiftedPartialFunction((inpPtr: FileReadPos ) => {
 *   ;
 *   inpPtr.tryNextBigDecimal()
 * } )
 * ```
 * 
 * `lscalg.parsing`
 * 
 */
object Sdf
extends
AnyRef
with SdfCases
with SdfRepr
with SdfCommonlyNeededOps
with SdfZipWithReceiverIPackedCases
{
  ;

  ;

  ;
}

trait SdfCases
{
  ;

  @deprecated("I meant 'ForReceiverAndRValue'.")
  type ForReceiverAndROpt
    [-ReceiT, +R ]
  = ForReceiverAndRValue[ReceiT, R ]

  type ForReceiverAndRValue
    [-ReceiT, +R ]
  = ForReceiverAndRMonad[ReceiT , Either[RExceptionUpperBound, R ] ]

  @deprecated
  type ForReceiverAndRMonad
    [-ReceiT, +R <: Either[RExceptionUpperBound, ? ] ]
  // <: ForReceiverAndRAndRMonad[ReceiT, Any, R ]
  <: AnyRef

  // type ForReceiverAndRAndRMonad
  //   [-ReceiT, +RValue, +R <: Either[RExceptionUpperBound, RValue ] ]
  // <: AnyRef

  type _Any
  = ForReceiverAndRMonad[Nothing, Either[RExceptionUpperBound, ? ] ]

  ;

  type RExceptionUpperBound
  >: Unit
  <: Unit

  ;
}

/**
 * 
 * on an obtained `ParseFunction`, one can do this
 * 
 * ```
 * // function (s: ParseFunction )
 * 
 * val dOpt = tryParse(src = existingInpPos, subject = s )
 * ```
 * 
 * a `ParseFunction`
 * can be obtained from one of the factory methods,
 * most which builds on given "partial digest function"
 * 
 * ```
 * ParseFunction.fromLiftedPartialFunction((inpPtr: FileReadPos ) => {
 *   ;
 *   inpPtr.tryNextBigDecimal()
 * } )
 * ```
 * 
 * `lscalg.parsing`
 * 
 */
object ParseFunction
{
  ;

  export Sdf.zippedWithReceiverInstances.{*, given}

  ;

  ;
}

/** 
 * `SdfZipWithReceiverIPackedCases`
 * 
 * the cases not directly exported here at `this`, only packed in(to) `zippedWithReceiverInstances`.
 * 
 */
// TODO
trait SdfZipWithReceiverIPackedCases
{
  Sdf : (
    //

    AnyRef
    & SdfCases
    & SdfRepr
  ) =>
  ;

  ;

  object zippedWithReceiverInstances {
    ;

    type ForReceiverAndRValue
      [ReceiT, +R ]
    = ForReceiverLUAndRValue[ReceiT, ReceiT, R ]

    type ForReceiverLUAndRValue
      [-ReceiL <: ReceiU, +ReceiU, +R ]
    = ImplForReceiverLUAndRValue[ReceiL, ReceiU, R ]

    /** 
     * `ImplForReceiverLUAndRValue`
     * 
     * currently merely a type-alias,
     * to avoid needing to
     * write proxies (to avoid issues with implicit-scopes) for every of the delegated factory methods
     * 
     */
    protected
    type ImplForReceiverLUAndRValue
      [-ReceiL <: ReceiU, +ReceiU, +R ]
    = Sdf.ForReceiverAndRValue[ReceiL, (R, ReceiU) ]

    type _Any
    = ImplForReceiverLUAndRValue[Nothing, Any, Any ]

    ;

    export misnamedReExports.{*, given }
    @deprecated
    protected
    object misnamedReExports {
      ;
      export Sdf.{
        fromPartialFunction ,
        // fromLiftedPartialFunction ,
        fromAltLiftedFunction ,
      }
    }

    /**
     * `fromLiftedPartialFunction`
     * 
     * caveat --
     * it's essential to make the lambda explicitly ascribe the main arg type,
     * to work-around limitations of type-inference
     * 
     */
    def fromLiftedPartialFunction
      [ReceiT, R ]
      (impl: Function1[ReceiT, Option[(R, ReceiT)] ] )
    : ForReceiverAndRValue[ReceiT, R ]
    = Sdf.fromLiftedPartialFunction(impl).nn

    def fromBPermutLiftedFunction
      [ReceiT, R ]
      (impl: Function1[ReceiT, lscalg.parsing.BRetrialIterator[(R, ReceiT)] ] )
    : ForReceiverAndRValue[ReceiT, R ]
    = Sdf.fromAltBRetrialFunction(impl).nn

    ;

    type ForReceiverAndRMonad
      [ReceiU, +RMonad <: Either[Sdf.RExceptionUpperBound, ? ] ]
    = (
      // _Any
      // &
      ForReceiverAndRValue[ReceiU, Any ]
      &
      Sdf.ForReceiverAndRMonad[ReceiU, RMonad ]
    )

    type ForReceiverLUAndRMonad
      [-ReceiL <: ReceiU, +ReceiU, +RMonad <: Either[Sdf.RExceptionUpperBound, ? ] ]
    = (
      // _Any
      // &
      ForReceiverLUAndRValue[ReceiL, ReceiU, Any ]
      &
      Sdf.ForReceiverAndRMonad[ReceiL, RMonad ]
    )

    ;

    ;
  }

  ;
}




;



/* debugging the incremental compiler */

transparent inline
def psfLastCompileTime
  ()
: String
= ${psfEcdImpl() }

def psfEcdImpl
  (using quoted.Quotes )
  ()
: quoted.Expr[String]
= {
  import language.unsafeNulls
  val d = (new java.util.Date ).toLocaleString()
  quoted.Expr(d)
}















