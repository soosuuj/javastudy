package ex03_date_time;

public class Ex01_System {
  
  public static void ex01() {
    /*
     * TimeStamp(타임스템프)
     * 1. 현재 시간을 long 타입의 값으로 가지고 있는데 그걸 타임스탬프라고 한다.
     * 2. 1970년 1월 1일 0시부터  1/1000마다 1씩 증가하고 있는 값이다.
     * 
     */
    
    long timestamp = System.currentTimeMillis();
    System.out.println(timestamp);
    System.out.println(Long.MAX_VALUE);
    
  }
  
  public static void ex02() {
    
    /*
     * 시간 단위(ㄹ 한자)
     * 
     * second > ㎳    >   ㎲        > ㎱     >  ㎰
     *        밀리초    마이크로초   나노초   피코초
     *        
     *        
     *        currentTimeMillis()  nanoTime()  
     */       
    
    // 나노초
    // 어떤 작업 수행시간을 정밀하게 계산하고자 할 때 사용하는 시간
    
    String s1 = "";
    StringBuilder s2 = new StringBuilder();
    
    long Strat = System.nanoTime();
    
    for(char ch = 'A'; ch <= 'z'; ch++) {
      // s1 += ch;    //수행시간 : 14000㎱( String의 + 연산자) 
      s2.append(ch);  //수행시간 : 14900㎱ (StringBuilder의 append 메소드)
    }
    
    long end = System.nanoTime();
    System.out.println("수행시간 : " + (end - Strat)+ "㎱");
    
  }

  public static void main(String[] args) {
    //ex01();
    ex02();
    
  }

}
