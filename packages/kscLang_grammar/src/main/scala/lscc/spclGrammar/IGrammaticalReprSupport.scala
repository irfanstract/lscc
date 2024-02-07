package lscc.spclGrammar
















/** 
 * 
 * support for AST for TypeAscribedExpr(s) .
 * excludes the typechecking-specific aspects
 * 
 */
trait IGrammmaticalReprSupport
{
  ;

  val metaDataWrapMode
  : lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode._Any

  ;
}

object IGrammmaticalReprSupport
extends
AnyRef
with IGrammmaticalReprSupportLowPriority1
{
  ;

  given givenFrom1
    //
    (using mdtWrapModeImpl: lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode._Any )
  : (IGrammmaticalReprSupport {
    //
    val metaDataWrapMode
    : mdtWrapModeImpl.type
  } )
  = new IGrammmaticalReprSupport {
    //
    val metaDataWrapMode
    : mdtWrapModeImpl.type
    = mdtWrapModeImpl
  }

  ;
}

trait IGrammmaticalReprSupportLowPriority1
{ this : IGrammmaticalReprSupport.type =>
  ;
}










