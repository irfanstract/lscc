package lscc.spclGrammar.forTermOrTypeLevelExprs















object Aitl {
  ;

  type _Any
  = Aitl

  /**
   * 
   * the term-level rules
   * 
   */
  def forTermLevel
    //
    (using ctx : lscc.spclParsedConstructs1.SpclGrammaticalPxery )
    ( )
  : ForGrammaticalCtxT[ctx.type]
  = new Aitl {
    ;

    val basePxery
    : ctx.type
    = ctx

    val spclUnprefixedKeywdingMode
    = XTermLevelUnprefixedKeyword()

  }

  /**
   * 
   * the base type-level rules.
   * 
   */
  def forTypeLevel
    //
    (using ctx : lscc.spclParsedConstructs1.SpclGrammaticalPxery )
    ( )
  : ForGrammaticalCtxT[ctx.type]
  = new Aitl {
    ;

    val basePxery
    : ctx.type
    = ctx

    val spclUnprefixedKeywdingMode
    = XTypeLevelUnprefixedKeyword()

  }

  type ForGrammaticalCtxT
    [+Ctx <: lscc.spclParsedConstructs1.SpclGrammaticalPxery ]
  = _Any { val basePxery : Ctx }

  ;
}

trait Aitl protected[Aitl] () {
  ;

  implicit
  val basePxery
  : lscc.spclParsedConstructs1.SpclGrammaticalPxery

  /**
   * KeywordingCtx for
   * *words to be treated as keywords when-and-only-when occurring unprefixed and not part of selection (ie `a.b.c.d`)*
   * 
   */
  // implicit
  val spclUnprefixedKeywdingMode
  : lscc.spclGrammar.KeywordingCtx.WithGivenFispoSupp[basePxery.givenFispoSupp.type ]

  /**
   * KeywordingCtx for
   * *words to be treated as keywords when-and-only-when occurring as part of selection (ie `a.b.c.d`)*
   * 
   */
  final
  lazy
  val spclDotQualifiedKeywdingMode
  : lscc.spclGrammar.KeywordingCtx.WithGivenFispoSupp[basePxery.givenFispoSupp.type ]
  = spclUnprefixedKeywdingMode

  ;
}









