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

  given withRemainingLinesOp
  : AnyRef
  with {
    //

    extension (pt0 : _Any )
      transparent inline
      def withRemainingLines(newValue: ContentLines )
      = {
        // TODO check suffix same

        pt0
        .match { case s0 => s0.copy(_1 = newValue ) : _Any }
      }

  }

  final
  lazy val remainingLinesLens
  = {
    locally[ContentLines => _Any => _Any ] (newValue => pt0 => pt0.withRemainingLines(newValue ) )
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

  given eca
  : BnrpDoComposeAdvancement[_Any, ContentLines => ContentLines ]
  with {
    ;

    extension (pt0: _Any ) {
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
          pt0.remainingLines
          .match { case ls0 => f(ls0) }
          .match { case newLs => remainingLinesLens.apply(newLs )(pt0) }
          .match { case pt2 => pt2 }
        }
      }
    }

  }

  ;

  type ContentLines
  >: LazyList[String]
  <: LazyList[String]

  /** 
   * every talked-about `lscc.spclParsing.spclUtil.Lrp` .
   * `the elaborated file info`
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

  ;

  given given_BnrpMatchingLoopOp
  : BnrpMatchingLoopOp.ForReceiver[_Any, SpclAfterDigestTupleOption.PositiveInstance ]
  with {
    ;

    import BnrpMatchingLoopOp.SpclBacktrackworthiness
    import BnrpMatchingLoopOp.SpclEagerness
    import BnrpMatchingLoopOp.SpclSubject
    import BnrpMatchingLoopOp.SpclCountRange
    import BnrpMatchingLoopOp.implementativeImplicits.{*, given }

    type ReceiT
    >: _Any
    <: _Any
    type R
    >: SpclAfterDigestTupleOption.PositiveInstance
    <: SpclAfterDigestTupleOption.PositiveInstance

    extension (pt0: _Any)
      def tryForImmediateLoop
      : (
        (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness ) =>
        (SpclSubject.ForReceiverAndROpt[ReceiT, R ] , SpclCountRange ) =>
          BnfCompatibleRetrialIterator[Seq[R] ]
      )
      = {
        ;

        (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness ) =>
        (subject: SpclSubject.ForReceiverAndROpt[ReceiT, R ] , r: SpclCountRange ) =>
          rImpl
            (backtrackWorthiness = backtrackWorthiness , eagerness = eagerness  )
            (subject, backConv = e => e.nextPos )
            (pt0, countBnds = r )
      }
  }

  ;

  export bnrpImmediateRegexMatchOps1.{commonSubjects }

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
            nextPos = subsequentPos ,
            prod = ({
              SpclAfterDigestTupleOption._Impl1.SpclMatchedStringArray(fullS = matchedString , ms = m.toIndexedSeq )
            } , r ) )
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

  object commonSubjects {
    ;

    final lazy val WHITESPACE_SOME
    = BnrpMatchingLoopOp.SpclSubject.fromLiftedPartialFunction((_: _M._Any).immediateMatchInLineOf("""\s+""".r ).toOption )

    final lazy val IDENTIFIERWORD_SOME
    = BnrpMatchingLoopOp.SpclSubject.fromLiftedPartialFunction((_: _M._Any).immediateMatchInLineOf("""(?![0-9])\w+""".r ).toOption )

    ;
  }

  ;
}

trait BnrpDoComposeAdvancement
  [Receiver, -Cl <: Function1[?, ?] ]
{
  extension (s: Receiver)
    def composeAdvancement
      (f: Cl )
    : Receiver
}












