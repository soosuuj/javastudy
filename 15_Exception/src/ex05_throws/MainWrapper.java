package ex05_throws;

public class MainWrapper {
  
  /*
   * ★★★throws★★★  위치 꼭 기억!!!!
   * 1. 메소드에서 발생하는 모든 예외를 던질 때 사용한다.
   * 2. 메소드 내부에서 try-catch를 처리하지 않고, 메소드를 호출하는 곳으로 예외를 던질 때 사용한다.
   * 3. 메소드를 ★★★호출하는 곳에서 try-catch를 처리★★★한다. (메소드 호출하는 곳으로 try-catch 미루겠다.)
   *    본문에 try-catch 넣으면 안됨안됨안됨!
   */
  
  //print 메소드의 정의
  // throws NullPointerException : "메소드를 호출할 때" NullPointerException 처리가 필요하다.
  public static void print(String str) throws NullPointerException {  
       //print 메소드는 NullPointerException 를 발생 될 수 있다는 뜻
    
    System.out.println("첫 글자 : " + str.substring(0, 1));
    System.out.println("나머지 글자 : " + str.substring(1));
  }
  
  public static void main(String[] args) {
    
    try {
    // print 메소드 호출 
    print("홍길동");
    print(null);  // 출력 : NullPointerException 예외 발생
    } catch(NullPointerException e) {
      System.out.println(e.getMessage());  // Cannot invoke "String.substring(int, int)" because "str" is null
                                      // -> java가 만든 예외 메세지 확인
    }
  }

}


