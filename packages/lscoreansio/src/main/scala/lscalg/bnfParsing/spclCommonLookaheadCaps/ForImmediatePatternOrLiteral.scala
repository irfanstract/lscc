package lscalg.bnfParsing

package spclCommonLookaheadCaps














object ForImmediatePatterOccurence
extends
AnyRef
with EipoCommon
{
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

  // def forReceiverAndMatchSmmryBaseTypeAndQueryType
  //   [Receiver, IMOR_U, L ]
  //   (impl: Receiver => (s: L) => IMOR_U )
  // = forReceiverAndMatchSmmryAndQueryType[Receiver, [_] =>> IMOR_U, L ](impl)

  // @deprecated
  // def apply
  //   [Receiver, IMOR[+value <: L], L ]
  //   (impl: Receiver => (s: L) => IMOR[s.type] )
  // = forReceiverAndMatchSmmryAndQueryType[Receiver, IMOR, L ](impl)

  def forReceiverAndMatchSmmryAndQueryType
    [Receiver, IMOR[+value <: L], L ]
    (impl: Receiver => (s: L) => IMOR[s.type] )
  : ForReceiverAndRAndL[Receiver, IMOR, L ]
  = {
    new ForReceiverAndRAndL[Receiver, IMOR, L ]
    {
      ;
      extension (receiver: Receiver)
        def immediateMatchOf
          //
          (s: L)
        = impl(receiver)(s)
    }
  }

}

object ForImmediateLiteral
extends
AnyRef
with EipoCommon
{
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

  trait ForReceiverAndRAndL[-Receiver, +IMOL[+value <: L], -L ] @deprecated ()
  {
    ;
    extension (receiver: Receiver)
      def immediateLiterally
        //
        (s: L)
      : IMOL[s.type]
  }

  def forReceiverAndMatchSmmryAndQueryType
    [Receiver, IMOL[+value <: L], L ]
    (impl: Receiver => (s: L) => IMOL[s.type] )
  : ForReceiverAndRAndL[Receiver, IMOL, L ]
  = {
    new ForReceiverAndRAndL[Receiver, IMOL, L ]
    {
      ;
      extension (receiver: Receiver)
        def immediateLiterally
          //
          (s: L)
        = impl(receiver) (s)
    }
  }

}

trait EipoCommon private [lscalg] ()
{
  ;

  transparent inline
  def forReceiverAndMatchSmmryBaseTypeAndQueryType
    [Receiver, IMOR_U, L ]
    (impl: Receiver => (s: L) => IMOR_U )
  = forReceiverAndMatchSmmryAndQueryType[Receiver, [_] =>> IMOR_U, L ](impl)

  @deprecated
  transparent inline
  def apply
    [Receiver, IMOR[+value <: L], L ]
    (impl: Receiver => (s: L) => IMOR[s.type] )
  = forReceiverAndMatchSmmryAndQueryType[Receiver, IMOR, L ](impl)


  def forReceiverAndMatchSmmryAndQueryType
    [Receiver, IMOX[+value <: L], L ]
    (impl: Receiver => (s: L) => IMOX[s.type] )
  : Any

  ;
}











