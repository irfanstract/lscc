package lscc.spclGrammar















/** 
 * 
 * `ParseFunction` to parse the desired keywds
 * 
 */
object KeywordPrf
{
  // TODO

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp

  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1
  import lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFiSpoSupp

  /**
   * 
   * alias of `forWordlikeContentByPattern`.
   * 
   */
  @deprecated("alias of 'forWordlikeContentByPattern'.")
  transparent inline
  def forContentPattern
    //
    (using ctx : lscc.spclTerminalGrammarsB.SpclPxery )
    (subject: IRegExp._Any )
  : ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1 ]
  = forWordlikeContentByPattern(subject)

  /**
   * 
   * `KeywordPrf`
   * to match UnescapedWord(s) described by the given RegExp (and hence, assumed to be `\w+`s)
   * .
   * will
   * compensate for very speculable absence, at either ends, of the meta-char `\b`,
   * by adding one manually
   * .
   * 
   */
  def forWordlikeContentByPattern
    //
    (using ctx : lscc.spclTerminalGrammarsB.SpclPxery )
    (subject: IRegExp._Any )
  : ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1 ]
  = ({
    import ctx.given

    import ctx.givenFispoSupp.SpclAfterDigestTupleOption

    import IRegExp.tagImplicits.r

    import lscalg.digestivity.ParseFunction.returnedMainValueMapOpImplicits.returnedMainValueMapOp

    /** 
     * compensate for very speculable absence of the meta-char `\b`
     * 
     */
    ({
      ;

      // glscc.spclTerminalGrammars.ForImmediateSingleLineRawOcc({
      //   wordLikeContentPattern(subject)
      // })

      val Ss
      = subject

      // TODO
      (for {
        rawMatch <- {
          ;
          glscc.spclTerminalGrammars.ForImmediateSingleLineRawOcc({
            // TODO
            """(?![0-9])\w+\b""".r
          })
        }

        (matchedStr, userSideIMatches) <- {
          ;

          Some(rawMatch.matchedStr )
          .collect({
            case matchedStr @ Ss(m* ) =>
              ; 
              (matchedStr, m )
          })
        }

      }
      yield (matchedStr, userSideIMatches, rawMatch ))
      .mapWithFinalPtrPosVl({
        case ((matchedStr*: userSideIMatches *: rawMatch *: _ ) *: newPos *: _ ) => {
          ;
          // TODO
          rawMatch
        }
      })
      .map(<:<.refl[ctx.givenFispoSupp.SpclMatchContent ] )
    })
  }).nn

  ;

  /**
   * 
   * `IRegExp`
   * to match UnescapedWord(s) described by the given RegExp (and hence, assumed to be `\w+`s)
   * .
   * will
   * compensate for very speculable absence, at either ends, of the meta-char `\b`,
   * by adding one manually
   * .
   * 
   */
  // private
  // transparent inline
  def wordLikeContentPattern
    //
    (subject: IRegExp._Any )
  : IRegExp._Any
  = {
    ;
    import language.unsafeNulls

    import IRegExp.tagImplicits.r

    subject
    .regex
    .match { case s => (
      // """\b(?:[MAIN])\b""" /* causes `Stack overflow during pattern compilation`s */
      // """\b[MAIN]\b""" /* WRONG */
      """\b(?:[MAIN])\b"""
      .replace("[MAIN]", s )
    ) }
    .match { case r => {
      assert((r startsWith """\b""") && (r endsWith """\b""") )
      r
    } }
    .r
  }

}




;

trait Ikpm
{
  val mainSelector
  : ITokenSelectorRepr
}

object Ikpm {
  ;

  def fromSelectorRepr
    [S <: ITokenSelectorRepr ]
    (s : S )
  : Ikpm { val mainSelector : s.type }
  = new Ikpm { val mainSelector : s.type = s }

  /** magic */
  transparent inline
  implicit
  def asTokenSelectorRepr(lhs: Ikpm )
  : lhs.mainSelector.type
  = lhs.mainSelector

  ;

  @deprecated
  given givenFromFlatGramCtx
    //
    [CtxInst <: (
      lscc.spclTerminalGrammarsB.SpclPxery
      & Singleton
    ) ]
    (using ctx : CtxInst )
  : (
    Ikpm {
      val mainSelector: ITokenSelectorRepr {
        type Applied
        <: ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1]
      }
    }
  )
  = {
    summon[ITokenSelectorRepr ]
    .match { case s => {
      fromSelectorRepr(s)
    } }
    .nn
  }

  ;
}




trait ITokenSelectorRepr
{
  type Applied

  extension (lhs: Applied ) def orElse(rhs: Applied ) : Applied

  def fromRegExp
    (p: lscalg.bnfParsing.IRegExp._Any)
  : Applied

}

object ITokenSelectorRepr
{
  ;

  @deprecated
  given givenFromFlatGramCtx
    //
    [CtxInst <: (
      lscc.spclTerminalGrammarsB.SpclPxery
      & Singleton
    ) ]
    (using ctx : CtxInst )
  : ITokenSelectorRepr { type Applied <: ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1 ] }
  = {
    // import ctx.given
    new ITokenSelectorRepr
    {
      type Applied
      >: ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1 ]
      <: ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1 ]

      import lscalg.digestivity.ParseFunction.alternationalOp.{orElse as orElse0 }

      extension (lhs: Applied )
        def orElse(rhs: Applied )
        = lhs.orElse0(rhs )

      def fromRegExp
        (p: lscalg.bnfParsing.IRegExp._Any)
      = {
        KeywordPrf.forWordlikeContentByPattern(p)
      }
    }
  }

  ;
}







