package lscc.spclParsedConstructs1

















trait SpclGrammaticalPxery {
  ;

  implicit
  val givenFispoSupp
  : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any

  implicit
  val apMode
  : SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[givenFispoSupp.T, givenFispoSupp.T ]

  // implicit
  transparent inline
  def grmMetadataWrapMode
  : apMode.type
  = apMode

  implicit
  val expcRx
  : lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.T, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ]

  ;

  /** 
   * spcl ParseFunction/FromSrcStreamDigestFnc which yields as-value instance-of `Value`
   * 
   */
  type SpclSdfYielding
    [+Value]
  = SpclSdfYieldingUnwrapped[grmMetadataWrapMode.AfterSi[Value ] ]

  type SpclSdfYieldingUnwrapped
    [+Value]
  >: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , ([e] =>> e )[Value ] ] @annotation.unchecked.uncheckedVariance
  <: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.T , ([e] =>> e )[Value ] ] //

  extension [Value] (f: SpclSdfYieldingUnwrapped[Value] )
    def withFinalPtrPosVl
      ()
      (using util.NotGiven[Value <:< grmMetadataWrapMode.AfterSi[Any] ] )
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
  : SpclGrammaticalPxery {val givenFispoSupp: g.type; val apMode: a.type; val expcRx: eRx.type}
  = {
    new SpclGrammaticalPxery {
      ;
      val givenFispoSupp : g.type = valueOf
      val apMode : a.type = valueOf
      val expcRx : eRx.type = valueOf
    }
    .nn
  }

  ;
}








