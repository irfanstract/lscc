package lscc.spclParsedConstructs1

















trait SpclGrammaticalPxery
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
  //  * spcl ParseFunction/FromSrcStreamDigestFnc which yields as-value instance-of `Value` wrapped in `grmMetadataWrapMode.AppliedTo`
  //  * 
  //  */
  // type SpclSdfYielding
  //   [+Value]
  // = SpclSdfYieldingUnwrapped[grmMetadataWrapMode.AppliedTo[Value ] ]

  // /** 
  //  * spcl ParseFunction/FromSrcStreamDigestFnc which yields as-value instance-of `Value`
  //  * 
  //  */
  // type SpclSdfYieldingUnwrapped
  //   [+Value]
  // >: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , ([e] =>> e )[Value ] ] @annotation.unchecked.uncheckedVariance
  // <: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , ([e] =>> e )[Value ] ] //

  // extension [Value] (f: SpclSdfYieldingUnwrapped[Value] )
  //   def withFinalPtrPosVl
  //     ()
  //     (using util.NotGiven[Value <:< grmMetadataWrapMode.AppliedTo[Any] ] )
  //   : SpclSdfYielding[Value ]
  //   = {
  //     f.mapWithFinalPtrPosVl((vau, pos) => (
  //       vau
  //       .withSrcInfo(srcPosInfo = pos )
  //     ) )
  //   }
  // //

  ;
}

object SpclGrammaticalPxery
{
  ;

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
  : SpclGrammaticalPxery {val givenFispoSupp: g.type; val grmMetadataWrapMode: a.type; val expcRx: eRx.type}
  = {
    new SpclGrammaticalPxery {
      ;
      val givenFispoSupp : g.type = valueOf
      val grmMetadataWrapMode : a.type = valueOf
      val expcRx : eRx.type = valueOf
    }
    .nn
  }

  ;
}



trait SpclPxeryOpsGivenFispoSupps
{
  ;

  implicit
  val givenFispoSupp
  : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any

  implicit
  val grmMetadataWrapMode
  : SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ]

  ;
}

trait SpclPxeryOpsSdfDefine
{ this : SpclPxeryOpsGivenFispoSupps =>
  ;

  /** 
   * spcl ParseFunction/FromSrcStreamDigestFnc which yields as-value instance-of `Value` wrapped in `grmMetadataWrapMode.AppliedTo`
   * 
   */
  type SpclSdfYielding
    [+Value]
  = SpclSdfYieldingUnwrapped[grmMetadataWrapMode.AppliedTo[Value ] ]

  /** 
   * spcl ParseFunction/FromSrcStreamDigestFnc which yields as-value instance-of `Value`
   * 
   */
  type SpclSdfYieldingUnwrapped
    [+Value]
  >: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , ([e] =>> e )[Value ] ] @annotation.unchecked.uncheckedVariance
  <: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , ([e] =>> e )[Value ] ] //

  extension [Value] (f: SpclSdfYieldingUnwrapped[Value] )
    def withFinalPtrPosVl
      ()
      (using util.NotGiven[Value <:< grmMetadataWrapMode.AppliedTo[Any] ] )
    : SpclSdfYielding[Value ]
    = {
      f.mapWithFinalPtrPosVl((vau, pos) => (
        vau
        .withSrcInfo(srcPosInfo = pos )
      ) )
    }
  //

  ;
}








