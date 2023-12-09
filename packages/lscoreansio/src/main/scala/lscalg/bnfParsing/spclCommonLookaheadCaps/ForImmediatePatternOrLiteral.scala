package lscalg.bnfParsing

package spclCommonLookaheadCaps














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











