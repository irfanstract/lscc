package lscc.spclGrammar.forTermOrTypeLevelExprs















object Aitl {
  ;

  type _Any
  = Aitl

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

  type ForGrammaticalCtxT
    [+Ctx <: lscc.spclParsedConstructs1.SpclGrammaticalPxery ]
  = _Any { val ctx1 : Ctx }

  ;
}

trait Aitl protected[Aitl] () {
  ;

  implicit
  val ctx1
  : lscc.spclParsedConstructs1.SpclGrammaticalPxery

  /**
   * KeywordingCtx for
   * *words to be treated as keywords when-and-only-when occurring unprefixed and not part of selection (ie `a.b.c.d`)*
   * 
   */
  // implicit
  val spclUnprefixedKeywdingMode
  : lscc.spclGrammar.KeywordingCtx.WithGivenFispoSupp[ctx1.givenFispoSupp.type ]

  /**
   * KeywordingCtx for
   * *words to be treated as keywords when-and-only-when occurring as part of selection (ie `a.b.c.d`)*
   * 
   */
  final
  lazy
  val spclDotQualifiedKeywdingMode
  : lscc.spclGrammar.KeywordingCtx.WithGivenFispoSupp[ctx1.givenFispoSupp.type ]
  = spclUnprefixedKeywdingMode

  ;
}









