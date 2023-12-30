package lscalg.cli.repl













object LineNumberAndContents { type _Any >: LineNumberAndContents <: LineNumberAndContents }
case class LineNumberAndContents(index: Int, contents: String )

trait DefinesGetRemainingLines[-A, +R]
{
  ;

  extension (s: A )
    def remainingLines
    : R

}
// object DefinesGetRemainingLines {
//   ;
//
//   ;
// }

/** 
 * cannot define companion namespace obj `DefinesGetRemainingLines` as
 * that'd lead to "Cyclic Reference" complaints.
 * 
 */
object commonDefinesGetRemainingLinesConv
{
  ;

  def basicInstance
    [A, R] (applyTo: A => R )
  = {
    new DefinesGetRemainingLines[A, R] {
      ;
      extension (s: A )
        def remainingLines = applyTo(s)
    }
  } : DefinesGetRemainingLines[? >: A, ? <: R]

  @deprecated
  def drlItemStructurisingWrapper [A , Cc[+a] <: collection.IterableOps[a, Cc, Cc[a] ] ] (using impl : DefinesGetRemainingLines[A, Cc[String]])
  : DefinesGetRemainingLines[A, Cc[LineNumberAndContents] ]
  = {
    impl
    .andThen(r => {
      r
      .zipWithIndex
      .map({ case (c, i) => LineNumberAndContents(index = i , contents = c ) })
    } )
  }

  @deprecated
  implicit
  def drlItemExtractingWrapper [A, Cc[+a] <: collection.IterableOps[a, Cc, Cc[a] ] ] (using impl : DefinesGetRemainingLines[A, Cc[LineNumberAndContents] ])
  : DefinesGetRemainingLines[A, Cc[String] ]
  = {
    impl
    .andThen(r => {
      r
      .map({ case l => l.contents : String })
    } )
  }

  extension [A0, R0] (impl: DefinesGetRemainingLines[A0, R0] ) {
    def andThen[R2] (f2: R0 => R2 )
    = {
      import impl.{remainingLines as remainingLines0 }
      new DefinesGetRemainingLines[A0, R2] {
        ;
        extension (s: A0 )
          def remainingLines = remainingLines0(s).match { case r => f2(r) }
      }
    }

    def compose[A00] (f2: A00 => A0 )
    = {
      import impl.{remainingLines as remainingLines0 }
      new DefinesGetRemainingLines[A00, R0] {
        ;
        extension (s: A00 )
          def remainingLines = f2(s).match { case a => remainingLines0(a) }
      }
    }
  }

  ;
}

transparent inline
def DefinesGetRemainingLinesConv
: commonDefinesGetRemainingLinesConv.type
= commonDefinesGetRemainingLinesConv

trait DefinesGetSrcFileInfo[-A, +R]
{
  ;

  extension (s: A )
    def srcFileInfo
    : R

}

object DefinesGetSrcFileInfo {
  ;

  def apply
    [A, R] (applyTo: A => R )
  = {
    new DefinesGetSrcFileInfo[A, R] {
      ;
      extension (s: A )
        def srcFileInfo = applyTo(s)
    }
  } : DefinesGetSrcFileInfo[? >: A, ? <: R]

  ;
}





object NextIncreasingLengthDequeueRetrialItrOps1 {
  ;

  class _Impl
    [-A, +Ln ]
    (using DefinesGetRemainingLines[A, Seq[Ln] ] )
    ()
  {
    ;

    extension (p: A ) {
      //

      // private
      // transparent inline
      def nextIncreasingLengthDequeueRetrialItr1
        ()
      = {
        ;

        val existingLines
        = p.remainingLines

        LazyList.unfold ((Seq(), existingLines))({
          PartialFunction.fromFunction(<:<.refl[(Seq[Ln], Seq[Ln] )] )
          .andThen({
            case (l0, newLine +: l2) =>
              (l0 :+ newLine, l2 )
              .match { case tup => (tup, tup) }

          })
          .lift
        })
        .collect({
          case p @ (poppedLines @ (_ +: _ ), afterCheckRemainingLines) =>
            p
        })

        .match { case r => lscalg.parsing.BRetrialIterator.from(r) }

        .match { case r => r }
      }

      def nextUpToNLinesDequeueRetrialItr1
        //
        (lineCountLimit: Int )
      = {
        ;
        require(1 <= lineCountLimit )

        val existingLines
        = p.remainingLines

        p.nextIncreasingLengthDequeueRetrialItr1()

        .takeWhile({
          case (poppedLines, afterCheckRemainingLines) =>
            poppedLines.length <= lineCountLimit
        })

        .match { case r => r }
      }
    }

  }

  type ForAAndLn
    [-A, +Ln ]
  = _Impl[A, Ln]

  given given_ForAAndLn_A_Ln[A, Ln ](using DefinesGetRemainingLines[A, Seq[Ln] ] )
  : ForAAndLn[A, Ln]
  = new _Impl[A, Ln ]

}











