package lscalg.digestivity

















trait SdfWithFilter[ ForReceiverAndRValue[ReceiT, +Value ] ]
{
  ;

  ;

  extension [ReceiT0, LRV] (lhsI : ForReceiverAndRValue[ReceiT0, LRV ] )
  {
    //

    def map
      //
      [NewRV]
      (proj: LRV => NewRV )
    : ForReceiverAndRValue[ReceiT0, NewRV ]

    def collect
      //
      [NewRV]
      (proj: PartialFunction[LRV, NewRV] )
    : ForReceiverAndRValue[ReceiT0, NewRV ]

    def flatMap
      //
      [NewRV]
      (proj: LRV => collection.IterableOnce[NewRV] )
    : ForReceiverAndRValue[ReceiT0, NewRV ]

    def filter
      //
      (pred: LRV => Boolean )
    : ForReceiverAndRValue[ReceiT0, LRV ]

    /** an alias of `filter`, to avoid desugaring-related issues */
    transparent inline
    def withFilter
      //
      (pred: LRV => Boolean )
    : ForReceiverAndRValue[ReceiT0, LRV ]
    = lhsI.filter(pred )

  }

  ;
}

trait SdfWithFilterOnMain[ ForReceiverAndRValue[ReceiT, +Value ] ]
{
  ;

  ;

  extension [ReceiT0, LRV] (lhsI : ForReceiverAndRValue[ReceiT0, LRV ] )
  {
    //

    def mapMainValue
      //
      [NewRV]
      (proj: LRV => NewRV )
    : ForReceiverAndRValue[ReceiT0, NewRV]

    def flatMapMainValue
      //
      [NewRV]
      (proj: LRV => collection.IterableOnce[NewRV] )
    : ForReceiverAndRValue[ReceiT0, NewRV]
  }

  ;
}

trait SdfFallBackOps[ ForReceiverAndRValue[ReceiT, +Value ] ]
{
  ;

  extension [ReceiT, LhsRV] (lhsI : ForReceiverAndRValue[ReceiT, LhsRV ] )
  {

    /** 
     * ordered alternation -- the LHS will take precedence over the RHS .
     * in case of [[lscalg.parsing.BRetrialIterator polymorphic matches ]],
     * will be deferred to after the end of the (ordered) set.
     * 
     */
    infix
    def orElse
      [UniRV >: LhsRV ]
      (rhsI : ForReceiverAndRValue[ReceiT, UniRV ] )
    : ForReceiverAndRValue[ReceiT, UniRV ]
  }

  ;
}

trait SdfZipKAndTupledOps[ ForReceiverAndRValue[ReceiT, +Value ] ]
{
  ;

  extension [
    //
    ReceiT,
    LhsVal,
  ] (impl: ForReceiverAndRValue[ReceiT, LhsVal] )
  {

    /** 
     * concatenation of expected inputs,
     * effectively composition of *inp-pos*,
     * returned as `(parsed1, parsed2)`
     * 
     */
    infix
    def zip
      [
        RhsVal ,
      ]
      (implRhs : ForReceiverAndRValue[ReceiT, RhsVal] )
    : ForReceiverAndRValue[ReceiT, (LhsVal, RhsVal)]
  }

  ;
}

/**
 * 
 * `andThen` and
 * `andThenAlso` and
 * 
 */
given sdfSuccessionalOpsImpl
  //
  [ForReceiverAndRValue[ReceiT, +Value] ]
  (using SdfZipKAndTupledOps[ForReceiverAndRValue ])
  (using SdfWithFilter[ForReceiverAndRValue ])
: AnyRef with {
  ;

  extension [
    //
    ReceiT,
    LhsVal,
  ] (impl: ForReceiverAndRValue[ReceiT, LhsVal] )
  {
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
    // transparent inline
    def andThenAlso
      [
        RhsVal ,
      ]
      (implRhs : ForReceiverAndRValue[ReceiT, RhsVal] )
      (using szcv : lscalg.parsingCatt.SPostZipConv { type Value2Base >: RhsVal } )
    // : ParseFunction.ForReceiverAndRValue[ReceiT, (LhsVal, RhsVal)]
    : ForReceiverAndRValue[ReceiT, szcv.Conv[LhsVal, RhsVal ] ]
    = ({
      ;

      impl.zip[RhsVal] (implRhs )
      .map((v1, v2) => {
        szcv.conv(v1, v2)
      })
      .nn
    })

    /** 
     * concatenation of expected inputs,
     * effectively composition of *inp-pos*,
     * returned as `(parsed1, parsed2)`
     * 
     * concatenation of two Subject(s)
     * 
     */
    // TODO
    // protected
    infix
    transparent inline
    def andThen
      [
        RhsVal ,
      ]
      (implRhs : ForReceiverAndRValue[ReceiT, RhsVal] )
      (using szcv : lscalg.parsingCatt.SPostZipConv { type Value2Base >: RhsVal } )
    : ForReceiverAndRValue[ReceiT, szcv.Conv[LhsVal, RhsVal ] ]
    = andThenAlso(implRhs )

  }

}









