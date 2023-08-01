package ex04_catch;

public class MainWrapper {
  
  public static void ex01() {
    
    try {
      
      // 1. java가 발생시킨 예외    -> 자바가 메세지 만들어줌
      // int a = 5 / 0;
      // System.out.println(a);
      
      // 2. 개발자가 발생시킨 예외
      throw new RuntimeException("개발자 예외"); 
        // 출력 : java.lang.RuntimeException
        // 출력 : 개발자 예외     -> 개발자가 예외 사유도 적으면 좋음, 직
      
    } catch (Exception e) {

      // 예외 객체 e가 가진 메소드
      
      // 예외 클래스 확인하기
      System.out.println(e.getClass().getName());  
                    // java.lang.ArithmeticException  ->  Exception Object의 메소드 활용
    
      // 예외 메시지 확인하기(예외가 발생한 이유)
      System.out.println(e.getMessage());  // / by zero -> java가 적어준 예외 사유
         // -> getMessage 메세지 확인은 이걸로
      
      
    }
  }

  public static void ex02(String name) {
    
    // 예외 처리란?????? try 안에 printStackTrace 넣어서 확인
    
    try {  
      System.out.println(name.substring(0, 1));
    }catch (Exception e) {
      //System.out.println("예외처리");
      e.printStackTrace();    // 예외 추적 메시지를 출력하는 메소드 (개발 중에는 이것만 사용한다.)
    }
    
  }
  
  public static void main(String[] args) {
    //ex01();
    ex02(null);
    
  }

}
