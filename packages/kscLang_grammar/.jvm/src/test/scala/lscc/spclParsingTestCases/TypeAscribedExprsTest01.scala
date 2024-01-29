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

  test("type-ascribed val-def") {
    ;

    val rule
    = {
      ;

      import lscc.spclTerminalGrammarsB.{ForInlineTerminalLiteral1, ForImmediateUnescapedWord }
      import lscc.spclParsedConstructs1.{ForBindingFirstTermOrTypeAscribedExprP }
      import lscc.spclGrammar.{KeywordingCtx , forTermOrTypeLevelExprs }, forTermOrTypeLevelExprs.{Aitl }

      (
        withMode(Aitl.forTermLevel() ) ((
          ForBindingFirstTermOrTypeAscribedExprP( )
        ))
      )
    }

    ;

    lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("_ @ MainVariableExprImpl ; ")
    .atBgnPars()

    .match { case p => {
      ;

      ({
        ;

        p

        .match { case ptr0 => {
          rule
          .applyBrt(ptr0)
        } }
      })
      .match { case r => {
        ;

        assert(r.nonEmpty )

        println(r )

      } }

      ;
    } }

    lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("val MainVariableExpr @ MainVariableExprImpl ; ")
    .atBgnPars()

    .match { case p => {
      ;

      ({
        ;

        p

        .match { case ptr0 => {
          rule
          .applyBrt(ptr0)
        } }
      })
      .match { case r => {
        ;

        assert(r.nonEmpty )

        println(r )

      } }

      ;
    } }

    ;

    lscc.spclMeta.SpclAnyFunSuite.aftermathsUtil.printlnBanner(s"parsing of Expr `val MainVariableExpr @ MainVariableExprImpl ; `")
  }

  ;
}