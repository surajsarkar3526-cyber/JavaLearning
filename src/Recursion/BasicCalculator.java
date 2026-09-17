package Recursion;

public class BasicCalculator {
    static int index = 0;
    public static int calculate(String s) {
        index = 0;
        return solve(s);
    }
    private static int solve(String s) {
        int result = 0;
        int number = 0;
        int sign = 1;
        while (index < s.length()) {
            char ch = s.charAt(index);
            if (ch == ' ') {
                index++;
            }
            else if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
                index++;
            }
            else if (ch == '+') {
                result = result + sign * number;
                number = 0;
                sign = 1;
                index++;
            }
            else if (ch == '-') {
                result = result + sign * number;
                number = 0;
                sign = -1;
                index++;
            }
            else if (ch == '(') {
                index++;
                number = solve(s);
            }
            else if (ch == ')') {
                result = result + sign * number;
                return result;
            }
        }
        result = result + sign * number;
        return result;
    }
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }
}
