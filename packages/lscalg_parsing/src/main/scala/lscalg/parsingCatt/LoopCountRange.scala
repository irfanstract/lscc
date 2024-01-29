package lscalg.parsingCatt




















/**
 * 
 * every `LoopCountRange`
 * describes a range of integers
 * 
 */
opaque type LoopCountRange
<: AnyRef & Matchable
// >: Range
// <: Range
= Range

/* needs to repeat the doc-section, to work-around practical omission */
/**
 * 
 * every `LoopCountRange`
 * describes a range of integers
 * 
 */
object LoopCountRange
extends
AnyRef
with LoopCountRangeLowPriorityImplicits
{
  ;

  type _Any
  = LoopCountRange

  //
  // transparent inline
  def fromStartToIncludingEndIndex(start: Int, end: Int)
  : LoopCountRange
  = Range.inclusive(start, `end`)

  def fromStartToBeforeEndIndex(start: Int, end: Int)
  : LoopCountRange
  = Range(start, `end`)

  //
  @deprecated("alias of 'fromStartToIncludingEndIndex'.")
  transparent inline
  def inclusive(start: Int, end: Int)
  : LoopCountRange
  = fromStartToIncludingEndIndex(start, `end`)

  @deprecated("alias of 'fromStartToBeforeEndIndex'.")
  transparent inline
  def exclusive(start: Int, end: Int)
  : LoopCountRange
  = fromStartToBeforeEndIndex(start = start , `end` = end + -1 )

  // extension (d: LoopCountRange )
  //   def start = d.start
  //   def end   = d.end

  case class SpclStartAndEndIndexOps(val d: Range ) :
    export d.{start, end }
  //
  given cSpclStartAndEndIndexOps
  : Conversion[_Any, SpclStartAndEndIndexOps]
  = SpclStartAndEndIndexOps.apply

  // protected
  object implicitConversionsFromAndToStdRangeObj
  {
    ;

    @deprecated("use factory-method 'inclusive'. ")
    given Conversion[Range, LoopCountRange]
    = (<:<.refl[Range] ).apply

    @deprecated
    given Conversion[LoopCountRange, Range]
    = (<:<.refl[Range] ).apply

  }


  ;
}

protected
trait LoopCountRangeLowPriorityImplicits
{ this : LoopCountRange.type =>
  ;

  export implicitConversionsFromAndToStdRangeObj.given

}







