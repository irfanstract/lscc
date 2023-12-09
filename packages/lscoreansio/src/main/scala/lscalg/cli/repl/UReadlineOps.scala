package lscalg.cli.repl













trait DefinesGetRemainingLines[-A, +R]
{
  ;

  extension (s: A )
    def remainingLines
    : R

}

trait DefinesGetSrcFileInfo[-A, +R]
{
  ;

  extension (s: A )
    def srcFileInfo
    : R

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
      }
    }

  }

  type ForAAndLn
    [-A, +Ln ]
  = _Impl[A, Ln]

  given [A, Ln ](using DefinesGetRemainingLines[A, Seq[Ln] ] )
  : ForAAndLn[A, Ln]
  = new _Impl[A, Ln ]

}











