package Math;

import java.util.Scanner;

public class PowX_N {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x: ");
        double x = sc.nextDouble();
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        double answer = myPow(x, n);
        System.out.println("Answer = " + answer);
        sc.close();
    }

    private static double myPow(double x, int n) {
        long power = n;
        if(power < 0){
            x = 1/x;
            power = -power;
        }
        double result = 1.0;
        while(power > 0){
            if(power % 2 == 1){
                result = result * x;
            }
            x = x * x;
            power = power / 2;
        }
        return result;
    }
}
