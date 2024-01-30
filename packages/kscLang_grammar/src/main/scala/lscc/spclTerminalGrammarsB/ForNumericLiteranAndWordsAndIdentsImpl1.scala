package lscc.spclTerminalGrammarsB




















// TODO
object ForNumericLiteral1 {
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  // protected
  def apply
    //
    (using ctx : SpclPxery )
    ( )
  : ctx.SpclSdfYieldingUnwrapped[ctx.givenFispoSupp.SpclMatchContent ]
  = {
    // TODO
    (
      ForBigDecimalLiteral1()
      orElse
      ForBigHexadecimalLiteral1()
    )
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
    (using ctx : SpclPxery )
    ( )
  : ctx.SpclSdfYieldingUnwrapped[ctx.givenFispoSupp.SpclMatchContent ]
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
    (using ctx : SpclPxery )
    ( )
  : ctx.SpclSdfYieldingUnwrapped[ctx.givenFispoSupp.SpclMatchContent ]
  = ({
    ForTerminalLiteral1("""0{1,5}x{1,5}((?:Neg)?(?:[0-9A-Za-z]+)(?:\.[0-9A-Za-z]+)?)""".r )
  })

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
    (using ctx : SpclPxery )
    ( )
  : ctx.SpclSdfYieldingUnwrapped[ctx.givenFispoSupp.SpclMatchContent ]
  = ForTerminalLiteral1("""(?![0-9])(?>[\w]|\\[pu]\{.*?\})+""".r )

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
    (using ctx : SpclPxery )
    ( )
  : ctx.SpclSdfYieldingUnwrapped[ctx.givenFispoSupp.SpclMatchContent ]
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
  : ctx.SpclSdfYieldingUnwrapped[ctx.givenFispoSupp.SpclMatchContent ]
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
      lscalg.parsing.ParseFunction.emptyTupleValuedInstance[ctx.givenFispoSupp.InputState ]
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
    (subject: IRegExp._Any )
    (using ctx : SpclPxery )
  : ctx.SpclSdfYieldingUnwrapped[ctx.givenFispoSupp.SpclMatchContent ]
  = ({
    import ctx.given

    lscc.spclGrammar.KeywordPrf.forContentPattern(subject)
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

object ForInlineTerminalLiteral1
{
  ;

  //

  export ForImmediateSingleLineRawOcc.apply

  ;
}




;









