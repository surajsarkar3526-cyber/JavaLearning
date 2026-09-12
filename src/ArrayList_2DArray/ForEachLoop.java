package ArrayList_2DArray;

import java.util.Scanner;

public class ForEachLoop {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Rows : ");
        int n = sc.nextInt();

        System.out.print("Enter Columns : ");
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int[] num : arr){
            for(int ele : num){
                System.out.print(ele+" ");
            }
        }
    }
}