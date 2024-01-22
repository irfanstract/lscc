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

export lscc.spclTerminalGrammars.{FixedIdentifier }

object ForKwPre
{
  // TODO
  export ForTerminalLiteral1.apply
}

export lscc.spclTerminalGrammars.{Keyword}

@deprecated("alias of 'ForTerminalLiteral1'.")
transparent inline
def ForBhOrNmLiteral
: ForTerminalLiteral1.type
= ForTerminalLiteral1

object ForTerminalLiteral1
{
  ;

  //

  export ForImmediateSingleLineRawOcc.apply

  ;
}




;









