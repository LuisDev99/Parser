%{
    #include <stdio.h>
    #include <stdlib.h>
%}

%option c++
%option outfile="Scanner.cpp"
%option case-insensitive
%option noyywrap

ADD_OP [+-]

/* DIGITO [0-9] */
/* LETRA [a-zA-ZñÑ] */
/* ENTERO {DIGITO}+ */
/* REAL {DIGITO}+"."{DIGITO}+ */
/* IDENTIFICADOR {LETRA}({LETRA}|{DIGITO}|"_")* */

DELIMITADOR [\t\r\f" "]

%%

{ADD_OP}        {printf("Operador +    %s\n",yytext);}

{ENTERO}        {printf("Numero Entero %s\n",yytext);}
{REAL}          {printf("Numero Real   %s\n",yytext);}
{IDENTIFICADOR}	{printf("Identificador %s\n",yytext);}

{DELIMITADOR}   {}
.               {printf("ERROR LEXICO");}


%%




