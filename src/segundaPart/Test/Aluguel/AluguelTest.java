package segundaPart.Test.Aluguel;

import java.util.Locale;
import java.util.Scanner;

import segundaPart.Demo.Aluguel.Aluguel;

public class AluguelTest {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.print("How many rooms will be rented? ");
    int n = sc.nextInt();

    Aluguel[] aluguels = new Aluguel[10];

    for (int i = 0; i < n; i++) {
      System.out.println();
      System.out.println("Rent #" + i + ":");
      System.out.print("Name: ");
      sc.nextLine();
      String nome = sc.nextLine();
      System.out.print("Email: ");
      String email = sc.nextLine();
      System.out.print("Room: ");

      int roomNumber = sc.nextInt();
      aluguels[roomNumber] = new Aluguel(nome, email);
    }
    System.out.println();
    System.out.println("Busy rooms");

    for (int i = 0; i < aluguels.length; i++) {
      if (aluguels[i]!=null) {
        System.out.println(i+": "+aluguels[i].toString());
      }
      
    }

    sc.close();
  }

}
