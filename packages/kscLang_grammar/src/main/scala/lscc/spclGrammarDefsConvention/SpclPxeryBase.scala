package lscc.spclGrammarDefsConvention

















export lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode


export lscalg.bnfParsing.spclCptdFispoSuppExtras1.{GivenFispoSupp, GivenFiSpoSupp}







trait SpclGrPxDefinesThisType
{
  ;

  implicit
  transparent inline
  def SpclGrammaticalPxery_this
  : this.type
  = this

  ;
}

trait SpclPxeryOpsGivenFispoSupps
{
  ;

  ;

  implicit
  val givenFispoSupp
  : GivenFispoSupp._Any

  /** 
   * `InputState`
   * 
   */
  export givenFispoSupp.InputState as InputState

  implicit
  val grmMetadataWrapMode
  : SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[InputState, InputState ]

  ;
}

trait SpclPxeryOpsSdfDefine
{ this : SpclPxeryOpsGivenFispoSupps =>
  ;

  ;

  /** 
   * spcl ParseFunction/FromSrcStreamDigestFnc which yields as-value instance-of `Value` wrapped in `grmMetadataWrapMode.AppliedTo`
   * 
   */
  type SpclSdfYielding
    [+Value]
  = SpclSdfYieldingUnwrapped[(
    grmMetadataWrapMode.AppliedTo[Value ]
  ) ]

  /**
   * spcl ParseFunction/FromSrcStreamDigestFnc which yields as-value instance-of `Value`
   * 
   */
  type SpclSdfYieldingUnwrapped
    [+Value]
  >: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState , Value ] @annotation.unchecked.uncheckedVariance
  <: lscalg.digestivity.ParseFunction.ForReceiverAndRValue[givenFispoSupp.InputState , Value ] //

  ;

  extension [Value] (f: SpclSdfYieldingUnwrapped[Value] )
  {
    //

    def withFinalPtrPosVl
      ()
      (using util.NotGiven[Value <:< grmMetadataWrapMode.AppliedTo[Any] ] )
    : SpclSdfYielding[Value ]
    = {
      f
      .mapWithFinalPtrPosVl((vau, pos) => (
        vau
        .withSrcInfo(srcPosInfo = pos )
      ) )
    }
  }
  //

  ;

  /** 
   * permut-Iterable
   * 
   */
  type SpclBRetrialIteratorForItemT[+R]
  >: lscalg.probing.BRetrialIterator.ForItemT[R] @annotation.unchecked.uncheckedVariance
  <: lscalg.probing.BRetrialIterator.ForItemT[R]

  ;
}

trait SpclPxeryOpsGivenFispoSuppsAndExpecRxOps
  //
extends
AnyRef
with SpclPxeryOpsGivenFispoSupps
{
  this : (
    AnyRef
    & SpclPxeryOpsGivenFispoSupps
  ) =>
  ;

  implicit
  val givenFispoSupp
  : GivenFispoSupp._Any

  implicit
  val grmMetadataWrapMode
  : SpclGrammaticalItemMetaDataWrapMode.withPtrTRange[InputState, InputState ]

  implicit
  val expcRx
  : lscalg.bnfParsing.spclCommonLookaheadCaps.ForImmediatePatterOccurence._AnyForReceiverAndSpecAndReturnBaseType[
    InputState,
    util.matching.Regex,
    givenFispoSupp.SpclAfterDigestTupleOption._Any ]

  ;

  ;

  ;
}

// // AnyRef
// // with SpclGrammaticalPxeryThisType
// // with SpclPxeryOpsGivenFispoSupps
// // with SpclPxeryOpsSdfDefine





// object SpclGrammaticalPxeryEntryAndExitLogging
// {
//   ;

//   ;

//   // TODO
//   trait SpclEntLoggingMode private [SpclGrammaticalPxeryEntryAndExitLogging] ()
//   {
//     ;

//     type SupportedEnclosingCtx
//     <: SpclPxeryOpsGivenFispoSupps

//     def onEntry
//       //
//       (using ctx: SupportedEnclosingCtx )
//       (msg: String, p: ctx.givenFispoSupp.InputState )
//     : SpclExitLoggingMode
//   }

//   object SpclEntLoggingMode
//   {
//     ;

