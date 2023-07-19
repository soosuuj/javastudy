package ex04_field;

public class MainWrapper {

  public static void main(String[] args) {
    // AccCalculator 객체 선언 & 생성
    AccCalculator myAcc = new AccCalculator();  
    //클래스를 기반으로 객체 만들기! /AccCalculator(클래스 타입 ) = myAcc(객체) 
    
    //value 확인
    myAcc.showValue(); //myAcc(객체)를 이용해서 메소드 호출 -> 0.0 
    
    // 사칙연산
    myAcc.addition(3);       // +3
    myAcc.substraction(2);   // -2
    myAcc.multiplication(3); // *3
    myAcc.division(2);       // /2
    
    // value 확인 -> 값 확인
    myAcc.showValue();
    
  }

}
