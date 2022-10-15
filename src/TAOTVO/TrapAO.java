package TAOTVO;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.net.ftp.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import UTIL.ConnectDB;

import java.io.File;
import java.io.FileNotFoundException;

public class TrapAO {
	int type;
	HttpServletResponse response;
	Connection conn = null;
	PreparedStatement pre = null;
	ResultSet rs=null;
	
	private static TrapAO inst = new TrapAO();
	
	public static TrapAO getInstance() {
		return inst;
	}

	public List<TrapVO> selectalltrap() throws Exception{
				
		List<TrapVO> traplist=new ArrayList<TrapVO>();
		JSONObject jobj=new JSONObject();
		JSONArray jarray=new JSONArray();
		TrapVO tvo=new TrapVO();
		try {
			conn =ConnectDB.getConnection();
			pre = conn.prepareStatement(ConnectDB.SQLQuery(1));
			rs=pre.executeQuery();
			System.out.println("List Check");			
			while(rs.next()){
				tvo=new TrapVO();
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
				traplist.add(tvo);				
				System.out.println("List Check Fine");
			}			
		} catch (Exception e) {
			System.out.println("Error from selecting SQL : "+e);
		}finally {
			ConnectDB.close(conn, pre, rs);
		}
		return traplist;
	}
	
	public TrapVO selecttrap(String trappicaccount) throws Exception{
		TrapVO tvo=new TrapVO();		
		try {
			
			conn =ConnectDB.getConnection();
			pre = conn.prepareStatement(ConnectDB.SQLQuery(2));
			pre.setString(1, trappicaccount);
			rs=pre.executeQuery();
			if(rs.next()){
				tvo=new TrapVO();
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
				tvo.setTrapunlock(rs.getBoolean("trapunlock"));		
				tvo.setImgwidth(rs.getInt("imgwidth"));
				tvo.setImgheight(rs.getInt("imgheight"));
				
				tvo.setUnlockeraccount(rs.getInt("unlockeraccount"));
				tvo.setUnlockpictureurl(rs.getString("unlockpictureurl"));
				tvo.setUnlockpictureurlspath(rs.getString("unlockpictureurlspath"));					
		}
		} catch (Exception e) {
			System.out.println("Error from selecting SQL : "+e);
		}finally {
			ConnectDB.close(conn, pre, rs);
		}
		return tvo;
	}
	
	public void addtrap(TrapVO tvo) throws SQLException, FileNotFoundException{
		
		try {
			conn =ConnectDB.getConnection();
			pre = conn.prepareStatement(ConnectDB.SQLQuery(3));
			System.out.println("Check Point : before pre set");
			ConnectDB.trappreSetting(tvo, conn, pre, ConnectDB.SQLQuery(3), 1);
			System.out.println("Check Point : before execute");			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error from insert "+e);
		}finally {
			ConnectDB.close(conn, pre);
		}
	}
	
	public void trapunlock(TrapVO tvo) throws SQLException{
		try {
			conn =ConnectDB.getConnection();
			String sql="update triportrap set trapunlock=?, "+
					"unlockeraccount=?, "+
					"unlockpictureurl=? "+
					"where trappicaccount=?";
			pre = conn.prepareStatement(sql);
			pre.setBoolean(1, true);
			pre.setInt(2, tvo.getUnlockeraccount());
			pre.setString(3, tvo.getUnlockpictureurl());
			pre.setInt(4, tvo.getTrappicaccount());
			pre.executeUpdate();
			
			System.out.println("언락 완료");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error from update "+e);
		}finally {
			ConnectDB.close(conn, pre);
		}
		
	}
	
	public void deltrap(String pictureurl) throws SQLException{		
		try {
			conn =ConnectDB.getConnection();
			pre = conn.prepareStatement(ConnectDB.SQLQuery(5));
			pre.setString(1, pictureurl);
			pre.executeUpdate();						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error from delete "+e);
		}finally {
			ConnectDB.close(conn, pre);
		}
	}
	
	public void ftpupload(File file) throws Exception{
		
		//String ftpIP = "mustory.ivyro.net";
		String ftpIP = "192.168.10.31:21";
        String ftpID = "mustory";
        String ftpPW = "nudeogi07";
        //String ftpServerPath="/public_html/tot";
        String ftpServerPath="/tot";
        FTPClient ftpConn = null;
        
        try {
            System.out.println(ftpIP + "Connect Success");
            ftpConn = new FTPClient(); 
            ftpConn.setControlEncoding("utf-8");
            ftpConn.connect(ftpIP);
            ftpConn.login(ftpID, ftpPW);
            ftpConn.changeWorkingDirectory(ftpServerPath);
		    ftpConn.setFileType(FTP.BINARY_FILE_TYPE); 

    		FileInputStream fis = new FileInputStream(file);
            ftpConn.storeFile(file.getName(), fis);
            System.out.println("Perfect!");            
            
        } catch (Exception e) {
        	System.out.println("Error From Connect FTP");
        }
        ftpConn.disconnect();
	}
	
}
