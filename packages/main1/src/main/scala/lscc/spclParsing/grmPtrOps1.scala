package lscc.spclParsing
















object GrmPtrStrMatchOpTraits1 {
  ;

  object ForImmediatePatterOccurence {
    ;

    type _Any
    = _AnyForL[Nothing]

    type _AnyForL[-L ]
    = ForReceiverAndRAndL[?, ? <: [pattern <: L] =>> Any , L ]

    type _AnyForReceiverAndL[-Receiver, -L ]
    = _AnyForReceiverAndSpecAndReturnBaseType[Receiver, L, Any ]

    type _AnyForReceiverAndSpecAndReturnBaseType[-Receiver, -L, +ReturnV ]
    = ForReceiverAndRAndL[Receiver, ? <: [pattern <: L] =>> ReturnV , L ]

    type _AnyForReceiverAndSpecAndReturnCc[-Receiver, -L, +ReturnCc[+pattern <: L] ]
    = ForReceiverAndRAndL[Receiver, ? <: ReturnCc , L ]

    trait ForReceiverAndRAndL[-Receiver, +IMOR[+pattern <: L], -L ]
    {
      ;
      extension (receiver: Receiver)
        def immediateMatchOf
          //
          (r: L )
        : IMOR[r.type]
    }

  }

  object ForImmediateLiteral {
    ;

    type _Any
    = _AnyForL[Nothing]

    type _AnyForL[-L ]
    = ForReceiverAndRAndL[?, ? <: [pattern <: L] =>> Any , L ]

    type _AnyForReceiverAndL[-Receiver, -L ]
    = _AnyForReceiverAndSpecAndReturnBaseType[Receiver, L, Any ]

    type _AnyForReceiverAndSpecAndReturnBaseType[-Receiver, -L, +ReturnV ]
    = ForReceiverAndRAndL[Receiver, ? <: [pattern <: L] =>> ReturnV , L ]

    type _AnyForReceiverAndSpecAndReturnCc[-Receiver, -L, +ReturnCc[+pattern <: L] ]
    = ForReceiverAndRAndL[Receiver, ? <: ReturnCc , L ]

    trait ForReceiverAndRAndL[-Receiver, +IMOL[+value <: L], -L ]
    {
      ;
      extension (receiver: Receiver)
        def immediateLiterally
          //
          (s: L)
        : IMOL[s.type]
    }

  }

  def forZeroLengthMatching
    [_Any]
    (using c : ForImmediatePatterOccurence._AnyForReceiverAndL[_Any, util.matching.Regex ] )
  = new forZeroLengthMatchingImpl[_Any, c.type ]

  class forZeroLengthMatchingImpl
    [
      _Any,
      Impl1
        <: Singleton & ForImmediatePatterOccurence._AnyForReceiverAndL[_Any, util.matching.Regex ]
      ,
    ]
    (using val xx1 : Impl1)
  extends
  AnyRef
  {
    ;

    import GrmPtrSpclRegex.tagImplicits.{*, given }

    extension (p: _Any ) {
      //

      transparent inline
      def immediateZeroLengthie
        ()
      = p.immediateMatchOf("".r )

    }

  }

  def forEofMatching
    [_Any]
    (using c : lscalg.cli.repl.DefinesGetRemainingLines[_Any, Seq[String] ] )
  = new forEofMatchingImpl[_Any, c.type ]

  class forEofMatchingImpl
    [
      _Any,
      /** 
       * cannot use `immediateMatchOf("""\z""")` from `ForImmediatePatterOccurence` , as
       * there's such limitation there
       * 
       */
      Impl1
        <: Singleton & lscalg.cli.repl.DefinesGetRemainingLines[_Any, Seq[String] ]
      ,
    ]
    (using val xx1 : Impl1)
  {
    ;

    extension (p: _Any ) {
      //

      transparent inline
      def immediateEndOfFile
        ()
      = {
        p.remainingLines
        .match { case s => {
          Some(s)
          .collect({ case Seq() | ("" +: Seq() ) => })
        } }
      }

    }

  }

  ;
}

object gwConcatOps1 {
  ;

  transparent inline
  given apply
    [
      _Any
      ,
      EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[_Any]
      ,
    ]
    (using VO_EOptConstructor : ValueOf[EOptConstructor] )
  : gwConcatOps1[_Any, EOptConstructor ]
  = new gwConcatOps1[_Any, EOptConstructor ]

  ;
}

