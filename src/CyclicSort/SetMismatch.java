package CyclicSort;

import java.util.Arrays;

public class SetMismatch {

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 4};

        int[] result = findErrorNums(nums);

        System.out.println("Duplicate and Missing: "
                + Arrays.toString(result));
    }

    private static int[] findErrorNums(int[] nums) {

        int i = 0;

        while (i < nums.length) {

            int correctIndex = nums[i] - 1;

            if (nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
            else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {

            if (nums[i] != i + 1) {

                int duplicate = nums[i];
                int missing = i + 1;

                return new int[]{duplicate, missing};
            }
        }

        return new int[]{-1, -1};
    }
}
