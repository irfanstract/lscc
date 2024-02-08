package lscc.spclGrammar.forTermAscriptiveScrut














import lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode

import lscc.spclParsedConstructs1.{SpclApModeDependentTuple1, SpclApModeDependentTuple2 }







// TODO
final
lazy val ToTermPatternScrutiveAscription
= (ctx: IAscriptiveExprGrammmaticalReprSupport ) ?=> (_: Any) => (??? : ctx.TermOrTypeAscribedExprImplAst)

// TODO
final
lazy val ToTypeScrutiveAscription
= (ctx: IAscriptiveExprGrammmaticalReprSupport ) ?=> (_: Any) => (??? : ctx.TermOrTypeAscribedExprImplAst)

// TODO
final
lazy val SatisfiaScrutiveAscription
= (ctx: IAscriptiveExprGrammmaticalReprSupport ) ?=> (_: Any) => (??? : ctx.TermOrTypeAscribedExprImplAst)







/** 
 * 
 * support for AST for TypeAscribedExpr(s) .
 * excludes the typechecking-specific aspects
 * 
 */
trait IAscriptiveExprGrammmaticalReprSupport
{
  ;

  val ctx
  : lscc.spclGrammar.IGrammmaticalReprSupport

  import ctx.metaDataWrapMode as grmMetadataWrapMode

  type AscriptiveExpr

  // TODO
  enum PrefixScrutLhsExpr {
    ;

    case ForIgnorableWildcard()

    case ForValDef(value: ValDefAlikeOnlyAst._Any )

  }

  case class TermOrTypeAscribedExprImplAst
    //
    (bindingSideExpr: grmMetadataWrapMode.AppliedTo[PrefixScrutLhsExpr], ascriptiveSideExpr: grmMetadataWrapMode.AppliedTo[AscriptiveExpr ] )

  ;
}

object IAscriptiveExprGrammmaticalReprSupport
{
  ;

  transparent inline
  def fromGiven(using impl: IAscriptiveExprGrammmaticalReprSupport )
  : impl.type
  = impl

  given givenFrom1
    //
    [C <: lscc.spclGrammar.IGrammmaticalReprSupport ]
    (using ctxImpl: C  )
  : IAscriptiveExprGrammmaticalReprSupport with {
    ;

    val ctx
    : ctxImpl.type
    = ctxImpl
  }

  ;
}






object ValDefAlikeOnlyAst
{
  ;

  type _Any
  = ValDefAlikeOnlyAst[?, ?]

  ;
}

case class ValDefAlikeOnlyAst
  [
    +Ident,
    +IType ,
  ] (
    ident : Ident ,
    iTypeKw : IType ,
  )
//











