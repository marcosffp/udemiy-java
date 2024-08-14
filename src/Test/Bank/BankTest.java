package Test.Bank;

import Demo.Bank.Bank;
import java.util.Locale;
import java.util.Scanner;

public class BankTest {
  public static void main(String[] args) {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    Bank bank;

    System.out.print("Enter account number: ");
    int numeroConta = sc.nextInt();

    sc.nextLine();
    
    System.out.print("Enter account holder: ");
    String nome = sc.nextLine();

    System.out.print("Is there an initial deposit (y/n)? ");
    char opcao = sc.next().charAt(0);
    
    if (opcao=='y') {  
      System.out.print("Enter initial deposit value: ");
      double deposito = sc.nextDouble();
      bank = new Bank(numeroConta, nome, deposito);
    } else {
      bank = new Bank(numeroConta, nome);
    }

    System.out.println();
    System.out.println("Account data: ");
    System.out.println(bank.toString());
    System.out.println();

    System.out.print("Enter a deposit value: ");
    double depositoNaConta = sc.nextDouble();
    bank.depositoNaConta(depositoNaConta);

    System.out.println("Updated account data:");
    System.out.println(bank.toString());

    System.out.print("Enter a withdraw value: ");
    double saqueNaConta = sc.nextDouble();
    bank.saqueNaConta(saqueNaConta);
    
    System.out.println("Updated account data:");
    System.out.println(bank.toString());

    sc.close();
  }
}
