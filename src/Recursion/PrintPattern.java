package Recursion;

import java.util.ArrayList;

public class PrintPattern {
    public static void main(String[] args){
        int n = 10;
        ArrayList<Integer> ans = printPattern(n);
        System.out.println(ans);
    }

    private static ArrayList<Integer> printPattern(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        if(n <= 0){
            result.add(n);
            return result;
        }
        pattern(n, result);
        return result;
    }

    private static void pattern(int n, ArrayList<Integer>result) {
        result.add(n);
        if(n<=0){
            return;
        }
        pattern(n-5, result);
        if(n != 0){
            result.add(n);
        }
    }
}
