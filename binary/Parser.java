package binary;

import java.util.List;

public class Parser {
    private final List<Token> tokens;
    private int i = 0;

    public Parser(List<Token> tokens){
        this.tokens = tokens;
    }

    public Node parse(){
        return parseE();
    }

    private Node parseF() {
        Token current = tokens.get(i);
        if (current.type.equals(TokenType.NUMBER)) {
            i++; // consume the number
            return new Node(new Const(Double.parseDouble(current.value)));
        } else if (current.type.equals(TokenType.LPAREN)) {
            i++; // consume '('
            Node inner = parseE();
            i++; // consume ')'
            return inner;
        } else if (current.type.equals(TokenType.OPERATOR) && current.value.equals("-")) {     // Unary negative operator (e.g. -4, -25)
            i++; // consume the '-'
            Node operand = parseF();
            return new Node(new Minus(), new Node(new Const(0)), operand);                  // Represented as 0 - x
        }
        throw new RuntimeException("Unexpected token: " + current.value);
    }

    private Node parseE() {
        Node left = parseT();
        while (i < tokens.size() && tokens.get(i).type.equals(TokenType.OPERATOR)
                && (tokens.get(i).value.equals("+") || tokens.get(i).value.equals("-"))) {
            String op = tokens.get(i).value;
            i++;
            Node right = parseT();
            if (op.equals("+")) left = new Node(new Plus(), left, right);
            else left = new Node(new Minus(), left, right);
        }
        return left;
    }

    private Node parseT(){
        Node left = parseF();
        while(i < tokens.size() && tokens.get(i).type.equals(TokenType.OPERATOR)
                && (tokens.get(i).value.equals("*") || tokens.get(i).value.equals("/"))) {
            String op = tokens.get(i).value;
            i++;
            Node right = parseF();
            if(op.equals("*")) left = new Node(new Mult(), left, right);
            else left = new Node(new Divide(), left, right);
        }
        return left;
    }
}