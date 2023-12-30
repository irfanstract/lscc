package lscc.spclParsedConstructs1










import lscalg.bnfParsing.{*, given }











// object ForNumericLiteralAndWordsAndIdents
// {
//   ;

//   import BnfCompatibleFileReadPtr1._Any as T

//   ;
// }

// TODO
object ForNumericLiteral1 {
  ;

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

  import IRegExp.tagImplicits.{r}

  // TODO
  // protected
  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    ( )
  = ForBhOrNmLiteral("""(?!0x)[0-9]+(\.[0-9]+)?([eE][+\-][0-9]+)?""".r )

  ;
}

object ForBigHexadecimalLiteral1
{
  ;

  import IRegExp.tagImplicits.{r}

  // TODO
  // protected
  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    ( )
  = ForBhOrNmLiteral("""0x(?:[0-9A-Z]+|[0-9a-z]+)(\.[0-9A-Za-z]+)?""".r )

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

  import IRegExp.tagImplicits.{r}

  // TODO
  // protected
  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    ( )
  = ForBhOrNmLiteral("""(?![0-9])(?:[\w]|\\p\{.*?\})+""".r )

  ;
}

/**
 * `quoted (with)in (a pair of) backticks` 
 * 
 */
object ForImmediateEscapedIdent
{
  ;

  import IRegExp.tagImplicits.{r}

  // TODO
  // protected
  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    ( )
  = ForBhOrNmLiteral("""\`\w+\`""".r )

  ;
}

// TODO
object ForBhOrNmLiteral
{
  ;

  import BnfCompatibleFileReadPtr1 as BC

  import IRegExp.tagImplicits.{r}

  // TODO
  // protected
  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    (subject: IRegExp.ForRegexp[String] )
  = {
    ;

    lscalg.bnfParsing.spclCommonLookaheadCaps1.ForImmediateStrPatternOccurence
      (subject , lineCountLimit = 1 )
  }

  ;
}















