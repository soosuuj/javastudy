package ex01_try_catch;

import java.net.URL;
import java.util.Scanner;

public class MainWrapper {
  
  
  public static void ex01() {
    
    try {
      String name = "tom";
      Integer.parseInt(name);   // 발생한 NumberFormatException(unchacked) 을 catch 블록으로 java가 던진다.
    } catch(NumberFormatException  e) {    //RuntimeException, Exception 가능
      //﻿※Exception e 라고 쓰면 모든 오류 처리 가능!!!!!
      System.out.println("예외발생");
    }
    
  }
  
  public static void ex02() {
    
    try {
      
 
    Scanner sc = new Scanner(System.in);
    System.out.println("덧셈식을 입력하세요.(예 : 1 +2)");  // 1.5 + 2 -> int 로 받을 수 없음
    String expr = sc.next();
    String[] numbers = expr.split("[+]");  //numbers = {"1", "2"} -> String
                                           // 그냥 + 라고 쓰면 안되고, 대괄호로 묶어줘야함
    
    int number1 = Integer.parseInt(numbers[0]);
    int number2 = Integer.parseInt(numbers[1]);  //"1-2" 입력 시 인덱스 벗어남 [1]은 없는거임
    System.out.println(number1 + number2);
    sc.close();
       } catch (NumberFormatException e) {     // 여러개 적는 것 -> 예외 발생 사유를 명확하게 사용자에게 안내
                                               // 안내 안할거면 exception으로만 써도 됨
     System.out.println("정수 연산만 가능합니다.");
    } catch (ArrayIndexOutOfBoundsException e) {  // 사용할 수 있는 범위의 인덱스 벗어남
      System.out.println("덧셈식에 +를 포함해서 입력하세요"); 
    } catch (Exception e) {  //NumberFormatException과 ArrayIndexOutOfBoundsException 으로 처리 못하는 예외들
      System.out.println("알 수 없는 예외가 발생했습니다.");
    }
   
  }

  public static void ex03() {
    
    // 중요!!! 반드시 try - catch가 필요한 예외를 checked Exception이라고 한다. -> 예외 종류를 공부하는 건은 중요하지 않음
    try {
      URL url = new URL("https://www.naver.com");  // 특정 사이트 접속 할 때 작성하는 코드
      } catch (Exception e) {
        System.out.println("예외 발생");
      }
   
  }
  
  
  public static void main(String[] args) {
    //ex01();
    //ex02();
    ex03();

    
    
    
  }

}
