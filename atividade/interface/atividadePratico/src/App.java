import entities.Contrato;
import entities.Parcela;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import services.ServicoContrato;
import services.ServicoPaypal;

public class App {
  private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public static void main(String[] args) throws Exception {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    System.out.println("Entre os dados do contrato: ");

    System.out.print("Numero: ");
    Integer numero = sc.nextInt();

    // Consumir a nova linha pendente
    sc.nextLine();

    System.out.print("Data: ");
    String dataString = sc.nextLine();
    LocalDate data = LocalDate.parse(dataString, fmt);

    System.out.print("Valor do contrato: ");
    double totalValor = sc.nextDouble();

    System.out.print("Número de parcelas: ");
    int numeroParcela = sc.nextInt();

    // Inicializar o array de parcelas
    Parcela[] parcelas = new Parcela[numeroParcela];

    // Criação do contrato com o array de parcelas vazio
    Contrato contrato = new Contrato(numero, data, totalValor, parcelas);

    // Serviço de contrato e processamento
    ServicoContrato servicoContrato = new ServicoContrato(new ServicoPaypal());
    servicoContrato.processsarContrato(contrato, numeroParcela);

    // Exibição das parcelas
    System.out.println("Parcelas: ");
    for (int i = 0; i < numeroParcela; i++) {
      System.out.println(
          contrato.getParcelas()[i].getDataVencimento().format(fmt)
              + " - "
              + contrato.getParcelas()[i].getQuantia());
    }

    sc.close();
  }
}
