package ex05_BankAccount;

public class Bank {

  private String name;
  private String tel;
  
  //메소드
  public Bank(String name, String tel) {
    this.name = name;
    this.tel = tel;
  }
  

 // 생성자
  public Bank() {
  }
 
  
  //setter
  public void setName(String name) {
    this.name = name;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  
  //getter
  public String getName() {
    return name;
  }
  
  public String getTel() {
    return tel;
  }
  
  public void info() {
    System.out.println(name + "(" + tel + ")");
  }
}
