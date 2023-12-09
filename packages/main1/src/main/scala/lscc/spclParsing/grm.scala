package lscc.spclParsing







import lscalg.cli.repl.UReadlineConsole









object GrmPtr {
  ;

  ;

  transparent inline
  def atBeginningOfFile
    //
    (src: GrmSpclFileReadPtr1.ElbdFileInfo )
  = {
    src
    .match { case file => GrmSpclFileReadPtr1.atBeginningOfSrcFile(file ) }
    .match { case r => atPosition(r) }
  }

  ;

  type _Any
  = AtPos[GrmSpclFileReadPtr1._Any ]

  type AtRemainingPosAndSrcFile
    [+RemnPos, +SrcFileInfo <: GrmSpclFileReadPtr1.ElbdFileInfo ]
  = AtPos[GrmSpclFileReadPtr1.AtRemainingPosAndSrcFile[RemnPos, SrcFileInfo ] ]

  opaque type AtPos
    [+Pos <: GrmSpclFileReadPtr1._Any ]
  <: Pos
  = Pos

  def atPosition
    //
    (src: GrmSpclFileReadPtr1._Any )
  : AtPos[src.type ]
  = src

  ;

  /** 
   * `SpclAfterDigestTupleOption`
   * 
   * note :
   * uses a conjunction of two instantiations of same base classs-type with variation on nonvariant type-param,
   * which happened to compile but can't be guaranteed to remain do so in next compiler versions
   * 
   */
  final lazy val SpclAfterDigestTupleOption
  // : GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[_Any ]
  // = GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[_Any ]
  : GrmSpclFileReadPtr1.SpclAfterDigestTupleOption.type & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[_Any ]
  = {
    ;

    ({ val tc : (AtPos[GrmSpclFileReadPtr1._Any ] =:= GrmSpclFileReadPtr1._Any ) = implicitly ; tc })
    .flip
    .liftCo[[T] =>> GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[T] ]
    .match { case actualFnc => {
      ([T0, T1] => (f: T0 <:< T1) => (
        f.asInstanceOf[(
          (value: T0) => (
            value.type &
            // ([T] =>> ({ type Main >: T <: T })[T0 & T1 ] )#Main
            T0 & T1
            // ({ type I1 >: T0 <: T0 })#I1 & ({ type I2 >: T1 <: T1 })#I2
          )
        ) ]
      ) )
        (actualFnc )
    } }
    .match { case f => f }
    .match { case refine => {
      refine(GrmSpclFileReadPtr1.SpclAfterDigestTupleOption )
    } }
    // .match { case f => f }
  }

  extension (code: String)
    def r
    = GrmPtrSpclRegex.forRegExpr(code)

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

  extension (e: SpclAfterDigestTupleOption.PositiveInstance )
    def matchedStr
    : String
    = e.prod._1.head

  def describeAfterDigestTuple1
    //
    (finalPos: _Any, prod: (IndexedSeq[String], util.matching.Regex ) )
  = {
    ;
    SpclAfterDigestTupleOption.PositiveInstance
      (nextPos = finalPos , prod = prod )
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

    def immediateMatchOf
      //
      (r: util.matching.Regex )
    : IMOR[r.type]
    = {
      ({
        ;

        import  GrmSpclFileReadPtr1.{immediateMatchIgnoringLinebreakOf as immediateMatchOf0 }

        p.immediateMatchOf0(r)

        .match { case s => s }
      })

      .match { case result => {
        &&%%%[IMOR[r.type] ]
        .apply(result)
      } }
    }

    def immediateLiterally
      //
      (s: String)
    : IMOL[s.type]
    = {
      p.immediateMatchOf(s match { case chr => util.matching.Regex.quote(chr).r } )

      .match { case r => {
        &&%%%[IMOL[s.type] ]
        .apply(r)
      } }
    }

    transparent inline
    def immediateEndOfFile
      ()
    = {
      /* won't work */
      p.immediateMatchOf("""\z""".r )
      //
      p.remainingLines
      .match { case s => {
        Some(s)
        .collect({ case Seq() | ("" +: Seq() ) => })
      } }
    }

    transparent inline
    def immediateZeroLengthie
      ()
    = p.immediateMatchOf("".r )

  }

  private
  def &&%%%[T >: SpclAfterDigestTupleOption._Any ]
  = identity[(value: SpclAfterDigestTupleOption._Any ) => (value.type & T ) ] (e => e )

  opaque type IMOL[+Value]
  <: SpclAfterDigestTupleOption._Any
  =  SpclAfterDigestTupleOption._Any

  opaque type IMOR[+Pattern ]
  <: SpclAfterDigestTupleOption._Any
  =  SpclAfterDigestTupleOption._Any

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

object GrmPtrSpclRegex {

  opaque type ForRegexp[+V]
  <: util.matching.Regex
  = util.matching.Regex

  def forRegExpr(code: String)
  : ForRegexp[code.type ]
  = code.r

}















