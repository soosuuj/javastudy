package ex;

public class MainWapper {
  public static void main(String[] args) {
    
    // 초 -> 분/초
    int second = 90;
    int m = 90/second;  // 1
    int s = second % 60;  // 30
    
    System.out.println(second + "초는 " + m + "분 " + s + "초입니다." );
    System.out.println(s);
    
    
    // x와 y값을 교환
    int x = 10;
    int y = 20;
    int temp;

    temp = x;
    x = y;
    y = temp;

    System.out.println(y);
  

    // 5% 이자를 받으면 통장잔액이 얼마?(소수 이하는 버림)
    long balance = 123456L;  // 통장잔액
    double pct = 0.05;  // 5%

    //balance = balance * 1 + balance * pct);  -- 뒤에 소수점 있는데, 앞에서 받아줄 애가 없어서 오류남 // long(balance * (1 + pct)); 
    // balance = balance * (1 + pct); 
      balance *= (1+pct);
    
    System.out.println(balance);
    
    
    // 90점대 점수이면 true, 아니면 false
    int score1 = 95;
    //double result1 = ??;  // true
    int score2 = 75;
    //double result2 = ??;  // false
    
   // boolean result1 = (score1 >= 90 ); // 내가 쓴 답
    boolean result1 = (score1 >= 90 ) && (score1 < 100); //true
    System.out.println(result1);

   // boolean result2 = (score2 >= 90); // 내가 쓴 답
    boolean result2 = (score2 / 10) == 9;
    System.out.println(result2);


    // n의 "짝수", "홀수" 여부 출력
    int n = 3;
    //String res1 = ??;  // "홀수"
    
    String res1 = (n % 2 == 0) ? "짝수" : "홀수";
    System.out.println(res1);
    System.out.println(n + "은(는) " + res1 + "입니다." );



  
    // num의 "짝수", "홀수", "3의배수" 여부 출력
    int num = 3;
    int num2 = 0;
    //String res2 = ??;  // "3의배수"
   
   String res2 = n % 3 == 0  ?   "3의배수": (n % 2 == 0) ? "짝수" : "홀수" ;
    System.out.println(res2);
    System.out.println(num + "은(는) " + res2 + "입니다." );
    System.out.println(num2 + "은(는) " + res2 + "입니다." ); // 0도 3의 배수...


  }
}
