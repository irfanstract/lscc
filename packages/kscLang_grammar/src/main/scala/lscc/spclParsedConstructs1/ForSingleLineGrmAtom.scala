package lscc.spclParsedConstructs1




















@deprecated("alias of 'ForImmediateSingleLineRegexSelectedRawOccurence'.")
transparent inline
def ForImmediateSingleLineMatchOf
: ForImmediateSingleLineRegexSelectedRawOccurence.type
= ForImmediateSingleLineRegexSelectedRawOccurence



// TODO
/**
 * 
 * immediate, single-line occurence of what the RegExp would select
 * 
 */
object ForImmediateSingleLineRegexSelectedRawOccurence
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  import BnfCompatibleFileReadPtr1 as BC

  import IRegExp.tagImplicits.{r}

  // TODO
  // protected
  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    (subject: IRegExp.ForRegexp[String] )
  : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ec.T, ec.SpclMatchContent ]
  = {
    ;

    lscalg.bnfParsing.spclCommonLookaheadCaps1.ForImmediateStrPatternOccurence
      (subject , lineCountLimit = 1 )
  }

  ;
}












