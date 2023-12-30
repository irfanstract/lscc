package lscalg.bnfParsing

package  spclCommonLookaheadCaps1





import lscalg.cli.repl.{*}












object ForImmediateStrPatternOccurence
{
  ;

  import BnfCompatibleFileReadPtr1 as BC
  
  @deprecated
  type T = BC._Any

  opaque type _Any
  <: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[T, SpclMatchContent]
  =  lscalg.digestivity.ParseFunction.ForReceiverAndRValue[T, SpclMatchContent]

  opaque type FromScRegex[+Query <: util.matching.Regex ]
  <: _Any
  =  _Any

  def apply
    //
    (subject: util.matching.Regex, lineCountLimit: Int )
  : FromScRegex[subject.type]
  = {
    lscalg.parsing.ParseFunction.fromLiftedPartialFunction((pt0: BC._Any) => {
      ;
      pt0.immediateMatchOf(subject, lineCountLimit = lineCountLimit )
      .toOption
      .map(r => (r : SpclMatchContent, r.nextPos) )
    } )
  }

  type SpclMatchContent
  >: BC.SpclAfterDigestTupleOption._Impl1.Some
  <: BC.SpclAfterDigestTupleOption._Impl1.Some

  ;
}

object ForImmediateStrLiteralOccurence
{
  ;

  import BnfCompatibleFileReadPtr1._Any as T

  def apply
    //
    (subject: String )
  = {
    lscalg.parsing.ParseFunction.fromLiftedPartialFunction((pt0: T) => {
      ;
      pt0.immediateMatchOf(util.matching.Regex.quote(subject).r, lineCountLimit = 1048576 )
      .toOption
      .map(r => (r.matchedStr, r.nextPos) )
    } )
  }

  ;
}

transparent inline
def ForImmediateEndOfFile
: ForImmediateEof.type
= ForImmediateEof

object ForImmediateEof
{
  ;

  import BnfCompatibleFileReadPtr1._Any as T

  def apply
    //
    (subject: String )
  = {
    lscalg.parsing.Subject.fromLiftedPartialFunction((pt0: T) => {
      ;
      ({
        ;

        val impl
        = {
          import BnfCompatibleFileReadPtr1.extraEdgrlImplicits.given
          spclCommonLookaheadCaps.forEofMatching[T]
        }
        ;
        ({
          given impl.type = impl
          pt0.immediateEndOfFile()
        })
      })
      // .map(r => (r.prod, r.nextPos) )
    } )
  }

  ;
}









