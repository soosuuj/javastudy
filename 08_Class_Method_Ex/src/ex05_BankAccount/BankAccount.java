package ex05_BankAccount;

public class BankAccount {

  private Bank bank;
  private String accNo;
  private long balance;
  
 
  public BankAccount(Bank bank, String accNo, long balance) {
    this.bank = bank;
    this.accNo = accNo;
    this.balance = balance;
  }
   
  //생성자
  public BankAccount() {
  
  }
   
  //setter
  public void setBank(Bank bank) {
    this.bank = bank;
}
  public void setAccNo(String accNo) {
    this.accNo = accNo; 
  }
  public void setBalance(long balance) {
    this.balance = balance;
  }
  
  //getter
   public Bank getBank() {
    return bank;
   }

   public String getAccNo() {
     return accNo;
   }
   public long getBalance() {
    return balance;
   }
   

 
  public void info() {
    System.out.println("계좌번호: " + accNo + ", 통장잔액: " + balance + "원");
    System.out.print("개설지점: ");
    bank.info();
  }
  
  //입금 메소드
  public void deposit(long money) {
    if(money <= 0) {
      return; // 메소드 종료
    }
    balance += money;
  }
  
  // 출금 메소드
  public long withdrawal(long money) {
    long retVal = 0;
    if(money > 0 && money <= balance) {
      balance -= money;
      retVal = money;
    }
    return retVal;
  }
 // 이체 메소드
  public void transfer(BankAccount acc, long money) {
    acc.deposit(withdrawal(money)); // 내통장에서 출금 된 금액만큼, 상대 계좌에 입금 시켜줌
  }  //1장은 직접 이체.. 이번껀 사람이 사람에게 이체하는 구조로 변경된 것임..ㅎㅎ 
   // 사람이 가지고 있는 계좌 정보를 가지고 진행

}
