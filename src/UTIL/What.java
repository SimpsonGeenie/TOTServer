package UTIL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class What {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pre = null;
		ResultSet rs=null;
		
		String sql="show tables;";
		//String sql="create table aaa values(
//			id number(10),
//			name varchar(20)
		//);";
		//String sql="delete table aaa;";
		
		
		try {
			conn =ConnectDB.getConnection();
			pre = conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next()){
				String str=rs.getString(0);
				System.out.println(str);		
				}
		
			
			System.out.println("complete");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnectDB.close(conn, pre, rs);
	}

}
