package ex02_OutputStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;

public class MainWrapper {
  
  /*
   * java.io.OutputStream
   * 1. 바이트 기반의 출력 스트림이다. -> 파일 만드는 용도!  // 모니터 출력 스트림 : System.out
   * 2. 출력 단위
   *    1) int
   *    2) byte[] -> 배열타입
   */
  
  public static void ex01() {
    
    // 디렉터리를 File 객체로 만들기
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex01.dat");
    // FileOutputStream -> import해 줘야함, 데이터를 내보내는 출력스트림 - 바이트 내보내는 대상을 파일로 지정하면 파일로 내보내기 때문에 파일 만들어야함
    
    // 파일 출력 스트림 선언
    FileOutputStream fout = null; // 선언만
   
    try {
      
     // 파일 출력 스트림 생성(반드시 예외 처리가 필요한 코드) -> 예외 처리 안되있음 실행 안되는 checked exception
     
      
      // 1. 생성모드 : 언제나 새로 만든다.(덮어쓰기)           new FileOutputStream(file)
      // 2. 추가모드 : 새로 만들거나, 기존 파일에 추가한다.    new FileOutputStream(file, true) - > 처음만 새로만들고 그 다음부터 추가
      
    fout = new FileOutputStream(file); // 생성, 따로하는 이유 범위 조절 때문,  출력 스트림의 목적지가 파일로 결정됨 -> 예외 처리 요구됨!!!
    
    // 출력할 데이터(파일로 보낼 데이터)
    int c = 'A'; // int //  4byte int 사용 이유? -> 출력단위가 int or byte 뿐이기 때문에 
    String s = "pple";  // String을 byte로 변경
    byte[] b = s.getBytes();  // byte[] : String을 byte[]로 변환해서 만듦 
                              //파라미터 있으면 인코딩 필요, 이건 영어기 때문에 필요 없음
    
    // 출력(파일로 데이터 보내기)
    fout.write(c); // ex01.dat 파일로 보내는 작업
    fout.write(b); // ex01.dat 파일로 보내는 작업
    
    //fout.close(); 여따쓰면 fout.write(c); 여기서 예외 발생시 밑에 코드 작동 안하므로 여기다 쓰면 안됨
    
    
    System.out.println(file.getPath()+ " 파일크기 " + file.length() +"바이트"); 
    // 파일이름을 파일 객체로 부터 가져옴 .getName(); getParent() -> 폴더가져옴, getPath() -> 경로 + 파일 가져옴
    //file.length() 바이트 단위로 크기 출력
    
    
    } catch (IOException e) {
      e.printStackTrace();  // 예외 어디서 발생하는지 
    } finally {
      //fout.close();  // finally {} 에 넣으면 예외 발생 여부와 상관없이 닫기, -> 닫는 중 오류 발생(Unhandled -> 예외처리 또 요구) -> 예외 처리가 필요한 애들은 try에 들어가 있어야함.. 
    try {
      if(fout != null);
      fout.close();    // 출력 스트림은 "반드시" 닫아줘야함.("반드시 예외 처리"가 필요한 코드 + try 추가로 써줘야함)
                       //안닫아주면 파일이 정상적으로 닫히지 않아 파일이 만들어지지 않음
    } catch (IOException e) {
      e.printStackTrace();
    }
    }
    
    
    
  }
  
  public static void ex02() {
    
    // C:\storage\ex02.dat 파일로 "안녕하세요" 보내기, 파일 크기 확인
    // 디렉터리를 File 객체로 만들기
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex02.dat");
    // FileOutputStream -> import해 줘야함, 데이터를 내보내는 출력스트림 - 바이트 내보내는 대상을 파일로 지정하면 파일로 내보내기 때문에 파일 만들어야함
    
    // 파일 출력 스트림 선언
    FileOutputStream fout = null; // 선언만
   
    try {
      
     // 파일 출력 스트림 생성(반드시 예외 처리가 필요한 코드) -> 예외 처리 안되있음 실행 안되는 checked exception
    fout = new FileOutputStream(file); // 생성, 따로하는 이유 범위 조절 때문,  출력 스트림의 목적지가 파일로 결정됨 -> 예외 처리 요구됨!!!
    
    // 출력할 데이터(파일로 보낼 데이터)

    String s = "안녕하세요";  // String을 byte로 변경
    byte[] b = s.getBytes();  // byte[] : String을 byte[]로 변환해서 만듦 
                              //파라미터 있으면 인코딩 필요, 이건 영어기 때문에 필요 없음
    
    // 출력(파일로 데이터 보내기)
    // ex01.dat 파일로 보내는 작업
    fout.write(b); // ex01.dat 파일로 보내는 작업
    
    //fout.close(); 여따쓰면 fout.write(c); 여기서 예외 발생시 밑에 코드 작동 안하므로 여기다 쓰면 안됨
    
    } catch (IOException e) {
      e.printStackTrace();  // 예외 어디서 발생하는지 
    } finally {
      //fout.close();  // finally {} 에 넣으면 예외 발생 여부와 상관없이 닫기, -> 닫는 중 오류 발생(Unhandled -> 예외처리 또 요구) -> 예외 처리가 필요한 애들은 try에 들어가 있어야함.. 
    try {
      if(fout != null);
      fout.close();    // 출력 스트림은 "반드시" 닫아줘야함.("반드시 예외 처리"가 필요한 코드 + try 추가로 써줘야함)
                       //안닫아주면 파일이 정상적으로 닫히지 않아 파일이 만들어지지 않음
    } catch (IOException e) {
      e.printStackTrace();
    }
    }
    
    System.out.println(file.getPath()+ " 파일크기 " + file.length() +"바이트"); 
    // 파일이름을 파일 객체로 부터 가져옴 .getName(); getParent() -> 폴더가져옴, getPath() -> 경로 + 파일 가져옴
    //file.length() 바이트 단위로 크기 출력
    
  }
  
