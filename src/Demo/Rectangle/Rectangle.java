package Demo.Rectangle;

public class Rectangle {
  public double width;
  public double height;

  public double areaDoRetangulo() {
    return this.height * this.width;
  }

  public double perimetroDoRetangulo() {
    return (this.height * 2) + (this.width * 2);
  }

  public double diagonalDoRetangulo() {
    return Math.sqrt((height * height) + (width * width));
  }

  public String toString() {
    return "AREA = "
        + String.format("%.2f", areaDoRetangulo())
        + "\n"
        + "PERIMETER = "
        + String.format("%.2f", perimetroDoRetangulo())
        + "\n"
        + "DIAGONAL = "
        + String.format("%.2f", diagonalDoRetangulo());
  }
}
