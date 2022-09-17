<%@page import="QnABBS.*"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
String trapperaccount;
String bbstitle;
String bbscontent;


QnaDAO qao=QnaDAO.getInstance();
QnaVO qvo=new QnaVO();



try {
	trapperaccount=request.getParameter("trapperaccount");
	System.out.println("유저어카운트 : "+trapperaccount);
	bbstitle=request.getParameter("bbstitle");
	System.out.println("bbstitle : "+bbstitle);
	bbscontent=request.getParameter("bbscontent");
	System.out.println("bbscontent : "+bbscontent);
	String trappernickname=qao.findnick(trapperaccount);
	
	qvo.setTrapperaccount(Integer.parseInt(trapperaccount));
	qvo.setTrappernickname(trappernickname);
	qvo.setTitle(bbstitle);
	qvo.setContent(bbscontent);
	
	String returnstr=qao.insertqna(qvo);
	
	
	JSONObject jobj=new JSONObject();
	JSONArray jarray=new JSONArray();	
	
	
		JSONObject jobjin=new JSONObject();
		jobjin.put("returnstr", returnstr);		
		jarray.add(0, jobjin);
		jobj.put("qna", jarray);
	
	out.print(jobj);
	out.flush();
} catch (Exception e) {
}

%>