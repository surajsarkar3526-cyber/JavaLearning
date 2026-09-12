package Arrays;

public class SmallestSubarraySum {
    public static void main(String[] args){
        int x = 51;
        int[] arr = {1, 4, 45, 6, 0, 19};
        int answer = smallestSubarray(arr, x);
        System.out.println(answer);
    }

    private static int smallestSubarray(int[] arr, int x) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            while(sum > x){
                minLength = Math.min(minLength, i-left+1);
                sum -= arr[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
