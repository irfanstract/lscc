package lscc.spclParsedConstructs1


val _ = {}
















;

// protected // TODO
// object ForChainedInfixOpFullExpr {
//   ;

//   import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
//   import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

//   /**
//    * `__`
//    * 
//    */
//   def apply
//     //
//     (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
//     (using apMode : SpclApm.withPtrTRange[givenFispoSupp.InputState, givenFispoSupp.InputState ] )
//     (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
//     (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.InputState, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
//     ()
//   // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState , apMode.AppliedTo[UnderscoreWildcardPatternImpl._Any ] ]
//   = ???

//   ;
// }




// def ForChainedInfixOpItemExpr
//   //
//   (using g : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
//   (using a : SpclApm.withPtrTRange[g.InputState, g.InputState ] )
// = {
//   new AnyRef with ForChainedInfixOpItemExprImpl {
//     //

//     implicit val givenFispoSupp
//     : g.type
//     = g

//     implicit val apMode
//     : a.type
//     = a

//   }
// }

// type ParsedChainedInfixOpItemExpr
// = ForChainedInfixOpItemExprImpl#ParsedChainedInfixOpItemExpr

// // protected // can't be 'protected' since there's no other way to reference the inner path-dependable stuffs
// // trait
// trait ForChainedInfixOpItemExprImpl
// { ForChainedInfixOpItemExpr =>
//   ;

//   implicit val givenFispoSupp
//   : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any

//   implicit val apMode
//   : SpclApm.withPtrTRange[givenFispoSupp.InputState, givenFispoSupp.InputState ]

//   ;

//   def apply
//     //
//     (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
//     (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.InputState, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
//     ()
//   // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState, apMode.AppliedTo[PrefixScrutLhsExpr ] ]
//   : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState, apMode.AppliedTo[ParsedChainedInfixOpItemExpr ] ]
//   = {
//     ;

//     import givenFispoSupp.InputState as PAny

//     import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
//     import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

//     ;

//     (
//       ForSingleTokenLiteralExpr()
//       .map(e => (
//         e.map(e => (
//           ParsedChainedInfixOpItemExpr.ForSingleTokenLiteralExpr(e )
//         ))
//       ) )

//       orElse

//       ForInfixOpEdCompoundSelectExpr()
//       .map(e => {
//         e.map(e => (
//           ParsedChainedInfixOpItemExpr.ForCompoundSelectExpr(e)
//         ) )
//       } )
//     )
//     .nn
//   }

//   ;

//   // TODO
//   enum ParsedChainedInfixOpItemExpr
//   {
//     case ForCompoundSelectExpr(e: IInfixOpEdCompoundSelectExpr )
//     case ForSingleTokenLiteralExpr(value: ISingleTokenLiteralExpr )
//   }

//   ;
// }

// def ForInfixOpEdCompoundSelectExpr
//   //
//   (using g : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
//   (using a : SpclApm.withPtrTRange[g.InputState, g.InputState ] )
// = {
//   new AnyRef with ForInfixOpEdCompoundSelectExprImpl {
//     //

//     implicit val givenFispoSupp
//     : g.type
//     = g

//     implicit val apMode
//     : a.type
//     = a

//   }
// }

// // TODO
// type IInfixOpEdCompoundSelectExpr
// = ForInfixOpEdCompoundSelectExprImpl#IInfixOpEdCompoundSelectExpr

// // protected // can't be 'protected' since there's no other way to reference the inner path-dependable stuffs
// // trait
// trait ForInfixOpEdCompoundSelectExprImpl
// { ForInfixOpEdCompoundSelectExpr =>
//   ;

//   implicit val givenFispoSupp
//   : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any

//   implicit val apMode
//   : SpclApm.withPtrTRange[givenFispoSupp.InputState, givenFispoSupp.InputState ]

//   import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
//   import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

//   /**
//    * expr like `bar1.bar2.bar3` being an item of a chain of infix op
//    * 
//    */
//   def apply
//     //
//     (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
//     (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.InputState, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
//     ()
//   // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState , apMode.AppliedTo[UnderscoreWildcardPatternImpl._Any ] ]
//   : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState , apMode.AppliedTo[IInfixOpEdCompoundSelectExpr ] ]
//   = {
//     // TODO

//     import givenFispoSupp.InputState as PAny

//     import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
//     import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

//     import fwscImplicits.prsWhitespaceableHeadTailConcatOp

//     (
//       ForSingleTokenLiteralExpr()
//       .map(_.value)
//       .map(e => (
//         IInfixOpEdCompoundSelectExpr.TermI(e)
//       ) )

//       orElse

//       (
//         ForInfixOpEdCompoundSelectExpr()

//         +%:

//         lscc.spclParsedConstructs1.KeywordingCtx.withSp({
//           // TODO
//           kwIngCtx
//         })({
//           ForOccurringKeywordOrRefP()
//         })

//         +%:

