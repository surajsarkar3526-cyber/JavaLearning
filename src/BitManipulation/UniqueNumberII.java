package BitManipulation;

import java.util.Arrays;

public class UniqueNumberII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 4};

        int[] result = singleNumber(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] singleNumber(int[] arr) {
        int xor = 0;
        for (int num : arr) {
            xor = xor ^ num;
        }
        int rightmostSetBit = xor & -xor;
        int first = 0;
        int second = 0;
        for (int num : arr) {
            if ((num & rightmostSetBit) != 0) {
                first = first ^ num;
            }
            else {
                second = second ^ num;
            }
        }
        if (first > second) {
            int temp = first;
            first = second;
            second = temp;
        }

        return new int[]{first, second};
    }
}
