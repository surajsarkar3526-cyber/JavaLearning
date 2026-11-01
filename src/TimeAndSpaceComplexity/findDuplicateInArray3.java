package TimeAndSpaceComplexity;

import java.util.Scanner;

public class findDuplicateInArray3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No. : ");
        int n = sc.nextInt();
        int[] arr  = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        int SOS;
        for(int i=0; i<n; i++){
            sum += arr[i];
        }
        SOS = (n*(n-1))/2;
        System.out.println(Math.abs(sum - SOS));
    }
}
