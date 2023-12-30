package lscc.spclParsedConstructs













import lscalg.bnfParsing.BnfCompatibleFileReadPtr1 as GrmSpclFileReadPtr1

import lscalg.bnfParsing.spclCommonLookaheadCaps as GrmPtrStrMatchOpTraits1









object ForValsImpl
{
  ;

  ;

  transparent inline
  given _MainPublic
    [
      EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
      ,
      PAny
      ,
    ]
    (using c : BnfParseOptionCtorAndPtrTypeDefiner.ForPtrTypeAndParseOptionConstructor[PAny, EOptConstructor] )
    (using rr : (
      GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
        [PAny, util.matching.Regex , c.SpclAfterDigestTupleOption._Any ]
    ) )
    (using given_ForNumericLiteranAndWordsAndIdentsImpl_impl
    : (
      ForNumericLiteranAndWordsAndIdentsImpl._MainPublic[c.SpclAfterDigestTupleOption.type , PAny ]
    ) )
  : _MainPublic[EOptConstructor, PAny]
  =
    new AnyRef with _MainPublic[EOptConstructor, PAny]
    {
      val SpclAfterDigestTupleOption
      : c.SpclAfterDigestTupleOption.type

      = valueOf 
      val iemiOpsR
      : rr.type
      = valueOf

      val given_ForNumericLiteranAndWordsAndIdentsImpl
      : given_ForNumericLiteranAndWordsAndIdentsImpl_impl.type
      = valueOf
    }

  trait _MainPublic
    [
      EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
      ,
      PAny
      ,
    ]
  extends
  AnyRef
  with _Main[PAny]
  with _Main1Deps[EOptConstructor, PAny]

  ;

  trait _Main1Deps
    [
      EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
      ,
      PAny
      ,
    ]
  {
    ;

    val SpclAfterDigestTupleOption : EOptConstructor
    // val VO_EOptConstructor = implicitly[ValueOf[SpclAfterDigestTupleOption.type] ]

    implicit
    val iemiOpsR : (
      GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
        [PAny, util.matching.Regex , SpclAfterDigestTupleOption._Any ]
    )

    implicit
    val given_ForNumericLiteranAndWordsAndIdentsImpl
    : (
      ForNumericLiteranAndWordsAndIdentsImpl._MainPublic[SpclAfterDigestTupleOption.type , PAny ]
    )

    ;
  }

  /** 
   * only the ops, without the clutter (here, the essential auxiliary defs)
   * 
   */
  trait _Main
    [
      PAny
      ,
    ]
    // (using val VO_EOptConstructor : ValueOf[EOptConstructor] )
    //
  // : AnyRef with
  {
    this : (
      _Main[PAny]
      & _Main1Deps[?, PAny ]
    ) =>
    ;

    // transparent inline
    // def iemiOpsR
    // = summon

    ;

    import lscalg.bnfParsing.IRegExp.tagImplicits.{*, given }

    // TODO

    object privateImplicits {
      ;

      import scala.util.matching.Regex.quote

      extension (s: String)
        def quotingR
        = quote(s).r

    }

    extension (p: PAny ) {
      //

      /** 
       * `immediateKeyword` ;
       * 
       * TODO
       * 
       */
      transparent inline
      def immediateKeyword
        //
        ()
      = {
        ;

        import scala.util.matching.Regex.quote
        import privateImplicits.{*, given }

        (
          Nil
          :+ "abstract"
        )
        .foldLeft[SpclAfterDigestTupleOption._Any ] (SpclAfterDigestTupleOption._Impl1.None )((o, newS) => {
          o orElse {
            ((wrd: String) => (
              p.immediateMatchOf(wrd.quotingR )
            ) )(newS)
          }
        } )
      }

      /** 
       * `immediateIdent` ;
       * 
       * TODO
       * 
       */
      transparent inline
      def immediateKeywordOrIdent
        //
        ()
      = {
        ;
        // p.immediateMatchOf("""\`\w+\`""".r)
        ({
          ;
          import scala.util.matching.Regex.quote
          import privateImplicits.{*, given }
          (
            p.immediateKeyword()
            .toOption.map(r => {
              Iiik.KEYWORD(r)
            } )

            orElse

            p.immediateEscapedIdent()
            .toOption.map(r => {
              Iiik.IDENTIFIER(r)
            } )
          )
        })
      }

      //
    }

    enum Iiik {
      case KEYWORD(value: SpclAfterDigestTupleOption.PositiveInstance )
      case IDENTIFIER(value: SpclAfterDigestTupleOption.PositiveInstance )
    }

    ;
  }

  ;
}






