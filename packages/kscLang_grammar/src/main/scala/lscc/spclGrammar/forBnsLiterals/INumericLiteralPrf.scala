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
    def apply
      //
      (using ctx : SpclPxery )
      ( )
    : ctx.SpclSdfYieldingUnwrapped[ctx.SpclMatchContent1 ]
    = {
      // TODO
      (
        ForBigDecimalLiteral1()
        orElse
        ForBigHexadecimalLiteral1()
      )
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
    : ctx.SpclSdfYieldingUnwrapped[ctx.SpclMatchContent1 ]
    = ForInlineTerminalLiteral1("""(?!0x)[0-9]+(\.[0-9]+)?([eE][+\-][0-9]+)?""".r )

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
    : ctx.SpclSdfYieldingUnwrapped[ctx.SpclMatchContent1 ]
    = ({
      ForInlineTerminalLiteral1("""0{1,5}x{1,5}((?:Neg)?(?:[0-9A-Za-z]+)(?:\.[0-9A-Za-z]+)?)""".r )
    })

    ;
  }

  ;
}







