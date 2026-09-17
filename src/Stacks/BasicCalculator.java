package Stacks;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s1 = "1 + 1";
        String s2 = " 2-1 + 2 ";
        String s3 = "(1+(4+5+2)-3)+(6+8)";
        String s4 = "-(2+3)";
        System.out.println(calculate(s1));
        System.out.println(calculate(s2));
        System.out.println(calculate(s3));
        System.out.println(calculate(s4));
    }

    private static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }
            else if (ch == '+') {
                result = result + sign * number;
                number = 0;
                sign = 1;
            }
            else if (ch == '-') {
                result = result + sign * number;
                number = 0;
                sign = -1;
            }
            else if (ch == '(') {
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            }
            else if (ch == ')') {
                result = result + sign * number;
                number = 0;
                int previousSign = stack.pop();
                int previousResult = stack.pop();
                result = previousResult + previousSign * result;
            }
        }
        result = result + sign * number;
        return result;
    }
}
