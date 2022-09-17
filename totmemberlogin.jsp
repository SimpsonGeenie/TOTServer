<%@page import="MEMBER.*"%>
<%@page import="TriporTrap.traplistdo2"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@page import="TAOTVO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
String trapperid=request.getParameter("trapperid");
String trapperpw=request.getParameter("trapperpw");
System.out.println("유저pw : "+trapperpw);

MemberDAO mao=MemberDAO.getInstance();
int trapperaccount=mao.Login(trapperid, trapperpw);
try {
	
	JSONObject jobj=new JSONObject();
	JSONArray jarray=new JSONArray();	
	
	JSONObject jobjin=new JSONObject();
	
	jobjin.put("trapperaccount", trapperaccount+"");
	jarray.add(0, jobjin);
	jobj.put("trap", jarray);
	
	out.print(jobj);
	out.flush();
} catch (Exception e) {
}

%>