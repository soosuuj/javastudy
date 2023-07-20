package ex06_this;

/*
 * this (현재 객체를 의미 - 객체 참조 값)
 * 1. 필드나 메소드를 호출하는 객체의 참조값이다.
 * 2. 클래스 내부에서만 사용할 수 있는 키워드이다.
 */


/**
 * <p>메소드를 연속해서 호출할 수 있는 메소드 체이니(method chaining)이 가능한 계산기</p>
 * <p>사칙연산 메소드를 연속해서 호출할 수 있다.</p>
 * @author 홍길동
 * @since 2023.07.20
 * @version 1.0
 */
public class ChainCalculator {

  /**
   *  필드 value는 사칙연산 결과를 저장하고 있다.
   */
  private double value;
  
  public void printThis() {
    System.out.println("현재 객체(printThis 메소드를 호출한 객체)의 참조값 : " + this); // 결과 : ex06_this.ChainCalculator@6f2b958e
  }
  
  // Setter   -> 블로그 day17참고
  public void setValue(double value) {  //param 은 너무 일반적이라 의미 전달이 안되기 때문에 쓰지 않음, value 가 전달 되면 value로 받음..
    this.value = value; // value = value; 필드 value로 값을 보내지 못함 my.Calc.setValue(100);
  }
  
  //Getter
  public double getValue() {
    return value;
  }
  
  public ChainCalculator on() {
    System.out.print(value);
    return this;
  }
  
  public ChainCalculator addition(double a) {
    value += a;
    System.out.print("+" + a);
    return this;
  }
  
  public ChainCalculator subtraction(double a) {
    value -= a;
    System.out.print("-" + a);
    return this;
  }
  
  public ChainCalculator multiplication(double a) {
    value *= a;
    System.out.print("*" + a);
    return this;
  }
  
  public ChainCalculator division(double a) {
    value /= a;
    System.out.print("/" + a);
    return this;
  }
  
  public void done() {
    System.out.println("=" + value);
  }
  
  
  
}
