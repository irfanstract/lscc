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

    transparent inline
    def thisSpi
    : Spi.this.type
    = this

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

    export _Impl1.{Some as PositiveInstance }

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

        // transparent inline
        def toOption
        = {
          scala.Some[this1.type](this1 )
          .flatMap[this1.type & _Impl1.Some ] ({
            implicitly[reflect.TypeTest[this1.type, _Impl1.Some ] ]
            .match { case tt => tt.unapply _ }
            .match { case f => f }
          } )
        }

        export toOption.{fold as fold1 }

        //
      }

      extension (this1: _Impl1) {
        //

        /**
         * `orElse`
         */
        transparent inline
        def orElse
          (altVal: => _Impl1 )
        = {
          this1.toOption
          .fold[_Impl1 ] (altVal )(<:<.refl[_Impl1.Some ] )
        }

        /**
         * `flatMap`
         */
        transparent inline
        def flatMap
          [R <: _Impl1 ]
          (m: (_Impl1.Some & this1.type ) => R )
        = {
          this1.toOption
          .fold[_Impl1.None.type | R ] (_Impl1.None )(m )
        }

      }

      extension [T <: _Impl1] (this1: T)
        (using ([T] =>> (T =:= T ) )[thisSpi.type ] )
        (using ([T] =>> (T =:= T ) )[_Impl1 ] )
      {
        //

        transparent inline
        def collect
          [R <: _Impl1 ]
          (m: PartialFunction[_Impl1.Some & T , R] )
        = {
          this1
          .match { case e => {
            e
            .match {
              case m(v1) => v1
              case _ => _Impl1.None
            }
          } : (R | _Impl1.None.type ) }
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

      extension (e: _Impl1.Some )
        def matchedStr
        : String
        = e.prod._1.head
      //

      ;
    }

    ;

    def describeAfterDigestTuple1
      //
      (finalPos: Kp, prod: (IndexedSeq[String], util.matching.Regex ) )
    = {
      ;
      _Impl1.Some(nextPos = finalPos , prod = prod ) : _Impl1.Some
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
    { val `given:Spi[Kp]` = new Spi[Kp] ; export `given:Spi[Kp]`.{*, given } }

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












