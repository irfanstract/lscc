package lscc.spclParsedConstructs1























// TODO
object ForTermLevelKeyword
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
    
    ({
      ;

      import IRegExp.tagImplicits.r

      // TODO
      FTLK((
        ForMustAlwaysBeKeyword()
        orElse
        ForBhOrNmLiteral("""ref|refs""".r )
      ))
    })
    .match { case r => {
      KeywordingCtx.fromFtlk(r)
    } }
  }
}

// TODO
object ForTypeLevelKeyword
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
    
    ({
      ;

      import IRegExp.tagImplicits.r

      // TODO
      FTLK((
        ForMustAlwaysBeKeyword()
        orElse
        ForBhOrNmLiteral("""fi|do|if|for|while|until|case|abs|abstract|absol|trait|sealed|cap|capt|fnl|final|class|not|[ijkldfarcbx](\d+)|object|type|singletype|as|did""".r )
      ))
    })
    .match { case r => {
      KeywordingCtx.fromFtlk(r)
    } }
  }
}












