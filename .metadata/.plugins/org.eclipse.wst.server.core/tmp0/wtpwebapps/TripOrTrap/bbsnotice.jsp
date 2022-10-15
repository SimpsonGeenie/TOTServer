<%@page import="NoticeBBS.*"%>
<%@page import="QnABBS.*"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
int notinum=Integer.parseInt(request.getParameter("notinum"));
System.out.println("페이지 넘버 : "+notinum);

NoticeDAO nao=NoticeDAO.getInstance();

	NoticeVO nvo=nao.getNoti(notinum);
	
	JSONObject jobj=new JSONObject();
	JSONArray jarray=new JSONArray();	
	
	
		JSONObject jobjin=new JSONObject();
		jobjin.put("notinum", nvo.getNotinum());		
		jobjin.put("admin", nvo.getAdmin());
		jobjin.put("title", nvo.getTitle());
		jobjin.put("content", nvo.getContent());
		jobjin.put("notidate", nvo.getIndate().toString());
		jarray.add(0, jobjin);
		jobj.put("noti", jarray);
	
	out.print(jobj);
	out.flush();


%>