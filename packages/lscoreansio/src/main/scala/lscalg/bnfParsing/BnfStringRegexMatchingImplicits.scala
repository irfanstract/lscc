package lscalg.bnfParsing
















private
object bnrpStringRegexMatchingImplicits
{
  ;

  ;

  extension (d: String)
    def tryCheckAndSplitAndExtractAfterPrefix
      (r: util.matching.Regex )
    = {
      import language.unsafeNulls

      for {
        (matchedString , plRemainder ) <- d.tryCheckAndSplitAfterPrefix(r)
        `r`(m*) = matchedString : @unchecked
      }
      yield ((matchedString, m ) , plRemainder )
    }
  //

  extension (s: String)
    def tryCheckAndSplitAfterPrefix
      (r: util.matching.Regex )
    = {
      import language.unsafeNulls

      ({
        r
        .match { case r => {
          r
          .withLeadingInputStartMatcher()
          .match { case r => {
            r
            .match { case r => {
              r
              .pattern
              .matcher(s)
            } }
            .match { case m => {
              Option.when(m.find() )(m )
            } }
          } }
        } }
      })

      .map(matcher => {
        val mEnd
        = matcher.end()

        s.splitAt(mEnd )
      } )
    }

  extension (r: util.matching.Regex )
    /** 
     * `plusLineRemaindPattern`,
     * also adding extra *group*s
     * 
     * ```
     * s"($pattern)(.*?)"
     * .r
     * ```
     * 
     */
    def plusLineRemaindPattern()
    = {
      r
      .regex
      .match { case pattern => s"($pattern)(.*?)" }
      .r
    }

  extension (r: util.matching.Regex )
    def withLeadingInputStartMatcher()
    = {
      r
      .regex
      .match { case pattern => pattern.prependedAll("""\A""") }
      .r
    }

  ;
}













