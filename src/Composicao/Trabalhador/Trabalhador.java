package Composicao.Trabalhador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Composicao.ContratoHora.ContratoHora;
import Composicao.Departamento.Departamento;
import Composicao.NivelDeTrabalhador.NivelDeTrabalhador;

public class Trabalhador {
  private String nomeTrabalhador;
  private NivelDeTrabalhador nivelDeTrabalhador;
  private double salarioBase;

  private Departamento departamento;
  private List<ContratoHora> contratos=new ArrayList<>();


  public Trabalhador() {

  }
  
  public Trabalhador(String nomeTrabalhador, NivelDeTrabalhador nivelDeTrabalhador, double salarioBase,
      Departamento departamento) {
    this.nomeTrabalhador = nomeTrabalhador;
    this.nivelDeTrabalhador = nivelDeTrabalhador;
    this.salarioBase = salarioBase;
    this.departamento = departamento;
  }
  
  public void setNomeTrabalhador(String nomeTrabalhador) {
    this.nomeTrabalhador = nomeTrabalhador;
  }

  public String getNomeTrabalhador() {
    return nomeTrabalhador;
  }
  
  public void setNivelDeTrabalhador(NivelDeTrabalhador nivelDeTrabalhador) {
    this.nivelDeTrabalhador = nivelDeTrabalhador;
  }

  public NivelDeTrabalhador getNivelDeTrabalhador() {
    return nivelDeTrabalhador;
  }

  public void setSalarioBase(double salarioBase) {
    this.salarioBase = salarioBase;
  }

  public double getSalarioBase() {
    return salarioBase;
  }

  public void setDepartamento(Departamento departamento) {
    this.departamento = departamento;
  }

  public Departamento getDepartamento() {
    return departamento;
  }

  public List<ContratoHora> getContratos() {
    return contratos;
  }

  public void adicionarContrato(ContratoHora contrato) {
    contratos.add(contrato);
  }

  public void removerContrato(ContratoHora contrato) {
    contratos.remove(contrato);
  }

  public double renda(int ano, int mes) {
    double soma=salarioBase;
    Calendar cal=Calendar.getInstance();
    for (ContratoHora contratoHora : contratos) {
      cal.setTime(contratoHora.getData());
      int contratoHora_ano=cal.get(Calendar.YEAR);
      int contratoHora_mes= 1+cal.get(Calendar.MONTH);
      if (ano==contratoHora_ano&&mes==contratoHora_mes) {
        soma+=contratoHora.totalValor();
      }
    }
    return soma;
  }

}
