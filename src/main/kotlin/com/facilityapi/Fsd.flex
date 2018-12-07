package com.facilityapi;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.facilityapi.psi.FsdTypes.*;

%%

%{
  public FsdLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class FsdLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
NAME=[a-zA-Z_][a-zA-Z_0-9]*
COMMENT=("///".*)
NUMBER=[0-9]+(\.[0-9]*)?
STRING=\"[^\"]*\"
NAMESPACE=[a-zA-Z_0-9][.\w]*

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  ";"                { return SEMI; }
  "["                { return LBRACKET; }
  "]"                { return RBRACKET; }
  "("                { return LPAREN; }
  ")"                { return RPAREN; }
  "{"                { return LCURLY; }
  "}"                { return RCURLY; }
  ","                { return COMMA; }
  ":"                { return COLON; }
  "method"           { return METHOD; }
  "service"          { return SERVICE; }
  "data"             { return DATA; }
  "enum"             { return ENUM; }
  "errors"           { return ERRORS; }
  "int32"            { return INT32; }
  "int64"            { return INT64; }
  "decimal"          { return DECIMAL; }
  "double"           { return DOUBLE; }
  "boolean"          { return BOOLEAN; }
  "object"           { return OBJECT; }
  "map"              { return MAP; }
  "bytes"            { return BYTES; }
  "result"           { return RESULT; }

  {SPACE}            { return SPACE; }
  {NAME}             { return NAME; }
  {COMMENT}          { return COMMENT; }
  {NUMBER}           { return NUMBER; }
  {STRING}           { return STRING; }
  {NAMESPACE}        { return NAMESPACE; }

}

[^] { return BAD_CHARACTER; }
