package Recursion;

import java.util.Scanner;

public class SticklerThief {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(maxLoot(arr));
    }

    private static int maxLoot(int[] arr) {

        int n = arr.length;
        if(n == 1){
            return arr[0];
        }

        int prev2 = arr[0];
        int prev1 = Math.max(arr[0], arr[1]);

        for(int i=2; i<n; i++){
            int current = Math.max(prev1, arr[0] + prev2);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
