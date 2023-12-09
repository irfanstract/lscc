




















@main
def runRlLscc() : Unit
= {
  ;

  ({
    import lscc.asToolChain.ext.rfsPredef.{*, given }

    enableVerboseOrgJLineLogging()
  })

  transparent inline
  given given_c_excs
  : lscc.asToolChain.SpclCompilerOpsExceptionsImpl
  = lscc.asToolChain.SpclCompilerOpsExceptionsImpl.i

  object TcSFileEntry {
    ;
    def apply
      (d: String )
    = new TcSFileEntry(d = d )
  }
  case class TcSFileEntry private (d: String )

  object TcS {
    ;

    opaque type _Any
    <: AnyRef
    = C

    case class C(c: collection.immutable.Iterable[TcSFileEntry], unused: Unit = () )

    lazy val fileContLens
    : monocle.Lens[_Any, collection.immutable.Iterable[TcSFileEntry]]
    = monocle.macros.GenLens[C](_.c )

    def initially()
    : _Any
    = C(c = IndexedSeq() )

    given given_SpclEnsureCompiledOp
    : lscc.asToolChain.SpclEnsureCompiledOp.ForReceiverLUAndReturnVal[_Any, _Any, Unit ]
    = lscc.asToolChain.SpclEnsureCompiledOp.fromTotalFunction((c: _Any) => {
      c
      .c
      .toSeq.last
      .match { case file => {
        file
        .d
        .match {
          case "" =>
          case s @ ":Q" =>
            throw
              given_c_excs.newParseSyntaxErrorException1(msg = s"invalid expr: '$s'")
          case c =>
            println(s"text: $c ")
        }
      } }
    } )

    given given_AddFileOp
    : lscc.asToolChain.SpclAddFromInteractiveFileOps.ForReceiverLU[_Any, _Any]
    = lscc.asToolChain.SpclAddFromInteractiveFileOps.fromFunction((r: _Any, newFile ) => {
      val txt = { import language.unsafeNulls ; lscalg.cli.repl.UReadLineList(new java.io.BufferedReader(newFile) ).mkString("\r\n") }

      println(s"new file added: ${ txt } ")

      fileContLens.modify
        (s0 => s0.toSeq :+ TcSFileEntry(d = txt ) )
        (r)
    } )

    ;
  }

  lscc.asToolChain.runFromS
    [TcS._Any] (initialToolchainState = TcS.initially() , intendedRunningThread = concurrent.ExecutionContext.parasitic )
}










