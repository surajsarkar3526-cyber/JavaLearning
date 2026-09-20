package DynamicProgramming;

public class LongestIncreasingPath {
    static int rows;
    static int cols;
    static int[][] directions = {
            {-1,0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        int result = longestIncreasingPath(matrix);
        System.out.println("Longest Increasing Path Length: " + result);
    }

    private static int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        int answer = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                answer = Math.max(answer, DfS(matrix,i,j,dp));
            }
        }
        return answer;
    }

    private static int DfS(int[][] matrix, int row, int col, int[][] dp) {
        if(dp[row][col] != 0){
            return dp[row][col];
        }
        int longest = 1;
        for(int[] direction : directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols){
                if(matrix[newRow][newCol] > matrix[row][col]){
                    int pathLength = 1 + DfS(matrix, newRow, newCol, dp);
                    longest = Math.max(longest, pathLength);
                }
            }
        }
        dp[row][col] = longest;
        return longest;
    }
}
