package lscalg.parsing













// export lscalg.digestivity.Subject as SpclSubject
transparent inline
def Subject
: lscalg.digestivity.Subject.type
= lscalg.digestivity.Subject






object subjectOpsCommon {
  ;

  ;

  extension [
    //
    ReceiT,
    LhsREi <: Either[Subject.RExceptionUpperBound, (LhsVal, ReceiT) ],
    LhsVal,
    /* auxiliary type-param to work-around potential issues with type-inference */
    ReceiTInitial >: ReceiT ,
  ] (impl: Subject.ForReceiverAndRMonad[ReceiTInitial, LhsREi] ) {
    //

    // def unliftTr()
    // = {
    //   impl 
    // }

    def andThenAlso
      [RhsREi <: Either[Subject.RExceptionUpperBound, (RhsVal, ReceiT) ], RhsVal ]
      (implRhs : Subject.ForReceiverAndRMonad[ReceiT, RhsREi] )
    : Subject.ForReceiverAndRValue[ReceiT, ((LhsVal, RhsVal), ReceiT)]
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

    def +%:
      [RhsREi <: Either[Subject.RExceptionUpperBound, (RhsVal, ReceiT) ], RhsVal ]
      (implRhs : Subject.ForReceiverAndRMonad[ReceiT, RhsREi] )
      (using RVT : RhsVal <:< Tuple )
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











