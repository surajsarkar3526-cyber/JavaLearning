package Recursion;

public class FunctionCallingItself {
    public static void main(String[] args){
        ajay(1);
    }

    private static void ajay(int n) {
        if(n==19){  // Base Case
            return;
        }
        System.out.println("Priya");
        ajay(n + 1);
    }
}