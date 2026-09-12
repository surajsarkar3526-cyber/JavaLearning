package DynamicProgramming;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
public class LargestDivisibleSubsetTabulation {
    public static void main(String[] args) {
        int[] arr = {1, 16, 7, 8, 4};
        int n = arr.length;
        Arrays.sort(arr);
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int maxLength = 1;
        int lastIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (parent[lastIndex] != lastIndex) {
            result.add(arr[lastIndex]);
            lastIndex = parent[lastIndex];
        }
        result.add(arr[lastIndex]);
        Collections.reverse(result);
        System.out.println(result);
    }
}
