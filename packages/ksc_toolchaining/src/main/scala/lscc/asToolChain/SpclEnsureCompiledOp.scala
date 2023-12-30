
package lscc
package asToolChain












object SpclEnsureCompiledOp
{
  ;

  ;

  type _Any
  = ForReceiverLUAndReturnVal[Nothing, Any, Any ]

  type ForReceiverLU[-RL <: RU, +RU]
  = ForReceiverLUAndReturnVal[RL, RU, Any ]

  type ForReceiverLUAndReturnVal[-ReceiL <: ReceiU, +ReceiU, +R]
  = Impl1[? >: ReceiL <: ReceiU, ? <: R ]

  // @deprecated
  // protected
  // type Impl
  //   [-ReceiL <: ReceiU, +ReceiU, +R ]
  // = Impl1[? >: ReceiL <: ReceiU, ? <: R ]

  protected
  trait Impl1
    [ReceiT, +R ]
  {
    extension (receiver: ReceiT ) {
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
    new ForReceiverLUAndReturnVal[Recei, Recei, R ]
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








