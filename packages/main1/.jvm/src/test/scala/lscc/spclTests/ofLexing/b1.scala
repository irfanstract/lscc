package lscc.spclTests.ofLexing












class Lx1
extends
org.scalatest.funsuite.AnyFunSuite
{
  ;

  import lscalg.bnfParsing.spclCommonLookaheadCaps1 as spclCommonLookaheadCaps1

  import lscc.spclParsedConstructs1 as spclParsedConstructs1

  import spcgSpclParsingDefs.{*, given }

  test("b 1") {
    lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("transparent inline")
    .atBgnPars()

    .match { case p => {
      assert ((
        p
        // .immediateUnescapedWord().toOption
        .immediateSubjectInstance(spclParsedConstructs1.ForImmediateUnescapedWord() ).toOption
        .map(e => e.prod._1.mFullStr )
        ==
          Some("transparent")
      ))

      assert((
        p
        // .immediateEscapedIdent().toOption
        .immediateSubjectInstance(spclParsedConstructs1.ForImmediateEscapedIdent() ).toOption
        .map(e => e.prod )
        .isEmpty
      ) )

    } }

    println(s"done test 'b 1' " )
  }

  test("whitespace-only src-file skip-all test") {
    val code
    = {
      ;

      """
      |
      |
      |
      """.stripMargin
    }

    assert(code.matches("""\s+""") )

    lscc.spclParsing.spclUtil.LazyRlb.fromSnippet(code)
    .atBgnPars()

    .match { case p => {
      assert(p.skippingNextWhitespace(lineCountLimit = 10485).immediateEndOfFile().nonEmpty )

      ;
    } }

    println(s"done test 'whitespace-only src-file skip-all test' " )
  }

  test("b 3") {
    lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("transparent inline")
    .atBgnPars()
    .match { case p => {
      val p1
      = p.immediateSubjectInstance(spclCommonLookaheadCaps1.ForImmediateStrLiteralOccurence("{") )
      
      //
    } }

    println(s"done test 'b 3' " )
  }

}











