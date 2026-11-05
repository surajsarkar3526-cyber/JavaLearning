package MergeSort;

public class CountRangeSum {
    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;
        int result = countRangeSum(nums, lower, upper);
        System.out.println("Count of Range Sum: " + result);
    }

    static int count = 0;
    public static int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        long[] temp = new long[n + 1];
        count = 0;
        mergeSort(prefix, temp, 0, n, lower, upper);
        return count;
    }

    static void mergeSort(long[] prefix, long[] temp, int left, int right, int lower, int upper) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(prefix, temp, left, mid, lower, upper);
        mergeSort(prefix, temp, mid + 1, right, lower, upper);
        int low = mid + 1;
        int high = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (low <= right &&
                    prefix[low] - prefix[i] < lower) {
                low++;
            }
            while (high <= right &&
                    prefix[high] - prefix[i] <= upper) {
                high++;
            }
            count += high - low;
        }
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (prefix[i] <= prefix[j]) {
                temp[k++] = prefix[i++];
            } else {
                temp[k++] = prefix[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = prefix[i++];
        }
        while (j <= right) {
            temp[k++] = prefix[j++];
        }
        for (int x = left; x <= right; x++) {
            prefix[x] = temp[x];
        }
    }
}
