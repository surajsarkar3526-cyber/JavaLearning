package BitManipulation;

public class BinaryToDecimal {

    public static void main(String[] args) {

        String binary = "1011";

        int decimal = binaryToDecimal(binary);

        System.out.println("Decimal = " + decimal);
    }

    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            int bit = binary.charAt(i) - '0';
            decimal = decimal * 2 + bit;
        }

        return decimal;
    }
}
