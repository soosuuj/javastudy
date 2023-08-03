package ex03_InputStream;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import ex02_OutputStream.Student;

public class MainWrapper {
  
  /*
   * java.io.InputStream 클래스
   * 1. 바이트 기반의 입력스트림이다.  // 서버 통신 기본... !!!
   * 2. 입력 단위
   *    1) int
   *    2) byte[]
   */

  public static void ex01() {
    
    // 디렉터리를 File 객체로 만들기
    File dir = new File("C:/storage"); // 읽어야할 것이 여기 있으니까
    
    //파일을 File 객체로 만들기
    File file = new File(dir, "ex01.dat");
    
    // 파일입력 스트림 선언
    FileInputStream fin = null;
    
    try {
      
      // 파일 입력 스트림 생성(반드시 예외 처리 필요, 파일이 없으면 예외 발생)
      fin = new FileInputStream(file);
      
      // 입력된 데이터 저장 변수
      int c = 0; // 입력단위가 int 아니면 byte이기 때문에 int 사용 -> 초기화
      
      // read() 메소드
      // 1. 1개의 데이터를 읽어서 반환한다.
      // 2. 읽은 내용이 없으면 (만든건 5개, 읽은건 6개로 돌아갈 때) -1을 반환한다.
      
      // 입력된 ( 1개씩 읽은)데이터를 누적할 StringBilder 생성  //기본 클래스라 임폴트 안해도 됨
      StringBuilder sb = new StringBuilder();
      
      // 반복문 : 읽은 내용이 -1이 아니면 계속 읽는다.
      /*
      c = fin.read();   // 기본 사용법 지정된 입력 스트림으로부터 데이터를 하나 읽어와 c에 저장 (a를 읽음)
      sb.append(c)// 읽어서 저장
      c = fin.read();   // 그 다음은 b... => 얼마나 있는지 모르기 때문에 이렇게 짤 수 없음
      sb.append(c)// 읽어서 저장
      */
      while((c = fin.read()) != -1) {    //c = fin.read() 먼저 수행 -> -1 이아니면 수형
        sb.append((char)c);  // A는 65로 저장 , a = 97, 0 = 48 // 시작부터 char로 저장 할 수 없기 때문에 형변환!
                             //  java.io.InputStream 클래스 -> 하나씩 읽을거면 int 여러개 쓸거면 byte[] 써라
      }
      // 결과 확인
      System.out.println(sb.toString());
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {  // 입력스트림은 꼭 닫지 않아도 됨, 이미 위에서 확인이 됐기 때문에.. 생성은 안닫아주면 계속 올 거라고 생각해서 안되지만, 읽은건 다 읽었으면 문제 없음
      try {
        if(fin != null) {
          fin.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
    
  }
  
  public static void ex02() {  // read 방법 변경 -> ex01보다 성능 좋음 -> 요거 공부
    
    // 바이트 기반 스트림은 원래 한글 처리가 안 된다.
    
    // 디렉터리를 File 객체로 만들기
    File dir = new File("C:/storage"); // 읽어야할 것이 여기 있으니까
    
    //파일을 File 객체로 만들기
    File file = new File(dir, "ex02.dat");
    
    // 파일입력 스트림 선언
    FileInputStream fin = null;
    
    try {
      
      // 파일 입력 스트림 생성(반드시 예외 처리 필요, 파일이 없으면 예외 발생)
      fin = new FileInputStream(file);
      
      // --- 여기서 부터 변경 -- 
      //입력된 데이터 저장 변수
      byte[] b = new byte[4]; // 4byte 임의로 크기 설정 (최대 4바이트 입력 가능)-> 이걸로는 한글 파일 못읽음
      
      // 실제로 읽은 바이트수 저장 변수가 .따로 있음
      int readByte = 0; // 4바이트를 못읽을 수도 있음.. 
                        // 2번째 파일 15byte 4, 4, 4, 3 -> 실제로 읽어들이는 바이트 -> 이 값이 저장 될 변수  int readByte = 0;
                         //﻿4, 4, 4, 3 실제로 읽어 들이는 바이트 수가 꼭 따로 저장되야함 덮어 쓰기 때문에 부족한건 이전 값이 남아있을 수 있음
      
      // 입력된 ( 1개씩 읽은)데이터를 누적할 StringBilder 생성  //기본 클래스라 임폴트 안해도 됨
      StringBuilder sb = new StringBuilder();
      
      // read(byte[] b) 메소드
      // 1. 파라미터로 전달된 byte[] b 에 읽은 내용을 저장한다.
      // 2. 실제로 읽은 바이트 수를 반환한다.
      // 3. 읽은 내용이 없으면 (만든건 5개, 읽은건 6개로 돌아갈 때) -1을 반환한다.  
      
      /*
      readByte = fin.read(b); // readByte 처음에 4 저장, 실제 데이터는 b 배열에 저장 
      sb.append(new String(b, 0, readByte)); // b배열의 readbyte만큼 저장, 읽어드린 수만큼만 저장 -> 이걸 계속 반복
      readByte = fin.read(b); 
      sb.append(new String(b, 0, readByte)); 
      readByte = fin.read(b); 
      sb.append(new String(b, 0, readByte)); 
      readByte = fin.read(b); 
      sb.append(new String(b, 0, readByte)); 
      */
      
      
      // 반복문 : read()의 반환값이 -1이 아니면 계속 읽는다.
      while((readByte = fin.read(b)) != -1) {    
        sb.append(new String(b, 0, readByte)) ; // 배열 b의 인덱스 0부터 readByte개의 데이터를 String으로 변환한다.
                                          // 읽어드린 데이터는 4바이트가 아니기 때문에 언제나 모든 바이트를 쓰면 안됨
      }
      
      /*
       * 15바이트 "abcdefghijklmno"를 4바이트씩 읽는 방식
       * 
       * byte[] b            readByte    new String(b, 0, readByte)
       * 
       * 1차 Loop
       * ┌---------------┐
       * │ a | b | c | d │  4           배열 b의 인덱스 0부터 4개 데이터를 String으로 변환한다.
       * └---------------┘
       * 2차 Loop
       * ┌---------------┐
       * │ e | f | g | h │  4           배열 b의 인덱스 0부터 4개 데이터를 String으로 변환한다.
       * └---------------┘
       * 3차 Loop
       * ┌---------------┐
       * │ i | j | k | l │  4           배열 b의 인덱스 0부터 4개 데이터를 String으로 변환한다.
       * └---------------┘
       * 4차 Loop
       * ┌---------------┐
       * │ m | n | o | l │  3           배열 b의 인덱스 0부터 3개 데이터를 String으로 변환한다.
       * └---------------┘
       *                ↑
       *                └---- 이전 Loop에서 읽은 데이터이므로 사용하면 안 된다.
       */
      
      
      
      // 결과 확인
      System.out.println(sb.toString());
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {  // 입력스트림은 꼭 닫지 않아도 됨, 이미 위에서 확인이 됐기 때문에.. 생성은 안닫아주면 계속 올 거라고 생각해서 안되지만, 읽은건 다 읽었으면 문제 없음
      try {
        if(fin != null) {
          fin.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
   
  }
  
  public static void ex03() {  // 성능 가장 우수
    
    /*
     * java.io.BufferedInputStream 클래스
     * 1. 내부 버퍼를 가지고 있는 입력스트림이다.
     * 2. 많은 데이터를 한 번에 입력받기 때문에 속도 향상을 위해서 사용한다.
     * 3. 보조스트림이므로 메인 스트림과 함께 사용한다.
     */
    
    
    // 디렉터리를 File 객체로 만들기
    File dir = new File("C:/storage"); // 읽어야할 것이 여기 있으니까
    
    //파일을 File 객체로 만들기
    File file = new File(dir, "ex03.dat");
    
    // 버퍼 입력 스트림 선언
    BufferedInputStream bin = null;
    
    try {
      
      // 버퍼 입력 스트림 생성
      bin = new BufferedInputStream(new FileInputStream(file));
      
      //입력된 데이터 저장 변수
      byte[] b = new byte[4]; 
      
      // 실제로 읽은 바이트수 저장 변수가 .따로 있음
      int readByte = 0; 
      
      // 입력된 ( 1개씩 읽은)데이터를 누적할 StringBilder 생성  
      StringBuilder sb = new StringBuilder();
      
      // read(byte[] b) 메소드
      // 1. 파라미터로 전달된 byte[] b 에 읽은 내용을 저장한다.
      // 2. 실제로 읽은 바이트 수를 반환한다.
      // 3. 읽은 내용이 없으면 (만든건 5개, 읽은건 6개로 돌아갈 때) -1을 반환한다.  
      
  
      
      // 반복문 : read()의 반환값이 -1이 아니면 계속 읽는다.
      while((readByte = bin.read(b)) != -1) {    
        sb.append(new String(b, 0, readByte)) ; 
      }
      // 결과 확인
      System.out.println(sb.toString());
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {  // 입력스트림은 꼭 닫지 않아도 됨, 이미 위에서 확인이 됐기 때문에.. 생성은 안닫아주면 계속 올 거라고 생각해서 안되지만, 읽은건 다 읽었으면 문제 없음
      try {
        if(bin != null) {
          bin.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
   
  }
  
  public static void EX04() {
    
    // DataOutputStream과 DataInputStream을 사용하면
    // 바이트 기반 입출력에서도 한글 처리가 가능하다.(writeUTF, readUTF 메소드 이용)
    
    /*
     * java.io.DataInputStream 클래스
     * 1. int, double, String 등의 변수를 그대로 입력받는 입력스트림이다.
     * 2. 보조스트림이므로 메인스트림과 함께 사용한다.
     */
    
    // 디렉터리를 File 객체로 만들기
    File dir = new File("C:/storage");
    
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex04.dat");
    
    // 데이터입력스트림 선언
    DataInputStream din = null;
    
    try {
      
      // 데이터입력스트림 생성 (반드시 예외 처리 필요, 파일이 없으면 예외 발생)
      din = new DataInputStream(new FileInputStream(file));
      
      // 순서대로 입력 받기
      char ch1 = din.readChar();        // 't'
      char ch2 = din.readChar();        // 'o'
      char ch3 = din.readChar();        // 'm'
      int age = din.readInt();          // 50
      double height = din.readDouble(); // 180.5
      String school = din.readUTF();    // 가산대학교
      
      // 결과 확인
      System.out.println("" + ch1 + ch2 + ch3);
      System.out.println(age);
      System.out.println(height);
      System.out.println(school);      
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(din != null) {
          din.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
  }
  
  public static void ex05() {
    
    /*
     * java.io.ObjecInoutStream 클래스
     * 1. 객체를 그대로 입력받는 입력스트림이다.
     * 2. 직렬화(Serializable)된 객체를 입력 받을 수 있다.
     * 3. 보조스트림이므로 메인스트림과 함께 사용한다.
     */
    
    
    //
    File dir = new File("C:/storage"); // 읽어야할 것이 여기 있으니까
    
    //파일을 File 객체로 만들기
    File file = new File(dir, "ex05.dat");
    
    // 객체 입력 스트림 선언
    ObjectInputStream oin = null;
    
    try {
      
      // 객체 입력 스트림 생성
      oin = new ObjectInputStream(new FileInputStream(file));
      
      // 객체 순서대로 입력 받기
      Student s = (Student)oin.readObject();  // 타입이 object, (부모를 자식으로 - 다운케스팅)
      
      
      // 결과 확인
      System.out.println(s);  // toString 메소드 만들어놔서 이렇게만 해도 출력
      
     
      
    } catch (IOException  | ClassNotFoundException e) {
      e.printStackTrace();
    } finally {  // 입력스트림은 꼭 닫지 않아도 됨, 이미 위에서 확인이 됐기 때문에.. 생성은 안닫아주면 계속 올 거라고 생각해서 안되지만, 읽은건 다 읽었으면 문제 없음
      try {
        if(oin != null) {
          oin.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
    
  }
  
 
  
  public static void main(String[] args) {
    //ex01();
    //ex02();
    //ex03();
    //EX04();
    ex05();
    
  }

}
