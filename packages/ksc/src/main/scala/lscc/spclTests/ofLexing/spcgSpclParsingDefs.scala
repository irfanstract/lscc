package lscc.spclTests.ofLexing












object spcgSpclParsingDefs {
  ;

  implicit
  transparent inline
  def SpclGrmPtr
  : lscc.spclParsing.GrmPtr.type
  = lscc.spclParsing.GrmPtr

  implicit
  object impl1
  {
    ;

    extension (r: lscalg.cli.repl.spclCollections.Lrp._Any )
      //
      def atBgnPars()
      : SpclGrmPtr._Any
      = SpclGrmPtr.atBeginningOfFile(r )

  }

  export lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp.ftoOp

  implicit
  transparent inline
  def SpclGrmPtr_gfs
  : lscc.spclParsing.GrmPtr.for_BC1.type
  = lscc.spclParsing.GrmPtr.for_BC1

  export lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp.ptrParseFromSpOps

}