//         lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
//       )
//       // TODO
//       .collect({ case (receiverWr *: Identifier(tail) *: _ ) => ({
//         val receiver = receiverWr.value
//         // TODO
//         IInfixOpEdCompoundSelectExpr.SuccI(receiver, tail )
//       }) })
//     )
//     .mapWithFinalPtrPosVl((e, pos) => (
//       e
//       .withSrcInfo(srcPosInfo = pos )
//     ) )
//     .nn
//   }

//   ;

//   enum IInfixOpEdCompoundSelectExpr {
//     case TermI(l: ISingleTokenLiteralExpr )
//     case SuccI(l: IInfixOpEdCompoundSelectExpr, r: String )
//   }

//   ;
// }





// // TODO
// object ForSingleTokenLiteralExpr
// {
//   ;

//   ;

//   def apply
//     //
//     (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
//     (using apMode : SpclApm.withPtrTRange[givenFispoSupp.InputState, givenFispoSupp.InputState ] )
//     (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
//     (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.InputState, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
//     ()
//   // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState , apMode.AppliedTo[IInfixOpEdCompoundSelectExpr ] ]
//   : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState , apMode.AppliedTo[ISingleTokenLiteralExpr ] ]
//   = {
//     ;

//     import givenFispoSupp.InputState as PAny
//     import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
//     import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

//     (
//       ForNumericLiteral1()
//       .map(_ => (
//         ISingleTokenLiteralExpr.ForNumeric()
//       ) )

//       // orElse

//       // ForOccurringKeywordOrRefP()
//       // .map(Some(_) )
//     )
//     // .map(_.value)
//     .mapWithFinalPtrPosVl((e, pos) => (
//       e
//       .withSrcInfo(srcPosInfo = pos )
//     ) )
//     .nn
//   }
//   ;
// }

// enum ISingleTokenLiteralExpr {
//   case ForNumeric()
// }

object ForSingleTokenLiteralExpr
{
  ;

  ;

  import lscalg.parsing.ParseFunction.returnedMainValueMapOpImplicits.given
  import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

  import lscalg.parsing.subjectConcatOps1.given

  /** to impose `prsWhitespaceableHeadTailConcatOp` */
  import fwscImplicits.prsWhitespaceableHeadTailConcatOp

  // TODO
  transparent inline
  def apply
    //
    (using ctx: SpclGrammaticalPxery )
    // (using flatCaseCtx : lscc.spclTerminalGrammarsB.SpclPxery )
    //
    (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
    //
    ( )
  : ctx.SpclSdfYielding[Any ]
  = { val flatCaseCtx = summon[lscc.spclTerminalGrammarsB.SpclPxery ] ; { import ctx.given ; given flatCaseCtx.type = flatCaseCtx ; {
    ;

    // TODO
    // import ctx.given

    val trn
    = summon[SpclOps]

    // TODO

    (
      ForNumericLiteral1()
      // .map(_ => (
      //   ISingleTokenLiteralExpr.ForNumeric()
      // ) )
      .map(_ => {
        FixedIdentifier("(numeric)")
      } )
      .withLogging1(mainMsg = "ForSingleTokenLiteralExpr.Numeric")

      orElse

      ({
        ;

        given kwdIngMode
        : m.spclUnprefixedKeywdingMode.type
        = m.spclUnprefixedKeywdingMode

        ForOccurringKeywordOrRefP()
        .collect({ case e @ FixedIdentifier(_) => {
          e
        } })
        // .map(Some(_) )
      })
      .withLogging1(mainMsg = "ForSingleTokenLiteralExpr.Ref")
    )
    // .map(_.value)
    .mapWithFinalPtrPosVl((e, pos) => (
      e
      .withSrcInfo(srcPosInfo = pos )
    ) )
    .withLogging1(mainMsg = "ForSingleTokenLiteralExpr")
    .nn
  }}}

  type SpclOps
  = SpclOpsStle

  // TODO
  trait SpclOpsStle
  { thisSpclTranslativeOps =>
    ;

    type Translated

    implicit
    val numericTranslator1
    : (
      lscc.spclGrammar.forBnsLiterals.IHexadecimalTranslatorI {
        type Extracted1
        <: thisSpclTranslativeOps.Translated

        ;
      }
    )

    def translateOccuringKeywdOrIdent
      //
      (c: Keyword[String] | FixedIdentifier[String ])
    : Translated

    ;
  }

  object SpclOpsStle
  {
    ;

    transparent inline
    given defaultFromCtxs
      //
      (using grammaticalPxey: SpclGrammaticalPxery )
      (using regularPxey: lscc.spclTerminalGrammarsB.SpclPxery { val givenFispoSupp : grammaticalPxey.givenFispoSupp.type } )
      //
      (using exprsMode: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[grammaticalPxey.type ] )
      //
    : SpclOpsStle
    = {
      ;
      new SpclOpsStle
      {
        ;

        opaque type Translated
        = Any

        val numericTranslator1
        = {
          lscc.spclGrammar.forBnsLiterals.IHexadecimalTranslatorI.idemInstance
          .nn
        }

        def translateOccuringKeywdOrIdent
          //
          (c: Keyword[String] | FixedIdentifier[String ])
        = c

        ;
      }
      .nn
      .nn
    }
  }

  ;
}







