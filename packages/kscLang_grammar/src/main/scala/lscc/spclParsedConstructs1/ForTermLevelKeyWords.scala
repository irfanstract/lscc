package lscc.spclParsedConstructs1


























// TODO
/** 
 * `ForTermLevelUnprefixedKeyword` --
 * only concerns the unprefixed usages of those "word"s .
 * 
 */
object ForTermLevelUnprefixedKeyword
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  // protected
  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    ( )
  = {
    ;
    
    ({
      ;

      import IRegExp.tagImplicits.r

      // TODO
      FTLK((
        ForMustAlwaysBeKeyword()
        orElse
        ForKwPre("""ref|refs""".r )
      ))
    })
    .match { case r => {
      KeywordingCtx.fromFtlk(r)
    } }
  }
}

/** 
 * `ForTypeLevelUnprefixedKeyword` --
 * only concerns the unprefixed usages of those "word"s .
 * 
 */
object ForTypeLevelUnprefixedKeyword
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  // protected
  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    ( )
  = {
    ;

    ({
      ;

      import IRegExp.tagImplicits.r

      // TODO
      FTLK((
        ForMustAlwaysBeKeyword()
        orElse
        ForKwPre("""([_]+|)(object(?:ype|)|single(?:ton|type|t|)|match(?:es|))""".r )
      ))
    })
    .match { case r => {
      KeywordingCtx.fromFtlk(r)
    } }
  }
}

// TODO
/** 
 * `ForTypeLevelNsDotQualifiedKeyword` --
 * only concerns the ns-dot-qualified usages of those "word"s .
 * 
 */
object ForTypeLevelNsDotQualifiedKeyword
{
  ;

  // import lscalg.bnfParsing.{given }
  import lscalg.bnfParsing.IRegExp
  import lscalg.bnfParsing.BnfCompatibleFileReadPtr1

  // protected
  def apply
    //
    (using ec : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[ec.T, util.matching.Regex, ec.SpclAfterDigestTupleOption._Any ] )
    ( )
  = {
    ;
    
    ({
      ;

      import IRegExp.tagImplicits.r

      // TODO
      FTLK((
        ForMustAlwaysBeKeyword()
        orElse
        ForKwPre("""ref(?:)|object(?:ype|)|single(?:ton|type|t|)""".r )
      ))
    })
    .match { case r => {
      KeywordingCtx.fromFtlk(r)
    } }
  }
}












