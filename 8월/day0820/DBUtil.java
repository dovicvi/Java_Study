package day0820;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String driver="com.mysql.cj.jdbc.Driver"; 
    private static final String url="jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8"; 
    private static final String user="ssafy"; 
    private static final String password="ssafy";
    
    static {//static영역: 클래스가 참조 또는 로딩 되었을때 가장 먼저 실행
       try {
		Class.forName(driver); //1
	   } catch (ClassNotFoundException e) {
		e.printStackTrace();
	  }
    }
    
    public static Connection getConnection() {
      Connection conn=null;	
      try {
		  conn = DriverManager.getConnection(url,user,password);//2
		} catch (SQLException e) {
			e.printStackTrace();
		}
      return conn;
    }//getConnection
    
    public static void close(AutoCloseable ac) {
    	try {
			if(ac != null)ac.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }//close
	
}



