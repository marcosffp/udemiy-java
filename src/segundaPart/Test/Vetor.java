package segundaPart.Test;

public class Vetor {
  private String nome;
  private int idade;
  private double altura;

  public Vetor(String nome, int idade, double altura) {
    this.nome = nome;
    this.idade = idade;
    this.altura = altura;
  }

  public String getNome() {
    return nome;
  }
  
  public int getIdade() {
    return idade;
  }

  public double getAltura() {
    return altura;
  }
}
