package ex07_Object;

public class MainWrapper {
  
  public static void ex01() {
     //Object 타입으로 모든 객체를 저장할 수 있다.
     //Object타입으로 저장한 객체를 사용할 때는 캐스팅 해야 한다.
  }

  public static void ex02() {
    
    //동일한 객체 2개   
    Person p1 = new Person("홍길동", 20);
    Person p2 = new Person("홍길동", 20);
    
    //동일한 객체인지 판단,
    boolean same = p1.equals(p2);
    
    //결과확인
    System.out.println(same ? "동일한 객체" : "다른 객체");
  }
  
  public static void ex03() {
    Person p = new Person("홍길동", 20);
    System.out.println(p);     // 객체 p는 p.toString()이 자동 호출돼서 사용된다. -> 알아두기!!
    System.out.println(p.toString());
  }
  
  public static void main(String[] args) {

    Object obj = new Person();        //Object 단군할아버지같은 존재.. 그 밑에 수많은 자식들 ㅎㅎ  
    ((Person)obj).setName("홍길동");
    ((Person)obj).setAge(20);
    System.out.println(((Person)obj).getName());
    System.out.println(((Person)obj).getAge());
    
    //ex02();
    ex03();
  }

}
