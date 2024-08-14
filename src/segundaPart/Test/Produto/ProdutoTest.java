package segundaPart.Test.Produto;

import java.util.Locale;
import java.util.Scanner;

import Demo.Produto.Produto;

public class ProdutoTest {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    Produto[] vect = new Produto[n];

    for (int i = 0; i < vect.length; i++) {
      sc.nextLine();
      String name = sc.nextLine();
      double price = sc.nextDouble();
      vect[i] = new Produto(name, price);

    }

    double soma = 0.0;
    for (int i = 0; i < vect.length; i++) {
      soma += vect[i].getPrice();
    }

    double media;
    media = soma / n;
    System.out.printf("A média dos preços = %.2f",media);




    sc.close();
  }
}
