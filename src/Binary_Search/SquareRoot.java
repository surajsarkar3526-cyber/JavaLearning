package Binary_Search;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size : ");
        int n = sc.nextInt();
        int ans = Squareroot(n);

        System.out.print("Square Root : " + ans);
    }

    private static int Squareroot(int n) {
        int lo = 0;
        int hi = n;
        int ans = -1;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            long Square = (long) mid * mid;

            if(Square == n){
                return mid;
            }
            else if(Square < n){
                ans = mid;
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return ans;
    }
}
