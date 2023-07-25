package ex07_Object;

public class MainWrapper {

  public static void main(String[] args) {

    Object obj = new Person();        //Object 단군할아버지같은 존재.. 그 밑에 수많은 자식들 ㅎㅎ  
    ((Person)obj).setName("홍길동");
    ((Person)obj).setAge(20);
    System.out.println(((Person)obj).getName());
    System.out.println(((Person)obj).getAge());
  }

}
