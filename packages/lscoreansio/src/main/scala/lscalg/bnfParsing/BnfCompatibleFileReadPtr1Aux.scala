package lscalg.bnfParsing


















protected[bnfParsing]
trait BnfCompatibleFileReadPtrRepr1 private[bnfParsing] ()
extends
AnyRef
{ GrmPtr =>
  ;
  //

  type _Any
  = ImplAtRemainingPosAndSrcFile[?, ? ]

  type AtRemainingPosAndSrcFile
    [+RemnPos, +SrcFileInfo <: ElbdFileInfo ]
  = ImplAtRemainingPosAndSrcFile[? <: RemnPos, ? <: SrcFileInfo ]

  protected
  case class ImplAtRemainingPosAndSrcFile
    [+RemnPos, +SrcFileInfo <: ElbdFileInfo ]
    (remainingLinesImpl : LazyList[LineNumberAndContents], srcFileInfoImpl: SrcFileInfo )

  def atBeginningOfSrcFile
    (b: ElbdFileInfo )
  : AtRemainingPosAndSrcFile[Any, b.type ]
  = {
    ;
    ImplAtRemainingPosAndSrcFile[Any, b.type ] (
      remainingLinesImpl = {
        b.lines
        .zipWithIndex
        .map({ case (c, i) => LineNumberAndContents(index = i , contents = c ) })
      } , 
      srcFileInfoImpl = b )
  }

  given edgrl
  : lscalg.cli.repl.DefinesGetRemainingLines[_Any, ContentLines ]
  = {
    lscalg.cli.repl.DefinesGetRemainingLinesConv.basicInstance((s: _Any ) => {
      ;
      s.remainingLinesImpl
      .match { case l => l : ContentLines }
    } )
  }

  object extraEdgrlImplicits {
    ;

    given edgrlx
    : lscalg.cli.repl.DefinesGetRemainingLines[_Any, LazyList[String] ]
    = {
      ;
      lscalg.cli.repl.DefinesGetRemainingLinesConv.basicInstance((s: _Any) => {
        ;
        s.remainingLinesImpl
        .match { case l => l : ContentLines }
        .match { case l => l.map(ln => ln.contents ) }
      } : LazyList[String] )
    }

  }

  given withRemainingLinesOp
  : AnyRef
  with {
    //

    extension (pt0 : _Any )
      transparent inline
      def withRemainingLines(newValue: ContentLines )
      = {
        // TODO check suffix same

        pt0
        .match { case s0 => s0.copy(remainingLinesImpl = newValue ) : _Any }
      }

  }

  final
  lazy val remainingLinesLens
  = {
    locally[ContentLines => _Any => _Any ] (newValue => pt0 => pt0.withRemainingLines(newValue ) )
  }

  given edsi
  : lscalg.cli.repl.DefinesGetSrcFileInfo[_Any, ElbdFileInfo ]
  = {
    lscalg.cli.repl.DefinesGetSrcFileInfo((s: _Any) => (
      s.srcFileInfoImpl
    ) : ElbdFileInfo )
  }

  given eca
  : BnrpDoComposeAdvancement[_Any, ContentLines => ContentLines ]
  = {
    BnrpDoComposeAdvancement((pt0: _Any) => (f: ContentLines => ContentLines) => {
      ;

      locally[_Any] {
        pt0.remainingLines
        .match { case ls0 => f(ls0) }
        .match { case newLs => remainingLinesLens.apply(newLs )(pt0) }
        .match { case pt2 => pt2 }
      }
    } : _Any )
  }

  ;

  export lscalg.cli.repl.LineNumberAndContents

  type ContentLines
  >: LazyList[LineNumberAndContents]
  <: LazyList[LineNumberAndContents]

  /** 
   * every talked-about `lscc.spclParsing.spclUtil.Lrp` .
   * `the elaborated file info`
   * 
   */
  type ElbdFileInfo
  >: lscalg.cli.repl.spclCollections.Lrp._Any
  <: lscalg.cli.repl.spclCollections.Lrp._Any

  ;

  final
  lazy val SpclAfterDigestTupleOption
  : GeneralisedSpclAfterDigestTupleOption[GrmPtr._Any ]
  = implicitly

  type GeneralisedSpclAfterDigestTupleOption[T]
  = lscalg.bnfParsing.SpclTokenisedItemOption.SpclConstructor.ForCheckptType[T ]

  type GeneralisedSpclAfterDigestTupleOptionLU[-TL <: TU, +TU]
  = lscalg.bnfParsing.SpclTokenisedItemOption.SpclConstructor.ForCheckptTypeLU[TL, TU ]

  ;

  ;

  ;

  ;
}

trait BnrpDoComposeAdvancement
  [Receiver, -Cl <: Function1[?, ?] ]
{
  extension (s: Receiver)
    //

    /** 
     * after advancing the pos
     * 
     */
    def composeAdvancement
      (f: Cl )
    : Receiver
}
object BnrpDoComposeAdvancement {
  def apply[Receiver, Cl <: Function1[?, ?] ](impl: Receiver => Cl => Receiver )
  = {
    new BnrpDoComposeAdvancement[Receiver, Cl ] {
      extension (s: Receiver)
        def composeAdvancement(f: Cl) = impl.apply(s).apply(f)
    }
  } : BnrpDoComposeAdvancement[Receiver, ? >: Cl ]
}














