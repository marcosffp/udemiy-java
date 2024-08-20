package demo;

public class FuncionarioTerceirizado extends Funcionario {
  private double adicionalTaxa;

  public FuncionarioTerceirizado() {}

  public FuncionarioTerceirizado(
      String nome, Integer horas, double valorPorHora, double adicionalTaxa) {
    super(nome, horas, valorPorHora);
    this.adicionalTaxa = adicionalTaxa;
  }

  public double getAdicionalTaxa() {
    return adicionalTaxa;
  }

  public void setAdicionalTaxa(double adicionalTaxa) {
    this.adicionalTaxa = adicionalTaxa;
  }

  @Override
  public double pagamento() {
    return super.pagamento() + adicionalTaxa * 1.1;
  }
}
