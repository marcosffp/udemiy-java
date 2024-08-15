package Enumeracao.Pedido;

import java.util.Date;

public class Pedido {
  private Integer id;
  private Date momento;
  private StatusPedido status;

  public Pedido() {}

  public Pedido(Integer id, Date momento, StatusPedido status) {
    this.id = id;
    this.momento = momento;
    this.status = status;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setMomento(Date momento) {
    this.momento = momento;
  }

  public Date getMomento() {
    return momento;
  }

  public void setStatus(StatusPedido status) {
    this.status = status;
  }

  public StatusPedido getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return "Pedido [id=" + id + ", momento=" + momento + ", status=" + status + "]";
  }
}
