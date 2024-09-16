package entities;

import java.time.LocalDate;

public class Contrato {
  private Integer numero;
  private LocalDate data;
  private double totalValor;
  private Parcela[] parcelas;

  public Contrato(Integer numero, LocalDate data, double totalValor, Parcela[] parcelas) {
    this.numero = numero;
    this.data = data;
    this.totalValor = totalValor;
    this.parcelas = parcelas;
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public double getTotalValor() {
    return totalValor;
  }

  public void setTotalValor(double totalValor) {
    this.totalValor = totalValor;
  }
  

public Parcela[] getParcelas() {
  return parcelas;
}

public void setParcelas(Parcela[] parcelas) {
  this.parcelas = parcelas;
}
}
