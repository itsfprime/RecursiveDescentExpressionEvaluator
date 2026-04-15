package binary;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private final String input;
    private final List<Token> tokens;

    public Tokenizer(String input){
        this.input = input;
        tokens = tokenize(this.input);
    }

    private List<Token> tokenize(String input){
        ArrayList<Token> tokens = new ArrayList<>();
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                StringBuilder num = new StringBuilder();
                while (i < input.length() && (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.')) {
                    num.append(input.charAt(i));
                    i++;
                }
                tokens.add(new Token(TokenType.NUMBER, num.toString()));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                tokens.add(new Token(TokenType.OPERATOR, String.valueOf(c)));
                i++;
            } else if (c == '(') {
                tokens.add(new Token(TokenType.LPAREN, "("));
                i++;
            } else if (c == ')') {
                tokens.add(new Token(TokenType.RPAREN, ")"));
                i++;
            } else if (Character.isWhitespace(c)) {
                i++; // skip
            } else {
                throw new RuntimeException("Unexpected character: " + c);
            }
        }
        return tokens;
    }

    public List<Token> getTokens(){
        return tokens;
    }
}
