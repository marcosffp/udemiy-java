package business.entities;

import java.time.LocalDateTime;

public class AluguelCarro {
  private LocalDateTime inicio;
  private LocalDateTime fim;

  private Veiculo veiculo;
  private Fatura pagamento;

  public AluguelCarro() {
    
  }

  public LocalDateTime getInicio() {
    return inicio;
  }

  public void setInicio(LocalDateTime inicio) {
    this.inicio = inicio;
  }

  public LocalDateTime getFim() {
    return fim;
  }

  public void setFim(LocalDateTime fim) {
    this.fim = fim;
  }

  public Veiculo getVeiculo() {
    return veiculo;
  }

  public void setVeiculo(Veiculo veiculo) {
    this.veiculo = veiculo;
  }

  public Fatura getPagamento() {
    return pagamento;
  }

  public void setPagamento(Fatura pagamento) {
    this.pagamento = pagamento;
  }

  public AluguelCarro(LocalDateTime inicio, LocalDateTime fim, Veiculo veiculo) {
    this.inicio = inicio;
    this.fim = fim;
    this.veiculo = veiculo;
  }

  
}
