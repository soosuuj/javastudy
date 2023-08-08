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

import org.json.JSONArray;
import org.json.JSONObject;

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

  public static void ex02() {
    
    /*
     * 네이버개발자센터 - 검색(블로그)
     * 1. 요청주소 : https://openapi.naver.com/v1/search/blog.json
     * 2. 요청변수
     *    1) query   : 필수, 인코딩된 검색어
     *    2) display : 선택, 10 (검색 결과의 개수)
     *    3) start   : 선택, 1
     *    4) sort    : 선택, sim (sim 또는 date)
     */
    
    URL url = null;
    HttpURLConnection con = null;
    BufferedReader reader = null;
    
    try {
      
      String spec = "https://openapi.naver.com/v1/search/blog.json";
      String query = "폭염";
      String display = "10";
      String start = "1";
      String sort = "sim";
      String clientId = "RTJMyHb54a63lvLzPh7A";
      String clientSecret = "0xR9yv0oo3";
      
      StringBuilder sbUrl = new StringBuilder();
      sbUrl.append(spec);
      sbUrl.append("?query=").append(URLEncoder.encode(query, "UTF-8"));
      sbUrl.append("&display=").append(display);
      sbUrl.append("&start=").append(start);
      sbUrl.append("&sort=").append(sort);
      
      url = new URL(sbUrl.toString());
      con = (HttpURLConnection) url.openConnection();
      
      // 요청 메소드
      con.setRequestMethod("GET");  // 반드시 대문자 GET
      
      // 요청 헤더
      con.setRequestProperty("X-Naver-Client-Id", clientId);
      con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
      
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
      // 어제랑 다르게 items를 부르면 [] 임
     JSONObject obj = new JSONObject(sb.toString());
     JSONArray items = obj.getJSONArray("items"); //[{"link":"https://blog.naver.com/gogmwaa/223177374135","postdate":"20230807","description":"<b>폭염<\/b>이 뭐야..?? 강원도 원주 두리캠핑장.. 동영상은 여기에.. 벌써 한 달도 전에 여름 캠핑 계획을 세워놨는데.. 연일 계속되는 <b>폭염<\/b>주의보에.. 에어컨 없이는 조금도 살 수 없을 것 같아.. 이걸 가야 해.. 말아야... ","title":"<b>폭염<\/b>이 뭐야..?? 강원도 원주 두리캠핑장..(23.8.5-6)","bloggerlink":"blog.naver.com/gogmwaa","bloggername":"곰아저씨의 소소한 일상 이야기..."},{"link":"https://blog.naver.com/doojool69/223177160086","postdate":"20230807","description":"장마가 끝나고 낮기온이 35도를 넘는 <b>폭염<\/b>이 극성이라서 취사는 안 하고 잠만 잘 예정인데요. 계곡이... 오후 5시 30분쯤 집으로 출발~ <b>폭염<\/b>으로 많이들 움직이지를 않으셨는지 큰 정체없이 3시간 만에 집에... ","title":"<b>폭염<\/b>캠핑...서해 여름휴가의 베이스캠프... ","bloggerlink":"blog.naver.com/doojool69","bloggername":"낙엽같은 조그만 흔적"},{"link":"https://blog.naver.com/ster1004z/223176783310","postdate":"20230807","description":"엄청난 <b>폭염<\/b>에 온몸은 다 젖었고 마실 물은 없으니 당연한 결과였습니다 숨이 턱턱 막히며 심장은... 태클로 냉장고 가서 초록물고기 괴롭히다가 마무리 했습니다ㅋㅋ 진짜 <b>폭염<\/b> 조심하세요 골로 갈 뻔. 끝.","title":"휴가철 <b>폭염<\/b>에 쓰러질뻔한 쏘가리 낚시","bloggerlink":"blog.naver.com/ster1004z","bloggername":"낚시는 혼자하는 게임"},{"link":"https://blog.naver.com/cynthia0828/223174169965","postdate":"20230803","description":"요즘 <b>폭염<\/b>이 얼마나 심한지, 집안 실내 온도가 33도까지 올라가더라구요. 보통 단열재들이 있기 때문에, 실내 온도가 30도까지 올라가는 경우는 상당히 드문데 확실히 더위가 전년보다도 훨씬 심해진 것... ","title":"아이스넥밴드 <b>폭염<\/b> 이기는 여름 넥워머 냉감목수건 추천","bloggerlink":"blog.naver.com/cynthia0828","bloggername":"Cynthia"},{"link":"https://blog.naver.com/ijun4u/223177168907","postdate":"20230807","description":"▲ 잣향기 푸른숲 매표소 긴 장마가 끝나자 경험하지 못한 <b>폭염<\/b>이 계속되는 여름. 휴가 시즌이라서... ▲ 중요 - 애완견 출입 금지 오늘은 <b>폭염<\/b>이 기승을 부리는 날이어서 산행은 하지 않고 둘레길을 걷기로... ","title":"[잣향기 푸른숲/가평] <b>폭염<\/b>을 즈려밟는 곳","bloggerlink":"blog.naver.com/ijun4u","bloggername":"광야의 기행 \"올라[Hola]~\""},{"link":"https://blog.naver.com/kimyes99/223175639800","postdate":"20230805","description":"<b>폭염<\/b> 때문이라는 것은 핑계일 수 있는 것이 사실은 오전작업을 하면서 너무 지쳐서 늘어져있었다. 오늘 작업을 순조롭게하려고 8월 2일 오전에 일부러 시간을 내어 지붕가까이 부착해야하는 차광막을 걸기위한... ","title":"<b>폭염<\/b>속에 렉산 벽체붙이기","bloggerlink":"blog.naver.com/kimyes99","bloggername":"셀마에 반한 看書痴 블로그"},{"link":"https://blog.naver.com/mabelunefois/223177643213","postdate":"20230808","description":"소망했으나 <b>폭염<\/b>과 함께하는 귀갓길은 순탄치 않았고 ?????? 저런 안내문 살면서 몇번이나 볼건데 덕분에 6시간 걸릴 예정이었던 여정 8시간 걸려서 ... 쓸쓸하게 왔다는 엔딩 <b>폭염<\/b> &amp; 성수기 &amp; 인플레 환장조합... ","title":"강릉 / <b>폭염<\/b>을 뚫고 동해바다로","bloggerlink":"blog.naver.com/mabelunefois","bloggername":"뭐라 하든 말든"},{"link":"https://blog.naver.com/mopaspr/223174554445","postdate":"20230804","description":"<b>폭염<\/b> 중대본 2단계 최초 가동, 이상민 행정안전부 장관 중대본 회의 주재 - 중대본 2단계 발령(8.3.)에 따른 각 부처 및 지자체 대응 점검 - 이례적 <b>폭염<\/b> 상황에 대비하여 분야별 인명·재산 피해 예방에 만전... ","title":"<b>폭염<\/b> 중대본 2단계 최초 가동, 이상민 행정안전부 장관 중대본... ","bloggerlink":"blog.naver.com/mopaspr","bloggername":"대한민국 행정안전부"},{"link":"https://blog.naver.com/mistarno1/223171355638","postdate":"20230801","description":"나니깐 <b>폭염<\/b>이 지속되고 있어서, 진짜 매해가 지날수록 날씨의 변화가 특히나 여름에 많이 발생하는 것 같습니다. <b>폭염<\/b> 정말 조심하시고, 운동도 하시면서 면역력 키우시고 건강관리 조금 더 철저하게... ","title":"로또 예상번호 1079회 <b>폭염<\/b>을 이겨내며","bloggerlink":"blog.naver.com/mistarno1","bloggername":"초록꿈"},{"link":"https://blog.naver.com/ibdream/223176243232","postdate":"20230806","description":"8월 <b>폭염<\/b>에 물이 있고 숲이 있어 시원한 곳을 찾아.... (* 핸드폰 사진 후기) 그냥 오지캠핑이 아닌 배낭 메고 가야하는 곳 가족들을 데리고 가기엔 힘들 수 있지만 그래도 한번 도전!!! 8월 <b>폭염<\/b>이 극성이라... ","title":"8월 <b>폭염<\/b>에 시원한곳을 찾아야 하니~ 가족들과 처음으로... ","bloggerlink":"blog.naver.com/ibdream","bloggername":"20대여 영원하라~! 엔프라니의 캠핑, 레져, 커피 LIFE"}]
     for(int i = 0, length = items.length(); i < length; i++) {
       JSONObject item = items.getJSONObject(i);
       System.out.println((i+1) + "번째 블로그 검색 결과");
       System.out.println("제목 : " + item.getString("title"));
       System.out.println("링크 : " + item.getString("link"));
       System.out.println("요약 : "  + item.getString("description"));
       System.out.println("블로거 : " + item.getString("bloggername"));
       System.out.println("블로거 링크 : " + item.getString("bloggerlink"));
       System.out.println("작성일 : " + item.getString("postdate"));
     }
     
  
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if(reader != null) reader.close();
        if(con != null) con.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } 
    
  }
  
  
  public static void main(String[] args) {
    //ex01();
    ex02();
  }

}
