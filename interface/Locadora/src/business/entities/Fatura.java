package business.entities;

public class Fatura {
  private double basicPaymente;
  private double tax;

  public Fatura() {
    
  }

  public Fatura(double basicPaymente, double tax) {
    this.basicPaymente = basicPaymente;
    this.tax = tax;
  }

  public double getBasicPaymente() {
    return basicPaymente;
  }

  public void setBasicPaymente(double basicPaymente) {
    this.basicPaymente = basicPaymente;
  }

  public double getTax() {
    return tax;
  }

  public void setTax(double tax) {
    this.tax = tax;
  }

  public double getTtoalPagamento() {
    return getBasicPaymente() - getTax();
  }

}
