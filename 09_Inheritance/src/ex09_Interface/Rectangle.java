package ex09_Interface;

/*
 * 클래스 상속 vs 인터페이스 구현 구분하기
 * 
 * 1. 클래스는 클래스를 상속받는다.
 *    public class Person { }
 *    public class Student extends Person{ }
 * 2. 인터페이스를 구현한다.
 *    public interface Shape{ }
 *    public class Rectangle implements Shape{ }
 */

// 추상 클래스의 서브 클래스는 "반드시" 추상 메소드를 오버라이드 해야 한다.
//double getArea(); 
public class Rectangle implements Shape {
  
  private int width;
  private int height;
  
  public Rectangle(int width, int height) {
    this.width = width;
    this.height = height;
  }
  
  
  // 인터페이스를 구현한 클래스는 "반드시" 추상 메소드를 오버라이드 해야 한다.
  @Override
  public double getArea() {
    return width * height;
  }
  
  
  
}
