package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStackRecursively {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.print("Enter Stack Size : ");
        int n = sc.nextInt();

        System.out.print("Enter Stack Elements : ");
        for(int i=0; i<n; i++){
            int Element = sc.nextInt();
            stack.push(Element);

        }

        System.out.println("Original Stack: " + stack);

        reverseStack(stack);

        System.out.println("Reversed Stack: " + stack);

        sc.close();

    }

    private static void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;

        }
        int topElement = stack.pop();

        reverseStack(stack);

        insertStack(stack, topElement);
    }

    private static void insertStack(Stack<Integer> stack, int Element) {
        if(stack.isEmpty()){
            stack.push(Element);
            return;

        }

        int topElement = stack.pop();

        insertStack(stack, Element);

        stack.push(topElement);
        return;
    }
}
