<%@page import="MEMBER.MemberVO"%>
<%@page import="MEMBER.MemberDAO"%>
<%@page import="TriporTrap.traplistdo2"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@page import="TAOTVO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
int trapperaccount=Integer.parseInt(request.getParameter("trapperaccount"));

MemberDAO mao=MemberDAO.getInstance();
try {
	MemberVO mvo=mao.MyScoreAndTraps(trapperaccount);
	
	JSONObject jobj=new JSONObject();
	JSONArray jarray=new JSONArray();	
	
	
		JSONObject jobjin=new JSONObject();
		jobjin.put("score", mvo.getScore());
		jobjin.put("howmanytraps", mvo.getHowmanytraps());		
		jarray.add(0, jobjin);
		jobj.put("trap", jarray);
	out.print(jobj);
	out.flush();
} catch (Exception e) {
}

%>