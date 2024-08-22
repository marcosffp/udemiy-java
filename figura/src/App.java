package sr
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import demo.Forma;

public class App {
  public static void main(String[] args){
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    List<Forma> formas = new ArrayList<>();

    System.out.print("Quantos figuras vão ser? ");
    int quantidade = sc.nextInt();

    for (int i = 1; i <= quantidade; i++) {
      System.out.println("Forma n°" + i + ":");
      System.out.print("Retangular ou circle (r/c): ");
      char opcao = sc.next().charAt(0);

      System.out.println("Color: ");
      for (int j = 0; j < Color.values().length; j++) {
        System.out.println((j + 1) + ". " + Color.values()[j].name());
      }
      int opcaoEnum = sc.nextInt();
      Color color = Color.values()[opcaoEnum--];

      if (opcao == 'r' || opcao == 'R') {
        System.out.print("Width: ");
        double width = sc.nextDouble();
        System.out.print("Height: ");
        double height = sc.nextDouble();
        Forma rectangle = new Rectangle(color, width, height);
        formas.add(rectangle);
      }
      System.out.print("Radius: ");
      double radius = sc.nextDouble();
      Forma circle = new Circle(color, radius);
      formas.add(circle);
    }
    System.out.println("Shape Areas");
    for (Forma forma : formas) {
      System.out.println(forma.area());
    }

    sc.close();
}
