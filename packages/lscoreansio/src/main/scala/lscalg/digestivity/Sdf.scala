package lscalg.digestivity

















object Subject
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















