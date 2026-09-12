package Loops;

import java.util.Scanner;

public class AP {
    public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the terms of number : ");
        int n = sc.nextInt();
        for(int i = 2; i <= 3*n-1; i +=3) System.out.print(i +" ");
    }
}
