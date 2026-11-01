package TimeAndSpaceComplexity;

import java.util.Scanner;

public class findDuplicateInArray2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No. : ");
        int n = sc.nextInt();
        int[] arr  = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] duplicate = new int[n];
        for(int i=0; i<n; i++){
            int ele = arr[i];
            if(duplicate[ele] == arr[i]){
                System.out.println("Duplicate Found!");
            }
            else{
                duplicate[ele] = arr[i];
            }
        }
    }
}
