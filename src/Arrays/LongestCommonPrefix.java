package Arrays;

import java.util.Scanner;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No. : ");
        int n = sc.nextInt();

        String[] strs = {"flower", "flow", "flight"};
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    private static String longestCommonPrefix(String[] str) {
        String prefix = str[0];
        for(int i=1; i<str.length; i++){
            while(!str[i].startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
}
