package Arrays;

public class ArrayNesting {
    public static void main(String[] args) {
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(arrayNesting(nums));
    }

    public static int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int current = i;
            int count = 0;
            while (!visited[current]) {
                visited[current] = true;
                count++;
                current = nums[current];
            }
            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
    }
}
