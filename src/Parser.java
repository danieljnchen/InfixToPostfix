import java.util.ArrayList;

public class Parser {
    public static StackElement parseStackElement(String s) {
        if(isNumber(s)) {
            return new StackDouble(s);
        } else if(s.length() == 1 && isOperation(s.charAt(0))) {
            return new Operation(s.charAt(0));
        } else {
            return null;
        }
    }

    public static ArrayList<StackElement> parseInfix(String s) {
        ArrayList<StackElement> out = new ArrayList<>();
        int lastIndex = 0;
        for(int i=0; i<s.length(); ++i) {
            if(isOperation(s.charAt(i))) {
                out.add(parseStackElement(s.substring(lastIndex,i)));
                lastIndex = i+1;
            }
        }
        out.add(parseStackElement(s.substring(lastIndex,s.length())));
        return out;
    }

    public static boolean isNumber(String s) {
        int numDots = 0;
        for(int i=0; i<s.length(); ++i) {
            char curr = s.charAt(i);
            if(curr == '.') {
                ++numDots;
            } else if(curr > '9' || curr < '0') {
                return false;
            }
            if(numDots > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }
}
