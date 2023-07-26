package ex07_Object;

import java.util.Objects;

/*
 * java.lang.Object 클래스 // 클래스(Object)이름 앞에 붙는 것 패키지(java.lang.)이름
 * 1. 모든 클래스의 최상위 슈퍼 클래스이다.
 * 2. 별도의 슈퍼 클래스를 명시하지 않은 클래스들은(extends가 없는 클래스) 모두 Object클래스의 서브 클래스이다.
 * 3. ★모든 것을 저장할 수 있는 Java의 만능 타입이다.
 * 4. ★Object 타입으로 저장하면 Object 클래스의 메소드만 호출할 수 있다. 이를 해결하기 위해서 "반드시" 다운 캐스팅을 해야 한다.
 *  정수, 문자열, 모두 저장해야할 때 Object 사용 - 여따 저장하면 Object거만 보임
 *  Object에 내가 원하는 코드 추가하는 오버라이딩 불가
 *  다운캐스팅만 오브젝트
 */

/*
 *  ┌--------------┐
 *  │  Object      │ 슈퍼 클래스
 *  │--------------│  (작업 지시서 느낌, 저 이름을 써라는 기준 같은 것)
 *  │  equals()    │ 두 객체의 참조값을 비교해서 같으면 true, 아니면 false 반환
 *  │  getClass()  │ 어떤 클래스인지 반환
 *  │  hashCode()  │ int 타입의 해시코드값, Object 클래스는 객체의 참조값을 해시코드값으로 사용함
 *  │  toString()  │ "클래스이름@참조값" 형식의 문자열을 반환
 *  │  notify()    │ 스레드(thread) 관련 메소드
 *  │  wait()      │ 스레드(thread) 관련 메소드
 *  └--------------┘
 *          ▲
 *          │
 *          │
 *  ┌--------------┐
 *  │  Person      │ 서브 클래스
 *  │--------------│
 *  │  @Override   │
 *  │ ★equals()    │ 이름과 나이가 같으면 true, 아니면 false 반환 (하드코딩하지 않고, 자동완성한다.)
 *  │              │
    │  @Override   │
 *  │ ★toString()  │ 이름과 나이를 확인할 수 있는 문자열 반환(하드코딩하지 않고, 자동완성한다.)
 *  └--------------┘

 *  ★★★★★★★﻿Object에 있는 기능 대부분 못씀
 *  ★★★★★★★오버라이딩 해서 사용해야함!!
 *  
 */
 

public class Person {  
  
  private String name;
  private int age;
  
  //new Person()
  public Person() {
    
  }
  //new Person("홍길동", 20)
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  
  /*
    @Override  //슈퍼 클래스 equals 안사용하고 , 서브 equals 사용 
  public boolean equals(Object obj) {  //p1.equals(p2)  , obj = p2
    Person p = (Person)obj;
    return (age == p.age ) &&  name.equals(p.name);  //필드 age값 p1값  ;
  }
    /*
     * 객체의 동등성 비교를 위해 equals 메서드를 오버라이딩한 예시입니다. 
     * //이 메서드는 다른 객체와 현재 객체가 같은지 비교하는 데 사용됩니다. 
     * 메서드의 시그니처는 `public boolean equals(Object obj)`이며,
     * 매개변수로 Object 타입의 obj를 받습니다. 이 메서드가 호출되면, 
     * 객체 p1이 다른 객체 p2와 같은지를 확인하는데, obj 매개변수는 p2를 가리키게 됩니다.
     * 
     * 메서드 내부에서는 먼저 obj를 Person 타입으로 캐스팅하여 Person 객체 p로 받습니다. 
     * 이렇게 함으로써 obj가 실제로 Person 클래스의 객체라고 가정하고, 
     * Person 클래스의 필드와 메서드를 사용할 수 있게 됩니다.
     * 그리고 나서 비교 연산을 통해 p1의 필드인 age와 name이 p2의 필드와 동일한지 비교합니다. 
     * 필드 age의 값이 같고 name의 값도 같으면 두 객체는 동등하다고 판단하며 true를 반환합니다. 
     * 그렇지 않은 경우에는 false를 반환합니다.
     * 
     * 이렇게 equals 메서드를 오버라이딩 함으로써 개발자는 객체 간 동등성 비교를 
     * 자신이 원하는 방식으로 정의할 수 있습니다. 기본적으로 
     * Object 클래스에 구현된 equals 메서드는 두 객체가 동일한 메모리 위치를 가리키는지를 비교하기 때문에, 
     * 사용자 정의 클래스에서는 필요한 비교를 위해 equals를 오버라이딩하는 것이 일반적입니다.
     */
    

  
  @Override
  public int hashCode() {
    return Objects.hash(age, name);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)   //p1.equals(p1) 무조건 같음 이런 경우는 앞의 코드로 처리하겠다
      return true;
    if (obj == null)   //p1.equals(null) 비교할 값이 없음 
      return false;
    if (getClass() != obj.getClass())  //p1.equals(s1)  person 과 student를 비교하고 있다. 클래스가 다르면 비교할 필요 없다.
      return false;                    // 앞에서 예외 상황 처리
    Person other = (Person) obj;
    return age == other.age && Objects.equals(name, other.name);
  }
  
  
  // 객체값을 보고싶을 땐 , "값이 잘 들어있는지 확인하는 용도",  ★toString()으로 찍어 syso - 많이 사용
  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + "]";
  }
  
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }

  
  
}
