package lscalg.bnfParsing

package spclDequeueFncCombiners



















object SpclTotalFunction {
  opaque type ForAAndR[-A, +R]
  <: PartialFunction[A, R]
  =  PartialFunction[A, R]

  def apply
    [A, R]
    (impl: Function[A, R] )
  : ForAAndR[A, R]
  = {
    PartialFunction.fromFunction((arg: A) => {
      impl
      .apply(arg)
    })
  }
}

type SpclTotalFunction[-A, +R]
= SpclTotalFunction.ForAAndR[A, R]





type SpclDequeueFunction[A, +R]
>: PartialFunction[A, (R, A) ]
<: PartialFunction[A, (R, A) ]

type SpclDequeueRetemptFunction[A, +R]
>: SpclTotalFunction[A, BnfCompatibleRetrialIterator[(R , A ) ] ]
<: SpclTotalFunction[A, BnfCompatibleRetrialIterator[(R , A ) ] ]












