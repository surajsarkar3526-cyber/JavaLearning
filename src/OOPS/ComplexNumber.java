package OOPS;
import java.util.Scanner;

class Complex {

    private double real;
    private double imaginary;

    Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    Complex add(Complex other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;

        return new Complex(newReal, newImaginary);
    }

    Complex subtract(Complex other) {
        double newReal = this.real - other.real;
        double newImaginary = this.imaginary - other.imaginary;

        return new Complex(newReal, newImaginary);
    }

    Complex multiply(Complex other) {
        double newReal =
                (this.real * other.real)
                        - (this.imaginary * other.imaginary);

        double newImaginary =
                (this.real * other.imaginary)
                        + (this.imaginary * other.real);

        return new Complex(newReal, newImaginary);
    }

    void display() {
        if (imaginary >= 0) {
            System.out.println(real + " + " + imaginary + "i");
        } else {
            System.out.println(real + " - " + (-imaginary) + "i");
        }
    }
}

public class ComplexNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n -------<---- Enter first complex number ---->--------- \n");

        System.out.print("Real part: ");
        double real1 = sc.nextDouble();

        System.out.print("Imaginary part: ");
        double imaginary1 = sc.nextDouble();

        System.out.println("\n ------------<---- Enter second complex number ----->---------\n");

        System.out.print("Real part: ");
        double real2 = sc.nextDouble();

        System.out.print("Imaginary part: ");
        double imaginary2 = sc.nextDouble();

        // Creating objects
        Complex c1 = new Complex(real1, imaginary1);
        Complex c2 = new Complex(real2, imaginary2);

        Complex sum = c1.add(c2);
        Complex difference = c1.subtract(c2);
        Complex product = c1.multiply(c2);

        System.out.print("\nFirst complex number: ");
        c1.display();

        System.out.print("Second complex number: ");
        c2.display();

        System.out.print("Addition: ");
        sum.display();

        System.out.print("Subtraction: ");
        difference.display();

        System.out.print("Multiplication: ");
        product.display();

        sc.close();
    }
}