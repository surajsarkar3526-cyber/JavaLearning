package HashMap;

import java.util.HashMap;

public class CountPairsDivisibleByK {

    public static int countPairs(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int num : arr) {
            int remainder = num % k;
            if (remainder < 0) {
                remainder += k;
            }
            int need = (k - remainder) % k;

            if (map.containsKey(need)) {
                count += map.get(need);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {2, 2, 1, 7, 5, 3};
        int k = 4;

        System.out.println(countPairs(arr, k));
    }
}
