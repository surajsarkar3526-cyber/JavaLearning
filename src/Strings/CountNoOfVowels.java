package Strings;

import java.util.Scanner;

public class CountNoOfVowels {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = "Suraj Sarkar";
        for(int i=0; i<str.length(); i++){
            System.out.print(str.charAt(i)+" ");
        }
        String s = sc.nextLine();
        System.out.println(s);
        String t = sc.next();
        System.out.print(t);
    }
}
