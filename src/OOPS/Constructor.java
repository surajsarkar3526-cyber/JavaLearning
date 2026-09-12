package OOPS;

import java.util.Scanner;
import static OOPS.Constructor.Car.max;
import java.util.*;

public class Constructor {
    public static class Car{
        int price;
        String name;
        Car(){  // constructor overloading

        }
        Car(int x,String s){
            price = x;
            name = s;
        }

        Car(String s, int x){  // constructor mein Order Matter karta hain
            price = x;
            name = s;
        }
        public void print(){
            System.out.println(price+" "+name);
        }

        public static int max(int a, int b){  // Method Overloading
            return Math.max(a,b);
        }
        public static int max(int a, int b, int c){  // Method OverLoading
            return Math.max(a,Math.max(b,c));
        }
    }
    public static void main(String[] args){
        Car c1 = new Car(5,"Kia Sonet");
        System.out.println(c1.name);
        c1.print();

        Car c2 = new Car(4,"Lord Alto");
        c2.print();
        Car c3 = new Car();
        c3.name = "Honda Amaze";
        System.out.println(max(3,8));
        System.out.println(max(2,7,4));

        Car c4 = new Car("constructor Order Matter karta hain",7);
        c4.print();
    }
}
