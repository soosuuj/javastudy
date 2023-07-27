package ex01_Person;

public class Person {
  
  private String name;
  private int age;
  
  //자동완성 ctrl + space
 public Person() {
   
 }
 
 //자동완성 
  public Person(String name, int age) {
  super();          // Object 생성자 부름 -> 자동완성이면 들어감, 의미두지 않아도 됨!
  this.name = name;
  this.age = age;
  }
  
  //자동완성
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
  
  //자동완성 toString
  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + "]";
  }
  
  
}
