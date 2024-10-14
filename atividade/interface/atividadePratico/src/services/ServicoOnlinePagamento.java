package services;

public interface ServicoOnlinePagamento {

  public double taxaPagamento(double quantia);

  public double juros(double quantia, Integer meses);
  
} 
