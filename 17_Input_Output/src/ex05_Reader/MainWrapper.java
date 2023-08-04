package ex05_Reader;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainWrapper {
  
  /*
   * java.io."Reader" 클래스
   * 1. 문자 기반의 입력스트림이다.
   * 2. 입력 단위
   *    1) int
   *    2) char[]
   *    3) String
   */

  public static void ex01() {
    
    // 디렉터리를 File 객체로 만들기
    File dir = new File("C:/storage");
    
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex01.txt");
    
    // 파일 입력 스트림 선언
    FileReader fr = null;
    
    try {
      
      // 파일 입력 스트림 생성 (반드시 예외 처리 필요, 파일이 없으면 FileNOtFoundException 발생)
      fr = new FileReader(file);
      
      // 입력된 문자 저장할 변수
      int ch = 0; // 문자는 int가 아니지만 -1값이 필요하기 때문에 int 사용
      
      // 입력된 문자를 누적할 StringBuffer 생성
      StringBuffer sb = new StringBuffer();
      
      // read() 메소드
      // 1. 1개 문자를 읽어서 반환한다.
      // 2. 읽은 문자가 없으면 -1을 반환한다.
      
      // 반복문 : 읽은 문자가 -1이 아니면 계속 읽는다.
      while((ch = fr.read()) != -1) {
        sb.append((char)ch);
      
      }
      // 결과확인
      System.out.println(sb.toString());

    } catch (IOException e) {  //FileNOtFoundException도 받음
      e.printStackTrace();
    } finally {
      try {
        if(fr != null){
          fr.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
 
  }
  
  public static void ex02() {
    
    // 디렉터리를 File 객체로 만들기
    File dir = new File("C:/storage");
    
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex02.txt");
    
    // 파일 입력 스트림 선언
    FileReader fr = null;
    
    try {
      
      // 파일 입력 스트림 생성 (반드시 예외 처리 필요, 파일이 없으면 FileNOtFoundException 발생)
      fr = new FileReader(file);
      
      // 입력된 문자 저장할 배열
      char[] cbuf = new char[2]; // 2글자 읽어들이기
      
      // 실제로 읽은 글자 수 저장 할 변수
      int readChar = 0;  //readbyte 비슷한 아이... 
      
      // 입력된 문자를 누적할 StringBuffer 생성
      StringBuffer sb = new StringBuffer();
      
      // int read(char[] cbuf) 메소드// int를 반환하는 read 메소드
      // 1. 파라미터로 전달된 char[] cbuf에 읽은 문자를 저장한다.
      // 2. 실제로 읽은 글자 수를 반환한다.
      // 3. 읽은 문자가 없으면 -1을 반환한다.
      
      // 반복문 : read()의 반환값(실제 읽은 글자 수)이 -1이 아니면 계속 읽는다.
      while((readChar = fr.read(cbuf)) != -1) {
        sb.append(cbuf, 0, readChar); // 배열 cbuf의 인덱스 0부터 readChar개 문자를 sb에 추가한다.
      
      }
      // 결과확인
      System.out.println(sb.toString());

    } catch (IOException e) {  //FileNOtFoundException도 받음
      e.printStackTrace();
    } finally {
      try {
        if(fr != null){
          fr.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
  }

  public static void ex03() {
    
    // 속도 젤 빠르고, 쉬움!!!! 이걸로 쓰기~~
    
    // 디렉터리를 File 객체로 만들기
    File dir = new File("C:/storage");
    
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex03.txt");
    
    // 버퍼 입력 스트림 선언
    BufferedReader br = null;
    
    try {
      
      // 버퍼 입력 스트림 생성 (반드시 예외 처리 필요, 파일이 없으면 FileNOtFoundException 발생)
      br = new BufferedReader(new FileReader(file));
      
      // 입력된 문자열 저장 변수, 사실은 객체
      String line = null;
      
      // 입력된 문자를 누적할 StringBuffer 생성
      StringBuffer sb = new StringBuffer();
      
      // String readLine()메소드
      // 1. 한 줄 전체를 반환한다. -> 글자 수를 고려하지 않아 편함
      // 2. 읽은 문자가 없으면 null을 반환한다.
      
      // 반복문 : readLine()의 반환값(실제 읽은 글자 수)이 null이 아니면 계속 읽는다.
      while((line = br.readLine()) != null) {
        sb.append(line + "\n");     // 읽은 라인에 줄 바꿈(\n)은 포함되어 있지 않다. 원하면 포함시켜 주기
      }
     
      // 결과확인
      System.out.println(sb.toString());

    } catch (IOException e) {  //FileNOtFoundException도 받음
      e.printStackTrace();
    } finally {
      try {
        if(br != null){
          br.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    
  }
  
  public static void ex04() {
    
    
    // 바이트 출력스트림으로 보낸 문자를 바이트 입력스트림으로 읽기(한글 실패)
    // 바이트 출력스트림으로 보낸 문자를 문자 입력스트림으로 읽기(한글 성공)
    // 참고) 서버가 기본적으로 보내는 것은 바이트스트림! 
    
    // 1단계. 바이트 출력스트림으로 문자보내기
    File dir = new File("C:/storage");
    if(dir.exists() == false){
      dir.mkdirs();
    }
    
    File file = new File(dir, "server.dat");  //byte로 만들어짐
    BufferedOutputStream bout = null;
    try {
      bout = new BufferedOutputStream(new FileOutputStream(file));
      String s1 ="안녕하세요";
      String s2 ="Hollo";
      bout.write(s1.getBytes("UTF-8"));
      bout.write(s2.getBytes("UTF-8"));  // byte로 변경하여 전달 
      bout.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    // 2단계. 문자 입력스트림으로 읽기 inputStreamReader
    /*
     * java.io.InputStreamReader 클래스
     * 1. Reader 클래스를 상속 받은 클래스이다. (문자 입력스트림이다.)
     * 2. InputStream(바이트 입력스트림)을 받아서 Reader(문자입력스트림)으로 변환한다.
     */
    
    BufferedReader br = null;
    try {
      br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
      String line = null;
      StringBuffer sb = new StringBuffer();
      while((line = br.readLine()) != null) {
        sb.append(line + "\n");
      }
      System.out.println(sb.toString());
      br.close();
   
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
    
  }
  
  public static void main(String[] args) {

    //ex01();
    //ex02();
    //ex03();
    ex04();
    
  }

}
