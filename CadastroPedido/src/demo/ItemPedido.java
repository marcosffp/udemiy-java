package demo;

public class ItemPedido {
  private Integer quantidade;
  private double preco;

  private Produto produto;

  public ItemPedido() {}

  public ItemPedido(Integer quantidade, double preco, Produto produto) {
    this.setQuantidade(quantidade);
    this.setPreco(preco);
    this.setProduto(produto);
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public double subTotal() {
    return quantidade * preco;
  }
}
