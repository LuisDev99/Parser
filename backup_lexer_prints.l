%{
    #include <stdio.h>
    #include <stdlib.h>
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

"."             {printf("PERIOD");}
"::"            {printf("DDPERIOD");}
"++"            {printf("INCR");}    
"false"         {printf("False Literal");}
"true"          {printf("True Literal");}
"while"         {printf("WHILE");}
"if"            {printf("IF");}
"else"          {printf("ELSE");}
"EXIT"          {printf("RETURN");}
"BEGIN"         {printf("INICIO");}
"THEN"          {printf("IF_THEN");}
"DO"            {printf("DO");}
"END"           {printf("END");}
"static"        {printf("STATIC_TKN");}
"int"           {printf("INT_TYPE");}
"anytype"       {printf("ANYTYPE_TYPE");}
"boolean"       {printf("BOOLEAN_TYPE");}
"void"          {printf("VOID_TYPE");}
"real"          {printf("REAL_TYPE");}
"String"        {printf("STRING_TYPE");}
"date"          {printf("DATE_TYPE");}



{ID}            {printf("ID %s", yytext);}
{ADD_OP}        {printf("ADD_OP %s", yytext);}
{MULT_OP}       {printf("MULT_OP %s", yytext);}
{LOG_OP}        {printf("LOG_OP %s", yytext);}
{REL_OP}        {printf("REL_OP %s", yytext);}

{INT_LITERAL}   {printf("INT_LITERAL %s", yytext);}
{REAL_LITERAL}  {printf("REAL_LITERAL %s", yytext);}
{STRING_LITERAL} {printf("STRING_LITERAL %s", yytext);}
{DATE_LITERAL}  {printf("DATE_LITERAL %s", yytext);}


{WHITESPACE}    {}
{COMMENT}       {}

.               {printf("ERROR LEXICO ENCONTRADO");}


%%