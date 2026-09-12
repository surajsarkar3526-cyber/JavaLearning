package Strings;

import java.util.Scanner;

public class Plus {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String s = "bhakti";
        s = s + " hi shakti hain";
//        s += s + " hi shakti hain";

        s += '\n';
        s += 'n';
        System.out.println(s);

        System.out.println(10 + 20 + " Raghav");
        System.out.println(10 + " Raghav " + 20);

        System.out.println('A' + 2 + " Isha");
    }
}
