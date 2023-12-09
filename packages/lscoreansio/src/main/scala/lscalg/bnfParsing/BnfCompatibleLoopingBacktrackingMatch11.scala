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
  trait ForReceiverImpl[ReceiT , R ] {
    extension (pt0: ReceiT)
      def tryForImmediateLoop
      : (
        (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness ) =>
        (SpclSubject.ForReceiverAndROpt[ReceiT, R ] , Range ) =>
          Option[Seq[R] ]
      )
    //

    extension (pt0: ReceiT)
      // TODO
      transparent inline
      def tryForImmediateLoop1
      : (
        (SpclSubject.ForReceiverAndROpt[ReceiT, R ] , Range, SpclEagerness ) =>
          Option[Seq[R] ]
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

  object SpclSubject {
    ;

    opaque type ForReceiverAndROpt
      [-ReceiT, +R ]
    <: AnyRef
    = ReceiT => Either[Unit, R ]

    extension [ReceiT, R ] (impl: ForReceiverAndROpt[ReceiT, R ] ) {
      //

      def applyEi(receiver: ReceiT )
      = impl.apply(receiver )

      def applyO(receiver: ReceiT )
      = impl.apply(receiver ).fold(_ => None, Some(_) )

    }
    //

    def fromPartialFunction
      [ReceiT, R ]
      (impl: PartialFunction[ReceiT, R ] )
    : ForReceiverAndROpt[ReceiT, R ]
    = {
      impl
      .lift
      .match { case fnc => fromLiftedPartialFunction(fnc) }
    }

    def fromLiftedPartialFunction
      [ReceiT, R ]
      (impl: Function1[ReceiT, Option[R] ] )
    : ForReceiverAndROpt[ReceiT, R ]
    = {
      impl
      .andThen(_.toRight(() ) )
    }

    ;

    final
    lazy val Mst
    : BnrpMatchingLoopOp.type
    = BnrpMatchingLoopOp

    def forFixedCompoundO
      [ReceiT, R ]
      (children: Seq[Function1[ReceiT, Option[R] ] ] , backConv: R => ReceiT )
      // (using Mst.ForReceiv )
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
  }

  object implementativeImplicits {
    ;

    implicit
    object spclExtensions {
      ;

      extension (r0: Range ) {

        transparent inline
        def incrBothEndsBy(incr: Int )
        = Range(r0.start + incr, r0.end + incr )

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
      (subject: SpclSubject.ForReceiverAndROpt[ReceiT, R1 ] , backConv: R1 => ReceiT )
    : (
      (p0: ReceiT, countBnds: Range ) =>
        Option[Seq[R1] ]
    )
    = {
      ;

      // TODO
      def %%%%
        (p0: ReceiT, countBnds0: Range )
      : Option[Seq[R1] ]
      = {
        ({
          ;

          ({
            ;

            Iterator.from(eagerness.pbs )
            .take(if canBacktrack(backtrackWorthiness) then 1048576 else 1 )
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
                  .flatMap(result1 => {
                    val p2
                    = backConv(result1)

                    for (sh <- %%%%(p2, countBnds0 = countBnds0.subtractBothEndsBy(1) ) )
                    yield { result1 +: sh }
                  } )
                }
                else {
                  if countBnds0.contains(0 ) then {
                    Some(Seq() )
                  }
                  else None
                }
            } : Option[ Seq[R1] ] })
          } }
        })
        .nextOption()
      }

      %%%% _
    }

    ;
  }

  ;
}











