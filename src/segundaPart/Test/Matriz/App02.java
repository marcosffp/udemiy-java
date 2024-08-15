package segundaPart.Test.Matriz;

import java.util.Locale;
import java.util.Scanner;

public class App02 {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    int i = sc.nextInt();
    int j = sc.nextInt();

    int[][] matrizes = new int[i][j];

    System.out.println();

    for (int j2 = 0; j2 < i; j2++) {
      for (int k = 0; k < j; k++) {
        matrizes[j2][k] = sc.nextInt();
      }
    }

    for (int j2 = 0; j2 < i; j2++) {
      for (int k = 0; k < j; k++) {
        System.out.print(matrizes[j2][k] + " ");
      }
      System.out.println();
    }
  
    System.out.println("---------------");
    int num=sc.nextInt();
    for (int j2 = 0; j2 < i; j2++) {
      for (int k = 0; k < j; k++) {
        if (matrizes[j2][k] == num) {
          System.out.println("Posicao: " + j2 + ", " + k);
          if (j2 - 1 >= 0) {
            System.out.println("cima: " + matrizes[j2 - 1][k]);
          }
          if (k + 1 < j) {
            System.out.println("Direita: " + matrizes[j2][k + 1]);
          }
          if (j2+1<i) {
            System.out.println("em baixo: "+matrizes[j2+1][k]);
          }if (k-1>=0) {
            System.out.println("Esquerda: "+matrizes[j2][k-1]);
          }
        }
      }
    }
    


  



    sc.close();
  }
}
