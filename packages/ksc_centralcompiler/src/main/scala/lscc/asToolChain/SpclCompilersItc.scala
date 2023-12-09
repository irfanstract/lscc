package lscc.asToolChain




















type RfsSpclCentralCompilerOpsImpl
=    RfsSpclCentralCompilerOpsImpl._Any

object RfsSpclCentralCompilerOpsImpl {
  ;

  ;

  def apply
    //
    (
      //
      exceptionsCtor: SpclCompilerOpsExceptionsImpl
      ,
    )
  : _Any & WithGivenExceptionsCtor[exceptionsCtor.type ]
  = {
    val wrppr
    = Impl(d = ((), exceptionsCtor ) : (Unit, exceptionsCtor.type ) )

    wrppr
  }

  /** 
   * as `class`es doesn't directly support dependent-typing,
   * we need to resort to combination of `Tuple`, path-dependent typing, generics, (on `case class`)
   * 
   */
  case class Impl
    [+T <: (Unit, SpclCompilerOpsExceptionsImpl ) ]
    (d: T )
  {
    export d.{_2 as SpclException }
  }

  opaque type _Any
  <: Impl[?]
  = Impl[?]

  opaque type WithGivenExceptionsCtor
    [+T <: SpclCompilerOpsExceptionsImpl ]
  <: (
    /**
     * can't safely refine non-concrete types,
     * hence re-iterating `Impl[?]` the second time
     */
    _Any & (
      Impl[?] { val SpclException : T }
    )
  )
  = Impl[?] { val SpclException : T }

  ;

  ;

  @deprecated("WIP")
  given _Any
  = apply(
    exceptionsCtor = SpclCompilerOpsExceptionsImpl.i )

  ;
}











