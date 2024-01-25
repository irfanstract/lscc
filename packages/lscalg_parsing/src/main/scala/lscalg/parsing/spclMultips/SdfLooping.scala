package lscalg.parsing.spclMultips










import lscalg.probing.BRetrialIterator





export lscalg.parsingCatt.LoopCountRange as BnrpCountRange





object BnrpMatchingLooping
{ BnrpMatchingLoopOp =>
  ;

  enum SpclEagerness {
    case `+`
    case lazyInstance
  }

  enum SpclBacktrackworthiness {
    case _1
    case _0
  }

  type SpclCountRange
  = BnrpCountRange

  transparent inline
  def SpclCountRange
  : BnrpCountRange.type
  = BnrpCountRange

  ;

  ;

  object implementativeImplicits {
    ;

    // export lscalg.digestivity.Sdf as SpclSubject
    transparent inline
    def SpclSubject
    : lscalg.digestivity.Sdf.type
    = lscalg.digestivity.Sdf

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
        BRetrialIterator.ForItemT[Seq[R1] ]
    )
    = {
      ;

      // TODO
      def %%%%
        (p0: ReceiT, countBnds0: Range.Inclusive )
      : BRetrialIterator.ForItemT[Seq[R1] ]
      = {
        // TODO
        if countBnds0.end < 0 then {
          return BRetrialIterator.from(None )
        }

        ({
          ;

          for {
            //
            needingMore <- BRetrialIterator.from((
              LazyList.from((
                eagerness.pbs
              )) 
            ))

            trValue <- (
              //

              if needingMore && (1 <= (countBnds0 : Range.Inclusive ).end ) then {
                ;

                for {
                  result1 <- (
                    ({
                      ;

                      subject.applyBrt(p0 )
                    } : BRetrialIterator.ForItemT[R1] )
                  )

                  p2 = backConv(result1)

                  /* recursion */
                  tail <- %%%%(p2, countBnds0 = countBnds0.subtractBothEndsBy(1) ) 

                }
                yield (result1 +: tail)
              }
              else {
                /**
                 * stop here.
                 * 
                 */
                BRetrialIterator.from({
                  Option.when(countBnds0.contains(0 ) ) {
                    Nil
                  }
                })
              }
            ) : BRetrialIterator.ForItemT[Seq[R1] ]

            //
          }
          yield trValue
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






