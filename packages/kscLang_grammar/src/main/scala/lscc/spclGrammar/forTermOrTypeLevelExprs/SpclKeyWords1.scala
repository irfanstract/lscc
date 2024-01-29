package lscc.spclGrammar.forTermOrTypeLevelExprs
























// TODO
/** 
 * `ForTermLevelUnprefixedKeyword` --
 * only concerns the unprefixed usages of those "word"s .
 * 
 */
object XTermLevelUnprefixedKeyword
{
  ;

  import lscc.spclGrammar.{KeywordingCtx, FTLK}
  import lscc.spclTerminalGrammarsB.ForKwPre

  import lscc.spclTerminalGrammarsB.ForCzps

  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  // protected
  def apply
    //
    (using ctx : lscc.spclTerminalGrammarsB.SpclPxery )
    ( )
  : KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ]
  = {
    ;
    import ctx.given
    
    ({
      ;

      import IRegExp.tagImplicits.r

      // TODO
      FTLK((
        ForCzps()
        orElse
        ForKwPre("""ref|refs""".r )
      ))
    })
    .match { case r => {
      KeywordingCtx.fromFtlk(r)
    } }
  }.nn
}

/** 
 * `ForTypeLevelUnprefixedKeyword` --
 * only concerns the unprefixed usages of those "word"s .
 * 
 */
object XTypeLevelUnprefixedKeyword
{
  ;

  import lscc.spclGrammar.{KeywordingCtx, FTLK}
  import lscc.spclTerminalGrammarsB.ForKwPre

  import lscc.spclTerminalGrammarsB.ForCzps

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  def apply
    //
    (using ctx : lscc.spclTerminalGrammarsB.SpclPxery )
    ( )
  : KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ]
  = {
    ;
    import ctx.given

    ({
      ;

      import IRegExp.tagImplicits.r

      // TODO
      FTLK((
        ForCzps()
        orElse
        ForKwPre("""([_]+|)(object(?:ype|)|single(?:ton|type|t|)|match(?:es|))""".r )
      ))
    })
    .match { case r => {
      KeywordingCtx.fromFtlk(r)
    } }
  }.nn
}

// TODO
/** 
 * `ForTypeLevelNsDotQualifiedKeyword` --
 * only concerns the ns-dot-qualified usages of those "word"s .
 * 
 */
object XTypeLevelNsDotQualifiedKeyword
{
  ;

  import lscc.spclGrammar.{KeywordingCtx, FTLK}
  import lscc.spclTerminalGrammarsB.ForKwPre

  import lscc.spclTerminalGrammarsB.ForCzps

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  def apply
    //
    (using ctx : lscc.spclTerminalGrammarsB.SpclPxery )
    ( )
  : KeywordingCtx.WithGivenFispoSupp[ctx.givenFispoSupp.type ]
  = {
    ;
    import ctx.given
    
    ({
      ;

      import IRegExp.tagImplicits.r

      // TODO
      FTLK((
        ForCzps()
        orElse
        ForKwPre("""ref(?:)|object(?:ype|)|single(?:ton|type|t|)""".r )
      ))
    })
    .match { case r => {
      KeywordingCtx.fromFtlk(r)
    } }
  }.nn
}









