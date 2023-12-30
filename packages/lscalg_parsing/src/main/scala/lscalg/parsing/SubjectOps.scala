package lscalg.parsing





















// @deprecated
object subjectOpsCommon {
  ;

  given subjectConcatOps
  : AnyRef with {
    export subjectConcatOps1.{*, given }
  }

  export subjectLoopOpOptInImplicits.given

  @deprecated
  final
  lazy val sCdt
  = lscalg.digestivity.psfLastCompileTime()

  ;
}













