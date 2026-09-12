package BitManipulation;

public class ToggleKthBit {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        System.out.println(toggleKthBit(n, k));
    }

    private static int toggleKthBit(int n, int k) {
        return (n ^ (1 << k));
    }
}
