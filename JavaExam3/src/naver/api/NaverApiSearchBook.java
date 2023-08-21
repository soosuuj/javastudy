package naver.api;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class NaverApiSearchBook {
  
  private void generateImage(String spec) {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedInputStream bin = null;
    BufferedOutputStream bout = null;

    
    
    try {
      
      // 파라미터 String spec에는 다운로드 받을 이미지 파일의 URL이 전달된다.
      // 해당 URL의 이미지 파일을 다운로드 받는다.
      
      
      // URL 객체 생성
      url = new URL(spec);
      
      // HttpURLConnection 객체 생성
      con = (HttpURLConnection) url.openConnection();
      
      // 입력스트림 생성
      bin = new BufferedInputStream(con.getInputStream());

      // 출력할 파일 File 객체
      File dir = new File("C:/download");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      String contentType = con.getContentType();
      String extName = contentType.substring(contentType.indexOf("/") + 1);
      
      LocalDateTime now = LocalDateTime.now();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
      String fileName = "thumbnail_" + now.format(formatter) + "." + extName; // 파일명 생성
      
      
      File file = new File(dir, fileName);
      
      // 출력스트림 생성
      bout = new BufferedOutputStream(new FileOutputStream(file));
      
      // 읽은 데이터를 저장할 바이트 배열
      byte[] b = new byte[1024];  // 1KB씩 읽기
      
      // 실제로 읽은 바이트 수
      int readByte = 0;
      
      // 읽기 (다음 로고 이미지를 byte[] b에 저장하기)     
      // 쓰기 (byte[] b의 내용을 daum.png 파일로 보내기)
      while((readByte = bin.read(b)) != -1) {
        bout.write(b, 0, readByte);
      }
      
      // 확인 메시지
      System.out.println(file.getPath() + "  파일 다운로드 완료");


      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(bout != null) bout.close();
        if(bin != null) bin.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
  }
  
  public void getSearchList() {
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    
    Scanner sc = new Scanner(System.in);
    System.out.print("검색어를 입력하세요: ");
    String query = sc.nextLine();
    
  
    try {
      
      // 책 검색 OpenAPI를 사용해서 응답 결과 중 이미지(image) 결과만 추출하여
      // generateImage 메소드에 전달한다.
      // 10번의 generateImage 메소드 호출이 필요하다.
      
      
      String spec ="https://openapi.naver.com/v1/search/book.json";
      //String  query = sc.next();


      

      String clientId = "s69mitzAnTVJZPIV_Hkc";
      String clientSecret = "G21YQxY5Ku";
     
      StringBuilder sbUrl = new StringBuilder();
      sbUrl.append(spec);
      sbUrl.append("?query=").append(URLEncoder.encode(query, "UTF-8"));


      
      

      url = new URL(sbUrl.toString());
      con = (HttpURLConnection)url.openConnection();
      
      con.setRequestMethod("GET");
      
      con.setRequestProperty("X-Naver-Client-Id", clientId);
      con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

      int resposeCode = con.getResponseCode();
      if(resposeCode != HttpURLConnection.HTTP_OK) {

      }
      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
      
      StringBuilder sb = new StringBuilder();
      String line = null;
      while((line = reader.readLine()) != null) {
        sb.append(line + "\n");
      }

      JSONObject obj = new JSONObject(sb.toString());
      JSONArray items = obj.getJSONArray("items");
      for (int i = 0, length = items.length(); i < length; i++) {
          JSONObject item = items.getJSONObject(i);
          
          String imageUrl = item.getString("image");
          generateImage(imageUrl); 


        
      }


      
    } catch (Exception e) {
      sc.close();
      
      LocalDateTime now = LocalDateTime.now();
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss");
      String time = dtf.format(now);
      
      
      // 예외 클래스 이름
      String clazz = e.getClass().getName();
      
      // File 객체   log 파일 만들기
      File dir = new File("C:/download/log");
      if(dir.exists() == false) {
        dir.mkdirs();
      }
      File file = new File(dir, "log.txt");
      
      //try -catch - resources
      // 추가모드 : 기존 파일에 내용을 추가하는 모드 new FileWriter(file, true)
      try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
        
        // 로그 파일에 "시간 예외메지 예외 클래스" 추가하기
        bw.write(time + "  " + clazz);
        bw.newLine();
        
        // 결과 메서지 
        System.out.println(file.getPath() + "파일 예외 처리 완료");
        
      }catch (IOException e2) {
        e2.printStackTrace();
      }
    }
    
  }
  
}
