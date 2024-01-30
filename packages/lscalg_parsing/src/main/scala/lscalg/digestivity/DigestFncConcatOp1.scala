package lscalg.digestivity














given prsZipOpsImpl
: AnyRef with lscalg.digestivity.SdfZipKAndTupledOps[ParseFunction.ForReceiverAndRValue ]
with {
  ;

  extension [
    //
    ReceiT,
    LhsVal,
  ] (impl: ParseFunction.ForReceiverAndRValue[ReceiT, LhsVal] )
    //

    /** 
     * concatenation of expected inputs,
     * effectively composition of *inp-pos*,
     * returned as `(parsed1, parsed2)`
     * 
     * concatenation of two Subject(s)
     * 
     */
    // override
    infix
    def zip
      [
        RhsVal ,
      ]
      (implRhs : ParseFunction.ForReceiverAndRValue[ReceiT, RhsVal] )
    : ParseFunction.ForReceiverAndRValue[ReceiT, (LhsVal, RhsVal)]
    = {
      ParseFunction.fromAltBRetrialFunction((receiverL0: ReceiT) => {
        ;

        /** 
         * must be aware that
         * the right receiver for the 2nd fnc call
         * is supposed to be what returned from the preceding fnc call, not the initial receiver
         * 
         */
        (
          //

          for {
            (v1, receiverL1)
              <- (impl ).applyBrt(receiverL0).to(LazyList) : @unchecked
            (v2, finalPos)
              <- implRhs.applyBrt(receiverL1).to(LazyList) : @unchecked
          }
          yield ((v1, v2) , finalPos )
        )
        .match { case l => { lscalg.parsing.BRetrialIterator.from(l) } }
      })
      .nn
    }

}



/** 
 * concatenation of two Subject(s),
 * effectively composition of *inp-pos*,
 * 
 */
object subjectConcatOps1
{
  ;

  ;

  locally([Pt, T] => (ea : ParseFunction.ForReceiverAndRValue[Pt, T ] ) => {
    Nil :+ ea :+ ea
  } )

  given prsSuccessionalOps
  : (AnyRef & lscalg.digestivity.sdfSuccessionalOpsImpl[ParseFunction.ForReceiverAndRValue ] )
  = {
    ;

    // import Subject.returnedMainValueMapOpExtras.given
    implicit val rmvo
    // = Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
    = ParseFunction.returnedMainValueMapOp1

    lscalg.digestivity.sdfSuccessionalOpsImpl[ParseFunction.ForReceiverAndRValue ]
    .nn
  }

  given prsZipOps
  : (AnyRef & lscalg.digestivity.SdfZipKAndTupledOps[ParseFunction.ForReceiverAndRValue ] )
  = lscalg.digestivity.prsZipOpsImpl

  /** 
   * the default concat operator (specifically, `PHTCO`) op impl,
   * being a strict-concat one.
   * 
   * (for comparison, there may be an alt impl which adds optional in-between whitespace-match rule )
   * 
   */
  given prsHeadTailConcatOp
  : AnyRef with PHTCO with {
    ;

    extension [
      //
      ReceiT,
      LhsVal,
    ] (impl: ParseFunction.ForReceiverAndRValue[ReceiT, LhsVal] )
    {
      //

      /** 
       * concatenation of expected inputs,
       * effectively composition of *inp-pos*,
       * returned as `parsed1 *: parsed2`
       * 
       * concatenation of two Subject(s)
       * 
       */
      def +%:
        [
          RhsVal ,
        ]
        (implRhs : => ParseFunction.ForReceiverAndRValue[ReceiT, RhsVal] )
        (using RVT : RhsVal <:< Tuple )
      : ParseFunction.ForReceiverAndRValue[ReceiT, (LhsVal *: (RhsVal & Tuple ) ) ]
      = ParseFunction.lazily {
        (impl zip implRhs )
        .applyBrt
        .andThen(o => (
          //
          o.map({ case ((lv, rv), newPos ) => (
            lv *: rv.match { case r => RVT.liftCo[[T] =>> (RhsVal & T ) ].apply(r) }
            ,
            newPos
            ,
          ) })
        ) )
        .match { case fnc => {
          ParseFunction.fromAltBRetrialFunction(fnc)
          .match { case r => {
            // prsSuccessionalOps.andThenAlso(ParseFunction.fromTotalFunction((_: ReceiT) => {} ) )(r )
            (ParseFunction.fromTotalFunction((p: ReceiT) => ((), p ) ) andThenAlso r )
            .match { case fnc => fnc }
            r
          } }
        } }
      }
    }

  }

  ;
}








type PHTCO
= PHTCOAlt[Nothing, Any ]

type PHTCOAlt
  [+RL <: RU, -RU ]
= PHTCOImpl[RL, RU ]

protected
trait PHTCOImpl
  [+RL <: RU, -RU ]
{
  ;

  extension [
    //
    ReceiT >: RL <: RU ,
    LhsVal,
  ] (impl: ParseFunction.ForReceiverAndRValue[ReceiT, LhsVal] )
  {
    //

    /** 
     * concatenation of expected inputs,
     * effectively composition of *inp-pos*,
     * returned as `parsed1 *: parsed2`
     * 
     * concatenation of two Subject(s)
     * 
     */
    def +%:
      [
        RhsVal ,
      ]
      (implRhs : => ParseFunction.ForReceiverAndRValue[ReceiT, RhsVal] )
      (using RVT : RhsVal <:< Tuple )
    : ParseFunction.ForReceiverAndRValue[ReceiT, (LhsVal *: (RhsVal & Tuple ) ) ]
  }

  ;
}







