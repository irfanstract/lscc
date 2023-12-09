package lscalg.bnfParsing

package spclCommonLookaheadCaps












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

  import lscalg.bnfParsing.IRegExp

  import IRegExp.tagImplicits.{*, given }

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











