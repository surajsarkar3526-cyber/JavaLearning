package Stacks;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args){

        String[] operations = {"5", "2", "C", "D", "+"};

        int answer = calculateScore(operations);
        System.out.println("Total Score: " + answer);
    }

    private static int calculateScore(String[] operations) {

        Stack<Integer> stack = new Stack<>();
        for (String operation : operations) {
            switch (operation) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    int lastScore = stack.pop();
                    int secondLastScore = stack.peek();

                    stack.push(lastScore);
                    stack.push(lastScore + secondLastScore);
                    break;
                default:
                    stack.push(Integer.parseInt(operation));
            }
        }

        int totalScore = 0;
        while (!stack.isEmpty()) {
            totalScore += stack.pop();
        }

        return totalScore;
    }
}
