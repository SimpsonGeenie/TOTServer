package UTIL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs=null;
		
		//String sql="show tables;";
		String sql="create table aasa (id integer(10), name varchar(20));";
		//String sql="delete table aaa;";
		
		
		try {
			String driverName="com.mysql.jdbc.Driver";
			String dbURL="jdbc:mysql://totserver.mooo.com:3306/tot";
			String dbUser="root";
			String dbUserpw="nudeogi07";
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL, dbUser, dbUserpw);
			System.out.println("Connect Check OK");
			//conn =ConnectDB.getConnection();
			pre = conn.prepareStatement(sql);
			pre.executeUpdate();
			
//			rs=pre.executeQuery();
//			if(rs.next()){
//				String str=rs.getString(1);
//				System.out.println(str);		
//				}
		
			
			System.out.println("complete");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectDB.close(conn, pre);
	}

}
