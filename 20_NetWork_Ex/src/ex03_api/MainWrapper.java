package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainWrapper {

  public static void main(String[] args) {
    
    // 문제. 공공데이터포털(datd.go.kr)에서 "한국전력공사_전기차 충전소 운영정보" API를 
    // 결과를 "C:/storage/한국전력공사_전기차_충전소_운영정보.xml"로 저장하시오.

    URL url = null;
    
    HttpURLConnection con = null;
    BufferedReader reader = null;
    BufferedWriter writer = null;
    
    try {
      
      String spec = "http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList";
      String serviceKey = "sXdPjVKntZTpovpAhZzTqg8seI2aeoECE6vwDhFbPq3nQ3g1Ea2DhvgwgIfnOF+Mj79KJsDDBPtYd0cJB8U5JA==";
      int pageNo = 1;
      int numOfRows = 10;
      String addr = "전라남도 나주시 빛가람동 120";

      
      StringBuilder sb = new StringBuilder();
      sb.append(spec);
      sb.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
      sb.append("&pageNo=").append(pageNo);
      sb.append("&numOfRows=").append(numOfRows);
      sb.append("&addr=").append(URLEncoder.encode(addr, "UTF-8"));
      
      url = new URL(sb.toString());
      con = (HttpURLConnection) url.openConnection();

      int returnCode = con.getResponseCode();
      if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
          throw new RuntimeException(returnCode + " 발생");
      }

      reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

      StringBuilder sbuf = new StringBuilder();
      String line = null;
      while ((line = reader.readLine()) != null) {
          sbuf.append(line + "\n");
      }

      File dir = new File("C:/storage");
      if (!dir.exists()) {
          dir.mkdirs();
      }

      File file = new File(dir, "한국전력공사_전기차_충전소_운영정보.xml");
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
          if (writer != null)
              writer.close();
          if (reader != null)
              reader.close();
          if (con != null)
              con.disconnect();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  }
}
