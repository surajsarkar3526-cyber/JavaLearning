package Queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int resultIndex = 0;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() &&
                    nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                result[resultIndex] = nums[deque.peekFirst()];
                resultIndex++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
