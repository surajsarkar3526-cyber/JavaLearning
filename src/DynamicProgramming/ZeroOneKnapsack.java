package DynamicProgramming;

import java.util.Scanner;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Size of Weight : ");
        int wt = sc.nextInt();

        int[] weight = new int[wt];
        System.out.println("Input the Elements => ");
        for(int i=0; i<wt; i++){
            weight[i] = sc.nextInt();
        }

        System.out.print("Input Size of Value : ");
        int val = sc.nextInt();

        int[] value = new int[val];
        System.out.println("Input the Values Elements => ");
        for(int i=0; i<val; i++){
            value[i] = sc.nextInt();
        }
        System.out.print("Input the Capacity : ");
        int capacity = sc.nextInt();

        int n = weight.length;
        int answer = knapsack(weight, value, capacity, n);
        System.out.println("Maximum Value : " + answer);
    }

    private static int knapsack(int[] weight, int[] value, int capacity, int n) {
        if(n == 0 || capacity == 0){
            return 0;
        }

        if(weight[n-1] > capacity){
            return knapsack(weight, value, capacity, n-1);
        }

        int take = value[n-1] + knapsack(weight, value, capacity-weight[n-1],n-1);
        int nonTake = knapsack(weight, value, capacity, n-1);
        return Math.max(take, nonTake);
    }
}
