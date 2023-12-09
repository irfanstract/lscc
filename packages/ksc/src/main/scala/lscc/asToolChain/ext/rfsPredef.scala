
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
}










