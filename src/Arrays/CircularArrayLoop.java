package Arrays;

public class CircularArrayLoop {
    public static void main(String[] args) {
        int[] nums1 = {2, -1, 1, 2, 2};
        int[] nums2 = {-1, -2, -3, -4, -5, 6};
        int[] nums3 = {1, -1, 5, 1, 4};
        System.out.println(circularArrayLoop(nums1));
        System.out.println(circularArrayLoop(nums2));
        System.out.println(circularArrayLoop(nums3));
    }

    private static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean forward = nums[i] > 0;
            int slow = i;
            int fast = i;
            while (true) {
                int nextSlow = getNextIndex(nums, slow);
                if ((nums[nextSlow] > 0) != forward || nextSlow == slow) {
                    break;
                }
                int nextFast = getNextIndex(nums, fast);
                if ((nums[nextFast] > 0) != forward || nextFast == fast) {
                    break;
                }
                nextFast = getNextIndex(nums, nextFast);
                if ((nums[nextFast] > 0) != forward || nextFast == getNextIndex(nums, nextFast)) {
                    break;
                }
                slow = nextSlow;
                fast = nextFast;
                if (slow == fast) {
                    return true;
                }
            }
        }

        return false;
    }

    private static int getNextIndex(int[] nums, int index) {
        int n = nums.length;
        return ((index + nums[index]) % n + n) % n;
    }
}
