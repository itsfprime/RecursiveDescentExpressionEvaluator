package binary;

public class Const extends Unop {
    /** the constant value */
    private final double value;
    /**
     * @param d the value to set the constant to.
     */
    public Const(double d) {
        value = d;
    }
    /**
     * @return the value of the constant.
     */
    public double eval() {
        return value;
    }

    public String toString(){
        return String.valueOf(value);
    }
}
