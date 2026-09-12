package CyclicSort;

public class FirstMissingPositive {
    public static void main(String[] args) {

        int[] nums = {3, 4, -1, 1};

        int missing = firstMissingPositive(nums);

        System.out.println("First Missing Positive: " + missing);
    }

    private static int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] > 0 &&
                    nums[i] <= nums.length
            ){
                int currentIndex = nums[i] - 1;
                if(nums[i] != nums[currentIndex]){

                    int temp = nums[i];
                    nums[i] = nums[currentIndex];
                    nums[currentIndex] = temp;
                }
                else{
                    i++;
                }
            }
            else{
                i++;
            }
        }

        for(int j=0; j<nums.length; j++){
            if(nums[j] != j + 1){
                return j + 1;
            }
        }
        return nums.length + 1;
    }
}
