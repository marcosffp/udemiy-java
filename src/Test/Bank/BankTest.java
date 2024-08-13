package Test.Bank;

import Demo.Bank.Bank;
import java.util.Locale;
import java.util.Scanner;

public class BankTest {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter account number: ");
    int numeroConta = sc.nextInt();
    sc.nextLine();  // Consumir a nova linha pendente
    System.out.println("Enter account holder: ");
    String nome = sc.nextLine();

    Bank bank = new Bank(numeroConta, nome);
    System.out.print("Is there an initial deposit (y/n)? ");
    String opcao = sc.nextLine();
    System.out.println();
    System.out.println("Account data:");

    System.out.println(bank.toString());
    System.out.println();
    if (opcao.equals("y")) {  // Utilize .equals() para comparar strings
      System.out.print("Enter a deposit value: ");
      double deposito = sc.nextDouble();
      bank.depositoNaConta(deposito);
    }

    System.out.print("Enter a withdraw value: ");
    double saqueNaConta = sc.nextDouble();
    bank.saqueNaConta(saqueNaConta);
    System.out.println("Updated account data:");
    System.out.println(bank.toString());

    sc.close();
  }
}
