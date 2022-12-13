package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
   public static Connection getConnection() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","project","1234");
         return con;
      } catch (Exception e) {
         System.out.println("oracle 연동 실패");
      }
      return null;
   }

//      나중에 생성한 것 부터 닫아줌 / rs -> stmt -> conn
//   insert, update, delete는 이거
   public static void close(PreparedStatement stmt, Connection conn) {
      if (stmt != null) {
         try {
            if(!stmt.isClosed()) {
               stmt.close();                           
            }
         } catch (Exception e) {
            System.out.println("PreparedStatement close error");
         }
      }
      if (conn != null) {
         try {
            if(!conn.isClosed()) {
               conn.close();
            }
         } catch (Exception e) {
            System.out.println("Connection close error");
         }
      }
   }

//   select는 rs까지 닫아줘야함
   public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
      if (rs != null) {
         try {
            if(!rs.isClosed()) {
               rs.close();                           
            }
         } catch (Exception e) {
            System.out.println("ResultSet close error");
         }
      }
      close(stmt, conn);
      
   }
   
   
}