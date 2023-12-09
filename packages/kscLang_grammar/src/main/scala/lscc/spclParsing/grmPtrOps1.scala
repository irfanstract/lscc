package lscc.spclParsing
















@deprecated
object GrmPtrStrMatchOpTraits1 {
  ;

  export lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence

  export lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediateLiteral

  export lscalg.bnfParsing.spclCommonLookaheadCaps.{forZeroLengthMatching, forZeroLengthMatchingImpl }

  export lscalg.bnfParsing.spclCommonLookaheadCaps.{forEofMatching, forEofMatchingImpl }

  ;
}

export lscalg.bnfParsing.spclCommonLookaheadCaps.forConcatenationSb as gwConcatOps1






// TODO
/**
 * `GrmPtrGivens` ;
 * a currently-small number of `using`s relevant
 * 
 * currently this don't quite work,
 * only ending up with complaint like `not a legal path because it's not immutable path`
 * 
 */
object GrmPtrGivens
{
  ;

  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1 as GrmSpclFileReadPtr1

  export GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOptionLU

  type GeneralisedSpclAfterDigestTupleOptionLUNothingAny
  = GeneralisedSpclAfterDigestTupleOptionLU[Nothing, Any]

  transparent inline
  def SpclAfterDigestTupleOption
    (using ctor : ValueOf[? <: GeneralisedSpclAfterDigestTupleOptionLUNothingAny ] )
    // [I <: ValueOf[? <: GeneralisedSpclAfterDigestTupleOptionLUNothingAny ] & Singleton ]
    // (using ctor: I )
  : ctor.value.type
  = ctor.value

}






// @deprecated
final
lazy val GrmPtrSpclRegex
: lscalg.bnfParsing.IRegExp.type
= lscalg.bnfParsing.IRegExp










