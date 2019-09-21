%{
    #include <stdio.h>
    #include <stdlib.h>
    #include "tokens.h"

%}



%option c++
%option outfile="Scanner.cpp"
%option case-insensitive
%option noyywrap


COMMENT "//".*
WHITESPACE [\t\r\f" "]


ID ({LETTER}|"_")({LETTER}|{DIGIT})*
ADD_OP [+-] 
MULT_OP [*/]
LOG_OP ("||")|("&&")
REL_OP (">")|("<")|("==")|("<=")|(">=")

STRING_LITERAL ["]({LETTER}|{DIGIT}|" "|[%=@,-=()_])*["]
DATE_LITERAL {DIGIT}{DIGIT}"/"{DIGIT}{DIGIT}"/"{DIGIT}{DIGIT}{DIGIT}{DIGIT}

DIGIT [0-9]
LETTER [a-zA-Z]

INT_LITERAL {DIGIT}+
REAL_LITERAL {DIGIT}+"."{DIGIT}+


%%

"."             { return PERIOD; } 
"::"            { return DDPERIOD;}
"++"            { return INCR;}    
"false"         { return False_Literal;}
"true"          { return True_Literal;}
"while"         { return WHILE;}
"if"            { return IF;}
"else"          { return ELSE;}
"EXIT"          { return RETURN;}
"BEGIN"         { return INICIO;}
"THEN"          { return IF_THEN;}
"DO"            { return DO;}
"END"           { return END;}
"static"        { return STATIC_TKN;}
"int"           { return INT_TYPE;}
"anytype"       { return ANYTYPE_TYPE;}
"boolean"       { return BOOLEAN_TYPE;}
"void"          { return VOID_TYPE;}
"real"          { return REAL_TYPE;}
"String"        { return STRING_TYPE;}
"date"          { return DATE_TYPE;}
";"             { return SEMICOLON;}
"("             { return PAR_OP;}
")"             { return PAR_CL;}
"{"             { return BRACK_OP;}
"}"             { return BRACK_CL;}
","             { return COMA;}
"E"             { return EPSILON;}


{ID}            { return ID;}
{ADD_OP}        { return ADD_OP;}
{MULT_OP}       { return MULT_OP;}
{LOG_OP}        { return LOG_OP;}
{REL_OP}        { return REL_OP;}

{INT_LITERAL}    { return INT_LITERAL;}
{REAL_LITERAL}   { return REAL_LITERAL;}
{STRING_LITERAL} { return STRING_LITERAL;}
{DATE_LITERAL}   { return DATE_LITERAL;}


{WHITESPACE}    { return EPSILON;}
{COMMENT}       {}

.               { return ERROR;}


%%