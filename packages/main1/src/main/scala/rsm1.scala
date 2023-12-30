




















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

  object TcSLazyCompiledView {
    ;

    /** 
     * supposed to run exactly once the given func
     * 
     */
    def fromVoidFunction
      (c:  () => Unit )
    : TcSLazyCompiledView
    = {
      ;
      lazy val returnVal
      = c.apply()
      new TcSLazyCompiledView {
        def asCompiled()
        = { returnVal ; this }
      }
    }

    ;
  }
  trait TcSLazyCompiledView private[TcSLazyCompiledView] ()
  {
    ;

    /** 
     * ensure compilation has been run.
     * 
     */
    def asCompiled()
    : this.type
  }

  object TcSFileEntry {
    ;

    type _Any
    = TcSFileEntry

    def fromSrcCode
      (srcCode: String )
    = {
      new TcSFileEntry
        (srcCode = srcCode,
        asCompiledView = {
          TcSLazyCompiledView.fromVoidFunction(() => {
            println(s"compiling code '$srcCode' ")
            println(s"done compiling code '$srcCode' ")
          })
        } )
    }

    extension (c: _Any) {

      /** 
       * ensure compilation has been run.
       * 
       */
      transparent inline
      def asCompiled()
      = c.asCompiledView.asCompiled()
    }

    ;
  }
  case class TcSFileEntry private[TcSFileEntry]
    (srcCode: String, asCompiledView: TcSLazyCompiledView )

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
        .srcCode
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

      val txtCFile
      = TcSFileEntry.fromSrcCode(srcCode = txt )

      txtCFile
      .asCompiled()

      fileContLens.modify
        (s0 => s0.toSeq :+ txtCFile )
        (r)
    } )

    ;
  }

  lscc.asToolChain.runFromS
    [TcS._Any] (initialToolchainState = TcS.initially() , intendedRunningThread = concurrent.ExecutionContext.parasitic )
}










