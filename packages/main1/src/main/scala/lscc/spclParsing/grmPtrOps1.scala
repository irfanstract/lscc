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

final
lazy val GrmPtrSpclRegex
: lscalg.bnfParsing.IRegExp.type
= lscalg.bnfParsing.IRegExp










