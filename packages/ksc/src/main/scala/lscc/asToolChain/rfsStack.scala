
package lscc

package asToolChain














import lscc.asToolChain.ext.rfsPredef






/** 
 * schedule an interactive/REPL session,
 * starting from toolchain state as specified, in the specified scheduler.
 * 
 * see `runFromSAlt`
 * 
 */
def runFromS
  [
    ToolChainS
    : [R] =>> lscc.asToolChain.SpclEnsureCompiledOp.ForReceiverLUAndReturnVal[R, R, Unit]
    : [R] =>> lscc.asToolChain.SpclAddFromInteractiveFileOps.ForReceiverLU[R, R]
    ,
  ]
  (using RfsSpclCentralCompilerOpsImpl )
  (initialToolchainState: ToolChainS, intendedRunningThread: concurrent.ExecutionContext )
  (using 5 <:< 5 )
= {
  ;

  import RfsStack.instance.{*, given }

  val ToolChainS1
  = RfsStack.SpclAdaptedToolChainCtor[ToolChainS ] (initialToolchainState = initialToolchainState)

  runFromSAlt
    (toolChainCtor = ToolChainS1 ,
    initialToolchainState = initialToolchainState,
    intendedRunningThread = intendedRunningThread  )
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
def runFromSAlt
  // [
  //   ToolChainS
  //   : [R] =>> lscc.asToolChain.SpclEnsureCompiledOp.ForReceiverLUAndReturnVal[R, R, Unit]
  //   : [R] =>> lscc.asToolChain.SpclAddFromInteractiveFileOps.ForReceiverLU[R, R]
  //   ,
  // ]
  (using RfsSpclCentralCompilerOpsImpl )
  (toolChainCtor : RfsStack.SpclAdaptedToolChainCtor._Any ,
  initialToolchainState: toolChainCtor._Any, intendedRunningThread: concurrent.ExecutionContext )
  (using 5 <:< 5 )
= {
  ;
  transparent inline def ToolChainS1
  = toolChainCtor

  import ToolChainS1.{_Any as ToolChainS}

  import RfsStack.instance.{*, given }

  import rfsPredef.{*, given }

  transparent inline
  def defaultCompilerSts
  : RfsSpclCentralCompilerOpsImpl
  = summon[SpclCentralCompilerOpsImpl ]

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
    : SpclCentralCompilerOpsImpl
    = {
      defaultCompilerSts
    }

    final
    lazy val defaultCompilerExceptions
    : SpclCompilerOpsExceptionsImpl
    = defaultCompiler.SpclException

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

  val readlineUtil
  = SpclStdInReadline()

  val mainRunCompletion = {
    ;

    import readlineUtil.{*, given}

    concurrent.Future.unit
    .map((_: Unit) => {
      ;

      // TODO
      Iterator.iterate[SpclSt._Any ] (SpclSt.initially() )(existingChainState => {
        ;

        val currentTurnLrfPermut
        = newReadlineFilePermut()

        java.lang.Thread.sleep(125 )

        currentTurnLrfPermut
        .tapEach(_ => {
          ;
          java.lang.Thread.sleep(125 )
        } )
        .collect({
          <:<.refl[lscc.spclParsing.spclUtil.Lrp._Any ]
          .andThen(newFle => {
            ;

            import SpclSt.defaultCompilerExceptions.{*, given}

            existingChainState
            /* add as unnamed file */
            .withAddedAnonSrc({
              newFle.linesNewReader()
            })
            /* attempt compilation */
            .match { case s => {
              ;
              // TODO
              s
              .ensureCompiledOrThereofErrorOption()
            } }
            /* finally */
            .match { case s => s }
          } )
          .unlift
        })
        .match { case tr => {
          tr
          .headOption
          .getOrElse({
            existingChainState
          })
        } }
      })
      .tapEach(toolchainState => {
        println(s"toolchain state: $toolchainState ")
      })
      .foreach(toolchainState => {
        // no code
      })

      ;
    })(using intendedRunningThread )

    .satisfies[concurrent.Future[Unit ] ]
  }

  mainRunCompletion
}

object RfsStack {
  ;

  // transparent inline
  // def instance
  final
  lazy val instance
  : impl.type
  = impl

  private[RfsStack]
  object impl {
    ;

    type SpclCentralCompilerOpsImpl
    >: RfsSpclCentralCompilerOpsImpl
    <: RfsSpclCentralCompilerOpsImpl

  }

  ;

  transparent inline
  def SpclAdaptedToolChainCtor
  = RfsSpclAdaptedToolChainCtor

  ;
}

object RfsSpclAdaptedToolChainCtor {
  ;

  ;

  def apply
    //
    // [
    //   ToolChainS
    //   : [R] =>> lscc.asToolChain.SpclEnsureCompiledOp.ForReceiverLUAndReturnVal[R, R, Unit]
    //   : [R] =>> lscc.asToolChain.SpclAddFromInteractiveFileOps.ForReceiverLU[R, R]
    //   ,
    // ]
    [R]
    (using EC : lscc.asToolChain.SpclEnsureCompiledOp.ForReceiverLUAndReturnVal[R, R, Unit] )
    (using REPF : lscc.asToolChain.SpclAddFromInteractiveFileOps.ForReceiverLU[R, R] )
    (using RfsSpclCentralCompilerOpsImpl )
    (initialToolchainState: R )
  = {
    type ToolChainS = R

    ({
      ;

      new Impl {

        type _Any
        >: ToolChainS
        <: ToolChainS

        val given_SpclEnsureCompiledOp
        = EC

        val given_SpclAddReplFile
        = REPF

        // export gvns.{*}

      }
    })
  }
  ///

  type _Any
  >: Impl
  <: Impl

  // private[RfsS]
  trait Impl
  {
    //

    type _Any

    implicit
    val given_SpclEnsureCompiledOp
    : ([R] =>> lscc.asToolChain.SpclEnsureCompiledOp.ForReceiverLUAndReturnVal[R, R, Unit] )[_Any]

    implicit
    val given_SpclAddReplFile
    : ([R] =>> lscc.asToolChain.SpclAddFromInteractiveFileOps.ForReceiverLU[R, R] )[_Any]

    //
  }

  ;
}











