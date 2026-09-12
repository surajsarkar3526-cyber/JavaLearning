package BackTracking;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class NQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> result = nQueen(n);
        System.out.println("All Possible Solution : " + result);
    }

    private static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] board = new int[n];
        Arrays.fill(board, -1);
        solve(0, n, board, ans);

        return ans;
    }
    public static void solve(int row, int n, int[] board, ArrayList<ArrayList<Integer>> ans){
        if(row == n){
            ArrayList<Integer> solution = new ArrayList<>();
            for(int i = 0; i<n; i++){
                solution.add(board[i] + 1);
            }
            ans.add(solution);
        }
        for(int col=0; col<n; col++){
            if(iSafe(row, col, board)){
                board[row] = col;
                solve(row + 1, n, board, ans);
                board[row] = -1;
            }
        }
    }

    private static boolean iSafe(int row, int col, int[] board) {
        for(int preRow = 0; preRow < row; preRow++){
            int preCol = board[preRow];
            if(preCol == col){
                return false;
            }
            if(Math.abs(preCol- col) == Math.abs(preRow - row)){
                return false;
            }
        }
        return true;
    }
}
