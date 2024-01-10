package lscc.spclParsedConstructs1


















;




/** 
 * type-ascriptive suffix operator -- one of `: T` or `@ t`
 * 
 */
object ForScrutSyntactic
{
  ;

  import lscalg.parsing.subjectConcatOps1.given

  def apply
    //
    //
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using apMode : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ] )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , Keyword[String] ]
  = {
    ;

    import givenFispoSupp.T as PAny

    ({
      ;

      /** `WithFilter` */
      import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
      import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

      (
        ForOccurringKeywordOrRef()
        .mapWithFinalPtrPosVl({ case (scrutMode @ (Keyword( ("@" | ":" ) ) ) , srcPos ) => {
          scrutMode
          .withSrcInfo(srcPosInfo = srcPos )
        } } )

        +%:

        lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
      )
    })
  }

  ;
}





object ForValDefExpr
{
  ;

  // val kwIngCtx
  // = ForTermLevelUnprefixedKeyword()

  ;

  /**
   * `val example1 @ (expr)`, `val exampleSome : T`
   * 
   */
  def apply
    //
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using apMode : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ] )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , FvdParsed._Any ]
  = {
    ;

    import givenFispoSupp.T as PAny

    ({
      ;

      /** 
       * impose
       * altered definition of the WithFilter ops, which is better for this usage.
       * 
       */
      import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
      import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

      ({
        ;

        ({
          ;
          import lscalg.parsing.subjectConcatOps1.given

          (
            ForValDefOnly()

            +%:

            ForScrutSyntactic()

            +%:

            lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
          )
          .map({ case (bindingExpr, s) => bindingExpr } )
        })
      })
    })
  }

  ;
}


object ForValDefOnly
{
  ;

  /**
   * `val example1`, `val exampleSome`
   * 
   */
  def apply
    //
    (using givenFispoSupp : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using apMode : SpclApm.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ] )
    (using kwIngCtx : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ] )
    ()
  // : lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , FvdParsed._Any ]
  = {
    ;

    import givenFispoSupp.T as PAny

    ({
      ;

      /** 
       * impose
       * altered definition of the WithFilter ops, which is better for this usage.
       * 
       */
      import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1
      import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1

      ({
        ;

        ({
          ;

          import lscalg.parsing.subjectConcatOps1.given

          (
            ForOccurringKeywordOrRef()
            .collect({ case iTypeKw @ (Keyword(iType @ ("val" | "const" | "let" ) )) => iTypeKw } )
            .mapWithFinalPtrPosVl({ case (vl, pos) => vl.withSrcInfo(srcPosInfo = pos) })

            +%:

            ForOccurringKeywordOrRef()
            .collect({ case (Identifier(ident)) => (ident ) } )
            .mapWithFinalPtrPosVl({ case (vl, pos) => vl.withSrcInfo(srcPosInfo = pos) })

            +%:

            // ForScrutSyntactic()

            // +%:
              
            lscalg.parsing.ParseFunction.emptyTupleValuedInstance[PAny]
          )
          .map({ case (iType, ident) => FvdParsed(ident = ident, iTypeKw = iType ) } )
        })
        .map({ case s => s } )
      })
    })
  }

  ;
}

object FvdParsed
{
  ;

  type _Any
  = FvdParsed[?, ?]

  ;
}

case class FvdParsed
  [
    +Ident,
    +IType ,
  ] (
    ident : Ident ,
    iTypeKw : IType ,
  )










