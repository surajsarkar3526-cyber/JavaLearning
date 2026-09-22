package MergeSort;

public class CountSubarraysWithMajorityElementI {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        int target = 2;
        int result = countSubarrays(nums, target);
        System.out.println("Answer: " + result);
    }

    private static int countSubarrays(int[] nums, int target) {
        int n = nums.length;
        int answer = 0;
        for(int left = 0; left<n; left++){
            int targetCount = 0;
            for(int right=left; right<n; right++){
                if(nums[right] == target){
                    targetCount++;
                }
                int length = right - left+1;
                if(targetCount*2 > length){
                    answer++;
                }
            }
        }
        return answer;
    }
}
