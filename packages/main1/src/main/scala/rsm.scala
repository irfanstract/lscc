








import lscalg.cli.repl.UReadlineConsole





@main
def runSMain() : Unit
= {
  ;
}

@main
def runRlEcho() : Unit
= {
  import lscalg.cli.repl.fvmPosixReplConsoleImplicits.{given UReadlineConsole._Any }

  for (_ <- Range(0, 4) )
  do {
    val txt = {
      ;
      summon[UReadlineConsole._Any ]
      .promptAndReadLine(">")
    }
    println(s"[out] $txt ")
  }
}

@main
def runRlLs() : Unit
= {
  ;

  import language.unsafeNulls

  import lscalg.cli.repl.UReadLineList

  val sRl
  = {
    ;

    import language.unsafeNulls

    new java.io.BufferedReader(new java.io.InputStreamReader(System.in ) ) {
      ;
      override
      def readLine()
      : String | Null
      = {
        System.out.print("> ")
        super.readLine()
      }
    }
  }

  for ((lC) <- UReadLineList.apply(sRl ).take(5 ) )
  do {
    ;
    println(s"[out] $lC ")
  }
}

@main
def runRlLscc() : Unit
= {
  ;

  ({
    import language.unsafeNulls

    import java.util.logging.{Logger, * }

    Logger.getLogger("org.jline")
    .setLevel(Level.FINER )
  })
  
  object TcS {
    ;

    opaque type _Any
    <: AnyRef
    = (Unit, Unit )

    def initially()
    : _Any
    = ((), () )

    given given_SpclEnsureCompiledOp
    : lscc.asToolChain.SpclEnsureCompiledOp.ForReceiverLUAndReturnVal[_Any, _Any, Unit ]
    = lscc.asToolChain.SpclEnsureCompiledOp.fromTotalFunction((_: _Any) => {} )

    given given_AddFileOp
    : lscc.asToolChain.SpclAddFromInteractiveFileOps.ForReceiverLU[_Any, _Any]
    = lscc.asToolChain.SpclAddFromInteractiveFileOps.fromFunction((r: _Any, newFile ) => {
      println(s"new file added: ${import language.unsafeNulls ; lscalg.cli.repl.UReadLineList(new java.io.BufferedReader(newFile) ).mkString("\r\n") } ")
      r
    } )

    ;
  }

  lscc.asToolChain.runFromS
    [TcS._Any] (initialToolchainState = TcS.initially() , intendedRunningThread = concurrent.ExecutionContext.parasitic )
}









