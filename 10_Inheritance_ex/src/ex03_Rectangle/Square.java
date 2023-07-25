package ex03_Rectangle;

// 정사각형은 사격형이다. 

public class Square extends Rectangle  {
  
  // 필더 필요 없음 - setter, getter도 필요 없음
  
  //new Square()
  public Square() {   // 텅빈 객체.. 
    super();
 }
  
  //new Square(6)
  public Square(int width) { // 너비, 높이 같으니까 하나만 받아도 괜춘
   super(width, width); // new Square(6, 6)
   
 }

  @Override // 이너테이션
 public void info() {
   System.out.println("너비 : " + getWidth() + " 높이 : " + getHeigth() + " 넓이 : " + getArea());
 }
}
