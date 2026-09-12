package BitManipulation;

public class CheckKthBit {

    public static void main(String[] args) {

        int n = 4;
        int k = 2;

        System.out.println(checkKthBit(n, k));
    }

    private static boolean checkKthBit(int n, int k) {

        return ((n>>k) % 2 == 1);
    }
}
