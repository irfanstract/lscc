package lscc.asToolChain




























/** 
 * a typeclass serving as interface to a toolchain immutable `AddFile` op.
 * 
 * requires implementations to be non-destructive and therefore immutable-based.
 * 
 */
object SpclAddFileOps
{
  ;

  ;

  type _Any
  = ForReceiverLU[Nothing, Any ]

  type ForReceiverLU[-RL <: RU, +RU]
  = Impl[? >: RL, ? <: RU , ? ]

  trait Impl
    [-RL <: RU, +RU, -Src >: lscc.spclParsing.spclUtil.Lrp._Any ]
  {
    extension (receiver: RL )
      def withAddedSrcFile(addend: Src )
      : RU
  }

  ;

  private[SpclAddFileOps]
  type DefaultSrcT
  >: lscc.spclParsing.spclUtil.Lrp._Any
  <: lscc.spclParsing.spclUtil.Lrp._Any

  def fromFunction
    [R]
    (impl: (receiver: R, addend: DefaultSrcT ) => R )
  : ForReceiverLU[R, R]
  = {
    type Src >: DefaultSrcT <: DefaultSrcT
    new Impl[R, R, DefaultSrcT ]
    {
      //
      extension (receiver: R )
        def withAddedSrcFile(addend: Src )
        = impl.apply(receiver = receiver , addend = addend )
    }
  }

  ;
}

/** 
 * a typeclass serving as interface to a toolchain immutable `AddUnnamedFile` op.
 * 
 * requires implementations to be non-destructive and therefore immutable-based.
 * 
 */
object SpclAddFromInteractiveFileOps
{
  ;

  ;

  type _Any
  = ForReceiverLU[Nothing, Any ]

  type ForReceiverLU[-RL <: RU, +RU]
  = Impl[? >: RL, ? <: RU, ? ]

  trait Impl
    [-RL <: RU, +RU, -Src >: java.io.Reader ]
  {
    extension (receiver: RL )
      def withAddedAnonSrc(file: Src )
      : RU
  }

  ;

  private[SpclAddFromInteractiveFileOps]
  type DefaultSrcT
  >: java.io.Reader
  <: java.io.Reader

  def fromFunction
    [R]
    (impl: (receiver: R, addend: DefaultSrcT ) => R )
  : ForReceiverLU[R, R]
  = {
    type Src >: DefaultSrcT <: DefaultSrcT
    new Impl[R, R, DefaultSrcT ]
    {
      //
      extension (receiver: R )
        def withAddedAnonSrc(addend: Src )
        = impl.apply(receiver = receiver , addend = addend )
    }
  }

  ;
}









