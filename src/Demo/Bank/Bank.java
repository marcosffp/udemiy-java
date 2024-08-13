package Demo.Bank;

public class Bank {
  private int numeroConta;
  private String nome;
  private double saldoConta;

  public static final double TAXA = 5.00;

  public Bank(int numeroConta, String nome) {
    this.numeroConta = numeroConta;
    this.nome = nome;
  }

  public int getNumeroConta() {
    return numeroConta;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void depositoNaConta(double deposito) {
    saldoConta += deposito;
  }

  public void saqueNaConta(double saqueNaConta) {
    saldoConta -= saqueNaConta - TAXA;
  }

  public double getSaldoConta() {
    return saldoConta;
  }

  public String toString() {
    return "Account "
        + getNumeroConta()
        + ", Holder: "
        + getNome()
        + ", Balance"
        + getSaldoConta();
  }
}
