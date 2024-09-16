import business.entities.AluguelCarro;
import business.entities.Veiculo;
import business.service.ServicoAluguel;
import business.service.TaxaServicoBrasil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class App {
  private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

  public static void main(String[] args) throws Exception {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.println("Entre com os dados do aluguel");
    System.out.print("Nome do modelo do carro: ");
    String modelo = sc.nextLine();
    System.out.print("Retirada (dd/MM/aaaa hh:mm): ");
    String dataRetirada = sc.nextLine();
    LocalDateTime dataInicio = LocalDateTime.parse(dataRetirada, fmt);
    System.out.print("Retorno (dd/MM/aaaa hh:mm): ");
    String dataRetorno = sc.nextLine();
    LocalDateTime dataFim = LocalDateTime.parse(dataRetorno, fmt);

    AluguelCarro cr = new AluguelCarro(dataInicio, dataFim, new Veiculo(modelo));

    System.out.println("Entre com o preco por hora: ");
    double precoPorHora = sc.nextDouble();
    System.out.println("Entre com o preco por dia: ");
    double precoPorDia = sc.nextDouble();

    ServicoAluguel servicoAluguel = new ServicoAluguel(precoPorHora, precoPorDia, new TaxaServicoBrasil());
    servicoAluguel.processarFatura(cr);

    System.out.println("Fatura");
    System.out.println("Pagamento basico: " + cr.getPagamento().getBasicPaymente());
    System.out.println("Imposto: " + cr.getPagamento().getTax());
    System.out.println("Pagemtno total: "+cr.getPagamento().getTtoalPagamento());

    sc.close();
  }
}
