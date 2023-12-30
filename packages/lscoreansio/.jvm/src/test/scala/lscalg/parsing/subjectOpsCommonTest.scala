package lscalg.parsing














class subjectOpsCommonTest
extends
org.scalatest.funsuite.AnyFunSuite
{
  ;

  test("lscalg_parsing_subjectOpsCommon concat Unit and literal 5 consistent") {
    ;

    import subjectOpsCommon.{*, given }

    object Eh {
      opaque type _Any = 5
      def apply() : _Any = 5
    }

    val sUnit = Subject.fromPartialFunction((p => ((), p ) ) : PartialFunction[Eh._Any, (Unit, Eh._Any )] )
    val sFive = Subject.fromPartialFunction((p => (5, p ) ) : PartialFunction[Eh._Any, (5, Eh._Any ) ] )

    (sUnit andThenAlso sFive )
    .applyEi(Eh() )
    .match { case r => {
      assert((
        r
        == Right((() *: 5 *: EmptyTuple , Eh() ))
      ))
    } }
  }

  test("lscalg_parsing_subjectOpsCommon concat in sequence consistent") {
    ;

    import subjectOpsCommon.{*, given }

    object Eh {
      type _Any
      >: Seq[Int]
      <: Seq[Int]
    }

    val sUnit = Subject.fromPartialFunction((p => ((), p :+ 1 ) ) : PartialFunction[Eh._Any, (Unit, Eh._Any )] )
    val sFive = Subject.fromPartialFunction((p => (5, p :+ 2 ) ) : PartialFunction[Eh._Any, (5, Eh._Any ) ] )

    (sUnit andThenAlso sFive )
    .applyEi(Nil :+ 7 )
    .match { case r => {
      assert((
        r
        .toOption
        .collect({ case (_, pt) => pt })
        .toRight(() )
        ==
          Right(Nil :+ 7 :+ 1 :+ 2 )
      ))

      println(s"result: $r")
    } }
  }

  test("lscalg_parsing_subjectOpsCommon looping consistent") {
    ;

    import subjectOpsCommon.{*, given }

    object Eh {
      type _Any
      >: Seq[Int]
      <: Seq[Int]
    }

    val sInt1 = Subject.fromPartialFunction((p => (p.last, p :+ 1 ) ) : PartialFunction[Eh._Any, (Int, Eh._Any )] )
    val sFive = Subject.fromPartialFunction((p => (5, p :+ 2 ) ) : PartialFunction[Eh._Any, (5, Eh._Any ) ] )

    import lscalg.bnfParsing.{BnrpMatchingLoopOp, sBnrpMatchingLoopOpOptInImplicits}, sBnrpMatchingLoopOpOptInImplicits.{*, given }

    (sInt1 andThenAlso sFive )
    .repeated(backtrackWorthiness = BnrpMatchingLoopOp.SpclBacktrackworthiness._1, eagerness = BnrpMatchingLoopOp.SpclEagerness.+ )
      ((), Range(3, 3) )
    .applyEi(Nil :+ 7 )
    .match { case r => {
      assert((
        r
        .toOption
        .collect({ case (r, _) => r.unzip._1 })
        .toRight(() )
        ==
          Right(Nil :+ 7 :+ 2 :+ 2 )
      ))

      println(s"result: $r")
    } }
  }

}










