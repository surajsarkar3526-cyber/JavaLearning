package Recursion;

public class GlobalVariables {
    static int x = 13;  // static means Shareable Variables
    public static void main(String[] args){
        fun(); // Function Call
        System.out.println(x);
    }
    public static void fun(){
        System.out.println(x);
        x = 98937;
    }
}