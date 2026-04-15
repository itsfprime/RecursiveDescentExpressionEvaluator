import binary.*;

import java.util.Random;

public class TestArithmetic {
    private static final Random rand = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Node expr = randomExpressionExtension();
            System.out.println(expr.toString() + " = " + ConsoleColors.GREEN_BOLD_BRIGHT + expr.eval() + ConsoleColors.RESET);
        }
    }

    // Build an expression tree of length 4 (Three operators, four constants)
    /*
    private static Node randomExpression() {
        Node c1 = randConstant();
        Node c2 = randConstant();
        Node c3 = randConstant();
        Node c4 = randConstant();

        Node b1 = randOperator(c1, c2); // combine first two
        Node b2 = randOperator(c3, c4); // combine last two
        Node root = randOperator(b1, b2); // combine them together

        return root;
    }
     */

    // Build an expression tree of length 5(?) (Four operators, six constants)
    private static Node randomExpressionExtension() {
        Node c1 = randConstant();
        Node c2 = randConstant();
        Node c3 = randConstant();
        Node c4 = randConstant();
        Node c5 = randConstant();
        Node c6 = randConstant();

        Node b1 = randOperator(c1, c3);
        Node b2 = randOperator(b1, c2);
        Node b3 = randOperator(c4, c5);
        Node b4 = randOperator(b3, c6);
        Node root = randOperator(b2, b4);

        return root;
    }

    // Generate a random Const node
    private static Node randConstant() {
        int value = 1 + rand.nextInt(20); // [1, 20]
        return new Node(new Const(value));
    }

    // Generate a random Binop node with given children
    private static Node randOperator(Node left, Node right) {
        int op = rand.nextInt(4);
        switch (op) {
            case 0: return new Node(new Plus(), left, right);
            case 1: return new Node(new Minus(), left, right);
            case 2: return new Node(new Mult(), left, right);
            case 3: return new Node(new Divide(), left, right);
        }
        return null;
    }
}