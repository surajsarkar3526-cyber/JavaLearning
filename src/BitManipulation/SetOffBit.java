package BitManipulation;

public class SetOffBit {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        System.out.println(setKthBit(n, k));
    }

    private static int setKthBit(int n, int k) {
        return (n & (~(1<<k)));
    }
}
