#ifndef PARSER__
#define PARSER__

#include <FlexLexer.h>
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <tuple>
#include "tokens.h"

using namespace std;

class parser
{

private:
    vector<int> tokens;
    vector<tuple<string, string>> derivation;
    yyFlexLexer *lexer;
    ifstream in;
    int lookahead_token;
    string lookahead_token_content;

public:
    parser()
    {
        cout << " \t$$$$$$$$$ (Parsing) $$$$$$$$$ \n\n\n";
        this->in = ifstream("./Programs/program1.txt");
        this->lexer = new yyFlexLexer(&in);

        this->lookahead_token = this->lexer->yylex();

        if (this->lookahead_token != 0)
        {
            this->lookahead_token_content = this->lexer->YYText();
        }
    }

    ~parser()
    {
        cout << " \n\t$$$$$$$$$ (Finished Parsing) $$$$$$$$$ \n";
        delete this->lexer;
    }

    void PrintErrorMessage(string error_message)
    {
        /* Always print when encountering a terminal */
        cout << "Error: " + error_message << endl;
    }

    void Add_Derivation_Path(string function_name, string token)
    {
        derivation.push_back({function_name, token});
    }

    void Print_Derivations_Path()
    {
        cout << "++++ Printing Derivation Path of the input ++++\n\n";
        for (tuple<string, string> path : derivation)
        {
            cout << "\tFunction \"" + get<0>(path) + "\" received " + get<1>(path) << endl;
        }
        cout << "\n++++                The End                ++++\n\n";
    }

    void beginAnalyzer();

    bool Match(string content); //Not used
    bool Match(yytokentype token);
    bool Match(int token, string content); //Not used

    void Consume_Token();

    /*Grammar functions in order*/
    bool Program();
    bool opt_funct_decl();
    bool funct_head();
    bool funct_name();
    bool funct_type();
    bool decl_type();
    bool param_list_opt();
    bool decl_param();
    bool body();
    bool stmt_list();
    bool stmts();
    bool stmt();
    bool if_stmt();
    bool while_stmt();
    bool return_stmt();
    bool expr_stmt();
    bool assign_stmt();
    bool function_stmt();
    bool bool_expr();
    bool constant();
};

#endif