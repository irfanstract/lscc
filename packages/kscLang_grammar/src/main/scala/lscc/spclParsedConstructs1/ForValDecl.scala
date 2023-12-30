package lscc.spclParsedConstructs1











import lscalg.bnfParsing.{*, given }











;

// /** 
//  * `immediateKeyword` ;
//  * 
//  * TODO
//  * 
//  */
// transparent inline
// def immediateKeyword
//   //
//   ()
// = {
//   ;

//   import scala.util.matching.Regex.quote
//   import privateImplicits.{*, given }

//   (
//     Nil
//     :+ "abstract"
//   )
//   .foldLeft[SpclAfterDigestTupleOption._Any ] (SpclAfterDigestTupleOption._Impl1.None )((o, newS) => {
//     o orElse {
//       ((wrd: String) => (
//         p.immediateMatchOf(wrd.quotingR )
//       ) )(newS)
//     }
//   } )
// }

// TODO
object ForMustAlwaysBeKeyword
{
  ;

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

// TODO
object ForTermLevelKeyword
{
  ;

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
    FTLK((
      ForMustAlwaysBeKeyword()
      orElse
      ForBhOrNmLiteral("""ref|refs""".r )
    ))
  }
}

// TODO
object ForTypeLevelKeyword
{
  ;

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
    FTLK((
      ForMustAlwaysBeKeyword()
      orElse
      ForBhOrNmLiteral("""fi|do|if|for|while|until|case|abs|abstract|absol|trait|sealed|cap|capt|fnl|final|class|not|[ijkldfarcbx](\d+)|object|type|singletype|as|did""".r )
    ))
  }
}

// TODO
object FTLK
{
  ;

  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    // (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    (impl: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ec.T, ec.SpclMatchContent] )
  = {
    ;
    SpclCont(impl)
  }

  /* auxiliary */
  protected[FTLK]
  case class SpclCont[+Impl ](impl : Impl )

}











