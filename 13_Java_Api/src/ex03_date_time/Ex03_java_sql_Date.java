package ex03_date_time;

import java.sql.Date;
import java.sql.Timestamp;

public class Ex03_java_sql_Date {

  public static void main(String[] args) {

    // 가장 많이 씀 java.sql.Date  //sql 인지 util 인지 확인
    // DB의 DATE 타입을 처리하는 Date 클래스
    
    // 현재 날짜
    Date date = new Date(System.currentTimeMillis()); //현재 날짜 // long date - 타임스템프  
    System.out.println(date);
    
    // 패키지 존재 이유 - 같은 클래스의 이름을 구분하기 위해서!!
    
    // java.sql.Timestamp 클래스
    // DB의 TIMESTAMP 타입을 처리하는 Timestamp 클래스
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());  // 현재 날짜
    System.out.println(timestamp);   //2023-07-31 14:38:06.295 밀리초까지 확인 가능
    
    
  }

}
