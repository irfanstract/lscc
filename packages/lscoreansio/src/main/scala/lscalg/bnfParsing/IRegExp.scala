package lscalg.bnfParsing














object IRegExp
{
  ;

  opaque type _Any
  <: util.matching.Regex
  = util.matching.Regex

  opaque type ForRegexp[+V]
  <: _Any
  = util.matching.Regex

  opaque type ForLiteral[+V]
  <: _Any
  = util.matching.Regex

  def forRegExpr(code: String)
  : ForRegexp[code.type ]
  = code.r

  def forLiteral(code: String)
  : ForLiteral[code.type ]
  = forRegExpr(util.matching.Regex.quote(code) )

  ;

  final
  lazy val tagImplicits
  : iRegExpTagImplicits.type
  = valueOf

}

object iRegExpTagImplicits {
  ;

  extension (code: String) {
    def r
    : IRegExp.ForRegexp[code.type]
    = IRegExp.forRegExpr(code)
  }

  ;
}













