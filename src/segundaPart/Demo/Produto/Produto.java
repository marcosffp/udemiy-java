package segundaPart.Demo.Produto;

public class Produto {
  private String nome;
  private double price;

  public Produto(String nome, double price) {
    this.nome = nome;
    this.price = price;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getPrice() {
    return price;
  }
}
