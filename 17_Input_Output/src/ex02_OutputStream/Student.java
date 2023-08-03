package ex02_OutputStream;

import java.io.Serializable;

/*
 * 직렬화(Serializable) 처리하기
 * 1. java.io.Serializable 인터페이를 구현(implements)한다.  -> 코드짜고
 * 2. long serialVersionUID 필드 값을 생성(generate)한다.              -> 자바가 생성
 *   같은 김밥을 붙여야하니까 같은 id 사용
 */

public class Student implements Serializable {
  

  private static final long serialVersionUID = -988261495718805568L;
// 직렬화 할 수 있는 스튜던트 됨 (자를 수 있는) <-직렬화 안되어있음 걍 클래스..
 //직렬화만 하면 오류 -> 2안해서
  // 경고 메서지 클릭 후 2번째 클릭!  -> 뭔가 생성되는데 이건 자바가 쓰는 것 -> 신경 ㄴㄴ
  
  private String name;
  private int age;
  private double height;
  private String school;
  
  public Student() {
  
  }
  public Student(String name, int age, double height, String school) {
    super();
    this.name = name;
    this.age = age;
    this.height = height;
    this.school = school;
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
  public double getHeight() {
    return height;
  }
  public void setHeight(double height) {
    this.height = height;
  }
  public String getSchool() {
    return school;
  }
  public void setSchool(String school) {
    this.school = school;
  }
  
  @Override
  public String toString() {
    return "Student [name=" + name + ", age=" + age + ", height=" + height + ", school=" + school + "]";
  }
  
}