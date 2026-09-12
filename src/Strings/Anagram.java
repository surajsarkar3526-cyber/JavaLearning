package Strings;
import java.util.*;
import java.util.Arrays;

public class Anagram {

    public static void main(String[] args){
        String s1 = "Anagram";
        String s2 = "Nagaarm";

        if(Equal(s1, s2)){
            System.out.println("Both Strings are Anagram ");
        }
        else{
            System.out.println("Not Anagram");
        }
    }

    private static boolean Equal(String str1, String str2) {
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s","").toLowerCase();

        if(str1.length() != str2.length()){
            return false;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}