package ex10_Cart;

import java.text.DecimalFormat;

public class Customer {
  
  /*Cart*/    private Cart cart;
  /*돈*/      private int money;
  /*포인트*/  private int point; // 소수점 빠이!
 
  // new Customer(100_000, 1_000)  // _이걸로 숫자 끊을 수 있음
   public Customer(int money, int point) {
    super();
    this.money = money;
    this.point = point;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public int getPoint() {
    return point;
  }

  public void setPoint(int point) {
    this.point = point;
  }
   
  // 카드에 물건 넣기
  public void addProductToCart(Product product) {
    cart.addProduct(product);
  }
  
  // 카트에 물건 바꾸기
  public void chageProductFromCart(int idx, Product product) {
    cart.changeProduct(idx, product);
  }
  
  // 카드에 물건 빼기
  public void deleteProductFromCart(int idx) {
    cart.deleteProdyct(idx);
  }
  
  // 물건 구매하기 -> 카드에 들어있는거 다 뺴서 총액 얼마인지...포인트 얼마인지 정리하는..것...
  public String buy() {
    
    String receipt ="------ 영수증 ------\n";
    
    int totalPrice = 0;
    
    for(int i = 0, prodCount = cart.getProdCount(); i < prodCount; i++ ) {
      
      // Cart에서 뺸 물건
      Product[] products = cart.getProducts(); // 배열에서 하나 뺌..
      Product product = products[i];
      
      
      // 구매액 누적
      totalPrice += product.getProdPrice();
      
      // 구매가 불가능한 경우
      if(money < totalPrice) {
        System.out.println("돈이 부족합니다.");
        return "";
      }
      
      // 영수증 만들기
      receipt += String.format("%-10s", product.getProdName()); // %-10s 폭 10개, 왼쪽 배열 
      receipt += String.format("%10s",  new DecimalFormat("#,##0").format(product.getProdPrice()));  
      receipt += "\n" ;
     
      
    }
    // 비용 지불
    money -= totalPrice;
    
    
    // 발생 포인트 누적
    point += totalPrice * 0.1;
    
    // 영수증 만들기
    // 참고 (#,##0은 천 단위 구분기호(,)를 넣어 주는 패턴, 패턴 적용을 위해서 DecimalFormat
    receipt += "---------------------\n";
    receipt += "구매총액 : " +String.format("%12s",  new DecimalFormat("#,##0").format(totalPrice)) + "\n";
    receipt += "발생포인트 : " + String.format("%10s", new DecimalFormat("#,##0").format(totalPrice * 0.1)) + "\n";
    receipt += "보유포인트 : " + String.format("%10s", new DecimalFormat("#,##0").format(point)) + "\n";
    //영수증 반환
    return receipt;
    
  }

  @Override
  public String toString() {
    return "Customer [money=" + money + ", point=" + point + "]";
  }
  
  
  
}
