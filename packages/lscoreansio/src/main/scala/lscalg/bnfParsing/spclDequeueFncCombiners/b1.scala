package lscalg.bnfParsing

package spclDequeueFncCombiners















extension [A, R] (impl: SpclDequeueFunction[A, R] ) {
  def liftedForLsc
  : SpclTotalFunction[A, Option[(R, A)] ]
  = SpclTotalFunction(impl.lift )
}





trait LbfOp[-T0, +T2]
{
  ;

  extension (impl: T0)
    //
    def loopingBacktrackablyFor
      //
      (range: BnrpMatchingLoopOp.SpclCountRange, ea: BnrpMatchingLoopOp.SpclEagerness, bw: BnrpMatchingLoopOp.SpclBacktrackworthiness )
    : T2

  ;
}

object LbfOp {
  ;

  ;

  given given_LbfOp_Sdf_Ebf1 [A, R]
  : LbfOp[SpclDequeueFunction[A, R] , SpclDequeueRetemptFunction[A, Seq[R] ] ]
  with {
    ;

    extension (impl: SpclDequeueFunction[A, R] )
      override
      def loopingBacktrackablyFor
        (range: BnrpMatchingLoopOp.SpclCountRange, ea: BnrpMatchingLoopOp.SpclEagerness, bw: BnrpMatchingLoopOp.SpclBacktrackworthiness )
      : SpclDequeueRetemptFunction[A, Seq[R] ]
      = {
        BnrpMatchingLoopOp.implementativeImplicits.rImpl
          (backtrackWorthiness = bw, eagerness = ea )
          (BnrpMatchingLoopOp.SpclSubject.fromPartialFunction(impl) , backConv = _._2 )
        .match { case f => {
          SpclTotalFunction((pt0: A) => {
            f(pt0, countBnds = range )
            .map(matched => ({
              matched
              .map[R] ({ case (matchedStr, _) => matchedStr })
            } , (matched.map({ case (_, nextPos) => nextPos }) ).prepended[A](pt0 ).head ) )
          } )
        } }
        .match { case r => r }
      }
    //

  }

  ;
}

extension [A, R] (impl: SpclDequeueFunction[A, R] )
  transparent inline
  def loopingBacktrackablyFor
    (range: BnrpMatchingLoopOp.SpclCountRange, ea: BnrpMatchingLoopOp.SpclEagerness, bw: BnrpMatchingLoopOp.SpclBacktrackworthiness )
  : SpclDequeueRetemptFunction[A, Seq[R] ]
  = {
    ;
    LbfOp.given_LbfOp_Sdf_Ebf1[A, R]
    .loopingBacktrackablyFor(impl) (range, ea = ea , bw = bw )
  }
//




object EConcKOp {
  ;

  ;

  type ForCc[Cc[+R] ]
  >: Impl[Cc]
  <: Impl[Cc]

  ;

  trait Impl[Cc[+R] ]
  {
    ;

    // extension [R1] (lhs: Cc[R1] )
    //   def andThenAlso
    //     [R2]
    //     (rhs: Cc[R2] )
    //   : Cc
    extension [R1] (lhs: Cc[R1] )
      def *%:
        [R2 <: Tuple ]
        (rhs: Cc[R2] )
      : Cc[R1 *: R2 ]

    ;
  }

  ;

  given given1[A]
  : ForCc[[R] =>> PartialFunction[A, R] ]
  = {
    type Cc
    >: [R] =>> PartialFunction[A, R]
    <: [R] =>> PartialFunction[A, R]
    new Impl[[R] =>> PartialFunction[A, R] ]
    {
      ;
      extension [R1] (lhs: Cc[R1] )
        def *%:[R2 <: Tuple] (rhs: Cc[R2] )
        : Cc[R1 *: R2 ]
        = {
          ;
          ((arg: A ) => {
            ((lhs.lift).apply(arg) zip (rhs.lift).apply(arg) )
            .map({ case (r1, r2) => r1 *: r2 })
            .filter(_ => true )
          })
          .unlift
          .nn
        }
    }
  }

  ;

  ;

  ;
}













