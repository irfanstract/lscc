package lscc.spclGrammar












/**
 * in many languages,
 * whether an unescaped "word" shall be considered "reserved word"
 * varies by where it happens, eg
 * ECMA-262 allows what's normally "keywords" like `class`, `static`, to be used as `keys of { [k]: v } literals`
 * 
 */
object KeywordingCtx
{
  ;

  type _Any
  = KeywordingCtx

  def fromFtlk
    //
    (c : FTLK.SpclCont )
  = {
    new KeywordingCtx {
      val sc : c.type = c
    }
  }

  /* commonly-needed refinemental aliases */

  type WithParsePtrTypeBounds[-STL <: STU, +STU ]
  /* don't make assumptions of it all */
  = WithGivenFispoSupp[(
    lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp.ForTInRange[STL, STU ]
  )]

  type WithGivenFispoSupp[+t <: lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any ]
  = KeywordingCtx {
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
   * run with altered `given` `KeywordingCtx`.
   * 
   */
  def withSp
    [R] (newM: KeywordingCtx) (run1: newM.type ?=> R )
  : R
  = run1(using newM)

  ;
}

trait KeywordingCtx private[KeywordingCtx] ()
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










