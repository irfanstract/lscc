package lscc.spclTests.ofLexing










class LxBConcatsExam
extends
org.scalatest.funsuite.AnyFunSuite
{
  ;

  import lscc.spclParsing.GrmPtr as SpclGrmPtr

  implicit
  object impl1
  {
    ;

    extension (r: lscc.spclParsing.spclUtil.Lrp._Any )
      //
      def atBgnPars()
      : SpclGrmPtr._Any
      = SpclGrmPtr.atBeginningOfFile(r )

  }

  ;

  ;

  test("given src `()()`, try to parse it alt") {
    ;

    import language.unsafeNulls

    lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("()()()")

    .atBgnPars()

    .match { case p => {
      ;

      ({
        ;

        p

        .immediateConc1((
          //

          Seq[(p: SpclGrmPtr._Any ) => (
            // SpclAfterDigestTupleOption._Any
            SpclGrmPtr.SpclAfterDigestTupleOption._Any
          ) ](
            _.immediateLiterally("()")
            ,
            _.immediateLiterally("?")
            ,
          )
        ))
        .map({ case (e1 +: _, nextPos) => {
          ;
          SpclGrmPtr.SpclAfterDigestTupleOption.describeAfterDigestTuple1(
            finalPos = nextPos , prod = e1 )
        } })
      })
      .match { case r => {
        assert(r.isEmpty )
      } }

      ({
        ;

        p

        .immediateConc1((
          //

          Seq[(p: SpclGrmPtr._Any ) => (
            // SpclAfterDigestTupleOption._Any
            SpclGrmPtr.SpclAfterDigestTupleOption._Any
          ) ](
            _.immediateLiterally("()")
            ,
            _.immediateLiterally("()")
            ,
          )
        ))
        .map({ case (e1 , nextPos) => {
          ;
          SpclGrmPtr.SpclAfterDigestTupleOption.describeAfterDigestTuple1(
            finalPos = nextPos ,
            prod = ((
              IndexedSeq() :+
              e1
              .map({ case (matchedStr +: _ , _ ) => matchedStr : String } )
              .mkString("")
            ) , e1.map(_._2.regex ).mkString("|").r ) )
        } })
      })
      .match { case r => {
        assert(r.map(e => e.matchedStr ) == Some("()()") )
      } }

      ;
    } }

    ;

    println(s"done for `()()()` ")
    println(new java.util.Date().toLocaleString() )
  }

  ;
}