package lscalg.parsing





class subjectedTrivialRLookup01
extends
org.scalatest.funsuite.AnyFunSuite
{
  ;

  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1 as SpclGrmPtr

  implicit
  object impl1
  {
    ;

    extension (r: lscalg.cli.repl.spclCollections.Lrp._Any )
      //
      def atBgnPars()
      : SpclGrmPtr._Any
      = SpclGrmPtr.atBeginningOfSrcFile(r )

  }

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

  given lscalg.bnfParsing.spclCptdFispoSuppExtras1.GivenFiSpoSupp.for_BC.type
  = lscalg.bnfParsing.spclCptdFispoSuppExtras1.GivenFiSpoSupp.for_BC

  test("underscore wildcard pattern") {
    ;

    val rule
    = lscalg.bnfParsing.spclCommonLookaheadCaps1.ForImmediateRawOcc("""_+""".r , lineCountLimit = 1 )
  
    ({
      ;

      rule
      .applyBrt({
        ;

        lscalg.cli.repl.spclCollections.LazyRlb.fromSnippet("___ @ MainVariableExprImpl ; ")
        .atBgnPars()
      })
    })
    .match { case r => {
      ;

      assert(r.nonEmpty )

      assert({
        r
        .map({ case (m, nextPos) => {
          m.matchedStr
        } })
        .filter(s => (
          s == "___"
        ) )
        .nonEmpty
      } )

      val nextPosOption
      = {
        ;
        r
        .map({ case (m, nextPos) => {
          nextPos
        } })
      }

      assert({
        nextPosOption
        .map((
          _
          .remainingLines
          .head
          .contents
        ))
        .filter(s => (
          s.startsWith(" ")
        ) )
        .nonEmpty
      } )

      assert({
        nextPosOption
        .map((
          _
          .remainingLines
          .head
          .contents
        ))
        .filter(s => (
          s.startsWith("_")
        ) )
        .isEmpty
      } )

    } }

    ;

    lscoreansioSpclTesting.SpclAnyFunSuite.aftermathsUtil.printlnBanner(s"parsing of the UnderscoreToken, in Expr `___ @ MainVariableExprImpl ; `")
  }
  ;

  ;
}