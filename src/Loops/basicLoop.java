package Loops;

import java.util.Scanner;

public class basicLoop {
    public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter terms of Number : ");
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++) System.out.print(i + " ");

    }
}
