package BitManipulation;

import java.util.Arrays;

public class SingleNumberIII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};

        int[] result = singleNumber(nums);

        System.out.println(Arrays.toString(result));
    }

    private static int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        int rightmostSetBit = xor & -xor;
        int first = 0;
        int second = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) {
                first = first ^ num;
            }
            else {
                second = second ^ num;
            }
        }

        return new int[]{first, second};
    }
}
