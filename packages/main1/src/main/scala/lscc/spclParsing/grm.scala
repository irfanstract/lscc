package lscc.spclParsing







import lscalg.cli.repl.UReadlineConsole









// object GrmPtr {
//   ;

//   ;

//   transparent inline
//   def atBeginningOfFile
//     //
//     (src: GrmSpclFileReadPtr1.ElbdFileInfo )
//   = {
//     src
//     .match { case file => GrmSpclFileReadPtr1.atBeginningOfSrcFile(file ) }
//     .match { case r => atPosition(r) }
//   }

//   ;

//   export GrmPtrInternal.cc1.{
//     *,
//     // given,
//   }

//   // TODO
//   object givens {
//     ;

//     export GrmPtrInternal.cc1.{
//       // *,
//       given,
//     }
//   }

//   ;

//   ;

//   ;
// }
final
lazy val GrmPtr
: GrmPtrInternal.cc1.type
= GrmPtrInternal.cc1

object GrmPtrInternal {
  ;

  ;

  trait CC1Pre
  { ImplGrmPtr =>
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

    trait LDefSpclAfterDigestTupleOptionAbstract
    {
      ;
      
      val SpclAfterDigestTupleOption
      : GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[ImplGrmPtr._Any ]

    }

    opaque type SpclAfterDigestTupleOptionS1
    <: GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[ImplGrmPtr._Any ]
    =  GrmSpclFileReadPtr1.SpclAfterDigestTupleOption.type

    trait LDefSpclAfterDigestTupleOption
    extends
    LDefSpclAfterDigestTupleOptionAbstract
    {
      ;

      // TODO
      val SpclAfterDigestTupleOption
      // : GrmSpclFileReadPtr1.SpclAfterDigestTupleOption.type
      : SpclAfterDigestTupleOptionS1
      = GrmSpclFileReadPtr1.SpclAfterDigestTupleOption

      ;
    }

    trait LDefSpclEtcs
    extends
    AnyRef
    {
      this : (
        AnyRef
        & LDefSpclAfterDigestTupleOptionAbstract
        & LDefSpclAfterDigestTupleOption
      ) =>
      ;

      import ImplGrmPtr.{*, given }

      ;

      // protected
      object spclUtil1 {
        ;

        export GrmPtrSpclRegex.tagImplicits.{*, given}

      }

      import spclUtil1.{*, given}

      ;

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

      final
      lazy val grmWhitespaces1
      : grmWhitespaces1Impl[_Any , SpclAfterDigestTupleOption.type ]
      = {
        ;

        given edgrl1
        : lscalg.cli.repl.DefinesGetRemainingLines[_Any, lscalg.bnfParsing.BnfCompatibleFileReadPtr1.ContentLines ]
        = lscalg.bnfParsing.BnfCompatibleFileReadPtr1.edgrl

        grmWhitespaces1Impl[_Any , SpclAfterDigestTupleOption.type ]
      }

      given esnw
      : grmWhitespaceSkippingOpImpl1[_Any, SpclAfterDigestTupleOption.type ]
      = {
        grmWhitespaceSkippingOpImpl1[_Any, SpclAfterDigestTupleOption.type ]
      }

      given grmDelimiters1.type
      = grmDelimiters1

      given grmNumericLiteranAndWordsAndIdents
      : grmNumericLiteranAndWordsAndIdents0.type
      = grmNumericLiteranAndWordsAndIdents0
      // implicit
      final
      lazy val grmNumericLiteranAndWordsAndIdents0
      : grmNumericLiteranAndWordsAndIdents1[SpclAfterDigestTupleOption.type, _Any ]
      = {
        grmNumericLiteranAndWordsAndIdents1[SpclAfterDigestTupleOption.type, _Any ]
      }

      ;

      // TODO
      given given_gwConcatOps1
      : gwConcatOps1[_Any, SpclAfterDigestTupleOption.type ]
      = {
        gwConcatOps1[_Any, SpclAfterDigestTupleOption.type ]
      }

      import lscalg.bnfParsing.BnrpMatchingLoopOp

      given given_BnrpMatchingLoopOp1
      : BnrpMatchingLoopOp.ForReceiver[_Any, SpclAfterDigestTupleOption.PositiveInstance ]
      = GrmSpclFileReadPtr1.given_BnrpMatchingLoopOp

      ;
      ;
    }

    trait LDefSpclAllPre1 extends
    AnyRef
    with LDefSpclAfterDigestTupleOptionAbstract
    with LDefSpclEtcs
    { this : (AnyRef & LDefSpclAfterDigestTupleOption ) => }

    trait LDefSpclAll1 extends
    AnyRef
    with LDefSpclAllPre1
    with LDefSpclAfterDigestTupleOption

    ;

    // private[cc1]
    // val implCc1
    // =
    // object implCc1 extends
    // AnyRef
    // with LDefSpclAll1
    final
    lazy
    val implCc1
    : LDefSpclAllPre1
    = (
      new AnyRef
      with LDefSpclAllPre1
      with LDefSpclAfterDigestTupleOption
    )

    ;

  }

  // trait CC1
  object cc1
  extends
  CC1Pre
  {
    ;

    export implCc1.{*, given }

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
  }

  ;
}

lazy val _ = {
  Some(GrmPtr.grmNumericLiteranAndWordsAndIdents )
}














