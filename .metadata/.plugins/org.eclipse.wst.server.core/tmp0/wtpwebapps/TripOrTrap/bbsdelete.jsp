<%@page import="QnABBS.*"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
String qnanumber;




try {
	qnanumber=request.getParameter("qnanumber");
	
	System.out.println("delete check : "+qnanumber);
	QnaDAO qao=QnaDAO.getInstance();
	
    String returnstr=qao.deleteQna(Integer.parseInt(qnanumber));	
	
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