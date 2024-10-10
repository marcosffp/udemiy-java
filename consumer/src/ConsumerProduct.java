import java.util.function.Consumer;

public class ConsumerProduct implements Consumer<Product> {
  @Override
  public void accept(Product p) {
    p.setPrice(p.getPrice() * 1.1);
  }
  
}
