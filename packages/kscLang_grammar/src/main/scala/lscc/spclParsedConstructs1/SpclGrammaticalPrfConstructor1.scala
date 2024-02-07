package lscc.spclParsedConstructs1








// /** 
//  * 
//  * *type-level reference to types*
//  * 
//  */
// object ForTypeRef
// {
//   ;

//   ;

//   import lscc.spclGrammar.KeywordingCtx

//   import lscc.spclParsedConstructs1.SpclGrammaticalPxery

//   transparent inline
//   def apply
//     //
//     (using ctx: SpclGrammaticalPxery )
//     //
//     (using kwIngCtx : KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ] )
//     ()
//   : ctx.SpclSdfYielding[Any ]
//   = {
//     // TODO
//     import ctx.given

//     ForQueryExpr1.withMode
//       (lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.forTypeLevel() )
//   }.nn

//   ;
// }






// /**
//  * 
//  * *either-level references*
//  * 
//  */
// object ForQueryExpr1
// {
//   ;

//   ;

//   import lscalg.parsing.ParseFunction.returnedMainValueMapOpImplicits.given
//   import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

//   import lscalg.parsing.subjectConcatOps1.given

//   import lscc.spclParsedConstructs1.SpclGrammaticalPxery

//   transparent inline
//   def withMode
//     //
//     (using ctx: SpclGrammaticalPxery )
//     //
//     (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
//   : ctx.SpclSdfYielding[Any ]
//   = {
//     given aitl
//     : m.type
//     = m

//     apply()
//   }

//   // TODO
//   // transparent inline
//   def apply
//     //
//     (using ctx: SpclGrammaticalPxery )
//     //
//     (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
//     //
//     ( )
//   : ctx.SpclSdfYielding[Any ]
//   = {
//     import m.spclUnprefixedKeywdingMode

//     // (
//     //   ForPrefixedExpr()
//     //   orElse
//     //   ForSingleTokenLiteralExpr()
//     // )

//     ???
//   }.nn

//   ;
// }






object SpclGrammaticalPrfConstructor
{
  ;

  import lscc.spclParsedConstructs1.SpclGrammaticalPxery

  trait WhichTakesELvlInfo private[SpclGrammaticalPrfConstructor] ()
  {
    //

    transparent inline
    def withMode
      //
      (using ctx: SpclGrammaticalPxery )
      //
      (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
    : ctx.SpclSdfYieldingUnwrapped[Any ]
    = {
      given aitl
      : m.type
      = m

      apply()
    }

    // TODO
    // transparent inline
    def apply
      //
      (using ctx: SpclGrammaticalPxery )
      //
      (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
      //
      ( )
    : ctx.SpclSdfYieldingUnwrapped[Any ]

  }

  def whichTakesELvlInfo
    //
    [T <: (Tuple2[SpclGrammaticalPxery, ? ] ) ]
    (impl : (
      (ctx: SpclGrammaticalPxery  ) ?=> (m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ]) ?=>
        (ctx.SpclSdfYieldingUnwrapped[(
          //
          // T
          (T & (ctx.type, Any ))
        )])
    ) )
  : WhichTakesELvlInfo {
    //

    def apply
      //
      (using ctx: SpclGrammaticalPxery )
      //
      (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
      //
      ( )
    : ctx.SpclSdfYieldingUnwrapped[T & (ctx.type, Any ) ]
  }
  = {
    ;
    new WhichTakesELvlInfo
    {
      ;

      def apply
        //
        (using ctx: SpclGrammaticalPxery )
        //
        (using m: lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.ForGrammaticalCtxT[ctx.type ] )
        //
        ( )
      : ctx.SpclSdfYieldingUnwrapped[T & (ctx.type, Any ) ]
      = {
        val r = impl

        import ctx.grmMetadataWrapMode

        // r.withSrcInfo()
        r
      }.nn
    }
    .nn
  }

  ;
}







