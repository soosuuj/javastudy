package ex04_Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MainWrapper {
  
  /*
   * HashMap  필드를  key(변수요소)라고함../ 저장된 값 value(변수 값) 라고함 
   * 1. Map 인터페이스를 구현한 클래스이다.
   * 2. ★객체(Object)/인스턴스(Instance)를 대신할 수 있는 자료구조이다.
   * 3. 용어
   *    1) Entry : Key  + Value를 합쳐서 부르는 말
   *    2) Key   : 데이터를 식별하는 식별자 (변수명) -> name
   *    3) Value : 데이터 자체(변수에 저장된 값)     -> 홍길동
   * 4. 특징 : 
   *    1) Key는 중복이 불가능하다.(HashSet 구조로 되어 있다.)
   *    2) Value는 중복이 가능하다.
   *    3) Key와 Value 모두 Generic 처리한다. (Key와 Value 값을 따로 따로 잡아줘야한다.)
   */
  
  public static void ex01() {
    
    // Map 인터페이스 타입으로 HashMap 선언
    Map<String, String> dict;
    
    // HashMap 생성
    dict = new HashMap<String, String>();
    
    // Entry 저장(Key, Value) -> 동일한 key는 2개 이상 들어갈 수 없다. 
    // 동일한 키 사용하게 된다면, 기존 데이터 엎어써짐
    
    // 봄을 전달하면 답은 spring 출력, 한글만 보이고 영어 안보인다고생각하기!
    dict.put("봄", "spring");
    dict.put("여름", "summer");
    dict.put("가을", "autumn");
    dict.put("겨울", "winter");
    
    // Value 확인(Key를 전달한다.) Value를 넣어 Key확인한다는건 없음. 안됨.
    System.out.println(dict.get("봄"));  // 출력 : spring
    System.out.println(dict.get("여름"));  // 출력 : summer
    System.out.println(dict.get("가을"));  // 출력 : autumn
    System.out.println(dict.get("겨울"));  // 출력 : winter

    
  }

  public static void ex02() {
    
    // HashMap 선언 & 생성 Object -> 원하는데로 사용하기 위해서, 대부분 <String, Object>로 사용하긴함
    Map<String, Object> person = new HashMap<String, Object>();
    
    //Entry 저장(Key는 변수명으로, Value는 변수값으로 저장) -> 일반적인 Map의 사용법
    person.put("name", "홍길동");
    person.put("age", 30);
    
    // 위 두개로 person 객체 대신 사용 가능, 기능이 같다.
    
    // Entry 수정(기존의 Key를 사용하면 해당 Key의 Value가 수정되는 방식)
    person.put("name", "제시카");
    person.put("age", 40);
    
    
    // Value 확인
    System.out.println(person.get("name"));
    System.out.println(person.get("age"));
   
    
  }
  
  public static void ex03() {
    
    //HashMap 선언 & 생성
    Map<String, Object> map = new HashMap<String, Object>();
    
    //Entry 저장
    map.put("top", 10);
    map.put("bottom", 30);
    map.put("left", 30);
    map.put("right", 40);
    
    // 반복자(Iterator)를 이용한 HashMap의 순회
    // 1. Key만 모두 꺼내서(Hash set에 저장 가능) Set에 저장한다. (KeySet 메소드)
    // 2. Set에 반복자(Iterator)를 붙여서 Key를 하나씩 꺼낸다. 
    // 3. get() 메소드에 Key를 전달하면 Value가 나온다. 
    
    Set<String> keySet = map.keySet();  // 키 나옴
    Iterator<String> arm = keySet.iterator();
    while(arm.hasNext()) {
      String key = arm.next();  // 키를 꺼냄
      Object value = map.get(key);
      System.out.println(key + " : " + value );
    }
    
    
    
  }
  
  public static void ex04() {
    
    // HashMap 선언 & 생성
    Map<String, Object> map = new HashMap<String, Object>();
    
    // Entry 추가
    map.put("id", "admin");
    map.put("pw", "1234");
    map.put("role", "DBA");
    
    // ★ for문 순회 ★ (Entry 단위로 값을 빼는 entrySet() 매소드 활용)
    // for(변수 : 컬렉션) 변수에 Entry 넣어 2개를 같이 뺌
    // Map.Entry 명확한 의사전달로 앞에 써도됨, 안써도 괜춘
    for(Map.Entry<String, Object> entry : map.entrySet()) {
      String key = entry.getKey();      // 키값 꺼내기
      Object value = entry.getValue();  // value값 꺼내기
      System.out.println(key + " : " + value);
    }
    
  }
  
  public static void main(String[] args) {

    //ex01();
    //ex02();
    //ex03();
    ex04();
  }

}
