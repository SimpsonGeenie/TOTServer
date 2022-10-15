package UTIL;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONObject;

import MEMBER.MemberVO;
import TAOTVO.TrapVO;

public class ConnectDB {

	public static Connection getConnection(){
		Connection conn=null;		
		try {
			String driverName="com.mysql.jdbc.Driver";
			//String dbURL="jdbc:mysql://totserver.mooo.com:3306/tot";
			//String dbURL="jdbc:mysql://localhost:3307/tot";
			String dbURL="jdbc:mysql://localhost:3306/tot";
			String dbUser="root";
			String dbUserpw="1234";
			//String dbUserpw="nudeogi07";
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL, dbUser, dbUserpw);
			
			System.out.println("conn compl");	
			
			
			System.out.println("Connect Check OK");
			
		} catch (Exception e) {
			System.out.println("Error From Connection");
		}
		return conn;		
	}
	
	public static String SQLQuery(int querytype){
		
		String sql=null;
		
		switch(querytype){
		
		case 1:
			sql="select * from triportrap order by trappicaccount desc";
			break;
			
		case 2:
			sql="select * from triportrap where trappicaccount=?";
			break;
			
		case 3:
//			sql="insert into triportrap (trappicaccount,"+
//					"trapperaccount,address,latitude,longitude,xAxis,"+
//					"yAxis,zAxis,heading,pitch,roll,"+
//					"picturewidth ,pictureheight, pictureurl)values (triportrap_seq.nextval,"+
//					"?,?,?,?,?,"+
//					"?,?,?,?,?,"+
//					"?,?,?)";
			sql="insert into triportrap ("+
					"trapperaccount,addre,latitude,longitude,xAxis,"+
					"yAxis,zAxis,heading,pitch,roll,trapunlock,"+
					"imgwidth ,imgheight, pictureurl)values ("+
					"?,?,?,?,?,"+
					"?,?,?,?,?, false,"+
					"?,?,?)";
			
			break;
			
		case 4:
			sql="update triportrap set trapunlock=?, "+
		"unlockeraccount=?, "+
		"unlockpictureurl=? , "+
		"unlockpictureurlspath=? "+
		"where trappicaccount=?";
			break;
			
		case 5:
			sql="delete triportrap where pictureurl=?";
			break;
		//TRAP SQL End
			
		case 6:
			sql="select userid from totmember where userid=?";
			break;
			
		case 7:
			sql="insert into totmember(userid, pwd, name, zip_num,"+
			 " address, phone) values(?, ?, ?, ?, ?, ?)";
			break;
			
		case 8:
			sql="select * from totmember where name like '%'||?||'%' "+
					" order by indate desc";
			break;
			
		case 9:
			sql="update totmember set pwd=?, name=?, zip_num=?,"+
					" addre=?, phone=? where id=?";
			break;
			
		case 10:
			sql="delete totmember where id=?";
			break;
			
		case 11:
			sql="delete triportrap where pictureurl=?";
			break;
			
		case 12:
			sql="delete triportrap where pictureurl=?";
			break;
			
			
			
		}
		return sql;
	}
	
	public static void traptvoSetting(TrapVO tvo, JSONObject jobj, Connection conn, PreparedStatement pre, ResultSet rs) throws SQLException{
		tvo.setTrappicaccount(rs.getInt("trappicaccount"));
		tvo.setTrapperaccount(rs.getInt("trapperaccount"));
		tvo.setAddre(rs.getString("addre"));
		tvo.setLatitude(rs.getDouble("latitude"));
		tvo.setLongitude(rs.getDouble("longitude"));
				
		tvo.setxAxis(rs.getDouble("xAxis"));
		tvo.setyAxis(rs.getDouble("yAxis"));
		tvo.setzAxis(rs.getDouble("zAxis"));
		tvo.setHeading(rs.getDouble("heading"));
		tvo.setPitch(rs.getDouble("pitch"));
		tvo.setRoll(rs.getDouble("roll"));
		
		tvo.setPictureurl(rs.getString("pictureurl"));
				
		tvo.setPictureurlspath(rs.getString("pictureurlspath"));
		if(rs.getBoolean("trapunlock")==false)
			tvo.setTrapunlock(false);
		else
			tvo.setTrapunlock(true);				
		tvo.setImgwidth(rs.getInt("imgwidth"));
		tvo.setImgheight(rs.getInt("imgheight"));
		
		tvo.setUnlockeraccount(rs.getInt("unlockeraccount"));
		tvo.setUnlockpictureurl(rs.getString("unlockpictureurl"));
		tvo.setUnlockpictureurlspath(rs.getString("unlockpictureurlspath"));	
		
	}
	
	public static void trappreSetting(TrapVO tvo, Connection conn, PreparedStatement pre, String sql, int type) throws SQLException{

		switch(type){
		case 1:
			pre = conn.prepareStatement(sql);
			pre.setInt(1, tvo.getTrapperaccount());
			pre.setString(2,tvo.getAddre());
			pre.setDouble(3, tvo.getLatitude());
			pre.setDouble(4, tvo.getLongitude());
			pre.setDouble(5, tvo.getxAxis());
			pre.setDouble(6, tvo.getyAxis());
			pre.setDouble(7, tvo.getzAxis());
			pre.setDouble(8, tvo.getHeading());
			pre.setDouble(9, tvo.getPitch());
			pre.setDouble(10, tvo.getRoll());
			pre.setInt(11, tvo.getImgwidth());
			pre.setInt(12, tvo.getImgheight());
			pre.setString(13, tvo.getPictureurl());
			pre.executeUpdate();
			break;
		
		case 2:
			pre = conn.prepareStatement(sql);
			pre.setBoolean(1, true);
			pre.setInt(2, tvo.getUnlockeraccount());
			pre.setString(3, tvo.getUnlockpictureurl());
			pre.setString(4, tvo.getUnlockpictureurlspath());
			pre.setString(5, tvo.getPictureurl());
			pre.executeUpdate();	
			break;
		}
		
		
	}
	
	public static void MemberVOSetting(MemberVO mvo, Connection conn, PreparedStatement pre, ResultSet rs) throws SQLException{
		mvo.setId(rs.getString("id"));
		mvo.setPwd(rs.getString("pwd"));
		mvo.setName(rs.getString("name"));
		mvo.setEmail(rs.getString("email"));
		mvo.setZipNum(rs.getString("zip_num"));
		mvo.setAddress(rs.getString("address"));
		mvo.setPhone(rs.getString("phone"));
		mvo.setUseyn(rs.getString("useyn"));
		mvo.setIndate(rs.getTimestamp("indate"));
	}
		
	public static void MemberpreSetting(MemberVO mvo, Connection conn, PreparedStatement pre, String sql) throws SQLException{

			pre = conn.prepareStatement(sql);
			pre.setString(1, mvo.getId());
			pre.setString(2, mvo.getPwd());
			pre.setString(3, mvo.getName());
			pre.setString(4, mvo.getZipNum());
			pre.setString(5, mvo.getAddress());
			pre.setString(6, mvo.getPhone());
			pre.executeUpdate();		
	}
		
	public static void close(Connection conn, PreparedStatement pre, ResultSet rs){
	
		try {
			rs.close();
			pre.close();
			conn.close();
			System.out.println("Disconnect Check OK");
		} catch (SQLException e) {
			System.out.println("Error From Disconnect");
			e.printStackTrace();
		}
		
	}
	
	public static void close(Connection conn, PreparedStatement pre){
		
		try {			
			pre.close();
			conn.close();
			System.out.println("Disconnect Check OK");
		} catch (SQLException e) {
			System.out.println("Error From Disconnect");
			e.printStackTrace();
		}
		
	}
	
}
