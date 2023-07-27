package ex10_Cart;

public class Cart {
  
  /*Product 배열 길이*/  private final int CART_LENGTH = 10;
  /*Product 배열*/       private Product[] products;  //초기화 null
  /*담긴 Product 개수*/  private int prodCount;  //초기화 0 
  
  //new Cart()
  public Cart() { //배열 생성을 해서 추가 적을 내용 없음
    products = new Product[CART_LENGTH];
  }

  //final getter,setter 필요 없음
  
  public Product[] getProducts() {
    return products;
  }

  public void setProducts(Product[] products) {
    this.products = products;
  }

  public int getProdCount() {
    return prodCount;
  }

  public void setProdCount(int prodCount) {
    this.prodCount = prodCount;
  }
  
  // 물건 넣기 -> 순차적으로 물건 넣기(배열의 첫 번째 요소부터)
  //addProduct(new Product("제품번호","제품명", 제품가격))
  public void addProduct(Product product) {
    // 물건을 못 넣는 경우(꽉찼음) CART_LENGTH = prodCount
    if(prodCount == CART_LENGTH) {
      System.out.println("Cart is Full!");
      return;
    }
    // 물건 넣기, ﻿물건 개수 = 제품의 인덱스와 동일 , prodCount++ 사용 후 증가, 
    products[prodCount++] = product;
    }
  // 물건 바꾸기
  //changeProduct(0, new Product("제품번호","제품명", 제품가격))
  public void changeProduct(int idx, Product product) {
    // 물건 못 바꾸는 경우 제품개수를 넘어가는 경우... 
    if(idx < 0 || idx > prodCount ) {
      System.out.println("There is no Prduct!");
      return;
    }
    // 물건 바꾸기
    //products[idx] = null; // 일단 빼고 -> 사실 할 필요 없음.. 덮어쓰기 때문에 
    products[idx] = product; // 덮어쓰기, 다시 넣기
  }
  // 물건 빼기 (뺀거 순서 앞으로 땡기고, 들어가는건 그 다음에 올 수 있도록... )
  // deledtProduct(0)
  public void deleteProdyct(int idx) {
    // 물건을 못 빼는 경우
    if(prodCount == 0) {
      System.out.println("Cart is Empty");
      return;
    }
    if(idx < 0 || idx > prodCount ) {
      System.out.println("There is no Prduct!");
      return;
    }//   (3 - idx) = prodCount
    // idx  복사할 요소의 개수  물건의 개수
    // 0     3                   4
    // 1     2                   4
    // 2     1                   4
    // 0     0                   4
    //---------------------------------
    // idx + x + 1 = prodCount
    //  x = prodCount - idx -1
    System.arraycopy(products, idx + 1, products, idx, prodCount - idx - 1);
    products[--prodCount] = null;    //﻿ products[prodCount -1] = null; //prodCount-- 두 줄 짜리 한 줄로 바꿈﻿﻿
 }
  
}
