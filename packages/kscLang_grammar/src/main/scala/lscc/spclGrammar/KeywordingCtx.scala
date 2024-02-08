package lscc.spclGrammar












;

@deprecated("an alias of `IReservedWords`.")
type KeywordingCtx
= IReservedWords

@deprecated("an alias of `IReservedWords`.")
transparent inline
def KeywordingCtx
: IReservedWords.type
= IReservedWords





/**
 * in many languages,
 * whether an unescaped "word" shall be considered "reserved word"
 * varies by where it happens, eg
 * ECMA-262 allows what's normally "keywords" like `class`, `static`, to be used as `keys of { [k]: v } literals`
 * 
 */
object IReservedWords
{
  ;

  type _Any
  = IReservedWords

  // TODO
  def factoryUsingCtxtualFlatGramPxery
    //
    (impl : (
      // (ctx0: lscc.spclTerminalGrammarsB.SpclPxery) ?=>
      //   (ctx0.SpclSdfYieldingUnwrapped[ctx0.SpclExtractedRawStr1] )

      (ctx0 : lscc.spclGrammar.Ikpm ) ?=>
        ctx0.Applied
    ) )
  : (
    () => (ctx : lscc.spclTerminalGrammarsB.SpclPxery) ?=>
      (KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type])
  )
  = {
    ;
    () => ctx ?=> {
      lscc.spclGrammar.IReservedWords.fromIkpf
        (ctx2 ?=> impl )
      .nn
    }
  }

  // transparent inline
  def fromIkpf
    //
    (impl : (
      // (ctx0: lscc.spclTerminalGrammarsB.SpclPxery) ?=>
      //   (ctx0.SpclSdfYieldingUnwrapped[ctx0.SpclExtractedRawStr1] )

      (ctx0 : lscc.spclGrammar.Ikpm ) ?=>
        ctx0.Applied
    ) )
    (using ctx2 : lscc.spclTerminalGrammarsB.SpclPxery )
  : IReservedWords.WithGivenFispoSupp[ctx2.givenFispoSupp.type ]
  = {
    import ctx2.given

    { impl }
    .match { case prf => {
      fromFtlk((
        FTLK(prf)
      ))
    } }
    .nn
  }

  def fromFtlk
    //
    (c : FTLK.SpclCont )
  : IReservedWords { val sc : c.type }
  = {
    new IReservedWords
    {
      val sc : c.type = c

      // TODO
      override def toString(): String = s"IReservedWords(c) "
    }
  }

  /* commonly-needed refinemental aliases */

  type WithParsePtrTypeBounds[-STL <: STU, +STU ]
  /* don't make assumptions of it all */
  = WithGivenFispoSupp[(
    lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp.ForTInRange[STL, STU ]
  )]

  type WithGivenFispoSupp[+t <: lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any ]
  = IReservedWords {
    val sc
    : FTLK.SpclContWithEcType[t]
  }

  extension (d: _Any )
  {
    transparent inline
    def asParseSubject
    = d.sc.asParseSubject1
  }

  ;

  /* test */

  /** 
   * run with altered `given` `IReservedWords`.
   * 
   */
  def withSp
    [R] (newM: IReservedWords) (run1: newM.type ?=> R )
  : R
  = run1(using newM)

  ;
}

trait IReservedWords private[IReservedWords] ()
{
  implicit
  val sc : FTLK.SpclCont

  type ParsePtr
  >: sc.ec.InputState
  <: sc.ec.InputState

  ;
}

// TODO
object FTLK
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    // (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.InputState, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    (impl: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ec.InputState, ec.SpclMatchContent] )
  = {
    ;
    SpclContImpl((ec, impl ) )
  }

  /* auxiliary */
  protected[FTLK]
  case class SpclContImpl
    [+Impl <: (
      (lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any, lscalg.digestivity.ParseFunction._Any) {
        val _2 : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[_1.InputState, _1.SpclMatchContent]
      }
    ) ]
    (impl : Impl )
  {
    export impl._1 as givenFispoSupp
    export impl._1 as givenFispoSupp1
    export impl._1 as ec
    export impl._2 as asParseSubject1
  }

  /* auxiliary */

  type SpclCont
  = SpclContImpl[?]

  type SpclContWithEcType
    [+Ec <: lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any ]
  = (
    //
    SpclCont
    &
    (SpclCont {
      val impl : Tuple2[Ec, ?]
    })
  )

  type SpclContWithParsePtrTypeBounds[-STL <: STU, +STU ]
  = SpclContWithEcType[(
    lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp.ForTInRange[STL, STU]
  )]

}










