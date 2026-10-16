package Graph;

public class MinesweeperMinesweeper {
    public static void main(String[] args) {
        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        int[] click = {3, 0};
        char[][] result = updateBoard(board, click);
        for (char[] row : result) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    private static char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        dfs(board, row, col);
        return board;
    }
    private static void dfs(char[][] board, int row, int col) {
        int m = board.length;
        int n = board[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n
                || board[row][col] != 'E') {
            return;
        }
        int mines = 0;
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int nr = row + dr;
                int nc = col + dc;
                if (nr >= 0 && nr < m && nc >= 0 && nc < n
                        && board[nr][nc] == 'M') {
                    mines++;
                }
            }
        }
        if (mines > 0) {
            board[row][col] = (char) ('0' + mines);
            return;
        }
        board[row][col] = 'B';
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr == 0 && dc == 0) {
                    continue;
                }
                dfs(board, row + dr, col + dc);
            }
        }
    }
}
