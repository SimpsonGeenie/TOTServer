package TriporTrap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import TAOTVO.TrapVO;



public class testingmac {

	public static void main(String[] args) {
		Connection conn = null;       
		PreparedStatement pre = null;
		ResultSet rs=null;
		
		
		String dbURL="jdbc:mysql://totserver.mooo.com:3306/tot";
		String dbUser="root";
		String dbUserpw="nudeogi07";		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(dbURL,dbUser,dbUserpw);
			System.out.println("����� ����Ǿ����ϴ�."); 
			
			
			String table="show tables;";
			String sql="select * from triportrap;";
			pre = conn.prepareStatement(table);
			rs=pre.executeQuery();
			while(rs.next()){				
				System.out.println("�����" + rs.getString(1));
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	
	}
	
	

}
