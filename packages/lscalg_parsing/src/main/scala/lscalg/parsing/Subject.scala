package lscalg.parsing













// export lscalg.digestivity.Subject as SpclSubject
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
: lscalg.digestivity.Subject.type
= lscalg.digestivity.Subject

/**
 * 
 * on an obtained `ParseFunction`, one can do this
 * 
 * ```
 * // function (s: ParseFunction )
 * 
 * val dOpt = tryParse(src = existingInpPos, subject = s )
 * ```
 * 
 * a `ParseFunction`
 * can be obtained from one of the factory methods,
 * most which builds on given "partial digest function"
 * 
 * ```
 * ParseFunction.fromLiftedPartialFunction((inpPtr: FileReadPos ) => {
 *   ;
 *   inpPtr.tryNextBigDecimal()
 * } )
 * ```
 * 
 * `lscalg.parsing`
 * 
 */
transparent inline
def ParseFunction
: lscalg.digestivity.ParseFunction.type
= lscalg.digestivity.ParseFunction

;






/** 
 * concatenation of two Subject(s),
 * effectively composition of *inp-pos*,
 * 
 */
transparent inline
def subjectConcatOps1
: lscalg.digestivity.subjectConcatOps1.type
= lscalg.digestivity.subjectConcatOps1




export lscalg.digestivity.{PHTCO, PHTCOAlt }










