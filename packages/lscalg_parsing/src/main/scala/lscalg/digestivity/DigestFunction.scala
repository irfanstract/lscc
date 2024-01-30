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
extends
AnyRef
with ParseFunctionExtras
{
  ;

  // export Sdf.zippedWithReceiverInstances.{*, given}

  type ForReceiverAndRValue
    [ReceiT, +R ]
  = ForReceiverLUAndRValue[ReceiT, ReceiT, R ]

  type ForReceiverLUAndRValue
    [-ReceiL <: ReceiU, +ReceiU, +R ]
  = ImplForReceiverLUAndRValue[ReceiL, ReceiU, R ]

  /** 
   * `ImplForReceiverLUAndRValue`
   * 
   * 
   */
  protected
  opaque type ImplForReceiverLUAndRValue
    [-ReceiL <: ReceiU, +ReceiU, +R ]
  <: AnyRef
  = Sdf.ForReceiverAndRValue[ReceiL, (R, ReceiU) ]

  type _Any
  = ImplForReceiverLUAndRValue[Nothing, Any, Any ]

  ;

  // TODO

  infix
  def fromAltBRetrialFunction
    [A, R ]
    (impl: A => lscalg.parsing.BRetrialIterator[(R, A)] )
  : ForReceiverAndRValue[A, R ]
  = Sdf.fromAltBRetrialFunction(impl).nn

  /**
   * from a func which is "defined for subset inst of `ReceiT`"
   * 
   */
  infix
  def fromPartialFunction
    [ReceiT, R ]
    (impl: PartialFunction[ReceiT, (R, ReceiT) ] )
  : ForReceiverAndRValue[ReceiT, R ]
  = {
    Sdf.fromPartialFunction(impl).nn
  }

  ;

  /** 
   * 
   * evidence that `ParseFunction.ForReceiverAndRValue[ReceiT, R ] =:= Sdf.zippedWithReceiverInstances.ForReceiverAndRValue[ReceiT, R ]`,
   * a utility to simplify deriving
   * 
   */
  def iev
  : (
    { type Main[ReceiT, R ] = ParseFunction.ForReceiverAndRValue[ReceiT, R ] }
    =:=
      { type Main[ReceiT, R ] = Sdf.zippedWithReceiverInstances.ForReceiverAndRValue[ReceiT, R ] }
  )
  = <:<.refl[{ type Main[ReceiT, R ] = ParseFunction.ForReceiverAndRValue[ReceiT, R ] } ]

  ;

  /** 
   * the `applyBrt` methods provider
   */
  given eApplyEiOrOptionPkOps
  : AnyRef with {
    ;

    extension [ReceiT, R ] (d: ForReceiverAndRValue[ReceiT, R ])
    {
      private
      def asHasApplyBRT: Sdf.ForReceiverAndRValue[ReceiT, (R, ReceiT) ]
      = d
      export asHasApplyBRT.{applyBrt, applyEi}

    }
  }

  /** 
   * the WithFilter methods provider,
   * defined to be on the main-value (of two values, the other one being `the subsequent parser-position`)
   * 
   */
  @deprecated
  transparent inline
  def returnedMainValueMapOp1
  : returnedMainValueMapOpImplicits.returnedMainValueMapOp.type
  = returnedMainValueMapOpImplicits.returnedMainValueMapOp

  object returnedMainValueMapOpImplicits
  {
    ;

    given returnedMainValueMapOp
    : (AnyRef & SdfWithFilter[ForReceiverAndRValue ] )
    = Sdf.returnedMainValueMapOpExtras.returnedMainValueMapOp1.nn

  }

  given returnedMainValueMapOpAlt
  : (AnyRef & SdfWithFilterOnMain[ForReceiverAndRValue ])
  = Sdf.returnedMainValueMapOp

  given returnedMainValueWithFinalPosMapOps11
  : Sdf.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1Impl[[LA, LRV] =>> ForReceiverAndRValue[LA, LRV ] ]
  = Sdf.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1Impl[[LA, LRV] =>> ForReceiverAndRValue[LA, LRV ] ]

  /** 
   * the `orElse` provider
   */
  given alternationalOp
  : (AnyRef & lscalg.digestivity.SdfFallBackOps[ForReceiverAndRValue ] )
  = new AnyRef with lscalg.digestivity.SdfFallBackOps[ForReceiverAndRValue ] {
    ;

    import Sdf.alternativeOp.{orElse as orElseImpl }

    extension [LA, LRV] (lhsI : ForReceiverAndRValue[LA, LRV ] )

      infix
      def orElse
        [UniRV >: LRV]
        (rhsI : ForReceiverAndRValue[LA, UniRV ] )
      = (
        lhsI.orElseImpl(rhsI)
      ).nn
  }

  ;

  // TODO
  @deprecated
  // protected 
  given given_sBnrpSubjectLoopOpP[ReceiT , R ]
  : (AnyRef & lscalg.parsing.SubjectLoopOpOptInImplicits1.GeneralisedSBSLO[
    //
    ParseFunction.ForReceiverAndRValue[ReceiT, R]
    ,
    ParseFunction.ForReceiverAndRValue[ReceiT, Seq[R]]
    ,
  ])
  = {
    lscalg.parsing.SubjectLoopOpOptInImplicits1.given_sBnrpSubjectLoopOp[ReceiT , R ]
  }.nn

  // // TODO
  @deprecated
  given given_GeneralisedSBSLOOperator_ForReceiverAndRValue_ForReceiverAndRValue[ReceiT , R ]
  : lscalg.parsing.SubjectLoopOpOptInImplicits1.GeneralisedSBSLOOperator[
    //
    ParseFunction.ForReceiverAndRValue[ReceiT, R]
    ,
    ParseFunction.ForReceiverAndRValue[ReceiT, Seq[R]]
    ,
  ]
  = {
  lscalg.parsing.SubjectLoopOpOptInImplicits1.GeneralisedSBSLOOperator[
    //
    ParseFunction.ForReceiverAndRValue[ReceiT, R]
    ,
    ParseFunction.ForReceiverAndRValue[ReceiT, Seq[R]]
    ,
  ]
  }.nn

  ;

  ;
}

