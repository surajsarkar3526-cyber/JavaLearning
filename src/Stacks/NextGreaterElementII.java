package Stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size : ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.print("Enter Arrays Elements : ");
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        int[] result = nextGreaterElements(nums);
        System.out.println("NextGreates Element Is : "+Arrays.toString(result));

        sc.close();
    }

    private static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i=2*n-1; i>=0; i--){

            int index = i % n;
            int currentElement = nums[index];

            while (!stack.isEmpty()
                    && stack.peek() <= currentElement) {

                stack.pop();
            }

            if(i < n && !stack.isEmpty()){
                result[index] = stack.peek();

            }

            stack.push(currentElement);
        }

        return result;
    }
}
