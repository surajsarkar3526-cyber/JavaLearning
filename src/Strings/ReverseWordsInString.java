package Strings;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int write = 0;
        int read = 0;
        while (read < chars.length) {
            while (read < chars.length && chars[read] == ' ') {
                read++;
            }
            while (read < chars.length && chars[read] != ' ') {
                chars[write++] = chars[read++];
            }
            while (read < chars.length && chars[read] == ' ') {
                read++;
            }
            if (read < chars.length) {
                chars[write++] = ' ';
            }
        }
        reverse(chars, 0, write - 1);
        int start = 0;
        for (int i = 0; i <= write; i++) {
            if (i == write || chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
        return new String(chars, 0, write);
    }
    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        String s = "  the   sky is   blue  ";
        String result = reverseWords(s);
        System.out.println(result);
    }
}
