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

object Sdf
{
  ;

  @deprecated("I meant 'ForReceiverAndRValue'.")
  type ForReceiverAndROpt
    [-ReceiT, +R ]
  = ForReceiverAndRValue[ReceiT, R ]

  type ForReceiverAndRValue
    [-ReceiT, +R ]
  = ForReceiverAndRMonad[ReceiT , Either[RExceptionUpperBound, R ] ]

  opaque type ForReceiverAndRMonad
    [-ReceiT, +R <: Either[RExceptionUpperBound, ? ] ]
  <: AnyRef
  = ReceiT => R

  type _Any
  = ForReceiverAndRMonad[Nothing, Either[RExceptionUpperBound, ? ] ]

  extension [ReceiT, R, RException <: RExceptionUpperBound, REi <: Either[RException, R ] ] (impl: ForReceiverAndRMonad[ReceiT, REi] ) {
    //

    def applyEi
      (receiver: ReceiT )
    : REi
    = impl.apply(receiver )

  }

  extension [ReceiT, R ] (impl: ForReceiverAndRValue[ReceiT, R ] ) {
    //

    // TODO make transparent-inline

    def applyO
      (receiver: ReceiT )
    : Option[R]
    = impl.apply(receiver ).fold(_ => None, Some(_) )

  }
  //

  type RExceptionUpperBound
  >: Unit
  <: Unit

  def fromPartialFunction
    [ReceiT, R ]
    (impl: PartialFunction[ReceiT, R ] )
  : ForReceiverAndRValue[ReceiT, R ]
  = {
    impl
    .lift
    .match { case fnc => fromLiftedPartialFunction(fnc) }
  }

  def fromLiftedPartialFunction
    [ReceiT, R ]
    (impl: Function1[ReceiT, Option[R] ] )
  : ForReceiverAndRValue[ReceiT, R ]
  = {
    impl
    .andThen(_.toRight(() ) )
  }

  def fromAltLiftedFunction
    [A, R <: Either[RExceptionUpperBound, ? ] ]
    (impl: A => R )
  : ForReceiverAndRMonad[A, R ]
  = impl

  ;

  def forFixedCompoundO
    [ReceiT, R ]
    (children: Seq[Function1[ReceiT, Option[R] ] ] , backConv: R => ReceiT )
  = {
    ;
    fromLiftedPartialFunction((pt0: ReceiT ) => {
      ;
      children
      .foldLeft[Option[(IndexedSeq[R] , ReceiT ) ] ] (Some((IndexedSeq() , pt0 ) ) ) ({
        case (Some((ls0, pt0)), applyNext ) =>
          ;

          applyNext(pt0)

          .map(result1 => {
            val pt2 = backConv(result1)
            ;
            (ls0 :+ result1 , pt2 )
          } )

        case (None, _ ) =>
          None
      })
    } )
  }

  ;

  /** collective ! */
  def fromLiftedPartialFunctionList
    //
    [ReceiT, R ]
    (impls: Seq[Function1[ReceiT, Option[R] ] ] )
  = {
    impls
    .map(o => fromLiftedPartialFunction(o) )
  }

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

  export Sdf.{
    fromPartialFunction ,
    fromLiftedPartialFunction ,
    fromAltLiftedFunction ,
  }

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















