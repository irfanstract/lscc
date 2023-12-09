package lscc.spclTests.ofLexing















class LxBRepet
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

  test("given src `transparent inline`, look merely the first word `transparent`") {
    lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("transparent inline")
    .atBgnPars()
    .match { case p => {
      assert(p.immediateUnescapedWord().toOption.map(e => e.prod._1.head ) == Some("transparent") )
      assert(p.immediateEscapedIdent().toOption.map(e => e.prod ).isEmpty )
    } }

    assert(5 == 5 )
  }

  test("given src `()()()`, try to parse it") {
    lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("()()()")
    .atBgnPars()
    .match { case p => {
      ;
      import lscc.spclParsing.GrmPtr.{given lscalg.bnfParsing.BnrpMatchingLoopOp._Any}

      ({
        import lscalg.bnfParsing.BnrpMatchingLoopOp
        p
        .tryForImmediateLoop1
          ({
            BnrpMatchingLoopOp.SpclSubject.fromLiftedPartialFunction((pt: lscc.spclParsing.GrmPtr._Any ) => {
              pt.immediateLiterally("()")
              .toOption
            } )
          }, Range(1, 350000) , BnrpMatchingLoopOp.SpclEagerness.+ )
      })
      .match { case p1 => {
        ;
        assert(p1.nonEmpty )
        assert({
          p1
          .collect({ case e @ Seq(_, _, _ ) => e })
          .nonEmpty
        } )
      } }

      //
    } }

    assert(5 == 5 )
  }

}









