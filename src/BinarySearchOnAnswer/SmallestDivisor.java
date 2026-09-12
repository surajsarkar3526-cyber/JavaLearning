package BinarySearchOnAnswer;

public class SmallestDivisor {

    static int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = findMax(nums);
        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int sum = calculateSum(nums, mid);

            if (sum <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    static int calculateSum(int[] nums, int divisor) {

        int sum = 0;

        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;
        }

        return sum;
    }

    static int findMax(int[] nums) {

        int max = nums[0];

        for (int num : nums) {
            if (num > max)
                max = num;
        }

        return max;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        System.out.println("Smallest Divisor = " + smallestDivisor(nums, threshold));
    }
}
