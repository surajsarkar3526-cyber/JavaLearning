package Recursion;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GenerateCombination {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Phone Digit : ");
        String digits = sc.nextLine();

        ArrayList<String> ans = new ArrayList<>();

        if (!digits.isEmpty()){
            generateCombination(digits,0,"",ans);
        }

        System.out.print(ans);

        sc.close();
    }

    private static void generateCombination(String digits, int idx, String current, ArrayList<String> ans) {

        if(idx == digits.length()){
            ans.add(current);
            return;
        }
        String[] keypad = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        int digit = digits.charAt(idx) - '0';
        String letter = keypad[digit];

        for(int i=0; i<letter.length(); i++){
            char ch = letter.charAt(i);
            generateCombination(
                    digits,
                    idx+1,
                    current+ch,
                    ans
            );
        }
    }
}
