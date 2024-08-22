package model.services;

import java.util.Locale;
import java.util.Scanner;
import model.Demo.Conta;
import model.Exception.DomainException;

public class App {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    try {
      System.out.println("Enter account data: ");
      System.out.print("Number: ");
      Integer number = sc.nextInt();
      sc.nextLine(); 
      System.out.print("Holder: ");
      String holder = sc.nextLine();
      System.out.print("Initial balance: ");
      double deposit = sc.nextDouble();
      System.out.print("Withdraw limit: ");
      double retiradaLimite = sc.nextDouble();
      Conta conta = new Conta(number, holder, deposit, retiradaLimite);

      System.out.println();
      System.out.print("Enter amount for withdraw: ");
      double amount = sc.nextDouble();
      conta.withdraw(amount);
      System.out.println("New balance: " + String.format("%.2f", conta.getSaldo()));

    } catch (DomainException e) {
      System.out.println("Withdraw error: " + e.getMessage());
    } catch (RuntimeException e) {
      System.out.println("Unexpected error: " + e.getMessage());
    }

    sc.close();
  }
}
