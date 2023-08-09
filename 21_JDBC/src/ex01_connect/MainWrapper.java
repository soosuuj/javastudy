package ex01_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainWrapper {
  
  // 1. oracle.jdbc.OracleDriver 클래스 메모리에 Load
  
  public static void ex01() {
    
    try {
      Class.forName("oracle.jdbc.OracleDriver");
    } catch (ClassNotFoundException e) {
      System.out.println("OracleDriver 클래스가 없다.");
    }

  }
  
  // 2. java.sql.Connection 객체 생성 (DB 접속 생성)  //java.sql에 있는  Connection
  public static void ex02() {
   
    // 접속 정보 //express edition 의미 thin - 매번 들어감!!
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user ="GD";
    String password ="1111";
    
    // Connection 객체 선언
    Connection con = null;
    
    
    // Connection 객체 생성
    try {
      con = DriverManager.getConnection(url, user, password);
      System.out.println("DB 접속 성공");
    } catch (SQLException e) {
      System.out.println("DB 접속 실패");
    } finally {
      // Connection 객체 소멸
    try {
      if(con != null) con.close();
    } catch (SQLException e) {
      System.out.println("DB 접속 닫기 실패");
    } 
   }
    
  }
  
  

  public static void main(String[] args) {
    ex01();
    ex02();
    
  }

}
