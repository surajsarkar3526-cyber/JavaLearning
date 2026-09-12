package Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class StringBasicMore {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = "Kartikey";
        change(s);
        System.out.println(s);

        String[] arr = {"Santosh","Krish","Hemant","Preet"};
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }

        ArrayList<String> al = new ArrayList<>();
        al.add("Shravani");
        al.add("Umang");
        al.add("Ayan");
        al.add("Shelly");
        al.add("Riya");
        System.out.println("\n"+al);
        Change2(al);
        System.out.println(al);
    }

    public static void Change2(ArrayList<String> al) {
        al.add("Biplab");
    }

    public static void change(String s) {
        s = "Lavish";
    }
}
