package ArrayList_2DArray;

import java.util.Scanner;

public class RowMaxFind {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the row number : ");
        int n = sc.nextInt();

        System.out.print("Enter the column number : ");
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        System.out.print("Enter the Arrays Elements : ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int maxRow = -1;
        int indexRow = 0;

        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=0; j<m; j++){
                sum += arr[i][j];
            }

            if(sum > maxRow){
                maxRow = sum;
                indexRow = i;
            }
        }

        System.out.println("Maximum Count No. in Row : " + maxRow);
        System.out.println("Index OF Row : " + indexRow);
    }
}