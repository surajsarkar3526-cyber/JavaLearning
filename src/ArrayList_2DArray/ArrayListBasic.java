package ArrayList_2DArray;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListBasic {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.print("Enter Jitne Element dalne hain : ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            System.out.print("Enter Element " + (i + 1) + " : ");
            int x = sc.nextInt();
            arr.add(x);
        }
        System.out.print("ArrayList : "+arr);
    }
}
