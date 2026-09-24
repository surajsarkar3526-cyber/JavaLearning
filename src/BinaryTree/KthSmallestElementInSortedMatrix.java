package BinaryTree;

public class KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }

    private static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while(left < right){
            int mid = left + (right - left)/2;
            int count = countLessOrEqual(matrix, mid);
            if(count < k){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    private static int countLessOrEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;
        for(int i = 0; i<n; i++){
            int left = 0;
            int right = n;
            while (left < right){
                int mid = left + (right - left)/2;
                if(matrix[i][mid] <= target){
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }
            count = count + left;
        }
        return count;
    }
}
