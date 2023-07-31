package ex01_String;

public class Ex01_String {
  
  public static void ex01() {
    
    // 문자열 리터럴(Literal)
    // -> 자바에 의해 최적화 되기 때문에 같은 문자열 2개 이상 만들지 않는다.
    // 문자열 표현 방법 : 큰 따옴표로 문자열을 묶는다.
    String name1 = "tom";
    String name2 = "tom";
    
    // 문자열 리터럴은 Java에 의해서 최적화 되기 때문에
    // 동일한 리터럴이 2번 이상 나타나면 기존 리터럴을 재사용한다.
    //
    //       ┌--------------┐
    //  name1│  0x12345678  │
    //       │--------------│
    //  name2│  0x12345678  │
    //       │--------------│
    //       │      ...     │
    //       │--------------│
    //       │      tom     │0x12345678
    //       │--------------│
    //       │      ...     │
    //       └--------------┘
    //
    // 문자열 리터럴 비교 -> 참조값의 비교 수행
    // name1과 name2의 참조값이 동일하다.
    boolean isEqual = name1 == name2;
    System.out.println(isEqual);
    
  }
  
  public static void ex02() {
    
    // 문자열 객체(Object)
    String name1 = new String("tom");
    String name2 = new String("tom");
    
    // 문자열 객체는 항상 새로 생성된다.
    //
    //       ┌--------------┐
    //  name1│  0x12345678  │
    //       │--------------│
    //  name2│  0x98765432  │
    //       │--------------│
    //       │      ...     │
    //       │--------------│
    //       │      tom     │0x12345678
    //       │--------------│
    //       │      ...     │
    //       │--------------│
    //       │      tom     │0x98765432
    //       │--------------│
    //       │      ...     │
    //       └--------------┘
    
    // 문자열 객체 비교 -> 참조값의 비교 수행
    // name1과 name2의 참조값이 다르다.
    boolean isEqual = name1 == name2;
    System.out.println(isEqual);
  }
  public static void ex03() {
    
    // equals 메소드
    // 문자열이 동일하면 true, 아니면 false반환
    
    String name1 = new String("tom");
    String name2 = new String("tom");
    String name3 = new String("Tom");
    
    boolean isEquals1 = name1.equals(name2);
    System.out.println(isEquals1);

    boolean isEquals2 = name1.equals(name3); // 대소문자도 일치해야 동일한 문자열로 인식한다.
    System.out.println(isEquals2);
    
    boolean isEquals3 = name1.equalsIgnoreCase(name3); // 대소문자를 무시하고 문자열을 비교한다.
    System.out.println(isEquals3);

  }
  
  public static void ex04() {
    
    //toUpperCase 메소드 : 모두 대문자로 변환
    //toLowerCase 메소드 : 모두 소문자로 변환
    
    String name = "Tom";
    System.out.println(name.toUpperCase());
    System.out.println(name.toLowerCase());
  }
  
  public static void ex05() {
    
    // length 메소드 : 문자열의 길이(글자수)를 반환
    
    String name = "Tom cruise\n"; // 11글자, \n 글자로 포함
    int length = name.length();
    System.out.println(length);
    
  }
  
  public static void ex06() {
    
    // charAt 메소드
    // 문자열의 특정 인덱스(Index)의 문자를 반환
    
    String name = "tom"; //3글자 char[] -> [t] [o] [m] 처림 생겼다고 생각! -> Index 0, 1, 2
    
    char ch1= name.charAt(0);
    char ch2= name.charAt(1);
    char ch3= name.charAt(2);
        
   System.out.println(ch1 + ", " + ch2 + ", " + ch3);
 
  }
  
  public static void ex07() {
    
    // subString 메소드
    // 문자열의 일부 문자열을 반환
    
    // subString 사용법
    // 1. subString(int begin) : 인덱스 begin 부터 끝까지 반환
    // 2. subString(int  begin, int end) : 인덱스 begin부터 end 이전까지 반환 (begin <= 추출범위 < end)
    
    String name = "tom cruise";
    
    String firstName = name.substring(0,3); //tom;
    String lastName = name.substring(4);
   
    System.out.println(firstName);
    System.out.println(lastName);
  }
  

  public static void main(String[] args) {
    //ex01();
    //ex02();
    //ex03();
    //ex04();
    //ex05();
    //ex06();
    ex07();
    
    
    
    
  }

}
