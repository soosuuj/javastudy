package ex02_return;

public class Mainwrapper2 {

  /*
   * void 메소드의 return -> 많이 사용되고 있으니 반드시 알아야함!!
   * 1. 반환값이 없는 메소드는 void 키워드를 사용한다.
   * 2. 이런 경우 return; 키워드를 이용해서 메소드 실행을 종료할 수 있다.
   * 3. return 키워드만 작성해야 한다.
   * 4. void 메소드에서만 사용할 수 있다.
   */
  
  public static void main(String[] args) {
    positivePrint(10);  // 양수만 출력하겠다.
    positivePrint(-10);
  }
// 전달된 인수가 양수이면 출력하고 아니면 출력하지 않는 positivePrint 메소드
  public static void positivePrint(int a) { 
   // if(a  >= 0) {    // 좋은 코드 아님! if 만족안하면 실행이 안됨..
   //   System.out.println(a);
    
    if(a < 0) {  // 종료 조건 : 만족하지 않으면 끝내버리겠다! 0보다 작으면 실행되지 않는다.
      return;
    }
    System.out.println(a);
  }
  
 
}
