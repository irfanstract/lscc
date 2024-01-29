package lscc.spclParsedConstructs1





















// object ForNumericLiteralAndWordsAndIdents
// {
//   ;
//   import BnfCompatibleFileReadPtr1._Any as T
//   ;
// }

// TODO
export lscc.spclTerminalGrammarsB.{ForNumericLiteral1 }

export lscc.spclTerminalGrammarsB.{ForBigDecimalLiteral1 }

export lscc.spclTerminalGrammarsB.{ForBigHexadecimalLiteral1 }

/** 
 * `immediateUnescapedWord` ;
 * *excludes numeric literals, escaped identifiers,*
 * 
 */
export lscc.spclTerminalGrammarsB.{ForImmediateUnescapedWord }

export lscc.spclTerminalGrammarsB.{ForUnderscoreWildcardPattern }

/**
 * escaped identifier
 * 
 */
// @deprecated
export lscc.spclTerminalGrammarsB.{ForImmediateEscapedIdent }

/**
 * `quoted (with)in (a pair of) backticks` 
 * 
 */
export lscc.spclTerminalGrammarsB.{ForImmediateBacktickedIdent }

export lscc.spclTerminalGrammarsB.{Identifier }

export lscc.spclTerminalGrammarsB.{FixedIdentifier }

export lscc.spclTerminalGrammarsB.{ForKwPre}

export lscc.spclTerminalGrammarsB.{Keyword}

export lscc.spclTerminalGrammarsB.ForBhOrNmLiteral

export lscc.spclTerminalGrammarsB.ForTerminalLiteral1




;















