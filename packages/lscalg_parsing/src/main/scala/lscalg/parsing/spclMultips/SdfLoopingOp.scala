package lscalg.parsing.spclMultips













import lscalg.probing.BRetrialIterator










object BnrpMatchingLoopOp
{
  ;

  export BnrpMatchingLooping.SpclEagerness

  export BnrpMatchingLooping.SpclBacktrackworthiness

  type _Any
  // = ForReceiverLU[Nothing, Any, Nothing, Any ]
  = ForReceiverImpl[?, ?]

  type ForReceiver[ReceiT, R ]
  = ForReceiverLU[ReceiT, ReceiT, R, R ]

  type ForReceiverLU[-ReceiTL <: ReceiTU, +ReceiTU, -RL <: RU, +RU  ]
  = ForReceiverImpl[? >: ReceiTL <: ReceiTU , ? >: RL <: RU ]

  @deprecatedInheritance("use 'fromFunction1' instead.")
  // protected
  trait ForReceiverImpl
    [ReceiT , R ] @deprecated("do not subclass directly. use 'fromFunction1' instead.") ()
  {
    extension (pt0: ReceiT)
      def tryForImmediateLoop
      : (
        (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness ) =>
        (SpclSubject.ForReceiverAndRValue[ReceiT, R ] , SpclCountRange ) =>
          BRetrialIterator.ForItemT[Seq[R] ]
      )
    //

    extension (pt0: ReceiT)
      // TODO
      transparent inline
      def tryForImmediateLoop1
      : (
        (SpclSubject.ForReceiverAndRValue[ReceiT, R ] , SpclCountRange, SpclEagerness ) =>
          BRetrialIterator.ForItemT[Seq[R] ]
      )
      = { case e => {
        pt0
        .tryForImmediateLoop
          (backtrackWorthiness = SpclBacktrackworthiness._1 , eagerness = e._3 )
          (e._1, e._2 )
        .match { case r => r }
      } }
    //

  }

  def fromFunction1
    //
    [ReceiT , R ]
    (runImpl: (
      (p0: ReceiT ) =>
        (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness ) =>
        (SpclSubject.ForReceiverAndRValue[ReceiT, R ] , SpclCountRange ) =>
          BRetrialIterator.ForItemT[Seq[R] ]
    ))
  : ForReceiverImpl[ReceiT, R]
  = {
    new ForReceiverImpl[ReceiT, R] {
      ;

      extension (pt0: ReceiT)
        def tryForImmediateLoop
        : (
          (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness ) =>
          (SpclSubject.ForReceiverAndRValue[ReceiT, R ] , SpclCountRange ) =>
            BRetrialIterator.ForItemT[Seq[R] ]
        )
        = runImpl(p0 = pt0 )
      //
    }
  }

  export BnrpMatchingLooping.implementativeImplicits.SpclSubject

  export BnrpMatchingLooping.SpclCountRange

  export BnrpMatchingLooping.implementativeImplicits as implementativeImplicits

  ;
}










