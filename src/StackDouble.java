public class StackDouble extends StackElement {
    private double value;

    public StackDouble(String s) {
        value = Double.parseDouble(s);
    }

    public double getValue() {
        return value;
    }
}
