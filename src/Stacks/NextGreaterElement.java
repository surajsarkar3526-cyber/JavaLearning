package Stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.print("Enter array elements: ");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = findNextGreater(arr);

        System.out.println("Next Greater Elements: "
                + Arrays.toString(result));

        sc.close();
    }

    private static int[] findNextGreater(int[] arr) {

        int n = arr.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=n-1; i >= 0; i--){

            while(!stack.isEmpty()
                    && stack.peek() <= arr[i]) {

                stack.pop();
            }

            if(stack.isEmpty()){
                result[i] = -1;
            }
            else{
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        return result;
    }

}
