package lscc.spclParsedConstructs1










import lscalg.bnfParsing.{*, given }











// object ForNumericLiteralAndWordsAndIdents
// {
//   ;

//   import BnfCompatibleFileReadPtr1._Any as T

//   ;
// }

object ForBigDecimalLiteral
{
  ;

  import BnfCompatibleFileReadPtr1 as BC

  import IRegExp.tagImplicits.{r}

  // TODO
  // protected
  def apply
    //
    ( )
  = ForBhOrNmLiteral("""(?!0x)[0-9]+(\.[0-9]+)?([eE][+\-][0-9]+)?""".r )

  ;
}

object ForBigHexadecimalLiteral
{
  ;

  import BnfCompatibleFileReadPtr1 as BC

  import IRegExp.tagImplicits.{r}

  // TODO
  // protected
  def apply
    //
    ( )
  = ForBhOrNmLiteral("""0x(?:[0-9A-Z]+|[0-9a-z]+)(\.[0-9A-Za-z]+)?""".r )

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
    (subject: IRegExp.ForRegexp[String] )
  = lscalg.bnfParsing.spclCommonLookaheadCaps1.ForImmediateStrPatternOccurence(subject , lineCountLimit = 1 )

  ;
}

/** 
 * multiple of relevant features were bundled together there, and
 * having to repeat all these all over in multiple places
 * would invite programmer errors
 * 
 */
private
object fnlAuxImplicits
{
  ;

  import BnfCompatibleFileReadPtr1 as BC

  val main
  = {
    import BC.extraEdgrlImplicits.given
    object implicits {
      ;

      val e1 = {
        lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence.forReceiverAndMatchSmmryBaseTypeAndQueryType((
          (pt0: BC._Any) => (r: util.matching.Regex ) => {
            import BC.immediateMatchIgnoringLinebreakOf
            pt0.immediateMatchIgnoringLinebreakOf(r)
          }
        ))
      }
    }
    ({
      ;
      given implicits.e1.type = valueOf
      lscc.spclParsedConstructs.forNumericLiteranAndWordsAndIdents1[BC.SpclAfterDigestTupleOption.type , BC._Any ]
    })
  }
}















