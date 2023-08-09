package ex01_Stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MainWrapper {
  
   // 스트림 생성 & forEach()
  
  public static void ex01() {
   /*
     *  forEach() 메소드  // 메소드를 불렀는데 for문처럼 작동함
     *  1. Stream 파이프라인의 마지막에 사용할 수 있는 메소드 중 하나이다.
     *  2. Stream 파이프라인의 각 요소를 순회할 때 사용한다.
     *  3. for문처럼 동작한다.
     *  4. 형식
     *    void forEach(Consumer<T> consumer) 
     */
    
    // String 생성 
    Stream<String> stream = Stream.of("봄", "여름", "가을", "겨울");
    
    // comsumer 생성 (Anonymous inner Type 생성)
    Consumer<String> consumer = new Consumer<String>() {
      
      @Override
      public void accept(String t) {
       System.out.println(t);
      }
    };
    
    // forEach() 메소드 호출
    stream.forEach(consumer);
    
  }
  
  public static void ex02() {
    //Stream 생성
    Stream<String> stream = Stream.of("봄", "여름", "가을", "겨울");
    
    //Consumer 생성 (람다 표현식 생성)
    Consumer<String> consumer = (t) -> System.out.println(t);
      
    // forEach() 메소드 호출
    stream.forEach(consumer);    //  consumer 전달하면 끝
    //stream 에 저장된 거 순서대로 출력해라 
   
  }
  
  public static void ex03() {
    
    // 일반적으로 forEach 이렇게 사용함
    
    // Stream 생성
    Stream<String> stream = Stream.of("봄", "여름", "가을", "겨울");
    
    // forEach()메소드 호출  // 여기서 consumer 만들기
    stream.forEach((t) -> System.out.println(t));
    
    
  }
  
  /* 각종 스트림 생성 방법*/
  public static void ex04() {
    
    // 1. Integer 전용 stream
    //IntStream iStream = IntStream.of(1,2,3,4,5)       // 1, 2, 3, 4, 5)
    //IntStream iStream = IntStream.range(1, 6);        // 1이상 6미만 (1, 2, 3, 4, 5)
    //IntStream iStream = IntStream.rangeClosed(1, 5);  // 1이상 5이하 (1, 2, 3, 4, 5)
  
    IntStream iStream = IntStream.of(1,2,3,4,5);       // 1, 2, 3, 4, 5)
    iStream.forEach((number) -> System.out.println(number));
    
    // 2. Long 전용 Stream
    LongStream IStream = LongStream.of(1,2,3,4,5);
    IStream.forEach((number) -> System.out.println(number));
    
    // 3. Double 전용 스트림 (range, rangeClosed 불가능)
    DoubleStream dStream = DoubleStream.of(1.1, 2.2);   
    dStream.forEach((number) -> System.out.println(number));
 
    
  }
  
  public static void ex05() {
    
    // 배열 -> stream
    
    // 1. 일반 Stream
    String[] season = {"봄", "여름", "가을", "겨울"};
    Stream<String> stream  = Arrays.stream(season);
    stream.forEach((t) -> System.out.println(t));
    
    //2. IntStream
    int[] iNumber = {1, 2,3,4,5};
    IntStream iStream = Arrays.stream(iNumber);
    iStream.forEach((number) -> System.out.println(number));
    
    // 3. DoubleStream
    double[] dNumber = {1,2,3};
    DoubleStream dstream = Arrays.stream(dNumber);
    dstream.forEach((number) -> System.out.println(number));
    
  }
  
  public static void ex06() {
    
    // 컬렉션(Collection) -> Stream
    
    // List -> Stream
    List<String> list = Arrays.asList("봄", "여름", "가을", "겨울");
    Stream<String> stream = list.stream();  // 수업용, 실무에서 사용하지 않음
    stream.forEach((t) -> System.out.println(t)); //(t) 괄호 없애도 괜찮음 
    
    // Set -> Stream   //이게 더 실무에서 많이 쓰임 HashSet 초기화 코드가 없는셈..??
    Set<String> set = new HashSet<String>(Arrays.asList("봄", "여름", "가을", "겨울"));
    set.stream().forEach((t) -> System.out.println(t));  // 순서대로 출력되지 않음
    
  } 
  
  public static void ex07() {
    
    // 파일(입출력 스트림)-> Stream
    
    File file = new File("src/ex01_Stream/hello.txt"); // new File("hello.txt")도 가능함(동일한 곳에 있기 때문에 
    try (BufferedReader reader = new BufferedReader(new FileReader(file))){
      
      // Stream 생성
      Stream<String> stream = reader.lines(); 
      
      
      // forEach() 호출
      StringBuffer sb = new StringBuffer();
      stream.forEach((line)-> sb.append(line+ "\n"));
      
      // 확인
      System.out.println(sb.toString());
      
    } catch (IOException e) {
      e.printStackTrace();

    }
 
  }
    
  public static void ex08() {
    
    try {
    // Path를 이용한 Stream 처리
    Path path = Paths.get("src/ex01_Stream/hello.txt");
    Stream<String> stream = Files.lines(path); // 예외 처리 필요
    stream.forEach((line) -> System.out.println(line));
    stream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
  
  public static void ex09() {
    
    // 디렉터리에 저장된 파일 목록 -> stream
    // 목록 뽑아 보기 가능, 이걸로 비교해서 저긴 있고, 여긴 없네 확인 가능... ㅎㅎ
    File dir = new File("C:/Program Files");
    File[] files = dir.listFiles();  //-> 파일 배열 
    Stream<File> stream = Arrays.stream(files);
    stream.forEach((file)-> System.out.println(file.getPath()));
    
  }

  public static void ex10() {
    
    // Path를 이용한 Stream 처리

    try {
    Path path = Paths.get("C:/Program Files");
    Stream<Path> stream = Files.list(path);
    stream.forEach((p)-> System.out.println(p.getFileName()));
    stream.close();
     } catch (IOException e) {
      e.printStackTrace();
    }

  }
  
  
  public static void main(String[] args) {
    //ex01();
    //ex02();
    //ex03();
    //ex04();
    //ex05();
    //ex06();
    //ex07();
    //ex08();
    //ex09();
    ex10();
    
    
    
  }

}
