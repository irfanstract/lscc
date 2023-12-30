package lscalg.bnfParsing





















object BnrpMatchingLoopOp {
  ;

  enum SpclEagerness {
    case `+`
    case lazyInstance
  }

  enum SpclBacktrackworthiness {
    case _1
    case _0
  }

  type _Any
  = ForReceiverLU[Nothing, Any, Nothing, Any ]

  type ForReceiver[ReceiT, R ]
  = ForReceiverLU[ReceiT, ReceiT, R, R ]

  type ForReceiverLU[-ReceiTL <: ReceiTU, +ReceiTU, -RL <: RU, +RU  ]
  = ForReceiverImpl[? >: ReceiTL <: ReceiTU , ? >: RL <: RU ]

  // protected
  trait ForReceiverImpl[ReceiT , R ]
  {
    extension (pt0: ReceiT)
      def tryForImmediateLoop
      : (
        (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness ) =>
        (SpclSubject.ForReceiverAndRValue[ReceiT, R ] , SpclCountRange ) =>
          BnfCompatibleRetrialIterator.ForR[Seq[R] ]
      )
    //

    extension (pt0: ReceiT)
      // TODO
      transparent inline
      def tryForImmediateLoop1
      : (
        (SpclSubject.ForReceiverAndRValue[ReceiT, R ] , SpclCountRange, SpclEagerness ) =>
          BnfCompatibleRetrialIterator.ForR[Seq[R] ]
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

  // export lscalg.digestivity.Subject as SpclSubject
  transparent inline
  def SpclSubject
  : lscalg.digestivity.Subject.type
  = lscalg.digestivity.Subject

  opaque type SpclCountRange
  <: AnyRef & Matchable
  // >: Range
  // <: Range
  = Range

  object SpclCountRange {
    ;

    //
    transparent inline
    def inclusive(start: Int, end: Int)
    : SpclCountRange
    = Range.inclusive(start, `end`)

    // extension (d: SpclCountRange )
    //   def start = d.start
    //   def end   = d.end

    @deprecated
    given Conversion[Range, SpclCountRange]
    = (<:<.refl[Range] ).apply _

    @deprecated
    given Conversion[SpclCountRange, Range]
    = (<:<.refl[Range] ).apply _


    ;
  }

  object implementativeImplicits {
    ;

    implicit
    object spclExtensions {
      ;

      extension (r0: Range.Inclusive ) {

        transparent inline
        def incrBothEndsBy(incr: Int )
        = Range.inclusive(r0.start + incr, r0.end + incr )

        transparent inline
        def subtractBothEndsBy(incr: Int )
        = r0.incrBothEndsBy(-incr )

      }

      extension (r0: SpclEagerness )
        def pbs
        = r0 match {
          case SpclEagerness.+ =>
            Nil :+ true :+ false
          case SpclEagerness.lazyInstance =>
            Nil :+ false :+ true
        }

    }

    transparent inline
    def canBacktrack(md: SpclBacktrackworthiness)
    = md match
      case SpclBacktrackworthiness._1 => true
      case SpclBacktrackworthiness._0 => false
    //

    def rImpl
      //
      [ReceiT , R1 ]
      (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness )
      (subject: SpclSubject.ForReceiverAndRValue[ReceiT, R1 ] , backConv: R1 => ReceiT )
    : (
      (p0: ReceiT, countBnds: SpclCountRange ) =>
        BnfCompatibleRetrialIterator.ForR[Seq[R1] ]
    )
    = {
      ;

      // TODO
      def %%%%
        (p0: ReceiT, countBnds0: Range.Inclusive )
      : BnfCompatibleRetrialIterator.ForR[Seq[R1] ]
      = {
        if countBnds0.end < 0 then {
          return BnfCompatibleRetrialIterator.from(Nil )
        }

        ({
          ;

          ({
            ;

            BnfCompatibleRetrialIterator.from(eagerness.pbs )
            // .take(if canBacktrack(backtrackWorthiness) then 1048576 else 1 )
          })
          .match { case trs => {
            ;

            trs

            .flatMap({ case (needingMore) => {
                ;

                if needingMore then {
                  ;

                  subject.applyEi(p0 )

                  .toOption
                  .match { case tr => BnfCompatibleRetrialIterator.from(tr) }
                  .flatMap(result1 => {
                    val p2
                    = backConv(result1)

                    for (sh <- %%%%(p2, countBnds0 = countBnds0.subtractBothEndsBy(1) ) )
                    yield { result1 +: sh }
                  } )
                }
                else {
                  ({
                    ;

                    if countBnds0.contains(0 ) then {
                      Some(Seq() )
                    }
                    else None
                  })
                  .match { case tr => BnfCompatibleRetrialIterator.from(tr ) }
                }
            }.iterator })
          } }
        })
      }

      (p0: ReceiT, countBnds0: SpclCountRange ) => {
        %%%%(p0, countBnds0 = Range.inclusive(countBnds0.start, countBnds0.end ) )
        .take(if canBacktrack(backtrackWorthiness) then 1048576 else 1 )
        .match { case r => {
          r
        } }
      }
    }

    ;
  }

  ;
}

object sBnrpMatchingLoopOpOptInImplicits
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
            BnfCompatibleRetrialIterator.ForR[Seq[R] ]
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
        lscalg.parsing.Subject.fromLiftedPartialFunction[ReceiT , (Seq[RValue], ReceiT) ] (pt0 => {
          given_sBnrpMatchingLoopOp_tupleTwo[ReceiT , RValue ]
          .tryForImmediateLoop
            (pt0 )
            (backtrackWorthiness = backtrackWorthiness , eagerness = eagerness )
            (impl0, nRange )
          .headOption
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

}












