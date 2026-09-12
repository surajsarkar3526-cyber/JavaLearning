package Binary_Search;

import java.util.Scanner;

public class ArrangingOne {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter coins: ");
        int n = sc.nextInt();
        int ans = arrangeCoins(n);
        System.out.println("Complete Rows = " + ans);
    }
    private static int arrangeCoins(int n) {
        int lo = 1;
        int hi = n;
        int ans = 0;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;

            long CoinsCount = (long) mid * (mid + 1)/2;
            if(CoinsCount == n){
                return mid;
            }
            else if(CoinsCount < n){
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