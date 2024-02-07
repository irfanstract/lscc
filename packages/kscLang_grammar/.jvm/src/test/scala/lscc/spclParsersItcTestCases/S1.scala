package lscc.spclParsersItcTestCases











class IKeywordingCtxTest
extends
org.scalatest.funsuite.AnyFunSuite
{
  ;

  @deprecated
  implicit
  def defaultGrmMetadataWrapMode1
    (using gfsp : lscalg.bnfParsing.spclCptdFispoSuppExtras1.GivenFiSpoSupp._Any )
  : lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[gfsp.T, gfsp.T ]
  = lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode.identityInstance

  // @deprecated
  // implicit
  // def defaultPxery
  // : lscc.spclParsedConstructs1.SpclGrammaticalPxery {
  //   val givenFispoSupp
  //   : lscalg.bnfParsing.spclCptdFispoSuppExtras1.GivenFiSpoSupp.for_BC.type
  // }
  // = {
  //   implicit val gfsp
  //   = lscalg.bnfParsing.spclCptdFispoSuppExtras1.GivenFiSpoSupp.for_BC
  //   lscc.spclParsedConstructs1.SpclGrammaticalPxery.make
  // }

  // //

  // test("IKeywordingCtxTest prep") {
  //   ;

  //   val termExprMode
  //   = lscc.spclGrammar.forTermOrTypeLevelExprs.Aitl.forTermLevel()

  //   println(termExprMode.toString() )

  //   println(s"done 'IKeywordingCtxTest prep'.")
  // }

}











