package Strings;

public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int length = compress(chars);
        System.out.println("Compressed Length: " + length);
        for (int i = 0; i < length; i++) {
            System.out.print(chars[i] + " ");
        }
    }

    private static int compress(char[] chars) {
        int read = 0;
        int write = 0;
        while (read < chars.length) {
            char current = chars[read];
            int count = 0;
            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }
            chars[write++] = current;
            if (count > 1) {
                String countString = String.valueOf(count);
                for (char digit : countString.toCharArray()) {
                    chars[write++] = digit;
                }
            }
        }
        return write;
    }
}
