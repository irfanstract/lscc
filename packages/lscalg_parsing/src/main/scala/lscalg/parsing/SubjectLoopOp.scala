package lscalg.parsing




















object sBnrpMatchingLoopOpOptInImplicits1
{
  ;

  given given_sBnrpMatchingLoopOp_tupleTwo[ReceiT , RValue ]
  : BnrpMatchingLoopOp.ForReceiverImpl[ReceiT, (RValue, ReceiT) ]
  = {
    ;
    type R
    >: (RValue, ReceiT)
    <: (RValue, ReceiT)

    new BnrpMatchingLoopOp.ForReceiverImpl[ReceiT, R ] {
      ;

      import BnrpMatchingLoopOp.{SpclBacktrackworthiness, SpclEagerness, SpclSubject, SpclCountRange}

      extension (pt0: ReceiT)
        def tryForImmediateLoop
        : (
          (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness ) =>
          (SpclSubject.ForReceiverAndRValue[ReceiT, R ] , SpclCountRange ) =>
            BRetrialIterator.ForR[Seq[R] ]
        )
        = { case (backtrackWorthiness , eagerness ) => {
          (subject, nRange) => {
            ;

            BnrpMatchingLoopOp.implementativeImplicits.rImpl[ReceiT , R ]
              (backtrackWorthiness = backtrackWorthiness, eagerness = eagerness )
              (subject, backConv = { case (_, newPos) => newPos } )
              (pt0, countBnds = nRange )
            .match { case r => r }
          }
        }}
    }
  }

}

transparent inline
def subjectLoopOpOptInImplicits
= SubjectLoopOpOptInImplicits1

@deprecated
transparent inline
def SubjectLoopOpOptInImplicit
= SubjectLoopOpOptInImplicits1

object SubjectLoopOpOptInImplicits1
{
  ;

  import sBnrpMatchingLoopOpOptInImplicits1.given_sBnrpMatchingLoopOp_tupleTwo

  given given_sBnrpSubjectLoopOp[ReceiT , RValue ]
  : AnyRef with {
    ;

    type R[+C[+r] ]
    >: (lscalg.parsing.Subject.ForReceiverAndRValue[ReceiT , (C[RValue] , ReceiT ) ] )
    <: (lscalg.parsing.Subject.ForReceiverAndRValue[ReceiT , (C[RValue] , ReceiT ) ] )

    import BnrpMatchingLoopOp.{SpclBacktrackworthiness, SpclEagerness, SpclCountRange}

    extension (impl0: R[[e] =>> e] ) {
      def repeated
        //
        (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness )
        (eu1: Unit , nRange: SpclCountRange )
      : R[[e] =>> Seq[e] ]
      = {
        lscalg.parsing.Subject.fromAltBRetrialFunction ((pt0: ReceiT) => {
          given_sBnrpMatchingLoopOp_tupleTwo[ReceiT , RValue ]
          .tryForImmediateLoop
            (pt0 )
            (backtrackWorthiness = backtrackWorthiness , eagerness = eagerness )
            (impl0, nRange )
          .map(s => {
            s.unzip
            .match { case (s1, s2) => {
              (s1, s2.prepended[ReceiT](pt0).head )
            } }
          } )
          .nn
          .nn
        } )
        .match { case s1 => s1 }
      }
    }
  }

  ;
}













