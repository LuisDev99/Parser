#include "parser.h"

void parser::beginAnalyzer()
{
    if (Program())
        cout << " Parsing successful \n";
    else
    {
        cout << " Parsing gone wrong \n";
    }
}

bool parser::Match(string content)
{

    this->lookahead_token = this->lexer->yylex();
    this->lookahead_token_content = this->lexer->YYText();
    return true; //TODO: do correct checking
}

bool parser::Match(yytokentype token)
{
    if (token == this->lookahead_token)
    {
        this->lookahead_token = this->lexer->yylex();
        this->lookahead_token_content = this->lexer->YYText();
        return true;
    }

    return false;
}

bool parser::Match(int token, string content)
{

    this->lookahead_token = this->lexer->yylex();
    this->lookahead_token_content = this->lexer->YYText();
    return true; //TODO: do correct checking
}

void parser::Consume_Token()
{
    this->lookahead_token = this->lexer->yylex();
    this->lookahead_token_content = this->lexer->YYText();
}

bool parser::Program()
{
    return opt_funct_decl();
}

bool parser::opt_funct_decl()
{
    if (funct_head()) //If head went well, call body
    {
        return body();
    }
    else
    {
        return false;
    }
}

bool parser::funct_head()
{
    if (funct_name())
    {
        if (!Match(PAR_OP))
        {
            string BadToken = lexer->YYText();
            PrintErrorMessage("Expected open parenthesis '('  in function name, found: " + BadToken);
            return false;
        }

        if (!param_list_opt())
        {
            return false;
        }

        if (!Match(PAR_CL))
        {
            string BadToken = lexer->YYText();
            PrintErrorMessage("Expected closing parenthesis ')' in function name, found: " + BadToken);
            return false;
        }

        return true;
    }
    else
    {
        return false;
    }
}

bool parser::funct_name()
{
    if (funct_type())
    {
        if (!Match(ID))
        {
            //TODO
            string BadToken = lexer->YYText();
            PrintErrorMessage("Expected an identifier in function name, found: " + BadToken);
            return false;
        }

        return true;
    }
    else
    {
        return false;
    }
}

bool parser::funct_type()
{
    if (!Match(STATIC_TKN))
    {
        string BadToken = lexer->YYText();
        PrintErrorMessage("Expected keyword 'static' in function declaration type, found: " + BadToken);
        return false;
    }

    return decl_type();
}

bool parser::decl_type()
{
    if (lookahead_token == VOID_TYPE || lookahead_token == INT_TYPE ||
        lookahead_token == ANYTYPE_TYPE || lookahead_token == BOOLEAN_TYPE ||
        lookahead_token == REAL_TYPE || lookahead_token == DATE_TYPE ||
        lookahead_token == STRING_TYPE)
    {
        Consume_Token();
        return true;
    }
    else
    {
        return false;
    }
}

bool parser::param_list_opt()
{
    if (decl_param())
    {
        if (lookahead_token == EPSILON)
        {
            Consume_Token();
            return true;
        }

        if (param_list_opt())
        {
            if (!Match(COMA))
            {
                string BadToken = lexer->YYText();
                PrintErrorMessage("Expected a comma ',' between parameters, found: " + BadToken);
                return false;
            }

            return decl_param();
        }
        else
        {
            return false;
        }
    }
    else
    {
        return false;
    }
}

bool parser::decl_param()
{
    if (decl_type())
    {
        if (!Match(ID))
        {
            string BadToken = lexer->YYText();
            PrintErrorMessage("Expected an identifier in parameter, found: " + BadToken);
            return false;
        }

        return true;
    }
    else
    {
        return false;
    }
}

bool parser::body()
{
    return true; //TODO: change this, do correct grammar body
}

bool parser::stmt_list()
{
}

bool parser::stmts()
{
}

bool parser::stmt()
{
}

bool parser::if_stmt()
{
}

bool parser::while_stmt()
{
}

bool parser::return_stmt()
{
}

bool parser::expr_stmt()
{
}

bool parser::assign_stmt()
{
}

bool parser::function_stmt()
{
}

bool parser::bool_expr()
{
}

bool parser::bool_constant()
{
}

bool parser::constant()
{
}
