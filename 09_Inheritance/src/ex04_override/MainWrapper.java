package ex04_override;

public class MainWrapper {

  public static void main(String[] args) {

    //CafeLatte 객체 선언 & 생성
    CafeLatte latte = new CafeLatte();
    
    //CafeLatte 객체 메소드
    //latte.taste();           //부모의 것
    latte.taste();             //자식의 것
    
  }

}
