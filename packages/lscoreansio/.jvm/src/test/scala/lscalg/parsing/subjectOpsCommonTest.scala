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
      type _Any >: Int <: Int
    }

    val sUnit = Subject.fromPartialFunction((p => ((), p + 1 ) ) : PartialFunction[Eh._Any, (Unit, Eh._Any )] )
    val sFive = Subject.fromPartialFunction((p => (5, p + 1 ) ) : PartialFunction[Eh._Any, (5, Eh._Any ) ] )

    (sUnit andThenAlso sFive )
    .applyEi(7 )
    .match { case r => {
      assert((
        r
        .toOption
        .collect({ case (_, pt) => pt })
        .toRight(() )
        ==
          Right(9)
      ))

      println(s"result: $r")
    } }
  }

}










