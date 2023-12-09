
package lscc

package asToolChain
package ext













object rfsPredef {
  ;

  type SpclBufferedLnocSeq[A]
  >: (List[A] | IndexedSeq[A] )
  <: (List[A] | IndexedSeq[A] )

  extension [A] (receiver: A ) {
    transparent inline
    def satisfies[A1](using SatisfiesOpEvid.ForTypes[receiver.type, A1] )
    : receiver.type
    = receiver
  }

  object SatisfiesOpEvid {
    opaque type ForTypes[-L, +U]
    = true

    given forTypeConformance[L, U]
      (using L <:< U )
    : ForTypes[L, U]
    = true

    @deprecated
    given forTypeConversion [L, U]
      (using util.NotGiven[L <:< U] )
      (using Conversion[L, U] )
    : ForTypes[L, U]
    = true

  }

  object OpqScheduler {
    ;

    // opaque type ForCc
    //   [+Cc[+R] ]
    // <: AnyRef
    // =  [R] => (main : DummyImplicit ?=> R ) => Cc[R]

    // type _Any
    // = ForCc[[_] => Any ]

    // extension [Cc[+R] ] (impl: ForCc[Cc] ) {
    //   def applyTo
    //     [R] (c: DummyImplicit ?=> R )
    //   : Cc[R]
    //   = impl.apply(c)
    // }

    ;

    ;
  }

  ;

  extension (d: Throwable) {
    //

    def printOneLineStackTrace()
    : Unit
    = {
      import language.unsafeNulls
      System.err.println(d)
    }
  }

  ;

  def enableVerboseOrgJLineLogging()
  : Unit
  = {
    ;

    import language.unsafeNulls

    import java.util.logging.{Logger, * }

    Logger.getLogger("org.jline")
    .setLevel(Level.FINER )
  }

  ;
}










