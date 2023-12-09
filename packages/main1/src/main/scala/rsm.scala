








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









