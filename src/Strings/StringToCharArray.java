package Strings;

public class StringToCharArray {
    public static void main(String[] args){
        String S = "Ruhan";

        char[] arr = S.toCharArray();
        for(char ch : arr){
            System.out.println(ch);
        }
    }
}
