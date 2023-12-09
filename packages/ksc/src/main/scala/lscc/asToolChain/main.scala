
package lscc

package asToolChain














import lscc.asToolChain.ext.rfsPredef






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
  (using SpclCompilerOpsExceptionsImpl )
  (initialToolchainState: ToolChainS, intendedRunningThread: concurrent.ExecutionContext )
  (using 5 <:< 5 )
= {
  ;

  import rfsPredef.{*, given }

  val readlineUtil
  = SpclStdInReadline()

  type SpclCompilerOpsImpl
  >: SpclCompilerOpsExceptionsImpl
  <: SpclCompilerOpsExceptionsImpl

  transparent inline
  def defaultCompilerSts
  = summon[SpclCompilerOpsImpl ]

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
      defaultCompilerSts
    }

    final
    lazy val defaultCompilerExceptions
    : SpclCompilerOpsExceptionsImpl
    = defaultCompiler

    given SpclEnsureCompiledOp.ForReceiverLUAndReturnVal[_Any, _Any, Unit]
    = SpclEnsureCompiledOp.fromTotalFunction((e: _Any) => e.mainBuildState.ensureCompiled() )

    given SpclAddFromInteractiveFileOps.ForReceiverLU[_Any, _Any]
    = SpclAddFromInteractiveFileOps.fromFunction ((receiver: _Any, addend) => {
      mainBuildLens
      .modify(s => s.withAddedAnonSrc(addend) )(receiver )
    } )

    given tecOps
    : ToEnsureCompiledOrThereofError[_Any]
    = ToEnsureCompiledOrThereofError[_Any]

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

            import SpclSt.defaultCompilerExceptions.{*, given}

            // TODO
            s
            .ensureCompiledOrThereofErrorOption()
          } }
          //
          .match { case s => s }
        } )
        .unlift
      })
      .get
    })
    .foreach(toolchainState => {
      println(s"shifted toolchain state: $toolchainState ")
    })

    ;
  })(using intendedRunningThread )

  .satisfies[concurrent.Future[Unit ] ]
}











