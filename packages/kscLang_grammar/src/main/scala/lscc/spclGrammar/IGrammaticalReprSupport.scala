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

  ;

  type OfSpecificMetaDataWrapMode[+M <: lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode._Any ]
  = (IGrammmaticalReprSupport {
    //
    val metaDataWrapMode
    : M
  } )

  given givenFromImplicitGrammaticalPxery
    //
    [CI <: lscc.spclParsedConstructs1.SpclGrammaticalPxery ]
    (using ctx: CI )
  : (IGrammmaticalReprSupport.OfSpecificMetaDataWrapMode[ctx.grmMetadataWrapMode.type ] )
  = {
    import ctx.given

    givenFrom1
  }

  ;
}

trait IGrammmaticalReprSupportLowPriority1
{ this : IGrammmaticalReprSupport.type =>
  ;

  given givenFrom1
    //
    [MdwModeI <: lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode._Any ]
    (using mdtWrapModeImpl: MdwModeI )
  : (IGrammmaticalReprSupport.OfSpecificMetaDataWrapMode[mdtWrapModeImpl.type ] )
  = new IGrammmaticalReprSupport {
    //
    val metaDataWrapMode
    : mdtWrapModeImpl.type
    = mdtWrapModeImpl
  }

}










