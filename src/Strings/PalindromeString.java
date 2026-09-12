package Strings;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String : ");
        String st = sc.next();

        if(isPalindrome(st)){
            System.out.print(st + " Is Palindrome");
        }
        else{
            System.out.print(st + " Is Not Palindrome");
        }
    }

    private static boolean isPalindrome(String st) {

        st = st.toLowerCase();
        int start = 0;
        int End = st.length()-1;

        while(start < End){
            if(st.charAt(start) != st.charAt(End)){
                return false;
            }
            start++;
            End--;
        }
        return true;
    }
}