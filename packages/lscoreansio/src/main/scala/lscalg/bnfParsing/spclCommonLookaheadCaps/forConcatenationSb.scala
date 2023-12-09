package lscalg.bnfParsing

package spclCommonLookaheadCaps





















object forConcatenationSb {
  ;

  export lscalg.bnfParsing.BnfCompatibleFileReadPtr1.GeneralisedSpclAfterDigestTupleOption

  transparent inline
  given apply
    [
      _Any
      ,
      EOptConstructor
      <: Singleton & forConcatenationSb.GeneralisedSpclAfterDigestTupleOption[_Any]
      ,
    ]
    (using VO_EOptConstructor : ValueOf[EOptConstructor] )
  : forConcatenationSb[_Any, EOptConstructor ]
  = new forConcatenationSb[_Any, EOptConstructor ]

  ;
}

class forConcatenationSb
  [
    _Any
    ,
    EOptConstructor
    <: Singleton & forConcatenationSb.GeneralisedSpclAfterDigestTupleOption[_Any]
    ,
  ]
  (using val VO_EOptConstructor : ValueOf[EOptConstructor] )
  //
  // (using toGetRemngLines : lscalg.cli.repl.DefinesGetRemainingLines[_Any, forConcatenationSb.ContentLines ] )
  // (using lscalg.bnfParsing.BnrpDoComposeAdvancement[_Any, ([CL] =>> (CL => CL ) )[forConcatenationSb.ContentLines ] ] )
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

  transparent inline
  def gwConcatOps1This
  : this.type
  = this

  /* a workaround to the failure of the inliner to maintain the `.type`ing */
  transparent inline
  def SpclAfterDigestTupleOption
  : VO_EOptConstructor.value.type
  = VO_EOptConstructor.value

  /* a workaround */
  type SpclAfterDigestTupleOption
  = VO_EOptConstructor.value._Any

  ;

  import lscalg.bnfParsing.IRegExp

  import IRegExp.tagImplicits.{r}

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
        // .take(0 )
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










