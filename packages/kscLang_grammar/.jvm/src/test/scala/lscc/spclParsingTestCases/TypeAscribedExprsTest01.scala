package lscc.spclParsingTestCases







class TypeAscribedExprsTest01
extends
org.scalatest.funsuite.AnyFunSuite
{
  ;

  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1 as SpclGrmPtr

  implicit
  object impl1
  {
    ;

    extension (r: lscc.spclParsing.spclUtil.Lrp._Any )
      //
      def atBgnPars()
      : SpclGrmPtr._Any
      = SpclGrmPtr.atBeginningOfSrcFile(r )

  }

  import lscc.spclTests.BasicGrammaticalPxeryImplicits.given

  import lscalg.parsing.subjectConcatOps1.given

  ;

  import language.unsafeNulls

  import lscalg.bnfParsing.IRegExp

  import IRegExp.tagImplicits.r

  private
  def withMode
    [M <: AnyRef, R ] (m: M) (run: (m.type) ?=> R )
  : R
  = run(using m )

  ;

  ;

  // test("underscore wildcard match") {
  //   ;

  //   ;

  //   lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("_ @ MainVariableExprImpl ; ")
  //   .atBgnPars()

  //   .match { case p => {
  //     ;

  //     ({
  //       ;

  //       p

  //       .match { case ptr0 => {
  //         lscc.spclTerminalGrammarsB.ForUnderscoreWildcardPattern()
  //         .applyBrt(ptr0)
  //       } }

  //     })
  //     .headOption
  //     .orElse({
  //       assert(!((p.remainingLines.head).contents startsWith "_" ) )

  //       None
  //     })
  //     .match { case r => {
  //       ;

  //       assert(r.nonEmpty )

  //       println(r )

  //     } }

  //     ;
  //   } }

  //   ;

  //   lscc.spclMeta.SpclAnyFunSuite.aftermathsUtil.printlnBanner(s"parsing of Expr `val MainVariableExpr @ MainVariableExprImpl ; `")
  // }

  // test("type-ascribed val-def") {
  //   ;

  //   import lscc.spclGrammar.{KeywordingCtx , forTermOrTypeLevelExprs }, forTermOrTypeLevelExprs.{Aitl }

  //   // implicit
  //   val exprMode
  //   = {
  //     Aitl.forTermLevel()
  //   }

  //   val headBindingRule
  //   = {
  //     ;

  //     ({
  //       given exprMode.type
  //       = exprMode
  //       given exprMode.spclUnprefixedKeywdingMode.type
  //       = exprMode.spclUnprefixedKeywdingMode
  //       lscc.spclParsedConstructs1.ForUnparenthesedSimpleHeadBindingExpr()
  //     })
  //   }

  //   val fullExprRule
  //   = {
  //     ;

  //     import lscc.spclTerminalGrammarsB.{ForInlineTerminalLiteral1, ForImmediateUnescapedWord }
  //     import lscc.spclParsedConstructs1.{ForBindingFirstTermOrTypeAscribedExprP }

  //     (
  //       withMode(Aitl.forTermLevel() ) ((
  //         ForBindingFirstTermOrTypeAscribedExprP( )
  //       ))
  //     )
  //   }

  //   ;

  //   lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("_ @ MainVariableExprImpl ; ")
  //   .atBgnPars()

  //   .match { case p => {
  //     ;

  //     ({
  //       ;

  //       p

  //       .match { case ptr0 => {
  //         headBindingRule
  //         .applyBrt(ptr0)
  //       } }

  //     })
  //     .headOption
  //     .orElse({
  //       assert(!((p.remainingLines.head).contents startsWith "_" ) )

  //       None
  //     })
  //     .match { case r => {
  //       ;

  //       assert(r.nonEmpty )

  //       println(r )

  //     } }

  //     ({
  //       ;

  //       p

  //       .match { case ptr0 => {
  //         fullExprRule
  //         .applyBrt(ptr0)
  //       } }

  //     })
  //     .headOption
  //     .orElse({
  //       assert(!((p.remainingLines.head).contents startsWith "_" ) )

  //       None
  //     })
  //     .match { case r => {
  //       ;

  //       assert(r.nonEmpty )

  //       println(r )

  //     } }

  //     ;
  //   } }

  //   lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("val MainVariableExpr @ MainVariableExprImpl ; ")
  //   .atBgnPars()

  //   .match { case p => {
  //     ;

  //     ({
  //       ;

  //       p

  //       .match { case ptr0 => {
  //         headBindingRule
  //         .applyBrt(ptr0)
  //       } }

  //     })
  //     .headOption
  //     .orElse({
  //       assert(!((p.remainingLines.head).contents startsWith "val " ) )

  //       None
  //     })
  //     .match { case r => {
  //       ;

  //       assert(r.nonEmpty )

  //       println(r )

  //     } }

  //     ({
  //       ;

  //       p

  //       .match { case ptr0 => {
  //         fullExprRule
  //         .applyBrt(ptr0)
  //       } }
  //     })
  //     .match { case r => {
  //       ;

  //       assert(r.nonEmpty )

  //       println(r )

  //     } }

  //     ;
  //   } }

  //   ;

  //   lscc.spclMeta.SpclAnyFunSuite.aftermathsUtil.printlnBanner(s"parsing of Expr `val MainVariableExpr @ MainVariableExprImpl ; `")
  // }

  ;
}