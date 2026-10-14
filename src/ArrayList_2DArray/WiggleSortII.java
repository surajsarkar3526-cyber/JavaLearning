package ArrayList_2DArray;

import java.util.Arrays;

public class WiggleSortII {
    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void wiggleSort(int[] nums) {
        int[] sorted = nums.clone();
        int n = nums.length;
        Arrays.sort(sorted);
        int mid = (n+1)/2;
        int left = mid - 1;
        int right = n - 1;
        for(int i=0; i<n; i++){
            if(i%2==0){
                nums[i] = sorted[left--];
            }
            else{
                nums[i] = sorted[right--];
            }
        }
    }
}
