package Loops;

import java.util.Scanner;

public class Tableof19 {
    public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enetr number : ");
        int n = sc.nextInt();
        for(int i = n; i <= n*10; i++){
            if(i%n ==0) System.out.print(i + " ");
        }
    }
}
