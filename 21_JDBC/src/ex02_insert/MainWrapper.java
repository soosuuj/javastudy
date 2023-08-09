package ex02_insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import connect.DB_Connect;
import dto.UserDto;

public class MainWrapper {

  public static void main(String[] args) {

    // User 정보 입력
    Scanner sc = new Scanner(System.in);
    System.out.println("USER_ID >>> ");
    String user_id = sc.next();
    sc.nextLine();
    System.out.println("USER_NAME >>> ");
    String user_name = sc.nextLine();
    sc.close();  // 정보 입력 끝
    
    // UserDto 생성
    UserDto user = new UserDto();
    user.setUser_id(user_id);
    user.setUser_name(user_name);
    
    // Connection 객체 선언 (DB 접속)
    Connection con = null;
    
    // PreparedStatement 객체 선언 (쿼리문 실행) , 미리 쿼리문 준비하고 사용해야함, Statement 쿼리문을 의미
    PreparedStatement ps = null;
    
    try {
      
      // Connection 객체 생성 (DB_Connect 클래스의 getConnection 메소드로부터 받아오기)
      con = DB_Connect.getConnection();
      
      // 쿼리문 - 이거먼저 준비하고  PreparedStatement 요거 진행 
      // 변수가 들어갈 자리는 ? 써야함 - 약속!
      // 오라클에서 현재 날짜와 시간 DATE 타입의 시간 함수... SYSDATE
      // JDBC ; 붙이면 안됨...
      String sql = "";
      sql += "INSERT INTO USER_T (USER_NO, USER_ID, USER_NAME, JOINED_AT) ";
      sql += "VALUES(USER_SEQ.NEXTVAL, ?, ?, SYSDATE)";
      
      // PreparedStatement 객체 생성
      ps = con.prepareStatement(sql);
      
      // 쿼리문(?)에 변수 넣기  -> 인서트 업데이트 모두 하고 있다고 생각하면 됨
      ps.setString(1, user.getUser_id());    // 1번째 물음표에  ← user.getUser_id() 넣어라
      ps.setString(2, user.getUser_name());  // 2번째 물음표에  ← getUser_name() 넣어라
      
      // 쿼리문 실행 : insert 된 행의 개수가 반환된다.
      int insertResult = ps.executeUpdate();
      
      // 결과 
      System.out.println(insertResult + "개의 행이 삽입되었습니다.");  // 성공했다면 1, 실해했다면 0 
      
      // 커밋? 안 한다.
      // con.setAutoCommit(true); <- 기본값으로 사용되고 있다. // 자바라서 안하는게 아니라 AutoCommit
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(ps != null) ps.close();
        if(con != null) con.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
 
  }

}
