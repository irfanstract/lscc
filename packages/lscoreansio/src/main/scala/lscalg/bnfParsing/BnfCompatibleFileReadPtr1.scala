package lscalg.bnfParsing













object BnfCompatibleFileReadPtr1
extends
AnyRef
with BnfCompatibleFileReadPtrExtras1
{ GrmPtr =>
  ;

  type _Any
  = ImplAtRemainingPosAndSrcFile[?, ? ]

  type AtRemainingPosAndSrcFile
    [+RemnPos, +SrcFileInfo <: ElbdFileInfo ]
  = ImplAtRemainingPosAndSrcFile[? <: RemnPos, ? <: SrcFileInfo ]

  protected
  case class ImplAtRemainingPosAndSrcFile
    [+RemnPos, +SrcFileInfo <: ElbdFileInfo ] private[BnfCompatibleFileReadPtr1 ]
    (remainingLinesImpl : LazyList[LineNumberAndContents], srcFileInfoImpl: SrcFileInfo )

  def atBeginningOfSrcFile
    (b: ElbdFileInfo )
  : AtRemainingPosAndSrcFile[Any, b.type ]
  = {
    ;
    ImplAtRemainingPosAndSrcFile[Any, b.type ] (
      remainingLinesImpl = {
        b.lines
        .zipWithIndex
        .map({ case (c, i) => LineNumberAndContents(index = i , contents = c ) })
      } , 
      srcFileInfoImpl = b )
  }

  given edgrl
  : lscalg.cli.repl.DefinesGetRemainingLines[_Any, ContentLines ]
  = {
    lscalg.cli.repl.DefinesGetRemainingLinesConv.basicInstance((s: _Any ) => {
      ;
      s.remainingLinesImpl
      .match { case l => l : ContentLines }
    } )
  }

  object extraEdgrlImplicits {
    ;

    given edgrlx
    : lscalg.cli.repl.DefinesGetRemainingLines[_Any, LazyList[String] ]
    = {
      ;
      lscalg.cli.repl.DefinesGetRemainingLinesConv.basicInstance((s: _Any) => {
        ;
        s.remainingLinesImpl
        .match { case l => l : ContentLines }
        .match { case l => l.map(ln => ln.contents ) }
      } : LazyList[String] )
    }

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
        .match { case s0 => s0.copy(remainingLinesImpl = newValue ) : _Any }
      }

  }

  final
  lazy val remainingLinesLens
  = {
    locally[ContentLines => _Any => _Any ] (newValue => pt0 => pt0.withRemainingLines(newValue ) )
  }

  given edsi
  : lscalg.cli.repl.DefinesGetSrcFileInfo[_Any, ElbdFileInfo ]
  = {
    lscalg.cli.repl.DefinesGetSrcFileInfo((s: _Any) => (
      s.srcFileInfoImpl
    ) : ElbdFileInfo )
  }

  given eca
  : BnrpDoComposeAdvancement[_Any, ContentLines => ContentLines ]
  = {
    BnrpDoComposeAdvancement((pt0: _Any) => (f: ContentLines => ContentLines) => {
      ;

      locally[_Any] {
        pt0.remainingLines
        .match { case ls0 => f(ls0) }
        .match { case newLs => remainingLinesLens.apply(newLs )(pt0) }
        .match { case pt2 => pt2 }
      }
    } : _Any )
  }

  ;

  export lscalg.cli.repl.LineNumberAndContents

  type ContentLines
  >: LazyList[LineNumberAndContents]
  <: LazyList[LineNumberAndContents]

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

  object extraImmediatePatternMatchImplicits {
    ;

    export bnrpImmediateRegexMatchOps1.{immediateMatchIgnoringLinebreakOf as immediateMatchOf0 }

    given iemiOpsR
    : spclCommonLookaheadCaps.ForImmediatePatterOccurence.ForReceiverAndRAndL[_Any, [t] =>> SpclAfterDigestTupleOption._Any , util.matching.Regex ]
    = {
      spclCommonLookaheadCaps.ForImmediatePatterOccurence.forReceiverAndMatchSmmryBaseTypeAndQueryType
        [_Any, SpclAfterDigestTupleOption._Any, util.matching.Regex ] ((p) => (query) => {
          ;

          p.immediateMatchOf0(query )
        } )
    }

    given iemiOpsL
    : spclCommonLookaheadCaps.ForImmediateLiteral.ForReceiverAndRAndL[_Any, [t] =>> SpclAfterDigestTupleOption._Any , String ]
    = {
      ;
      import IRegExp.tagImplicits.r

      spclCommonLookaheadCaps.ForImmediateLiteral.forReceiverAndMatchSmmryBaseTypeAndQueryType
        [_Any, SpclAfterDigestTupleOption._Any, String ] ((p) => (queryString) => {
          ;
          val query
          = util.matching.Regex.quote(queryString ).r

          p.immediateMatchOf0(query )
        } )
    }

  }

  ;

  given given_BnrpMatchingLoopOp
  : BnrpMatchingLoopOp.ForReceiver[_Any, SpclAfterDigestTupleOption.PositiveInstance ]
  = given_BnrpMatchingLoopOp1

  ;

  ;

}

private
object bnrpImmediateRegexMatchOps1
{
  ;

  import BnfCompatibleFileReadPtr1.SpclAfterDigestTupleOption

  import BnfCompatibleFileReadPtr1.LineNumberAndContents

  import BnfCompatibleFileReadPtr1 as _M

  given lscalg.cli.repl.NextIncreasingLengthDequeueRetrialItrOps1.ForAAndLn[_M._Any, String ]
  = {
    ;
    // import lscalg.cli.repl.NextIncreasingLengthDequeueRetrialItrOps1.{given }
    // implicitly[lscalg.cli.repl.NextIncreasingLengthDequeueRetrialItrOps1.ForAAndLn[_M._Any, LineNumberAndContents ] ]

    import lscalg.cli.repl.NextIncreasingLengthDequeueRetrialItrOps1.{given_ForAAndLn_A_Ln }
    given_ForAAndLn_A_Ln[_M._Any, String ]
      (using {
        import lscalg.cli.repl.DefinesGetRemainingLinesConv.{*, given }
        drlItemExtractingWrapper[_M._Any, LazyList ]
      } )
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

        val pl
        : poppedLines.type
        = poppedLines

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
              // TODO
              .zip(LazyList.from(pl.match { case ls :+ lastLine => ls.length }) )
              .map({ case (c, i) => LineNumberAndContents(index = i , contents = c ) })
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

  ;
}












