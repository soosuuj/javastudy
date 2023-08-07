package ex03_image_copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainWrapper {

  public static void main(String[] args) {  // 이미지는 바이트 입출력으로 처리해야한다.
    // 문제. %ORA_HOME%/oui/instImages/bg.jpg 이미지 파일을 C:/storage/bg.jpg 이미지로 복사하시오.
    // %ORA_HOME%은 C:/app/사용자/product/18.0.0/dbhomeXE 디렉터리를 의미한다.
    
    // 원본 파일의 File 객체 생성
    File dir1 = new File("C:\\app\\GDJ\\product\\18.0.0\\dbhomeXE\\oui\\instImages");
    File src = new File(dir1, "bg.jpg ");  //src = 원본
    

    // 원본을 읽는 입력 스트림 선언
    BufferedInputStream bin = null;
    
    // 복사본 파일의 File 객체 생성
    File dir2 = new File("c:/storage");
    if(dir2.exists() == false) {
      dir2.mkdirs();
    }
    File cp = new File(dir2, src.getName()); // 원본 파일의 이름을 그대로 가져와서 복사본 파일의 이름으로 사용
    
   
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
}
 // C:\app\GDJ\product\18.0.0\dbhomeXE\oui\instImages\bg.jpg  → c:\storage\bg.jpg 
