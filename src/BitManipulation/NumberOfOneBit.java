package BitManipulation;

import java.util.Scanner;

public class NumberOfOneBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No. : ");
        int n = sc.nextInt();
        System.out.println(SetBits(n));
    }

    private static int SetBits(int n) {
        int count = 0;
        for(int i=0; i<31; i++){
            if((n>>i)%2 != 0){
                count++;
            }
        }
        return count;
    }
}
