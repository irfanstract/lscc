






classes (with)in `lscc.spclGrammar`
is restricted to *untyped AST repr(s) of the supported lang construct(s)* ,
excluding
- type-checking and *the typed versions of those AST repr(s)*
  (although in future I may choose to add typechecking-sensitive parsing modes )
- defs for TerminalLiteral (eg UnescapedWord(s), BacktickedIdentifier(s), NumericLiteral(s), StringLiteral(s), etc ) ;
  look at `spclTerminalGrammarsB` instead


*dealing with the source-string-to-AST parsing and also post-AST lint-ing*












