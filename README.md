# Parser
Simple Parser using Flex as the Lexical Analyzer
The grammar that this parser can process is in file 'NewGrammar(1).g4'

In order to compile, you need to install flex
Tutorial: https://www.youtube.com/watch?v=ekS5l9Lrqo4

To compile:

$ flex lexer.l && g++ -g *.h *.cpp && ./a.out
