package lscalg.bnfParsing














object IRegExp {

  opaque type ForRegexp[+V]
  <: util.matching.Regex
  = util.matching.Regex

  def forRegExpr(code: String)
  : ForRegexp[code.type ]
  = code.r

  final
  lazy val tagImplicits
  : iRegExpTagImplicits.type
  = valueOf

}

object iRegExpTagImplicits {
  ;

  extension (code: String) {
    def r
    = IRegExp.forRegExpr(code)
  }

  ;
}













