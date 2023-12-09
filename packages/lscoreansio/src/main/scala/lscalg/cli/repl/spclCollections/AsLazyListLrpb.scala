package lscalg.cli.repl.spclCollections















object Lrp
{
  ;

  ;

  type _Any
  = ByFileName[String]

  type ByFileName
    //
    [+Fnm <: String]
  = ByFileNameAndContentsLl[Fnm, LazyList[String] ]

  type ByFileNameAndContentsLl
    //
    [+Fnm <: String, +Ls <: LazyList[String] ]
  >: (Fnm, Ls )
  <: (Fnm, Ls )

  def apply
    (fileName: String, c: LazyList[String] )
  : ByFileNameAndContentsLl[fileName.type, c.type ]
  = (fileName, c )

  extension (r: _Any )
    transparent inline
    def fileName = r._1
    
  extension (r: _Any )
    transparent inline
    def lines = r._2
  //

  extension (r: _Any )
    transparent inline
    def linesNewReader()
    : java.io.Reader
    = lscalg.cli.repl.UReadLineFromList(r.lines )
  //

  ;

  ;
}

object LazyRlb
{
  ;

  ; 

  lscalg.cli.repl.UReadlineConsole

  /** 
   * from `BufferedReader` assumed to come from ad-hoc input sources like REPL -
   * therefore `fileName` would likely evaluate to "anon-ish" value eg `"(REPL)"`
   * 
   */
  def fromAssumedlyAnonRl
    //
    (src: java.io.BufferedReader )
  = Lrp(fileName = "<repl>", c = lscalg.cli.repl.UReadLineList(src ) )

  /** 
   * read from given code
   * 
   */
  transparent inline
  def fromSnippet
    //
    (code: String)
  = {
    ({
      ;

      import language.unsafeNulls

      code
      .match { case str => new java.io.StringReader(str) }
      .match { case r => new java.io.BufferedReader(r) }
    })
    .match { case r => fromAssumedlyAnonRl(r) }
  }

  ;

  ;
}











