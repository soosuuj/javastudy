package ex02_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *  ┌--------------┐
 *  │     List     │ List 인터페이스
 *  │--------------│
 *  │   add();     │
 *  │   get();     │
 *  │   size();    │
 *  │   set();     │
 *  │   remove();  │
 *  └--------------┘
 *          ▲
 *          │
 *          │
 *  ┌--------------┐
 *  │   ArrayList  │ ArrayList 클래스
 *  │--------------│
 *  │   add(){}    │ 요소 추가하기
 *  │   get(){}    │ 요소 가져오기
 *  │   size(){}   │ 요소 개수 반환하기
 *  │   set(){}    │ 요소 수정하기
 *  │   remove(){} │ 요소 삭제하기
 *  └--------------┘
 */



public class MainWrapper {

  public static void ex01() { 
    // List라는 인터페이스
    // import 신경써서 해야함 -> 프로젝트 import xx
    // import -> 기본 목적 프로젝트 불러오는 것
    // java.util.List -> import 처리해서 List라고 부를 것임
    
    //ArrayList의 인터페이스 List 타입 선언
    //제네릭(Generic)을 활용한 리스트 변수의 선언 
    //List<String>: `List`는 자바에서 제공하는 인터페이스 중 하나로, "순서가 있는 데이터의 집합"을 표현. 
    //`<String>`은 제네릭(Generic)을 사용하여 "`List`가 담을 요소들의 타입을 지정"하는 부분. 
    //`List<String>`은 문자열 타입(String)의 요소를 가지는 리스트를 의미
     List<String> season;
     //`season`: `List<String>` "타입의 변수인 `season`을 선언." 
     //이 변수는 `List<String>`에 담길 문자열 요소들을 관리하는 역할.
     
     //ArrayList 생성
     //﻿`ArrayList<String>`은 `List<String>` 인터페이스를 구체적으로 구현한 구현 클래스
     season = new ArrayList<String>();
         
    
    // 배열 요소 추가하기(`ArrayList<String>`인 `season`에 요소를 추가하는 작업)
    season.add("여름");
    //"여름"이라는 문자열을 `season` 리스트의 끝에 추가 리스트에는 현재 "여름" 하나만 들어감.
    season.add("가을");
    //"가을"이라는 문자열을 `season` 리스트의 끝에 추가. 리스트에는 "여름", "가을"의 순서로 요소가 들어 감.
    season.add("겨울");
    season.add(0, "봄");
    //season."봄"이라는 문자열을 `season` 리스트의 인덱스 0에 추가. 
    //"봄"이 리스트의 가장 앞에 위치하게 되고, 리스트에는 "봄", "여름", "가을", "겨울"의 순서로 들어감.
    
    //배열 요소 확인하기 "get 메소드 사용"하는 것 주의!!!
    System.out.println(season.get(0));
    System.out.println(season.get(1));
    System.out.println(season.get(2));
    System.out.println(season.get(3));
    
    
  }
  
  public static void ex02() {
    
    //ArrayList의 선언 & 생성
    List<String> hobbies = new ArrayList<String>();
    
    //배열 요소 추가하기
    hobbies.add("영화");
    hobbies.add("독서");
    hobbies.add("코딩");
    
    //일반 배열과 다른 점 : 배열의 길이를 고려하지 않아도 됨
    //add, get, size 메소드 총 3개 배움
    
    //배열 길이 확인하기(저장된 요소의 개수)
    System.out.println(hobbies.size());
    
    // 배열 길이 관련 (마지막 요서 꺼내기)
    System.out.println(hobbies.get(hobbies.size() -1));
  
    // 배열 for문 적용하기 .length가 아니라, .size!!
    for(int i = 0 ; i < hobbies.size(); i++) {
      System.out.println(hobbies.get(i));
    }
    
    // 배열 for문 적용하기 (리팩토링 : hobbies.size()가 여러번 호출 되는 문제점 해결)
    int a, b;           // 변수 한 번에 선언
    int x = 10, y = 20; // 초기값 지정도 동시에 가능
    
    for(int i = 0, length = hobbies.size(); i < length; i++ ) {
      System.out.println(hobbies.get(i));
  }
      //i,  length 변수 2개 사용, 선언 2개 동시에 함 int i = 0, length = hobbies.size() - 초기화
    
    
  }
  
  public static void ex03() {
    
    //ArrayLIst 선언 & 생성
    List<String> flower = new ArrayList<String>();
    
    // 배열 요소 추가
    flower.add("장미");
    flower.add("튤립");
    flower.add("무궁화");
    
    // 요소 수정하기
    flower.set(0, "백일홍"); // 인덱스 0의 요소를 "백일홍"으로 수정
    
    // 요소 삭제하기
    flower.remove(1);  // 인덱스 1의 요소 삭제
    
    //for 요소 확인
    for(int i = 0, length = flower.size(); i <length; i ++) {
      System.out.println(flower.get(i));
    }
    
   
    
  }

  public static void ex04() {
    
    // 배열을 ArrayLit로 바꾸기
    Integer[] a = {10, 20, 40, 50}; // 배열을 초기화 int 쓰면 안됨
    List<Integer> numbers = Arrays.asList(a);
    
    // 주의!!!!!! 초기화된 ArrayList는 길이를 변경할 수 없다.
    // numbers.add(60); // 마지막요소로 60을 추가하겠다 - > 출력 오류
    // numbers.remove(0); // 출력 오류 -> 삭제도 안됨 길이가 변경되기 때문에
    
    
    // for문
    for(int i = 0, length = numbers.size(); i< length; i++) {
      System.out.println(numbers.get(i));
    }
    
  }
  
  public static void ex05() {
    
    // ArrayList 초기화
    List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
    
    // for문
    for(int i = 0, length = numbers.size(); i <length ; i++) {
      System.out.println(numbers.get(i));
    }
    
  }
  
  
  public static void main(String[] args) {
    //ex01();
    //ex02();
    //ex03();
    //ex04();
    ex05();
  }

}
