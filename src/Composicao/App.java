package Composicao;

import Composicao.ContratoHora.ContratoHora;
import Composicao.Departamento.Departamento;
import Composicao.NivelDeTrabalhador.NivelDeTrabalhador;
import Composicao.Trabalhador.Trabalhador;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws ParseException {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

    System.out.print("Entra com o nome do departamento: ");
    String nomeDepartamento = sc.nextLine();
    System.out.println("Entra com os dados do trabalhador");
    System.out.print("Nome: ");
    String nomeTrabalhador = sc.nextLine();
    System.out.print("Nível de Trabalhador: ");
    String nivelDeTrabalhador = sc.nextLine();
    System.out.println("Salário base: ");
    double salarioBase = sc.nextDouble();

    Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelDeTrabalhador.valueOf(nivelDeTrabalhador),
        salarioBase, new Departamento(nomeDepartamento));

    System.out.println("Quantos contratos o trabalhador vai ter? ");
    int quantidadeContratos = sc.nextInt();

    for (int i = 1; i <= quantidadeContratos; i++) {
      System.out.println("Dados do primeiro contrato #" + i + " data");
      System.out.print("Data (DD/MM/AAAA): ");
      Date dataContrato = sdf.parse(sc.next());
      System.out.print("Valor de horas: ");
      double valorPorHora = sc.nextDouble();
      System.out.print("Duração (horas): ");
      Integer horas = sc.nextInt();

      ContratoHora contratoHora = new ContratoHora(dataContrato, valorPorHora, horas);
      trabalhador.adicionarContrato(contratoHora);

    }
    
    System.out.println();
    System.out.println("Entre com o mês e o ano para calcular a renda (MM/AAAA): ");
    String mesEAno = sc.next();
    int mes = Integer.parseInt(mesEAno.substring(0, 2));
    int ano = Integer.parseInt(mesEAno.substring(3));

    System.out.println("Nome: " + trabalhador.getNomeTrabalhador());
    System.out.println("Departamento: " + trabalhador.getDepartamento().getNomeDepartamento());
    System.out.println(
        "Renda é: " + mesEAno + " :" + String.format("%.2f", trabalhador.renda(ano, mes)));
    sc.close();
  }
}
