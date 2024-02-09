package lscc.spclGrammar.forClassInterfaceClauseDefs















final
lazy val SpclStartingKeywdPrfs
: DefOrClassOrNamespaceClauselikeStartingKeywdPrfs.type
= DefOrClassOrNamespaceClauselikeStartingKeywdPrfs

@deprecated
final
lazy val DefKeywdedMethodDeclStartingKeywdPrfs
= DefOrClassOrNamespaceClauselikeStartingKeywdPrfs




object ClassOrNamespaceClauseStartingKeywdPrfs
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
      ctx.fromRegExp("""(?:tr|tra|trait|cl|cl[a]|cla+s+|ob|obj|obje|obje[ck]t*)\b""".r )
    ))
  }

}

object DefOrClassOrNamespaceClauselikeStartingKeywdPrfs
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1
  import lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp

  // protected
  def apply
    (using ctx : lscc.spclGrammar.Ikpm )
    ( )
  : ctx.Applied
  = {
    ;
    import IRegExp.tagImplicits.r

    // TODO
    // lscc.spclGrammar.KeywordPrf.forContentPattern("""(?:const|cons|con|co|val|let|var|va|tr|tra|trait|cl|cl[a]|cla+s+|ob|obj|obje|obje[ck]t*)\b""".stripMargin.r )
    ((
      lscc.spclGrammar.forDefKeywdedMethodDecls.DefKeywdedMethodDeclStartingKeywdPrfs()
      orElse
      lscc.spclGrammar.forClassInterfaceClauseDefs.ClassOrNamespaceClauseStartingKeywdPrfs.apply()
    ))
  }

}








