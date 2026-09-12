package ArrayList_2DArray;

import java.util.Scanner;

public class SumOfArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Row number : ");
        int n = sc.nextInt();

        System.out.print("Enter the column number : ");
        int m = sc.nextInt();
        System.out.print("Enter Elements of 2D Arays ");
        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int sum = 0;

        System.out.print("The Sum of 2D arrays is : ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sum += arr[i][j];
            }
        }
        System.out.print(sum);
    }
}
