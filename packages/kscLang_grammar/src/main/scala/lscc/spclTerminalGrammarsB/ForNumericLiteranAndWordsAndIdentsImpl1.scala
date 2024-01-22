package lscc.spclTerminalGrammarsB




















// object ForNumericLiteralAndWordsAndIdents
// {
//   ;
//   import BnfCompatibleFileReadPtr1._Any as T
//   ;
// }

// TODO
object ForNumericLiteral1 {
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
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ec.T, ec.SpclMatchContent ]
  = {
    // TODO
    ForBigDecimalLiteral1() orElse ForBigHexadecimalLiteral1()
  }
}

object ForBigDecimalLiteral1
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  import IRegExp.tagImplicits.{r}

  // TODO
  // protected
  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    ( )
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ec.T, ec.SpclMatchContent ]
  = ForTerminalLiteral1("""(?!0x)[0-9]+(\.[0-9]+)?([eE][+\-][0-9]+)?""".r )

  ;
}

object ForBigHexadecimalLiteral1
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  import IRegExp.tagImplicits.{r}

  // TODO
  // protected
  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    ( )
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ec.T, ec.SpclMatchContent ]
  = ForTerminalLiteral1("""0x(?:[0-9A-Z]+|[0-9a-z]+)(\.[0-9A-Za-z]+)?""".r )

  ;
}

/** 
 * `immediateUnescapedWord` ;
 * *excludes numeric literals, escaped identifiers,*
 * 
 */
object ForImmediateUnescapedWord
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  import IRegExp.tagImplicits.{r}

  // TODO
  // protected
  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    ( )
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ec.T, ec.SpclMatchContent ]
  = ForTerminalLiteral1("""(?![0-9])(?:[\w]|\\p\{.*?\})+""".r )

  ;
}

object ForUnderscoreWildcardPattern
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  // import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1

  import IRegExp.tagImplicits.{r}

  val SUnderscore
  = """_+""".r

  // TODO
  // protected
  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    ( )
  = (
    ForTerminalLiteral1(SUnderscore )
    .mapMainValue({ case v => "__" } )
  )

  ;
}

/**
 * escaped identifier
 * 
 */
@deprecated
object ForImmediateEscapedIdent {
  //

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    ( )
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ec.T, ec.SpclMatchContent ]
  = (
    ForImmediateBacktickedIdent()
  )

}

/**
 * `quoted (with)in (a pair of) backticks` 
 * 
 */
object ForImmediateBacktickedIdent
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  import IRegExp.tagImplicits.{r}

  // TODO
  // protected
  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    ( )
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ec.T, ec.SpclMatchContent ]
  = ({
    ;
    import lscalg.parsing.subjectConcatOps1.given

    (
      ForTerminalLiteral1("""\`""".r )
      +%:
      ForTerminalLiteral1(""".+?(?=\`)""".r )
      +%:
      ForTerminalLiteral1("""\`""".r )
      +%:
      lscalg.parsing.ParseFunction.emptyTupleValuedInstance[ec.T ]
    )
    .mapMainValue({ case ((_, v, _)) => (
      v
    ) })
  }).nn

  ;
}

@deprecated("alias of 'FixedIdentifier'")
type Identifier[+A] = FixedIdentifier[A]
@deprecated("alias of 'FixedIdentifier'")
transparent inline
def Identifier = FixedIdentifier

export glscc.spclTerminalGrammars.{FixedIdentifier }

/**
 * 
 * Keyword
 * 
 */
object ForKwPre
{
  // TODO

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1
  import lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFiSpoSupp

  /**
   * 
   * `ForKwPre.apply`
   *  
   * compensate for very speculable absence of the meta-char `\b`
   * 
   */
  transparent inline
  def apply
    //
    (using ec : GivenFiSpoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    (subject: IRegExp.ForRegexp[String] )
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ec.T, ec.SpclMatchContent ]
  = ({
    lscc.spclGrammar.KeywordPrf.forContentPattern(subject)
  })

}

export glscc.spclTerminalGrammars.{Keyword}

@deprecated("alias of 'ForTerminalLiteral1'. \nin turn, \nan alias of 'ForInlineTerminalLiteral1'.")
transparent inline
def ForBhOrNmLiteral
: ForTerminalLiteral1.type
= ForTerminalLiteral1

@deprecated("alias of 'ForInlineTerminalLiteral1'.")
transparent inline
def ForTerminalLiteral1
= ForInlineTerminalLiteral1

object ForInlineTerminalLiteral1
{
  ;

  //

  export glscc.spclTerminalGrammars.ForImmediateSingleLineRawOcc.apply

  ;
}




;









