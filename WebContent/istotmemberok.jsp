<%@page import="TriporTrap.traplistdo2"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@page import="MEMBER.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String userid=request.getParameter("userid");
System.out.println("유저아이디 : "+userid);
String returnuserid;
String isok="false";
MemberDAO mao=MemberDAO.getInstance();
try {
	returnuserid=mao.confirmID(userid);
	if(returnuserid==null){
		isok="false";
	}else{
		isok="true";
	}
	
	MemberVO mvo;
	JSONObject jobj=new JSONObject();
	JSONArray jarray=new JSONArray();	
	JSONObject jobjin=new JSONObject();
		jobjin.put("returnuserid", returnuserid);
		jobjin.put("isok", isok);
		jarray.add(0, jobjin);
		jobj.put("trap", jarray);
	
	out.print(jobj);
	out.flush();
} catch (Exception e) {
}

%>