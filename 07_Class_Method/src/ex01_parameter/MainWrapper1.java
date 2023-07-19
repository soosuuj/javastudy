package ex01_parameter;

import java.util.Arrays;

public class MainWrapper1 {

  /*
   * 1. 인수(Argument)
   *    1) 메소드에게 전달하는 값을 의미한다.
   *    2) 메소드를 호출할 때 전달할 수 있다.
   * 2. 파라미터(Parameter)
   *    1) 인수를 받아서 저장하는 변수이다.
   *    2) 매개변수라고도 한다.
   */
  
  public static void main(String[] args) {
    ex01();  // 괄호 안 인수가 없는 경우
    ex02(10);  // 인수가 정수 1개인 경우
    ex03(1.5, 1.2);    // 인수가 실수 2개인 경우
    ex04("홍길동", 30);  // 인수가 문자열 1개와 정수 1개인 경우
    int[] a = {10, 20, 30}; 
    ex05(a);   //인수가 배열 1개인 경우
  }
  public static void ex05(int[] arr) {  // 인수가 배열 1개이면 파라미터 int[] arr을 선언한다. 여기서 배열이름은 아무 이름이나 사용해도 상관없다.
    // 보내는 이름 a, 받는 이름 arr 이름은 달라도, 같아도 상관 없음
    //이름은 중요하지 않고, 타입(종류)가 중요하다.
   System.out.println("ex05 : " + Arrays.toString(arr)); // 매개변수 이름이 arr이니까 요걸로 호출
  }
  
  public static void ex04(String name, int age) {  //문자열 인수는 파라미터 String name, 정수 인수는 int age
    System.out.println("ex04 : " + name);
    System.out.println("ex04 : " + age);
  }
  
  
  public static void ex03(double a, double b) { // 인수가 실수 2개이면 파라미터 double a, double b를 선언한다.
    System.out.println("ex03 : " + a);
    System.out.println("ex03 : " + b);
  }
  
  public static void ex02(int a) { // 인수가 정수 1개 이면 파라미터 int a를 선언한다.
    System.out.println("ex02 : " + a);
  }

  public static void ex01() { // 괄호 안 인수가 없으면 괄호 안 파라미터도 없다.
    System.out.println("ex01");    
  }
}
