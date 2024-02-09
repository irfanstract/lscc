







# _





## Coding Convention

### Suggested Ordering Of The `import`s

```scala

def processItems
  (using rtConfig : ProcessItemsRtConfig )
  (using tSyntaxConfig : TSyntax )
  ()
  (using delivPrefs : ProcessItemsDelivPrefs )
= {
  ;

  /*
   * IMPLIED GIVENS IMPORTS
   * 
   * see https://contributors.scala-lang.org/t/encoding-type-class-hierarchies/4626 
   * 
   */
  import rtConfig.given
  import tSyntaxConfig.given

  ;

  /*
   * RELEVANT GENERAL-PURPOSE IMPORTS
   * 
   * imports from
   * packages in pre-existing libraries
   * 
   */

  import scala.util.{*}
  
  import scala.concurrent.duration.{*, given }

  ;

  /*
   * RELEVANT ON-TOPIC IMPORTS
   * 
   * imports from
   * packages defined by the current project
   * 
   * */

  import lscc.spclGrammar.forTermOrTypeLevelExprs.{*}
  import lscc.spclGrammar.forStatementalExprs.{*}
  import lscc.spclGrammar.for.{*}

  ;

  /*
   * SYNTACTIC IMPORTS
   * 
   * this is essential/necessary
   * in order for "orphaned givens" to ever work
   * 
   */

  import lscalg.digestivity.ParseFunction.returnedMainValueMapOpImplicits.given
  import lscalg.digestivity.Subject.returnedMainValueMapOpExtras.returnedMainValueWithFinalPosMapOps1
  import lscalg.digestivity.subjectConcatOps1.given

  ;

  ...
  ...

  ;
}

;

```






