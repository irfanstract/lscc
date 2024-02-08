package lscc.spclParsingTestCases









class ConcatenatedEmptyParentheses01
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

  import lscalg.bnfParsing.IRegExp, IRegExp.tagImplicits.r

  ;

  ;

  // test("CE, given src `()()`, try to parse it alt") {
  //   ;

  //   import language.unsafeNulls

  //   lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("()()()")

  //   .atBgnPars()

  //   .match { case p => {
  //     ;

  //     ({
  //       ;

  //       p

  //       .match { case ptr0 => {
  //         ({
  //           import lscc.spclTerminalGrammarsB.{ForInlineTerminalLiteral1 }

  //           (
  //             ForInlineTerminalLiteral1(IRegExp.forLiteral("()") )
  //             zip
  //             ForInlineTerminalLiteral1(IRegExp.forLiteral("?") )
  //           )
  //         })
  //         .applyBrt(ptr0)
  //       } }
  //     })
  //     .match { case r => {
  //       ;

  //       assert(r.isEmpty )

  //     } }

  //     ({
  //       ;

  //       p

  //       .match { case ptr0 => {
  //         ({
  //           import lscc.spclTerminalGrammarsB.{ForInlineTerminalLiteral1 }

  //           (
  //             ForInlineTerminalLiteral1(IRegExp.forLiteral("()") )
  //             zip
  //             ForInlineTerminalLiteral1(IRegExp.forLiteral("()()") )
  //           )
  //         })
  //         .applyBrt(ptr0)
  //       } }
  //     })
  //     .match { case r => {
  //       ;

  //       assert(r.nonEmpty )

  //     } }

  //     ({
  //       ;

  //       p

  //       // .immediateConcatOfSubjectsExre((
  //       //   //

  //       //   lscalg.bnfParsing.BnrpMatchingLoopOp.SpclSubject.fromLiftedPartialFunctionList
  //       //     (Seq[(p: SpclGrmPtr._Any ) => Option[SpclGrmPtr.SpclAfterDigestTupleOption.PositiveInstance ] ] (
  //       //       //

  //       //       _.immediateLiterally("()").toOption
  //       //       ,
  //       //       _.immediateLiterally("()").toOption
  //       //       ,
  //       //     ))
  //       // ))
  //       // .map({ case (e1 , nextPos) => {
  //       //   ;
  //       //   SpclGrmPtr.SpclAfterDigestTupleOption.describeAfterDigestTuple1(
  //       //     finalPos = nextPos ,
  //       //     prod = ((
  //       //       ({
  //       //         ;
  //       //         e1
  //       //         .map({ case (matchedStrs , _ ) => matchedStrs.mFullStr : String } )
  //       //         .mkString("")
  //       //       })
  //       //       .match { case matchedStr => SpclGrmPtr.SpclAfterDigestTupleOption._Impl1.SpclMatchedStringArray(fullS = matchedStr , ms = IndexedSeq() ) }
  //       //     ) , e1.map(_._2.regex ).mkString("|").r ) )
  //       // } })
  //     })
  //     // .match { case r => {
  //     //   assert(r.map(e => e.matchedStr ) == Some("()()") )
  //     // } }

  //     ;
  //   } }

  //   ;

  //   // println(s"done for `()()()` ")
  //   // println(new java.util.Date().toLocaleString() )
  //   lscc.spclMeta.SpclAnyFunSuite.aftermathsUtil.printlnBanner(s"parsing of `()()()`")
  // }

  ;
}



