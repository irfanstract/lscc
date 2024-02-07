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
    (using kwIngCtx : lscc.spclGrammar.IReservedWords.WithGivenFispoSupp[givenFispoSupp.type ] )
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
    (using kwIngCtx : lscc.spclGrammar.IReservedWords.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
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


@deprecated("alias of `ForOccurringNonbreakingGkw`.")
transparent inline
def ForOccurringGeneralisedKeyword
: ForOccurringNonbreakingGkw.type
= ForOccurringNonbreakingGkw
// 

object ForOccurringNonbreakingGkw
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
    ForOccurringNonbreakingGkw.forPattern("""(?:\(|\)|\,|\;)""".r)
    .mapMainValue(va => {
      glscc.spclTerminalGrammars.Keyword.apply(va )
    } )
  }.nn

  ;
}







@deprecated("an alias of 'ForOccurringKeywordOrIdentifier1'.")
transparent inline
def ForOccurringKeywordOrRefP
: ForOccurringKeywordOrIdentifier1.type
= ForOccurringKeywordOrIdentifier1

export lscc.spclGrammar.forBasicCompoundExprs1.OccurringKeywordOrIdentifierPrf1 as ForOccurringKeywordOrIdentifier1










