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

    def immediateNonLinebreakingWhitespace() = p.immediateMatchOf("""(?:(?![\r\n])\s)+""".r)

    //
  }

  extension (p: _Any ) {
    //

    def immediateMatchOf
      //
      (r: util.matching.Regex )
    : SpclAfterDigestTupleOption._Any
    = {
      import  GrmSpclFileReadPtr1.{immediateMatchIgnoringLinebreakOf as immediateMatchOf0 }

      p.immediateMatchOf0(r)

      .match { case s => s }
    }

    def immediateLiterally
      //
      (s: String)
    = p.immediateMatchOf(s match { case chr => util.matching.Regex.quote(chr).r } )

  }

  extension (p: _Any ) {
    //

    // TODO
    def immediateIdentifierOption
      //
      ()
    : SpclAfterDigestTupleOption._Any
    = {
      SpclAfterDigestTupleOption.negativeInstance

      .orElse({
        val w
        = p.immediateUnescapedWord()

        w
        .toOption
        .flatMap (s => {
          ;

          val wrd = {
            ;

            s.prod
            .match { case (_ :+ idnt, _ ) => idnt }
          }

          val isValidIdent
          = {
            // TODO
            true
          }

          if isValidIdent then Some(w)
          else None

        } )
        .fold(SpclAfterDigestTupleOption.negativeInstance )(e => e )
      })

      .orElse({
        p.immediateEscapedIdent()
      })
    }

    /** 
     * `immediateUnescapedWord` ;
     * *excludes numeric literals, escaped identifiers,*
     * 
     */
    def immediateUnescapedWord
      //
      ()
    = p.immediateMatchOf("""(?![0-9])\w+""".r)

    /** 
     * `immediateEscapedIdent` ;
     * 
     */
    def immediateEscapedIdent
      //
      ()
    = p.immediateMatchOf("""\`\w+\`""".r)

    //
  }

  extension (p: _Any ) {
    //

    def immediateCurlyBraceOpen() = p.immediateLiterally("{")
    def immediateCurlyBraceClose() = p.immediateLiterally("}")
    def immediateRoundBraceOpen() = p.immediateLiterally("(")
    def immediateRoundBraceClose() = p.immediateLiterally(")")
    def immediateSquareBraceOpen() = p.immediateLiterally("[")
    def immediateSquareBraceClose() = p.immediateLiterally("]")

    //
  }

  ;
}















