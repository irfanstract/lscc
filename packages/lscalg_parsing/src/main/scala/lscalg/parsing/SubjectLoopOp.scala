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

    BnrpMatchingLoopOp.fromFunction1[ReceiT, R ] ((pt0) => {
      ;
      (
        //
        { case (backtrackWorthiness , eagerness ) => {
          (subject, nRange) => {
            ;

            BnrpMatchingLoopOp.implementativeImplicits.rImpl[ReceiT , R ]
              (backtrackWorthiness = backtrackWorthiness, eagerness = eagerness )
              (subject, backConv = { case (_, newPos) => newPos } )
              (pt0, countBnds = nRange )
            .match { case r => r }
          }
        }}
      )
    } )
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

  @deprecatedInheritance
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

  // TODO
  given GeneralisedSBSLOOperator[PreRepForm, PostRepForm ]
    (using GeneralisedSBSLO[PreRepForm, PostRepForm ] )
  : AnyRef with {
    ;

    import lscalg.parsing.Subject.zippedWithReceiverInstances as S

    import BnrpMatchingLoopOp.{SpclBacktrackworthiness, SpclEagerness, SpclCountRange}

    def maxLoopN: Int
    = 1048576

    extension (impl0: PreRepForm )
    {
      //

      /* LAZY CASES */

      transparent inline
      def ??
      : PostRepForm
      = :*?(0, 1)

      transparent inline
      def :*?(n: Int)
      : PostRepForm
      = :*?(n, n)

      transparent inline
      def oneOrMoreTimeLazily
      : PostRepForm
      = :*?(1, maxLoopN )

      transparent inline
      def :*?(nMin: Int, nMax: Int)
      : PostRepForm
      = :*?(SpclCountRange.fromStartToIncludingEndIndex(nMin, nMax ) )

      // transparent inline
      def :*?(nRange: SpclCountRange._Any)
      : PostRepForm
      = impl0.repeated(SpclBacktrackworthiness._1, SpclEagerness.lazyInstance )(() , nRange )

      /* EAGERLY CASES */

      transparent inline
      def ?
      : PostRepForm
      = :*(0, 1)

      transparent inline
      def :*(n: Int)
      : PostRepForm
      = :*(n, n)

      transparent inline
      def oneOrMoreTime
      : PostRepForm
      = :*(1, maxLoopN )

      transparent inline
      def :*(nMin: Int, nMax: Int)
      : PostRepForm
      = :*(SpclCountRange.fromStartToIncludingEndIndex(nMin, nMax ) )

      // transparent inline
      def :*(nRange: SpclCountRange._Any)
      : PostRepForm
      = impl0.repeated(SpclBacktrackworthiness._1, SpclEagerness.+ )(() , nRange )

    }

  }

  import lscalg.digestivity.{Sdf, ParseFunction}

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
            val (matchedValues, _ ) = s.unzip

            val ptrPosProgression = (pt0 +: s.unzip._2 )

            (matchedValues, ptrPosProgression.last )
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













