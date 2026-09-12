package OOPS;

import java.util.Scanner;
import java.util.*;

public class FractionClass {
    public static class Fraction{
        int numerator;
        int denominator;

        public Fraction(int numerator, int denominator) {
            if(denominator == 0){
                throw new IllegalArgumentException(
                        "Denominator cannot be zero"
                );
            }

            this.numerator = numerator;
            this.denominator = denominator;

            simplify();
        }

        private void simplify() {

            int gcd = findGCD(
                    Math.abs(numerator),
                    Math.abs(denominator)
            );

            numerator = numerator / gcd;
            denominator = denominator / gcd;

            if(denominator < 0){
                numerator = -numerator;
                denominator = -denominator;
            }
        }

        private int findGCD(int a, int b) {

            while (b != 0){
                int reminder = a % b;
                a = b;
                b = reminder;
            }

            return a;
        }

        public void print() {
            System.out.println(numerator + "/"+denominator);
        }

        public Fraction add(Fraction f2) {
            int newNumerator =
                    numerator * f2.denominator
                    + f2.numerator * denominator;

            int newDenominator =
                    denominator * f2.denominator;
            return new Fraction(newNumerator, newDenominator);
        }

        public Fraction subtract(Fraction f2) {

            int newNumerator =
                    numerator * f2.denominator
                    - f2.numerator * denominator;

            int newDenominator =
                    denominator * f2.denominator;

            return new Fraction(newNumerator, newDenominator);
        }

        public Fraction multiply(Fraction f2) {

            int newNumerator =
                    numerator * f2.numerator;

            int newDenominator =
                    denominator * f2.denominator;

            return new Fraction(newNumerator, newDenominator);
        }

        public Fraction divide(Fraction f2) {

            if(f2.numerator == 0){
                throw new ArithmeticException (
                    "Cannoot divide by zero fraction"
                );
            }

            int newNumerator =
                    numerator * f2.denominator;

            int newDenominator =
                    denominator * f2.numerator;

            return new Fraction(newNumerator, newDenominator);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("-------<----- Enter First FractionNumber ---->--------\n");

        System.out.print("Enter First Numerator : ");
        int numerator1 = sc.nextInt();

        System.out.print("Enter First Dinominator : ");
        int denominator1 = sc.nextInt();
        
        System.out.println(" ----------<------ Enter Second FractionNumber --->-------\n");
        System.out.print("Enter Second Numerator : ");
        int numerator2 = sc.nextInt();
        
        System.out.print("Enter Second Denominator : ");
        int denominator2 = sc.nextInt();

        try{
            Fraction f1 = new Fraction(
                    numerator1, denominator1
            );
            
            Fraction f2 = new Fraction(
                    numerator2, denominator2
            );
            
            System.out.print("\nFirst fraction : ");
            f1.print();

            System.out.print("Second fraction: ");
            f2.print();

            Fraction sum = f1.add(f2);
            System.out.print("Addition: ");
            sum.print();

            Fraction difference = f1.subtract(f2);
            System.out.print("Subtraction: ");
            difference.print();

            Fraction product = f1.multiply(f2);
            System.out.print("Multiplication: ");
            product.print();

            Fraction quotient = f1.divide(f2);
            System.out.print("Division: ");
            quotient.print();
        }

        catch(IllegalArgumentException |
              ArithmeticException exception) {

            System.out.println(
                    "Error: " + exception.getMessage()
            );
        }
        sc.close();
    }
}
