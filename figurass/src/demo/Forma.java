package demo;

public abstract class Forma {
  Color color;

  public Forma() {}

  public Forma(Color color) {
    this.color = color;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public abstract double area();
}
