import java.util.function.Function;

public class ProductUpperCaseName implements Function<Product, String> {
  @Override
  public String apply(Product p) {
    return p.getName().toUpperCase();
  }
  
}
