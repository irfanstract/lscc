package lscc.spclParsing







import lscalg.cli.repl.UReadlineConsole









object GrmPtr {
  ;

  ;

  transparent inline
  def atBeginningOfFile
    //
    (src: GrmSpclFileReadPtr1.ElbdFileInfo )
  = {
    src
    .match { case file => GrmSpclFileReadPtr1.atBeginningOfSrcFile(file ) }
    .match { case r => atPosition(r) }
  }

  ;

  type _Any
  = AtPos[GrmSpclFileReadPtr1._Any ]

  type AtRemainingPosAndSrcFile
    [+RemnPos, +SrcFileInfo <: GrmSpclFileReadPtr1.ElbdFileInfo ]
  = AtPos[GrmSpclFileReadPtr1.AtRemainingPosAndSrcFile[RemnPos, SrcFileInfo ] ]

  opaque type AtPos
    [+Pos <: GrmSpclFileReadPtr1._Any ]
  // <: Pos
  = Pos

  def atPosition
    //
    (src: GrmSpclFileReadPtr1._Any )
  : AtPos[src.type ]
  = src

  ;

  /** 
   * `SpclAfterDigestTupleOption`
   * 
   * note :
   * uses a conjunction of two instantiations of same base classs-type with variation on nonvariant type-param,
   * which happened to compile but can't be guaranteed to remain do so in next compiler versions
   * 
   */
  final lazy val SpclAfterDigestTupleOption
  // : GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[_Any ]
  // = GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[_Any ]
  : GrmSpclFileReadPtr1.SpclAfterDigestTupleOption.type & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[_Any ]
  = {
    ;

    ({ val tc : (AtPos[GrmSpclFileReadPtr1._Any ] =:= GrmSpclFileReadPtr1._Any ) = implicitly ; tc })
    .flip
    .liftCo[[T] =>> GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[T] ]
    .match { case actualFnc => {
      ([T0, T1] => (f: T0 <:< T1) => (
        f.asInstanceOf[(
          (value: T0) => (
            value.type &
            // ([T] =>> ({ type Main >: T <: T })[T0 & T1 ] )#Main
            T0 & T1
            // ({ type I1 >: T0 <: T0 })#I1 & ({ type I2 >: T1 <: T1 })#I2
          )
        ) ]
      ) )
        (actualFnc )
    } }
    .match { case f => f }
    .match { case refine => {
      refine(GrmSpclFileReadPtr1.SpclAfterDigestTupleOption )
    } }
    // .match { case f => f }
  }

  // protected
  object spclUtil1 {
    ;

    export GrmPtrSpclRegex.tagImplicits.{*, given}

    extension (e: SpclAfterDigestTupleOption.PositiveInstance )
      def matchedStr
      : String
      = e.prod._1.head

    def describeAfterDigestTuple1
      //
      (finalPos: _Any, prod: (IndexedSeq[String], util.matching.Regex ) )
    = {
      ;
      SpclAfterDigestTupleOption.PositiveInstance
        (nextPos = finalPos , prod = prod )
    }

  }

  import spclUtil1.{*, given}

  given eca1
  : lscalg.bnfParsing.BnrpDoComposeAdvancement[_Any, ([T] =>> (T => T) )[lscalg.bnfParsing.BnfCompatibleFileReadPtr1.ContentLines ] ]
  = lscalg.bnfParsing.BnfCompatibleFileReadPtr1.eca

  given iemiOpsR
  : GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence.ForReceiverAndRAndL[_Any, IMOR, util.matching.Regex ]
  with {
    ;

    extension (p: _Any ) {
      //

      def immediateMatchOf
        //
        (r: util.matching.Regex )
      : IMOR[r.type]
      = {
        ({
          ;

          import  GrmSpclFileReadPtr1.{immediateMatchIgnoringLinebreakOf as immediateMatchOf0 }

          p.immediateMatchOf0(r)

          .match { case s => s }
        })

        .match { case result => {
          &&%%%[IMOR[r.type] ]
          .apply(result)
        } }
      }

    }

  }

  given iemiOpsL
  : GrmPtrStrMatchOpTraits1.ForImmediateLiteral.ForReceiverAndRAndL[_Any, IMOL, String ]
  with {
    ;

    extension (p: _Any ) {
      //

      def immediateLiterally
        //
        (s: String)
      : IMOL[s.type]
      = {
        p.immediateMatchOf(s match { case chr => util.matching.Regex.quote(chr).r } )

        .match { case r => {
          &&%%%[IMOL[s.type] ]
          .apply(r)
        } }
      }

    }

  }

  private
  def &&%%%[T >: SpclAfterDigestTupleOption._Any ]
  = identity[(value: SpclAfterDigestTupleOption._Any ) => (value.type & T ) ] (e => e )

  opaque type IMOL[+Value]
  <: SpclAfterDigestTupleOption._Any
  =  SpclAfterDigestTupleOption._Any

  opaque type IMOR[+Pattern ]
  <: SpclAfterDigestTupleOption._Any
  =  SpclAfterDigestTupleOption._Any

  given given_grmForLanguageAgnosticPrimitves1__Any_SpclAfterDigestTupleOption_type
  : grmForLanguageAgnosticPrimitves1[_Any, SpclAfterDigestTupleOption.type ]
  = {
    ;

    grmForLanguageAgnosticPrimitves1[_Any, SpclAfterDigestTupleOption.type ]
  }

  ;

  given grmWhitespaces1.type
  = grmWhitespaces1

  given esnw
  : grmWhitespaceSkippingOpImpl1[_Any, SpclAfterDigestTupleOption.type ]
  = {
    // given given_grmForLanguageAgnosticPrimitves1__Any_SpclAfterDigestTupleOption_type.iemiOpsL.type
    // = valueOf
    // given given_grmForLanguageAgnosticPrimitves1__Any_SpclAfterDigestTupleOption_type.iemiOpsR.type
    // = valueOf

    grmWhitespaceSkippingOpImpl1[_Any, SpclAfterDigestTupleOption.type ]
  }

  given grmDelimiters1.type
  = grmDelimiters1

  given grmNumericLiteranAndWordsAndIdents
  : grmNumericLiteranAndWordsAndIdents1[GrmPtr.SpclAfterDigestTupleOption.type, GrmPtr._Any ]
  = {
    // given given_grmForLanguageAgnosticPrimitves1__Any_SpclAfterDigestTupleOption_type.iemiOpsL.type
    // = valueOf
    // given given_grmForLanguageAgnosticPrimitves1__Any_SpclAfterDigestTupleOption_type.iemiOpsR.type
    // = valueOf

    grmNumericLiteranAndWordsAndIdents1[GrmPtr.SpclAfterDigestTupleOption.type, GrmPtr._Any ]
  }

  ;

  import lscalg.bnfParsing.BnrpMatchingLoopOp

  given given_BnrpMatchingLoopOp1
  : BnrpMatchingLoopOp.ForReceiver[_Any, SpclAfterDigestTupleOption.PositiveInstance ]
  = GrmSpclFileReadPtr1.given_BnrpMatchingLoopOp

  /* fixing the "ambiguous extension" problem */
  export given_BnrpMatchingLoopOp1.{tryForImmediateLoop, tryForImmediateLoop1}

  ;
} 














