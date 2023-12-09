package lscc.spclParsing.spclUtil














// object Lrp
// {
//   ;

//   ;

//   type _Any
//   = ByFileName[String]

//   type ByFileName
//     //
//     [+Fnm <: String]
//   = ByFileNameAndContentsLl[Fnm, LazyList[String] ]

//   type ByFileNameAndContentsLl
//     //
//     [+Fnm <: String, +Ls <: LazyList[String] ]
//   >: (Fnm, Ls )
//   <: (Fnm, Ls )

//   def apply
//     (fileName: String, c: LazyList[String] )
//   : ByFileNameAndContentsLl[fileName.type, c.type ]
//   = (fileName, c )

//   extension (r: _Any )
//     transparent inline
//     def fileName = r._1
    
//   extension (r: _Any )
//     transparent inline
//     def lines = r._2

//   ;

//   ;
// }

final
lazy val Lrp
: lscalg.cli.repl.spclCollections.Lrp.type
= lscalg.cli.repl.spclCollections.Lrp

// object LazyRlb
// {
//   ;

//   ; 

//   lscalg.cli.repl.UReadlineConsole

//   def fromAssumedlyAnonRl
//     //
//     (src: java.io.BufferedReader )
//   = Lrp(fileName = "<repl>", c = lscalg.cli.repl.UReadLineList(src ) )

//   ;

//   ;
// }

final
lazy val LazyRlb
: lscalg.cli.repl.spclCollections.LazyRlb.type
= lscalg.cli.repl.spclCollections.LazyRlb










