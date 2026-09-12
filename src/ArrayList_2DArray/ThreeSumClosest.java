package ArrayList_2DArray;
import java.util.Arrays;
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 0;
        System.out.println(threesumclosest(nums,target));
    }

    private static int threesumclosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closest = nums[0] + nums[1] + nums[2];
        for(int i=0; i<n; i++){
            int left = i+1;
            int right = n-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum-target) < Math.abs(closest-target)){
                    closest = sum;
                }
                if(sum==target){
                    return sum;
                }
                else if(sum < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return closest;
    }
}
