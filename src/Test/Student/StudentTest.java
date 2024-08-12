package Test.Student;

import java.util.Locale;
import java.util.Scanner;

import Demo.Student.Student;

public class StudentTest {
  public static void main(String[] args) {
     Locale.setDefault(Locale.US);
     Scanner sc = new Scanner(System.in);

     Student student = new Student();
     student.nome = sc.nextLine();
     student.primeiraNota = sc.nextDouble();
     student.segundaNota = sc.nextDouble();
     student.terceiraNota = sc.nextDouble();

     System.out.printf("FINAL GRADE: %.2f%n",student.notaFinal());
     student.aprovacaoDoAluno();

     sc.close();
  }
}
