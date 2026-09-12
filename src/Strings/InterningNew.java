package Strings;

public class InterningNew {
    public static boolean Equals(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
//        String Str = "Vishu";
//        System.out.println(Str.substring(0,4)+'n'+Str.substring(4,5));
//        String s1 = "Suraj";
//        String s2 = "Suraj"; ----> Same Value in another variables
//        System.out.println(s1==s2);
        String s1 = new String("Suraj");
        String s2 = new String("Suraj");
//        System.out.println(s1==s2);  ---> check Addresses of s1 and s2
        System.out.println(s1.equals(s2));
        System.out.println(Equals(s1, s2));
    }
}
