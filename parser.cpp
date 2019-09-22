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

    if (decl_type())
    {
        return true;
    }
    else
    {
        string BadToken = lexer->YYText();
        PrintErrorMessage("Expected declaration type after static keyword in function declaration, found: " + BadToken);
        return false;
    }
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

    if (lookahead_token == PAR_CL) //Epsilon
    {
        //Consume_Token();
        return true;
    }

    if (decl_param())
    {
        if (lookahead_token == PAR_CL) //Epsilon
        {
            //Consume_Token();
            return true;
        }

        if (!Match(COMA))
        {
            string BadToken = lexer->YYText();
            PrintErrorMessage("Expected a comma ',' between parameters, found: " + BadToken);
            return false;
        }

        if (lookahead_token != PAR_CL)
        {
            return param_list_opt();
        }
        else
        {
            string BadToken = lexer->YYText();
            PrintErrorMessage("Found a comma ',' followed by a parenthesis ')', invalid!");
            return false;
        }
    }
    else
    {
        return false;
    }

    // OLD
    // It works but with two params only
    // if (decl_param())
    // {
    //     if (lookahead_token == EPSILON)
    //     {
    //         Consume_Token();
    //         return true;
    //     }

    //     if (lookahead_token == PAR_CL)
    //     {
    //         Consume_Token();
    //         return true;
    //     }

    //     if (!Match(COMA))
    //     {
    //         string BadToken = lexer->YYText();
    //         PrintErrorMessage("Expected a comma ',' between parameters, found: " + BadToken);
    //         return false;
    //     }

    //     return decl_param();
    // }
    // else
    // {
    //     if (lookahead_token == PAR_CL)
    //     {
    //         Consume_Token();
    //         return true;
    //     }
    //     else
    //     {
    //         return param_list_opt();
    //     }

    //     return false;
    // }
}

bool parser::decl_param()
{
    if (decl_type())
    {
        if (!Match(ID))
        {
            string BadToken = lexer->YYText();
            PrintErrorMessage("Expected an identifier after variable type in function parameter, found: " + BadToken);
            return false;
        }

        return true;
    }
    else
    {
        string BadToken = lexer->YYText();
        PrintErrorMessage("Expected declaration type in function parameter list, found: " + BadToken);
        return false;
    }
}

bool parser::body()
{
    if (!Match(BRACK_OP))
    {
        string BadToken = lexer->YYText();
        PrintErrorMessage("Expected open bracket '{' in body, found: " + BadToken);
        return false;
    }

    if (stmt_list())
    {
        if (!Match(BRACK_CL))
        {
            string BadToken = lexer->YYText();
            PrintErrorMessage("Expected closing bracket '}' in body, found: " + BadToken);
            return false;
        }

        return true;
    }
    else
    {
        return false;
    }
}

bool parser::stmt_list()
{
    return stmts();
}

bool parser::stmts()
{
    if (lookahead_token == BRACK_CL) //Epsilon
    {
        return true;
    }

    return stmt();
}

bool parser::stmt()
{
    //While
    if (lookahead_token == WHILE)
    {
        return while_stmt();
    }

    // //If
    if (lookahead_token == IF)
    {
        return if_stmt();
    }

    if (lookahead_token == RETURN)
    {
        return return_stmt();
    }

    // expr
    if (expr_stmt())
    {
        if (lookahead_token != BRACK_CL) //If we havent reached the end of the body (in other words, if the next token isnt an '}'), then continue calling statement because there's literally more statements to parse
            return stmt();

        return true;
    }
    else
    {
        return false;
    }
}

bool parser::if_stmt()
{
    if (!Match(IF))
    {
        string BadToken = lexer->YYText();
        PrintErrorMessage("Expected a statement, found: " + BadToken);
        return false;
    }

    if (!Match(PAR_OP))
    {
        string BadToken = lexer->YYText();
        PrintErrorMessage("Expected open parenthesis '(' after if, found: " + BadToken);
        return false;
    }

    if (bool_expr())
    {
        if (!Match(PAR_CL))
        {
            string BadToken = lexer->YYText();
            PrintErrorMessage("Expected closing parenthesis ')' in if, found: " + BadToken);
            return false;
        }

        return body();
    }
    else
    {
        return false;
    }
}

