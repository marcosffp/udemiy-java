package Composicao.ContratoHora;

import java.util.Date;

public class ContratoHora {
  private Date data;
  private double valorPorHora;
  private Integer horas;

  public ContratoHora() {

  }
  
  public ContratoHora(Date data, double valorPorHora, Integer horas) {
    this.data = data;
    this.valorPorHora = valorPorHora;
    this.horas = horas;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public Date getData() {
    return data;
  }

  public void setValorPorHora(double valorPorHora) {
    this.valorPorHora = valorPorHora;
  }

  public double getValorPorHora() {
    return valorPorHora;
  }

  public void setHoras(Integer horas) {
    this.horas = horas;
  }

  public Integer getHoras() {
    return horas;
  }

  public double totalValor() {
    return valorPorHora * horas;
  }




  
}
