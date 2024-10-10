import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class App {
  public static void main(String[] args) throws Exception {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

    Stream<Integer> stream = list.stream().map(i -> i * 2);
    System.out.println(Arrays.toString(stream.toArray()));

    Stream<String> stream2 = Stream.of("Maria", "Alex", "Bob");
    System.out.println(Arrays.toString(stream2.toArray()));

    Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
    System.out.println(Arrays.toString(stream3.limit(10).toArray()));

    Stream<Long> stream4 = Stream.iterate(new long[] { 0L, 1L }, p -> new long[] { p[1], p[0] + p[1] }).map(p -> p[0]);
  }
}
