public class Operation extends StackElement {
    private int priority;

    public static final Operation ADD = new Operation(0);

    public static final Operation SUBTRACT = new Operation(0);

    public static final Operation MULTIPLY = new Operation(1);

    public static final Operation DIVIDE = new Operation(1);

    public static final Operation POWER = new Operation(2);


    public Operation(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public static Operation parseOperation(char operation) {
        if(operation == '+') {
            return ADD;
        } else if(operation == '-') {
            return SUBTRACT;
        } else if(operation == '*') {
            return MULTIPLY;
        } else if(operation == '/') {
            return DIVIDE;
        } else if(operation == '^') {
            return POWER;
        } else {
            return null;
        }
    }
}
