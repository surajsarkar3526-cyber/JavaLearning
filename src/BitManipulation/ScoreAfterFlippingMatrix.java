package BitManipulation;

public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {

        int[][] grid = {
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        };

        System.out.println(matrixScore(grid));
    }

    private static int matrixScore(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        for (int j = 1; j < cols; j++) {
            int ones = 0;
            for (int[] row : grid) {
                ones += row[j];
            }
            int zeros = rows - ones;
            if (zeros > ones) {
                for (int i = 0; i < rows; i++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        int score = 0;
        for (int[] row : grid) {
            int value = 0;
            for (int bit : row) {
                value = value * 2 + bit;
            }
            score += value;
        }
        return score;
    }
}
