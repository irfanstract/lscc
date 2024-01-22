package glscc.spclTerminalGrammars















// TODO
case class Keyword[+Value] private[Keyword] (val value: Value )
object Keyword
{
  def apply
    [Value] (value: Value )
  : Keyword[value.type]
  = new Keyword[value.type](value )

  ;
}


/** 
 * Identifier closed from further interpolations
 * 
 */
case class FixedIdentifier [+Value] private[FixedIdentifier] (val value: Value )
object FixedIdentifier
{
  def apply
    [Value] (value: Value )
  : FixedIdentifier[value.type]
  = new FixedIdentifier[value.type](value )

  ;
}















