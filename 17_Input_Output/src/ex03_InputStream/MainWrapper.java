package ex03_InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainWrapper {
  
  /*
   * java.io.InputStream 클래스
   * 1. 바이트 기반의 입력스트림이다.
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
      
      // 입력된 데이터를 저장 변수 준비
      int c = 0; // 입력단위가 int 아니면 byte이기 때문에 int 사용 -> 초기화
      
      // read() 메소드
      // 1. 1개의 데이터를 읽어서 반환한다.
      // 2. 읽은 내용이 없으면 (만든건 5개, 읽은건 6개로 돌아갈 때) -1을 반환한다.
      
      // 1개씩 읽은 데이터를 누적할 StringBilder 생성  //기본 클래스라 임폴트 안해도 됨
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
  
  public static void main(String[] args) {
    ex01();
    
    
  }

}
