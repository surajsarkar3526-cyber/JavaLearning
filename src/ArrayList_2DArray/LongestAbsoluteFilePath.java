package ArrayList_2DArray;

public class LongestAbsoluteFilePath {
    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n" + "\tsubdir2\n\t\tsubsubdir2\n" + "\t\t\tfile2.ext";
        System.out.println(lengthLongestPath(input));
    }
    private static int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int[] pathLength = new int[lines.length];
        int maxLength = 0;
        for (String line : lines) {
            int depth = 0;
            while (line.charAt(depth) == '\t'){
                depth++;
            }
            String name = line.substring(depth);
            int currentLength = name.length();
            if (depth > 0) {
                currentLength += pathLength[depth - 1] + 1;
            }
            if (name.contains(".")){
                maxLength = Math.max(maxLength, currentLength);
            }
            else {
                pathLength[depth] = currentLength;
            }
        }
        return maxLength;
    }
}