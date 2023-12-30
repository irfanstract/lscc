package lscalg.parsing



















opaque type BnrpCountRange
<: AnyRef & Matchable
// >: Range
// <: Range
= Range

object BnrpCountRange
{
  ;

  //
  transparent inline
  def inclusive(start: Int, end: Int)
  : BnrpCountRange
  = Range.inclusive(start, `end`)

  // extension (d: BnrpCountRange )
  //   def start = d.start
  //   def end   = d.end

  @deprecated
  given Conversion[Range, BnrpCountRange]
  = (<:<.refl[Range] ).apply _

  @deprecated
  given Conversion[BnrpCountRange, Range]
  = (<:<.refl[Range] ).apply _


  ;
}





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
          BRetrialIterator.ForR[Seq[R] ]
      )
    //

    extension (pt0: ReceiT)
      // TODO
      transparent inline
      def tryForImmediateLoop1
      : (
        (SpclSubject.ForReceiverAndRValue[ReceiT, R ] , SpclCountRange, SpclEagerness ) =>
          BRetrialIterator.ForR[Seq[R] ]
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

  type SpclCountRange
  = BnrpCountRange

  transparent inline
  def SpclCountRange
  : BnrpCountRange.type
  = BnrpCountRange

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
        BRetrialIterator.ForR[Seq[R1] ]
    )
    = {
      ;

      // TODO
      def %%%%
        (p0: ReceiT, countBnds0: Range.Inclusive )
      : BRetrialIterator.ForR[Seq[R1] ]
      = {
        if countBnds0.end < 0 then {
          return BRetrialIterator.from(Nil )
        }

        ({
          ;

          ({
            ;

            BRetrialIterator.from(eagerness.pbs )
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
                  .match { case tr => BRetrialIterator.from(tr) }
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
                  .match { case tr => BRetrialIterator.from(tr ) }
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














