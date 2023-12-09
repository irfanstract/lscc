package lscc.spclParsing














object grmAddedImplicits1 {
  ;

  ;

  import GrmPtr.{*, given }

  import spclUtil1.{*, given}

  object XLbm {
    ;

    type _Any
    = _Of[Boolean]

    opaque type _Of[+Value <: Boolean]
    <: Matchable
    = Value

    def does(using XLbm._Any) : Boolean
    = summon[XLbm._Any ]

    ;
  }

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
    }

    /** line-break, defined to be `\r?\n` */
    transparent inline
    def immediateLineBreak()
    = p.immediateMatchOf("""\R""".r)

    transparent inline
    def skippingNextWhitespace
      (lineCountLimit: Int)
    : _Any
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

  extension (p: _Any ) {
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
      p.immediateMatchOf("""(?!0x)[0-9]+(\.[0-9]+)?([eE][+\-][0-9]+)?""".r)
      orElse
      p.immediateMatchOf("""0x(?:[0-9A-Z]+|[0-9a-z]+)(\.[0-9A-Za-z]+)?""".r)
    )

    //
  }
  extension (p: _Any ) {
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

  extension (p: _Any ) {
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

  extension (p: _Any ) {
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














