package demo;

public abstract class Taypayer {
  private String name;
  private double anualIncome;

  public Taypayer(){}
  public Taypayer(String name, double anualIncome) {
    this.name = name;
    this.anualIncome = anualIncome;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public double getAnualIncome() {
    return anualIncome;
  }

  public void setAnualIncome(double anualIncome) {
    this.anualIncome = anualIncome;
  }

  public abstract double tax();
}
