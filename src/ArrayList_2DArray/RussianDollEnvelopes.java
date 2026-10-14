package ArrayList_2DArray;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };
        System.out.println(maxEnvelopes(envelopes));
    }

    private static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int n = envelopes.length;
        int[] lis = new int[n];
        int size = 0;
        for (int[] envelope : envelopes) {
            int height = envelope[1];
            int left = 0;
            int right = size;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (lis[mid] < height) {
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }
            lis[left] = height;
            if (left == size) {
                size++;
            }
        }
        return size;
    }
}
