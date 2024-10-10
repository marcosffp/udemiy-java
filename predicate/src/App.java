import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) throws Exception {
    List<Product> list = new ArrayList<>();

    list.add(new Product("TV", 900.00));
    list.add(new Product("Mouse", 50.00));
    list.add(new Product("Tablet", 350.50));
    list.add(new Product("HD Case", 80.90));

    double min = 100.0;

    list.removeIf(p -> p.getPrice() >= min);
    for (Product product : list) {
      System.out.println(product);
    }
  }
}
