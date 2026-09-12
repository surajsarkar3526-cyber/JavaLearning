package ArrayList_2DArray;

import java.util.Scanner;

public class SearchRowColumnMatrix {
    private static boolean Matrix(int[][] matrix, int target){

        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0;
        int j = cols - 1;

        while(i < rows && j >= 0){

            int current = matrix[i][j];

            if(current == target){
                System.out.print("" +
                        "The Target Index is ["+ (i+1) + "]["+(j+1)+"]");

                return true;
            }

            else if(current > target){
                j--;
            }

            else{
                i++;
            }
        }

        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.print("Enter the target : ");
        int target = sc.nextInt();

        boolean result = Matrix(matrix, target);

        System.out.print("\nThe Result is : "+result);
    }
}