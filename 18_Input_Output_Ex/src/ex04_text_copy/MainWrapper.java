package ex04_text_copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainWrapper {
  
  public static void ex01() {
    
    // 문제1. 다음과 같이 알파벳 대문자가 입력된 C:/storage/alphabet.txt 파일을 만드시오.
    // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    
    File dir = new File("C:/storage");
    if(dir.exists() == false) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "alphabet.txt");
    
    
    // 버퍼출력스트림생성(close가 필요 없는 try - catch-resources문
    try ( BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
      
      // 알파벳 순차적으로 하나씩 저장
      for(char ch = 'A'; ch <= 'Z'; ch++) {
        writer.write(ch);
      }
      // 버퍼 출력스트림에 (혹시) 남아있는 모든 데이터를 보내기
      writer.flush();

      // 메서지
      System.out.println(file.getPath() +" 파일 생성 완료");

    } catch (IOException e) {
       e.printStackTrace();    
    }
  }


  
  public static void ex02() {
    
    
    // 문제2. C:/storage/alphabet.txt 파일을 복사하여 C:/storage/alphabet2.txt 파일을 만드시오.
   
    // 원본 파일의 File 객체 생성  / 디렉터리, 원본 File 객체
    File dir1 = new File("C:/storage");
    if(dir1.exists() == false) {
      dir1.mkdirs();
    }
    
    File src = new File(dir1, "alphabet.txt");  //src = 원본
    
    // 복사본 파일의 File 객체 생성
    //File dir2 = new File("c:/storage");
    File cp = new File(dir1, "alphabet2.txt"); 
    
    
     // 원본을 읽는 입력 스트림 선언
    BufferedInputStream bin = null;
    // 복사본을 만드는 출력 스트림 선언
    BufferedOutputStream bout = null;
    
    // try - catch - resources 

    try (BufferedReader br = new BufferedReader(new FileReader(src)); 
         BufferedWriter bw = new BufferedWriter(new FileWriter(cp))) {
 
      // 복사 단위 5 char
      char[] cbuf = new char[5];
      
      // 원본에서 읽은 실제로 복사된 바이트
      int readChar = 0;
      
      //1024byte씩 복사 진행
      while((readChar = br.read(cbuf)) != -1) {
        bw.write(cbuf,0, readChar);
      }
      
      // 결과 메시지
      System.out.println(cp.getPath() + "파일 생성 완료");  //경로, 파일 명 전부 나옴
      
      
    } catch(IOException e) {
      e.printStackTrace();
    }finally {
      try {
        if(bout != null) bout.close();
        if(bin != null) bin.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
   }

  public static void main(String[] args) {
    ex01();
    ex02();
  }

}