trait ParseFunctionExtras
{ this : ParseFunction.type =>
  //

  ;

  def emptyTupleValuedInstance
    [ReceiT]
  : ForReceiverAndRValue[ReceiT, (EmptyTuple.type)]
  = resolvingWith[ReceiT, EmptyTuple.type ] (_ => EmptyTuple )

  def resolvingWith
    [ReceiT, R ]
    (vf: ReceiT => R )
  : ForReceiverAndRValue[ReceiT, R ]
  = fromTotalFunction((ptr: ReceiT) => (vf(ptr), ptr ) ).nn

  infix
  def fromLiftedPartialFunction
    [ReceiT, R ]
    (impl: Function1[ReceiT, Option[(R, ReceiT)] ] )
  : ForReceiverAndRValue[ReceiT, R ]
  = fromAltBRetrialFunction((
    impl
    andThen
    (o => lscalg.probing.BRetrialIterator.from(o ).nn )
  ) )

  /**
   * from a func which is "defined for all inst of `ReceiT`"
   * 
   */
  infix
  def fromTotalFunction
    [ReceiT, R ]
    (impl: Function[ReceiT, (R, ReceiT) ] )
  : ForReceiverAndRValue[ReceiT, R ]
  = {
    fromPartialFunction(impl.apply )
  }

  ;

  /** 
   * 
   * a work-around to
   * the eagerness of the operators
   * 
   */
  def lazily
    //
    [ReceiT, R ]
  (impl0: => ForReceiverAndRValue[ReceiT, R ] )
  : ForReceiverAndRValue[ReceiT, R ]
  = ({
    lazy val impl
    = impl0

    fromAltBRetrialFunction((p0: ReceiT) => (
      impl.applyBrt(p0 )
    ) )
  })

  ;

  ;
}
















