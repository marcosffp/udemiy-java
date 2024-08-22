package demo;

public class Individual extends Taypayer {
  private double healthExpenditures;

  public Individual(String name, double anualIncome, double healthExpenditures) {
    super(name, anualIncome);
    this.healthExpenditures = healthExpenditures;
  }

  public double getHealthExpenditures() {
    return healthExpenditures;
  }

  public void setHealthExpenditures(double healthExpenditures) {
    this.healthExpenditures = healthExpenditures;
  }

  @Override
  public double tax() {
    double baseTax;

    if (getAnualIncome() < 20000.0) {
      baseTax = getAnualIncome() * 0.15;
    } else {
      baseTax = getAnualIncome() * 0.25;
    }

    baseTax -= healthExpenditures * 0.5;

    return baseTax;
  }
}
