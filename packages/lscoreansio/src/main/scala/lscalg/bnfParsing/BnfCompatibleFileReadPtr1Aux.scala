package lscalg.bnfParsing


















trait BnfCompatibleFileReadPtrExtras1
{ GrmPtr : BnfCompatibleFileReadPtr1.type =>
  ;

  // given given_BnrpMatchingLoopOp
  // : BnrpMatchingLoopOp.ForReceiver[_Any, SpclAfterDigestTupleOption.PositiveInstance ]
  // = given_BnrpMatchingLoopOp1

  // private[BnfCompatibleFileReadPtrExtras1]
  protected
  given given_BnrpMatchingLoopOp1
  : BnrpMatchingLoopOp.ForReceiver[_Any, SpclAfterDigestTupleOption.PositiveInstance ]
  with {
    ;

    import BnrpMatchingLoopOp.SpclBacktrackworthiness
    import BnrpMatchingLoopOp.SpclEagerness
    import BnrpMatchingLoopOp.SpclSubject
    import BnrpMatchingLoopOp.SpclCountRange
    import BnrpMatchingLoopOp.implementativeImplicits.{*, given }

    type ReceiT
    >: _Any
    <: _Any
    type R
    >: SpclAfterDigestTupleOption.PositiveInstance
    <: SpclAfterDigestTupleOption.PositiveInstance

    extension (pt0: _Any)
      def tryForImmediateLoop
      : (
        (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness ) =>
        (SpclSubject.ForReceiverAndROpt[ReceiT, R ] , SpclCountRange ) =>
          BnfCompatibleRetrialIterator[Seq[R] ]
      )
      = {
        ;

        (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness ) =>
        (subject: SpclSubject.ForReceiverAndROpt[ReceiT, R ] , r: SpclCountRange ) =>
          rImpl
            (backtrackWorthiness = backtrackWorthiness , eagerness = eagerness  )
            (subject, backConv = e => e.nextPos )
            (pt0, countBnds = r )
      }
  }

}

trait BnrpDoComposeAdvancement
  [Receiver, -Cl <: Function1[?, ?] ]
{
  extension (s: Receiver)
    //

    /** 
     * after advancing the pos
     * 
     */
    def composeAdvancement
      (f: Cl )
    : Receiver
}
object BnrpDoComposeAdvancement {
  def apply[Receiver, Cl <: Function1[?, ?] ](impl: Receiver => Cl => Receiver )
  = {
    new BnrpDoComposeAdvancement[Receiver, Cl ] {
      extension (s: Receiver)
        def composeAdvancement(f: Cl) = impl.apply(s).apply(f)
    }
  } : BnrpDoComposeAdvancement[Receiver, ? >: Cl ]
}














