package lscalg.digestivity



















// trait SdfCases
// trait SdfRepr
trait SdfRepr
extends
AnyRef
with SdfCases
{
  ;

  override
  opaque type ForReceiverAndRMonad
    [-ReceiT, +R <: Either[RExceptionUpperBound, ? ] ]
  // <: AnyRef
  // = ReceiT => R
  <: SdfRepr1[? >: ReceiT, ERhs[R], ? <: R ]
  =  SdfRepr1[? >: ReceiT, ERhs[R], ? <: R ]

  type ERhs[REi <: Either[RExceptionUpperBound, ? ] ] =
    REi match { case Either[?, r] => r }

  private[SdfRepr]
  abstract
  class SdfRepr1[-ReceiT, +R, +REi <: Either[RExceptionUpperBound, R ] ] private[SdfRepr1] ()
  {
    ;

    /** 
     * variant of `apply` whose return-type is `BRetrialIterator[R ]`,
     * .
     * 
     */
    def applyBrt
      (receiver: ReceiT )
    : lscalg.parsing.BRetrialIterator[R]

    /** 
     * variant of `apply` whose return-type is `Either[RExcUpb, R ]`,
     * and
     * supposed to be equivalent to `applyBrt(receiver).headOption.toRight(errCode)`
     * .
     * 
     */
    def applyEi
      (receiver: ReceiT )
    : REi

  }
  private[SdfRepr]
  object SdfRepr1 {
    //
    class ByEiF[-ReceiT, +R, +REi <: Either[RExceptionUpperBound, R ] ] (impl: ReceiT => REi )
    extends SdfRepr1[ReceiT, R, REi ]
    {
      ;

      override
      def applyEi
        (receiver: ReceiT )
      : REi
      = impl.apply(receiver )

      override
      def applyBrt
        (receiver: ReceiT )
      : lscalg.parsing.BRetrialIterator[R]
      = {
        applyEi(receiver)
        .toOption
        .match { case o => lscalg.parsing.BRetrialIterator.from(o.toList ) }
      }

    }

    class ByBrF[-ReceiT, +R ] (impl: ReceiT => lscalg.parsing.BRetrialIterator[R] )
    extends SdfRepr1[ReceiT, R, Either[RExceptionUpperBound, R ] ]
    {
      ;

      override
      def applyBrt
        (receiver: ReceiT )
      : lscalg.parsing.BRetrialIterator[R]
      = {
        impl.apply(receiver)
      }

      override
      def applyEi
        (receiver: ReceiT )
      = {
        applyBrt(receiver )
        .headOption
        .toRight(() )
      }

    }
  }

  // extension [ReceiT, R, RException <: RExceptionUpperBound, REi <: Either[RException, R ] ] (impl: ForReceiverAndRMonad[ReceiT, REi] ) {
  //   //

  //   def applyEi
  //     (receiver: ReceiT )
  //   : REi
  //   = impl.apply(receiver )

  // }

  extension [ReceiT, R ] (impl: ForReceiverAndRValue[ReceiT, R ] ) {
    //

    // TODO make transparent-inline

    /** 
     * variant of `apply` whose return-type is `Option[R ]`,
     * and
     * supposed to be equivalent to `applyBrt(receiver).headOption`
     * .
     * 
     */
    def applyO
      (receiver: ReceiT )
    : Option[R]
    = impl.applyEi(receiver ).fold(_ => None, Some(_) )

  }
  //

  def fromPartialFunction
    [ReceiT, R ]
    (impl: PartialFunction[ReceiT, R ] )
  : ForReceiverAndRValue[ReceiT, R ]
  = {
    impl
    .lift
    .match { case fnc => fromLiftedPartialFunction(fnc) }
  }

  /**
   * from a func which is "defined for all inst of `ReceiT`"
   * 
   */
  def fromTotalFunction
    [ReceiT, R ]
    (impl: Function[ReceiT, R ] )
  : ForReceiverAndRValue[ReceiT, R ]
  = {
    fromLiftedPartialFunction1((
      impl
      .andThen(Some(_) )
    ))
  }

  def fromLiftedPartialFunction
    [ReceiT, R, ROpt <: Option[R] ]
    (impl: Function1[ReceiT, ROpt ] )
  : ForReceiverAndRValue[ReceiT, R ]
  = fromLiftedPartialFunction1(impl )

  transparent inline
  def fromLiftedPartialFunction1
    [ReceiT, R, ROpt <: Option[R] ]
    (impl: Function1[ReceiT, ROpt ] )
  : ForReceiverAndRValue[ReceiT, R ]
  = {
    fromAltLiftedFunction({
      ;
      impl
      .andThen(o => (
        o match {
          case Some(value) => Right(value)
          case None => Left(())
        }
      ) )
    })
  }

  def fromAltLiftedFunction
    [A, R <: Either[RExceptionUpperBound, ? ] ]
    (impl: A => R )
  : ForReceiverAndRMonad[A, R ]
  = SdfRepr1.ByEiF(impl = impl )

  def fromAltBRetrialFunction
    [A, R ]
    (impl: A => lscalg.parsing.BRetrialIterator[R] )
  : ForReceiverAndRValue[A, R ]
  = SdfRepr1.ByBrF(impl = impl )

  given optLiftingOps1
  : AnyRef with {
    ;

    extension [ReceiT, R ] (impl: ForReceiverAndRValue[ReceiT, R ] )
      //

      /**
       * lifted -- `Option[R]`
       * 
       */
      def liftSbjO
        //
      : ForReceiverAndRMonad[ReceiT, Right[Nothing, Option[R] ] ]
      = fromAltLiftedFunction((
        (impl.applyEi _ )
        andThen(ei => ei.toOption ) 
        andThen (Right(_) )
      ))

    ;
  }

  given brtLiftingOps1
  : AnyRef with {
    ;

    extension [ReceiT, R ] (impl: ForReceiverAndRValue[ReceiT, R ] )
      //

      /**
       * lifted -- `BRetrialIterator[R]`
       * 
       */
      // @deprecated
      def liftSbjBr
        // lscalg.parsing.BRetrialIterator[R]
      // : ForReceiverAndRMonad[ReceiT, Right[Nothing, lscalg.parsing.BRetrialIterator[R] ] ]
      = fromAltLiftedFunction((
        (impl.applyBrt _ )
        andThen (Right(_) )
      )).nn

    ;
  }

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














