package ArrayList_2DArray;

import java.util.Scanner;

public class SnakePattern {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Rows : ");
        int n = sc.nextInt();

        System.out.print("Enter columns : ");
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        System.out.println("Enter Matrix Numbers ");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int[] num : arr){
            for(int ele : num){
                System.out.print(ele+" ");
            }
            System.out.println();
        }

        for(int i=0; i<arr.length; i++){

            if(i%2 == 0){

                for(int j=0; j<arr[0].length; j++){
                    System.out.print(arr[i][j]+" ");
                }
            }

            else{

                for(int j = m-1; j >= 0; j--){
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}