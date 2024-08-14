package segundaPart.Test;

import java.util.Locale;
import java.util.Scanner;

public class VetorTest {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.print("Quantas pessoas serão digitadas? ");
    int n = sc.nextInt();
    sc.nextLine(); 

    Vetor[] vetors = new Vetor[n];
    int cont = 1;

    for (int i = 0; i < vetors.length; i++) {
      System.out.println("Dados da " + cont++ + "a pessoa: ");
      System.out.print("Nome: ");
      String nome = sc.nextLine();
      System.out.print("Idade: ");
      int idade = sc.nextInt();
      System.out.print("Altura: ");
      double altura = sc.nextDouble();
      sc.nextLine();  

      vetors[i] = new Vetor(nome, idade, altura);
    }

    double alturaMedia;
    double somaAltura = 0.0;
    int contMenores16 = 0;

    for (int i = 0; i < vetors.length; i++) {
      somaAltura += vetors[i].getAltura();
      if (vetors[i].getIdade() < 16) {
        contMenores16++;
      }
    }
    alturaMedia = somaAltura / n;
    double porcetagemMenoresIdade = (double) contMenores16 * 100 / n;

    System.out.printf("Altura media: %.2f%n", alturaMedia);
    System.out.printf("Pessoas com menos de 16 anos: %.2f%%%n", porcetagemMenoresIdade);

    for (int i = 0; i < vetors.length; i++) {
      if (vetors[i].getIdade() < 16) {
        System.out.println(vetors[i].getNome());
      }
    }




    sc.close();
  }
}
