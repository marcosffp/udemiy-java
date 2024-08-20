package main;

import demo.Funcionario;
import demo.FuncionarioTerceirizado;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    List<Funcionario> funcionarios = new ArrayList<>();

    System.out.print("Insira o número de funcionários: ");
    int numeroFuncionario = sc.nextInt();

    for (int i = 1; i <= numeroFuncionario; i++) {
      System.out.println("Dados do funcionário n°" + i + ":");
      System.out.print("Terceirizado (s/n): ");
      char isSimNao = sc.next().charAt(0);
      System.out.print("Nome: ");
      sc.nextLine();
      String nome = sc.nextLine();
      System.out.print("Horas: ");
      Integer horas = sc.nextInt();
      System.out.print("Valor por horas: ");
      double valorPorHora = sc.nextDouble();

      if (isSimNao == 's') {
        System.out.print("Custo adiconal: ");
        double adicionalTaxa = sc.nextDouble();
        Funcionario funcionario =
            new FuncionarioTerceirizado(nome, horas, valorPorHora, adicionalTaxa);
        funcionarios.add(funcionario);
      } else {
        Funcionario funcionario = new Funcionario(nome, horas, valorPorHora);
        funcionarios.add(funcionario);
      }
    }
    System.out.println();
    System.out.println("Pagamentos");
    for (Funcionario funcionario : funcionarios) {
      System.out.println(
          funcionario.getNome() + " $" + String.format("%.2f", funcionario.pagamento()));
    }

    sc.close();
  }
}
