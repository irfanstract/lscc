package lscc.spclGrammar.forTermOrTypeLevelExprs













import lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode

import lscc.spclParsedConstructs1.{SpclApModeDependentTuple1, SpclApModeDependentTuple2 }







type AscriptiveExpr
= AscriptiveExprPr[SpclGrammaticalItemMetaDataWrapMode]

trait AscriptiveExprPr[+t <: SpclGrammaticalItemMetaDataWrapMode] @deprecated protected () {}

// TODO
final
lazy val ToTermPatternScrutiveAscription
= (ctx: SpclGrammaticalItemMetaDataWrapMode ) ?=> (_: Any) => new AnyRef with AscriptiveExprPr[ctx.type]

// TODO
final
lazy val ToTypeScrutiveAscription
= (ctx: SpclGrammaticalItemMetaDataWrapMode ) ?=> (_: Any) => new AnyRef with AscriptiveExprPr[ctx.type]

// TODO
final
lazy val SatisfiaScrutiveAscription
= (ctx: SpclGrammaticalItemMetaDataWrapMode ) ?=> (_: Any) => new AnyRef with AscriptiveExprPr[ctx.type]







// TODO
object TermOrTypeAscribedExprImplAst {
  ;

  type _Any
  = TermOrTypeAscribedExprImplAst[?]

  def apply
    //
    (using grmMetadataWrapMode : SpclGrammaticalItemMetaDataWrapMode )
    (bindingSideExpr: grmMetadataWrapMode.AppliedTo[PrefixScrutLhsExpr], ascriptiveSideExpr: grmMetadataWrapMode.AppliedTo[AscriptiveExpr ] )
  = new TermOrTypeAscribedExprImplAst((
    (grmMetadataWrapMode, bindingSideExpr, ascriptiveSideExpr )
    : ((grmMetadataWrapMode.type, bindingSideExpr.type, ascriptiveSideExpr.type ) )
  ) )

  type _DataAny
  = SpclApModeDependentTuple2[[c[_] ] =>> c[PrefixScrutLhsExpr] , [c[_] ] =>> c[AscriptiveExpr] ]

  type ForApmType
    [+T <: SpclGrammaticalItemMetaDataWrapMode ]
  = TermOrTypeAscribedExprImplAst[(
    _DataAny
    & Tuple3[T, ?, ?]
  )]

  ;
}
case class TermOrTypeAscribedExprImplAst
  [+T <: TermOrTypeAscribedExprImplAst._DataAny ] private[TermOrTypeAscribedExprImplAst] (d: T )
//




object ValDefOnlyAst
{
  ;

  type _Any
  = ValDefOnlyAst[?, ?]

  ;
}

case class ValDefOnlyAst
  [
    +Ident,
    +IType ,
  ] (
    ident : Ident ,
    iTypeKw : IType ,
  )
//




// TODO
enum PrefixScrutLhsExpr {
  ;

  case ForIgnorableWildcard()

  case ForValDef(value: ValDefOnlyAst._Any )

}







