package ex03_Rectangle;

public class MainWrapper {

  public static void main(String[] args) {
    
    // 정사각형 만들기
    Square s1 = new Square();
    s1.setWidth(5);
    s1.setHeigth(5);
    s1.info();
    
    // 정사각형 만들기 -> 더 안전하게 만들 수 있는 코드
    Square s2 = new Square(6);  // 너비 6, 높이 6인 정사각형
    s2.info();
    

  }

}
