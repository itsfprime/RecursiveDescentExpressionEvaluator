import binary.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter input: ");
        String input = reader.nextLine();
        reader.close();

        tokenizeInput(input);
    }

    private static void tokenizeInput(String input){
        Tokenizer tokenizer = new Tokenizer(input);
        List<Token> tokens = tokenizer.getTokens();
        System.out.println("Tokens: " + tokens);

        Parser parser = new Parser(tokens);

        try {
            Node n = parser.parse();
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Parse successful" + ConsoleColors.RESET);
            System.out.println(n);
            System.out.println(ConsoleColors.WHITE_BOLD + "Result:" + ConsoleColors.GREEN_BOLD_BRIGHT + " " + n.eval() + ConsoleColors.RESET);
        } catch (RuntimeException e){
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Parse failed: " + e.getMessage() + ConsoleColors.RESET);
        }
    }
}
