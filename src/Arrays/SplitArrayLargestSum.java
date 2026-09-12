package Arrays;

public class SplitArrayLargestSum {
    static void main() {
        int[] arr = {1, 2, 3, 4};
        int k = 3;
        int answer = splitArray(arr, k);
        System.out.println("Minimum possible maximum sum = " + answer);
    }

    private static int splitArray(int[] arr, int k) {
        int low = 0;
        int high = 0;
        for(int num : arr){
            low = Math.max(low, num);
            high += num;
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canSplit(arr, k, mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    private static boolean canSplit(int[] arr, int k, int mid) {
        int subArray = 1;
        int currentSum = 0;
        for(int num : arr){
            if(currentSum + num >= mid){
                currentSum += num;
            }
            else{
                subArray++;
                currentSum = num;
            }
        }
        return subArray <= k;
    }
}
