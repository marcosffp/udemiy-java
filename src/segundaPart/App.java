package segundaPart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
  public static void main(String[] args) {

    List<String> list = new ArrayList<>();

    list.add("Maria");
    list.add("Alex");
    list.add("Anna");
    list.add("Bob");

    list.add(2, "Marcos");

    System.out.println(list.size());

    for (String string : list) {
      System.out.println(string);
    }

    System.out.println("---------------");
    list.removeIf(x -> x.charAt(0) == 'M');

    for (String string : list) {
      System.out.println(string);
    }

    System.out.println("---------------");
    System.out.println("iNDEX OF BOB: " + list.indexOf("Bob"));
    System.out.println("Index of Marcos: " + list.indexOf("Marcos"));

    List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());

    for (String string : result) {
      System.out.println(string);
    }

    System.out.println("---------------");

    String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
    System.out.println(name);
    

  }
}
