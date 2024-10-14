package services;

public class ServicoPaypal implements ServicoOnlinePagamento {

  // Juros simples por mês (1% por mês)
  public double juros(double quantia, Integer meses) {
    return quantia * 0.01 * meses;
  }

  // Taxa de pagamento fixa (2% por parcela)
  public double taxaPagamento(double quantia) {
    return quantia * 0.02;
  }
}
