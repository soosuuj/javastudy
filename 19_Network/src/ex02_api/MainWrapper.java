package ex02_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpConnectTimeoutException;

public class MainWrapper {
  
  public static void ex01() {
    
    /*
     * 한국환경공단 에어코리아 대기오염정보 - 시도별 실시간 측정정보 조회
     * 1. 요청주소 : http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty
     * 2. 요청변수(Request Parameter) :
     *    1) serviceKey : 필수, 인코딩된 인증키
     *    2) returnType : 선택, xlm 또는 json
     *    3) numOfRows  : 선택, 100
     *    4) pageNo     : 선택, 1
     *    5) sidoName   : 필수, 서울
     *    6) ver        : 선택, 1.0
     */
    
    // URL 객체 선언
    URL url = null;
    
    //HttpURLConnection 객체 선언(스코프 문제로 선언만)
    HttpURLConnection con = null;
    BufferedReader reader = null;
    BufferedWriter writer = null;
    
    try {
      
  
    // 필요한 것만 준비해도 되지만 전부 준비해봄
    String spec = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
    String serviceKey = "sXdPjVKntZTpovpAhZzTqg8seI2aeoECE6vwDhFbPq3nQ3g1Ea2DhvgwgIfnOF+Mj79KJsDDBPtYd0cJB8U5JA==";
    String returnType = "xml";
    int numOfRows = 100;
    int  pageNo = 1;
    String sidoName = "서울";
    String ver = "1.0";
    
    StringBuilder sb = new StringBuilder();
    sb.append(spec);
    sb.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));   // 인코딩 처리 - UnsupportedEncodingException   오류
    sb.append("&returnType=").append(returnType);  // ?파라미터= 값&파라미터=값
    sb.append("&numOfRows=").append(numOfRows);
    sb.append("&pageNo=").append(pageNo);
    sb.append("&sidoName=").append(URLEncoder.encode(sidoName,"UTF-8"));
    sb.append("&ver=").append(ver);
    
    // URL 객체 생성 , 주소가 스티링 빌더기 떄문에 toString
    url = new URL(sb.toString());  //MalformedURLException - 잘못된 형식의 url
    
    //HttpURLConnection 객체 생성
    con = (HttpURLConnection)url.openConnection();   // Exception
    
    int returnCode = con.getResponseCode();
    if(con.getResponseCode() != HttpURLConnection.HTTP_OK) {
      throw new RuntimeException(returnCode + " 발생");
    }
    
     reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
     
     StringBuilder sbuf = new StringBuilder();
     String line = null;
     while ((line = reader.readLine()) !=null) {
       sbuf.append(line + "\n");
     }
    
     File dir = new File("C:/storage");
     if(dir.exists() == false){
       dir.mkdirs();
     }
     
     File file = new File(dir, "시도별_실시간_측정정보_조회.xml");
     writer = new BufferedWriter(new FileWriter(file));
     writer.write(sbuf.toString());
     
     System.out.println(file.getPath() + " 파일 생성 완료");
     
        
    } catch (UnsupportedEncodingException e) {
      System.out.println(e.getMessage());
    } catch (MalformedURLException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(writer != null) writer.close();
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
  }

  public static void main(String[] args) {
    ex01();
    
  }

}
