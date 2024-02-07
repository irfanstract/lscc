package lscc.spclParsedConstructs1


















;




;





;

// object ForUnderscoreWildcardDefOnly {
//   ;

//   import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
//   import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

//   /**
//    * `__`
//    * 
//    */
//   def apply
//     //
//     (using ctx: SpclGrammaticalPxery )
//     (using kwIngCtx : lscc.spclGrammar.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
//     ()
//   : ctx.SpclSdfYielding[UnderscoreWildcardPatternImpl._Any ]
//   = ({
//     ;

//     import ctx.given

//     lscc.spclGrammar.forDefKeywdedMethodDecls.UnderscoreWildcardPatternPrf.apply()
//     .match { case f => f : ctx.SpclSdfYieldingUnwrapped[String ] }
//     .mapMainValue(UnderscoreWildcardPatternImpl.forExactSrcLevelToken(_) )
//     .withFinalPtrPosVl()

//     .withLogging1(mainMsg = s"ForUnderscoreWildcardDefOnly(${kwIngCtx })")
//   }).nn

//   ;
// }

export lscc.spclGrammar.forDefKeywdedMethodDecls.UnderscoreWildcardDefOnly1 as ForUnderscoreWildcardDefOnly

export lscc.spclGrammar.forDefKeywdedMethodDecls.UnderscoreWildcardPatternImpl




export lscc.spclGrammar.forDefKeywdedMethodDecls.ForValDefOnly as ForValDefOnly

export lscc.spclGrammar.forTermOrTypeLevelExprs.ValDefOnlyAst






export lscc.spclGrammar.forDefKeywdedMethodDecls.UnparenthesedSimpleHeadBindingExprPrf as ForUnparenthesedSimpleHeadBindingExpr

// object ForUnparenthesedSimpleHeadBindingExpr {
//   ;

//   def apply
//     //
//     (using ctx: SpclGrammaticalPxery )
//     (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
//     ()
//   : ctx.SpclSdfYielding[PrefixScrutLhsExpr ]
//   = {
//     ;

//     import ctx.given

//     import ctx.givenFispoSupp

//     import ctx.givenFispoSupp.InputState as PAny

//     import lscalg.parsing.ParseFunction.returnedMainValueMapOpImplicits.given
//     import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

//     ;

//     (
//       ForValDefOnly().map(_.value )
//       .map(e => {
//         PrefixScrutLhsExpr.ForValDef(e) : PrefixScrutLhsExpr.ForValDef
//       } )

//       orElse

//       ForUnderscoreWildcardDefOnly().map(_.value )
//       .map(e => {
//         PrefixScrutLhsExpr.ForIgnorableWildcard() : PrefixScrutLhsExpr.ForIgnorableWildcard
//       } )
//     )
//     .withFinalPtrPosVl()
//     .withLogging1(mainMsg = s"ForUnparenthesedSimpleHeadBindingExpr")
//   }.nn

//   ;
// }












