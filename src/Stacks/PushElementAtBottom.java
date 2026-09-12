package Stacks;
import java.util.Scanner;
import java.util.Stack;

public class PushElementAtBottom {
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

        System.out.print("Enter Element to Push at Bottom: ");
        int val = sc.nextInt();
        pushAtBottom(stack, val);

        System.out.println("After Pushing at Bottom: " + stack);

        sc.close();

    }

    private static void pushAtBottom(Stack<Integer> stack, int val) {

        if(stack.isEmpty()){
            stack.push(val);
            return;

        }

        int topElement = stack.pop();

        pushAtBottom(stack, val);

        stack.push(topElement);
    }
}
