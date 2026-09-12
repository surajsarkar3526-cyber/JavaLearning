package OOPS;

public class PassingClassesToMethod {
    public static class Car {
        int seats;
        String name;
        double length;
        String type;
        int torque;
        void print(){
            System.out.print(name + " "+length+" "+seats+" "+torque+" "+type);
        }
    }
    public static void main(String[] args){
        Car c = new Car();
        c.seats = 5;
        c.name = "Kia Sonet";
        c.length = 3.99;
        c.torque = 178;
        c.type = "SUV";

        System.out.println(c.seats);
        c.print();
    }
}
