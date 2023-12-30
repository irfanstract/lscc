package lscalg.digestivity



















trait SdfCommonlyNeededOps
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

  ;
}













