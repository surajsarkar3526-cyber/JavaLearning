package Arrays;

import java.util.Scanner;

public class MissingArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = {1,2,3,5};
        int n = arr.length + 1;
        int arraySum = 0;
        int sum = n*(n+1)/2;
        for(int ele : arr){
            arraySum += ele;
        }
        int missing = sum - arraySum;
        System.out.print(missing);
    }
}