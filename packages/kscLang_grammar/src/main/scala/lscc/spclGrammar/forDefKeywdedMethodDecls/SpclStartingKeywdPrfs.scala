package lscc.spclGrammar.forDefKeywdedMethodDecls















object DefKeywdedMethodDeclStartingKeywdPrfs
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1
  import lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp

  // protected
  def apply
    //
    (using ctx : lscc.spclGrammar.Ikpm )
    ( )
  : ctx.Applied
  = {
    ;
    import IRegExp.tagImplicits.r

    // TODO
    ((
     ctx.fromRegExp((
        """(?:const|cons|con|co|val|let|var|va|def|alias|inline|virtual|term|extension|abstract)\b"""
        .r
      ))
    ))
  }

}






