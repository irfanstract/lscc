package lscc.spclParsedConstructs1



















private
object ForOccurringKeyword
{
  ;

  /**
   * the items the `KeywordingCtx` `kwIngCtx` would consider "reserved".
   * 
   * implemented as `kwIngCtx.asParseSubject`.
   * 
   */
  def apply
    //
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    ()
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T, givenFispoSupp.SpclMatchContent ]
  = {
    ;

    import givenFispoSupp.T as PAny

    kwIngCtx.asParseSubject
  }

  ;
}

object ForOccurringKeywordPr
{
  ;

  /**
   * the items the `KeywordingCtx` `kwIngCtx` would consider "reserved".
   * 
   * implemented as `kwIngCtx.asParseSubject`.
   * 
   */
  // transparent inline /* forwarders need to be `tr inline` so that narrowing of the peer method gets properly reflected */
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  //
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ctx.givenFispoSupp.T, Keyword[String] ]
  = {
    ;

    import ctx.givenFispoSupp.T as PAny
    import ctx.given

    ForOccurringKeyword()
    .mapMainValue(v => Keyword(v.matchedStr) )
  }.nn

  ;
}




@deprecated
object ForOccurringKeywordOrRef
{
  ;

  /**
   * `ForOccurringKeywordOrRef` specific to `kwIngCtx`.
   * first, `ForOccurringKeyword`, and then, as fallback, `ForImmediateUnescapedWord`.
   * 
   */
  def apply
    //
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T, Keyword[String] | FixedIdentifier[String] ]
  = {
    ;

    import givenFispoSupp.T as PAny

    (
      ForOccurringKeyword()
      .mapMainValue(v => Keyword(v.matchedStr) )

      orElse

      (ForImmediateUnescapedWord() orElse ForImmediateEscapedIdent() )
      .mapMainValue(v => FixedIdentifier(v.matchedStr) )

    )
  }.nn

  ;
}

@deprecated
object ForOccurringKeywordOrRefP
{
  ;

  transparent inline /* forwarders need to be `tr inline` so that narrowing of the peer method gets properly reflected */
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  //
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ctx.givenFispoSupp.T, Keyword[String] | Identifier[String] ]
  = {
    import ctx.given

    ForOccurringKeywordOrRef()
    .nn
  }

  ;
}










