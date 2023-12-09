package lscalg.cli.repl












object UReadlineConsole
{
  ;

  type _Any
  = _Impl

  protected
  type _Impl
  >: PAndRlOps
  <: PAndRlOps

  def apply
    (impl: PAndRlOps)
  : _Any
  = impl

  trait PAndRlOps {
    ;

    @`throws`[java.io.IOException]
    def promptAndReadLine
      //
      (pr: => String )
    : String

    ;
  }

  def byPromptAndReadLineFnc
    //
    (do1: (msg: DummyImplicit ?=> String ) => String )
  = {
    apply({
      new PAndRlOps {
        ;

        @`throws`[java.io.IOException]
        def promptAndReadLine
          //
          (pr: => String )
        = do1(msg = pr )

      }
    })
  }

  ;
}

object fvmPosixReplConsoleImplicits {
  ;
  
  @deprecated
  given intendedConsole
  : java.io.Console
  = java.lang.System.console().nn

  given (using DummyImplicit )
  : UReadlineConsole._Any
  = {
    ;

    import  language.unsafeNulls

    UReadlineConsole.byPromptAndReadLineFnc({
      //

      case (msg) =>
        ;

        def readLine()
        : String
        = {
          ;
          new java.io.BufferedReader(new java.io.InputStreamReader(System.in ) )
          .readLine()
        }

        (msg: String ) match {
        //
        case c @ ("$" | "$ " | ">" | "> ") =>
          System.out.print(c )
          readLine()
        case _ =>
          System.out.println(msg )
          readLine()
        }
    })
  }

  ;
}














