package Strings;

import java.util.ArrayList;

public class StringBuilders {
    public static void main(String[] args){
//        ArrayList<Character> Str = new ArrayList<>();
//        Str.add('r');
//        Str.set(0,'j');
//        StringBuilder s = new StringBuilder("Suraj");
//        System.out.println(s);
//        System.out.println(s.length()+" "+s.capacity());   ---> Output = 5 21  { 16 StringBuilders Capacity hoti hain} 5 lebth hain
        StringBuilder s = new StringBuilder();
        StringBuilder s1 = new StringBuilder(6);
        System.out.println(s1.length() + " " + s1.capacity());
        s1.append("Suraj");
        System.out.println(s1.length() + " " + s1.capacity());

        // Set Characters
        s1.setCharAt(0, 's');  // Suraj -> suraj
        System.out.println(s1);

        String s2 = s1.toString();
        System.out.println(s2);
        String s3 = "Devesh";
        StringBuilder t = new StringBuilder(s3);
        t.append(" Jain");
        System.out.println(t);

        System.out.println(t.length() + " " + t.capacity());
    }
}
