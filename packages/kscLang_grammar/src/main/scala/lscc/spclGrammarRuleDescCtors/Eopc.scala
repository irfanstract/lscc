package lscc.spclGrammarRuleDescCtors












import lscalg.bnfParsing.BnfCompatibleFileReadPtr1 as GrmSpclFileReadPtr1

import lscalg.bnfParsing.spclCommonLookaheadCaps as GrmPtrStrMatchOpTraits1






object Eopc {
  ;

  transparent inline
  def SpclAfterDigestTupleOption
    (using c : ValueOf[GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOptionLU[Nothing, Any] ] )
  : c.value.type
  = c.value

  ;

  /** 
   * named `forMainOperandTAndResultOptionCtorT`, building on `GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence`s
   * 
   */
  type ForApplyRequiringXRAny
  = ForApplyRequiringXRImpl[?]

  ;

  /** 
   * named `forMainOperandTAndResultOptionCtorT`, building on `GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence`s
   * 
   */
  trait ForApplyRequiringXRImpl
    [T] private[Eopc]
    ()
  {
    ;

    // inline
    def forMainOperandTAndResultOptionCtorT
      [
        PAny
        ,
        EOptConstructor
        <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
        ,
      ]
      (using VO_EOptConstructor : ValueOf[EOptConstructor] )
      (using rr : (
        GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
          [PAny, util.matching.Regex , VO_EOptConstructor.value._Any ]
      ) )
    : ForMainOperandTAndResultOptionCtorT[PAny, EOptConstructor ]

    type ForMainOperandTAndResultOptionCtorT
      //
      [
        PAny
        ,
        /* TODO assess whether this one could appropriatelt be spec-ed as co-variant */
        EOptConstructor
        <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
        ,
      ]

  }

  // TODO
  protected
  // transparent inline
  def forApplyRequiringXR
    (impl: (
      /** 
       * some remarks
       * - due to limitations WRT curried fnc-types
       *   I had to resort to alt solutions like inter-dependent tuple-types (like this one)
       * - by making the type-arg `R` wildcard
       *   we're doing something necessary for
       * 
       */
      Function1[(
        ({ type Operand }, Any, Any ) {
          //

          val _2 : (
            GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[_1.Operand]
          )
          val _3 : (
            //
            GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
              [_1.Operand, util.matching.Regex , _2._Any ]
          )
        }
      ), ? ]
    ) )
  : ForApplyRequiringXRAny
  = {
    ;
    type SpclA = ({ type Main[F] = F match { case Function1[a, r] => a } })#Main[impl.type ]
    type SpclR = ({ type Main[F] = F match { case Function1[a, r] => r } })#Main[impl.type ]

    val impl1 = impl : (SpclA => SpclR)

    // new ForApplyRequiringXRImpl[?]
    // {
    //   ;

    //   // inline
    //   def forMainOperandTAndResultOptionCtorT
    //     [
    //       PAny
    //       ,
    //       EOptConstructor
    //       <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
    //       ,
    //     ]
    //     (using VO_EOptConstructor : ValueOf[EOptConstructor] )
    //     (using rr : (
    //       GrmPtrStrMatchOpTraits1.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType
    //         [PAny, util.matching.Regex , VO_EOptConstructor.value._Any ]
    //     ) )
    //   : ForMainOperandTAndResultOptionCtorT[PAny, EOptConstructor ]
    //   = {
    //     ;

    //     ???
    //   }

    //   type ForMainOperandTAndResultOptionCtorT
    //     //
    //     [
    //       PAny
    //       ,
    //       /* TODO assess whether this one could appropriatelt be spec-ed as co-variant */
    //       EOptConstructor
    //       <: Singleton & GrmSpclFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[PAny]
    //       ,
    //     ]
    //   // = SpclA { val _1 : { type Operand >: PAny <: PAny } }
    //   = SpclR

    // }

    ???
  }

  ;

}












