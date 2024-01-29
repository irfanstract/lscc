package lscalg.bnfParsing

package  spclCommonLookaheadCaps1





import lscalg.cli.repl.{*}












@deprecated("alias of 'ForImmediateRawOcc'.")
transparent inline
def ForImmediateStrPatternOccurence
: ForImmediateRawOcc.type
= ForImmediateRawOcc

object ForImmediateRawOcc
{
  ;

  def apply
    //
    // [T]
    (using ec : GivenFispoSupp._Any )
    (using spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.InputState, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    (subject: util.matching.Regex, lineCountLimit: Int )
  // : FromScRegex[subject.type]
  = {
    import ec.InputState
    import ec.SpclAfterDigestTupleOption
    import ec.SpclMatchContent
    ;

    lscalg.parsing.ParseFunction.fromLiftedPartialFunction((pt0: InputState) => {
      ;
      pt0.immediateMatchOf(subject )
      .toOption
      .map(r => (r : SpclMatchContent, r.nextPos) )
    } )
  }

  ;
}

@deprecated("alias of 'ForImmediateLiterallyRawOccurence'.")
transparent inline
def ForImmediateStrLiteralOccurence
: ForImmediateLiterallyRawOccurence.type
= ForImmediateLiterallyRawOccurence

object ForImmediateLiterallyRawOccurence
{
  ;

  import BnfCompatibleFileReadPtr1._Any as T

  inline def globalLineCountLimit : Int
  = 1048576

  def apply
    //
    // [T]
    (using ec : GivenFispoSupp._Any )
    (using spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.InputState, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    (subject: String )
  = {
    ;
    import IRegExp.tagImplicits.r

    val subjectAsR
    = {
      util.matching.Regex.quote(subject).r
    }

    ForImmediateStrPatternOccurence
      (using ec) (subjectAsR, lineCountLimit = globalLineCountLimit )
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

;










