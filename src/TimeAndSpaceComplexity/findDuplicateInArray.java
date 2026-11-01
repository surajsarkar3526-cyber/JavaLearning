package TimeAndSpaceComplexity;

import java.util.Scanner;

public class findDuplicateInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No. : ");
        int n = sc.nextInt();
        int[] arr  = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        boolean duplicate = false;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] == arr[j]){
                    duplicate = true;
                    break;
                }
            }
        }
        if(duplicate){
            System.out.println("Duplicate Found! ");
        }
        else{
            System.out.println("Their have unique Values ! ");
        }
    }
}
