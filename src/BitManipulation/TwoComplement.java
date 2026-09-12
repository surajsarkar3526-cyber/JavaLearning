package BitManipulation;

public class TwoComplement {
    public static void main(String[] args) {

        int n = 5;
        int oneComplement = ~n;
        int twoComplement = ~n + 1;

        System.out.println("Original Number : "+n);
        System.out.println("1's Complement : "+oneComplement);
        System.out.println("2's Complement : "+twoComplement);
    }
}
