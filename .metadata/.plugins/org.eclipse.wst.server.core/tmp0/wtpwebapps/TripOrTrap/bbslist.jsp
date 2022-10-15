<%@page import="QnABBS.*"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
QnaDAO qao=QnaDAO.getInstance();
try {
	List<QnaVO> qnalist=qao.listAllQna();
	
	JSONObject jobj=new JSONObject();
	JSONArray jarray=new JSONArray();	
	
	for(int i=0;i<qnalist.size();i++){
		JSONObject jobjin=new JSONObject();
		jobjin.put("qnanum", qnalist.get(i).getQnanum());		
		jobjin.put("trappernickname", qnalist.get(i).getTrappernickname());
		jobjin.put("title", qnalist.get(i).getTitle());		
		jarray.add(0, jobjin);
		jobj.put("qna", jarray);
	}
	out.print(jobj);
	out.flush();
} catch (Exception e) {
}

%>