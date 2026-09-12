package If_Else;

import java.util.Scanner;

public class AbsoluteValue {
    public static void main(String[] args) {
        Scanner sb = new Scanner(System.in);
        System.out.print("Enter coast price : ");

        int coast = sb.nextInt();

        System.out.print("Enter selling price : ");
        int sp = sb.nextInt();

        if(sp > coast) System.out.print("Profit");
        else if(sp == coast) System.out.print("no profit neither loss");
        else System.out.print("Loss");
    }
}
