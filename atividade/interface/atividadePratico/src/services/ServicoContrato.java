package services;

import entities.Contrato;
import entities.Parcela;
import java.time.LocalDate;

public class ServicoContrato {

  private ServicoOnlinePagamento servicoOnlinePagamento;

  public void processsarContrato(Contrato contrato, Integer meses) {
    Parcela[] parcelas = new Parcela[meses];
    LocalDate dataContrato = contrato.getData();
    double valorBaseParcela = contrato.getTotalValor() / meses;

    for (int i = 0; i < meses; i++) {
      // Calcular a data de vencimento da parcela
      LocalDate dataVencimento = dataContrato.plusMonths(i + 1);

      // Calcular juros e taxa de pagamento para o mês atual
      double juros = servicoOnlinePagamento.juros(valorBaseParcela, i + 1);
      double taxa = servicoOnlinePagamento.taxaPagamento(valorBaseParcela);

      // Quantia final da parcela (com juros e taxa)
      double quantia = valorBaseParcela + juros + taxa;

      // Inicializar a parcela com data de vencimento e quantia
      parcelas[i] = new Parcela(dataVencimento, quantia);
    }

    // Atualizar o contrato com o array de parcelas
    contrato.setParcelas(parcelas);
  }

  public ServicoContrato(ServicoOnlinePagamento servicoOnlinePagamento) {
    this.servicoOnlinePagamento = servicoOnlinePagamento;
  }
}
