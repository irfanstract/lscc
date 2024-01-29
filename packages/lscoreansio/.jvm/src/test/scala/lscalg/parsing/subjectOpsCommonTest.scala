package lscalg.parsing














class subjectOpsCommonTest
extends
org.scalatest.funsuite.AnyFunSuite
{
  ;

  ({
    @deprecated
    val subjectCmbnOpsCdt
    = subjectOpsCommon.sCdt
  })

  test("lscalg_parsing_subjectOpsCommon concat Unit and literal 5 consistent") {
    ;

    import subjectConcatOps1.{*, given }
    import lscalg.parsing.ParseFunction

    object Eh {
      opaque type _Any = 5
      def apply() : _Any = 5
    }

    val sUnit = ParseFunction.fromPartialFunction((p => ((), p ) ) : PartialFunction[Eh._Any, (Unit, Eh._Any )] )
    val sFive = ParseFunction.fromPartialFunction((p => (5, p ) ) : PartialFunction[Eh._Any, (5, Eh._Any ) ] )

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

    import subjectConcatOps1.{*, given }
    import lscalg.parsing.ParseFunction

    object Eh {
      type _Any
      >: Seq[Int]
      <: Seq[Int]
    }

    val sUnit = ParseFunction.fromPartialFunction((p => ((), p :+ 1 ) ) : PartialFunction[Eh._Any, (Unit, Eh._Any )] )
    val sFive = ParseFunction.fromPartialFunction((p => (5, p :+ 2 ) ) : PartialFunction[Eh._Any, (5, Eh._Any ) ] )

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
    import lscalg.parsing.ParseFunction

    object Eh {
      type _Any
      >: Seq[Int]
      <: Seq[Int]
    }

    val sInt1 = ParseFunction.fromPartialFunction((p => (p.last, p :+ 1 ) ) : PartialFunction[Eh._Any, (Int, Eh._Any )] )
    val sFive = ParseFunction.fromPartialFunction((p => (5, p :+ 2 ) ) : PartialFunction[Eh._Any, (5, Eh._Any ) ] )

    import lscalg.bnfParsing.{BnrpMatchingLoopOp, sBnrpMatchingLoopOpOptInImplicits}, sBnrpMatchingLoopOpOptInImplicits.{*, given }

    (sInt1 andThenAlso sFive )
    .match { case prf => prf : ParseFunction.ForReceiverAndRValue[Eh._Any, (Int, Int) ] }
    .:*(BnrpMatchingLoopOp.SpclCountRange.fromStartToBeforeEndIndex(3, 3) )
    .match { case prf => prf : ParseFunction.ForReceiverAndRValue[Eh._Any, Seq[(Int, Int)] ] }

    .applyEi(Nil :+ 7 )
    .match { case r => r }
    .match { case r => {
      assert((
        r
        .map({ case (value, _) => {
          value
        } })
        ==
          Right(Nil :+ (7, 5) :+ (2, 5) :+ (2, 5) )
      ))

      assert((
        r
        .map({ case (value, newPos) => {
          newPos
        } })
        ==
          Right((Nil :+ 7 :+ 1 :+ 2 :+ 1 :+ 2 :+ 1 :+ 2 ) : Eh._Any)
      ))

      println(s"result: $r")
    } }
  }

}










