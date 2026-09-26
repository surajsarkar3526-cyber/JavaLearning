package Recursion;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        String expression = "2-1-1";
        List<Integer> answer = diffWaysToCompute(expression);
        System.out.println(answer);
    }

    private static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<expression.length(); i++){
            char operator = expression.charAt(i);
            if(operator == '+' || operator == '-' || operator == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                List<Integer> leftResult = diffWaysToCompute(left);
                List<Integer> rightResult = diffWaysToCompute(right);
                for (int a : leftResult) {
                    for (int b : rightResult) {
                        if (operator == '+') {
                            result.add(a + b);
                        } else if (operator == '-') {
                            result.add(a - b);
                        } else {
                            result.add(a * b);
                        }
                    }
                }
            }
        }
        if(result.isEmpty()){
            result.add(Integer.parseInt(expression));
        }

        return result;
    }
}
