package ex02_api;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Ex05_NaverPapago {
  
  

  public static void main(String[] args) {

    URL url = null;
    HttpURLConnection con = null;
    BufferedOutputStream bout = null;  // 서버로 POST 데이터 보내는 용도
    BufferedReader reader = null; // 번역 결과 text
    
    try {
      
     Scanner sc = new Scanner(System.in);
     System.out.println("번역할 한국어 입력 >>> ");
     String text = sc.nextLine();
      
     String spec ="https://openapi.naver.com/v1/papago/n2mt"; // 파라미터 뒤에 붙이기 안됨  
     String clientId ="s69mitzAnTVJZPIV_Hkc";
     String clientSecret = "G21YQxY5Ku";
     
     // 주소에 안붙이고 따로 outputString으로 처리 예정 - 서버로 데이터 보내기 - get방식이 안되니까!!
     String params = "source=ko&target=en&text=" + text;
     
     url = new URL(spec);
     con = (HttpURLConnection)url.openConnection();
     
     // 요청메소드 post (생략 할 수 없다.)
     con.setRequestMethod("POST");
     
     // 요청 헤더 (클라이언트 id, pw) 
     
     con.setRequestProperty("X-Naver-Client-Id", clientId);
     con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
     
     // OuputStream을 이용해서 POST 데이터를 보내겠다.
     con.setDoOutput(true);
     
     // OutputStream을 이용해서 POST 데이터 보내기
     bout = new BufferedOutputStream(con.getOutputStream()); // com이 서버 - getOutputStream는 byte 데이터 기반으로 int or byte 기반
     //String -> byte[] 로 변경 , params.getByte
     bout.write(params.getBytes());
     bout.flush();  // write로 보냈는데 안가고 stream 안에 있음, flush로 확실하게 보내줌 (빨래로 후~ 불어준다!!)
     
     //-----------서버로 데이터 보내는 과정(요청)--400번오류-------------------
     
     //-----------결과 받기 -----------------------------
     
     int resposeCode = con.getResponseCode();
     if(resposeCode != HttpURLConnection.HTTP_OK) {
       throw new RuntimeException(resposeCode + "발생");
     }
     
     reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
     
     StringBuilder sb = new StringBuilder();
     String line = null;
     while((line = reader.readLine()) != null) {
     sb.append(line);
     }
     
     //message, result, translatedtext 순으로 
     
     JSONObject obj = new JSONObject(sb.toString());
     JSONObject message = obj.getJSONObject("message");
     JSONObject result = message.getJSONObject("result");
     String translatedText = result.getString("translatedText");
     
     System.out.println("번역 결과");
     System.out.println("---------");
     System.out.println(translatedText);

     
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(reader != null) reader.close();
        if(bout != null) bout.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

}
