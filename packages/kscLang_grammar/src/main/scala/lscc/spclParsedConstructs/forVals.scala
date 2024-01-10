package lscc.spclParsedConstructs













import lscalg.bnfParsing.BnfCompatibleFileReadPtr1 as GrmSpclFileReadPtr1

import lscalg.bnfParsing.spclCommonLookaheadCaps as GrmPtrStrMatchOpTraits1









object ForValsImpl
{
  ;

  ;

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

    transparent inline
    def givenFispoSupp
    : rc.ccImpl.type
    = rc.ccImpl

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
      // transparent inline
      def immediateKeyword
        //
        (using kwIngCtx : (
          lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ]
        ) )
        ()
      : Option[(givenFispoSupp.SpclMatchContent, givenFispoSupp.T)]
      = {
        ;

        ({
          ;

          import scala.util.matching.Regex.quote
          import privateImplicits.{*, given }

          val sj
          = (kwIngCtx.asParseSubject )

          // TODO
          sj.applyBrt(p)
        })
        .headOption
      }
      
    }

    extension (p: PAny ) {
      

      /** 
       * `immediateIdent` ;
       * 
       * TODO
       * 
       */
      // @annotation.experimental
      def immediateKeywordOrIdent
        //
        (using kwdIng : lscc.spclParsedConstructs1.KeywordingCtx.WithGivenFispoSupp[givenFispoSupp.type ] )
        ()
      = {
        ;

        (
          // p.immediateKeyword()
          // .map(Iiik.KEYWORD(_) )
          (for { r <- p.immediateKeyword() } yield Iiik.KEYWORD(r) )
          
          orElse
          
          // p.immediateEscapedIdent()
          // .map(Iiik.KEYWORD(_) )
          (for { r1 <- p.immediateEscapedIdent().toOption ; r = (r1, r1.nextPos) } yield Iiik.IDENTIFIER(r) )

          // THE COMPILER WENT INTO CPU 100% HANG, WITH `.map`
          //
          //
          //
        )
      }


      
    }

    enum Iiik {
      case KEYWORD   (value: (givenFispoSupp.SpclMatchContent, givenFispoSupp.T) )
      case IDENTIFIER(value: (givenFispoSupp.SpclMatchContent, givenFispoSupp.T) )
    }

    ;
  }

  ;

  transparent inline
  given _MainPublic
    //
    [
      PAny
      ,
      EOptConstructor
      <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
      ,
    ]
    (using c1 : _Main1Deps[PAny, EOptConstructor] )
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
    & _Main[? <: _Main1Deps[PAny, EOptConstructor] ] 
  )

  ;

  ;

  ;
}






