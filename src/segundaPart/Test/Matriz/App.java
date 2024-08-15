package segundaPart.Test.Matriz;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite o numero de linhas: ");
    int linha = sc.nextInt();
    System.out.println("Digite o numero de colunas:");
    int coluna = sc.nextInt();

    int[][] matrizes = new int[linha][coluna];
    int quantidadeNumerosNegativos = 0;

    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < linha; i++) {
      for (int j = 0; j < coluna; j++) {

        System.out.printf("Digite o valor para matrizes[%d][%d]: ", i, j);
        matrizes[i][j] = sc.nextInt();

        if (i == j) {
          list.add(matrizes[i][j]);
        }
        if (matrizes[i][j] < 0) {
          quantidadeNumerosNegativos++;
        }
      }
    }

    System.out.println("Main diagonal");
    for (Integer integer : list) {
      System.out.println(integer);
    }

    System.out.printf("Negativos: %d", quantidadeNumerosNegativos);

    sc.close();
  }
}
