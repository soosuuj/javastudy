package ex04_text_copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    
    // 파일 출력 스트림 선언
    BufferedWriter fw = null;
    
    try {
      // 파일 입력 스트림 생성
      fw = new BufferedWriter(new FileWriter(file));
  
      // 출력할 데이터
      char[] c = {'a','b','c','b','e','f'};
   
      // 출력)파일로 데이터 보내기
      fw.write(c);
      
      // 메서지
      System.out.println(file.getPath() +" 파일 생성 완료");
     
      
    } catch(IOException e) {
    e.printStackTrace();
    }finally {
      try {
       if(fw != null);
       fw.close();
    } catch (IOException e) {
       e.printStackTrace();    
    }
  }

  
}
  
  public static void ex02() {
    
    
    // 문제2. C:/storage/alphabet.txt 파일을 복사하여 C:/storage/alphabet2.txt 파일을 만드시오.
   
    // 원본 파일의 File 객체 생성  
    File dir1 = new File("C:/storage");
    File src = new File(dir1, "alphabet.txt");  //src = 원본
    
    // 원본을 읽는 입력 스트림 선언
    BufferedInputStream bin = null;
    
    // 복사본 파일의 File 객체 생성
    File dir2 = new File("c:/storage");
    if(dir2.exists() == false) {
      dir2.mkdirs();
    }
    File cp = new File(dir2, "alphabet2.txt"); // 원본 파일의 이름을 그대로 가져와서 복사본 파일의 이름으로 사용
    
   
    // 복사본을 만드는 출력 스트림 선언
    BufferedOutputStream bout = null;
    

    try{
      // 원본을 읽는 입력 스트림 생성
      bin = new BufferedInputStream(new FileInputStream(src));
      
      // 복사본을 만드는 출력스트림 생성
      bout = new BufferedOutputStream(new FileOutputStream(cp));
      
      // 복사 단위(몇 byte씩 복사할 것인가?)
      byte[] b = new byte[1024];
      
      // 원본에서 읽은 실제로 복사된 바이트
      int readByte = 0;
      
      //1024byte씩 복사 진행
      while((readByte = bin.read(b)) != -1) {
        bout.write(b,0, readByte);
      }
      
      // 결과 메시지
      System.out.println(src.getPath() + " → " + cp.getPath());  //경로, 파일 명 전부 나옴
      
      
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
