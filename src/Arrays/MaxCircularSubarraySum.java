package Arrays;

public class MaxCircularSubarraySum {
    static void main() {
        int[] arr = {8, -8, 9, -9, 10, -11, 12};

        System.out.println(maxCircularSum(arr));
    }

    private static int maxCircularSum(int[] arr) {
        int n =arr.length;
        int currentMax = arr[0];
        int maxSum = arr[0];
        int currentMin = arr[0];
        int minSum = arr[0];
        int totalSum = 0;
        for(int i=0; i<n; i++){
            totalSum += arr[i];
            if(i > 0){
                currentMax = Math.max(arr[i], currentMax + arr[i]);
                maxSum = Math.max(maxSum, currentMax);
            }
            if(i > 0){
                currentMin = Math.min(arr[i], currentMin + arr[i]);
                minSum = Math.min(minSum, currentMin);
            }
        }
        if(maxSum < 0){
            return maxSum;
        }

        int CircularSum = totalSum - minSum;
        return Math.max(maxSum, CircularSum);
    }
}
