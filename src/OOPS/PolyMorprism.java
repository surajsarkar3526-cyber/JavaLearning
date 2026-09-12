package OOPS;

public class PolyMorprism {
    public static class Dog{
        void speak(){
            System.out.println("Bhau Bhau");
        }
    }
    public static class Cat{
        void speak(){
            System.out.println("Meow Meow");
        }
    }
    public static class Lion{
        void speak(){
            System.out.println("GRRRRRR");
        }
    }
    public static class Pikachu{
        void speak(){
            System.out.println("Pika Pika");
        }
    }
    public static class Human{
        void speak(){
            System.out.println("Hello");
        }
    }
    public static void main(String[] args){
        Dog d = new Dog();
        Cat c = new Cat();
        Pikachu p = new Pikachu();
        Human h = new Human();

        d.speak();
        c.speak();
        p.speak();
        h.speak();
    }
}
