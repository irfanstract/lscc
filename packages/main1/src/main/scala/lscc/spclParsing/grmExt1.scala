package lscc.spclParsing














object grmWhitespaces1 {
  ;

  import GrmPtr.{*, given }

  import spclUtil1.{*, given}

  extension (p: _Any ) {
    //

    /** non-zero-length same-line whitespace, therefore excluding CR and, obviously, LF */
    transparent inline
    def immediateSameLineWhitespace()
    = p.immediateMatchOf("""[\s&&[^\r\n]]+""".r)

    /** OPTIONAL non-zero-length same-line whitespace, therefore excluding CR and, obviously, LF */
    transparent inline
    def immediateSameLineWhitespaceOpt()
    = (
      p.immediateSameLineWhitespace() orElse p.immediateZeroLengthie()
    )

    /** optional same-line whitespace, until right before `\r?\n` */
    transparent inline
    def immediateWhitespaceOptUntilLineBreak()
    = {
      ({
        ;

        p.immediateSameLineWhitespaceOpt()
        .flatMap(e1 => {
          (e1.nextPos )
          .match { case p => {
            p.immediateLineBreak()
          } }
          .collect({ case eLast => {
            describeAfterDigestTuple1(
              finalPos = eLast.nextPos , prod = e1.prod )
          } })
        } )
      })
    }

    /** line-break, defined to be `\r?\n` */
    transparent inline
    def immediateLineBreak()
    = p.immediateMatchOf("""\R""".r)

    //
  }

}

given grmWhitespaceSkippingOpImpl1
  [
    PAny
    ,
    EOptConstructor
    <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
    ,
  ]
  (using VO_EOptConstructor : ValueOf[EOptConstructor] )
  (using toGetRemngLines : lscalg.bnfParsing.BnrpDoComposeAdvancement[PAny, ([CL] =>> (CL => CL ) )[GrmSpclFileReadPtr1.ContentLines ] ] )
  (using (
    GrmPtrOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
      [PAny, util.matching.Regex , VO_EOptConstructor.value._Any ]
  ) )
  //
: AnyRef with
{
  ;

  transparent inline
  def SpclAfterDigestTupleOption
  = VO_EOptConstructor.value._Impl1 : VO_EOptConstructor.value._Impl1.type

  ;

  extension (p: PAny ) {
    //

    transparent inline
    def skippingNextWhitespace
      (lineCountLimit: Int)
    : PAny
    = {
      ({
        ;

        p
        .composeAdvancement(lines0 => {
          ;

          import language.unsafeNulls

          lines0
          /* drop all leading whitespace-only or zero-length lines */
          .dropWhile(lne => (lne: String).matches("""\s*""") )
          /* deduce leading whitespace, from the head-line */
          .match {
            case lne +: nextLines =>
              lne.replaceFirst("""\A\s+""", "") +: nextLines
            case s =>
              s
          }
        } )
      })

      .match { case s => {
        ;
        assert({
          s.immediateMatchOf("""\s+""".r )
          .toOption
          .isEmpty
        }, s"leading some whitespace remaining intact" )
        s
      } }
    }

    //
  }

  ;
}

given grmNumericLiteranAndWordsAndIdents1
  [
    EOptConstructor
    <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
    ,
    PAny
    ,
  ]
  (using VO_EOptConstructor : ValueOf[EOptConstructor] )
  (using (
    GrmPtrOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
      [PAny, util.matching.Regex , VO_EOptConstructor.value._Any ]
  ) )
  //
: AnyRef with
{
  ;

  transparent inline
  def SpclAfterDigestTupleOption
  = VO_EOptConstructor.value._Impl1 : VO_EOptConstructor.value._Impl1.type

  // import GrmPtr.{*, given }

  // import spclUtil1.{*, given}

  import GrmPtr.{spclUtil1 }

  import spclUtil1.{r}

  extension (p: PAny ) {
    //

    /** 
     * `immediateNumericLiteral` ;
     * 
     */
    transparent inline
    def immediateNumericLiteral
      //
      ()
    = (
      p.immediateBigDecimalLiteral()
      // orElse
      // p.immediateBigHexadecimalLiteral()
      .match { case result0 => {
        val result2
        = p.immediateBigHexadecimalLiteral()

        SpclAfterDigestTupleOption.orElse(result0 )(result2 )
        .match { case r => r }
      } }
    )

    //
  }

  extension (p: PAny ) {
    //

    /** 
     * `immediateBigDecimalLiteral` ;
     * 
     */
    transparent inline
    def immediateBigDecimalLiteral
      //
      ()
    = (
      p.immediateMatchOf("""(?!0x)[0-9]+(\.[0-9]+)?([eE][+\-][0-9]+)?""".r)
    )

    /** 
     * `immediateBigHexadecimalLiteral` ;
     * 
     */
    transparent inline
    def immediateBigHexadecimalLiteral
      //
      ()
    = (
      p.immediateMatchOf("""0x(?:[0-9A-Z]+|[0-9a-z]+)(\.[0-9A-Za-z]+)?""".r)
    )

    //
  }

  extension (p: PAny ) {
    //

    /** 
     * `immediateUnescapedWord` ;
     * *excludes numeric literals, escaped identifiers,*
     * 
     */
    transparent inline
    def immediateUnescapedWord
      //
      ()
    = p.immediateMatchOf("""(?![0-9])(?:[\w]|\\p\{.*?\})+""".r)

    //
  }

  extension (p: PAny ) {
    //

    /** 
     * `immediateEscapedIdent` ;
     * 
     */
    transparent inline
    def immediateEscapedIdent
      //
      ()
    = p.immediateMatchOf("""\`\w+\`""".r)

    //
  }

  ;
}

object grmDelimiters1 {
  ;

  import GrmPtr.{*, given }

  import spclUtil1.{*, given}

  extension [Recei] (p: Recei )
    (using GrmPtrOpTraits1.ForImmediateLiteral._AnyForReceiverAndL[Recei, String ] )
  {
    //

    transparent inline def immediateCurlyBracketOpen () = p.immediateLiterally("{")
    transparent inline def immediateCurlyBracketClose() = p.immediateLiterally("}")
    transparent inline def immediateRoundBracketOpen () = p.immediateLiterally("(")
    transparent inline def immediateRoundBracketClose() = p.immediateLiterally(")")
    transparent inline def immediateSquareBracketOpen () = p.immediateLiterally("[")
    transparent inline def immediateSquareBracketClose() = p.immediateLiterally("]")

    //
  }

  ;
}














