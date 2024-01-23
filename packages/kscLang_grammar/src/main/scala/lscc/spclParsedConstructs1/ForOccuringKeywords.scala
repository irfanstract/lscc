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




@deprecated("an alias of 'ForOccurringKeywordOrIdentifier1'.")
transparent inline
def ForOccurringKeywordOrRefP
= ForOccurringKeywordOrIdentifier1

/**
 * 
 * first, try parsing as kwd, then as ident
 * 
 */
object ForOccurringKeywordOrIdentifier1
{
  ;

  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  //
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ctx.givenFispoSupp.T, Keyword[String] | Identifier[String] ]
  = {
    import ctx.given

    import ctx.givenFispoSupp.T as PAny

    (
      ForOccurringKeyword()
      .mapMainValue(v => Keyword(v.matchedStr) )

      orElse

      (ForImmediateUnescapedWord() orElse ForImmediateEscapedIdent() )
      .mapMainValue(<:<.refl[ctx.givenFispoSupp.SpclMatchContent ] )
      .mapMainValue(v => FixedIdentifier(v.matchedStr) )

    )
  }

  ;
}










