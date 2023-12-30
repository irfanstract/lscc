package lscc










// TODO
@main
def aSpclReadEvalLoop
  (args: String* )
= {
  SpclReadEvalLoop.run
    (config = {
      SpclReadEvalLoop.SpclConfig.fromStringArgs
        (args.toIndexedSeq )
    } )
}







