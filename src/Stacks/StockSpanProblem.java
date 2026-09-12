package Stacks;

import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

public class StockSpanProblem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.print("Enter Arrays Elements : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();

        }

        int[] result = calculateSpan(arr);

        System.out.println("Stock Span: " + Arrays.toString(result));

        sc.close();
    }

    private static int[] calculateSpan(int[] arr) {

        int n = arr.length;
        int[] span = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){

            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();

            }

            if(stack.isEmpty()){
                span[i] = i + 1;

            }
            else{
                span[i] = i - stack.peek();

            }

            stack.push(i);
        }

        return span;
    }
}
