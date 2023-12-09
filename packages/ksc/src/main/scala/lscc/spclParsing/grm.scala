package lscc

package spclParsing







import lscalg.cli.repl.UReadlineConsole









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

      transparent inline
      def thisLDefSpclEtcs
      : this.type
      = this

      import ImplGrmPtr.{*, given }

      ;

      // protected
      object spclUtil1 {
        ;

        export GrmPtrSpclRegex.tagImplicits.{*, given}

      }

      import spclUtil1.{*, given}

      ;

      given for_BC1
      : (lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp) with {
        //

        @deprecated
        type T
        >: _Any
        <: _Any

        val SpclAfterDigestTupleOption
        : thisLDefSpclEtcs.SpclAfterDigestTupleOption.type
        = valueOf

        // type SpclMatchContent
        // >: BC.SpclAfterDigestTupleOption._Impl1.Some
        // <: BC.SpclAfterDigestTupleOption._Impl1.Some
      }

      given edgrl1
      : lscalg.cli.repl.DefinesGetRemainingLines[_Any, lscalg.bnfParsing.BnfCompatibleFileReadPtr1.ContentLines ]
      = lscalg.bnfParsing.BnfCompatibleFileReadPtr1.edgrl

      given eca1
      : lscalg.bnfParsing.BnrpDoComposeAdvancement[_Any, ([T] =>> (T => T) )[lscalg.bnfParsing.BnfCompatibleFileReadPtr1.ContentLines ] ]
      = lscalg.bnfParsing.BnfCompatibleFileReadPtr1.eca

      protected[GrmPtrInternal ] /* work-around to the (spurious) "abiguous given" phenomenon */
      given iemiOpsR
      : GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence.ForReceiverAndRAndL[_Any, IMOR, util.matching.Regex ]
      = {
        GrmSpclFileReadPtr1.extraImmediatePatternMatchImplicits.iemiOpsR
      }

      protected[GrmPtrInternal ] /* work-around to the (spurious) "abiguous given" phenomenon */
      given iemiOpsL
      : GrmPtrStrMatchOpTraits1.ForImmediateLiteral.ForReceiverAndRAndL[_Any, IMOL, String ]
      = {
        GrmSpclFileReadPtr1.extraImmediatePatternMatchImplicits.iemiOpsL
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

      implicit
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

      implicit
      final
      lazy val grmWsk
      : grmWhitespaceSkippingOpImpl1[_Any, SpclAfterDigestTupleOption.type ]
      = grmWhitespaceSkippingOpImpl1[_Any, SpclAfterDigestTupleOption.type ]

      given esnw
      : spclParsedConstructs.forNumericLiteralAndWordsAndIdentsForBnfParseOptionCtorAndPtrType[SpclAfterDigestTupleOption.type , _Any ]
      = spclParsedConstructs.forNumericLiteralAndWordsAndIdentsForBnfParseOptionCtorAndPtrType[SpclAfterDigestTupleOption.type , _Any ]

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
      = {
        implicitly[SpclAfterDigestTupleOption.PositiveInstance =:= GrmSpclFileReadPtr1.SpclAfterDigestTupleOption.PositiveInstance ]
        .flip
        .liftCo[[t] =>> BnrpMatchingLoopOp.ForReceiver[_Any, t ] ]
        .apply(GrmSpclFileReadPtr1.given_BnrpMatchingLoopOp )
      }

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














