package lscc.spclTerminalGrammarsB













// TODO
@deprecated
final
lazy val ForCzps
: SpclKeyWordsPrfConstructor.ForMono1
= {
  SpclKeyWordsPrfConstructor.forMonoAs(ctx1 ?=> {
    ;

    // TODO
    ((
      ForCondZeroParticulars()
      orElse
      ForCondZeroNouns()
    ))
  })
}





// TODO
transparent inline
def ForCondZeroParticulars
= ForCondZeroPrepositionates

// TODO
final
lazy val ForCondZeroPrepositionates
: SpclKeyWordsPrfConstructor.ForMono1
= {
  SpclKeyWordsPrfConstructor.forMonoByIRegExp({
    ;
    import lscalg.bnfParsing.IRegExp, IRegExp.tagImplicits.r
    """fi|do|if|for|while|until|case|not|(?:do|does|done|did)|(?:is|are|was|were)""".r
  })
}






// TODO
final
lazy val ForCondZeroNouns
: SpclKeyWordsPrfConstructor.ForMono1
= {
  SpclKeyWordsPrfConstructor.forMonoAs(ctx1 ?=> {
    ;

    // TODO
    ((
      ForCondZeroModifiers()
      orElse
      ForCondZeroPronouns()
      orElse
      ForCondZeroDataTypeKwds()
    ))
  })
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

final
lazy val ForCondZeroPronouns
: SpclKeyWordsPrfConstructor.ForMono1
= {
  SpclKeyWordsPrfConstructor.forMonoByIRegExp({
    ;
    import lscalg.bnfParsing.IRegExp, IRegExp.tagImplicits.r
    """none|some|this|that""".r
  })
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

  trait ForMono1
  {
    def apply
      //
      (using ctx : lscc.spclGrammar.Ikpm )
      ( )
    : ctx.Applied
  }

  // TODO
  def forMonoAs
    (impl: (
      // (ctx : lscc.spclTerminalGrammarsB.SpclPxery ) ?=>
      //   ctx.SpclSdfYieldingUnwrapped[ctx.SpclExtractedRawStr1]

      (ctx : lscc.spclGrammar.Ikpm ) ?=>
        ctx.Applied
    ) )
  : ForMono1
  = {
    new ForMono1
    {
      def apply
        (using ctx : lscc.spclGrammar.Ikpm )
        ( )
      : ctx.Applied
      = impl.nn
    }
  }.nn

  // transparent inline
  def forMonoByIRegExp
    (p: IRegExp._Any )
  : ForMono1
  = {
    forMonoAs(ctx ?=> {
      ctx.fromRegExp(p)
    })
  }

  //   (using ctx : lscc.spclGrammar.Ikpm )
  //   ( )
  // : ctx.Applied

  ;
}












