package lscc.spclParsedConstructs1

















trait SpclGrammaticalPxery
  //
  // (using val entryAndExitLoggingMode1 : SpclGrammaticalPxery.SpclEntLoggingMode)
extends
AnyRef
with SpclGrammaticalPxeryThisType
with SpclPxeryOpsGivenFispoSupps
with SpclPxeryOpsSdfDefine
with SpclGrammaticalPxeryPrfLoggingExtensionMethod1
{
  ;

  implicit
  val givenFispoSupp
  : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any

  implicit
  val grmMetadataWrapMode
  : SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[givenFispoSupp.InputState, givenFispoSupp.InputState ]

  implicit
  val expcRx
  : lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[givenFispoSupp.InputState, util.matching.Regex, givenFispoSupp.SpclAfterDigestTupleOption._Any ]

  ;

  // /** 
  //  * spcl ParseFunction/FromSrcStreamDigestFnc which yields as-value instance-of `Value` wrapped in `grmMetadataWrapMode.AppliedTo`
  //  * 
  //  */
  // type SpclSdfYielding
  //   [+Value]
  // = SpclSdfYieldingUnwrapped[grmMetadataWrapMode.AppliedTo[Value ] ]

  // /** 
  //  * spcl ParseFunction/FromSrcStreamDigestFnc which yields as-value instance-of `Value`
  //  * 
  //  */
  // type SpclSdfYieldingUnwrapped
  //   [+Value]
  // >: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState , ([e] =>> e )[Value ] ] @annotation.unchecked.uncheckedVariance
  // <: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState , ([e] =>> e )[Value ] ] //

  // extension [Value] (f: SpclSdfYieldingUnwrapped[Value] )
  //   def withFinalPtrPosVl
  //     ()
  //     (using util.NotGiven[Value <:< grmMetadataWrapMode.AppliedTo[Any] ] )
  //   : SpclSdfYielding[Value ]
  //   = {
  //     f.mapWithFinalPtrPosVl((vau, pos) => (
  //       vau
  //       .withSrcInfo(srcPosInfo = pos )
  //     ) )
  //   }
  // //

  ;

  // transparent inline
  // def SpclGrammaticalPxery_this
  // : this.type
  // = this

  ;
}

object SpclGrammaticalPxery
{
  ;

  ;

  implicit
  def make
    //
    (using g : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any )
    (using a : SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[g.InputState, g.InputState ] )
    (using eRx : (
      lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[g.InputState, util.matching.Regex, g.SpclAfterDigestTupleOption._Any ] 
    ))
    (using onEntryAndExitLoggingModeImpl : (
      SpclEntLoggingMode {
        type SupportedEnclosingCtx
          >: SpclGrammaticalPxery {
            val givenFispoSupp: g.type
          }
          <: SpclGrammaticalPxery
      }
    ) )
  //
  : SpclGrammaticalPxery {val givenFispoSupp: g.type; val grmMetadataWrapMode: a.type; val expcRx: eRx.type}
  = {
    new SpclGrammaticalPxery {
      ;
      val givenFispoSupp : g.type = valueOf
      val grmMetadataWrapMode : a.type = valueOf
      val expcRx : eRx.type = valueOf
      
      val entryAndExitLoggingMode1 = onEntryAndExitLoggingModeImpl
    }
    .nn
  }

  ;
  
  // TODO
  trait SpclEntLoggingMode private [SpclGrammaticalPxery] ()
  {
    ;

    type SupportedEnclosingCtx
    <: SpclGrammaticalPxery

    def onEntry
      //
      (using ctx: SupportedEnclosingCtx )
      (msg: String, p: ctx.givenFispoSupp.InputState )
    : SpclExitLoggingMode
  }

  object SpclEntLoggingMode
  {
    ;

    def forCurriedFunc
      //
      [SupportedEnclosingCtxT <: SpclGrammaticalPxery ]
      (impl: (
        //
        (ctx: SupportedEnclosingCtxT ) =>
        (msg: String, p: ctx.givenFispoSupp.InputState ) =>
          SpclExitLoggingMode
      ) )
    = new SpclEntLoggingMode {
      ;

      type SupportedEnclosingCtx
      >: SupportedEnclosingCtxT
      <: SupportedEnclosingCtxT

      def onEntry
        //
        (using ctx: SupportedEnclosingCtx )
        (msg: String, p: ctx.givenFispoSupp.InputState )
      = impl(ctx)(msg = msg , p = p )
    }

    def noOpInstance
    = forCurriedFunc((ctx: SpclGrammaticalPxery ) => { case e => {
      ;
      ({ case _ =>  } : (util.Try[Unit] => Unit )) : SpclExitLoggingMode
    } } )

