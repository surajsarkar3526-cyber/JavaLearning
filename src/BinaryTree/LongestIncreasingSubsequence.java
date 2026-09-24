package BinaryTree;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int answer = lengthOfLIS(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + answer);
    }

    private static int lengthOfLIS(int[] nums) {
        int size = 0;
        int[] tail = new int[nums.length];
        for(int num : nums){
            int left = 0;
            int right = size;
            while(left < right){
                int mid = left + (right - left)/2;
                if(tail[mid] < num){
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }
            tail[left] = num;
            if(left == size){
                size++;
            }
        }
        return size;
    }
}
