






classes (with)in `lscc.spclGrammar`
is restricted to dealing with the source-string-to-AST parsing and also post-AST lint-ing,
excluding
- type-checking
  (although in future I may choose to add typechecking-sensitive parsing modes )
- defs for TerminalLiteral (eg UnescapedWord(s), BacktickedIdentifier(s), NumericLiteral(s), StringLiteral(s), etc ) ;
  look at `spclTerminalGrammarsB` instead













