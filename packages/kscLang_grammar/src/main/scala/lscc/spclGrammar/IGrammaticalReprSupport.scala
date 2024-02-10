package lscc.spclGrammar
















/** 
 * 
 * support for AST for TypeAscribedExpr(s) .
 * excludes the typechecking-specific aspects
 * 
 */
trait IGrammmaticalReprSupportFromGrmPxery
  //
  [+Ctx <: lscc.spclParsedConstructs1.SpclPxeryOpsGivenFispoSupps ]
  (val backingPxery : Ctx )
extends
AnyRef
with IGrammmaticalReprSupport
{
  ;

  // override
  export backingPxery.grmMetadataWrapMode as metaDataWrapMode

  ;
}

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

  type OfSpecificMetaDataWrapMode
    [+M <: lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode._Any ]
  = (
    IGrammmaticalReprSupport {
      //
      val metaDataWrapMode
      : M
    }
  )

  type FromGrmPxery[+Ctx <: lscc.spclParsedConstructs1.SpclPxeryOpsGivenFispoSupps ]
  >: IGrammmaticalReprSupportFromGrmPxery[Ctx ] @annotation.unchecked.uncheckedVariance
  <: IGrammmaticalReprSupportFromGrmPxery[Ctx ]

  //

  implicit def givenFromImplicitGrammaticalPxery
    //
    [CI <: lscc.spclParsedConstructs1.SpclGrammaticalPxery ]
    (using ctx: CI )
  // : (IGrammmaticalReprSupport.OfSpecificMetaDataWrapMode[ctx.grmMetadataWrapMode.type ] )
  : (IGrammmaticalReprSupportFromGrmPxery[ctx.type ] )
  = {
    import ctx.given

    new AnyRef with IGrammmaticalReprSupportFromGrmPxery[ctx.type ](backingPxery = ctx )
    .nn
  }

  ;
}

trait IGrammmaticalReprSupportLowPriority1
{ this : IGrammmaticalReprSupport.type =>
  ;

  implicit def givenFrom1
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










