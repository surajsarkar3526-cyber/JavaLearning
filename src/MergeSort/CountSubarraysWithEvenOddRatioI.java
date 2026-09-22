package MergeSort;

public class CountSubarraysWithEvenOddRatioI {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2};
        int a = 3;
        int b = 2;
        long result = countSubarrays(nums, a, b);
        System.out.println("Number of valid subarrays: " + result);
    }

    private static long countSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int answer = 0;
        for(int i = 0; i<n; i++){
            int evenCount = 0;
            int oddCount = 0;
            for(int j=i; j<n; j++){
                if(nums[j]%2==0){
                    evenCount++;
                }
                else{
                    oddCount++;
                }
                if(oddCount > 0){
                    if(evenCount*b <= oddCount*a){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
