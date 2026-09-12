package If_Else;

import java.util.Scanner;

public class FourDigitNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number : ");

        int n = sc.nextInt();
        if(n > 999 && n < 10000) System.out.print("Four Digit Number");
        else System.out.print("Not Four Digit Number ");
    }
}
