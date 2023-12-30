
package lscc

package asToolChain














import lscc.asToolChain.ext.rfsPredef





private
given ToEnsureCompiledOrThereofError
  //
  [
    S
    : [R] =>> lscc.asToolChain.SpclEnsureCompiledOp.ForReceiverLUAndReturnVal[R, R, Unit]
    ,
  ]
  // (using  )
  (using compilerExceptions : SpclCompilerOpsExceptionsImpl )
: AnyRef with {
  ;

  import rfsPredef.{*, given }

  import compilerExceptions.{*, given}

  extension (s: S) {
    //

    /**
     * first calls `ensureCompiledOrThereofError`, and then
     * - catch `CompileErrorException` (inclding `SyntaxErrorException` ),
     *   translating into `None` in case of `SyntaxErrorException`, and
     *   `Some(_)` otherwise
     * - leave other exceptions bubble
     * 
     */
    transparent inline
    def ensureCompiledOrThereofErrorOption
      //
      ()
    : Option[S]
    = {
      ;

      // TODO
      util.Try({
        ;

        s
        .ensureCompiledOrThereofErrorOption1()
        .map(v => {
          println(s"compilation successful. ($v) ")
          v
        } )
        .match { case tr => {
          tr.map(Some(_))
          .recover[Option[S ] ] ({
            case SpclParseSyntaxErrorException(z) =>
              z.printOneLineStackTrace()
              new Exception(s"please fix the code").printOneLineStackTrace()
              None
            case SpclCompileErrorException(z) =>
              z.printOneLineStackTrace()
              Some(s)
          })
        } }
        .get
      })
      .match { case tr => {
        ;
        tr
        .recover(z => {
          java.lang.Thread.sleep(500 )
          throw z
        } )
        .get
      } }
    }

    /** 
     * `ensureCompiledOrThereofError` ;
     * essentially `tryEnsureCompiled` except that
     * only `CompileError` (including `SyntaxError` ) would be caught.
     * 
     */
    transparent inline
    def ensureCompiledOrThereofErrorOption1
      //
      ()
    : util.Try[s.type ]
    = {
      ;

      s
      .tryEnsureCompiled()
      .match { case s => {
        ;
        s
        .map(util.Success(_) )
        .recover({
          ;
          {
            // case SpclParseSyntaxErrorException(z) =>
            //   throw z

            case z @ (
              SpclCompileErrorException(_)
              | SpclParseSyntaxErrorException(_)
            ) =>
              new Exception(s"SpclCompileErrorException: ${z} ")
              .printOneLineStackTrace()
              util.Failure(z)
          }
        }) 
        .get
      } }
      .map[s.type] ((_: Unit) => s )
    }
  }

  ;
}


















