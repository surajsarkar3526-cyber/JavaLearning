package If_Else;

import java.util.Scanner;

public class GreatestofThree {
    public void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 1st Number : ");
        int First = sc.nextInt();

        System.out.print("Enter 2nd Number : ");

        int Second = sc.nextInt();

        System.out.print("Enetr 3rd number : ");
        int Third = sc.nextInt();

        if(First > Second){
            if(Second > Third) System.out.print(Second);
            else System.out.print(Third);
        }
        else{
            if(First > Third) System.out.print(First);
            else System.out.print(Third);
        }
    }
}
