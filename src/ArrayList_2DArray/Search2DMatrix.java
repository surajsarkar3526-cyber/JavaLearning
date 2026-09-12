package ArrayList_2DArray;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Search2DMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.print("Enter the Target : ");
        int target = sc.nextInt();
        System.out.print(Matrix(matrix, target));
    }

    private static boolean Matrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int lo = 0;
        int hi = m*n - 1;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target){
                return true;

            }

            else if(matrix[row][col] < target){
                lo = mid + 1;
            }

            else{
                hi = mid - 1;
            }
        }
        return false;
    }
}