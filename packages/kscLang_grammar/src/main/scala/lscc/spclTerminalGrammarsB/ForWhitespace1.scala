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

    prsWhitespaceableHeadTailConcatOp1
  }

  // public
  given prsWhitespaceableHeadTailConcatOp
    //
    (using ctx : lscc.spclParsedConstructs1.SpclGrammaticalPxery )
  : (AnyRef & lscalg.parsing.PHTCOAlt[ctx.givenFispoSupp.InputState, ctx.givenFispoSupp.InputState] )
  = {
    import ctx.given

    prsWhitespaceableHeadTailConcatOp1
  }

  private
  given prsWhitespaceableHeadTailConcatOp1
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.InputState, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
  : (AnyRef & lscalg.parsing.PHTCOAlt[ec.InputState, ec.InputState] )
  = new AnyRef with lscalg.parsing.PHTCOAlt[ec.InputState, ec.InputState] {
    ;

    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1

    import lscalg.parsing.subjectConcatOps1.prsHeadTailConcatOp.{+%: as &&: }

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
        (impl &&: (ForSingleLineWhitespace( ) ) &&: implRhs )
        .mapMainValue({ case (cLhs, sp, cRhs : (RhsVal & Tuple) ) => {
          cLhs *: cRhs
        } })
        .match { case e => e }
      }
    }

    ;
  }
}







