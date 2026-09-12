package Arrays;
import java.util.Arrays;
public class MaximumSubArray {
    public static void main(String[] args){
        int[] arr = {1, 2, 5, -7, 2, 6};
        int[] answer = findMaxSubarray(arr);
        System.out.println(Arrays.toString(answer));
    }
    private static int[] findMaxSubarray(int[] arr) {
        int n = arr.length;
        int start = 0;
        int bestStart = -1;
        int maxSum = -1;
        int bestEnd = -1;
        int currentSum = 0;
        for(int i=0; i<n; i++){
            if(arr[i] < 0){
                currentSum = 0;
                start = i + 1;
                continue;
            }
            currentSum += arr[i];
            int currentLength = i - start + 1;
            int bestLength = bestEnd - bestStart + 1;
            if(currentSum > maxSum ||
                    (currentSum == maxSum && currentLength > bestLength) ||
                    (currentSum == maxSum && currentLength == bestLength &&
                            start < bestStart)){
                maxSum = currentSum;
                bestStart = start;
                bestEnd = i;
            }
        }
        if(bestStart == -1){
            return new int[]{-1};
        }
        int[] answer = new int[bestEnd-bestStart+1];
        for(int i=bestStart; i<=bestEnd; i++){
            answer[i-bestStart] = arr[i];
        }
        return answer;
    }
}
