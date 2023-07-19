package ex05_access_modifier;

/*
 * 접근 제어 지시자(Access Modifier)
 * 1. Private   : 같은 클래스 내부에서만 접근할 수 있다.
 * 2. default   : 동일한 패키지에서만 접근할 수 있다.(access modifier를 작성하지 않은 경우)
 * 3. protected : 동일한 패키지 or 다른 패키지에 있는 상속 관계의 클래스만 접근할 수 있다.
 * 4. public    : 어디서든 접근할 수 있다.
 */

/*
 * 정보 은닉 (Information Hiding)
 * 1. 객체가 가진 내부 정보(필드)를 외부에 직접 노출하지 않는다.
 * 2. 외부로부터 내부 정보(필드)를 숨김으로써 정보를 안전하게 관리할 수 있다.
 * 3. Java에서는 정보 은닉을 위해 필드는 private처리하고, method는 public처리한다.
 * 4. java에서는 메소드를 통해서 필드에 접근한다.(필드에 직접 접근할 수 없다.) 
 */

/*
 * Getter와 Setter(게터와 세터)
 * 1. Getter
 *    1) 필드값을 외부로 반환(return)하는 메소드
 *    2) "get + 필드명" 형식의 이름을 가지는 메소드
 *    3) 메소드 이름을 마음대로 바꾸면 안된다. 
 * 2. Setter
 *    1) 외부로부터 받아 온 값(파라미터)을 필드에 저장하는 메소드이다.
 *    2) "set + 필드명" 형식의 이름을 가지는 메소드이다.
 *    3) 메소드 이름을 마음대로 바꾸면 안된다. 
 * 3. 참고. Boolean 타입의 필드는 Getter/Setter의 이름 형식이 다르다.
 *    
 */

public class User { //field, method 두가지만 class에 들어갈 수 있음

  // field 
  private String id; 
  private int age;
  
  
  //method
    
  /*
  //method   //public 다른 클래스도 사용 할 수 있음 - 접근 가능
  public void setId(String userId) { // 파라미터로 특정 아이디 받아옴, 받아온 아이디를 필드에 저장하여, 사용
    id = userId;
  }
*/
  //getter : 필드값을 외부로 반환(return)하는 메소드, 
  public String getId() { //String 반환타입  getId를 호출하면 id 알려줌
    return id;
    }
  /*
  public void setAge(int a) {
    age = a;
  }
  */
  
   public int getAge() {
     return age;
  }
   
   // setter : 외부로부터 전달된 값(파라미터)를 필드에 저장하는 메소드
   public void setId(String param) {
     id = param;
   }
   public void setAge(int param) {
     age = param;
   }
   
}
