import java.util.function.Predicate;

public class ProdutoPredicate implements Predicate<Product> {
    @Override
    public boolean test(Product p) {
        return p.getPrice() >= 100;
    }
  
}
