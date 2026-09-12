package Pattern_Printing;

import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number : ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" "+" ");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
}
//package Pattern_Printing;
//
//import java.util.Scanner;
//
//public class Diamond {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int nsp = n - 1, nst = 1;
//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=nsp; j++){
//                System.out.print(" "+" ");
//            }
//            for(int j=1; j<=nst; j++){
//                System.out.print("*"+" ");
//            }
//
//            nsp--;
//            nst += 2;
//            System.out.println();
//        }
//    }
//}
