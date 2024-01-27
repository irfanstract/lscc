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

object ForCondZeroModifiers
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
      lscc.spclGrammar.KeywordPrf.forContentPattern("""case""".r )
    ))
  }

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

object ForCondZeroDataTypeKwds
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
      ForCondZeroIjftTypeKwds()
      orElse
      ForCondZeroClassTraitInterfaceTypeKwds()
    ))
  }.nn

}

object ForCondZeroIjftTypeKwds
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
      lscc.spclGrammar.KeywordPrf.forContentPattern("""(_*(?:fl|float|int|ra)|_+[FIJBZijkldfarcbzx])(\d+)\b""".r )
    ))
  }.nn

}

object ForCondZeroClassTraitInterfaceTypeKwds
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
      lscc.spclGrammar.KeywordPrf.forContentPattern("""(?:tr|tra|trait|cl|cl[a]|cla+s+|ob|obj|obje|obje[ck]t*)\b""".r )
    ))
  }

}












