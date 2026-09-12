package OOPS;

class Cricketer{

//    final String country = "India";
//    final static String country = "India";

    static String country = "India";
    int runs;
    String name;
    double avg;

    void print(){
        System.out.println(runs+" "+name+" "+avg);
    }

    static void greet(){
        System.out.println("I only believe in jassi bhai");
    }
}
public class FinalAndStatic {
    public static void main(String[] args){
        Cricketer c1 = new Cricketer();
//        c1.country = "England";
//        System.out.println(c1.country);

        Cricketer c2 = new Cricketer();
        c1.country = "NZ";
        System.out.println(c2.country);
        c2.greet();
        c1.greet();
        fun();
    }

    private static void fun(){
        System.out.println("Hello Intellij IdeA");
    }
}
