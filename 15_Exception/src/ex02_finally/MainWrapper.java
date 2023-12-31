package ex02_finally;

import java.util.Scanner;

public class MainWrapper {

  // finally 블록
  // 1. try - catch문의 마지막 블록으로 추가할 수 있다. (생략 가능)
  // 2. 예외 발생 여부와 상관 없이 "항상 마지막"에 무조건 실행된다.
  
  // 추가)  { scope 범위 } -> 중괄호 안에서만 사용 가능
  // 변수의 라이프 사이클, 어떤 변수에서 이 범위를 쓸 수 있는지
  
  
  public static void main(String[] args) {
   // 나이를 입력 받아서 "주류 구매 가능", "주류 구매 불가능" 출력하기
   // 예외처리
    
    // try 블록과 finally 블록에서 모두 사용할 수 있도록 scope 조정
    Scanner sc = null;    // 객체 선언만한 것 , null로 초기값 잡아줌
                   //sc가 선언된 중괄호  main(String[] args) { <- 요기 중괄호부터 닫히는 곳까지
    
    try {
      sc = new Scanner(System.in); // 객체 생성 Scanner sc = new Scanner(System.in); 
      System.out.println("몇 살이세요?");
      int age = sc.nextInt();
      System.out.println(age >= 20 ? "주류 구매 가능" : "주류 구매 불가능");
      //sc.close();                 // 예외 발생 시 이 코드 작동 안됨

    } catch (Exception e) {
      System.out.println("잘모르겠어요");
    } finally {
      sc.close();  // finally는 주로 자원 반납용으로 사용한다.
    }
  
  }

}
