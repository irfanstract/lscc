package lscc.spclTerminalGrammarsB





















@deprecated("alias of 'ForImmediateSingleLineRawOcc'.")
transparent inline
def ForImmediateSingleLineMatchOf
: ForImmediateSingleLineRawOcc.type
= ForImmediateSingleLineRawOcc



// TODO
/**
 * 
 * immediate, single-line occurence of what the RegExp would select
 * 
 */
object ForImmediateSingleLineRawOcc
{
  ;

  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  import BnfCompatibleFileReadPtr1 as BC

  import IRegExp.tagImplicits.{r}

  // TODO
  transparent inline
  def apply
    //
    (using ctx : SpclPxery )
    (subject: IRegExp._Any )
  // : ctx.SpclSdfYieldingUnwrapped[ctx.givenFispoSupp.SpclMatchContent ]
  = {
    ;
    import ctx.given

    glscc.spclTerminalGrammars.ForImmediateSingleLineRawOcc.apply
      (subject )
  }.nn

  ((ctx : SpclPxery) => Seq[ctx.SpclSdfYieldingUnwrapped[ctx.givenFispoSupp.SpclMatchContent ] ]() )
  .nn

  ;
}












