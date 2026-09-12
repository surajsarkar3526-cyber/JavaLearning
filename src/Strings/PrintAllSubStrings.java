package Strings;

public class PrintAllSubStrings {
    public static void main(String[] args) {
        String str = "1234";

        int sum = SubStrings(str);
        System.out.println(sum);
    }

    public static int SubStrings(String str) {

        int n = str.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int m = Integer.parseInt(str.substring(i,j+1));
                sum += m;
            }
        }
        return sum;
    }
}