package lscc.spclParsedConstructs1






















;

// TODO
object ForMustAlwaysBeKeyword
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  // protected
  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    ( )
  = {
    ;
    import IRegExp.tagImplicits.r

    // TODO
    ((
      ForBhOrNmLiteral("""fi|do|if|for|while|until|case|trait|class|object|not|(?:do|does|done|did)|(?:is|are|was|were)|none|some|this|that|[ijkldfarcbx](\d+)""".r )
    ))
  }
}




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

  ;
}

trait KeywordingCtx private[KeywordingCtx] ()
{ implicit val sc : FTLK.SpclCont }

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
    // (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    (impl: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ec.T, ec.SpclMatchContent] )
  = {
    ;
    SpclContImpl((ec, impl ) )
  }

  /* auxiliary */
  protected[FTLK]
  case class SpclContImpl
    [+Impl <: (
      (lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any, lscalg.digestivity.ParseFunction._Any) {
        val _2 : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[_1.T, _1.SpclMatchContent]
      }
    ) ]
    (impl : Impl )
  { export impl._1 as ec ; export impl._2 as im }

  /* auxiliary */
  type SpclCont
  = SpclContImpl[?]

}











