package lscalg.parsing













// export lscalg.digestivity.Subject as SpclSubject
/**
 * 
 * on an obtained `Subject`, one can do this
 * 
 * ```
 * val dOpt = tryParse(src = existingInpPos, subject = s )
 * ```
 * 
 * a `Subject`
 * can be obtained from one of the factory methods,
 * most which builds on given "partial digest function"
 * 
 * ```
 * Subject.fromLiftedPartialFunction((inpPtr: FileReadPos ) => {
 *   ;
 *   inpPtr.tryNextBigDecimal()
 * } )
 * ```
 * 
 * `lscalg.parsing`
 * 
 */
@deprecated
transparent inline
def Subject
: lscalg.digestivity.Subject.type
= lscalg.digestivity.Subject

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
transparent inline
def ParseFunction
: lscalg.digestivity.ParseFunction.type
= lscalg.digestivity.ParseFunction

;






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
  : AnyRef with {
    ;

    extension [
      //
      ReceiT,
      LhsVal,
    ] (impl: ParseFunction.ForReceiverAndRValue[ReceiT, LhsVal] )

      /** 
       * concatenation of expected inputs,
       * effectively composition of *inp-pos*,
       * returned as `(parsed1, parsed2)`
       * 
       * concatenation of two Subject(s)
       * 
       */
      @deprecated
      infix
      transparent inline
      def andThenAlso
        [
          // RhsREi <: Either[Subject.RExceptionUpperBound, (RhsVal, ReceiT) ],
          RhsVal ,
        ]
        (implRhs : ParseFunction.ForReceiverAndRValue[ReceiT, RhsVal] )
      : ParseFunction.ForReceiverAndRValue[ReceiT, (LhsVal, RhsVal)]
      = impl.zip[RhsVal] (implRhs )

  }

  given prsZipOps
  : AnyRef with {
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
      infix
      def zip
        [
          RhsVal ,
        ]
        (implRhs : ParseFunction.ForReceiverAndRValue[ReceiT, RhsVal] )
      : ParseFunction.ForReceiverAndRValue[ReceiT, (LhsVal, RhsVal)]
      = {
        Subject.fromAltBRetrialFunction((receiverL0: ReceiT) => {
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
      }

  }

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
        (implRhs : ParseFunction.ForReceiverAndRValue[ReceiT, RhsVal] )
        (using RVT : RhsVal <:< Tuple )
      : ParseFunction.ForReceiverAndRValue[ReceiT, (LhsVal *: (RhsVal & Tuple ) ) ]
      = {
        (impl andThenAlso implRhs )
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
          Subject.fromAltBRetrialFunction(fnc)
        } }
      }
    }

  }

  ;
}

trait PHTCO {
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
      (implRhs : ParseFunction.ForReceiverAndRValue[ReceiT, RhsVal] )
      (using RVT : RhsVal <:< Tuple )
    : ParseFunction.ForReceiverAndRValue[ReceiT, (LhsVal *: (RhsVal & Tuple ) ) ]
  }

  ;
}










