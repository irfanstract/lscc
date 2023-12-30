package lscc.spclParsing












import lscalg.bnfParsing.BnfCompatibleFileReadPtr1 as GrmSpclFileReadPtr1

import lscalg.bnfParsing.spclCommonLookaheadCaps as GrmPtrStrMatchOpTraits1





given grmWhitespaces1Impl
  [
    _Any
    ,
    EOptConstructor
    <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[_Any]
    ,
  ]
  (using VO_EOptConstructor : ValueOf[EOptConstructor] )
  // (using gwConcatOps1[_Any, VO_EOptConstructor.value.type ] )
  //
  (using toGetRemngLines : lscalg.cli.repl.DefinesGetRemainingLines[_Any, GrmSpclFileReadPtr1.ContentLines ] )
  (using lscalg.bnfParsing.BnrpDoComposeAdvancement[_Any, ([CL] =>> (CL => CL ) )[GrmSpclFileReadPtr1.ContentLines ] ] )
  //
  (using
    //
    (
        GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
          [_Any, util.matching.Regex , VO_EOptConstructor.value._Any ]
      ) ,
      grmForLanguageAgnosticPrimitves1[_Any, VO_EOptConstructor.value.type ]
      ,
  )
  //
: AnyRef with
{
  ;

  /* a workaround to the failure of the inliner to maintain the `.type`ing */
  transparent inline
  def SpclAfterDigestTupleOption
  : VO_EOptConstructor.value.type
  = (VO_EOptConstructor.value)

  // TODO
  given gwConcatOps1[_Any, VO_EOptConstructor.value.type ]
  = {
    gwConcatOps1[_Any, VO_EOptConstructor.value.type ]
  }

  ;

  import lscalg.bnfParsing.IRegExp.tagImplicits.{r}

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

        p
        .immediateConc1((
          //

          Seq[(p: _Any ) => (
            // SpclAfterDigestTupleOption._Any
            VO_EOptConstructor.value._Any
          ) ](
            _.immediateSameLineWhitespaceOpt()
            ,
            _.immediateLineBreak()
            ,
          )
        ))
        .map({case (e1 +: _, nextPos) => {
          ;
          SpclAfterDigestTupleOption.describeAfterDigestTuple1(
            finalPos = nextPos , prod = e1 )
        } })
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
  (using lscalg.bnfParsing.BnrpDoComposeAdvancement[PAny, ([CL] =>> (CL => CL ) )[GrmSpclFileReadPtr1.ContentLines ] ] )
  (using (
    GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
      [PAny, util.matching.Regex , VO_EOptConstructor.value._Any ]
  ) )
  //
: AnyRef with
{
  ;

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
          .dropWhile(lne => {
            lne.contents
            .match { case lne => {
              (lne: String).matches("""\s*""")
            } }
          } )
          /* deduce leading whitespace, from the head-line */
          .match {
            case lne +: nextLines =>
              (lne.copy(contents = lne.contents.replaceFirst("""\A\s+""", "") ) ) +: nextLines
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















