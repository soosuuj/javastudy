package ex05_upcasting;

public class Person {

  private String name;
  
  // new Person()
  public Person() {
    
  }
  //new Person("홍길동")
  public Person(String name) {
    this.name = name;
  }
  

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void eat() {
    System.out.println("냠냠");
  }
 public void sleep() {
   System.out.println("쿨쿨");
 }
 
 // 실행이 목적이 아닌 호출이 목적인 메소드
 public void study() {  // person에 있어야해서 없는데 추가함
   
 }
 // 실행이 목적이 아닌 호출이 목적인 메소드 -> 실행되도록 짜면 실수! 
 // -> Person 이 working, study할 필요 없는거니까~
 public void working() {
   
 }
  public void info() {  //person 것이지만 student, alba의 것이기도함.
    System.out.println("이름 : " + name);
  }
  
}
