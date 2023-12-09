package lscc.spclParsing












final lazy val GrmSpclFileReadPtr1
: BnfCompatibleFileReadPtr1.type
= BnfCompatibleFileReadPtr1




object BnfCompatibleFileReadPtr1
{ GrmPtr =>
  ;

  type _Any
  = AtRemainingPosAndSrcFile[Any, ElbdFileInfo ]

  opaque type AtRemainingPosAndSrcFile
    [+RemnPos, +SrcFileInfo <: ElbdFileInfo ]
  <: Product
  = (ContentLines & RemnPos, SrcFileInfo )

  def atBeginningOfSrcFile
    (b: ElbdFileInfo )
  : AtRemainingPosAndSrcFile[Any, b.type ]
  = (b.lines, b )

  given edgrl
  : lscalg.cli.repl.DefinesGetRemainingLines[_Any, ContentLines ]
  with {
    //

    extension (s: _Any )
      transparent inline
      def remainingLines
      = s._1

  }

  given edsi
  : lscalg.cli.repl.DefinesGetSrcFileInfo[_Any, ElbdFileInfo ]
  with {
    //

    extension (s: _Any )

      transparent inline
      def srcFileInfo
      : ElbdFileInfo
      = s._2

  }

  // extension (s: _Any )
  //   transparent inline
  //   def remainingLines
  //   = s._1

  //   transparent inline
  //   def srcFileInfo
  //   : ElbdFileInfo
  //   = s._2

  extension (s: _Any ) {
    //

    /** 
     * after advancing the pos
     * 
     */
    // transparent inline
    def composeAdvancement
      //
      (f: ContentLines => ContentLines )
    = {
      ;
      locally[_Any] {
        (s.remainingLines match { case ls => f(ls) } , s.srcFileInfo )
      }
    }
  }

  ;

  type ContentLines
  >: LazyList[String]
  <: LazyList[String]

  /** 
   * every talked-about `lscc.spclParsing.spclUtil.Lrp`
   * 
   */
  type ElbdFileInfo
  >: lscc.spclParsing.spclUtil.Lrp._Any
  <: lscc.spclParsing.spclUtil.Lrp._Any

  ;

  final
  lazy val SpclAfterDigestTupleOption
  : GeneralisedSpclAfterDigestTupleOption[GrmPtr._Any ]
  = GeneralisedSpclAfterDigestTupleOption[GrmPtr._Any ]

  class GeneralisedSpclAfterDigestTupleOption
    //
    [Kp]
  {
    ;

    type _Any
    >: _Impl
    <: _Impl

    final
    lazy val negativeInstance
    : _Any & _Impl.None.type
    = _Impl.None
    type negativeInstance
    = _Any & _Impl.None.type

    def apply
      //
      (nextPos: Kp, prod: (IndexedSeq[String], util.matching.Regex ) )
    = _Impl.Some(nextPos = nextPos , prod = prod )

    ;

    private[GeneralisedSpclAfterDigestTupleOption]
    final
    lazy
    val  _Impl = _Impl1
    private[GeneralisedSpclAfterDigestTupleOption]
    type _Impl = _Impl1

    enum _Impl1 {
      case None
      case Some(nextPos: Kp, prod: (IndexedSeq[String], util.matching.Regex ) )

    }

    object _Impl1 {
      ;

      extension (this1: _Impl1) {
        //

        def toOption
        = {
          this1 match {
            case _Impl1.None => scala.None
            case (e : _Impl1.Some) => scala.Some(e )
          }
        }

        /**
         * `orElse` (not `Option`)
         */
        def orElse
          (altVal: => _Impl1 )
        = {
          this1.toOption
          .fold[_Impl1 ] (altVal )(<:<.refl[_Impl1.Some ] )
        }

      }

      extension (this1: _Impl1.Some ) {
        //

        /** map */
        def mapNextPos
          //
          [OtherKp]
          (using dest : GeneralisedSpclAfterDigestTupleOption[OtherKp] )
          (fnc: Kp => OtherKp )
        : dest._Impl.Some
        = {
          dest._Impl.Some(
            nextPos = this1.nextPos match { case p => fnc(p) }
            ,
            prod = this1.prod )
        }
      }

      ;
    }

    ;
  }

