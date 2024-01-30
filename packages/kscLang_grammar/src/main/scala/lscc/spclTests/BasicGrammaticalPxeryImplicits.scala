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

    def runLoggingModeEntryPtTask
      (e: (String, gfsp.InputState) )
    : lscc.spclParsedConstructs1.SpclGrammaticalPxery.SpclExitLoggingMode
    = {
      ;

      val (msg *: inputState *: _ ) = e

      val oisS
      = inputState.remainingLinesAsSingleLineStrBy(n = 2 )

      println(s"==> ($msg) on $oisS ")

      ((r) => {
        import language.unsafeNulls
        r
        .recover(z => println(s"FAILED<== with ($z) on $oisS ") )
      } ) : (util.Try[Unit] => Unit )
    }
    implicit
    val loggingMode
    = {
      import lscc.spclParsedConstructs1.SpclGrammaticalPxery

      SpclGrammaticalPxery.SpclEntLoggingMode.forCurriedFunc((
        (c: SpclGrammaticalPxery { val givenFispoSupp : gfsp.type } ) => {
          case evt => runLoggingModeEntryPtTask(evt)
        }
      ))
    }

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








