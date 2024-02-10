package lscc.spclParsingTestCases









class LiteralsTestCase01
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

  ;

  ;

  test("EscapedIdent parsing Txt Golden") {
    ;

    lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("Golden")

    .atBgnPars()

    .match { case p => {
      ;

      ({
        ;

        p

        .match { case ptr0 => {
          ({
            import lscc.spclTerminalGrammarsB.{ForInlineTerminalLiteral1, ForImmediateUnescapedWord }

            (
              ForImmediateUnescapedWord( )
            )
          })
          .applyBrt(ptr0)
        } }
      })
      .match { case r => {
        ;

        assert(r.nonEmpty )

        assert((
          r
          .collect({ case (m, newPos) => m })
          .map(_.matchedStr )
          .headOption
          .==(Some("Golden") )
        ))

        println(r )

      } }

      ;
    } }

    ;

    lscc.spclMeta.SpclAnyFunSuite.aftermathsUtil.printlnBanner(s"parsing of Txt `Golden`")
  }

  // test("BigDecimalLiteral parsing '0.5678 Semicol Semicol'") {
  //   ;

  //   lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("0.5678 ; ;")

  //   .atBgnPars()

  //   .match { case p => {
  //     ;

  //     ({
  //       ;

  //       p

  //       .match { case ptr0 => {
  //         ({
  //           import lscc.spclTerminalGrammarsB.{ForInlineTerminalLiteral1, ForImmediateUnescapedWord, ForBigDecimalLiteral1 }

  //           (
  //             ForBigDecimalLiteral1( )
  //           )
  //         })
  //         .applyBrt(ptr0)
  //       } }
  //     })
  //     .match { case r => {
  //       ;

  //       assert((
  //         r
  //         .collect({ case (m, newPos) => m })
  //         .map(_.matchedStr )
  //         .headOption
  //         .==(Some("0.5678") )
  //       ))

  //       println(r )

  //     } }

  //     ;
  //   } }

  //   ;

  //   lscc.spclMeta.SpclAnyFunSuite.aftermathsUtil.printlnBanner(s"parsing of BigDecimalLiteral `0.5678`")
  // }

}