  export bnrpImmediateRegexMatchOps1.{immediateMatchOf as immediateMatchOf }

  export bnrpImmediateRegexMatchOps1.{immediateMatchInLineOf }
  export bnrpImmediateRegexMatchOps1.{immediateMatchIgnoringLinebreakOf }

}

private
object bnrpImmediateRegexMatchOps1
{
  ;

  import BnfCompatibleFileReadPtr1.SpclAfterDigestTupleOption

  import BnfCompatibleFileReadPtr1 as _M

  given lscalg.cli.repl.NextIncreasingLengthDequeueRetrialItrOps1.ForAAndLn[_M._Any, String ]
  = {
    ;
    import lscalg.cli.repl.NextIncreasingLengthDequeueRetrialItrOps1.{given }
    implicitly[lscalg.cli.repl.NextIncreasingLengthDequeueRetrialItrOps1.ForAAndLn[_M._Any, String ] ]
  }

  extension (p: _M._Any ) {
    //

    def immediateMatchOf
      //
      (r: util.matching.Regex, lineCountLimit: Int )
    : SpclAfterDigestTupleOption._Any
    = {
      ;
      require(1 <= lineCountLimit )

      val existingLines
      = p.remainingLines

      p.nextUpToNLinesDequeueRetrialItr1(lineCountLimit = lineCountLimit )

      .flatMap({ case (poppedLines @ (_ +: _ ), afterCheckRemainingLines) => {
        ;

        import language.unsafeNulls

        val poppedStr
        = {
          ;
          poppedLines
          .mkString("", "\r\n", "" )
        }

        poppedStr

        .tryCheckAndSplitAfterPrefix(r)

        .map({ case s1 @ (matchedString, _ ) => {
          ;

          val `r`(m*)
          = matchedString : @unchecked

          val subsequentPos
          = {
            p.composeAdvancement(_ => (
              (
                (s1._2 : String ) +:
                  afterCheckRemainingLines
              )
              .to(LazyList )
            ) )
          }

          SpclAfterDigestTupleOption.apply(
            nextPos = subsequentPos , prod = (m.toIndexedSeq.prepended(matchedString) , r ) )
        } })
      } })
      .headOption

      .fold
        (SpclAfterDigestTupleOption.negativeInstance )
        (r => r )
    }

    transparent inline
    def immediateMatchInLineOf
      //
      (r: util.matching.Regex )
    : SpclAfterDigestTupleOption._Any
    = p.immediateMatchOf(r, lineCountLimit = 1 )

    transparent inline
    def immediateMatchIgnoringLinebreakOf
      //
      (r: util.matching.Regex )
    : SpclAfterDigestTupleOption._Any
    = p.immediateMatchOf(r, lineCountLimit = 1048576 )

    //
  }

  extension (s: String)
    def tryCheckAndSplitAfterPrefix
      (r: util.matching.Regex )
    = {
      import language.unsafeNulls

      ({
        r
        .match { case r => {
          r
          .withLeadingInputStartMatcher()
          .match { case r => {
            r
            .match { case r => {
              r
              .pattern
              .matcher(s)
            } }
            .match { case m => {
              Option.when(m.find() )(m )
            } }
          } }
        } }
      })

      .map(matcher => {
        val mEnd
        = matcher.end()

        s.splitAt(mEnd )
      } )
    }

  extension (r: util.matching.Regex )
    /** 
     * `plusLineRemaindPattern`,
     * also adding extra *group*s
     * 
     * ```
     * s"($pattern)(.*?)"
     * .r
     * ```
     * 
     */
    def plusLineRemaindPattern()
    = {
      r
      .regex
      .match { case pattern => s"($pattern)(.*?)" }
      .r
    }

  extension (r: util.matching.Regex )
    def withLeadingInputStartMatcher()
    = {
      r
      .regex
      .match { case pattern => pattern.prependedAll("""\A""") }
      .r
    }

  ;
}












