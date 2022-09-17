<%@page import="NoticeBBS.*"%>
<%@page import="QnABBS.*"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
NoticeDAO nao=NoticeDAO.getInstance();
try {
	ArrayList<NoticeVO> qnalist=nao.listNoti();
	
	JSONObject jobj=new JSONObject();
	JSONArray jarray=new JSONArray();	
	
	for(int i=0;i<qnalist.size();i++){
		JSONObject jobjin=new JSONObject();
		jobjin.put("notinum", qnalist.get(i).getNotinum());		
		jobjin.put("admin", qnalist.get(i).getAdmin());
		jobjin.put("title", qnalist.get(i).getTitle());
		jobjin.put("notidate", qnalist.get(i).getIndate().toString());
		jarray.add(0, jobjin);
		jobj.put("noti", jarray);
	}
	out.print(jobj);
	out.flush();
} catch (Exception e) {
}

%>