package ex05_access_modifier;

public class MainWrapper {

  public static void main(String[] args) {

    // User 객체(객체명 u) 생성
    User u  = new User();
    
    // User 객체에 데이터 저장
    //객체이름 u.setId 세터 부르기(값) 저장
    u.setId("admin");  // setId 인수  admin     
    u.setAge(30);
    
    // User 객체의 데이터 확인
    System.out.println(u.getId());
    System.out.println(u.getAge());
    
  }

}
