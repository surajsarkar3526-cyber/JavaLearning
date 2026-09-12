package BitManipulation;

public class DataTypes {
    public static void main(String[] args) {
        byte x = 127; // 2^8=256 --> -128 to +127
        System.out.println(x+1);
        x +=1;
        System.out.println(x);
        x+=3;
        System.out.println(x);

        // Most Significant Bit (MSB) aur Least Significant Bit (LSB) in Binary Number

        int y = Integer.MAX_VALUE;
        y += 10;
        System.out.println(y);
    }
}
