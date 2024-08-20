package main;

import demo.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class aplication {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    List<Produto> produtos = new ArrayList<>();

    System.out.println("Insira o número de produtos: ");
    sc.close();
  }
}