class gwConcatOps1
  [
    _Any
    ,
    EOptConstructor
    <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[_Any]
    ,
  ]
  (using val VO_EOptConstructor : ValueOf[EOptConstructor] )
  //
  // (using toGetRemngLines : lscalg.cli.repl.DefinesGetRemainingLines[_Any, GrmSpclFileReadPtr1.ContentLines ] )
  // (using lscalg.bnfParsing.BnrpDoComposeAdvancement[_Any, ([CL] =>> (CL => CL ) )[GrmSpclFileReadPtr1.ContentLines ] ] )
  // //
  // (using
  //   //
  //   (
  //       GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
  //         [_Any, util.matching.Regex , VO_EOptConstructor.value._Any ]
  //     ) ,
  //     grmForLanguageAgnosticPrimitves1[_Any, VO_EOptConstructor.value.type ] ,
  // )
  // //
// : AnyRef with
{
  ;

  /* a workaround to the failure of the inliner to maintain the `.type`ing */
  transparent inline
  def SpclAfterDigestTupleOption
  : VO_EOptConstructor.value.type
  = VO_EOptConstructor.value

  /* a workaround */
  type SpclAfterDigestTupleOption
  = VO_EOptConstructor.value._Any

  ;

  import GrmPtr.spclUtil1.r

  ;

  final
  lazy val SpclSubject
  : lscalg.bnfParsing.BnrpMatchingLoopOp.SpclSubject.type
  = lscalg.bnfParsing.BnrpMatchingLoopOp.SpclSubject

  extension (p: _Any) {
    //

    // transparent inline
    def immediateConcatOfSubjects
      //
      (subject: ([A] =>> A )[(
        //
        Seq[(
          SpclSubject.ForReceiverAndROpt[_Any, (
            SpclAfterDigestTupleOption
          ) ]
        ) ]
      )] )
    = {
      ({
        ;

        p
        .immediateConc1L({
          subject
          .map(s => (
            (p: _Any ) => (
              s.applyO(p )
              .getOrElse[SpclAfterDigestTupleOption ] (SpclAfterDigestTupleOption.negativeInstance )
            )
          ) )
          .take(0 )
        })
        .match { case seq => {
          (seq.last.toOption.map({ case (m, _) => m }) , seq.reverse.collectFirst({ case Right(value) => value match { case (_, nextPos) => nextPos } }).get )
        } }
      })
    }

    // transparent inline
    def immediateConcatOfSubjectsExre
      //
      (subject: ([A] =>> A )[(
        //
        Seq[(
          SpclSubject.ForReceiverAndROpt[_Any, (
            SpclAfterDigestTupleOption
          ) ]
        ) ]
      )] )
    = {
      p
      .immediateConc1({
        subject
        .map(s => (
          (p: _Any ) => (
            s.applyO(p )
            .getOrElse[SpclAfterDigestTupleOption ] (SpclAfterDigestTupleOption.negativeInstance )
          )
        ) )
        .take(0 )
      })
    }

    @deprecated
    // transparent inline
    def immediateConc1
      //
      (subject: ([A] =>> A )[(
        //
        Seq[(p: _Any ) => (
          SpclAfterDigestTupleOption
        ) ]
      )] )
    = {
      ;

      p.immediateConc1L(subject )

      .last
      .toOption
    }

    @deprecated
    // transparent inline
    def immediateConc1L
      //
      (subject: ([A] =>> A )[(
        //
        Seq[(p: _Any ) => (
          SpclAfterDigestTupleOption
        ) ]
      )] )
    = {
      ;

      LazyList.from(subject )

      .scanLeft[Either[Unit, (Seq[&&%%._M], _Any)] ] (Right((Seq(), p)) )({
        case (Right((rFinal0, pt0)) , newShft ) =>
          newShft(pt0 )
          .toOption.toRight(() )
          .map(r2 => {
            ((rFinal0 :+ r2.prod , r2.nextPos))
          } )
        case _ =>
          Left(() )
      })
    }

    //
  }

  type PAny1
  = _Any

  object &&%% {
    type _Any
    >: (_M , PAny1 )
    <: (_M , PAny1 )

    export VO_EOptConstructor.value._Impl1 as VI

    type _M
    >: VI.SpclMatched1
    <: VI.SpclMatched1

    def apply(startPos: PAny1, m: _M , afterhandPos: PAny1 )
    : _Any
    = (m, afterhandPos )
  }

  ;
}
  //

final
lazy val GrmPtrSpclRegex
: lscalg.bnfParsing.IRegExp.type
= lscalg.bnfParsing.IRegExp










