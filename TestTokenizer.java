import binary.Tokenizer;

import java.util.Scanner;

public class TestTokenizer {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter String: ");
        String input = reader.nextLine();
        Tokenizer tokenizer = new Tokenizer(input);
        System.out.println(tokenizer.getTokens());
    }
}
