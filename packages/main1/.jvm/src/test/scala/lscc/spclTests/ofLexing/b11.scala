package lscc.spclTests.ofLexing















class LxBRepet
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

  test("relevant type-inference test") {
    ;

    lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("transparent inline")

    .atBgnPars()
    .match { case p => {
      ;

      SpclGrmPtr.grmNumericLiteranAndWordsAndIdents.immediateUnescapedWord(p ) ( )

      ((e: Any) => Some[e.type](e) )(SpclGrmPtr.implCc1.grmNumericLiteranAndWordsAndIdents)
      .match { case s => s }

      SpclGrmPtr.implCc1.grmNumericLiteranAndWordsAndIdents.immediateUnescapedWord(p ) ( )
      .match { case res0 => res0 }

      Seq(SpclGrmPtr.implCc1.grmNumericLiteranAndWordsAndIdents0)
      .match { case s => s }

      SpclGrmPtr.implCc1.grmNumericLiteranAndWordsAndIdents0.immediateUnescapedWord(p ) ( )
      .match { case res0 => res0 }

      summon[([T] =>> (T =:= T ) )[SpclGrmPtr.SpclAfterDigestTupleOption.PositiveInstance ] ]

      summon[([T] =>> (T =:= T ) )[SpclGrmPtr.implCc1.SpclAfterDigestTupleOption.PositiveInstance ] ]

      ;
    } }

    println(s"done the relevant type-inference test")
  }

  test("given src `transparent inline`, look merely the first word `transparent`") {
    ;

    lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("transparent inline")

    .atBgnPars()
    .match { case p => {
      ;

      assert((
        ({
          p
          .immediateUnescapedWord().toOption
        })
        .map(e => e.prod._1.head )
        ==
        Some("transparent")
      ) )

      assert({
        ({
          p
          .immediateEscapedIdent().toOption
        })
        .map(e => e.prod )
        .isEmpty
      } )

      ;
    } }

    assert(5 == 5 )
  }

  test("given src `()()()`, try to parse it") {
    ;

    import language.unsafeNulls

    lscc.spclParsing.spclUtil.LazyRlb.fromSnippet("()()()")

    .atBgnPars()

    .match { case p => {
      ;

      // import SpclGrmPtr.{given lscalg.bnfParsing.BnrpMatchingLoopOp._Any}

      ({
        val Etc = valueOf[SpclGrmPtr.SpclAfterDigestTupleOption.type ]
      })

      ({
        ({
          // import SpclGrmPtr as C
          import lscc.spclParsing.GrmPtr as C
          summon[(
            lscalg.bnfParsing.BnrpMatchingLoopOp.ForReceiver[C._Any, C.SpclAfterDigestTupleOption.PositiveInstance ]
          ) ]
        })
        .match { case op => {
          println({
            op.tryForImmediateLoop1(p)
          })
        } }
      })

      // extension (pt: SpclGrmPtr._Any )
      //   transparent inline
      //   def `immediate_()`
      //   = pt.immediateLiterally("()")

      ()

      ({
        p
        .match { case ipt => {
          ;

          import lscalg.bnfParsing.BnrpMatchingLoopOp.{*}

          ipt
          .tryForImmediateLoop1
            ({
              SpclSubject.fromLiftedPartialFunction((pt: SpclGrmPtr._Any ) => {
                pt.immediateLiterally("()")
                .toOption
              } )
            }, Range(1, 350000) , SpclEagerness.+ )
        } }
        .headOption
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

      ({
        p
        .match { case ipt => {
          ;

          import lscalg.bnfParsing.BnrpMatchingLoopOp.{*}

          ipt
          .tryForImmediateLoop1
            ({
              SpclSubject.fromLiftedPartialFunction((pt: SpclGrmPtr._Any ) => {
                pt.immediateLiterally("()")
                .toOption
              } )
            }, Range(1, 2) , SpclEagerness.+ )
        } }
        //
        .tapEach(e => {
          println(e)
        })
        .headOption
      })
      .match { case parsed1 => {
        ;
        assert(parsed1.nonEmpty )

        assert({
          parsed1
          .collect({ case e @ Seq(_, _ ) => e })
          .nonEmpty
        } , s"doesn't match '{ case e @ Seq(_, _ ) => e }' " )

        val pos2
        = {
          ;
          parsed1
          .map(e => e.last )
          .get
          .nextPos
        }

        pos2
        .immediateLiterally("()")
        .match { case r3 => {
          ;

          assert({
            r3
            .toOption.nonEmpty
          } )

          assert({
            r3
            .toOption
            .flatMap(r => {
              r.nextPos
              .match { case pos => {
                pos.immediateEndOfFile()
              } }
            } )
            .nonEmpty
          } )
        } }

        ;
      } }

      //
    } }

    println(new java.util.Date().toLocaleString() )

    assert(5 == 5 )
  }

}









