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
  : SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[givenFispoSupp.InputState, givenFispoSupp.InputState ]

  implicit
  val expcRx
  : lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.InputState, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ]

  ;

  // /** 
  //  * spcl ParseFunction/FromSrcStreamDigestFnc which yields as-value instance-of `Value`
  //  * 
  //  */
  // type SpclSdfYielding
  //   [+Value]
  // = SpclSdfYieldingUnwrapped[grmMetadataWrapMode.AppliedTo[Value ] ]

  type SpclSdfYieldingUnwrapped
    [+Value]
  >: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState , ([e] =>> e )[Value ] ] @annotation.unchecked.uncheckedVariance
  <: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState , ([e] =>> e )[Value ] ] //

  ;

  type SpclExtractedRawStr1
  >: givenFispoSupp.SpclMatchContent
  <: givenFispoSupp.SpclMatchContent

  ;
}

object SpclPxery
extends
AnyRef
with SpclPxeryImplicits
{
  ;

  ;

  ;
}

protected 
trait SpclPxeryImplicits
extends
AnyRef
with SpclPxeryReducedPriorityImplicits
with SpclPxeryLowPrioImplicits
{ this : SpclPxery.type =>
  ;

  // transparent inline
  given makeFromGrammaticalCaseManif
    //
    (using ctx : lscc.spclParsedConstructs1.SpclGrammaticalPxery )
  //
  : SpclPxery {val givenFispoSupp: ctx.givenFispoSupp.type; val grmMetadataWrapMode: ctx.grmMetadataWrapMode.type; val expcRx: ctx.expcRx.type }
  = {
    ;
    import ctx.given
    makeFromConstituents
  }.nn

}

protected 
trait SpclPxeryReducedPriorityImplicits
extends
AnyRef
with SpclPxeryLowPrioImplicits
{ this : SpclPxery.type =>
  ;

  given makeFromConstituents
    //
    (using g : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using a : SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[g.InputState, g.InputState ] )
    (using eRx : (
      lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[g.InputState, util.matching.Regex, g.SpclAfterDigestTupleOption._Any ] 
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
  // transparent inline
  given makeFromConstituentsAlt
    //
    (using g : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using eRx : (
      lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[g.InputState, util.matching.Regex, g.SpclAfterDigestTupleOption._Any ] 
    ))
  //
  : (SpclPxery {val givenFispoSupp: g.type; val expcRx: eRx.type} ) { val grmMetadataWrapMode : SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[g.InputState, g.InputState ] }
  = {
    ;
    given a : SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[g.InputState, g.InputState ]
    = SpclGrammaticalItemMetaDataWrapMode.identityInstance
    ;

    makeFromConstituents
  }
}







