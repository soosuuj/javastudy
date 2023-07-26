package ex09_Interface;

public class Circle implements Shape {

  private double radius;
  
  
  public Circle (double radius) {
    this.radius = radius;
  }
  
  @Override
  public double getArea() {
    return  PI * radius * radius;
  }

}
