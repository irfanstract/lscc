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
  : AnyRef with lscalg.digestivity.SdfFallBackOps[ForReceiverAndRValue ]
  with {
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
      }.nn
    }

    //
  }

  given brtLiftingOps1
  : AnyRef with {
    ;

    extension [ReceiT, R ] (impl: ForReceiverAndRValue[ReceiT, R ] )
      //

      /**
       * lifted -- `BRetrialIterator[R]`
       * 
       */
      // @deprecated
      def liftSbjBr
        // lscalg.parsing.BRetrialIterator[R]
      // : ForReceiverAndRMonad[ReceiT, Right[Nothing, lscalg.parsing.BRetrialIterator[R] ] ]
      = fromAltLiftedFunction((
        (impl.applyBrt )
        andThen (Right(_) )
      )).nn

    ;
  }

  given optLiftingOps1
  : AnyRef with {
    ;

    extension [ReceiT, R ] (impl: ForReceiverAndRValue[ReceiT, R ] )
      //

      /**
       * lifted -- `Option[R]`
       * 
       */
      @deprecated("'lift the return-value into being Option[this.R]' assumes mono-morphism and therefore is relatively lossy op. switch to 'liftSbjBr' instead.")
      def liftSbjO
        //
      // : ForReceiverAndRMonad[ReceiT, Right[Nothing, Option[R] ] ]
      = fromAltLiftedFunction((
        (impl.applyEi )
        andThen(ei => ei.toOption ) 
        andThen (Right(_) )
      ))

    ;
  }

  @deprecated("there are two versions of the WithFilter op. please, import 'monaryReturnValueProjectiveOp' explicitly.")
  protected
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

  transparent inline
  def returnedCompleteValueMapOpExtras
  : monaryReturnValueProjectiveOpImplicits.type
  = monaryReturnValueProjectiveOpImplicits

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
            .andThen((poset : lscalg.parsing.BRetrialIterator.ForItemT[LRV]) => poset.map(proj) )
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
            .andThen((poset : lscalg.parsing.BRetrialIterator.ForItemT[LRV]) => poset.collect(proj) )
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
            .andThen((poset : lscalg.parsing.BRetrialIterator.ForItemT[LRV]) => poset.flatMap(proj) )
          ))
        }

        def filter
          //
          (pred: LRV => Boolean )
        : ForReceiverAndRValue[LA, LRV ]
        = {
          fromAltBRetrialFunction((
            lhsI.applyBrt
            .andThen((poset : lscalg.parsing.BRetrialIterator.ForItemT[LRV]) => poset.filter(pred) )
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
















