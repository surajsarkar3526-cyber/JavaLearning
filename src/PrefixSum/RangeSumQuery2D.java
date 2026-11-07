
package PrefixSum;

public class RangeSumQuery2D {

    static class NumMatrix {
        int[][] prefix;
        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            prefix = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    prefix[i][j] = matrix[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int r1, int c1, int r2, int c2) {
            r1++;
            c1++;
            r2++;
            c2++;
            return prefix[r2][c2] + prefix[r1 - 1][c1 - 1] - prefix[r1 - 1][c2] - prefix[r2][c1 - 1];
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }
}
