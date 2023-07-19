package ex;

public class MainWrapper {
  
  // 메소드 오버로딩 : 같은 이름의 메소드를 중복하여 정의하는 것
  
  public static void ex01() {
    System.out.println("파라미터가 없는 ex01");
  }
  
  public static void ex01(String str) { // 파라미터 String str : 인수를 받아서 저장하는 변수(매개변수)
   System.out.println("파라미터 String str = " + str);
 }
  
  public static void ex01(int a, int b) { // 파라미터 int a, 파라미터 int b
    System.out.println("파라미터 int a =  " +   a);
    System.out.println("파라미터 int b =  " +   b);
  }
  
  public static void main(String[] args) {
    ex01();  // ex01() 메소드에 전달하는 인수가 없다.
    ex01("Hello World"); // ex01()메소드에 "hello world"를 전달한다는 뜻.
    ex01(10,20);  //ex01() 메소드에 인수 10, 20을 전달한다.
  }
}
