package lscc.spclParsedConstructs













import lscalg.bnfParsing.BnfCompatibleFileReadPtr1 as GrmSpclFileReadPtr1

import lscalg.bnfParsing.spclCommonLookaheadCaps as GrmPtrStrMatchOpTraits1









export ForNumericLiteranAndWordsAndIdentsImpl._MainPublic as forNumericLiteralAndWordsAndIdentsForBnfParseOptionCtorAndPtrType

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
    (using rc0 : BnfParseOptionCtorAndPtrTypeDefiner.ForPtrTypeAndParseOptionConstructor[PAny, EOptConstructor] )
    (using rr : (
      GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
        [PAny, util.matching.Regex , rc0.SpclAfterDigestTupleOption._Any ]
    ) )
  : _MainPublic[EOptConstructor, PAny]
  = {
    ;

    val rc
    // : BnfParseOptionCtorAndPtrTypeDefinerAndIemiOps.ForPtrTypeAndParseOptionConstructor[PAny, EOptConstructor]
    = {
      // summon[BnfParseOptionCtorAndPtrTypeDefinerAndIemiOps ]
      BnfParseOptionCtorAndPtrTypeDefinerAndIemiOps.iForPtrTypeAndParseOptionConstructor[PAny, EOptConstructor]
    }

    val rcAlias
    : rc.type
    = valueOf
    
    new 
    AnyRef
    with _Main[PAny]
    with _Main1Deps[PAny, EOptConstructor]
    { val rc : rcAlias.type = valueOf }
  }

  type _MainPublic
    [
      EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
      ,
      PAny
      ,
    ]
  = (
    AnyRef
    & _Main[PAny]
    & _Main1Deps[PAny, EOptConstructor]
  )

  ;

  trait _Main1Deps
    [
      PAny
      ,
      EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
      ,
    ]
  {
    thisMain1Deps =>
    ;

    // private[ForNumericLiteranAndWordsAndIdentsImpl]
    val rc
    : BnfParseOptionCtorAndPtrTypeDefinerAndIemiOps.ForPtrTypeAndParseOptionConstructor[PAny, EOptConstructor]

    protected
    transparent inline
    given given_rc_self
    : rc.type
    = rc

    protected
    transparent inline
    given given_rc_underl_self
    : rc.ieoc.type
    = rc.ieoc

    export rc.{SpclAfterDigestTupleOption}

    // export rc.{ccImpl}

    export rc.{iemiOpsR}

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
      & _Main1Deps[PAny, ? ]
    ) =>
    ;

    // transparent inline
    // def iemiOpsR
    // = summon

    ;

    import lscalg.bnfParsing.IRegExp.tagImplicits.{*, given }

    import lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp.ftoOp

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
      : SpclAfterDigestTupleOption._Any
      = ({
        ;

        lscc.spclParsedConstructs1.ForNumericLiteral1()
        .applyOET(p)
      })

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
      : SpclAfterDigestTupleOption._Any
      = (
        lscc.spclParsedConstructs1.ForBigDecimalLiteral1()
        .applyOET(p)
      )

      /** 
       * `immediateBigHexadecimalLiteral` ;
       * 
       */
      transparent inline
      def immediateBigHexadecimalLiteral
        //
        ()
      : SpclAfterDigestTupleOption._Any
      = (
        lscc.spclParsedConstructs1.ForBigHexadecimalLiteral1()
        .applyOET(p)
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
      : SpclAfterDigestTupleOption._Any
        // TODO
      // : VO_EOptConstructor.value._Any
      = (
        lscc.spclParsedConstructs1.ForImmediateUnescapedWord()
        .applyOET(p)
      )

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
      : SpclAfterDigestTupleOption._Any
      = (
        lscc.spclParsedConstructs1.ForImmediateEscapedIdent()
        .applyOET(p)
      )

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










