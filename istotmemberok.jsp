<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@page import="MEMBER.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
String userid=request.getParameter("trapperid");

System.out.println("유저아이디 : "+userid);
String trapperidreturn;

MemberDAO mao=MemberDAO.getInstance();

try {
	trapperidreturn=mao.confirmID(userid);
	
	MemberVO mvo;
	JSONObject jobj=new JSONObject();
	JSONArray jarray=new JSONArray();	
	JSONObject jobjin=new JSONObject();
		jobjin.put("trapperidreturn", trapperidreturn);
		jarray.add(0, jobjin);
		jobj.put("trap", jarray);
	
	out.print(jobj);
	out.flush();
} catch (Exception e) {
}

%>