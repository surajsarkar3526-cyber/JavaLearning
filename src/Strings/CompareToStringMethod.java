package Strings;

import java.util.Scanner;

public class CompareToStringMethod {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your 1st String : ");
        String s1 = sc.next();
        System.out.print("Enter your 2nd String : ");
        String s2 = sc.next();

        System.out.println(s1.concat(s2));
    }
}
