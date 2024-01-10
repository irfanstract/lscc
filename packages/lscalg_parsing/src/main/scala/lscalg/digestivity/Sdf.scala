package lscalg.digestivity

















/**
 * 
 * on an obtained `Subject`, one can do this
 * 
 * ```
 * val dOpt = tryParse(src = existingInpPos, subject = s )
 * ```
 * 
 * a `Subject`
 * can be obtained from one of the factory methods,
 * most which builds on given "partial digest function"
 * 
 * ```
 * Subject.fromLiftedPartialFunction((inpPtr: FileReadPos ) => {
 *   ;
 *   inpPtr.tryNextBigDecimal()
 * } )
 * ```
 * 
 * `lscalg.parsing`
 * 
 */
@deprecated
transparent inline
def Subject
: Sdf.type
= Sdf

/**
 * 
 * on an obtained `Subject`, one can do this
 * 
 * ```
 * val dOpt = tryParse(src = existingInpPos, subject = s )
 * ```
 * 
 * a `Subject`
 * can be obtained from one of the factory methods,
 * most which builds on given "partial digest function"
 * 
 * ```
 * Subject.fromLiftedPartialFunction((inpPtr: FileReadPos ) => {
 *   ;
 *   inpPtr.tryNextBigDecimal()
 * } )
 * ```
 * 
 * `lscalg.parsing`
 * 
 */
object Sdf
extends
AnyRef
with SdfCases
with SdfRepr
with SdfCommonlyNeededOps
with SdfZipWithReceiverIPackedCases
{
  ;

  ;

  locally {}

  ;
}




;



/* debugging the incremental compiler */

transparent inline
def psfLastCompileTime
  ()
: String
= ${psfEcdImpl() }

def psfEcdImpl
  (using quoted.Quotes )
  ()
: quoted.Expr[String]
= {
  import language.unsafeNulls
  val d = (new java.util.Date ).toLocaleString()
  quoted.Expr(d)
}















