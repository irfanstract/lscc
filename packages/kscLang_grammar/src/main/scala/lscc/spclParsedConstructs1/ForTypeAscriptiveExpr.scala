package lscc.spclParsedConstructs1

















// // TODO
// @deprecated
// protected
// object ForPrefixedScrutTermLvlExpr
// {
//   ;

//   import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
//   import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

//   /**
//    * `val example1 @ (expr)`, `val exampleSome : T`
//    * 
//    */
//   def apply
//     //
//     (using ctx: SpclGrammaticalPxery )
//     (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
//     ()
//   //
//   : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[ctx.givenFispoSupp.T , ScrutExprImpl.ForApmType[ctx.apMode.type ] ]
//   = (
//     ForPrefixedScrutTermLvlExprP()
//     .map(e => (
//       // e.value
//       ({ import ctx.apMode ; e.value })
//     ) )
//     .nn
//   )
// }

// object ForPrefixedScrutTermLvlExprP
// {
//   ;

//   // val kwIngCtx
//   // = ForTermLevelUnprefixedKeyword()

//   ;

//   /**
//    * `val example1 @ (expr)`, `val exampleSome : T`
//    * 
//    */
//   def apply
//     //
//     // (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
//     // (using apMode : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ] )
//     // (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
//     // (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
//     (using ctx: SpclGrammaticalPxery )
//     (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
//     ()
//   // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , ScrutExprImpl.ForApmType[apMode.type ] ]
//   : ctx.SpclSdfYielding[ScrutExprImpl.ForApmType[ctx.apMode.type ] ]
//   = {
//     ;

//     import ctx.given

//     import ctx.givenFispoSupp

//     import ctx.givenFispoSupp.T as PAny

//     import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
//     import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

//     ({
//       ;


//       ({
//         ;

//         ({
//           ;

//           import fwscImplicits.prsWhitespaceableHeadTailConcatOp

//           (
//             ForPsFirstBindingExpr()

//             +%:

//             ForScrutOperatorAndRhs()

//             +%:

//             lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
//           )
//           .map({ case (bindingExpr, s) => {
//             ScrutExprImpl(bindingSideExpr = bindingExpr, ascriptiveSideExpr = s )
//           } } )
//           .nn
//         })
//       })
//     })
//     .mapWithFinalPtrPosVl((vl, pos) => (
//       vl
//       .withSrcInfo(srcPosInfo = pos )
//     ) )
//     .nn
//   }

//   ;
// }

// object ScrutExprImpl {
//   ;

//   type _Any
//   = ScrutExprImpl[?]

//   def apply
//     //
//     (using apMode : SpclApm._Any )
//     (bindingSideExpr: apMode.AfterSi[PrefixScrutLhsExpr], ascriptiveSideExpr: apMode.AfterSi[AscriptiveExpr ] )
//   = new ScrutExprImpl((apMode, bindingSideExpr, ascriptiveSideExpr ) : (
//     (apMode.type, bindingSideExpr.type, ascriptiveSideExpr.type )
//   ) )

//   type _DataAny
//   = (
//     //

//     (SpclApm._Any, Any, Any ) {
//       ;
//       val _2 : _1.AfterSi[PrefixScrutLhsExpr]
//       val _3 : _1.AfterSi[AscriptiveExpr]
//     }
//   )

//   type ForApmType
//     [+T <: SpclApm._Any ]
//   = ScrutExprImpl[(
//     _DataAny
//     & Tuple3[T, ?, ?]
//   )]

//   ;
// }
// case class ScrutExprImpl
//   [+T <: ScrutExprImpl._DataAny ] private[ScrutExprImpl] (d: T )





// /** 
//  * type-ascriptive suffix operator -- one of `: T` or `@ t`
//  * 
//  */
// object ForScrutOperatorAndRhs
// { 
//   ;

//   import lscalg.parsing.subjectConcatOps1.given

//   def apply
//     //
//     //
//     // (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
//     // (using apMode : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ] )
//     // (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
//     // (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
//     (using ctx: SpclGrammaticalPxery )
//     (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
//     ()
//   // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T, apMode.AfterSi[AscriptiveExpr] ]
//   : ctx.SpclSdfYielding[AscriptiveExpr ]
//   = {
//     ;

//     import ctx.given

//     import ctx.givenFispoSupp

//     import ctx.givenFispoSupp.T as PAny

//     ({
//       ;

//       /** `WithFilter` */
//       import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
//       import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

//       /** to impose `prsWhitespaceableHeadTailConcatOp` */
//       import fwscImplicits.prsWhitespaceableHeadTailConcatOp

//       (
//         //

//         (
//           ForOccurringKeywordOrRefP()
//           .mapWithFinalPtrPosVl({ case (scrutMode @ (Keyword( kwd @ ("@" | "@") ) ) , srcPos ) => {
//             Keyword(kwd )
//             .withSrcInfo(srcPosInfo = srcPos )
//           } } )

//           +%:

//           ForQueryExpr()

//           +%:

//           lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
//         )
//         .map({ case (iTypeKw, vl) => {
//           // (iTypeKw, vl )
//           ToTermPatternScrutiveAscription(vl )
//         } })

//         orElse

//         (
//           ForOccurringKeywordOrRefP()
//           .mapWithFinalPtrPosVl({ case (scrutMode @ (Keyword( kwd @ (":" | ":") ) ) , srcPos ) => {
//             Keyword(kwd )
//             .withSrcInfo(srcPosInfo = srcPos )
//           } } )

//           +%:

//           KeywordingCtx.withSp(ForTypeLevelUnprefixedKeyword() ) {
//             ForQueryExpr()
//           }

//           +%:

//           lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
//         )
//         .map({ case (iTypeKw, vl) => {
//           // (iTypeKw, vl )
//           ToTypeScrutiveAscription(vl )
//         } })
//       )
//       .mapWithFinalPtrPosVl((value, srcPos) => (
//         value
//         .withSrcInfo(srcPosInfo = srcPos )
//       ) )
//     })
//     .nn
//     .nn
//   }

//   ;
// }

// trait AscriptiveExpr protected () {}

// case class ToTermPatternScrutiveAscription(main: Any )
// extends AscriptiveExpr

// case class ToTypeScrutiveAscription(t: Any )
// extends AscriptiveExpr

object ForPsFirstBindingExpr {
  ;

  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
    ()
  : ctx.SpclSdfYielding[PrefixScrutLhsExpr ]
  = {
    ;

    import ctx.given

    import ctx.givenFispoSupp

    import ctx.givenFispoSupp.T as PAny

    import lscalg.parsing.ParseFunction.returnedMainValueMapOpImplicits.given
    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

    ;

    (
      ForValDefOnly()
      .map(e => {
        e
        .map(e => (
          PrefixScrutLhsExpr.ForValDef(e) : PrefixScrutLhsExpr.ForValDef
        ) )
      } )

      orElse

      ForUnderscoreWildcardDefOnly()
      .map(e => {
        e
        .map(_ => (
          PrefixScrutLhsExpr.ForIgnorableWildcard() : PrefixScrutLhsExpr.ForIgnorableWildcard
        ) )
      } )
    )
  }.nn

  ;
}

enum PrefixScrutLhsExpr {
  ;

  case ForIgnorableWildcard()

  case ForValDef(value: FvdParsed._Any )

}









