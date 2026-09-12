package CyclicSort;
import java.util.Arrays;
public class MissingInArray {
    public static void main(String[] args) {

        int[] nums = {3, 0, 1};

        System.out.println("Original Array: " + Arrays.toString(nums));

        int missing = findMissing(nums);

        System.out.println("Missing Number: " + missing);
    }

    private static int findMissing(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int currentIndex = nums[i];
            if(nums[i] < nums.length && nums[i] != nums[currentIndex]){
                int temp = nums[i];
                nums[i] = nums[currentIndex];
                nums[currentIndex] = temp;
            }
            else{
                i++;
            }
        }

        for(int j=0; j<nums.length; j++){
            if(nums[j] != j){
                return j;
            }
        }

        return nums.length;
    }
}
