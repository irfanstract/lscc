package lscc.spclTests.ofLexing












class Lx1
extends
org.scalatest.funsuite.AnyFunSuite
{
  ;

  implicit
  object impl1
  {
    ;

    extension (r: lscc.spclParsing.spclUtil.Lrp._Any )
      //
      def atBgnPars()
      = lscc.spclParsing.GrmPtr.atBeginningOfFile(r )

  }

  test("b 1") {
    lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("transparent inline")
    .atBgnPars()
    .match { case p => {
      assert(p.immediateUnescapedWord().toOption.map(e => e.prod._1.head ) == Some("transparent") )
      assert(p.immediateEscapedIdent().toOption.map(e => e.prod ).isEmpty )
    } }

    assert(5 == 5 )
  }

  test("whitespace-only src-file skip-all test") {
    lscc.spclParsing.spclUtil.LazyRlb.fromSnippet({
      """
      |
      |
      |
      """.stripMargin
    })
    .atBgnPars()
    .match { case p => {
      assert(p.skippingNextWhitespace(lineCountLimit = 10485).immediateEndOfFile().nonEmpty )
    } }

    assert(5 == 5 )
  }

}











