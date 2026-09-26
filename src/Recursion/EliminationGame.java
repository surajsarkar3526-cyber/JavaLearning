package Recursion;

public class EliminationGame {
    public static void main(String[] args) {
        System.out.println(lastRemaining(9));
        System.out.println(lastRemaining(1));
    }

    private static int lastRemaining(int n) {
        int head = 1;
        int step = 1;
        boolean left = true;
        while(n > 1){
            if(left || n % 2 == 1){
                head += step;
            }
            n /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }
}
