package Demo.CurrencyConverter;
public class CurrencyConverter {

  public static double cotacao;
  public static double valorSemIOF;
  public static double IOF = 1.06;

    public static void definirCotacao(double novaCotacao) {
        cotacao = novaCotacao;
    }


    public static double conversaoDolarParaReais(double valorDolares) {
      valorSemIOF=valorDolares * cotacao;
      return valorSemIOF;
    }
    
    public static double conversaoDolarParaReaisComIof() {
      return valorSemIOF * IOF;
    }
}
