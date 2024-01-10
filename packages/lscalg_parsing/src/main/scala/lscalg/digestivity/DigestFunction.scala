package lscalg.digestivity














/**
 * 
 * on an obtained `ParseFunction`, one can do this
 * 
 * ```
 * // function (s: ParseFunction )
 * 
 * val dOpt = tryParse(src = existingInpPos, subject = s )
 * ```
 * 
 * a `ParseFunction`
 * can be obtained from one of the factory methods,
 * most which builds on given "partial digest function"
 * 
 * ```
 * ParseFunction.fromLiftedPartialFunction((inpPtr: FileReadPos ) => {
 *   ;
 *   inpPtr.tryNextBigDecimal()
 * } )
 * ```
 * 
 * `lscalg.parsing`
 * 
 */
object ParseFunction
{
  ;

  export Sdf.zippedWithReceiverInstances.{*, given}

  ;

  ;
}

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

    type _Any
    = ImplForReceiverLUAndRValue[Nothing, Any, Any ]

    ;

    def emptyTupleValuedInstance
      [ReceiT]
    = resolvingWith[ReceiT, EmptyTuple.type ] (_ => EmptyTuple )

    def resolvingWith
      [ReceiT, R ]
      (vf: ReceiT => R )
    = fromTotalFunction((pt0: ReceiT) => (vf(pt0), pt0 ) )

    export misnamedFtfReExports.{*, given }

    protected
    object misnamedFtfReExports {
      ;
      export Sdf.{
        fromTotalFunction ,
        fromPartialFunction ,
        // fromLiftedPartialFunction ,
        fromAltLiftedFunction ,
      }
    }

    /**
     * `fromLiftedPartialFunction`
     * 
     * caveat --
     * it's essential to make the lambda explicitly ascribe the main arg type,
     * to work-around limitations of type-inference
     * 
     */
    def fromLiftedPartialFunction
      [ReceiT, R ]
      (impl: Function1[ReceiT, Option[(R, ReceiT)] ] )
    : ForReceiverAndRValue[ReceiT, R ]
    = Sdf.fromLiftedPartialFunction(impl).nn

    def fromBPermutLiftedFunction
      [ReceiT, R ]
      (impl: Function1[ReceiT, lscalg.parsing.BRetrialIterator[(R, ReceiT)] ] )
    : ForReceiverAndRValue[ReceiT, R ]
    = Sdf.fromAltBRetrialFunction(impl).nn

    ;

    type ForReceiverAndRMonad
      [ReceiU, +RMonad <: Either[Sdf.RExceptionUpperBound, ? ] ]
    = (
      // _Any
      // &
      ForReceiverAndRValue[ReceiU, Any ]
      &
      Sdf.ForReceiverAndRMonad[ReceiU, RMonad ]
    )

    type ForReceiverLUAndRMonad
      [-ReceiL <: ReceiU, +ReceiU, +RMonad <: Either[Sdf.RExceptionUpperBound, ? ] ]
    = (
      // _Any
      // &
      ForReceiverLUAndRValue[ReceiL, ReceiU, Any ]
      &
      Sdf.ForReceiverAndRMonad[ReceiL, RMonad ]
    )

    ;

    ;
  }

  given returnedMainValueMapOp
  : AnyRef with {
    ;

    import monaryReturnValueProjectiveOpImplicits.monaryReturnValueProjectiveOp

    extension [LA, LRV] (lhsI : ForReceiverAndRValue[LA, (LRV, LA) ] )
    {
      //

      def mapMainValue
        //
        [NewRV]
        (proj: LRV => NewRV )
      = {
        lhsI
        .map({ case (value, nextPt) => (proj(value) , nextPt ) })
      }

      def flatMapMainValue
        //
        [NewRV]
        (proj: LRV => NewRV )
      = {
        lhsI
        .map({ case (value, nextPt) => (proj(value) , nextPt ) })
      }
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
        = {
          lhsI
          // .flatMapBoth({ case (value, nextPt) => Nil :+ (proj(value) , nextPt ) })
          .flatMapBoth({ case (value0, nextPt) => {
            for { value1 <- proj(value0) } yield (value1, nextPt)
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
    : AnyRef with {
      ;

      import monaryReturnValueProjectiveOpImplicits.monaryReturnValueProjectiveOp.{collect as collectBoth, flatMap as flatMapBoth }

      extension [LA, LRV] (lhsI : ForReceiverAndRValue[LA, (LRV, LA) ] )
      {
        //

        /** 
         * `collectWithFinalPtrPosVl`
         * 
         */
        def mapWithFinalPtrPosVl
          //
          [NewRV]
          (proj: PartialFunction[(LRV, LA), NewRV] )
        = lhsI.collectBoth((v0, nextP) => (proj((v0, nextP )) , nextP ) )

        //
      }

      ;
    }

    ;
  }

  ;
}












