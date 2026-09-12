package BinarySearchOnAnswer;

import java.util.Arrays;

public class AggressiveCows {

    static boolean canPlaceCows(int[] stalls, int cows, int minDistance) {

        int count = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - lastPosition >= minDistance) {
                count++;
                lastPosition = stalls[i];

                if (count == cows) {
                    return true;
                }
            }
        }

        return false;
    }

    static int aggressiveCows(int[] stalls, int cows) {

        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, cows, mid)) {
                ans = mid;
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] stalls = {1, 2, 4, 8, 9};
        int cows = 3;

        int result = aggressiveCows(stalls, cows);

        System.out.println("Maximum Minimum Distance = " + result);
    }
}
