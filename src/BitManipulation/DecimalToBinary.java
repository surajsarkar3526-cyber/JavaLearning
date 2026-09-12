package BitManipulation;

public class DecimalToBinary {

    public static void main(String[] args) {

        int n = 13;

        System.out.println(decimalToBinary(n));
    }

    static String decimalToBinary(int n) {

        if(n == 0){
            return "0";
        }

        StringBuilder binary = new StringBuilder();

        while(n > 0){

            int bit = n & 1;
            binary.append(bit);

            n = n >> 1;
        }

        return binary.reverse().toString();
    }
}
