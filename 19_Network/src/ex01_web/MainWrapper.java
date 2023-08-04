package ex01_web;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainWrapper {

  public static void ex01() {
    
    /*
     * URl <- 잘 알아두기!!
     * 1. Uniform Resource Location
     * 2. 정형화된(모양이 결정된) 자원의 경로(위치) 표기방법 (웹 주소를 의미한다.)
     * 3. 형식 
     *  프로토콜://    호스트      :포트/URlMapping값? 파라미터 = 값&파라미터=값&파라미터=값....
     *     https://search.naver.com:8080/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%ED%8F%AD%EC%97%BC=폭염 // 폭염은 내가 쓴거임 인코딩
     *    1) 프로토콜   : 통신규약, https(secure + http : 보안 처리된 하이퍼텍스트 전송 프로토콜)
     *    2) 호스트     : 서버주소 - 돈주고 사는 것(ex: 가비아), 기본포트(8080)는 생략 가능
     *    3) URlMapping : 서버경로 - 내가 결정
     *    4) 파라미터   : 서버로 보내는 데이터
     */
    
    /*
     * java.net.URL 클래스
     *  1. ULR을 관리하는 클래스이다.
     *  2. URL을 분석하여 원하는 정보를 얻어낼 수 있다.
     *  3. URL에 접속할 수 있는 URLConnection을 생성할 수 있다.
     */
    
    // URL 정보 분석하기
    String apiURL = " https://search.naver.com:8080/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%ED%8F%AD%EC%97%BC=폭염";
    
    // URL 객체 선언
    URL url = null;
    
    try {
      
      // URL 객체 생성
      url = new URL(apiURL); // MalformedURLException 발생(Malformed: 잘못된 형태)
      
      // URL 분석
      System.out.println("프로토콜 : " + url.getProtocol());
      System.out.println("호스트 : " + url.getHost());
      System.out.println("포트번호 : " + url.getPort()); // 안적어두면 -1값 나옴
      System.out.println("파라미터 : " + url.getQuery());
      
    } catch (MalformedURLException e) {
      System.out.println("apiURL형식 오류");
    }
    

  }
  
  public static void ex02() {
    
    // ★단어(>코드) 의 뜻에 초점 맞춰서 알아두기!!(웹개발하는데 웹 용어 모르면 되겠니..?)
    
    // 접속할 주소
    String spec = "https://gdu.co.kr";
    
    // URL 객체 선언
    URL url = null;
    
    // httpURLConnection 객체 선언
    HttpURLConnection con = null;
    
    try {
      
      // URL 객체 생성 (MalformedURLException 발생)
      url = new URL(spec);
      
      //HttpULRConnection 객체 생성(IOException 발생)
     con = (HttpURLConnection)url.openConnection();
     
      /*
      * 
      * HTTP 응답코드
      * 1. 200 : 정상
      * 2. 4xx : 잘못된 요청 (클라이언트(사용자)의 잘못된 요청)
      * 3. 5xx : 서버 오류(잘못된 개발)
      */
      
     // 접속 여부 확인
     int resposeCode = con.getResponseCode();
     System.out.println("접속여부 " + (resposeCode == HttpURLConnection.HTTP_OK));   //접속여부 true
     
     // 요청 헤더(User-Agent) : 무엇으로 접속했는가? 
     String userAgent = con.getRequestProperty("User-Agent");
     System.out.println("User-Agent : " + userAgent);       //User-Agent : Java/17.0.2
     
     // 요청 헤더(Referer) : 이전 주소가 무엇인가?
     String referer = con.getRequestProperty("Referer");
     System.out.println("Referer : " + referer);    //Referer : null
     
     // 요청 해더(Content -Type) : 어떤 타입인가?  //  Content-Type : null //text/html; charset=UTF-8, 근데 null 나옴
     String contentType = con.getRequestProperty("Content-Type");
     System.out.println("Content-Type : " + contentType);
     
     
     /*
      * 요청 메소드
      * 1. GET  : 주소(URL)를 이용한 데이터 전송 
      * 2. POST : 본문(Body)을 이용한 데이터 전송
      */
     // 요청 메소드 :  어떤 방식으로 요청했는가?
     String requestMethod = con.getRequestMethod();
     System.out.println("RequestMethod : " + requestMethod );  //RequestMethod : GET
     
     
   
    } catch (MalformedURLException e) {
      System.out.println("접속 주소 오류");
    }catch(IOException e) {
      System.out.println("접속 오류");
    }
    
    
    
    
  }
    
  
  
  
  
  
  
  public static void main(String[] args) {

    //ex01();
    ex02();
    
    
  }

}
