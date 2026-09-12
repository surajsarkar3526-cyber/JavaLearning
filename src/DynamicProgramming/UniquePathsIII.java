package DynamicProgramming;

import java.util.Arrays;

public class UniquePathsIII {
    public static void main(String[] args) {

        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };

        System.out.println(uniquePathsIII(grid));
    }

    private static int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int start = 0;
        int end = 0;
        int totalCells = 0;
        int[][] index = new int[m][n];
        for (int[] row : index) {
            Arrays.fill(row, -1);
        }

        int id = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != -1) {
                    index[i][j] = id++;
                    if (grid[i][j] == 1) {
                        start = index[i][j];
                    }
                    if (grid[i][j] == 2) {
                        end = index[i][j];
                    }
                    totalCells++;
                }
            }
        }

        int maxMask = 1 << totalCells;
        int[][][] dp = new int[m][n][maxMask];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int mask = 1 << start;

        return solve(grid, index, dp, 0, 0, mask, end, totalCells);
    }

    private static int solve(int[][] grid, int[][] index, int[][][] dp, int row, int col, int mask, int end, int totalCells) {
        if (row < 0 || row >= grid.length ||
                col < 0 || col >= grid[0].length) {
            return 0;
        }
        if (grid[row][col] == -1) {
            return 0;
        }

        int current = index[row][col];
        if ((mask & (1 << current)) != 0 &&
                grid[row][col] != 1) {
            return 0;
        }
        if (current == end) {
            if (mask == (1 << totalCells) - 1) {
                return 1;
            }

            return 0;
        }

        if (dp[row][col][mask] != -1) {
            return dp[row][col][mask];
        }
        int newMask = mask | (1 << current);
        int paths1 = solve(grid, index, dp, row - 1, col, newMask, end, totalCells);
        int paths2 = solve(grid, index, dp, row + 1, col, newMask, end, totalCells);
        int paths3 = solve(grid, index, dp, row, col - 1, newMask, end, totalCells);
        int paths4 = solve(grid, index, dp, row, col + 1, newMask, end, totalCells);

        return dp[row][col][mask] = paths1 + paths2 + paths3 + paths4;
    }
}
