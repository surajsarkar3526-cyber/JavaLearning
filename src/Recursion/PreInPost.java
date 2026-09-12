package Recursion;

import java.util.Scanner;

public class PreInPost {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        pip(4);
    }

    private static void pip(int n) {
        if(n==0){
            return;
        }
        System.out.print("pre"+n+" ");
        pip(n-1);
        System.out.print("In"+n+" ");
        pip(n-1);
        System.out.print("Post"+n+" ");
    }
}
