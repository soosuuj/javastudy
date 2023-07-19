package ex03_Class;

/**
 * 
 * 실수의 덧셈, 뺄셈, 곱셈, 나눗셈 기능을 제공하는 계산기 클래스
 * 
 * @author 홍길동
 * @since 2023.07.19
 * @version 1.0.0
 * 
 */
public class Calculator { 
  // 클레스 안에 메소드 넣음 -> 메소드 호출을 원하면 
  //-> 클래스를 먼저 변수로 만들어야함(클래스를 메모리에 얹어야한다 - 객체화 작업) - "객체를 만들고", 호출 
  // Calculator - 메소드까지만든건 설계도(클래스)까지 만든것, 요 설계도를 가지고 계산기(객채)를 만들어야함
  // 클래스를 보고 객체를 만든다.
  
  /**
   * 
   * 실수 2개를 전달 받아서 덧셈 결과를 반환하는 메소드
   * 
   * @param a 실수
   * @param b 실수
   * @return  파라미터 2개의 덧셈 결과
   * 
   */
  public double addition(double a, double b) {
    return a + b;
  }
  
  /**
   * 
   * 실수 2개를 전달 받아서 뺼셈 결과를 반환하는 메소드
   *
   * @param a 실수
   * @param b 실수
   * @return  파라미터 2개의 뺼셈 결과
   */
  public double subtraction(double a, double b) {
    return a - b;
  }
  
  /**
   * 
   * 실수 2개를 전달 받아서 곱셈 결과를 반환하는 메소드
   * 
   * @param a 실수
   * @param b 실수
   * @return  파라미터 2개의 곱셈 결과
   */
  public double multiplication(double a, double b) {
    return a * b;
  }
  
  /**
   * 
   * 실수 2개를 전달 받아서 나눗셈 결과를 반환하는 메소드
   * 
   * @param a 실수
   * @param b 실수
   * @return  파라미터 2개의 나눗셈 결과
   */
  public double division(double a, double b) {
    return a / b;
  }
  
}
