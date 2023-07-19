package ex04_field;

/**
 * 
 * 사칙연산 결과를 저장할 수 있는 계산기
 * 
 * @author 홍길동
 * @since 2023.07.19
 * @version 1.0.0
 *
 */
public class AccCalculator { // 객체 생성 main애서ㅗ 

  /*
   * 필드(field) // 객체마다 다른 값을 가질 수 있게 하는 것 - 각 이름이 다른 것을 필드에 저장한다~ 너낌
   * 1. 객체가 가질 수 있는 값을 저장할 변수
   * 2. 클래스에서 선언한다.
   * 3. 필드는 자동으로 초기화된다.(0, 0.0, false, null(모든 참조타입의 기본 값))
   * 4. 정보 은닉을 위해서 private 처리한다.
   */
  
  /**
   * 이 필드는 AccCalculator의 사칙연산 결과를<br>저장할 수 있는 필드이다. // 이필드는 html 테그로도 표현 가능하구나를 알 수 있음
   */
  private double value; 
  // 선언한 위치가 class -> field 앞에 private 써주기 value = 0; 이라는 말!!!! 모든 메소드가 접근 가능
  //값을 주면 안됨, 이미 0을 가지고 있음 
  
  /**
   * 
   * 필드 value에 파라미터 a를 더해주는 메소드
   * 
   * @param a 실수
   * 
   */
  public void addition(double a) { 
    value += a; // value = value + a; -> 복합연산, 
  }
  
  /**
   * 
   * 필드 value에 파라미터 a를 빼주는 메소드
   * 
   * @param a 실수 
   */
  public void substraction(double a) { 
    value -= a; // value = value + a; -> 복합연산, 
  }
  
  /**
   * 
   * 필드 value에 파라미터 a로 곱해주는 메소드
   * 
   * @param a 실수
   */
  public void multiplication(double a) { 
    value *= a; // value = value + a; -> 복합연산, 
  }
  /**
   * 
   * 필드 value를 파라미터 a로 나누는 메소드
   * 
   * @param a 실수
   */
  public void division(double a) { 
    value /= a; // value = value + a; -> 복합연산, 
  }
  
  
  public void showValue() { // 결과 출력
    System.out.println(value);
  }
  
  
  
  
  
  
  
  
}
