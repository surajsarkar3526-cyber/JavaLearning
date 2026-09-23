package BucketSort;

import java.util.TreeSet;

public class ContainsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicate(
            int[] nums,
            int indexDiff,
            int valueDiff
    ) {

        TreeSet<Long> window = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > indexDiff) {
                window.remove((long) nums[i - indexDiff - 1]);
            }
            Long candidate = window.ceiling((long) nums[i] - valueDiff);
            if (candidate != null &&
                    candidate <= (long) nums[i] + valueDiff) {
                return true;
            }
            window.add((long) nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(containsNearbyAlmostDuplicate(nums1, 3, 0));
        int[] nums2 = {1, 5, 9, 1, 5, 9};
        System.out.println(containsNearbyAlmostDuplicate(nums2, 2, 3));
    }
}
