
package lscc

package asToolChain








import lscc.asToolChain.ext.rfsPredef.{*, given }







object SpclStdInReadline {
  ;

  ;

  type _Any
  >: Impl
  <: Impl

  def apply()
  : _Any
  = new Impl()

  protected
  class Impl(
    val promptChar: String
    = ">"
    ,
  )
  {
    ;

    ;

    ;

    // TODO
    lazy val lReader = {
      import language.unsafeNulls

      import org.jline

      ({
        ;
        jline.reader.LineReaderBuilder.builder()
        .build()
      })
      .match { case r => {
        System.err.println(s"created terminal: ${r.getTerminal().getType() } ")
        r
      } }
    }

    // val promptChar = ">"

    /** 
     * `newReadlineSeq` - subject to race-condition!
     * 
     */
    def newReadlineSeq()
    = {
      ;

      LazyList.continually({
        import language.unsafeNulls
        lReader.readLine(promptChar ++ " ")
      })
    }

    /** 
     * `newReadlinePermut` - subject to race-condition!
     * 
     */
    def newReadlinePermut()
    = {
      ;

      lscalg.bnfParsing.BRetrialIterator.from({
        val _ +: itr = {
          ;

          LazyList.iterate[Seq[String] ] (Seq() ) ((existingLOcs) => {
            ;
            IndexedSeq() :+ {
              val existingTxt
              = existingLOcs.mkString("\r\n")
              ({
                import language.unsafeNulls
                lReader
                .readLine(promptChar ++ " " , null : Null | java.lang.Character, existingTxt )
              })
            }
          })
        } : @unchecked
        itr
      })
      .map(_.to(LazyList ) )
      .nn
    } : lscalg.bnfParsing.BRetrialIterator.ForR[LazyList[String ] ]

    /** 
     * `newReadlineFilePermut` - subject to race-condition!
     * 
     */
    def newReadlineFilePermut()
    = {
      ;

      val linesPermut
      = newReadlinePermut()

      linesPermut

      .map(lnes => {
        lscc.spclParsing.spclUtil.Lrp.apply(fileName = "<repl>", c = lnes )
      })
    }

    ;
  }

  ;
}














