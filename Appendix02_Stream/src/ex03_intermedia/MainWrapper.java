package ex03_intermedia;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainWrapper {
  
  public static void ex01() {
    
    // 필터 : 원하는 요소만 사용
    
    // List  시작은 배열이나 어레이리스트로 하는 경우가 많음 태초에 stream으로 사용 xx -> stream으로 바꿔서 사용하는 것 알아두기!
     List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    
    // 홀수만 출력하기
    list.stream()
      .filter((number) -> number %2 == 1)     // 조건 true 나오면 사용, 아니면 말고
      .forEach((n)-> System.out.println(n));  // 할일
    
    
  }
  
  public static void ex02() {
    
    // 필터
    
    //List
    List<Person> list = Arrays.asList(
        new Person("홍자", 20),
        new Person("영미", 10),
        new Person("미희", 30),
        new Person("숙자", 15)
        );
    
    // age가 20이상인 Person을 List로 생성
    List<Person> adult = list.stream() //list 에 person 4개 들어가 있음
                             .filter((person) -> person.getAge() >=20) // 20이상인게 true 
                             .collect(Collectors.toList());
    
    // adult 확인
    adult.stream()
         .forEach((person) -> System.out.println(person.getName() + "," + person.getName() + " ," + person.getAge()));    
  }
  
  public static void ex03() {
    
    // 변환 (값을 바꿈)
    
    // List 
    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    
    // 1씩 증가시키기
    list.stream()
       // .filter(null) 껴서 원하는 값만 뽑아 낼 수 있다.  
        .map((number) -> number + 1)
        .forEach((number)-> System.out.println(number));
    
  }
  
  public static void ex04() {
    
    // 변환 map 연습
    
    //List
    List<Person> list = Arrays.asList(
        new Person("홍자", 20),
        new Person("영미", 10),
        new Person("미희", 30),
        new Person("숙자", 15)
        );
    
   List<Person> adult =  list.stream()
        .filter((person)-> person.getAge() >= 20) // 어른들만 한살 먹음
        .map((person) -> new Person(person.getName() + "님", person.getAge() +1))
        .collect(Collectors.toList());
  }
  
  public static void main(String[] args) {
    //ex01();
    //ex02();
    //ex03();
    ex04();
    
  }

}
