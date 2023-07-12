package ex03_operator;

public class MainWrapper {

  // ex01 메소드 만들기 (메소드 정의 - 메소드 만들어달라)

  public static void ex01() {                    //      실행 2
    hello1();  // 재귀호출 (자기가 자기를 부르는 것)
    System.out.println("Hello World");
    // 정수 연산
    int a = 5;
    int b = 2;
    
    int add = a + b;
    int sub = a - b;
    int mul = a * b;
    int mok = a / b; // 몫
    int mod = a % b; // 나머지 
    
    System.out.println(add);
    System.out.println(sub);
    System.out.println(mul);
    System.out.println(mok);
    System.out.println(mod);
    
     // 실수 연산
    double x = 5;
    double y = 2;
    
    double addResult = x + y;
    double subResult = x - y;  
    double mulResult = x * y;  
    double divResult = x / y;  // 나누기

    System.out.println(addResult);
    System.out.println(subResult);
    System.out.println(mulResult);
    System.out.println(divResult);
    
    // 미션. 정수끼리 계산해서 실수 결과 도출하기
    int i = 5;
    int j = 2;
    
    double result = (double)i / j;  //casting 하여 계산
    System.out.println(result);   //2.5
    
  }
  
  public static void hello1() {                   
    System.out.println("안녕 자바1");
  }
  
  // ex02 메소드 정의
  public static void ex02() {
    // 증감 연산(++, --)

    // 전위 연산(먼저 증감)
    int a = 10;
    System.out.println(++a);  // a를 증가시킨 뒤 출력한다.
    System.out.println(a);
    
    // 후위 연산(나중에 증감)
       int b = 10;
    System.out.println(b++); // b를 출력한 뒤 증가시킨다.
    System.out.println(b);     
  }
  
  
  // ex03 메소드 정의
  public static void ex03() {
    
    // 대입 연산
    int a = 10;
    int b = a; 
    System.out.println(a);
    System.out.println(b);
    
    // 복합 연산(복합 대입 연산)
    int x = 10;
    int y = 1;
    y  += x;  // y = y + x; y 값을 x만큼 늘리기
    System.out.println(x); //10
    System.out.println(y); //11
    
  }
  
  // ex04 메소드 정의
  public static void ex04() {   
    int a = 3;
    int b = 5;
    
    boolean result1 = a > b;  // a가 b보다 크면 true, 아니면 false
    boolean result2 = a >= b; // a가 b보다 크거나 같으면 true, 아니면 false
    boolean result3 = a < b;  // a가 b보다 작으면 true, 아니면 false
    boolean result4 = a <= b; // a가 b보다 작거나 같으면 true, 아니면 false
    boolean result5 = a == b; // a와 b가 같으면 true, 아니면 false
    boolean result6 = a != b; // a와 b가 다르면 true, 같으면 false
    
    System.out.println(result1);
    System.out.println(result2);
    System.out.println(result3);
    System.out.println(result4);
    System.out.println(result5);
    System.out.println(result6);
    
    // 논리 연산
    // 1. 논리연산 AND : &&, 모든 조건이 만족하면 true, 아니면 false
    // 2. 논리 or : || 하나의 조건이라도 만족하면 true, 아니면 false
    // 3. 논리 NOT : 조건 결과가 true이면 false, 조건 결과가 false이면 true
    int x = 10;
    int y = 20;
    
    boolean andReasult = ( x == 10) && ( y == 10); // 모든 조건이 만족하지 않기 때문에 false
    boolean orReasult =  ( x == 10) || ( y == 10); // 모든 조건이 만족하므로 true
    boolean notReasult = !( x == 10); // x != 10과 동일한 조건 
    System.out.println("-------------");
    System.out.println(andReasult);
    System.out.println(orReasult);
    System.out.println(notReasult);
   
    
  }
  
  public static void main(String[] args) {  
    //ex01 메소드 실행 부탁(메소드 호출)
    ex01();                                     //  실행 1
    hello1();
    hello2();
  }
  
  public static void hello2() {
    System.out.println("안녕 자바2");
    //hello1();  - 여기다 쓰면 무한 루프 // 
    //ex02 메소드 호출
    //ex02();
    //ex03 메소드 호출
    //ex03();
    //ex04메소드 호출
    ex04();
  }

}

// 호출 순서 알아두기!!