package ex03_Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainWrapper {
   /*
     * Set
     * 1. 인덱스가 없다. 저장 순서가 없다. -> 인덱스가 사용되는 메서드는 없음
     * 2. 중복 저장이 되지 않는다.
     */
    
  public static void ex01() {
    
    // Set 인터페이스 타입 선언
    Set<String> season;
    
    // HashSet 클래스 타입의 객체 생성
    season = new HashSet<String>();
    
    // 요소 추가하기
    season.add("봄");
    season.add("여름");
    season.add("가을");
    season.add("겨울");
    season.add("봄");  // 중복 저장 안됨, 저장 된 순서로 안나옴 -> 요소 하나를 꺼내기 안되고 전체를 보기 위한 구조
   
    // 전체 확인 -> 평소같으면 참조값이 나옴, toString도 만들어져있음 -> ArrayList도 가능, 이미 오버라이드 되어있음
    System.out.println(season);
    
    //for문
    for(int i = 0, length = season.size(); i < length; i++) {
      System.out.println(season);
    }
    
    
   
  }

  public static void ex02() {
    
    //HashSet 선언 & 생성
    Set<String> hobbies = new HashSet<String>();
    
    //요소저장
    hobbies.add("독서");
    hobbies.add("요리");
    hobbies.add("운동");
    hobbies.add("체스");

    //for문 활용(인덱스가 없으므로 "향상 for문")
    for(String hobby : hobbies) {
      System.out.println(hobby);
    }
  
    
  }

  public static void ex03() {
    
    //HashSet 선언 & 생성
    Set<String> flower = new HashSet<String>();
    
    //요소 저장하기
    flower.add("국화");
    flower.add("튤립");
    flower.add("프리지아");
    flower.add("물망초");
    
    // 반복자 Iterator를 이용한 Set 순회(for문 대신 사용한다)
    Iterator<String> arm = flower.iterator(); 
    System.out.println(arm.hasNext());  // 있는지 확인하고 꺼내기, 있으면 true, 없음 false
    System.out.println(arm.next());  // 아무거나 하나 꺼내기
    
    System.out.println(arm.hasNext());
    System.out.println(arm.next());
   
    System.out.println(arm.hasNext());
    System.out.println(arm.next());
   
    System.out.println(arm.hasNext());
    System.out.println(arm.next());
    
    System.out.println(arm.hasNext());
    //System.out.println(arm.next());  -> 오류 
    
    
    // 조건 : arm.hasNext()
    // 실행 :  System.out.println(arm.next());
    while (arm.hasNext()) {
        System.out.println(arm.next());
    }
    
  }
  
public static void ex04() {
    
  // 동일한 객체 2개 
    Person p1 = new Person("홍길동", 30);
    Person p2 = new Person("홍길동", 30);
    
    //HashSet 생성 & 선언 
    //-> 7-Person 참고, 참조값을 비교, 참조값이 다르다고 생각(내용은 같지만, 메모리 주소값이 다름)해서 결과값 2개 나옴
    // 소스코드 -> 해쉬/이퀄 에서 자동완성 추가하면 값이 1개만 나옴..
    Set<Person> people = new HashSet<Person>();  //set 중복을 회피함
    
    // Hash코드 사용 - > 빠른 검색을 위해서 
    // Hash 값 - 어떤 데이터가 가지고 있는 정수 값, 데이터를 분리하기 위해 만들어짐
    // 동일한 데이터들은 동일한 hash 값을 가지도록 알고리즘을 짜서 구현한 것
    // hash 값을 먼저 찾고 - > 바나나(똑같은 데이터) 있는지 없는지 찾는게 이퀄 그래서 둘이 같이 다님...ㅎㅎ
    
    
    //요소 추가
    people.add(p1);
    people.add(p2);
    
    //확인
    System.out.println(people);
    
  }
  
  public static void ex05() {
    
    // ArrayList 선언 & 생성
    List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> numbers2 = Arrays.asList(6, 7, 3, 4, 5);
    
    // ArrayList를 이용해서 HashSet 생성
    Set<Integer> set1 = new HashSet<Integer>(numbers1);
    Set<Integer> set2 = new HashSet<Integer>(numbers2);
    
    // 교집합
    set1.retainAll(set2);  // 교집합 결과는 set1에 저장된다.
    
    System.out.println(set1);  // [3, 4, 5]
    
  }
  
  public static void ex06() {
    
    // ArrayList 선언 & 생성
    List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> numbers2 = Arrays.asList(6, 7, 3, 4, 5);
    
    // ArrayList를 이용해서 HashSet 생성
    Set<Integer> set1 = new HashSet<Integer>(numbers1);
    Set<Integer> set2 = new HashSet<Integer>(numbers2);
    
    // 합집합
    set1.addAll(set2);  // 합집합 결과는 set1에 저장된다.
    
    System.out.println(set1);  // [1, 2, 3, 4, 5, 6, 7]
    
  }
  
  public static void ex07() {
    
    // ArrayList 선언 & 생성
    List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> numbers2 = Arrays.asList(6, 7, 3, 4, 5);
    
    // ArrayList를 이용해서 HashSet 생성
    Set<Integer> set1 = new HashSet<Integer>(numbers1);
    Set<Integer> set2 = new HashSet<Integer>(numbers2);
    
    // 차집합
    set1.removeAll(set2);  // 차집합 결과는 set1에 저장된다.
    
    System.out.println(set1);  // [1, 2]
    
  }
  
  
  public static void main(String[] args) {
    //ex01();
    //ex02();
    //ex03();
    ex04();
    
  }

}
