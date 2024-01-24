package lscc.spclGrammar.forTermOrTypeLevelExprs















object Aitl {
  ;

  def forTermLevel
    //
    (using ctx : lscc.spclParsedConstructs1.SpclGrammaticalPxery )
    ( )
  = new Aitl {
    ;

    val ctx1
    : ctx.type
    = ctx

    val spclUnprefixedKeywdingMode
    = XTermLevelUnprefixedKeyword()

  }

  def forTypeLevel
    //
    (using ctx : lscc.spclParsedConstructs1.SpclGrammaticalPxery )
    ( )
  = new Aitl {
    ;

    val ctx1
    : ctx.type
    = ctx

    val spclUnprefixedKeywdingMode
    = XTypeLevelUnprefixedKeyword()

  }

  ;
}

trait Aitl protected[Aitl] () {
  ;

  implicit
  val ctx1
  : lscc.spclParsedConstructs1.SpclGrammaticalPxery

  implicit
  val spclUnprefixedKeywdingMode
  : lscc.spclGrammar.KeywordingCtx.WithGivenFispoSupp[ctx1.givenFispoSupp.type ]

  ;
}









