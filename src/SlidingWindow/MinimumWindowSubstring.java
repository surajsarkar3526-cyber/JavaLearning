package SlidingWindow;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    private static String minWindow(String s, String t) {
        int[] need = new int[228];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int left = 0;
        int remaining = t.length();
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if (need[current] > 0) {
                remaining--;
            }
            need[current]--;
            while (remaining == 0) {
                int windowLength = right - left + 1;
                if (windowLength < minLength) {
                    minLength = windowLength;
                    start = left;
                }
                char removed = s.charAt(left);
                need[removed]++;
                if (need[removed] > 0) {
                    remaining++;
                }
                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + minLength);
    }
}