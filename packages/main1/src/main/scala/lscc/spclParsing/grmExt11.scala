package lscc.spclParsing














import %%%&&&.SpclAfterDigestTupleOption

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







