package Strings;

import java.util.Scanner;

public class IntToString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        String S = ""; // ---> Empty String
//
//        s += n;
        String s = Integer.toString(n);
        System.out.println(s);
    }
}
