package Demo.Triangle;

public class Triangle {
  public double lado1;
  public double lado2;
  public double lado3;

  public double areaDoTriangulo() {
    double p = (lado1 + lado2 + lado3) / 2.0;
    return Math.sqrt(p * (p - lado1) * (p - lado2) * (p - lado3));
  }
}
