
package lscc

package asToolChain














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
    : [R] =>> lscc.asToolChain.SpclEnsureCompiledOp.ForReceiverLU[R, R]
    : [R] =>> lscc.asToolChain.SpclAddFromInteractiveFileOps.ForReceiverLU[R, R]
    ,
  ]
  (initialToolchainState: ToolChainS, intendedRunningThread: concurrent.ExecutionContext )
= {
  ;

  concurrent.Future.unit
  .map((_: Unit) => {
    ;

    type SpclBufferedLnocSeq[A]
    >: (List[A] | IndexedSeq[A] )
    <: (List[A] | IndexedSeq[A] )

    object SpclSt {
      ;
      opaque type _Any
      <: AnyRef
      = Impl 
      def apply
        (s: ToolChainS, pendingLines: SpclBufferedLnocSeq[String])
      : _Any
      = Impl(s, pendingLines = pendingLines )

      case class Impl(s: ToolChainS, pendingLines: SpclBufferedLnocSeq[String])

      val iPendingLinesLens
      : monocle.Lens[_Any, SpclBufferedLnocSeq[String] ]
      = monocle.macros.GenLens[Impl](_.pendingLines)

      // TODO

      extension (s: _Any )
        def withAddedPendingLineOfInput
          [V <: String](value: V)
        = iPendingLinesLens.modify(_.appended(value) )(s)

      extension (s: _Any )
        def afterDigestOfPendingInput
          [V <: String]( )
        = s

    }

    // TODO
    Iterator.iterate[SpclSt._Any ] (SpclSt(initialToolchainState, pendingLines = IndexedSeq() ) )(st0 => {
      ;

      val failedWithSyntaxError
      = locally[Boolean] (false )

      st0
      .match { case s => {
        if failedWithSyntaxError then
          s
        else s.afterDigestOfPendingInput()
      } }
    })
    .foreach(toolchainState => {
      println(s"toolchain state: $toolchainState ")
    })

    ;
  })(using intendedRunningThread )
}











