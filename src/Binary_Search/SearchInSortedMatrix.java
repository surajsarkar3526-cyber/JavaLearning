package Binary_Search;

import java.util.Scanner;

public class SearchInSortedMatrix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Arrays Rows Number : ");
        int row = sc.nextInt();

        System.out.print("Enter Arrays Column Number : ");
        int col = sc.nextInt();

        int[][] arr = new int[row][col];
        System.out.print("Enter 2D Arrays Element : ");
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter The Target : ");
        int target = sc.nextInt();

        int[] ans = Search(arr,target);

        if(ans[0] != -1){
            System.out.print("\nTarget Found at"+" "+ "Row : " + ans[0] + "Column : " + ans[1]);
        }
        else{
            System.out.print("\nTarget Not Found ");
        }
    }

    private static int[] Search(int[][] arr, int target) {

        int row = 0;
        int col = arr[0].length-1;

        while(row < arr.length && col >=0){

            if(arr[row][col] == target){
                return new int[]{row,col};
            }
            else if(arr[row][col] > target){
                col--;
            }

            else{
                row++;
            }
        }
        return new int[]{-1,-1};
    }
}