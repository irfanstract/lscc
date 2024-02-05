package lscc.spclTerminalGrammarsB













// TODO
@deprecated
object ForCzps
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  // protected
  def apply
    //
    (using ctx : lscc.spclTerminalGrammarsB.SpclPxery )
    ( )
  = {
    ;
    import IRegExp.tagImplicits.r

    // TODO
    ((
      ForCondZeroParticulars()
      orElse
      ForCondZeroNouns()
    ))
  }.nn
}




// TODO
transparent inline
def ForCondZeroParticulars
= ForCondZeroPrepositionates

object ForCondZeroPrepositionates
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  // protected
  def apply
    //
    (using ctx : lscc.spclTerminalGrammarsB.SpclPxery )
    ( )
  = {
    ;
    import IRegExp.tagImplicits.r

    // TODO
    ((
      lscc.spclGrammar.KeywordPrf.forWordlikeContentByPattern("""fi|do|if|for|while|until|case|not|(?:do|does|done|did)|(?:is|are|was|were)""".r )
    ))
  }
}




// TODO
object ForCondZeroNouns
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1
  import lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp

  // protected
  def apply
    //
    (using ctx : lscc.spclTerminalGrammarsB.SpclPxery )
    ( )
  = {
    ;
    import IRegExp.tagImplicits.r

    // TODO
    ((
      ForCondZeroModifiers()
      orElse
      ForCondZeroPronouns()
      orElse
      ForCondZeroDataTypeKwds()
    ))
  }.nn

}

final
lazy val ForCondZeroModifiers
: SpclKeyWordsPrfConstructor.ForMono1
= {
  SpclKeyWordsPrfConstructor.forMonoByIRegExp({
    ;
    import lscalg.bnfParsing.IRegExp, IRegExp.tagImplicits.r
    """case""".r
  })
}

object ForCondZeroPronouns
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1
  import lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp

  // protected
  def apply
    //
    (using ctx : lscc.spclTerminalGrammarsB.SpclPxery )
    ( )
  = {
    ;
    import IRegExp.tagImplicits.r

    // TODO
    ((
      lscc.spclGrammar.KeywordPrf.forContentPattern("""none|some|this|that""".r )
    ))
  }

}

final
lazy val ForCondZeroDataTypeKwds
: SpclKeyWordsPrfConstructor.ForMono1
= {
  SpclKeyWordsPrfConstructor.forMonoAs(ctx1 ?=> {
    ;

    // TODO
    ((
      ForCondZeroIjftTypeKwds()
      orElse
      ForCondZeroClassTraitInterfaceTypeKwds()
    ))
  })
}

final
lazy val ForCondZeroIjftTypeKwds
: SpclKeyWordsPrfConstructor.ForMono1
= {
  SpclKeyWordsPrfConstructor.forMonoByIRegExp({
    ;
    import lscalg.bnfParsing.IRegExp, IRegExp.tagImplicits.r
    """(?>(_*(?:int|fl|float|raty|ra|quant|qua|qty)|_+[FIJBZijkldfarcbzx]))(\d+)\b""".r
  })
}

final
lazy val ForCondZeroClassTraitInterfaceTypeKwds
: SpclKeyWordsPrfConstructor.ForMono1
= {
  SpclKeyWordsPrfConstructor.forMonoByIRegExp({
    ;
    import lscalg.bnfParsing.IRegExp, IRegExp.tagImplicits.r
    """(?:const|cons|con|co|val|let|var|va|tr|tra|trait|cl|cl[a]|cla+s+|ob|obj|obje|obje[ck]t*)\b""".r
  })
}




;

object SpclKeyWordsPrfConstructor
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1
  import lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp

  // TODO
  def forMonoAs
    (impl: (ctx : lscc.spclTerminalGrammarsB.SpclPxery ) ?=> ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1] )
  : ForMono1
  = {
    new ForMono1
    {
      def apply
        (using ctx : lscc.spclTerminalGrammarsB.SpclPxery ) ()
      = impl.nn
    }
  }.nn

  // transparent inline
  def forMonoByIRegExp
    (p: IRegExp._Any )
  : ForMono1
  = {
    forMonoAs {
      lscc.spclGrammar.KeywordPrf.forContentPattern(p )
    }
  }

  trait ForMono1
  {
    def apply
      //
      (using ctx : lscc.spclTerminalGrammarsB.SpclPxery )
      ()
    : ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1]
  }

  //   (using ctx : lscc.spclGrammar.Ikpm )
  //   ( )
  // : ctx.Applied

  ;
}












