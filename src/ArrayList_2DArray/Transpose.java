package ArrayList_2DArray;

import java.util.Scanner;

public class Transpose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Rows : ");
        int n = sc.nextInt();

        System.out.print("Enter columns : ");
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        System.out.println("Enter Matrix Numbers ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i =0; i<arr.length; i++){
            for(int j = i+1; j<arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        ArrayPrint(arr);
    }

    private static void ArrayPrint(int[][] arr) {
        for(int[] a : arr){
            for(int ele : a){
                System.out.print(ele + " ");
            }
            System.out.print("\n");
        }
    }
}