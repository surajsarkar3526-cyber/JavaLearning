package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class VisiblePeopleInQueue {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Size of heights : ");
        int n = sc.nextInt();

        int[] heights = new int[n];

        System.out.print("Enter Heights : ");
        for(int i=0; i<n; i++){
            heights[i] = sc.nextInt();

        }

        int[] result = canSeePersonsCount(heights);


        System.out.println("Visible People:");

        for(int x : result) {
            System.out.print(x + " ");
        }
    }

    private static int[] canSeePersonsCount(int[] heights) {

        int n = heights.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){

            int count = 0;
            while(!stack.isEmpty() && stack.peek() < heights[i]){
                stack.pop();
                count++;

            }
            if(stack.isEmpty()){
                count++;

            }

            answer[i] = count;
            stack.push(heights[i]);

        }

        return answer;
    }
}
