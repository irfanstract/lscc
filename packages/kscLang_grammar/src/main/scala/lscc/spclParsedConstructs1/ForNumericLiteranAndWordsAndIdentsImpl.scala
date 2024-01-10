package lscc.spclParsedConstructs1





















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
  = ForBhOrNmLiteral("""(?!0x)[0-9]+(\.[0-9]+)?([eE][+\-][0-9]+)?""".r )

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
  = ForBhOrNmLiteral("""(?![0-9])(?:[\w]|\\p\{.*?\})+""".r )

  ;
}

object ForUnderscoreWildcardPattern
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1

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
    ForBhOrNmLiteral(SUnderscore )
    .map({ case v => "__" } )
  )

  ;
}

/**
 * escaped identifier
 * 
 */
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
      ForBhOrNmLiteral("""\`""".r )
      +%:
      ForBhOrNmLiteral(""".+?(?=\`)""".r )
      +%:
      ForBhOrNmLiteral("""\`""".r )
      +%:
      lscalg.parsing.ParseFunction.emptyTupleValuedInstance[ec.T ]
    )
    .mapMainValue({ case ((_, v, _)) => v })
  })

  ;
}

case class Identifier [+Value] (val value: Value )

object ForKwPre
{
  // TODO
  export ForBhOrNmLiteral.apply
}

// TODO
case class Keyword[+Value] private[Keyword] (val value: Value )
object Keyword {
  ;
  def apply[Value] (value: Value )(using DummyImplicit )
  : Keyword[value.type]
  = new Keyword[value.type](value )
  ;
}

object ForBhOrNmLiteral
{
  ;

  //

  export ForImmediateSingleLineMatchOf.apply

  ;
}




;















