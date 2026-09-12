package BitManipulation;

import java.util.Scanner;

public class SetRightMostUnsetBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(RightMostSetBit(n));
    }

    private static int RightMostSetBit(int n) {

        for(int i=0; i<31; i++){
            if((n >> i)%2 == 0){
                return n | (1<<i);
            }
        }
        return 4;
    }
}
