
package lscc

package asToolChain














import lscc.asToolChain.ext.rfsPredef

trait ReplWaplWrplOpImpl[ReceiT] {
  ;

  extension (s: ReceiT )
    def withAddedPendingLineOfInput
      [V <: String](value: V)
    : ReceiT

    def withResetPendingLinesOfInput
      [V <: String](newValue: Seq[V])
    : ReceiT
  //

}





/** 
 * schedule an interactive/REPL session,
 * starting from toolchain state as specified, in the specified scheduler.
 * 
 * we intend that
 * instantiations of `ToolChainS`
 * get restricted to `type`s describing immutable data-structures, not the "builder-pattern"-ish ones
 * 
 * TODO
 * 
 */
def runFromS
  [
    ToolChainS
    : [R] =>> lscc.asToolChain.SpclEnsureCompiledOp.ForReceiverLUAndReturnVal[R, R, Unit]
    : [R] =>> lscc.asToolChain.SpclAddFromInteractiveFileOps.ForReceiverLU[R, R]
    ,
  ]
  (initialToolchainState: ToolChainS, intendedRunningThread: concurrent.ExecutionContext )
= {
  ;

  import rfsPredef.{*, given }

  object readlineUtil {
    ;

    // TODO
    val lReader = {
      import language.unsafeNulls

      import org.jline

      jline.reader.LineReaderBuilder.builder()
      .build()
    }

    val promptChar = ">"

    /** 
     * `newReadlineSeq` - subject to race-condition!
     * 
     */
    def newReadlineSeq()
    = {
      ;

      LazyList.continually({
        import language.unsafeNulls
        lReader.readLine(promptChar ++ " ")
      })
    }

    /** 
     * `newReadlinePermut` - subject to race-condition!
     * 
     */
    def newReadlinePermut()
    = {
      ;

      lscalg.bnfParsing.BRetrialIterator.from({
        val _ +: itr = {
          ;

          LazyList.iterate[Seq[String] ] (Seq() ) ((existingLOcs) => {
            ;
            existingLOcs :+ {
              val existingTxt
              = existingLOcs.mkString("\r\n")
              ({
                import language.unsafeNulls
                lReader
                .readLine(promptChar ++ " " , null : Null | java.lang.Character, existingTxt )
              })
            }
          })
        } : @unchecked
        itr
      })
      .map(_.to(LazyList ) )
      .nn
    } : lscalg.bnfParsing.BRetrialIterator.ForR[LazyList[String ] ]

    /** 
     * `newReadlineFilePermut` - subject to race-condition!
     * 
     */
    def newReadlineFilePermut()
    = {
      ;

      val linesPermut
      = newReadlinePermut()

      linesPermut

      .map(lnes => {
        lscc.spclParsing.spclUtil.Lrp.apply(fileName = "<repl>", c = lnes )
      })
    }

    ;
  }

  trait SpclCompilerOpsImpl {
    ;

    type SpclCompileErrorException
    <: java.lang.Exception

    val SpclCompileErrorException
    : reflect.TypeTest[Any, ? <: SpclCompileErrorException ]

    val SpclParseSyntaxErrorException
    : reflect.TypeTest[Any, ? <: SpclCompileErrorException ]

    ;
  }

  object SpclSt {
    ;

    opaque type _Any
    <: Impl
    = Impl

    case class Impl private[SpclSt] (mainBuildState: ToolChainS, reserved1 : Unit = () )

    lazy val mainBuildLens
    : monocle.Lens[_Any, ToolChainS]
    = {
      monocle.macros.GenLens[Impl](_.mainBuildState)
    }

    def apply
      (s: ToolChainS )
    : _Any
    = Impl(mainBuildState = s )

    // TODO

    extension (s: _Any ) {
      def modify1
        (applyMod1: ([T] =>> (T => T) )[Impl] )
      : _Any
      = applyMod1(s)
    }

    // TODO
    given defaultCompiler
    : SpclCompilerOpsImpl
    = {
      class SpclCompileErrorException1() extends java.io.IOException
      class SpclParseErrorException1() extends SpclCompileErrorException1

      new SpclCompilerOpsImpl {
        ;

        type SpclCompileErrorException
        >: SpclCompileErrorException1
        <: SpclCompileErrorException1

        val SpclCompileErrorException
        : reflect.Typeable[SpclCompileErrorException1]
        = implicitly

        val SpclParseSyntaxErrorException
        : reflect.Typeable[SpclParseErrorException1]
        = implicitly

      }
    }

    given SpclEnsureCompiledOp.ForReceiverLUAndReturnVal[_Any, _Any, Unit]
    = SpclEnsureCompiledOp.fromTotalFunction((e: _Any) => e.mainBuildState.ensureCompiled() )

    given SpclAddFromInteractiveFileOps.ForReceiverLU[_Any, _Any]
    = SpclAddFromInteractiveFileOps.fromFunction ((receiver: _Any, addend) => {
      mainBuildLens
      .modify(s => s.withAddedAnonSrc(addend) )(receiver )
    } )

  }

  extension (receiver: SpclSt.type) {
    //
    def initially()
    : receiver._Any
    = receiver.apply(initialToolchainState )

  }

  import readlineUtil.{*, given}

  concurrent.Future.unit
  .map((_: Unit) => {
    ;

    // TODO
    Iterator.iterate[SpclSt._Any ] (SpclSt.initially() )(existingChainState => {
      ;
      
      val lrfPermut
      = newReadlineFilePermut()

      java.lang.Thread.sleep(250 )
      
      lrfPermut
      .tapEach(_ => {
        ;
        java.lang.Thread.sleep(250 )
      } )
      .collectFirst({
        <:<.refl[lscc.spclParsing.spclUtil.Lrp._Any ]
        .andThen(newFle => {
          ;
          
          existingChainState
          .withAddedAnonSrc({
            newFle.linesNewReader()
          })
          /* attempt compilation */
          .match { case s => {
            ;

            import SpclSt.defaultCompiler.{*, given}

            // TODO
            s
            .match { case s => {
              s
              .tryEnsureCompiled()
              .recover({
                ;
                {
                  // case SpclParseSyntaxErrorException(z) =>
                  //   throw z
                  case SpclCompileErrorException(z) =>
                    z.printOneLineStackTrace()
                }
              })
              .map[s.type] ((_: Unit) => s )
            } }
            .map(v => {
              println(s"compilation successful. ($v) ")
              v
            } )
            .match { case tr => {
              tr.map(Some(_))
              .recover(z => throw (z match {
                //
                case (SpclParseSyntaxErrorException(_) | SpclCompileErrorException(_) ) =>
                  z
                case z => {
                  java.lang.Thread.sleep(1000 )
                  z
                }
              }))
              .recover[Option[SpclSt._Any ] ] ({
                case SpclParseSyntaxErrorException(z) =>
                  z.printOneLineStackTrace()
                  None
                case SpclCompileErrorException(z) =>
                  z.printOneLineStackTrace()
                  Some(s)
              })
              .get
            } }
          } }
          //
          .match { case s => s }
        } )
        .unlift
      })
      .get
    })
    .foreach(toolchainState => {
      println(s"toolchain state: $toolchainState ")
    })

    ;
  })(using intendedRunningThread )

  .satisfies[concurrent.Future[Unit ] ]
}











