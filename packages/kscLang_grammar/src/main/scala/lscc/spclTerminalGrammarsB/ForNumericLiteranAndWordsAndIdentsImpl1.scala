package lscc.spclTerminalGrammarsB




















export lscc.spclGrammar.forBnsLiterals.INumericLiteralPrf.{
  ForNumericLiteral1 ,
  ForBigDecimalLiteral1 ,
  ForBigHexadecimalLiteral1 ,
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
    (using ctx : SpclPxery )
    ( )
  : ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1 ]
  = ForInlineTerminalLiteral1("""(?![0-9])(?>[\w]|\\[pu]\{.*?\})+""".r )

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
    (using ctx : SpclPxery )
    ( )
  : ctx.SpclSdfYieldingUnwrapped[String ]
  = (
    ForInlineTerminalLiteral1(SUnderscore )
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
    (using ctx : SpclPxery )
    ( )
  : ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1 ]
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
    (using ctx : SpclPxery )
    ( )
  : ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1 ]
  = ({
    ;
    import lscalg.parsing.subjectConcatOps1.given

    (
      ForImmediateSingleLineRawOcc("""\`""".r )
      +%:
      ForImmediateSingleLineRawOcc(""".+?(?=\`)""".r )
      +%:
      ForImmediateSingleLineRawOcc("""\`""".r )
      +%:
      ctx.prsfNil
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
    (using ctx : lscc.spclGrammar.Ikpm )
    (subject: IRegExp._Any )
  : ctx.Applied
  = ({
    import ctx.given

    ctx.fromRegExp(subject )
  }).nn

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

/**
 * 
 * flat token supposed to represent a literal-like construct
 * 
 */
object ForInlineTerminalLiteral1
{
  ;

  //

  export ForImmediateSingleLineRawOcc.apply

  ;
}




;









