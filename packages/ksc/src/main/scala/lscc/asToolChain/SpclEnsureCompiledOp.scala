
package lscc
package asToolChain












object SpclEnsureCompiledOp
{
  ;

  ;

  type _Any
  = ForReceiverLU[Nothing, Any ]

  type ForReceiverLU[-RL <: RU, +RU]
  = ForReceiverLUAndReturnVal[RL, RU, Any ]

  type ForReceiverLUAndReturnVal[-RL <: ReceiU, +ReceiU, +ReturnVl]
  = Impl[? >: RL, ? <: ReceiU , ? <: ReturnVl ]

  trait Impl
    [-RL <: ReceiU, +ReceiU, +R ]
  {
    extension (receiver: RL ) {
      //

      /** 
       * ensure the compilation successful.
       * 
       */
      def ensureCompiled( )
      : R

      /** 
       * ensure the compilation successful.
       * 
       */
      def tryEnsureCompiled( )
      : util.Try[R]

    }
  }

  ;

  def fromTotalFunction
    [Recei, R]
    (impl: (receiver: Recei ) => R )
  : ForReceiverLUAndReturnVal[Recei, Recei , R]
  = {
    new Impl[Recei, Recei, R ]
    {
      //
      extension (receiver: Recei )
        def ensureCompiled( )
        = impl.apply(receiver = receiver )

        def tryEnsureCompiled( )
        = {
          util.Try({
            receiver.ensureCompiled()
          })
        }
    }
  }

  ;
}








