<%@page import="QnABBS.*"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
int qnanumber=Integer.parseInt(request.getParameter("qnanumber"));

QnaDAO qao=QnaDAO.getInstance();
try {
	QnaVO qvo=qao.getQna(qnanumber);
	
	JSONObject jobj=new JSONObject();
	JSONArray jarray=new JSONArray();	
	
	
		JSONObject jobjin=new JSONObject();
		jobjin.put("qnanum", qvo.getQnanum());		
		jobjin.put("trapperaccount", qvo.getTrapperaccount());
		jobjin.put("title", qvo.getTitle());
		jobjin.put("content", qvo.getContent());
		jarray.add(0, jobjin);
		jobj.put("qna", jarray);
	
	out.print(jobj);
	out.flush();
} catch (Exception e) {
}

%>