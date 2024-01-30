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
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState, givenFispoSupp.SpclMatchContent ]
  = {
    ;

    import givenFispoSupp.InputState as PAny

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
  : ctx.SpclSdfYieldingUnwrapped[ Keyword[String] ]
  = {
    ;

    import ctx.givenFispoSupp.InputState as PAny
    import ctx.given

    ForOccurringKeyword()
    .mapMainValue(v => Keyword(v.matchedStr) )
    .withLogging1(mainMsg = s"ForOccurringKeywordOrRefP()")
  }.nn

  ;
}


object ForOccurringGeneralisedKeyword
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  import IRegExp.tagImplicits.{r}

  transparent inline /* forwarders need to be `tr inline` so that narrowing of the peer method gets properly reflected */
  def forLiteral
    //
    (using ctx: SpclGrammaticalPxery )
    (subject: ([e] =>> e ) [String] )
  //
  // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ctx.givenFispoSupp.InputState, Keyword[String] ]
  : ctx.SpclSdfYieldingUnwrapped[ ([e] =>> e )[String] ]
  = forPattern((subject match { case s => util.matching.Regex.quote(s) }).r )

  // transparent inline /* forwarders need to be `tr inline` so that narrowing of the peer method gets properly reflected */
  def forPattern
    //
    (using ctx: SpclGrammaticalPxery )
    (subject: IRegExp._Any )
  //
  // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ctx.givenFispoSupp.InputState, Keyword[String] ]
  : ctx.SpclSdfYieldingUnwrapped[ ([e] =>> e )[String] ]
  = {
    ({
      ;

      import ctx.givenFispoSupp.InputState as PAny
      import ctx.given

      ForTerminalLiteral1(subject)
    })
    .mapMainValue(va => {
      (va.matchedStr )
    } )
  }.nn

  ;
}

object ForOccurringDelimiterPr
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  import IRegExp.tagImplicits.{r}

  // transparent inline /* forwarders need to be `tr inline` so that narrowing of the peer method gets properly reflected */
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (  )
  //
  // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ctx.givenFispoSupp.InputState, Keyword[String] ]
  : ctx.SpclSdfYieldingUnwrapped[ Keyword[String] ]
  = {
    ForOccurringGeneralisedKeyword.forPattern("""(?:\(|\)|\,|\;)""".r)
    .mapMainValue(va => {
      glscc.spclTerminalGrammars.Keyword.apply(va )
    } )
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
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ctx.givenFispoSupp.InputState, Keyword[String] | Identifier[String] ]
  = {
    import ctx.given

    import ctx.givenFispoSupp.InputState as PAny

    (
      ForOccurringKeyword()
      .mapMainValue(v => Keyword(v.matchedStr) )
      .withLogging1(mainMsg = "ForOccurringKeywordOrIdentifier1.Kwd")

      orElse

      (ForImmediateUnescapedWord() orElse ForImmediateEscapedIdent() )
      .mapMainValue(<:<.refl[ctx.givenFispoSupp.SpclMatchContent ] )
      .mapMainValue(v => FixedIdentifier(v.matchedStr) )
      .withLogging1(mainMsg = "ForOccurringKeywordOrIdentifier1.Ref")

    )
    .withLogging1(mainMsg = "ForOccurringKeywordOrIdentifier1")
  }

  ;
}










