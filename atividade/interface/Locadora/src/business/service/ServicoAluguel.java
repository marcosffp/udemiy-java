package business.service;

import business.entities.AluguelCarro;
import business.entities.Fatura;
import java.time.Duration;

public class ServicoAluguel {
  private double precoPorDia;
  private double precoPorHora;

  private TaxaServico taxaServico;

  public ServicoAluguel(double precoPorDia, double precoPorHora, TaxaServico taxaServico) {
    super();
    this.precoPorDia = precoPorDia;
    this.precoPorHora = precoPorHora;
    this.taxaServico = taxaServico;
  }

  public void processarFatura(AluguelCarro aluguelCarro) {
    double minutes = Duration.between(aluguelCarro.getInicio(), aluguelCarro.getFim()).toMinutes();
    double hours = minutes / 60;

    double basicPayment;
    if (hours<=12.0) {
      basicPayment = precoPorHora * Math.ceil(hours);
    } else {
      basicPayment = precoPorDia * Math.ceil(hours / 24.0);
    }
    double tax = taxaServico.tax(basicPayment);

    aluguelCarro.setPagamento(new Fatura(basicPayment,tax));
  }
  

}
