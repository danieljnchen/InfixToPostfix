import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            input = scanner.nextLine();
            ArrayList<StackElement> infix;
            infix = Parser.parseInfix(input);
            ArrayList<StackElement> postfix= new ArrayList<>();
            ArrayList<Operation> operationStack = new ArrayList<>();
            for(StackElement s : infix) {
                if(s instanceof Operation) {
                    Operation operation = (Operation) s;
                    if(operation.getPriority() >= operationStack.get(operationStack.size()-1).getPriority()) {
                        postfix.add(operation);
                    }
                }
            }
        } while(!input.equals("exit"));
    }

}
