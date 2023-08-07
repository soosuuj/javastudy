package ex03_functional_interface;

public class MainWrapper {

  public static void ex01() {
    // Anonymous inner type
    /*
    Myinterface1 interface1 = new Myinterface1() {
      
      @Override
      public void method1() {
        System.out.println("Hollo World");
        
      }
    };
    */
    
    // 람다 표현식으로 생성
    Myinterface1 interface1 = () -> System.out.println("Hollo World");
    
    // method1() 호출
    interface1.method1();
    
  }
  
  public static void ex02() {
    
    //Anonymous inner type 생성
   /* 
    Myinterface2 interface2 = new Myinterface2() {
      
      @Override
      public void method2(String name)  {
      System.out.println(name + "님");
      }
    };
    */

    // 람다 표현식으로 생성
    Myinterface2 interface2 = (name) -> System.out.println(name +"님");
    interface2.method2("홍길동");
  }
  
    public static void ex03() {
      
    }

    public static void ex04() {
      
   Myinterface interface4 = (name) -> name +"님";

    String str = interface4.method4("홍길동");
    System.out.println(str);
    
    }
    
  
  public static void main(String[] args) {

    //ex01();
    //ex02();
    //ex03();
    ex04();
  }

}
