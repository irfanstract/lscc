package lscalg.digestivity



















trait SdfCommonlyNeededOps
extends
AnyRef
with SdfWithFilterOpsImpl
{
  this : (
    //

    AnyRef
    & SdfCases
    & SdfRepr
  ) =>
  ;

  ;

  given alternativeOp
  : AnyRef with {
    ;

    extension [LA, LRV] (lhsI : ForReceiverAndRValue[LA, LRV ] )
    {

      /** 
       * ordered alternation -- the LHS will take precedence over the RHS .
       * in case of [[lscalg.parsing.BRetrialIterator polymorphic matches ]],
       * will be deferred to after the end of the (ordered) set.
       * 
       */
      infix
      def orElse
        [UniRV >: LRV]
        (rhsI : ForReceiverAndRValue[LA, UniRV ] )
      = {
        /** 
         * this shall stick to `applyBrt`.
         * 
         */
        fromAltBRetrialFunction((pt0: LA ) => {
          (lhsI.applyBrt(pt0) concat rhsI.applyBrt(pt0) )
          .match { case r => lscalg.parsing.BRetrialIterator.from(r) }
        } )
      }
    }

    //
  }

  @deprecated("there are two versions of the WithFilter op. please, import 'monaryReturnValueProjectiveOp' explicitly.")
  given returnValueProjectiveOp
  : (AnyRef & SdfWithFilter[ForReceiverAndRValue] )
  = {
    import monaryReturnValueProjectiveOpImplicits.monaryReturnValueProjectiveOp
    monaryReturnValueProjectiveOp
  }

  ;
}

trait SdfWithFilterOpsImpl
{
  this : (
    //

    AnyRef
    & SdfCases
    & SdfRepr
  ) =>
  ;

  object monaryReturnValueProjectiveOpImplicits
  {
    ;

    given monaryReturnValueProjectiveOp
    : (AnyRef & SdfWithFilter[ForReceiverAndRValue] )
    = new AnyRef with SdfWithFilter[ForReceiverAndRValue] {
      ;

      extension [LA, LRV] (lhsI : ForReceiverAndRValue[LA, LRV ] )
      {
        //

        def map
          //
          [NewRV]
          (proj: LRV => NewRV )
        : ForReceiverAndRValue[LA, NewRV ]
        = {
          fromAltBRetrialFunction((
            lhsI.applyBrt
            .andThen((poset : lscalg.parsing.BRetrialIterator.ForR[LRV]) => poset.map(proj) )
          ))
        }

        def collect
          //
          [NewRV]
          (proj: PartialFunction[LRV, NewRV] )
        : ForReceiverAndRValue[LA, NewRV ]
        = {
          fromAltBRetrialFunction((
            lhsI.applyBrt
            .andThen((poset : lscalg.parsing.BRetrialIterator.ForR[LRV]) => poset.collect(proj) )
          ))
        }

        def flatMap
          //
          [NewRV]
          (proj: LRV => collection.IterableOnce[NewRV] )
        : ForReceiverAndRValue[LA, NewRV ]
        = {
          fromAltBRetrialFunction((
            lhsI.applyBrt
            .andThen((poset : lscalg.parsing.BRetrialIterator.ForR[LRV]) => poset.flatMap(proj) )
          ))
        }

        def filter
          //
          (pred: LRV => Boolean )
        : ForReceiverAndRValue[LA, LRV ]
        = {
          fromAltBRetrialFunction((
            lhsI.applyBrt
            .andThen((poset : lscalg.parsing.BRetrialIterator.ForR[LRV]) => poset.filter(pred) )
          ))
        }

        // def withFilter
        //   //
        //   (pred: LRV => Boolean )
        // : ForReceiverAndRValue[LA, LRV ]
        // = lhsI.filter(pred )

      }
    }

    ;
  }

  ;

  ;
}




trait SdfWithFilter[ ForReceiverAndRValue[LA, +LRV ] ]
{
  ;

  ;

  extension [LA, LRV] (lhsI : ForReceiverAndRValue[LA, LRV ] )
  {
    //

    def map
      //
      [NewRV]
      (proj: LRV => NewRV )
    : ForReceiverAndRValue[LA, NewRV ]

    def collect
      //
      [NewRV]
      (proj: PartialFunction[LRV, NewRV] )
    : ForReceiverAndRValue[LA, NewRV ]

    def flatMap
      //
      [NewRV]
      (proj: LRV => collection.IterableOnce[NewRV] )
    : ForReceiverAndRValue[LA, NewRV ]

    def filter
      //
      (pred: LRV => Boolean )
    : ForReceiverAndRValue[LA, LRV ]

    transparent inline
    def withFilter
      //
      (pred: LRV => Boolean )
    : ForReceiverAndRValue[LA, LRV ]
    = lhsI.filter(pred )

  }

  ;
}













