package lscc.spclTests











/** 
 * 
 * `BasicGrammaticalPxeryImplicits`
 * 
 */
private[lscc ]
object BasicGrammaticalPxeryImplicits
{
  ;

  // @deprecated
  implicit
  def spclGrmMetadataWrapMode1
    (using gfsp : lscalg.bnfParsing.spclCptdFispoSuppExtras1.GivenFiSpoSupp._Any )
  : lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[gfsp.InputState, gfsp.InputState ]
  = lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode.identityInstance

  // @deprecated
  implicit
  final
  lazy val spclPxery
  : lscc.spclParsedConstructs1.SpclGrammaticalPxery {
    val givenFispoSupp
    : lscalg.bnfParsing.spclCptdFispoSuppExtras1.GivenFiSpoSupp.for_BC.type
  }
  = {
    implicit val gfsp
    = lscalg.bnfParsing.spclCptdFispoSuppExtras1.GivenFiSpoSupp.for_BC
    lscc.spclParsedConstructs1.SpclGrammaticalPxery.make
  }

  // @deprecated
  implicit
  final
  lazy val spclPxeryAlt1
  : lscc.spclTerminalGrammarsB.SpclPxery {
    val givenFispoSupp
    : lscalg.bnfParsing.spclCptdFispoSuppExtras1.GivenFiSpoSupp.for_BC.type
  }
  = lscc.spclTerminalGrammarsB.SpclPxery.makeFromGrammaticalCaseManif

}








