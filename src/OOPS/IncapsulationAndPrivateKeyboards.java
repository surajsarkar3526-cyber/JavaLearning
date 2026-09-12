package OOPS;

import java.util.Scanner;

class Students{
    String name;
    private int rno;
    double cgpa;
    void print(){    // getter
        System.out.println(name+" "+rno+" "+cgpa);
    }

    public int getRno() {  // getter
        return rno;
    }
    public void setRno(int i) { // setter
        rno = i;
    }
//    public void p(){    // Kuch nhi means public
//        print();
//    }


}
public class IncapsulationAndPrivateKeyboards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Students s1 = new Students();
//        System.out.println(s1.cgpa);
//        System.out.println(s1.rno);
        s1.setRno(47);
        s1.print();
        s1.cgpa = 8.9;
        s1.name = "Hemant";
        s1.print();
        System.out.println(s1.getRno());

        Students s2 = new Students();
        s2.print();

        StringBuilder sb = new StringBuilder(sc.nextLine());
        System.out.println(sb);
    }
}
