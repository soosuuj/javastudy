package ex05_BankAccount;

public class BankMember {

  
  private String name;
  private BankAccount acc;
  
  
  //기본 생성자
  public BankMember() { 
}
  
  //setter
  public void setName(String name) {
    this.name = name;
  }
  public void setAcc(BankAccount acc) {
    this.acc = acc;
  }
  
  //getter
  
  public String getName() {
    return name;
  }
  public BankAccount getAcc() {
    return acc;
  }
  
  public BankMember(String name, BankAccount acc) {
    this.name = name;
    this.acc = acc;
  }
  
  public void info() {
    System.out.println("고객명: " + name);
    acc.info();
  }
  
  public void deposit(long money) {
    acc.deposit(money);
  }
  
  public long withdrawal(long money) {
    return acc.withdrawal(money); // 실제 출금 액을 받아와서 그대로 반환    
  }
  
  public void transfer(BankMember member, long money) {
    member.deposit(withdrawal(money)); // 멤버에게 내 통장에서 출금된 금액만큼 입금해줌
  }
  
}