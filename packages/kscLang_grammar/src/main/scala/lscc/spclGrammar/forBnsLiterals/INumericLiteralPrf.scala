package lscc.spclGrammar.forBnsLiterals














object INumericLiteralPrf
{
  ;

  import lscc.spclTerminalGrammarsB.{SpclPxery }

  import lscc.spclTerminalGrammarsB.{ForTerminalLiteral1, ForInlineTerminalLiteral1 }

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  // TODO
  object ForNumericLiteral1 {
    ;

    // protected
    def applyAlt
      //
      (using ctx : SpclPxery )
      ( )
      (using trn: IHexadecimalTranslatorI.WithInputSuite[ctx.type] )
    : ctx.SpclSdfYieldingUnwrapped[trn.Extracted1 ]
    = {
      ;

      // TODO
      (
        ForBigDecimalLiteral1()
        orElse
        ForBigHexadecimalLiteral1()
      )

      .match { case r => r }
    }

    // protected
    // transparent inline
    def apply
      //
      (using ctx : SpclPxery )
      ( )
    : ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1 ]
    = {
      ;

      ({
        ;

        /* a work-around */
        given trn : (IHexadecimalTranslatorI.WithInputSuite[ctx.type] & IHexadecimalTranslatorI.RawMatchedStrBasedSpcImpl)
        = IHexadecimalTranslatorI.defaultInstanceFromPxery

        // TODO
        applyAlt()
        .match { case r => r : ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1 ] }
      })
    }
  }

  object ForBigDecimalLiteral1
  {
    ;

    import IRegExp.tagImplicits.{r}

    // TODO
    // protected
    def apply
      //
      (using ctx : SpclPxery )
      ( )
      (using trn : IHexadecimalTranslatorI.WithInputSuite[ctx.type] )
    //
    : ctx.SpclSdfYieldingUnwrapped[trn.Extracted1 ]
    =
      ForInlineTerminalLiteral1("""(?!0x)[0-9]+(\.[0-9]+)?([eE][+\-][0-9]+)?""".r )
      .mapMainValue({ case r => {
        ;
        trn.fromBigHexaDecimalMatch(r)
      } })

    ;
  }

  object ForBigHexadecimalLiteral1
  {
    ;

    import IRegExp.tagImplicits.{r}

    // TODO
    // protected
    def apply
      //
      (using ctx : SpclPxery )
      ( )
      (using trn : IHexadecimalTranslatorI.WithInputSuite[ctx.type] )
    : ctx.SpclSdfYieldingUnwrapped[trn.Extracted1 ]
    = ({
      ForInlineTerminalLiteral1("""0{1,5}x{1,5}((?:Neg)?(?:[0-9A-Za-z]+)(?:\.[0-9A-Za-z]+)?)""".r )
      .mapMainValue({ case r => {
        ;
        trn.fromBigHexaDecimalMatch(r)
      } })
    })

    ;
  }

  ;
}



/**
 * 
 * ad-hoc translative itc for the cases in `INumericLiteralPrf`
 * 
 */
trait IHexadecimalTranslatorI
{
  ;

  import lscc.spclTerminalGrammarsB.{SpclPxery }

  implicit
  val inputSuite
  : SpclPxery

  /**
   * for `ForBigHexadecimalLiteral1`
   */
  def fromBigHexaDecimalMatch
    //
    (v: inputSuite.SpclExtractedRawStr1 )
  : Extracted1

  /**
   * for `ForBigDecimalLiteral1`
   */
  def fromBigDecimalMatch
    //
    (v: inputSuite.SpclExtractedRawStr1 )
  : Extracted1

  type Extracted1

  ;
}

object IHexadecimalTranslatorI
{
  ;

  import lscc.spclTerminalGrammarsB.{SpclPxery }

  type _Any
  = IHexadecimalTranslatorI

  type WithInputSuite[+Ctx <: SpclPxery ]
  = _Any { val inputSuite: Ctx }

  trait RawMatchedStrBasedSpcImpl
  extends
  _Any
  {
    ;

    // TODO remove the lower-bounding
    override
    implicit
    val inputSuite
    : SpclPxery {
      type SpclExtractedRawStr1
      >: givenFispoSupp.SpclMatchContent
      <: givenFispoSupp.SpclMatchContent
    }

    override
    type Extracted1
    >: inputSuite.SpclExtractedRawStr1
    <: inputSuite.SpclExtractedRawStr1

    override
    def fromBigHexaDecimalMatch
      //
      (v: inputSuite.SpclExtractedRawStr1 )
    : Extracted1
    = v

    override
    def fromBigDecimalMatch
      //
      (v: inputSuite.SpclExtractedRawStr1 )
    : Extracted1
    = v

    ;
  }

  @deprecated("selection of `IHexadecimalTranslatorI` are supposed to be explicit.")
  implicit
  transparent inline
  def defaultInstanceFromPxery
    (using ctx : SpclPxery)
  : WithInputSuite[ctx.type ] & RawMatchedStrBasedSpcImpl
  = idemInstance

  // TODO
  def idemInstance
    (using ctx : SpclPxery)
  : WithInputSuite[ctx.type ] & RawMatchedStrBasedSpcImpl
  = new RawMatchedStrBasedSpcImpl {
    ;

    implicit
    val inputSuite
    : ctx.type
    = ctx

  }

  ;
}







