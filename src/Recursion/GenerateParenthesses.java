package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GenerateParenthesses {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        int n = sc.nextInt();
        
        ArrayList<String> ans = new ArrayList<>();
        
        Generate(n,n,"",ans);
        System.out.print(ans);
    }

    private static void Generate(int n, int n1, String current, ArrayList<String> ans) {

        if(n == 0 && n1 == 0){
            ans.add(current);
            return;
        }
        if(n > 0){
            Generate(n-1,n1,current+"(",ans);
        }

        if(n1 > n){
            Generate(n,n1-1,current+")",ans);
        }
    }
}