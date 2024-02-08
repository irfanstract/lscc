package lscc.spclGrammar.forBasicCompoundExprs1











/**
 * 
 * first, try parsing as kwd, then as ident
 * 
 */
object OccurringKeywordOrIdentifierPrf1
{
  ;

  import glscc.spclTerminalGrammars.{Keyword, FixedIdentifier}

  import lscc.spclGrammar.IReservedWords

  import lscc.spclParsedConstructs1.SpclGrammaticalPxery

  import lscc.spclParsedConstructs1.{ForOccurringKeywordPr }

  import lscc.spclParsedConstructs1.{ForImmediateUnescapedWord, ForImmediateEscapedIdent }

  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : IReservedWords.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  //
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ctx.givenFispoSupp.InputState, Keyword[String] | FixedIdentifier[String] ]
  = {
    import ctx.given

    import ctx.givenFispoSupp.InputState as PAny

    (
      ForOccurringKeywordPr()
      .mapMainValue(v => v )
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







