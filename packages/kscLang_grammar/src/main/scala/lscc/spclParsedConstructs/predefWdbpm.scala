package lscc.spclParsedConstructs













abstract
class WithDepsBasedFactoryMethods private[WithDepsBasedFactoryMethods] ()
{
  ;

  type _Main1Deps
  <: AnyKind

  /**
   * its 'kinds' cannot be identified at this point, so the only choice left here is to leave it opaque here .
   * in the end we need it to `extends` `Any`.
   */
  type _Main1DepsAny
  <: Any

  ;

  type _Main1Any
  = Any & _Main1[_Main1DepsAny ]

  type _Main1
    [
      +deps
      <: _Main1DepsAny
      ,
    ]
  //

  ;

  type _MainPublic
  /**
   * its 'kinds' cannot be identified at this point, so the only choice left here is to leave it opaque here .
   * in the end we need it to `extends` `Any`.
   */
  <: AnyKind

  ;
}

object WithDepsBasedFactoryMethods
{
  ;

  type _Any
  = WithDepsBasedFactoryMethods

  trait for2TsMainPublicPts
  { this : _Any =>
    ;

    ;

    ;
  }

  trait for2TsDepsNarrowings
    //
    [
      //
      +FinalT
        [+deps <: DepsT[SubGvnT1Base, SubGvnT2Base] ]
      ,
      +DepsT
        [
          +t1 <: SubGvnT1Base,
          +t2 <: SubGvnT2Base,
        ]
      ,
      SubGvnT1Base ,
      SubGvnT2Base,
    ]
  {
    this : _Any =>
    //
    ;

    // TODO probably needs to indirect them to use the local opqs instead

    type _Main1Deps[+t1 <: SubGvnT1Base, +t2 <: SubGvnT2Base]
    >: DepsT[t1, t2] @annotation.unchecked.uncheckedVariance
    <: DepsT[t1, t2] @annotation.unchecked.uncheckedVariance

    type _Main1DepsAny
    = _Main1Deps[SubGvnT1Base, SubGvnT2Base] @annotation.unchecked.uncheckedVariance

    ;

    type _Main1
      [+deps <: _Main1DepsAny ]
    = FinalT[deps] @annotation.unchecked.uncheckedVariance

    ;

    type _MainPublic
      [
        //
        /** 
         * the actual permutation is left to implementing subclasses,
         * - the only choice left here is to set it to `Nothing`
         * - the only choice left here is to leave them 'invariant'
         */
        xt1 <: Nothing ,
        xt2 <: Nothing ,
      ]
    <: Any & _Main1[_Main1DepsAny ]

    ;
  }

  class for2TsImplWithReversedTListImpl
    //
    [
      //
      +FinalT
        [+deps <: DepsT[SubGvnT1Base, SubGvnT2Base] ]
      ,
      +DepsT
        [
          +t1 <: SubGvnT1Base,
          +t2 <: SubGvnT2Base,
        ]
      ,
      SubGvnT2Base,
      SubGvnT1Base ,
    ] private[WithDepsBasedFactoryMethods]
    (instantiateWithDeps: [t1 <: SubGvnT1Base, t2 <: SubGvnT2Base] => (deps: DepsT[t1, t2]) ?=> FinalT[deps.type] )
  extends
  _Any
  with for2TsDepsNarrowings[FinalT, DepsT, SubGvnT1Base, SubGvnT2Base]
  {
    ;

    ;

    transparent inline
    implicit
    def _MainPublic
      //
      [
        EOptConstructor
        <: SubGvnT2Base
        ,
        PAny
        <: SubGvnT1Base
        ,
      ]
      //
      (using c1 : _Main1Deps[PAny, EOptConstructor] )
      //
    : (
      _Main1[c1.type ]
    )
    = {
      ;
      instantiateWithDeps[PAny, EOptConstructor](using c1)
      .match { case r => r }
    }

    // TODO
    type _MainPublic
      [
        +
        EOptConstructor
        <: SubGvnT2Base
        ,
        PAny
        <: SubGvnT1Base
        ,
      ]
    >: _Main1[_Main1Deps[PAny, EOptConstructor] ]
    <: _Main1[_Main1Deps[PAny, EOptConstructor] ]

    ;

  }

  object For2TsImplWithReversedTList {
    class Builder
      [
        //
        FinalT
          [+deps <: DepsT[SubGvnT1Base, SubGvnT2Base] ]
        ,
        DepsT
          [
            +t1 <: SubGvnT1Base,
            +t2 <: SubGvnT2Base,
          ]
        ,
        SubGvnT2Base,
        SubGvnT1Base ,
      ] private[WithDepsBasedFactoryMethods]
    {
      ;

      def withBaseTs
        [
          //
          SubGvnT2Base,
          SubGvnT1Base ,
        ]
      = new Builder[[_] =>> Nothing , [_, _] =>> Nothing, SubGvnT2Base, SubGvnT1Base]

      def withDepsT
        [
          //
          DepsT
            [
              +t1 <: SubGvnT1Base,
              +t2 <: SubGvnT2Base,
            ]
          ,
        ]
      = new Builder[[_] =>> Nothing , DepsT, SubGvnT2Base, SubGvnT1Base]

      def withFinalT
        [
          //
          FinalT
            [+deps <: DepsT[SubGvnT1Base, SubGvnT2Base] ]
          ,
        ]
      = new Builder[FinalT , DepsT, SubGvnT2Base, SubGvnT1Base]

      def completeWith
        //
        (instantiateWithDeps: [t1 <: SubGvnT1Base, t2 <: SubGvnT2Base] => (deps: DepsT[t1, t2]) ?=> FinalT[deps.type] )
      = {
        ;
        new for2TsImplWithReversedTListImpl
          [FinalT, DepsT, SubGvnT2Base, SubGvnT1Base]
          (instantiateWithDeps = instantiateWithDeps )
      }
    }

    def builder()
    = new Builder[[_] =>> Unit, [_, _] =>> Unit, Unit, Unit ]
  }

  ;
}
















