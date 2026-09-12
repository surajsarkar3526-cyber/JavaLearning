package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesesChecker {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);

        System.out.print("Enter Parentheses : ");
        String expression = sc.nextLine();

        if(isBalanced(expression)){
            System.out.print("Parentheses are Balanced Sequence ");

        }
        else{
            System.out.print("Parentheses are Un-balanced Sequence ");
        }

        sc.close();

    }

    private static boolean isBalanced(String expression) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<expression.length(); i++){

            char ch = expression.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            else if (ch == ')' || ch == ']' || ch == '}') {
                if(st.isEmpty()){
                    return false;
                }

                char openingBracket = st.pop();

                if ((ch == ')' && openingBracket != '(') ||
                        (ch == '}' && openingBracket != '{') ||
                        (ch == ']' && openingBracket != '[')) {

                    return false;
                }

            }
        }
        return st.isEmpty();
    }
}
