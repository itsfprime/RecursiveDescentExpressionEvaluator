import binary.Node;
import binary.Parser;
import binary.Tokenizer;

import java.util.Scanner;

public class TestParser {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter input: ");
        String input = reader.nextLine();
        Tokenizer tokenizer = new Tokenizer(input);
        Parser parser = new Parser(tokenizer.getTokens());
        Node n = parser.parse();
        System.out.println(n);
    }
}
