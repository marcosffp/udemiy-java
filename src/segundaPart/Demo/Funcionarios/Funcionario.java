package segundaPart.Demo.Funcionarios;

public class Funcionario {
  private Integer id;
  private String nome;
  private double salario;

  public Funcionario(String nome, double salario, Integer id) {
    this.id = id;
    this.nome = nome;
    this.salario = salario;
  }
  
  public void mudancaSalario(double porcentagem) {
    salario += salario * (porcentagem / 100);
  }

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public double getSalario() {
    return salario;
  }
  
}
