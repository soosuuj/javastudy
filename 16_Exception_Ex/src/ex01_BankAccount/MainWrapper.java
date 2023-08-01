package ex01_BankAccount;

public class MainWrapper {

  public static void main(String[] args) {
   // BankAccount acc = new BankAccount(10000, "1234");
    
   // acc.deposit(-1);  //실패 목적, 예외 처리..
    //long money = acc.withdrawal(5000);
    //System.out.println("출금액 " + money);
    
    try {
    BankAccount acc = new BankAccount(10000, "1234");
    BankAccount acc2 = new BankAccount(10000, "5678");
    // 각 계좌의 입금 & 출금
    acc.deposit(10000);
    acc.withdrawal(5000);
    //이체
    acc.transfer(acc2, 1);
    acc.inquiry();
    acc2.inquiry();
    } catch(RuntimeException e) {
      System.out.println(e.getMessage());
    }
    
  }

}
