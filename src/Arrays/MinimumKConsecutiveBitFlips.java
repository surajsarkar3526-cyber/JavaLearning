package Arrays;

public class MinimumKConsecutiveBitFlips {
    static void main() {
        int[] arr = {1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1};
        int k = 2;
        int answer = minKBitFlips(arr, k);
        System.out.println("Minimum flips = " + answer);
    }

    private static int minKBitFlips(int[] arr, int k) {
        int n = arr.length;
        int flips = 0;
        int flipCount = 0;
        int[] dp = new int[n + 1];
        for(int i=0; i<n; i++){
            flipCount += dp[i];
            int currentBit = arr[i];
            if(flipCount % 2 == 1){
                currentBit = 1 - currentBit;
            }
            if(currentBit == 0){
                if((i + k) > n){
                    return -1;
                }
                flips++;
                flipCount++;
                dp[i + k]--;
            }
        }
        return flips;
    }
}
