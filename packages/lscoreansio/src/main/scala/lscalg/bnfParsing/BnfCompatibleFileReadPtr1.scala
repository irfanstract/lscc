package lscalg.bnfParsing













object BnfCompatibleFileReadPtr1
extends
AnyRef
with BnfCompatibleFileReadPtrRepr1
with BnfCompatibleFileReadPtrExtras1
with BnfCompatibleFileReadPtrExtrasStrings1
{ GrmPtr =>
  ;

  // export bnrpImmediateRegexMatchOps1.{immediateMatchOf as immediateMatchOf }

  export bnrpImmediateRegexMatchOps1.{immediateMatchInLineOf }
  export bnrpImmediateRegexMatchOps1.{immediateMatchIgnoringLinebreakOf }

  object extraImmediatePatternMatchImplicits {
    ;

    export bnrpImmediateRegexMatchOps1.{immediateMatchIgnoringLinebreakOf as immediateMatchOf0 }

    export mainImmediatePatternMatchImplicits.{
      iemiOpsR ,
      iemiOpsL ,
    }

  }

  // TODO
  export extraImmediatePatternMatchImplicits.{
    iemiOpsR ,
    iemiOpsL ,
  }

  ;

  given given_BnrpMatchingLoopOp
  : BnrpMatchingLoopOp.ForReceiver[_Any, SpclAfterDigestTupleOption.PositiveInstance ]
  = given_BnrpMatchingLoopOp1

  ;

  ;

}

trait BnfCompatibleFileReadPtrExtrasStrings1
{
  _M : (
    BnfCompatibleFileReadPtrRepr1
  ) =>
  ;

  ;

  ;

  // private[bnfParsing]
  protected
  object bnrpImmediateRegexMatchOps1
  {
    ;

    import lscalg.cli.repl.LineNumberAndContents

    given lscalg.cli.repl.NextIncreasingLengthDequeueRetrialItrOps1.ForAAndLn[_M._Any, String ]
    = {
      ;
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

          for {
            ((matchedString, m ) , plRemainder )
              <- poppedStr.tryCheckAndSplitAndExtractAfterPrefix(r)
          }
          yield {
            ;

            val subsequentPos
            = {
              p.composeAdvancement(_ => (
                (
                  (plRemainder : String ) +:
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
          }
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

  ;

  private[bnfParsing]
  object mainImmediatePatternMatchImplicits {
    ;

    import bnrpImmediateRegexMatchOps1.{immediateMatchIgnoringLinebreakOf as immediateMatchOf0 }

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
}

trait BnfCompatibleFileReadPtrExtras1
{ GrmPtr : BnfCompatibleFileReadPtrRepr1 =>
  ;

  // given given_BnrpMatchingLoopOp
  // : BnrpMatchingLoopOp.ForReceiver[_Any, SpclAfterDigestTupleOption.PositiveInstance ]
  // = given_BnrpMatchingLoopOp1

  // private[BnfCompatibleFileReadPtrExtras1]
  protected
  given given_BnrpMatchingLoopOp1
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
        (SpclSubject.ForReceiverAndRValue[ReceiT, R ] , SpclCountRange ) =>
          BnfCompatibleRetrialIterator[Seq[R] ]
      )
      = {
        ;

        (backtrackWorthiness: SpclBacktrackworthiness , eagerness: SpclEagerness ) =>
        (subject: SpclSubject.ForReceiverAndRValue[ReceiT, R ] , r: SpclCountRange ) =>
          rImpl
            (backtrackWorthiness = backtrackWorthiness , eagerness = eagerness  )
            (subject, backConv = e => e.nextPos )
            (pt0, countBnds = r )
      }
  }

  ;

}












