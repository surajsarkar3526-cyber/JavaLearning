package Graph;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        for (char[] row : board) {
            for (char value : row) {
                System.out.print(value+" ");
            }
        }
    }

    private static void solve(char[][] board) {
        for(int i = 0; i<board[0].length; i++){
            if(board[0][i] == 'O'){
                Dfs(board,0,i);
            }
            if(board[board.length-1][i] == 'O'){
                Dfs(board, board.length-1, i);
            }
        }
        for(int j=0; j< board.length; j++){
            if(board[j][0] == 'O'){
                Dfs(board, j,0);
            }
            if(board[j][board[0].length-1] == 'O'){
                Dfs(board, j, board[0].length-1);
            }
        }
        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[0].length; col++){
                if(board[row][col] == 'O'){
                    board[row][col] = 'X';
                }
                else if(board[row][col] == '#'){
                    board[row][col] = 'O';
                }
            }
        }
    }

    private static void Dfs(char[][] board, int row, int col) {
        if(row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || board[row][col] != 'O'){
            return;
        }
        board[row][col] = '#';
        Dfs(board,row-1, col);
        Dfs(board, row+1, col);
        Dfs(board, row, col-1);
        Dfs(board, row, col+1);
    }
}
