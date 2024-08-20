package demo;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Ordem {
  private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
  private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
  private Date momento;
  private StatusPedido statusPedido;
  private List<ItemPedido> itemPedidos = new ArrayList<>();
  private Cliente cliente;

  public Ordem() {}

  public Ordem(Date momento, StatusPedido statusPedido, Cliente cliente) {
    this.setMomento(momento);
    this.setStatusPedido(statusPedido);
    this.setCliente(cliente);
  }

  public Date getMomento() {
    return momento;
  }

  public void setMomento(Date momento) {
    this.momento = momento;
  }

  public StatusPedido getStatusPedido() {
    return statusPedido;
  }

  public void setStatusPedido(StatusPedido statusPedido) {
    this.statusPedido = statusPedido;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public void addItem(ItemPedido itemPedido) {
    itemPedidos.add(itemPedido);
  }

  public void removeItem(ItemPedido itemPedido) {
    itemPedidos.remove(itemPedido);
  }

  public double total() {
    double soma = 0.0;
    for (ItemPedido itemPedido : itemPedidos) {
      soma += itemPedido.subTotal();
    }
    return soma;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Ordem sumário\n");
    sb.append("Momento da ordem: " + sdf.format(momento) + "\n");
    sb.append("Status da ordem: " + statusPedido.name() + "\n");
    sb.append("Cliente: " + cliente.getNome() + " (" + sdf2.format(cliente.getDataAniversario()) + ") - "
        + cliente.getEmail() + "\n");
    sb.append("Ordem dos itens:\n");
    for (ItemPedido itemPedido : itemPedidos) {
      sb.append(itemPedido.getProduto().getNome() + ", " + itemPedido.getPreco() + ", Quantidade: "
          + itemPedido.getQuantidade() + ", Subtotal: " + String.format("%.2f", itemPedido.subTotal()));
    }
    return sb.toString();
  }
}
