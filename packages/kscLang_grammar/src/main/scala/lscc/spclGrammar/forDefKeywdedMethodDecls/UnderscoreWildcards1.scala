package lscc.spclGrammar.forDefKeywdedMethodDecls








object UnderscoreWildcardPatternPrf
{
  ;

  import lscc.spclTerminalGrammarsB.SpclPxery

  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp

  // import lscalg.parsing.Subject.returnedMainValueMapOpExtras.returnedMainValueMapOp1

  import IRegExp.tagImplicits.{r}

  import lscc.spclTerminalGrammarsB.ForInlineTerminalLiteral1

  final
  lazy
  val SUnderscore
  = """_+""".r

  // TODO
  // protected
  def apply
    //
    (using ctx : SpclPxery )
    ( )
  : ctx.SpclSdfYieldingUnwrapped[String ]
  = ({
    ForInlineTerminalLiteral1(SUnderscore )
    .mapMainValue({ case v => "__" } )
  }).nn

  ;
}