  public static void ex03() {  
    // ★ 젤 많이 씀!! 파일 만들어져 있는데, 새로고침하여 다시 만들면 덮어쓰기, 오류 안남 -> 이걸로 써라
    
    /*
     * BufferedOutputStream 클래스
     * 1. 내부 버퍼를 가지고 있는 출력스트림(OutputStream)이다.
     * 2. 많은 데이터를 한 번에 출력하기 때문에 속도 향상을 위해서 사용한다.
     * 3. 보조 스트림이기에 메인 스트림과 함께 사용한다.  /메인 스트림(예:FileOutputStream) 
     */
    
    //2줄로 안녕하세요 
          // 반갑습니다.
    
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex03.dat");
    
    // 버퍼 출력 스트림 선언  -> 출력 속도가 빨라짐 - > 한번에 여러개 출력 //FileOutputStream -> 이건 한 번에 하나 출력
    BufferedOutputStream bout = null;
   
    try {
      
     // 달라진곳 -> 버퍼 출력 스트림 생성(반드시 예외 처리가 필요한 코드) -> 예외 처리 안되있음 실행 안되는 checked exception
      bout = new BufferedOutputStream(new FileOutputStream(file)); // 생성, file을 바로 넣지 않음
      // FileOutputStream을 만들어 파일쪽으로 통로를 하나 만들고 거기다 BufferedOutputStream를 끼움(추가)
    
    // 출력할 데이터(파일로 보낼 데이터)
    String s1 = "안녕하세요";  // String을 byte로 변경
    int c = '\n';  // 1byte 기록
    String s2 = "반갑습니다.";
    
    // 출력(파일로 데이터 보내기)
    bout.write(s1.getBytes("UTF-8")); 
    bout.write(c);    
    bout.write(s2.getBytes(StandardCharsets.UTF_8)); 
    
    } catch (IOException e) {
      e.printStackTrace();  // 예외 어디서 발생하는지 
    } finally {
    try {
      if(bout != null);
      bout.close();    
    } catch (IOException e) {
      e.printStackTrace();
    }
    }
 
    System.out.println(file.getPath()+ " 파일크기 " + file.length() +"바이트");
  }
  
  public static void ex04() {
    
    /*
     * java.io.DataOutputStream 클래스
     * 1. int, double, String 등의 변수를 그대로 출력하는 출력스트림이다.
     * 2. 보조스트림이므로 메인스트림과 함께 사용된다.
     */
    
    File dir = new File("C:/storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    // 파일을 File 객체로 만들기
    File file = new File(dir, "ex04.dat");
    
    // 데이터 출력 스트림 선언  -> 출력 속도가 빨라짐 - > 한번에 여러개 출력 //FileOutputStream -> 이건 한 번에 하나 출력
    DataOutputStream dout = null;
   
    try {
      
     // 달라진곳 -> 데이터 출력 스트림 생성(반드시 예외 처리가 필요한 코드) -> 예외 처리 안되있음 실행 안되는 checked exception
      dout = new DataOutputStream(new FileOutputStream(file)); // 생성, file을 바로 넣지 않음
      // FileOutputStream을 만들어 파일쪽으로 통로를 하나 만들고 거기다 BufferedOutputStream를 끼움(추가)
    
      // 출력할 데이터(파일로 보낼 데이터)
      String name = "tom";
      int age = 50;
      double height = 180.5;
      String school = "가산대학교";
    
      // 출력(파일로 데이터 보내기)
      dout.writeChars(name);  // dout.writeChar('t'), dout.writeChar('o'), dout.writeChar('m')
      dout.writeInt(age);
      dout.writeDouble(height);
      dout.writeUTF(school);
      
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if(dout != null) {
          dout.close();  // 출력스트림은 반드시 닫아줘야 함 (반드시 예외 처리가 필요한 코드)
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
    System.out.println(file.getPath() + " 파일 크기 : " + file.length() + "바이트");
    
  }

  public static void ex05() {
      
      /*
       * java.io.ObjectOutputStream 클래스
       * 1. 객체를 그대로 출력하는 출력스트림이다.
       * 2. 직렬화(Serializable)된 객체를 보낼 수 있다.
       *      통김밥을 보낼 수 없어서 자른 김밥을 하나씩 보냄
       * 3. 보조스트림이므로 메인스트림과 함께 사용한다.
       */
      
      // 디렉터리를 File 객체로 만들기
      File dir = new File("C:/storage");
      if(!dir.exists()) {
        dir.mkdirs();
      }
      
      // 파일을 File 객체로 만들기
      File file = new File(dir, "ex05.dat");
      
      // 객체출력스트림 선언
      ObjectOutput oout = null;
      
      try {
      
        // 객체출력스트림 생성 (반드시 예외 처리가 필요한 코드)
        oout = new ObjectOutputStream(new FileOutputStream(file));
        
        // 출력할 데이터(파일로 보낼 데이터)
        String name = "tom";
        int age = 50;
        double height = 180.5;
        String school = "가산대학교";
        Student student = new Student(name, age, height, school);
      
        // 출력(파일로 데이터 보내기)
        oout.writeObject(student);
        
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          if(oout != null) {
            oout.close();  // 출력스트림은 반드시 닫아줘야 함 (반드시 예외 처리가 필요한 코드)
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      
      System.out.println(file.getPath() + " 파일 크기 : " + file.length() + "바이트");
      
    }
    
   
  
  public static void main(String[] args) {

    //ex01();
    //ex02();
    //ex03();
    ex04();
    //ex05();
  }

}
