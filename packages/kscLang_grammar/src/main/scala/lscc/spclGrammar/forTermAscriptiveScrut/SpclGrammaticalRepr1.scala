package lscc.spclGrammar.forTermAscriptiveScrut














import lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode

import lscc.spclParsedConstructs1.{SpclApModeDependentTuple1, SpclApModeDependentTuple2 }







// TODO
final
lazy val ToTermPatternScrutiveAscription
= (ctx: IAscriptiveExprGrammmaticalReprSupport ) ?=> (c: ctx.E1) => ({
  ;
  import ctx.{*}

  TermOrTypeAscribedExprImplAst(
    bindingSideExpr =
      c
      .match { case c => {
        UntypedValDefAlikeAst1(iTypeKw = VAL, ident = c )
      } }
      .match { case c => {
        PrefixScrutLhsExpr.ForValDef(value = c )
      } }
      .withoutSrcInfo()
    , ascriptiveSideExpr =
      AscriptiveExpr.NONE
      .withoutSrcInfo()
    )
}.nn : ctx.TermOrTypeAscribedExprImplAst)

// TODO
final
lazy val ToTypeScrutiveAscription
= (ctx: IAscriptiveExprGrammmaticalReprSupport ) ?=> (c: ctx.E1) => (??? : ctx.TermOrTypeAscribedExprImplAst)

// TODO
final
lazy val SatisfiaScrutiveAscription
= (ctx: IAscriptiveExprGrammmaticalReprSupport ) ?=> (c: ctx.E1) => (??? : ctx.TermOrTypeAscribedExprImplAst)







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
  >: AscriptiveExpr1
  <: AscriptiveExpr1
  lazy val AscriptiveExpr = AscriptiveExpr1

  enum AscriptiveExpr1 {
    case NONE
  }

  // TODO
  enum PrefixScrutLhsExpr {
    ;

    case ForIgnorableWildcard()

    case ForValDef(value: UntypedValDefAlikeAst )

  }

  case class TermOrTypeAscribedExprImplAst
    //
    (bindingSideExpr: grmMetadataWrapMode.AppliedTo[PrefixScrutLhsExpr],
    ascriptiveSideExpr: grmMetadataWrapMode.AppliedTo[AscriptiveExpr ] )
  {}

  type UntypedValDefAlikeAst
  = UntypedValDefAlikeAst1[?, ?]

  case class UntypedValDefAlikeAst1
    [
      +Ident,
      +IType ,
    ] (
      ident : Ident ,
      iTypeKw : IType ,
    )
  {}

  ;

  export ctx.metaDataWrapMode.withSrcInfo

  extension [R] (r: R) {
    // TODO
    @deprecated
    def withoutSrcInfo()
    = {
      r
      .withSrcInfo(srcPosInfo = ().asInstanceOf[ctx.metaDataWrapMode.SrcPtrInfo ] )
    }
  }

  type E1
  >: grmMetadataWrapMode.AppliedTo[Any]
  <: grmMetadataWrapMode.AppliedTo[Any]

  opaque type ITypeKw1 = String
  final lazy val CONSTRAINT : ITypeKw1 = "given that"
  final lazy val TERMDEF : ITypeKw1 = "method"
  final lazy val TYPEDEF : ITypeKw1 = "type"
  final lazy val VAL : ITypeKw1 = "val"
  final lazy val CLASS : ITypeKw1 = "class"
  final lazy val EXPORT : ITypeKw1 = "export"

  ;
}

object IAscriptiveExprGrammmaticalReprSupport
{
  ;

  /* TYPE-ALIASES AND FACTORYLIKE SUMMONERS */

  type _Any = IAscriptiveExprGrammmaticalReprSupport

  type OfSpecificIegrc[+M <: lscc.spclGrammar.IGrammmaticalReprSupport ]
  = (_Any {
    //
    val ctx: M
  } )

  type OfSpecificMetaDataWrapMode[+M <: lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode._Any ]
  = OfSpecificIegrc[(
    lscc.spclGrammar.IGrammmaticalReprSupport.OfSpecificMetaDataWrapMode[M ]
  )]

  transparent inline
  def fromGiven(using impl: IAscriptiveExprGrammmaticalReprSupport )
  : impl.type
  = impl

  ;

  /* GIVEN INSTANCES */

  transparent inline
  given givenFromImpliedIGrammmaticalReprSupport
    //
    [C <: lscc.spclGrammar.IGrammmaticalReprSupport ]
    (using ctxImpl: C  )
  : OfSpecificIegrc[ctxImpl.type ]
  = fromIGrammmaticalReprSupport

  ;

  /* TRUE FACTORY METHODS */

  def fromIGrammmaticalReprSupport
    //
    [C <: lscc.spclGrammar.IGrammmaticalReprSupport ]
    (using ctxImpl: C  )
  = new IAscriptiveExprGrammmaticalReprSupport {
    ;

    val ctx
    : ctxImpl.type
    = ctxImpl
  }

  ;
}






// object ValDefAlikeOnlyAst
// {
//   ;

//   type _Any
//   = ValDefAlikeOnlyAst[?, ?]

//   ;
// }

// case class ValDefAlikeOnlyAst
//   [
//     +Ident,
//     +IType ,
//   ] (
//     ident : Ident ,
//     iTypeKw : IType ,
//   )
// //

object ValDefAlikeOnlyAst
{
  ;

  type _Any
  = ValDefAlikeOnlyAst[?, ?]

  // TODO
  def apply
    [
      Ident,
      IType ,
    ]
    (
      ident : Ident ,
      iTypeKw : IType ,
    )
    (using ctx : IAscriptiveExprGrammmaticalReprSupport )
  : ctx.UntypedValDefAlikeAst
  = ctx.UntypedValDefAlikeAst1(iTypeKw = iTypeKw, ident = ident )

  ;
}

type ValDefAlikeOnlyAst[+T1, +T2]
=
  // TODO
  IAscriptiveExprGrammmaticalReprSupport#UntypedValDefAlikeAst











