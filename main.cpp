#include "parser.h"

void hola();

int main()
{
    parser _parser;
    _parser.beginAnalyzer();
    //hola();
    cout << "KE PEXK";

    return 0;
}

void hola()
{
    ifstream in("./Programs/program1.txt");
    yyFlexLexer *lexer = new yyFlexLexer(&in);

    bool isZero = true;

    do
    {
        int token = lexer->yylex();

        if (token == 0)
            break;

        cout << token << endl;
        cout << lexer->YYText() << endl;

    } while (true);
}