package ex06_Member;

public class Member {  // 회원
  
  private String name;     // 이름
  private Contact contact; // 연락처
  
  
  //setter
  public void setName(String name) {
    this.name = name;
  }
  public void setContact(Contact contact) {
    this.contact = contact;
  }
  
  //getter
  public String getName() {
    return name;
  }
  public Contact getContact() {
    return contact;
  }
 
  public void info() {
    System.out.println("이름: " + name + ", 연락처 : " + contact);
  }
  
}
