
# Recursive Descent Expression Evaluator

## Project Authors - Jeremy Welty, Cesar Valades

This project utilizes an Abstract Syntax Tree (AST) to store a mathematical expression, which is first tokenized then lexically analyzed to ensure correctness. 

## Technical Summary

To setup this project, we first create the files necessary for the AST data structure, including a Node class which stores an operation, two child nodes, and a recursive evaluation method. A binary operator (binop) abstract class and an operator (op) abstract class can be defined as well. Four operator classes representing the four binary operations we represent can be defined as plus, minus, mult, and divide, all which extend the binop abstract class. Finally, a constant class will be used to store constant values.

The Tokenizer is a critical component of this project, it is responsible for breaking the input into something that can be lexically analyzed. To do this, the Tokenizer breaks a string input into a series of Tokens, which will be defined in a Token class. A token has a TokenType type, and a String value, where a TokenType is an enum representing four choices, NUMBER, OPERATOR, LPAREN, RPAREN. These are the only acceptable tokens for this program. The Tokenizer itself will take a string input, then use manual index control to consume characters and convert into tokens. The 'number' characters must be read differently from parenthesis or operator characters, because a number could take up multiple spaces, which is why manual index control is necessary.

The parser is responsible for turning the generated list of Tokens into an AST. To do this, we create 3 methods which call each other recursively and share an index variable. ParseE is the first level of precedence, and is responsible for parsing + and - tokens, and it calls on parseT to find its left node. ParseT is responsible for finding * and / tokens, and it calls on parseF to find its left node. ParseF is the final level of precedence here, and grabs a token by simply using the index variable i to grab from the tokens list at that index. ParseF is responsible for consuming number tokens, left parenthesis tokens, and handling unary negative cases like -4. If a token is found out of place, the chain falls apart, and an runtime exception occurs, which means an unexpected token was parsed.

## Test Cases

![App Screenshot](https://i.ibb.co/k20388Kz/test1.png)
![App Screenshot](https://i.ibb.co/jP1VyRcy/test2.png)
![App Screenshot](https://i.ibb.co/bt6F55T/test3.png)
![App Screenshot](https://i.ibb.co/prng5TM8/test4.png)
![App Screenshot](https://i.ibb.co/1YCDkTtQ/test5.png)