bool parser::while_stmt()
{
    if (!Match(WHILE))
    {
        string BadToken = lexer->YYText();
        PrintErrorMessage("Expected a statement, found: " + BadToken);
        return false;
    }

    if (!Match(PAR_OP))
    {
        string BadToken = lexer->YYText();
        PrintErrorMessage("Expected open parenthesis '(' after while, found: " + BadToken);
        return false;
    }

    if (bool_expr())
    {
        if (!Match(PAR_CL))
        {
            string BadToken = lexer->YYText();
            PrintErrorMessage("Expected closing parenthesis ')' in while, found: " + BadToken);
            return false;
        }

        return body();
    }
    else
    {
        return false;
    }
}

bool parser::return_stmt()
{
    if (!Match(RETURN))
    {
        string BadToken = lexer->YYText();
        PrintErrorMessage("Expected a statement, found: " + BadToken);
        return false;
    }

    if (lookahead_token == SEMICOLON)
    {
        Consume_Token();
        return true;
    }
    else
    {
        if (constant())
        {
            if (!Match(SEMICOLON))
            {
                string BadToken = lexer->YYText();
                PrintErrorMessage("Expected a semicolon ';' after return, found: " + BadToken);
                return false;
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}

bool parser::expr_stmt()
{
    // //function_stmt assignment
    // return function_stmt();

    // assigment
    if (assign_stmt())
    {
        if (!Match(SEMICOLON))
        {
            string BadToken = lexer->YYText();
            PrintErrorMessage("Expected a semicolon ';' after the assign, found: " + BadToken);
            return false;
        }

        return true;
    }
    else
    {
        return false;
    }
}

bool parser::assign_stmt()
{
    if (decl_type())
    {
        if (!Match(ID))
        {
            string BadToken = lexer->YYText();
            PrintErrorMessage("Expected an identifier name after variable type, found: " + BadToken);
            return false;
        }

        if (!Match(ASSIGN))
        {
            string BadToken = lexer->YYText();
            PrintErrorMessage("Expected assignment operator ':=' after identifier, found: " + BadToken);
            return false;
        }

        return constant();
    }
    else
    {
        string BadToken = lexer->YYText();
        PrintErrorMessage("Expected declaration type in assignment operation, found: " + BadToken);
        return false;
    }
}

bool parser::function_stmt()
{
    if (decl_type())
    {
        if (!Match(ID))
        {
            string BadToken = lexer->YYText();
            PrintErrorMessage("Expected an identifier name after function type, found: " + BadToken);
            return false;
        }

        if (!Match(PAR_OP))
        {
            string BadToken = lexer->YYText();
            PrintErrorMessage("Expected an open parenthesis '(' after function identifier, found: " + BadToken);
            return false;
        }

        if (param_list_opt())
        {
            if (!Match(PAR_CL))
            {
                string BadToken = lexer->YYText();
                PrintErrorMessage("Expected a closing parenthesis ')' after function params, found: " + BadToken);
                return false;
            }

            if (!Match(SEMICOLON))
            {
                string BadToken = lexer->YYText();
                PrintErrorMessage("Expected a semicolon ';' after the end of function, found: " + BadToken);
                return false;
            }

            return true;
        }
    }
    else
    {
        string BadToken = lexer->YYText();
        PrintErrorMessage("Expected function declaration type in function assignment, found: " + BadToken);
        return false;
    }
}

bool parser::bool_expr()
{
    if (lookahead_token == True_Literal || lookahead_token == False_Literal)
    {
        Consume_Token();
        return true;
    }

    if (constant())
    {
        if (!Match(LOG_OP))
        {
            string BadToken = lexer->YYText();
            PrintErrorMessage("Expected logical comparators ('&&' or '||') inside bool expr, found: " + BadToken);
            return false;
        }

        return constant();
    }
    else
    {
        return false;
    }
}

bool parser::constant()
{
    if (lookahead_token == INT_LITERAL || lookahead_token == REAL_LITERAL ||
        lookahead_token == DATE_LITERAL || lookahead_token == STRING_LITERAL)
    {
        Consume_Token();
        return true;
    }
    else
    {
        return false;
    }
}
