package ex08_Bakery;

//sell 메소드 - 잔돈 부족 추가해 주세요.
//buy  메소드- 가진 돈 부족 추가해 주세요

public class MainWarpper {

  public static void main(String[] args) {

    Bakery bakery = new Bakery(100, 10000);   // 빵이 100개, 빵 가격 1000원, 빵집에 10000원 있음
    Customer customer = new Customer(10000);        // 빵 0개, 10000원을 가진 고객
    
    customer.buy(bakery, 3, 10000);  // bakery 에서 빵을 3개 구매를 위해서 10000원을 냈다.
    
    System.out.println("빵집 money :" + bakery.getMoney() + "원");
    System.out.println("빵집 빵 :" + bakery.getCount() + "개");
    System.out.println("고객 money: " + customer.getMoney() + "원");
    System.out.println("고객 빵 " + customer.getCount() + "개");
  
  }

}
