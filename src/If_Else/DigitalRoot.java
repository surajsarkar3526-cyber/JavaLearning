package If_Else;

public class DigitalRoot {
    public static void main(String[] args){
        int n = 99999;
        System.out.println(digitalRoot(n));
    }

    private static int digitalRoot(int n) {
        while(n > 9){
            int sum = 0;
            while(n > 0){
                int digit = n % 10;
                sum = sum + digit;
                n = n / 10;
            }
            n = sum;
        }
        return n;
    }
}
