package lscalg.bnfParsing













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

  given eca
  : BnrpDoComposeAdvancement[_Any, ContentLines => ContentLines ]
  with {
    ;

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
  >: lscalg.cli.repl.spclCollections.Lrp._Any
  <: lscalg.cli.repl.spclCollections.Lrp._Any

  ;

  final
  lazy val SpclAfterDigestTupleOption
  : GeneralisedSpclAfterDigestTupleOption[GrmPtr._Any ]
  = implicitly

  type GeneralisedSpclAfterDigestTupleOption[T]
  = lscalg.bnfParsing.SpclTokenisedItemOption.SpclConstructor.ForCheckptType[T ]

  type GeneralisedSpclAfterDigestTupleOptionLU[-TL <: TU, +TU]
  = lscalg.bnfParsing.SpclTokenisedItemOption.SpclConstructor.ForCheckptTypeLU[TL, TU ]

  export bnrpImmediateRegexMatchOps1.{immediateMatchOf as immediateMatchOf }

  export bnrpImmediateRegexMatchOps1.{immediateMatchInLineOf }
  export bnrpImmediateRegexMatchOps1.{immediateMatchIgnoringLinebreakOf }

}

trait BnrpDoComposeAdvancement
  [Receiver, -Cl <: Function1[?, ?] ]
{
  extension (s: Receiver)
    def composeAdvancement
      (f: Cl )
    : Receiver
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

  import bnrpStringRegexMatchingImplicits.{*, given }

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

  ;
}

private
object bnrpStringRegexMatchingImplicits
{
  ;

  ;

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












