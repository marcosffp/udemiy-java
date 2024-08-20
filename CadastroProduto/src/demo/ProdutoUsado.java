package demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {
  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  private Date dataManufaturado;

  public ProdutoUsado() {}

  public ProdutoUsado(String nome, double preco, Date dataManufaturado) {
    super(nome, preco);
    this.dataManufaturado = dataManufaturado;
  }

  public Date getDataManufaturado() {
    return dataManufaturado;
  }

  public void setDataManufaturado(Date dataManufaturado) {
    this.dataManufaturado = dataManufaturado;
  }

  @Override
  public String precoTag() {
    StringBuilder sb = new StringBuilder();
    sb.append(
        getNome()
            + " (usado) $ "
            + String.format("%.2f", getPreco())
            + " (Data de fabricação: "
            + sdf.format(dataManufaturado)
            + ")"
            + "\n");
    return sb.toString();
  }
}
