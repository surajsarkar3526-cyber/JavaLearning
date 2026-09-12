package BackTracking;

import java.util.Scanner;
public class KnightTour {
    static int n = 5;
    static int[] rowMove = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] colMove = {1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = -1;
            }
        }
        board[0][0] = 0;
        if(knightTour(board ,0, 0, 1)){
            System.out.println("Knight's Tour Found:");
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.printf("%2d", board[i][j]);
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Knight's Tour Not Found:");
        }
        sc.close();
    }

    private static boolean knightTour(int[][] board, int row, int col, int move) {
        if(move == n*n){
            return true;
        }
        for(int i=0; i<8; i++){
            int newRow = row + rowMove[i];
            int newCol = col + colMove[i];
            if(newRow >= 0 &&
                    newRow < n &&
                    newCol >= 0 &&
                    newCol < n &&
                    board[newRow][newCol] == -1){
                board[newRow][newCol] = move;

                if(knightTour(board, newRow, newCol, move+1)){
                    return true;
                }
                board[newRow][newCol] = -1;
            }
        }
        return false;
    }
}
