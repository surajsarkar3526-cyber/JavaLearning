package BitManipulation;

import java.util.Scanner;

public class powerof2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPowerofTwo(n));
    }

    private static boolean isPowerofTwo(int n) {
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        if(n%2 == 1){
            return false;
        }
        return isPowerofTwo(n/2);
    }
}
