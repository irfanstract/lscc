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

  given prsWhitespaceableHeadTailConcatOp
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
  : (AnyRef & lscalg.parsing.PHTCOAlt[ec.T, ec.T] )
  = new AnyRef with lscalg.parsing.PHTCOAlt[ec.T, ec.T] {
    ;

    import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1

    import lscalg.parsing.subjectConcatOps1.prsHeadTailConcatOp.{+%: as &&: }

    import lscalg.parsing.ParseFunction

    extension [
      //
      ReceiT >: ec.T <: ec.T ,
      LhsVal,
    ] (impl: ParseFunction.ForReceiverAndRValue[ReceiT, LhsVal] )
    {
      //

      def +%:
        [
          RhsVal ,
        ]
        (implRhs : ParseFunction.ForReceiverAndRValue[ReceiT, RhsVal] )
        (using RVT : RhsVal <:< Tuple )
      : ParseFunction.ForReceiverAndRValue[ReceiT, (LhsVal *: (RhsVal & Tuple ) ) ]
      = {
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







