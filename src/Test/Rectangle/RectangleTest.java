package Test.Rectangle;

import java.util.Locale;
import java.util.Scanner;

import Demo.Rectangle.Rectangle;

public class RectangleTest {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US); 
    Scanner sc = new Scanner(System.in);
    
    Rectangle rectangle = new Rectangle();

    System.out.println("Enter rectangle width and height: ");
    rectangle.width = sc.nextDouble();
    rectangle.height = sc.nextDouble();

    System.out.println(rectangle);



    sc.close();
  }
}
