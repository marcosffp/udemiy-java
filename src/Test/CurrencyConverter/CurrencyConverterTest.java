package Test.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;
import Demo.CurrencyConverter.CurrencyConverter;

public class CurrencyConverterTest {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.print("Whait is the dollar price? ");
    double cotacao = sc.nextDouble();
    CurrencyConverter.definirCotacao(cotacao);
    System.out.print("How many dollars will be bought? ");
    double valor = sc.nextDouble();
    CurrencyConverter.conversaoDolarParaReais(valor);
    System.out.printf("Amount to be paid in reais = %.2f%n",CurrencyConverter.conversaoDolarParaReaisComIof());

    sc.close();
  }
}
