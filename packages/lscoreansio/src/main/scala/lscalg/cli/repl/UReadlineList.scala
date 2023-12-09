package lscalg.cli.repl












import scala.reflect.Selectable.reflectiveSelectable









object UReadLineList
{
  ;

  ;

  transparent
  inline
  def apply
    (src: java.io.BufferedReader )
  : LazyList[String]
  = fromJavaIoBufferedReader(src)
  
  /** 
   * based on given `java.io.BufferedReader`.
   * won't corrupt the stream, since
   * that's how `readLine` of every `java.io.BufferedReader` works.
   * 
   */
  def fromJavaIoBufferedReader
    (src: java.io.BufferedReader )
  : LazyList[String]
  = {
    ;

    import language.unsafeNulls

    import scala.jdk.CollectionConverters.{*}

    Iterator.unfold[String, Unit] (() )(_ => {
      ;
      Option(src.readLine() )
      /* `Some(readedValue )` */
      .match {
        case Some(value) =>
          Some((value : String , () ) )
        case None =>
          None
      }
    } )
    .to(LazyList )
  }

  /** 
   * based on given `java.util.Scanner`.
   * will likely corrupt the stream ;
   * `Scanner`s does buffering, which means,
   * pre-poping input exceeding what would be returned from the associated call
   * .
   * 
   */
  def fromJavaUtilScanner
    (src: java.util.Scanner )
  : LazyList[String]
  = {
    ;

    import language.unsafeNulls

    import scala.jdk.CollectionConverters.{*}

    (new collection.AbstractIterator[String] {
      ;
      def hasNext: Boolean = src.hasNextLine()
      def next(): String = src.nextLine()
    })
    .to(LazyList )
  }

  ;
}

object UReadLineFromList {
  ;

  def apply
    //
    (src: Seq[String] )
  = UReadLineFromSl(src )

  ;
}

object UReadLineFromSl
{
  ;

  import language.unsafeNulls

  ;

  def apply
    //
    (src: Seq[String] )
  = apply1(newHolder(src ) )

  def apply
    //
    (src: Iterator[String] )
  = apply1(newHolder(src.to(LazyList) ) )

  def newHolder
    [E]
    (d: Seq[E] )
  = {
    new java.util.concurrent.atomic.AtomicReference[(Option[E], collection.immutable.Seq[E] ) ]((None, d ) )
  }

  private
  def apply1
    //
    (src: java.util.concurrent.atomic.AtomicReference[(Option[String], collection.immutable.Seq[String] ) ] )
  : java.io.Reader
  = {
    new java.io.Reader {
      ;

      override
      def close(): Unit
      = {
        src
        .updateAndGet(_ => (None, Nil ) )
      }

      private
      def repopulate1
        (expectedLen: Int)
      : Unit
      = {
        ;

        src
        .getAndUpdate({
          //

          case (Some(c), _ ) =>
            throw new IllegalStateException(s"non-empty buf ('${c }')")

          case s0 @ (None, lines) =>
            lines
            .match {
              //

              case ln +: remainingLn =>
                (ln splitAt expectedLen )
                .match { case (matchedS, sameLineRemainingS) => {
                  (
                    Some(matchedS)
                    ,
                    remainingLn
                    .prependedAll({
                      Some(sameLineRemainingS)
                      .filter(_.nonEmpty)
                    })
                    ,
                  )
                } }
              //

              /* no more lines */
              case Seq() =>
                s0
            }
            .match { case s => s : (Option[String], Seq[String] ) }
          //

        })
      }

      // private
      def dequeueNextLen
        (requestedLen: Int)
      = {
        ;

        ({
          ;

          repopulate1(expectedLen = requestedLen )

          src
          .getAndUpdate({
            case s =>
              s.copy(_1 = None )
          })
        })
        ._1
      }

      override
      def read(cbuf: Array[Char], off: Int, requestedLen: Int): Int
      = {
        ;

        dequeueNextLen(requestedLen = requestedLen )

        .match {
          //
          case Some(value) =>
            new java.io.StringReader(value )
            .read(cbuf, off, math.max(requestedLen, (value: String ).length() ) )

          case None =>
            -1
        }
      }
    }
  }

  ;
}













