package lscalg.bnfParsing

package  spclCommonLookaheadCaps1





import lscalg.cli.repl.{*}












object ForImmediateStrPatternOccurence
{
  ;

  def apply
    //
    // [T]
    (using ec : GivenFispoSupp._Any )
    (using spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    (subject: util.matching.Regex, lineCountLimit: Int )
  // : FromScRegex[subject.type]
  = {
    import ec.T
    import ec.SpclAfterDigestTupleOption
    import ec.SpclMatchContent
    ;

    lscalg.parsing.ParseFunction.fromLiftedPartialFunction((pt0: T) => {
      ;
      pt0.immediateMatchOf(subject )
      .toOption
      .map(r => (r : SpclMatchContent, r.nextPos) )
    } )
  }

  ;
}

object ForImmediateStrLiteralOccurence
{
  ;

  import BnfCompatibleFileReadPtr1._Any as T

  inline def globalLineCountLimit : Int
  = 1048576

  def apply
    //
    // [T]
    (using ec : GivenFispoSupp._Any )
    (using spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
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



// TODO
trait GivenFispoSupp
{
  type T

  val SpclAfterDigestTupleOption
  : BnfCompatibleFileReadPtr1.GeneralisedSpclAfterDigestTupleOption[T]

  type SpclMatchContent
  >: SpclAfterDigestTupleOption._Impl1.Some
  <: SpclAfterDigestTupleOption._Impl1.Some
}
object GivenFispoSupp {
  ;

  type _Any
  = GivenFispoSupp

  transparent inline
  def apply[T](using impl : ForTExactly[T] )
  = impl

  transparent inline
  def inGiven(using impl : _Any )
  = impl

  type ForTExtending[-CT]
  = GivenFispoSupp { type T >: CT }

  type ForTExactly[CT]
  = GivenFispoSupp { type T >: CT <: CT }

  @deprecated
  @annotation.experimental
  inline
  given failIfFound
  : GivenFispoSupp
  = compiletime.error(s"unexpected selection.")

  given for_BC
  : GivenFispoSupp with {
    //
    import BnfCompatibleFileReadPtr1 as BC

    @deprecated
    type T
    >: BC._Any
    <: BC._Any

    val SpclAfterDigestTupleOption
    : BC.SpclAfterDigestTupleOption.type
    = valueOf

    // type SpclMatchContent
    // >: BC.SpclAfterDigestTupleOption._Impl1.Some
    // <: BC.SpclAfterDigestTupleOption._Impl1.Some
  }

}








