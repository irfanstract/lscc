package lscc.spclTerminalGrammarsB

















import lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode




import lscc.spclParsedConstructs1.{SpclPxeryOpsGivenFispoSupps, SpclPxeryOpsSdfDefine }


trait SpclPxery
extends
AnyRef
with SpclPxeryOpsGivenFispoSupps
with SpclPxeryOpsSdfDefine
{
  ;

  implicit
  val givenFispoSupp
  : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any

  implicit
  val grmMetadataWrapMode
  : SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ]

  implicit
  val expcRx
  : lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ]

  ;

  // /** 
  //  * spcl ParseFunction/FromSrcStreamDigestFnc which yields as-value instance-of `Value`
  //  * 
  //  */
  // type SpclSdfYielding
  //   [+Value]
  // = SpclSdfYieldingUnwrapped[grmMetadataWrapMode.AfterSi[Value ] ]

  // type SpclSdfYieldingUnwrapped
  //   [+Value]
  // >: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , ([e] =>> e )[Value ] ] @annotation.unchecked.uncheckedVariance
  // <: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , ([e] =>> e )[Value ] ] //

  ;
}

object SpclPxery
extends
AnyRef
with SpclPxeryReducedPriorityImplicits
with SpclPxeryLowPrioImplicits
{
  ;

  ;

  implicit
  // transparent inline
  def makeFromGrammaticalManif
    //
    (using ctx : lscc.spclParsedConstructs1.SpclGrammaticalPxery )
  //
  : SpclPxery {val givenFispoSupp: ctx.givenFispoSupp.type; val grmMetadataWrapMode: ctx.grmMetadataWrapMode.type; val expcRx: ctx.expcRx.type }
  = {
    ;
    import ctx.given
    make
  }.nn

  ;
}

protected 
trait SpclPxeryReducedPriorityImplicits
extends
AnyRef
{ this : SpclPxery.type =>
  ;

  implicit
  def make
    //
    (using g : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using a : SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[g.T, g.T ] )
    (using eRx : (
      lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[g.T, util.matching.Regex, g.SpclAfterDigestTupleOption._Any ] 
    ))
  //
  : SpclPxery {val givenFispoSupp: g.type; val grmMetadataWrapMode: a.type; val expcRx: eRx.type}
  = {
    new SpclPxery {
      ;
      val givenFispoSupp : g.type = valueOf
      val grmMetadataWrapMode : a.type = valueOf
      val expcRx : eRx.type = valueOf
    }
    .nn
  }

}

protected 
trait SpclPxeryLowPrioImplicits
extends
AnyRef
{ this : SpclPxery.type =>
  ;

  @deprecated("this factory-method makes its own choice of 'SpclGrammaticalItemMetaDataWrapMode', possibly undesirable one.")
  implicit
  // transparent inline
  def makeAlt
    //
    (using g : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using eRx : (
      lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[g.T, util.matching.Regex, g.SpclAfterDigestTupleOption._Any ] 
    ))
  //
  : (SpclPxery {val givenFispoSupp: g.type; val expcRx: eRx.type} ) { val grmMetadataWrapMode : SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[g.T, g.T ] }
  = {
    ;
    given a : SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[g.T, g.T ]
    = SpclGrammaticalItemMetaDataWrapMode.identityInstance
    ;

    make
  }
}







