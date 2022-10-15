<%@page import="QnABBS.*"%>
<%@page import="org.json.simple.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
request.setCharacterEncoding("utf-8");
int qnanumber=Integer.parseInt(request.getParameter("qnanumber"));
int trapperaccount=Integer.parseInt(request.getParameter("trapperaccount"));
String bbstitle=request.getParameter("bbstitle");
String bbscontent=request.getParameter("bbscontent");
System.out.println("start"+qnanumber);
String returnstr;

QnaVO qnaVO=new QnaVO();
qnaVO.setQnanum(qnanumber);
qnaVO.setTrapperaccount(trapperaccount);
qnaVO.setTitle(bbstitle);
qnaVO.setContent(bbscontent);

QnaDAO qao=QnaDAO.getInstance();
returnstr=qao.fixQna(qnaVO);

System.out.println("compl"+returnstr);

	
	JSONObject jobj=new JSONObject();
	JSONArray jarray=new JSONArray();	
	
	
		JSONObject jobjin=new JSONObject();
		jobjin.put("returnstr", returnstr);		
		jarray.add(0, jobjin);
		jobj.put("qna", jarray);
	
	out.print(jobj);
	out.flush();


%>