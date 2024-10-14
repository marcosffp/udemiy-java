package main;

import demo.Company;
import demo.Individual;
import demo.Taypayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    List<Taypayer> taypayers = new ArrayList<>();
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    System.out.print("Insira o número de contribuintes: ");
    int quantidade = sc.nextInt();

    for (int i = 1; i <= quantidade; i++) {
      System.out.println("Dados do contribuinte n°" + i + ":");
      System.out.print("Individual or company (i/c): ");
      char opcao = sc.next().charAt(0);
      sc.nextLine(); // Consumir a linha restante

      System.out.print("Name: ");
      String name = sc.nextLine();

      System.out.print("Anual income: ");
      double anualIncome = sc.nextDouble();

      if (opcao == 'i') {
        System.out.print("Health expenditures: ");
        double healthExpenditures = sc.nextDouble();
        Taypayer individual = new Individual(name, anualIncome, healthExpenditures);
        taypayers.add(individual);

      } else {
        System.out.print("Number of employees: ");
        int numberOfEmployees = sc.nextInt();
        Taypayer company = new Company(name, anualIncome, numberOfEmployees);
        taypayers.add(company);
      }
    }

    for (Taypayer taypayer : taypayers) {
      System.out.println(taypayer.tax());
    }

    sc.close();
  }
}
