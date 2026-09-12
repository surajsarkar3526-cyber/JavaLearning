package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[][] M = {
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}
        };

        int ans = celebrity(M, M.length);
        if(ans == -1){
            System.out.println("No Celebrity Found");
        }
        else{
            System.out.println("Celebrity is Person " + ans);

        }
        sc.close();
    }

    private static int celebrity(int[][] M, int n) {

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            stack.push(i);

        }
        while(stack.size() > 1){

            int a = stack.pop();
            int b = stack.pop();

            if(M[a][b] == 1){
                stack.push(b);

            }
            else{
                stack.push(a);

            }
        }

        int candidate = stack.pop();
        for(int i=0; i<n; i++){
            if(M[i][candidate] == 1){
                return -1;
            }
        }

        for(int j=0; j<n; j++){
            if(j != candidate && M[j][candidate] == 1){
                return -1;
            }
        }

        return candidate;
    }
}
