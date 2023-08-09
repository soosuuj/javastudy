package ex02_api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Ex04_NaverCaptcha {
  // https://developers.naver.com/docs/utils/captcha/reference/
  // static은 main에서 부르려고 작성, 웹 개발 시 필요 없음!!
  // 여러번 쓰지 않기 위해 필드로 잡음
  private static final String CLIENT_ID ="s69mitzAnTVJZPIV_Hkc";
  private static final String CLIENT_SECRET ="G21YQxY5Ku";
  
  private static String getKey() {
    

    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    String result = null;
    
    try {
      
    // 코드 필수 아님,  기본값 0 안써도 됨 "?code=0" - 마지막에 추가해도 됨
    String spec = "https://openapi.naver.com/v1/captcha/nkey";
      
      url = new URL(spec);
      con = (HttpURLConnection)url.openConnection();
      
      con.setRequestMethod("GET"); // http 메서드 GET으로 지정됨
      
      con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
      con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
      
      
      int responseCode = con.getResponseCode();
      if(responseCode != HttpURLConnection.HTTP_OK) {
        throw new RuntimeException(responseCode + " 발생");

      }
    
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line);
      }
      System.out.println(sb.toString());
    
      JSONObject obj = new  JSONObject(sb.toString());
      result =  obj.getString("key");

      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      }catch (Exception e) {
        e.printStackTrace();
      }
    }
    
  return result;
    
  }
  
  private static String getImage() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedInputStream bin = null;
    BufferedOutputStream bout = null;
    String key = null;
    
    
    try {
     
    key = getKey();
    String spec ="https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
    
    url = new URL(spec);  // 주소가 달라졌으니까 또 해야함 재활용 불가
    con = (HttpURLConnection)url.openConnection();
    
    con.setRequestMethod("GET");
    
    con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
    con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
    
    int responseCode = con.getResponseCode();
    if(responseCode != HttpURLConnection.HTTP_OK) {
      throw new RuntimeException(responseCode + "발생");
     
    }
    
    bin = new BufferedInputStream(con.getInputStream()); //문자로 바꿀 리더 없어도 되니까
    
    File dir = new File("C:/storage");
    if(dir.exists() == false) {
      dir.mkdirs();
    }
                                          // 중복 발생 방지 - 랜덤값 , UUID, 시간 timeStamp 자바 api에서 찾아보기
    File file = new File(dir, System.currentTimeMillis() + ".jpg");  //"a.jpeg" 이렇게 쓰면 계속 덮어쓰기 됨, 그게 싫으면 변수로 변하게 해주면 됨
    bout = new BufferedOutputStream(new FileOutputStream(file));
    
    byte[] b = new byte[1024]; // 1kb씩
    
    int readByte = 0; // 실제로 읽은 바이트
    
    while((readByte = bin.read(b)) != -1 ) { // 실제 읽은 내용 b에 저정되어있음
      bout.write(b, 0, readByte);  // readByte에서 읽어들인만큼 write
    }
    
    //System.out.println(file.getPath() + "파일 생성 완료");
    

    
     }catch (Exception e) {
      System.out.println(e.getMessage());
    }finally {
      try {
        if(bout != null) bout.close();
        if(bin != null) bin.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return key;
  }
  
  
  public static void validInput() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    
    try {
      
   String key = getImage();
    
    Scanner sc = new Scanner(System.in);
    System.out.println("입력 >>> ");
    String value = sc.next();
    
    String spec = "https://openapi.naver.com/v1/captcha/nkey?code=1&key=" + key + "&value=" + value;
    
    url = new URL(spec);
    con = (HttpURLConnection)url.openConnection();
    
    con.setRequestMethod("GET");
    
    con.setRequestProperty("X-Naver-Client-Id", CLIENT_ID);
    con.setRequestProperty("X-Naver-Client-Secret", CLIENT_SECRET);
    
    int responseCode = con.getResponseCode();
    if(responseCode != HttpURLConnection.HTTP_OK) {
      throw new RuntimeException(responseCode + "발생");
      
    }
    
    reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
    
    StringBuilder sb = new StringBuilder();
    String line = null;
    while((line = reader.readLine())  != null ) {
      sb.append(line);  // sb.toString 에  {"result":true,"responseTime":84.6} 값 저장되어있음
    }
    
    // 응답 결과
    JSONObject obj = new JSONObject(sb.toString()); // sb.toString -> JSONObject 로 변경하여 불린으로 
    System.out.println("응답시간 : " + obj.getDouble("responseTime"));
    if(obj.getBoolean("result")) {
    System.out.println("맞습니다.");
    }else {
      System.out.println("틀립니다.");
    }
    
    }catch (Exception e) {
      System.out.println(e.getMessage());
    }finally {
      try {
        if(reader != null ) reader.close();
        if(con != null) con.disconnect();
    }catch (Exception e) {
      e.printStackTrace();
    }

   }
  
    
  }
  

  
  
  public static void main(String[] args) {

    
    validInput();
    //getImage(); ex02();
    
    // ex01(); 만들고 호출
    //String key = getKey();
    //System.out.println("캡차키 : " + key);
    
    
  }

}
