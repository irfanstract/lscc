package lscalg.probing

















/**
 * 
 * an `IterableOps` to
 * represent/describe retrial-specific iterables of values
 * 
 */
object BRetrialIterator
extends
AnyRef
with BRetrialOpsLowerPriorityViews
{ BRetrialIterator =>
  ;

  /**
   * `ForItemT`
   */
  @deprecated("an alias of 'ForItemT'")
  type ForR[+R]
  = ForItemT[R]

  opaque type ForItemT[+R]
  <: AnyRef & Matchable
  =  LazyList[R]

  /**
   * 
   * of single value - the given value
   * 
   */
  def singularly
    (e: Any )
  : ForItemT[e.type ]
  = from[e.type] (LazyList[e.type](e ) )

  def from
    //
    [R]
    (impl: collection.IterableOnce[R] )
  : ForItemT[R]
  = {
    assert(impl.isInstanceOf[collection.IterableOnce[?] ], s"not an IterableOnce: $impl " )
    ({
      ;

      impl
      .match { case s => {
        s
        .match {
          case s : collection.Iterable[R] =>
            s.to(LazyList )
          case s =>
            s.iterator.to(LazyList )
          case impl =>
            assert(impl.isInstanceOf[collection.IterableOnce[?] ], s"not an IterableOnce: $impl (${import language.unsafeNulls ; impl.getClass().toGenericString() }) " )
            throw new AssertionError("unexpected fallthrough")
        }
      } : LazyList[R] }
    })
    .match { case s => {
      s : ForItemT[R]
    } }
  }

  object spclConversions
  {
    ;

    /**
     * 
     * this `Conversion` serves as the heart of the methods of BRtrI.
     * (TBD: switch to `extension` )
     * 
     * not merely `IterableOps`, but also `SeqOps` which `extends` the former
     * 
     */
    given ForROPs[R]
    : Conversion[
      BRetrialIterator.ForItemT[R]
      ,
      (
        collection.SeqOps[R, BRetrialIterator.ForItemT, BRetrialIterator.ForItemT[R] ]
        // &
        // collection.immutable.Seq[R]
      )
      ,
    ]
    = <:<.refl[BRetrialIterator.ForItemT[R] ].apply

  }

  // given lpaOps
  // // : AnyRef with {}
  implicit class LpaaOps[R] (val recei: ForItemT[R] )
  {
    ;

    def lazyAppendedAllC
      [R1 >: R ] (c: => IterableOnce[R1])
    : ForItemT[R1]
    = recei.lazyAppendedAll(c )

    // transparent inline
    def :++
      [R1 >: R ] (c: => IterableOnce[R1])
    : ForItemT[R1]
    = lazyAppendedAllC(c)

    def lazyPrependedAllC
      [R1 >: R ] (c: => IterableOnce[R1])
    : ForItemT[R1]
    = LazyList.empty.lazyAppendedAll(c) ++ recei

  }

  @deprecated
  implicit class CopyToArrayOps[R] (val recei: ForItemT[R] )
  {
    ;

    @deprecated
    @annotation.experimental
    def copyToArray()
    : Nothing
    = ???

  }

  ;

  // opaque type ForRAsDirect[+R]
  // <: AnyRef & Matchable & collection.SeqOps[R, ForRAsDirect, ForRAsDirect[R] ]
  // =  LazyList[R]

}

trait BRetrialOpsLowerPriorityViews
extends
AnyRef
{ this : BRetrialIterator.type =>
  ;

  export spclConversions.ForROPs

}

/**
 * 
 * an `IterableOps` to
 * represent/describe retrial-specific iterables of values
 * 
 */
type BRetrialIterator[+R]
= BRetrialIterator.ForItemT[R]











