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

  ([Pt, T] => (ea : ParseFunction.ForReceiverAndRValue[Pt, T ] ) => {
    Nil :+ ea :+ ea
  } )

  extension [
    //
    ReceiT,
    LhsREi
    <: Either[Subject.RExceptionUpperBound, (LhsVal, ReceiT) ]
    ,
    LhsVal,
    /* auxiliary type-param to work-around obvious potential limitations with type-inference */
    ReceiTInitial >: ReceiT ,
  ] (impl: ParseFunction.ForReceiverAndRValue[ReceiT, LhsVal] ) {
    //

    /** 
     * concatenation of expected inputs,
     * effectively composition of *inp-pos*,
     * returned as `(parsed1, parsed2)`
     * 
     * concatenation of two Subject(s)
     * 
     */
    @deprecated
    transparent inline
    def andThenAlso
      [
        // RhsREi <: Either[Subject.RExceptionUpperBound, (RhsVal, ReceiT) ],
        RhsVal ,
      ]
      (implRhs : ParseFunction.ForReceiverAndRValue[ReceiT, RhsVal] )
    : ParseFunction.ForReceiverAndRValue[ReceiT, (LhsVal, RhsVal)]
    = impl.zip[RhsVal] (implRhs )

    /** 
     * concatenation of expected inputs,
     * effectively composition of *inp-pos*,
     * returned as `(parsed1, parsed2)`
     * 
     * concatenation of two Subject(s)
     * 
     */
    def zip
      [
        // RhsREi <: Either[Subject.RExceptionUpperBound, (RhsVal, ReceiT) ],
        RhsVal ,
      ]
      (implRhs : ParseFunction.ForReceiverAndRValue[ReceiT, RhsVal] )
    : ParseFunction.ForReceiverAndRValue[ReceiT, (LhsVal, RhsVal)]
    = {
      Subject.fromLiftedPartialFunction((receiverL: ReceiT) => {
        ;

        /** 
         * must be aware that
         * the right receiver for the 2nd fnc call
         * is supposed to be what returned from the preceding fnc call, not the initial receiver
         * 
         */
        impl.applyEi(receiverL).toOption
        .flatMap({ case (v1, receiverL) => {
          ;
          implRhs.applyEi(receiverL).toOption
          .map({ case (v2, finalPos) => {
            ((v1, v2) , finalPos )
          } })
        } })
      })
    }

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
        // RhsREi <: Either[Subject.RExceptionUpperBound, (RhsVal, ReceiT) ],
        RhsVal ,
      ]
      (implRhs : ParseFunction.ForReceiverAndRValue[ReceiT, RhsVal] )
      (using RVT : RhsVal <:< Tuple )
    : ParseFunction.ForReceiverAndRValue[ReceiT, (LhsVal *: (RhsVal & Tuple ) ) ]
    = {
      (impl andThenAlso implRhs )
      .applyO
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
        Subject.fromLiftedPartialFunction(fnc)
      } }
    }
  }

  ;
}











