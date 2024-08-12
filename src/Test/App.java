package Test;

import java.util.Scanner;
import Demo.Triangle.Triangle;
import java.util.Locale;

public class App {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Triangle x, y;
        x = new Triangle();
        y = new Triangle();

        System.out.println("Enter the measures of triangle X: ");
        x.lado1 = sc.nextDouble();
        x.lado2 = sc.nextDouble();
        x.lado3 = sc.nextDouble();
        System.out.println("Enter the measures of triangle Y: ");
        y.lado1 = sc.nextDouble();
        y.lado2 = sc.nextDouble();
        y.lado3 = sc.nextDouble();

        double areaX = x.areaDoTriangulo();
        double areaY = y.areaDoTriangulo();

        System.out.printf("Triangle X area: %.4f%n", areaX);
        System.out.printf("Triangle Y area: %.4f%n", areaY);

        if (areaX > areaY) {
            System.out.println("Larger area: X");
        } else {
            System.out.println("Larger area: Y");
        }

        sc.close();

    }
}
