package lscalg.digestivity
















/** 
 * `SdfZipWithReceiverIPackedCases`
 * 
 * the cases not directly exported here at `this`, only packed in(to) `zippedWithReceiverInstances`.
 * 
 */
// TODO
trait SdfZipWithReceiverIPackedCases
{
  Sdf : (
    //

    AnyRef
    & SdfCases
    & SdfRepr
    & SdfCommonlyNeededOps
  ) =>
  ;

  ;

  object zippedWithReceiverInstances {
    ;

    type ForReceiverAndRValue
      [ReceiT, +R ]
    = ForReceiverLUAndRValue[ReceiT, ReceiT, R ]

    type ForReceiverLUAndRValue
      [-ReceiL <: ReceiU, +ReceiU, +R ]
    = ImplForReceiverLUAndRValue[ReceiL, ReceiU, R ]

    /** 
     * `ImplForReceiverLUAndRValue`
     * 
     * currently merely a type-alias,
     * to avoid needing to
     * write proxies (to avoid issues with implicit-scopes) for every of the delegated factory methods
     * 
     */
    protected
    type ImplForReceiverLUAndRValue
      [-ReceiL <: ReceiU, +ReceiU, +R ]
    = Sdf.ForReceiverAndRValue[ReceiL, (R, ReceiU) ]

    ;

    ;

    ;

    ;
  }

  given returnedMainValueMapOp
  : AnyRef with SdfWithFilterOnMain[[LA, LRV] =>> ForReceiverAndRValue[LA, (LRV, LA) ] ] with {
    ;

    // import monaryReturnValueProjectiveOpImplicits.monaryReturnValueProjectiveOp

    import returnedMainValueMapOpExtras.given

    extension [LA, LRV] (lhsI : ForReceiverAndRValue[LA, (LRV, LA) ] )
    {
      //

      def mapMainValue
        //
        [NewRV]
        (proj: LRV => NewRV )
      = lhsI.map(proj )

      def flatMapMainValue
        //
        [NewRV]
        (proj: LRV => collection.IterableOnce[NewRV] )
      = lhsI.flatMap(proj )
    }
  }

  object returnedMainValueMapOpExtras {
    ;

    given returnedMainValueMapOp1
    : AnyRef with SdfWithFilter[zippedWithReceiverInstances.ForReceiverAndRValue ] with {
      ;

      import monaryReturnValueProjectiveOpImplicits.monaryReturnValueProjectiveOp.{collect as collectBoth, flatMap as flatMapBoth }

      extension [LA, LRV] (lhsI : ForReceiverAndRValue[LA, (LRV, LA) ] )
      {
        //

        def map
          //
          [NewRV]
          (proj: LRV => NewRV )
        : ForReceiverAndRValue[LA, (NewRV, LA) ]
        = {
          lhsI
          .collect(PartialFunction fromFunction proj )
        }

        /* LOCAL IMPL */
        def collect
          //
          [NewRV]
          (proj: PartialFunction[LRV, NewRV] )
        : ForReceiverAndRValue[LA, (NewRV, LA) ]
        = {
          lhsI
          .flatMap(proj.lift.andThen(_.toList) )
        }

        def flatMap
          //
          [NewRV]
          (proj: LRV => collection.IterableOnce[NewRV] )
        : ForReceiverAndRValue[LA, (NewRV, LA) ]
        = {
          lhsI
          // .flatMapBoth({ case (value, nextPt) => Nil :+ (proj(value) , nextPt ) })
          .flatMapBoth({ case (value0, nextPt) => {
            for {
              value1 <- proj(value0).match { case c => collection.View.from(c) }
            }
            yield (value1, nextPt)
          } })
        }

        /* LOCAL IMPL */
        def filter
          //
          (proj: LRV => Boolean )
        // : ForReceiverAndRValue[LA, (NewRV, LA) ]
        = {
          lhsI
          .flatMap(c => Some(c).filter(proj ) )
        }
      }
    }

    given returnedMainValueWithFinalPosMapOps1
    : returnedMainValueWithFinalPosMapOps1Impl[[LA, LRV] =>> ForReceiverAndRValue[LA, (LRV, LA) ] ]
    = returnedMainValueWithFinalPosMapOps1Impl[[LA, LRV] =>> ForReceiverAndRValue[LA, (LRV, LA) ] ]

    class returnedMainValueWithFinalPosMapOps1Impl
      [
        //
        Cc[LA, +LRV]
        >: ForReceiverAndRValue[LA, (LRV, LA) ]
        <: ForReceiverAndRValue[LA, (LRV, LA) ]
        ,
      ]
    {
      ;

      import monaryReturnValueProjectiveOpImplicits.monaryReturnValueProjectiveOp.{collect as collectBoth, flatMap as flatMapBoth }

      extension [LA, LRV] (lhsI : Cc[LA, LRV ] )
      {
        //

        /** 
         * `mapWithFinalPtrPosVl`
         * 
         */
        def mapWithFinalPtrPosVl
          //
          [NewRV]
          (proj: PartialFunction[(LRV, LA), NewRV] )
        : Cc[LA, NewRV ]
        = lhsI.collectBoth((v0, nextP) => (proj((v0, nextP )) , nextP ) )

        //
      }

    }

    ;
  }

  ;
}











