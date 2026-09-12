package DynamicProgramming;

public class CountSquareSubmatrices {
    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        int result = countSquares(matrix);

        System.out.println("Total Squares: " + result);
    }

    private static int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;

        int[][] dp = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++) {

                if (matrix[i][j] == 1) {

                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = 1 + Math.min(
                                dp[i - 1][j],
                                Math.min(
                                        dp[i][j - 1],
                                        dp[i - 1][j - 1]
                                )
                        );
                    }

                    count += dp[i][j];
                }
            }
        }

        return count;
    }
}
