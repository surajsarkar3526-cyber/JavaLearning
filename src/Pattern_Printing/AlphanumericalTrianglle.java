package Pattern_Printing;

import java.util.Scanner;

public class AlphanumericalTrianglle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number : ");
        int n = sc.nextInt();
        System.out.print("Enter ASCII  Value : ");
        int a = sc.nextInt();
        char ch = 0;

        for (int i = 1; i <= n; i++) {
            ch = (char)a;
            for (int j = 1; j <= i; j++) {
                if(i%2 == 0) System.out.print(ch + " ");
                else System.out.print(j + " ");
                ch++;
            }
            System.out.println();
        }
    }
}
