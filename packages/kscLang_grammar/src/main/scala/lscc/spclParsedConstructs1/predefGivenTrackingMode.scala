package lscc.spclParsedConstructs1


















transparent inline
def SpclApm
: SpclGrammaticalItemMetaDataWrapMode.type
= SpclGrammaticalItemMetaDataWrapMode

type SpclApm[+R]
= SpclGrammaticalItemMetaDataWrapMode





export lscc.spclParsing.SpclGrammaticalItemMetaDataWrapMode






type SpclApModeDependentTuple1[+T1[C[_]] ]
= (
  //

  (SpclApm._Any, Any ) {
    ;
    val _2 : T1[_1.AppliedTo ]
  }
)

type SpclApModeDependentTuple2[+T1[C[_]] , +T2[C[_]] ]
= (
  //

  (SpclApm._Any, Any, Any ) {
    ;
    val _2 : T1[_1.AppliedTo ]
    val _3 : T2[_1.AppliedTo ]
  }
)










