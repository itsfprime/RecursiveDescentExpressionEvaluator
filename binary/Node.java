package binary;

public class Node {
    private Node left;
    private Node right;
    private final Op operation;

    public Node(Unop operation) {
        this.operation = operation;
    }

    public Node(Binop operation,Node left, Node right) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }
    public double eval() {
        if (operation instanceof Unop) {
              return ((Unop)operation).eval();
        } else if (operation instanceof Binop) {
              return ((Binop)operation).eval(left.eval(),right.eval());
        } else {
              System.err.println(ConsoleColors.RED_BOLD_BRIGHT + "Error: operation is not a Unary or Binary operator!" + ConsoleColors.RESET);
              return 0.0;
        }
    }

    @Override
    public String toString() {
        if (operation instanceof Unop) {
            // For constants or unary operations, just return their string form
            return operation.toString();
        } else if (operation instanceof Binop) {
            // Recursively call toString on children, surround with parentheses
            return "(" +
                    ConsoleColors.YELLOW_BRIGHT +
                    left.toString() +
                    ConsoleColors.RESET +
                    " " +
                    operation.toString() +
                    " " +
                    ConsoleColors.YELLOW_BRIGHT +
                    right.toString() +
                    ConsoleColors.RESET +
                    ")";
        } else {
            return "<?>";
        }
    }
}
