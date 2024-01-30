package lscc.spclTerminalGrammarsB



















object ForSingleLineWhitespace
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  import BnfCompatibleFileReadPtr1 as BC

  import IRegExp.tagImplicits.{r}

  // TODO
  // protected
  def apply
    //
    (using ctx : SpclPxery )
    ( )
  : ctx.SpclSdfYieldingUnwrapped[ctx.givenFispoSupp.SpclMatchContent ]
  = {
    ;

    ForImmediateSingleLineMatchOf("""\s+""".r )
  }

  ;
}



object fwscImplicits {
  ;

  // TODO
  given prsWhitespaceableHeadTailConcatOp0
    //
    (using ctx : lscc.spclParsedConstructs1.SpclGrammaticalPxery )
  : (AnyRef & lscalg.parsing.PHTCOAlt[ctx.givenFispoSupp.InputState, ctx.givenFispoSupp.InputState] )
  = {
    import ctx.given

    prsWhitespaceableHeadTailConcatOpEx
  }

  // public
  given prsWhitespaceableHeadTailConcatOp
    //
    (using ctx : lscc.spclParsedConstructs1.SpclGrammaticalPxery )
  : (AnyRef & lscalg.parsing.PHTCOAlt[ctx.givenFispoSupp.InputState, ctx.givenFispoSupp.InputState] )
  = {
    prsWhitespaceableHeadTailConcatOpEx
  }

  // public
  protected
  def prsWhitespaceableHeadTailConcatOpEx
    //
    (using ctx : lscc.spclParsedConstructs1.SpclGrammaticalPxery )
    (using regulSPa : lscc.spclTerminalGrammarsB.SpclPxery { val givenFispoSupp: ctx.givenFispoSupp.type } = lscc.spclTerminalGrammarsB.SpclPxery.makeFromGrammaticalCaseManif )
  : (AnyRef & lscalg.parsing.PHTCOAlt[ctx.givenFispoSupp.InputState, ctx.givenFispoSupp.InputState] )
  = {
    import ctx.given

    prsWhitespaceableHeadTailConcatOp1
  }

  private
  given prsWhitespaceableHeadTailConcatOp1
    //
    (using ctx1 : lscc.spclParsedConstructs1.SpclGrammaticalPxery )
    (using ec : (
      // lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any
      ctx1.givenFispoSupp.type
    ) )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.InputState, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    (using regulSPa : lscc.spclTerminalGrammarsB.SpclPxery { val givenFispoSupp: ec.type } )
    (using ValueOf[ec.SpclAfterDigestTupleOption.type ])
  : (AnyRef & lscalg.parsing.PHTCOAlt[ec.InputState, ec.InputState] )
  = new AnyRef with lscalg.parsing.PHTCOAlt[ec.InputState, ec.InputState] {
    ;

    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1

    // import lscalg.parsing.subjectConcatOps1.prsHeadTailConcatOp.{+%: as &&: }
    import lscalg.parsing.subjectConcatOps1.prsSuccessionalOps.{andThenAlso as &&: }
    import lscalg.parsing.subjectConcatOps1.prsHeadTailConcatOp.{+%: as /&&: }
    import lscalg.parsing.subjectConcatOps1.prsZipOps.{zip as +/&&: }

    import lscalg.parsing.ParseFunction

    extension [
      //
      ReceiT >: ec.InputState <: ec.InputState ,
      LhsVal,
    ] (impl: ParseFunction.ForReceiverAndRValue[ReceiT, LhsVal] )
    {
      //

      def +%:
        [
          RhsVal ,
        ]
        (implRhs : => ParseFunction.ForReceiverAndRValue[ReceiT, RhsVal] )
        (using RVT : RhsVal <:< Tuple )
      : ParseFunction.ForReceiverAndRValue[ReceiT, (LhsVal *: (RhsVal & Tuple ) ) ]
      = ParseFunction.lazily {
        ;

        val delimitingOptWhitespaceRule
        = {
          ;
          ForSingleLineWhitespace( )
          .withLogging1(mainMsg = s"prsWhitespaceableHeadTailConcat.DelimitingWhitespace")
        }

        // (impl &&: delimitingOptWhitespaceRule &&: implRhs )
        // (impl /&&: delimitingOptWhitespaceRule +/&&: implRhs )
        (impl /&&: delimitingOptWhitespaceRule /&&: implRhs /&&: lscalg.digestivity.ParseFunction.emptyTupleValuedInstance[ReceiT] )

        .withLogging1(mainMsg = s"prsWhitespaceableHeadTailConcat.L140")

        .mapMainValue(<:<.refl )
        .mapMainValue({ case (cLhs, sp, cRhs : (RhsVal & Tuple) ) => {
          cLhs *: cRhs
        } })

        .withLogging1(mainMsg = s"prsWhitespaceableHeadTailConcat.L147")

        .match { case e => e }
      }
    }

    ;
  }
}







