package lscc.spclParsedConstructs













import lscalg.bnfParsing.BnfCompatibleFileReadPtr1 as GrmSpclFileReadPtr1

import lscalg.bnfParsing.spclCommonLookaheadCaps as GrmPtrStrMatchOpTraits1









export ForNumericLiteranAndWordsAndIdentsImpl._MainPublic as forNumericLiteranAndWordsAndIdents1

object ForNumericLiteranAndWordsAndIdentsImpl
{
  ;

  ;

  transparent inline
  given _MainPublic
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
  : _MainPublic[EOptConstructor, PAny]
  =
    new AnyRef with _MainPublic[EOptConstructor, PAny]
    {
      val SpclAfterDigestTupleOption: VO_EOptConstructor.value.type = valueOf 
      val iemiOpsR : rr.type = valueOf
    }

  trait _MainPublic
    [
      EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
      ,
      PAny
      ,
    ]
  extends
  AnyRef
  with _Main[PAny]
  with _Main1Deps[EOptConstructor, PAny]

  ;

  trait _Main1Deps
    [
      EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
      ,
      PAny
      ,
    ]
  {
    ;

    val SpclAfterDigestTupleOption : EOptConstructor
    // val VO_EOptConstructor = implicitly[ValueOf[SpclAfterDigestTupleOption.type] ]

    given iemiOpsR : (
      GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
        [PAny, util.matching.Regex , SpclAfterDigestTupleOption._Any ]
    )

    ;
  }

  /** 
   * only the ops, without the clutter (here, the essential auxiliary defs)
   * 
   */
  trait _Main
    [
      PAny
      ,
    ]
    // (using val VO_EOptConstructor : ValueOf[EOptConstructor] )
    //
  // : AnyRef with
  {
    this : (
      _Main[PAny]
      & _Main1Deps[?, PAny ]
    ) =>
    ;

    // transparent inline
    // def iemiOpsR
    // = summon

    ;

    import lscalg.bnfParsing.IRegExp.tagImplicits.{*, given }

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

  ;
}

object forDelimiters1 {
  ;

  import lscalg.bnfParsing.IRegExp.tagImplicits.{*, given }

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







