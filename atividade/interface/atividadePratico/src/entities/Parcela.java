package entities;

import java.time.LocalDate;

public class Parcela {
  private LocalDate dataVencimento;
  private double quantia;
  
  public Parcela(LocalDate dataVencimento, double quantia) {
    this.dataVencimento = dataVencimento;
    this.quantia = quantia;
  
  }

  public LocalDate getDataVencimento() {
    return dataVencimento;
  }

  public void setDataVencimento(LocalDate dataVencimento) {
    this.dataVencimento = dataVencimento;
  }

  public double getQuantia() {
    return quantia;
  }

  public void setQuantia(double quantia) {
    this.quantia = quantia;
  }

}
