package lscalg.bnfParsing

package  spclDequeueFncCombiners














object PartialFunctionLiftStyle {
  ;

  type _Any
  = _ForC[[a, r] =>> Any ]

  opaque type _ForC[C[-A, +R] ]
  <: (WithAsl[C], Any )
  = (
    (WithAsl[C], Any ) {
      val _1 : WithAsl[C]
      val _2
      : [A, R] => DummyImplicit ?=> ([T0, T2] =>> (T2 => T0, T0 => T2 ) )[PartialFunction[A, R], C[A, R] ]
    }
  )

  type WithAsl[C[-A, +R] ]
  = {
    //
    type AsLifted[-A, +R]
    = C[A, R]
  }

  val for0
  = {
    ("""""" , (<:<.refl[Any] , <:<.refl[Any] ) )
    .asInstanceOf[_ForC[[a, r] =>> PartialFunction[a, r] ] ]
  }

  val for1
  = {
    ("""""" , ((_: Function1[?, Option[?] ] ).unlift , (_: PartialFunction[?, ?]).lift ) )
    .asInstanceOf[_ForC[[a, r] =>> Function1[a, Option[r]] ] ]
  }

  ;
}







