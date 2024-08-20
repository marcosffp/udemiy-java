package main;

import demo.Conta;
import demo.ContaEmpresarial;
import demo.SvingsConta;

public class App {
public static void main(String[] args) {
    Conta acc = new Conta(1001, "Alex", 0.0);
    ContaEmpresarial bacc = new ContaEmpresarial(1002, "Maria", 0.0, 500.0);

    // Upcasting
    Conta acc1 = bacc;
    Conta acc2 = new ContaEmpresarial(1004, "Bob", 0.0, 200.0);
    Conta acc3 = new SvingsConta(1004, "aNNA", 0.0, 0.01);

    // Downcasting
    ContaEmpresarial acc4 = (ContaEmpresarial) acc2;
    acc4.loan(100.0);

    // ContaEmpresarial acc5 = (ContaEmpresarial) acc3;
    if (acc3 instanceof ContaEmpresarial) {
      ContaEmpresarial acc5 = (ContaEmpresarial) acc3;
      acc5.loan(200.0);
      System.out.println("loan!");
    }
    if (acc3 instanceof SvingsConta) {
      SvingsConta acc5 = (SvingsConta) acc3;
      acc5.updateBalance();
      System.out.println("update");
    }
  }
}
