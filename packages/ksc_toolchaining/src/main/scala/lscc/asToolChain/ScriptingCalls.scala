
package lscc

package asToolChain



















trait ReplWaplWrplOpImpl[ReceiT] {
  ;

  extension (s: ReceiT )
    def withAddedPendingLineOfInput
      [V <: String](value: V)
    : ReceiT

    def withResetPendingLinesOfInput
      [V <: String](newValue: Seq[V])
    : ReceiT
  //

}

trait SpclCompilerOpsExceptionsImpl {
  ;

  type SpclCompileErrorException
  <: java.lang.Exception

  val SpclCompileErrorException
  : reflect.TypeTest[Any, SpclCompileErrorException ]

  type SpclParseSyntaxErrorException
  <: java.lang.Exception & SpclCompileErrorException

  val SpclParseSyntaxErrorException
  : reflect.TypeTest[Any, SpclParseSyntaxErrorException ]

  def newParseSyntaxErrorException1(msg: String)
  : SpclParseSyntaxErrorException
  def newParseSyntaxErrorException1(msg: String, cause: Throwable)
  : SpclParseSyntaxErrorException

  ;
}

object SpclCompilerOpsExceptionsImpl {
  ;

  @deprecated
  transparent inline
  given SpclCompilerOpsExceptionsImpl
  = i

  def i
  : SpclCompilerOpsExceptionsImpl
  = {
    ;

    class SpclCompileErrorException1() extends java.io.IOException
    class SpclParseErrorException1(msg: String) extends SpclCompileErrorException1

    new SpclCompilerOpsExceptionsImpl {
      ;

      type SpclCompileErrorException
      >: SpclCompileErrorException1
      <: SpclCompileErrorException1

      val SpclCompileErrorException
      : reflect.Typeable[SpclCompileErrorException]
      = implicitly

      type SpclParseSyntaxErrorException
      >: SpclParseErrorException1
      <: SpclParseErrorException1

      val SpclParseSyntaxErrorException
      : reflect.Typeable[SpclParseSyntaxErrorException]
      = implicitly

      // TODO

      def newParseSyntaxErrorException1(msg: String)
      = new SpclParseErrorException1(msg = msg )
      def newParseSyntaxErrorException1(msg: String, cause: Throwable)
      = new SpclParseErrorException1(msg = msg )

    } 
  }
}











