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
  = ForReceiverLUAndSrcType[Nothing, Any, Nothing ]

  type ForReceiverAndSrcType[R, -Src ]
  = ForReceiverLUAndSrcType[R, R, Src ]

  type ForReceiverLUAndSrcType[-RL <: RU, +RU, -Src ]
  = Impl[? >: RL <: RU, ? >: Src ]

  ;

  type LazyBlob
  = lscc.spclParsing.spclUtil.Lrp._Any

  ;


  protected
  trait Impl
    [R, -Src ]
  {
    extension (receiver: R )
      def withAddedSrcFile(addend: Src )
      : R
  }

  ;

  def fromFunction
    [R, DefaultSrcT ]
    (impl: (receiver: R, addend: DefaultSrcT ) => R )
  : ForReceiverAndSrcType[R, DefaultSrcT]
  = {
    type Src >: DefaultSrcT <: DefaultSrcT
    new Impl[R, DefaultSrcT ]
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
  = Impl1[?, ? ]

  type ForReceiverLU[-RL <: RU, +RU]
  = ForReceiverLUAndSrcType[RL, RU, java.io.Reader ]

  type ForReceiverLUAndSrcType[-RL <: RU, +RU, -Src >: java.io.Reader]
  = Impl1[? >: RL <: RU, Src ]

  protected
  trait Impl1
    [R, -Src >: java.io.Reader ]
  {
    extension (receiver: R )
      def withAddedAnonSrc(file: Src )
      : R
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
    new Impl1[R, DefaultSrcT ]
    {
      //
      extension (receiver: R )
        def withAddedAnonSrc(addend: Src )
        = impl.apply(receiver = receiver , addend = addend )
    }
  }

  ;
}









