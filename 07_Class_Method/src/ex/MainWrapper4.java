package ex;

public class MainWrapper4 {

  // void : 리턴(실행 후 결과)이 없다.
  public static void ex01() {
    System.out.println("리턴이 없는 ex01");
  }
  
  // int : 리턴이 int 타입이다.
  public static int ex02() {
    return 100;
  }
  public static String ex03(){
    return "hello world!";
  }
  
  public static void main(String[] args) {
    ex01(); // void는 이 호출만 쓸 수 있음
    int n = ex02(); // 실행 후에는 int n = 100;
    System.out.println(n);
    System.out.println(ex02()); // 실행 후에는 system.out.println(100);
    if(ex02() > 0) {
      System.out.println("양수");
    }else {
      System.out.println("음수");
    }
    String str = ex03();
    System.out.println(str); //  hello world!
    
    
  }

}
