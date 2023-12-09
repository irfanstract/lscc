package lscc.spclParsedConstructs













import lscalg.bnfParsing.BnfCompatibleFileReadPtr1 as GrmSpclFileReadPtr1

import lscalg.bnfParsing.spclCommonLookaheadCaps as GrmPtrStrMatchOpTraits1









object ForValsImpl
{
  ;

  ;

  transparent inline
  given _MainPublic
    //
    [
      EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
      ,
      PAny
      ,
    ]
    //
    (using c1 : _Main1Deps[PAny, EOptConstructor] )
    //
  : _MainPublic[EOptConstructor, PAny]
  = {
    ;
    (new AnyRef with _Main[c1.type] )
    .match { case r => r }
  }

  type _MainPublic
    [
      +
      EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
      ,
      PAny
      ,
    ]
  = (
    AnyRef
    // & _Main[PAny]
    // & _Main1Deps[PAny, EOptConstructor]
    & _Main[? <: _Main1Deps[PAny, EOptConstructor] ] 
  )

  ;

  trait _Main1Deps
    [
      PAnyImpl
      ,
      +
      EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAnyImpl]
      ,
    ]
    (using
      //
      DummyImplicit ,
    )
  {
    thisMain1Deps =>
    ;

    export rc.{PAny}

    // private[ForNumericLiteranAndWordsAndIdentsImpl]
    val rc
    : BnfParseOptionCtorAndPtrTypeDefiner.ForPtrTypeAndParseOptionConstructor[PAnyImpl, EOptConstructor]

    export rc.{SpclAfterDigestTupleOption}
    export rc.{given}

    implicit
    val given_ForNumericLiteranAndWordsAndIdentsImpl
    : (
      ForNumericLiteranAndWordsAndIdentsImpl._MainPublic[SpclAfterDigestTupleOption.type , PAnyImpl ]
    )

    ;
  }

  object _Main1Deps {
    ;

    implicit
    transparent inline
    def apply
      //
      [
        EOptConstructor
        <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
        ,
        PAny
        ,
      ]
      //
      (using c : BnfParseOptionCtorAndPtrTypeDefiner.ForPtrTypeAndParseOptionConstructor[PAny, EOptConstructor] )
      (using rr : (
        GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
          [PAny, util.matching.Regex , c.SpclAfterDigestTupleOption._Any ]
      ) )
      (using given_ForNumericLiteranAndWordsAndIdentsImpl_impl
      : (
        ForNumericLiteranAndWordsAndIdentsImpl._MainPublic[c.SpclAfterDigestTupleOption.type , PAny ]
      ) )
    //
    : _Main1Deps[PAny, c.SpclAfterDigestTupleOption.type ]
    = {
      ;

      class Impl1
        (using
          //
          val rc
          : c.type
          ,
          val given_ForNumericLiteranAndWordsAndIdentsImpl
          : given_ForNumericLiteranAndWordsAndIdentsImpl_impl.type 
          ,
        )
      extends
      _Main1Deps[PAny, c.SpclAfterDigestTupleOption.type ]

      new Impl1
    }

    ;
  }

  /** 
   * only the ops, without the clutter (here, the essential auxiliary defs)
   * 
   */
  trait _Main
    [
      +Erc
      <: (
        // Singleton &
        _Main1Deps[?, ?]
      )
      ,
    ]
    (using val dps : Erc )
    // (using val VO_EOptConstructor : ValueOf[EOptConstructor] )
    //
  // : AnyRef with
  {
    // this : (
    //   _Main[PAny]
    //   & _Main1Deps[PAny, ? ]
    // ) =>
    ;
    import dps.{*, given}

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