    implicit
    def defaultInstance
      //
      [T >: SpclGrammaticalPxery <: SpclGrammaticalPxery]
    : (SpclEntLoggingMode{type SupportedEnclosingCtx >: T <: T } )
    = noOpInstance

  }

  // TODO
  opaque type SpclExitLoggingMode
  >: (util.Try[Unit] => Unit )
  <: (util.Try[Unit] => Unit )
  =  (util.Try[Unit] => Unit )

  ;
}



trait SpclGrammaticalPxeryThisType
{
  ;

  transparent inline
  def SpclGrammaticalPxery_this
  : this.type
  = this

  ;
}

trait SpclPxeryOpsGivenFispoSupps
{
  ;

  implicit
  val givenFispoSupp
  : lscalg.bnfParsing.spclCommonLookaheadCaps1.GivenFispoSupp._Any

  implicit
  val grmMetadataWrapMode
  : SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[givenFispoSupp.InputState, givenFispoSupp.InputState ]

  ;
}

trait SpclPxeryOpsSdfDefine
{ this : SpclPxeryOpsGivenFispoSupps =>
  ;

  /** 
   * spcl ParseFunction/FromSrcStreamDigestFnc which yields as-value instance-of `Value` wrapped in `grmMetadataWrapMode.AppliedTo`
   * 
   */
  type SpclSdfYielding
    [+Value]
  = SpclSdfYieldingUnwrapped[grmMetadataWrapMode.AppliedTo[Value ] ]

  /** 
   * spcl ParseFunction/FromSrcStreamDigestFnc which yields as-value instance-of `Value`
   * 
   */
  type SpclSdfYieldingUnwrapped
    [+Value]
  >: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState , ([e] =>> e )[Value ] ] @annotation.unchecked.uncheckedVariance
  <: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState , ([e] =>> e )[Value ] ] //

  extension [Value] (f: SpclSdfYieldingUnwrapped[Value] )
    def withFinalPtrPosVl
      ()
      (using util.NotGiven[Value <:< grmMetadataWrapMode.AppliedTo[Any] ] )
    : SpclSdfYielding[Value ]
    = {
      f.mapWithFinalPtrPosVl((vau, pos) => (
        vau
        .withSrcInfo(srcPosInfo = pos )
      ) )
    }
  //

  ;
}

// AnyRef
// with SpclGrammaticalPxeryThisType
// with SpclPxeryOpsGivenFispoSupps
// with SpclPxeryOpsSdfDefine

trait SpclGrammaticalPxeryPrfLoggingExtensionMethod1
{
  this : (
    AnyRef
    & SpclGrammaticalPxeryThisType
    & SpclPxeryOpsGivenFispoSupps
    & SpclPxeryOpsSdfDefine
    & SpclGrammaticalPxeryPrfLoggingExtensionMethod1
  ) =>
  ;

  ;

  // // implicit
  // val entryAndExitLoggingMode1
  // : SpclGrammaticalPxery.SpclEntLoggingMode

  val entryAndExitLoggingMode1
  : SpclGrammaticalPxery.SpclEntLoggingMode { type SupportedEnclosingCtx >: SpclGrammaticalPxery_this.type <: SpclGrammaticalPxery }

  extension [Value] (f: SpclSdfYieldingUnwrapped[Value] )
  {
    def withLogging1(mainMsg: String)
    : SpclSdfYieldingUnwrapped[Value]
    = {
      f
      .match { case impl => {
        import lscalg.digestivity.ParseFunction

        ParseFunction.fromAltBRetrialFunction((
          (pt: SpclGrammaticalPxery_this.givenFispoSupp.InputState ) => {
            lazy val (started1 @ onExit) = {
              entryAndExitLoggingMode1.onEntry(using SpclGrammaticalPxery_this )(msg = mainMsg , p = pt )
            }

            // TODO
            started1

            (f)
            .applyBrt(pt )
            .lazyPrependedAllC({ started1 ; Nil })
            .zipWithIndex
            .match { case s => {
              ;

              ({
                s
                .tapEach({
                  //
                  lazy val asDone = {
                    ;

                    onExit.apply({
                      util.Success(() )
                    })
                  }

                  _ => asDone
                })
              }) lazyAppendedAllC ({
                ;

                if s.nonEmpty then {
                  ;

                  /* the "found at-least one production" logging had been done above */
                }
                else {
                  ;

                  onExit.apply({
                    util.Failure((
                      new Exception(s"failure (n=${s.length }) for ($mainMsg) ")
                    ))
                  })
                }

                Nil
              })
            } }
            .match { case r => r }
            .map((v, i) => v )
          }
        ))
      } }
    }
  }

  ;
}