//     def forCurriedFunc
//       //
//       [SupportedEnclosingCtxT <: SpclPxeryOpsGivenFispoSupps ]
//       (impl: (
//         //
//         (ctx: SupportedEnclosingCtxT ) =>
//         (msg: String, p: ctx.givenFispoSupp.InputState ) =>
//           SpclExitLoggingMode
//       ) )
//     = new SpclEntLoggingMode {
//       ;

//       type SupportedEnclosingCtx
//       >: SupportedEnclosingCtxT
//       <: SupportedEnclosingCtxT

//       def onEntry
//         //
//         (using ctx: SupportedEnclosingCtx )
//         (msg: String, p: ctx.givenFispoSupp.InputState )
//       = impl(ctx)(msg = msg , p = p )
//     }

//     def noOpInstance
//       //
//       [T <: SpclPxeryOpsGivenFispoSupps ]
//     = forCurriedFunc((ctx: T ) => { case e => {
//       ;
//       ({ case _ =>  } : (util.Try[Unit] => Unit )) : SpclExitLoggingMode
//     } } )

//     implicit
//     def defaultInstance
//       //
//       [T <: SpclPxeryOpsGivenFispoSupps ]
//     : (SpclEntLoggingMode{type SupportedEnclosingCtx >: T <: T } )
//     = noOpInstance

//   }

//   // TODO
//   opaque type SpclExitLoggingMode
//   >: (util.Try[Unit] => Unit )
//   <: (util.Try[Unit] => Unit )
//   =  (util.Try[Unit] => Unit )

//   ;
// }

// trait SpclGrammaticalPxeryPrfLoggingExtensionMethod1
// {
//   this : (
//     AnyRef
//     & SpclGrammaticalPxeryThisType
//     & SpclPxeryOpsGivenFispoSupps
//     & SpclPxeryOpsSdfDefine
//     & SpclGrammaticalPxeryPrfLoggingExtensionMethod1
//   ) =>
//   ;

//   ;

//   val entryAndExitLoggingMode1
//   : SpclGrammaticalPxeryEntryAndExitLogging.SpclEntLoggingMode { type SupportedEnclosingCtx >: SpclGrammaticalPxery_this.type <: SpclPxeryOpsGivenFispoSupps }

//   extension [Value] (f: SpclSdfYieldingUnwrapped[Value] )
//   {
//     def withLogging1(mainMsg: String)
//     : SpclSdfYieldingUnwrapped[Value]
//     = {
//       f
//       .match { case f => {
//         ;

//         given ecScheduler
//         : concurrent.ExecutionContext.parasitic.type
//         = concurrent.ExecutionContext.parasitic

//         import lscalg.digestivity.ParseFunction

//         ParseFunction.fromAltBRetrialFunction((
//           (pt: SpclGrammaticalPxery_this.givenFispoSupp.InputState ) => {
//             ;

//             lazy val (started1 @ onExit) = {
//               entryAndExitLoggingMode1.onEntry(msg = mainMsg , p = pt )
//             }

//             /** 
//              * it's wrong to make calls to `onNext` more-than-once --
//              * it's wrong to fire `Failure` after `Success`, and vice-versa ;
//              * ;
//              * this is the managed route to do the job
//              * 
//              */
//             val asdonePr
//             : concurrent.Promise[Unit]
//             = concurrent.Promise[Unit]

//             for {
//               tr <- {
//                 ;
//                 asdonePr.future
//                 .transform(util.Success(_) )
//               }
//             }
//             do onExit(tr)

//             // // TODO
//             // started1

//             (
//               (f).applyBrt(pt )
//             )
//             .lazyPrependedAllC({ started1 ; Nil })

//             .zipWithIndex
//             .match { case s => {
//               ;

//               s
//               .tapEach({
//                 //
//                 lazy val asDone
//                 : Unit
//                 = {
//                   /**  */
//                   asdonePr.success(() )
//                 }

//                 _ => asDone
//               })
//               .lazyAppendedAllC({
//                 ;

//                 if s.isEmpty then {
//                   ;

//                   /** note: it's wrong to fire `Failure` after `Success` */
//                   asdonePr
//                   .tryFailure({
//                     new Exception(s"failure (n=${s.length }) for ($mainMsg) ")
//                   })
//                 }

//                 Nil
//               })
//             } }
//             .map((v, i) => v )
//             .match { case r => r }
//           }
//         ))
//       } }
//     }
//   }

//   ;
// }









