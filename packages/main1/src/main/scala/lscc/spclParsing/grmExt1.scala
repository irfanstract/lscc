package lscc.spclParsing












object %%%&&& {
  ;

  type GeneralisedSpclAfterDigestTupleOptionLUNothingAny
  = GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOptionLU[Nothing, Any]

  transparent inline
  def SpclAfterDigestTupleOption
    (using ctor : ValueOf[? <: GeneralisedSpclAfterDigestTupleOptionLUNothingAny ] )
    // [I <: ValueOf[? <: GeneralisedSpclAfterDigestTupleOptionLUNothingAny ] & Singleton ]
    // (using ctor: I )
  : ctor.value.type
  = ctor.value

}

import %%%&&&.SpclAfterDigestTupleOption



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
      grmForLanguageAgnosticPrimitves1[_Any, VO_EOptConstructor.value.type ] ,
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

  import GrmPtr.spclUtil1.r

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


transparent inline
given grmNumericLiteranAndWordsAndIdents1
  [
    EOptConstructor
    <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
    ,
    PAny
    ,
  ]
  (using VO_EOptConstructor : ValueOf[EOptConstructor] )
  (using rr : (
    GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
      [PAny, util.matching.Regex , VO_EOptConstructor.value._Any ]
  ) )
: grmNumericLiteranAndWordsAndIdents1[EOptConstructor, PAny]
=
  new AnyRef with grmNumericLiteranAndWordsAndIdents1[EOptConstructor, PAny]
  {
    val SpclAfterDigestTupleOption: VO_EOptConstructor.value.type = valueOf 
    val iemiOpsR : rr.type = valueOf
  }

trait grmNumericLiteranAndWordsAndIdents1
  [
    EOptConstructor
    <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
    ,
    PAny
    ,
  ]
  // (using val VO_EOptConstructor : ValueOf[EOptConstructor] )
  //
// : AnyRef with
{
  ;

  val SpclAfterDigestTupleOption : EOptConstructor
  // val VO_EOptConstructor = implicitly[ValueOf[SpclAfterDigestTupleOption.type] ]

  given iemiOpsR : (
    GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
      [PAny, util.matching.Regex , SpclAfterDigestTupleOption._Any ]
  )

  // transparent inline
  // def iemiOpsR
  // = summon

  ;

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

        SpclAfterDigestTupleOption._Impl1.orElse(result0 )(result2 )
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
      // TODO
    // : VO_EOptConstructor.value._Any
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
    (using GrmPtrStrMatchOpTraits1.ForImmediateLiteral._AnyForReceiverAndL[Recei, String ] )
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














