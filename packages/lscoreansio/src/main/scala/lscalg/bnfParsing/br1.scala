package lscalg.bnfParsing






















object BRetrialIterator {
  ;

  opaque type ForR[+R]
  <: AnyRef & Matchable
  =  LazyList[R]

  def singularly
    (e: Any )
  : ForR[e.type ]
  = from[e.type] (LazyList[e.type](e ) )

  def from
    //
    [R]
    (impl: collection.IterableOnce[R] )
  : ForR[R]
  = {
    ({
      ;

      impl
      .match { case s => {
        s
        .match {
          case s : collection.Iterable[R] =>
            s.to(LazyList )
          case s : collection.Iterator[R] =>
            s.to(LazyList )
        }
      } : LazyList[R] }
    })
    .match { case s => {
      s : ForR[R]
    } }
  }

  given ForROPs[R]
  : Conversion[BRetrialIterator.ForR[R] , collection.SeqOps[R, BRetrialIterator.ForR, BRetrialIterator.ForR[R] ] ]
  = <:<.refl[BRetrialIterator.ForR[R] ].apply _

  ;

  // opaque type ForRAsDirect[+R]
  // <: AnyRef & Matchable & collection.SeqOps[R, ForRAsDirect, ForRAsDirect[R] ]
  // =  LazyList[R]

}

type BRetrialIterator[+R]
= BRetrialIterator.ForR[R]











