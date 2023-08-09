package connect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DB_Connect {

  public static Connection getConnection() {  
   // static 붙이면 클래스 메소드 되기 때문에 호출 할 때 클래스 이름으로 호출 가능..
   // DB_Connect.getConnetion()으로 호출 가능 new  없이
   
   
    Connection con = null;  // 1
    
    try (BufferedReader reader = new BufferedReader(new FileReader("src/db.properties"))) {
      
      Class.forName("oracle.jdbc.OracleDriver");   //ex01)
      
      Properties p = new Properties(); //ex02)
      p.load(reader);
      
      con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("user"), p.getProperty("password"));
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return con;   //2
    
  }
  
  
  
  
  

}
