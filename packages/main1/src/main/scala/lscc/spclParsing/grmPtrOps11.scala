package lscc.spclParsing


















// given grmForLanguageAgnosticPrimitves1
//   [
//     _Any
//     ,
//     EOptConstructor
//     <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[_Any]
//     ,
//   ]
//   (using VO_EOptConstructor : ValueOf[EOptConstructor] )
//   //
//   (using toGetRemngLines : lscalg.cli.repl.DefinesGetRemainingLines[_Any, GrmSpclFileReadPtr1.ContentLines ] )
//   (using lscalg.bnfParsing.BnrpDoComposeAdvancement[_Any, ([CL] =>> (CL => CL ) )[GrmSpclFileReadPtr1.ContentLines ] ] )
//   //
//   (using forRImpl : (
//     GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
//       [_Any, util.matching.Regex , VO_EOptConstructor.value._Any ]
//   ) )
//   (using forLiteralImpl :(
//     // TODO
//     GrmPtrStrMatchOpTraits1.ForImmediateLiteral._AnyForReceiverAndSpecAndReturnBaseType
//       [_Any, String , VO_EOptConstructor.value._Any ]
//   ) )
//   //
// : AnyRef with
// {
//   ;
// 
//   transparent inline
//   def SpclAfterDigestTupleOption
//   = VO_EOptConstructor.value._Impl1 : VO_EOptConstructor.value._Impl1.type
// 
//   ;
// 
//   val iemiOpsR
//   : forRImpl.type
//   = valueOf
// 
//   // export iemiOpsR.{*}
// 
//   val iemiOpsL
//   : forLiteralImpl.type
//   = valueOf
// 
//   // export iemiOpsL.{*}
// 
//   ;
// 
//   val iemiOpsZeroLengthMatching
//   : GrmPtrStrMatchOpTraits1.forZeroLengthMatchingImpl[_Any, iemiOpsR.type ]
//   = GrmPtrStrMatchOpTraits1.forZeroLengthMatching[_Any]
// 
//   export iemiOpsZeroLengthMatching.{*}
// 
//   val iemiOpsEofs
//   : GrmPtrStrMatchOpTraits1.forEofMatchingImpl[_Any, toGetRemngLines.type ]
//   = GrmPtrStrMatchOpTraits1.forEofMatching[_Any]
// 
//   export iemiOpsEofs.{*}
// 
//   ;
// 
//   ;
// }
export lscalg.bnfParsing.spclCommonLookaheadCaps.forLanguageAgnosticPrimitves1 as grmForLanguageAgnosticPrimitves1












