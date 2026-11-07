package PrefixSum;

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1},
                {0, -2, 3}
        };
        int k = 2;
        System.out.println(maxSumSubmatrix(matrix, k));
    }

    private static int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {
                for (int row = 0; row < n; row++) {
                    sum[row] += matrix[row][j];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int prefixSum = 0;
                for (int num : sum) {
                    prefixSum += num;
                    Integer previous = set.ceiling(prefixSum - k);

                    if (previous != null) {
                        answer = Math.max( answer,  prefixSum - previous);
                    }
                    set.add(prefixSum);
                    if (answer == k) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}
