package Demo.Student;

public class Student {
  public String nome;
  public double primeiraNota;
  public double segundaNota;
  public double terceiraNota;

  public double notaFinal() {
    return primeiraNota + segundaNota + terceiraNota;
  }

  public void aprovacaoDoAluno() {
    double notaBase;
    if (notaFinal() > 60.0) {
      System.out.println("PASS");
    } else {
      System.out.println("FAILED");
      notaBase = 60 - notaFinal();
      System.out.printf("MISSING %.2f POINTS%n",notaBase);
    }
  }
}
