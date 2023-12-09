package lscalg.bnfParsing
















object SpclTokenisedItemOption
{
  ;

  ;

  ;

  private[SpclTokenisedItemOption]
  class Spi
    //
    [Kp]
  {
    ;

    type _Any
    >: _Impl
    <: _Impl

    final
    lazy val negativeInstance
    : _Any & _Impl.None.type
    = _Impl.None
    type negativeInstance
    = _Any & _Impl.None.type

    def apply
      //
      (nextPos: Kp, prod: (IndexedSeq[String], util.matching.Regex ) )
    = _Impl.Some(nextPos = nextPos , prod = prod )

    ;

    private[Spi]
    final
    lazy
    val  _Impl = _Impl1
    private[Spi]
    type _Impl = _Impl1

    enum _Impl1 {
      case None
      case Some(nextPos: Kp, prod: (IndexedSeq[String], util.matching.Regex ) )

    }

    object _Impl1 {
      ;

      extension (this1: _Impl1) {
        //

        def toOption
        = {
          this1 match {
            case _Impl1.None => scala.None
            case (e : _Impl1.Some) => scala.Some(e )
          }
        }

        /**
         * `orElse` (not `Option`)
         */
        def orElse
          (altVal: => _Impl1 )
        = {
          this1.toOption
          .fold[_Impl1 ] (altVal )(<:<.refl[_Impl1.Some ] )
        }

      }

      extension (this1: _Impl1.Some ) {
        //

        /** map */
        def mapNextPos
          //
          [OtherKp]
          (using dest : Spi[OtherKp] )
          (fnc: Kp => OtherKp )
        : dest._Impl.Some
        = {
          dest._Impl.Some(
            nextPos = this1.nextPos match { case p => fnc(p) }
            ,
            prod = this1.prod )
        }
      }

      ;
    }

  }

  ;

  object SpclConstructor {
    ;

    type ForCheckptType
      [Kp]
    = ForCheckptTypeLU[Kp, Kp ]

    type ForCheckptTypeLU
      [-KpL <: KpU, +KpU]
    // >: Spi[? >: KpL <: KpU]
    // <: Spi[? >: KpL <: KpU]
    = ForCheckptTypeImpl[? >: KpL <: KpU]

    private[SpclConstructor]
    class ForCheckptTypeImpl
      [Kp]
    { val `Spi[Kp]` = new Spi[Kp] ; export `Spi[Kp]`.{*, given } }

    type _Any
    = ForCheckptTypeLU[Nothing, Any]

    given [Kp]
    : ForCheckptType[Kp]
    = forCheckptType[Kp]

    given sameness1[T1 <: _Any, T2 <: _Any] : (T1 =:= T2)
    = {
      <:<.refl[Any]
      .asInstanceOf[T1 =:= T2 ]
    }

    def forCheckptType[Kp]
    = instance.asInstanceOf[ForCheckptType[Kp] ]

    private
    given instance
    : _Any
    = new ForCheckptTypeImpl[Any]

    ;
  }

  ;
}












