package lscc.spclParsedConstructs1













object SpclGrammaticalPrfConstructor
{
  ;

  import lscc.spclParsedConstructs1.SpclGrammaticalPxery

  @deprecatedInheritance
  trait WhichTakesELvlInfo ()
  {
    //

    // TODO
    // transparent inline
    def apply
      //
      (using ctx: SpclGrammaticalPxery )
      //
      (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
      //
      ( )
    : ctx.SpclSdfYielding[Any ]

  }

  object WhichTakesELvlInfo
  {
    ;

    type _Any
    = WhichTakesELvlInfo

    type WithReturnValue[+R]
    = WhichTakesELvlInfo {
      //

      def apply
        //
        (using ctx: SpclGrammaticalPxery )
        //
        (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
        //
        ( )
      : ctx.SpclSdfYielding[R ]
    }

    // TODO
    type FromUnderlyingFnc[
      //
      +
      FncI
      <: (
        (ctx: SpclGrammaticalPxery  ) =>
        (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ]) =>
          (
            ctx.SpclSdfYielding[Any ]
          )
      )
      ,
    ]
    >: IWhichTakesELvlInfoImpl[?, Any, FncI ] @annotation.unchecked.uncheckedVariance
    <: IWhichTakesELvlInfoImpl[?, Any, FncI ]

    ;

    extension (receiver: _Any )
    {
      //

      // @deprecated
      transparent inline
      def withMode
        //
        (using ctx: SpclGrammaticalPxery )
        //
        (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
      : ctx.SpclSdfYielding[Any ]
      = {
        given aitl
        : m.type
        = m

        receiver.apply()
      }
    }

  }

  transparent inline
  def forExprsAtImpliedLvl
    //
    [
      // TODO
      //
      Ctx >: SpclGrammaticalPxery <: SpclGrammaticalPxery
      ,
      R
      ,
    ]
    (impl : (
      (ctx: Ctx  ) =>
      (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ]) =>
        (ctx.SpclSdfYielding[R ] )
    ) )
  : (IForExprsAtImpliedLvl & WhichTakesELvlInfo.WithReturnValue[R ])
  = {
    ;

    val iWhichTakesELvlInfoImpl
    = new IWhichTakesELvlInfoImpl(impl = impl )

    iWhichTakesELvlInfoImpl
    .nn
  }

  type IForExprsAtImpliedLvl
  = WhichTakesELvlInfo.FromUnderlyingFnc[(
    //

    (ctx: SpclGrammaticalPxery  ) =>
    (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ]) =>
      (ctx.SpclSdfYielding[Any ] )
  )]

  protected
  class IWhichTakesELvlInfoImpl
    //
    [
      // TODO
      //
      Ctx >: SpclGrammaticalPxery <: SpclGrammaticalPxery
      ,
      +
      R
      ,
      +
      FullCode
      <: (
        (ctx: Ctx  ) =>
        (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ]) =>
          (
            ctx.SpclSdfYielding[R ]
          )
      )
      ,
    ]
    (val impl : FullCode )
  extends
  WhichTakesELvlInfo
  {
    ;

    transparent inline
    def apply
      //
      (using ctx: SpclGrammaticalPxery )
      //
      (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
      //
      ( )
    : ctx.SpclSdfYielding[R ]
    = {
      val r
      = {
        impl(ctx)(m )
      }

      import ctx.grmMetadataWrapMode

      // r.withSrcInfo()
      r
    }

    ;
  }

  ;

  type IFromUnderlyingFnc[+FncI ]
  >: FncI @annotation.unchecked.uncheckedVariance
  <: FncI

  /**
   * 
   * relies on "expected types". TBD
   * 
   */
  def plainIFromFnc
    [T] (c: T)
  : IFromUnderlyingFnc[T]
  = c

  ;
}







