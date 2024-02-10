package lscc.spclGrammar












def withOne[R] (svc: AnyRef ) (r: svc.type ?=> R) : R
= r(using svc)

export ewacImpl.{run as withAll }

protected
object ewacImpl
{
  //
  extension [Tcs] (tcs: Tcs)
    def run[R] (c: (xGivens: Tcs) ?=> R )
    : R
    = { c(using tcs) }
}

lazy val _ = {
  withAll((3,4,5)) {
    println(s"do good!")
    5
  }
}












