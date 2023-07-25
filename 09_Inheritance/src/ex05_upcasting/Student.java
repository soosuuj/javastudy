package ex05_upcasting;

//Student is a Person. (is a)
// 서브 클래스(자식) is a 슈퍼 클래스(부모) -> 언제나 super라고 부름

public class Student extends Person {
  //Student는 Person의 기능을 모두 가질 수 있다.
  //Student get, set name, get, set sleep  4개 메소드 사용 가능
  //자신의 메소드 get, set school, study 3개 메소드 총 7개 사용 가능
  
  private String school;
  // ****자식이 가져야할 생성자 규칙
  // new Student() // 기본 생성자
  public Student() {
    // 반드시 휴퍼 클래스의 생성자 호출이 있어야 하기 때문에, 
    // 개발자가 슈퍼 클래스의 생성자를 호출하지 않으면 Java가 직접 슈퍼 클래스의 생성자를 호출한다.
    // Java가 호출하는 슈퍼 클래스의 생성자는 "디폴트 생성자"만 가능하다.
    super(); // 개발자가 작성하지 않아도 자동으로 호출되는 슈퍼 클래스의 디폴트 생성자
  }
  
  // new Student("홍길동", "가산대학교")   // 이름, 학교 생성자
  public Student(String name, String school) {
    //new Student("홍길동") 호출을 위한 코드 -> Person과 상속 관계를 맺어 super이용
    super(name);  //super (Person)"생성자 호출", 홍길동이 저장된 name 전달
    //상속시 서브 클래스 객체를 만드려면 부모를 호출해서 먼저 person생성!!
    //super.eat();  //﻿super.마침표 - 슈퍼가 가지고 있는 "멤버 호출"(필드나 메소드 가능)
    this.school = school;
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }
  
 
  
  @Override //애너테이션
  public void study() {
    System.out.println("공부");
  }
  
  @Override  //애너테이션
  public void info() {
    //System.out.println("이름 : " + name); name이라고 적을 수 없음 -> private -> 상속관계여도 불가!
   System.out.println("이름 : " + getName());
   System.out.println("학교 : " + school);

  }

  
}
