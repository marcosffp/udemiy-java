package demo;

public class ContaEmpresarial extends Conta{
  private double loanLimit;

  public ContaEmpresarial(Integer number, String holder, double balance, double loanLimit) {
    super(number, holder, balance);
    this.loanLimit = loanLimit;
  }

  public ContaEmpresarial() {
    super();
  }

  public double getLoanLimit() {
    return loanLimit;
  }

  public void setLoanLimit(double loanLimit) {
    this.loanLimit = loanLimit;
  }

  public void loan(double amount) {
    if (amount <= loanLimit) {
      deposit(amount);
    }
  }
  
  @Override
  public void withdraw(double amount) {
    super.withdraw(amount);
    balance -= 2.0;
  }
}
