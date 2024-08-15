package segundaPart.Test.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import segundaPart.Demo.Funcionarios.Funcionario;

public class App {
  public static void main(String[] args) {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    System.out.print("How many employees will be rigistered? ");
    int n = sc.nextInt();
    sc.nextLine();
    System.out.println();

    List<Funcionario> list = new ArrayList<>();
    int cont = 1;

    for (int i = 0; i < n; i++) {
      System.out.println("Emplyoee #" + cont++ + ":");
      System.out.print("Id: ");
      Integer id = sc.nextInt();
      sc.nextLine();
      System.out.print("Nome: ");
      String nome = sc.nextLine();
      System.out.print("Salário: ");
      double salario = sc.nextDouble();
      sc.nextLine();
      System.out.println();

      Funcionario funcionario = new Funcionario(nome, salario, id);
      list.add(funcionario);

    }

    System.out.println("Enter the employee id that will have salary increase: ");
    int idsalary = sc.nextInt();
    Integer pos = hasId(list, idsalary);
    if (pos == null) {
      System.out.println("This id does not exist!");
    } else {
      System.out.print("Enter the percentage: ");
      double porcentagem = sc.nextDouble();
      list.get(pos).mudancaSalario(porcentagem);
    }

    System.out.println("List of employees");
    for (Funcionario funcionario : list) {
      System.out.println(funcionario.getId()+", "+funcionario.getNome()+", "+funcionario.getSalario());
    }

    sc.close();
  }
  
  public static Integer hasId(List<Funcionario> list, int id) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getId() == id) {
        return i;
      }
    }
    return null;
  }
}
