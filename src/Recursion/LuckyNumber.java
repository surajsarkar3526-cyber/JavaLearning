package Recursion;

public class LuckyNumber {
    public static void main(String[] args){
        int n = 19;
        System.out.println(isLucky(n));
    }

    private static boolean isLucky(int n) {
        return islucky(n, 2);
    }

    private static boolean islucky(int n, int step) {
        if(step > n){
            return true;
        }
        if(n%step==0){
            return false;
        }
        n = n-(n/step);
        return islucky(n, step + 1);
    }
}
