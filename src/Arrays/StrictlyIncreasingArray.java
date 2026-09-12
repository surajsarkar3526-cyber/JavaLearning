package Arrays;

public class StrictlyIncreasingArray {
    static void main() {
        int[] nums = {1, 2, 3, 6, 5, 4};
        System.out.println(minOperations(nums));
    }

    private static int minOperations(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int size = 0;
        for(int i=0; i<n; i++){
            int value = nums[i] - i;
            int low=0;
            int high = size;
            while(low < high){
                int mid = low + (high - low)/2;
                if(temp[mid] <= value){
                    low = mid + 1;
                }
                else{
                    high = mid;
                }
            }
            temp[low] = value;
            if(low == size){
                size++;
            }
        }
        return n - size;
    }
}
