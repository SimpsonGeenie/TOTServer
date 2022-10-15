package MEMBER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import UTIL.ConnectDB;

public class MemberDAO {
	
	Connection conn = null;
	PreparedStatement pre = null;
	ResultSet rs=null;
	
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	public String confirmID(String userid) {
		String trapperaccount = null;
		
		try {
			conn =ConnectDB.getConnection();
			pre = conn.prepareStatement(ConnectDB.SQLQuery(6));
			pre.setString(1, userid);
			rs = pre.executeQuery();
			if (rs.next()) {
				trapperaccount=rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn, pre, rs);
		}
		return trapperaccount;
	}

	public MemberVO getMember(String id) {
		MemberVO mvo = new MemberVO();
		try {
			conn =ConnectDB.getConnection();
			pre = conn.prepareStatement(ConnectDB.SQLQuery(6));
			pre.setString(1, id);
			rs = pre.executeQuery();
			if (rs.next()) {
				ConnectDB.MemberVOSetting(mvo, conn, pre, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn, pre, rs);
		}
		return mvo;
	}

	public int insertMember(MemberVO mvo) {
		int result = 0;
		
		try {
			conn = ConnectDB.getConnection();
			ConnectDB.MemberpreSetting(mvo, conn, pre, ConnectDB.SQLQuery(7));
			result++;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn, pre);
		}
		return result;
	}
	public ArrayList<MemberVO> listMember(String member_name) {
		 ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		
		 try {
		 conn = ConnectDB.getConnection();
		 pre = conn.prepareStatement(ConnectDB.SQLQuery(8));
		 if (member_name == "") {
			 pre.setString(1, "%");
		 } else {
			 pre.setString(1, member_name);
		 }
		 rs = pre.executeQuery();
		 while (rs.next()) {
		 MemberVO mvo = new MemberVO();
		 ConnectDB.MemberVOSetting(mvo, conn, pre, rs);
		 memberList.add(mvo);
		 }
		 } catch (Exception e) {
		 e.printStackTrace();
		 } finally {
			 ConnectDB.close(conn, pre, rs);
		 }
		 return memberList;
	}
	
	public int updateMember(MemberVO mvo) {
		int result = 0;
		try {
			conn = ConnectDB.getConnection();
			 pre = conn.prepareStatement(ConnectDB.SQLQuery(9));
			ConnectDB.MemberpreSetting(mvo, conn, pre, ConnectDB.SQLQuery(9));
			result++;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn, pre);
		}
		return result;
	}
	public int getOutMember(MemberVO mvo) {
		int result = 0;
		
		try {
			conn = ConnectDB.getConnection();
			 pre = conn.prepareStatement(ConnectDB.SQLQuery(10));	
			 pre.setString(1, mvo.getId());			
			result = pre.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.close(conn, pre);
		}
		return result;
	}
	
}