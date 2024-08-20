package demo;

public class Produto {
  private String nome;
  private double preco;

  public Produto() {}

  public Produto(String nome, double preco) {
    this.nome = nome;
    this.preco = preco;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public String precoTag() {
    StringBuilder sb = new StringBuilder();
    sb.append(nome + " $ " + String.format("%.2f", preco) + "\n");
    return sb.toString();
  }
}
