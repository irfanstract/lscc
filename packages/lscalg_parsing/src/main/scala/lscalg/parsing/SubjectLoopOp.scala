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

  trait GeneralisedSBSLO[PreRepForm, +PostRepForm ]
  {
    ;

    import BnrpMatchingLoopOp.{SpclBacktrackworthiness, SpclEagerness, SpclCountRange}

    extension (impl0: PreRepForm ) {
      def repeated
        //
        (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness )
        (eu1: Unit , nRange: SpclCountRange )
      : PostRepForm
    }
  }

  import lscalg.digestivity.{Sdf, ParseFunction}

  // // protected 
  // given given_sBnrpSubjectLoopOpP[ReceiT , R ]
  // : AnyRef with GeneralisedSBSLO[
  //   //
  //   ParseFunction.ForReceiverAndRValue[ReceiT, R]
  //   ,
  //   ParseFunction.ForReceiverAndRValue[ReceiT, Seq[R]]
  //   ,
  // ]
  // with {
  //   ;

  //   import BnrpMatchingLoopOp.{SpclBacktrackworthiness, SpclEagerness, SpclCountRange}

  //   extension (impl0: ParseFunction.ForReceiverAndRValue[ReceiT, R ] )
  //   {
  //     //

  //     def repeated
  //       //
  //       (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness )
  //       (eu1: Unit , nRange: SpclCountRange )
  //     = {
  //       impl0
  //       .match { case c => ParseFunction.iev }
  //     }
  //   }

  //   ;
  // }

  // private
  // def given_sBnrpSubjectLoopOpP_impl
  // = {
  //   ;
  // }

  given given_sBnrpSubjectLoopOp[ReceiT , R ]
  : AnyRef with GeneralisedSBSLO[
    //
    Sdf.zippedWithReceiverInstances.ForReceiverAndRValue[ReceiT, R]
    ,
    Sdf.zippedWithReceiverInstances.ForReceiverAndRValue[ReceiT, Seq[R]]
    ,
  ]
  with {
    ;

    import lscalg.parsing.Subject.zippedWithReceiverInstances as S

    import BnrpMatchingLoopOp.{SpclBacktrackworthiness, SpclEagerness, SpclCountRange}

    extension (impl0: S.ForReceiverAndRValue[ReceiT, R ] )
    {
      def repeated
        //
        (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness )
        (eu1: Unit , nRange: SpclCountRange )
      : S.ForReceiverAndRValue[ReceiT, Seq[R] ]
      = {
        lscalg.parsing.Subject.fromAltBRetrialFunction ((pt0: ReceiT) => {
          given_sBnrpMatchingLoopOp_tupleTwo[ReceiT , R ]
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
      }.nn
    }
  }

  ;
}













