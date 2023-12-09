package lscc.spclMeta















object SpclAnyFunSuite {
  ;

  ;

  object aftermathsUtil {
    ;
    
    def printlnBanner
      (topic: String)
    : Unit
    = {
      ;

      import language.unsafeNulls

      println(s"done for <<${topic}>>")
      println(currentDateStr() )

      ;
    }

    ;
  }

  ;

  // private
  // transparent
  inline
  def currentDateStr
    ()
  : String
  = {
    import language.unsafeNulls

    currentDateFmt() format (new java.util.Date() )
  }

  def currentDateFmt
    ()
  : java.text.DateFormat
  = {
    import language.unsafeNulls
    ({
      import java.text.DateFormat.{*}
      getDateTimeInstance(MEDIUM, MEDIUM, java.util.Locale.getDefault() )
    })
  }

  ;
}











