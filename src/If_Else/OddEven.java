package If_Else;

import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        System.out.print("Enter the value : ");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n%2 == 0){
            System.out.print("Even number ");
        }
        else{
            System.out.println("Odd number ");
        }
    }
}
